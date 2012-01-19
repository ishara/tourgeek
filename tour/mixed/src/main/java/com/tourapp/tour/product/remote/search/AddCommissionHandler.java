/**
 * @(#)AddCommissionHandler.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.product.remote.search;

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
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import com.tourapp.tour.booking.db.*;
import com.tourapp.tour.product.base.db.*;

/**
 *  AddCommissionHandler - Add agency commission to the price.
 */
public class AddCommissionHandler extends FieldListener
{
    /**
     * Default constructor.
     */
    public AddCommissionHandler()
    {
        super();
    }
    /**
     * AddCommissionHandler Method.
     */
    public AddCommissionHandler(BaseField field)
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
     * DoSetData Method.
     */
    public int doSetData(Object objData, boolean bDisplayOption, int iMoveMode)
    {
        if (objData instanceof Double)
        {   // Always
            Record recProduct = this.getOwner().getRecord();
            RecordOwner recordOwner = recProduct.getRecordOwner();
            if (recordOwner != null)
            {
                double dCommission = 0.00;
                Record recBooking = recordOwner.getRecord(Booking.kBookingFile);
                if ((recBooking != null)
                    && ((recBooking.getEditMode() == DBConstants.EDIT_CURRENT) || (recBooking.getEditMode() == DBConstants.EDIT_IN_PROGRESS)))
                {
                    dCommission = recBooking.getField(Booking.kStdCommission).getValue();
                }
                else
                {
                    Record recBookingControl = recordOwner.getRecord(BookingControl.kBookingControlFile);
                    if (recBookingControl == null)
                        recBookingControl = new BookingControl(recordOwner);
                    dCommission = recBookingControl.getField(BookingControl.kAgencyComm).getValue();
                }
                if (dCommission != 0.00)
                {
                    double dNet = ((Double)objData).doubleValue();
                    double dGross = Math.floor(dNet / (1 - dCommission) * 100 + 0.5) / 100;
                    objData = new Double(dGross);
                }
            }                
        }
        return super.doSetData(objData, bDisplayOption, iMoveMode);
    }

}
