/**
  * @(#)GetProductCostHandler.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.product.base.event;

import java.util.*;

import org.jbundle.base.db.*;
import org.jbundle.thin.base.util.*;
import org.jbundle.thin.base.db.*;
import org.jbundle.base.db.event.*;
import org.jbundle.base.db.filter.*;
import org.jbundle.base.field.*;
import org.jbundle.base.field.convert.*;
import org.jbundle.base.field.event.*;
import org.jbundle.base.model.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import org.jbundle.main.msg.db.*;
import org.jbundle.thin.base.message.*;
import com.tourgeek.tour.acctpay.db.*;
import org.jbundle.base.message.core.trx.*;
import com.tourgeek.tour.product.base.db.*;
import com.tourgeek.tour.message.base.request.*;
import com.tourgeek.tour.message.base.response.*;
import com.tourgeek.tour.product.tour.db.*;
import org.jbundle.main.db.base.*;
import com.tourgeek.model.tour.booking.db.*;

/**
 *  GetProductCostHandler - Get the product cost on a valid product record.
(Using the params from the ProductVars screenrecord)..
 */
public class GetProductCostHandler extends GetProductStatusHandler
{
    /**
     * Default constructor.
     */
    public GetProductCostHandler()
    {
        super();
    }
    /**
     * GetProductCostHandler Method.
     */
    public GetProductCostHandler(Record recProductVars, Integer intRegistryID)
    {
        this();
        this.init(recProductVars, intRegistryID);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record recProductVars, Integer intRegistryID)
    {
        super.init(recProductVars, intRegistryID);
    }
    /**
     * Get the cost or inventory information from the product now.
     * @return The message status.
     */
    public int getDirectProductInfo(Product recProduct, BaseMessage message)
    {
        BaseProductResponse response = (BaseProductResponse)((BaseMessage)recProduct.processCostRequestInMessage(message, null)).getMessageDataDesc(null);
        
        int iPricingType = PricingType.COMPONENT_PRICING | PricingType.COMPONENT_COST_PRICING;
        double dMarkup = 0.00;
        RecordOwner recordOwner = recProduct.getRecordOwner();
        if (recordOwner != null)
        {
            Record recBooking = (Record)recordOwner.getRecord(BookingModel.BOOKING_FILE);
            if ((recBooking != null)
                && ((recBooking.getEditMode() == DBConstants.EDIT_CURRENT) || (recBooking.getEditMode() == DBConstants.EDIT_IN_PROGRESS)))
            {
                PricingType recPricingType = (PricingType)((ReferenceField)recBooking.getField(BookingModel.NON_TOUR_PRICING_TYPE_ID)).getReference();
                iPricingType = (int)recPricingType.getField(PricingType.PRICING_CODES).getValue();
                dMarkup = recBooking.getField(BookingModel.MARKUP).getValue();
            }
            else
            {
                Record recBookingControl = (Record)recordOwner.getRecord(BookingControl.BOOKING_CONTROL_FILE);
                if (recBookingControl == null)
                    recBookingControl = new BookingControl(recordOwner);
                PricingType recPricingType = (PricingType)((ReferenceField)recBookingControl.getField(BookingControl.NON_TOUR_PRICING_TYPE_ID)).getReference();
                iPricingType = (int)recPricingType.getField(PricingType.PRICING_CODES).getValue();
                dMarkup = recBookingControl.getField(BookingControl.MARKUP).getValue();
            }
        
            boolean bMarkupOnlyIfNoPrice = false;
            if (((iPricingType & PricingType.COMPONENT_PRICING) != 0) && ((iPricingType & PricingType.COMPONENT_COST_PRICING) != 0))
                bMarkupOnlyIfNoPrice = true;
        
            if ((iPricingType & PricingType.OPTION_PRICING) != 0)
                recProduct.markupPriceFromCost(0, false);    // Never
            
            if ((iPricingType & PricingType.COMPONENT_COST_PRICING) != 0)
                recProduct.markupPriceFromCost(dMarkup, bMarkupOnlyIfNoPrice);
        
            recProduct.markupPriceFromCost(0, true);   // Null looks better than 0
        }
        
        if (response != null)
            return response.getMessageDataStatus();
        return BaseStatus.NOT_VALID;
    }
    /**
     * If all the data in the screen record that is required for a query is there,
     * return true. If not, false.
     */
    public boolean isQueryComplete()
    {
        if (!m_recProductVars.getField(ProductScreenRecord.DETAIL_DATE).isNull())
            return true;
        return false;
    }
    /**
     * Get the lookup properties from the ProductScreenRecord and the
     * Product record and set them in this map.
     * (Override this to set the loopup properties).
     */
    public void setLookupProperties(BaseMessage map, Record recProduct, Record screenRecord)
    {
        ((ProductScreenRecord)screenRecord).setPriceProperties(map, (Product)recProduct);
    }
    /**
     * Move this product cost from to virtual fields to the ProductCost
     * field in recProduct. Also move the status to the product cost status.
     * (Override this to set the correct fields!).
     */
    public void setupScreenStatus(Record recProduct, int iStatus)
    {
        if (iStatus == CostStatus.VALID)
        {
        //    double dProductCost = recProduct.getField(Product.PRODUCT_COST).getValue();
        //    recProduct.getField(Product.PRODUCT_COST).setValue(dProductCost);
        }
        else
            recProduct.getField(Product.PRODUCT_COST).setData(null);
        recProduct.getField(Product.DISPLAY_COST_STATUS_ID).setValue(iStatus);
    }

}
