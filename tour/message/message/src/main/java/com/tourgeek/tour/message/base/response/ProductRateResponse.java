/**
  * @(#)ProductRateResponse.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.message.base.response;

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
import org.jbundle.thin.base.message.*;
import com.tourgeek.tour.acctpay.db.*;
import com.tourgeek.tour.base.db.*;
import com.tourgeek.tour.message.base.response.data.*;
import org.jbundle.model.message.*;
import com.tourgeek.model.tour.product.base.db.*;
import com.tourgeek.model.tour.booking.detail.db.*;

/**
 *  ProductRateResponse - .
 */
public class ProductRateResponse extends BaseProductResponse
{
    /**
     * Default constructor.
     */
    public ProductRateResponse()
    {
        super();
    }
    /**
     * ProductRateResponse Method.
     */
    public ProductRateResponse(MessageDataParent messageDataParent, String strKey)
    {
        this();
        this.init(messageDataParent, strKey);
    }
    /**
     * Initialize class fields.
     */
    public void init(MessageDataParent messageDataParent, String strKey)
    {
        super.init(messageDataParent, strKey);
    }
    /**
     * Get the key prefix for this type of message.
     */
    public String getKeyPrefix()
    {
        return "message.cost.";
    }
    /**
     * CreateProductResponseMessageData Method.
     */
    public ProductResponseMessageData createProductResponseMessageData()
    {
        return new ProductRateResponseMessageData(this, null);
    }

}
