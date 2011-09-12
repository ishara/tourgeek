/**
 * @(#)ChangePricingTypeHandler.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.booking.db.event;

import java.awt.*;
import java.util.*;

import org.jbundle.base.db.*;
import org.jbundle.thin.base.util.*;
import org.jbundle.thin.base.db.*;
import org.jbundle.base.db.event.*;
import org.jbundle.base.db.filter.*;
import org.jbundle.base.field.*;
import org.jbundle.base.field.convert.*;
import org.jbundle.base.field.event.*;
import org.jbundle.base.screen.model.*;
import org.jbundle.base.screen.model.util.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import com.tourapp.tour.booking.db.*;
import com.tourapp.tour.product.tour.db.*;
import com.tourapp.tour.booking.detail.db.*;
import com.tourapp.tour.product.tour.detail.db.*;
import com.tourapp.tour.product.base.db.*;

/**
 *  ChangePricingTypeHandler - .
 */
public class ChangePricingTypeHandler extends FieldListener
{
    /**
     * Default constructor.
     */
    public ChangePricingTypeHandler()
    {
        super();
    }
    /**
     * ChangePricingTypeHandler Method.
     */
    public ChangePricingTypeHandler(BaseField field)
    {
        this();
        this.init(field);
    }
    /**
     * Init Method.
     */
    public void init(BaseField field)
    {
        super.init(field);
        this.setRespondsToMode(DBConstants.INIT_MOVE, false);
        this.setRespondsToMode(DBConstants.READ_MOVE, false);
    }
    /**
     * FieldChanged Method.
     */
    public int fieldChanged(boolean bDisplayOption, int iMoveMode)
    {
        Booking recBooking = null;
        BaseField fldTourModuleID = null;
        Date dateStart = null;
        if (this.getOwner().getRecord() instanceof Booking)
        {
            recBooking = (Booking)this.getOwner().getRecord();
            Record recPricingType = ((ReferenceField)this.getOwner()).getReference();
            if ((recPricingType == null)
                || (recPricingType.getEditMode() == DBConstants.EDIT_NONE) || (recPricingType.getEditMode() == DBConstants.EDIT_ADD))
            {   // Can't have a null booking pricing type
                PricingType recPricingType2 = new PricingType(Utility.getRecordOwner(recBooking));
                PricingType recPricingType3 = recPricingType2.getPricingType(PricingType.COMPONENT_COST_PRICING);
                if (recPricingType3 != null)
                    this.getOwner().moveFieldToThis(recPricingType3.getField(PricingType.kID));
                recPricingType2.free();                
            }
        }
        else if (this.getOwner().getRecord() instanceof BookingDetail)
        {
            try {
                this.getOwner().getRecord().writeAndRefresh();  // Since I will be reading through the detail
            } catch (DBException e) {
                e.printStackTrace();
            }
            recBooking = ((BookingDetail)this.getOwner().getRecord()).getBooking(true);
            fldTourModuleID = this.getOwner().getRecord().getField(BookingDetail.kProductID);
            dateStart = ((DateTimeField)this.getOwner().getRecord().getField(BookingDetail.kDetailDate)).getDateTime();
            recBooking.getTourPricingType(null, fldTourModuleID, dateStart);    // This will clear the cache
        }
        if (!recBooking.getField(Booking.kTourID).isNull())
        {   // Always
            Tour recTour = (Tour)((ReferenceField)recBooking.getField(Booking.kTourID)).getReference();
            BookingLine recBookingLine = new BookingLine(Utility.getRecordOwner(recBooking));            
            recBookingLine.addDetailBehaviors(recBooking, recTour);
            
            // First step, delete the old pricing detail
            recBookingLine.deleteAllDetail(recBooking, null, fldTourModuleID, dateStart);
            // Next step, add the new pricing detail
            int iErrorCode = recBooking.addBookingDetailPricing(recTour, recBookingLine, fldTourModuleID, dateStart, false);
        
            if (recBookingLine != null)
                recBookingLine.free();
        
            if (iErrorCode != DBConstants.NORMAL_RETURN)
                return iErrorCode;
        }
        return super.fieldChanged(bDisplayOption, iMoveMode);
    }

}
