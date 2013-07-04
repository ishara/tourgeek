
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
import com.tourgeek.tour.product.base.db.*;
import org.jbundle.main.msg.db.*;
import org.jbundle.thin.base.message.*;
import com.tourgeek.tour.message.base.response.*;
import com.tourgeek.tour.message.base.request.*;
import org.jbundle.main.db.base.*;

/**
 *  GetProductAvailabilityHandler - Get the product cost on a valid product record.
(Using the params from the ProductVars screenrecord)..
 */
public class GetProductAvailabilityHandler extends GetProductStatusHandler
{
    /**
     * Default constructor.
     */
    public GetProductAvailabilityHandler()
    {
        super();
    }
    /**
     * GetProductAvailabilityHandler Method.
     */
    public GetProductAvailabilityHandler(Record recProductVars, Integer intRegistryID)
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
     * GetRequestType Method.
     */
    public String getRequestType()
    {
        return RequestType.AVAILABILITY;
    }
    /**
     * Get the cost or inventory information from the product now.
     * @return The message status.
     */
    public int getDirectProductInfo(Product recProduct, BaseMessage message)
    {
        BaseProductResponse response = (BaseProductResponse)((BaseMessage)recProduct.processAvailabilityRequestInMessage(message, null, null)).getMessageDataDesc(null);
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
        recProduct.getField(Product.DISPLAY_INVENTORY_STATUS_ID).setValue(iStatus);
    }

}
