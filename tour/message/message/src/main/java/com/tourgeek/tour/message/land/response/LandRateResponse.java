/**
  * @(#)LandRateResponse.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.message.land.response;

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
import com.tourgeek.tour.message.base.response.*;
import org.jbundle.thin.base.message.*;
import com.tourgeek.tour.message.land.request.*;
import com.tourgeek.tour.message.land.response.data.*;
import com.tourgeek.tour.message.base.response.data.*;
import org.jbundle.model.message.*;
import com.tourgeek.model.tour.booking.detail.db.*;
import com.tourgeek.model.tour.product.land.db.*;
import com.tourgeek.model.tour.product.base.db.*;

/**
 *  LandRateResponse - .
 */
public class LandRateResponse extends ProductRateResponse
{
    /**
     * Default constructor.
     */
    public LandRateResponse()
    {
        super();
    }
    /**
     * LandRateResponse Method.
     */
    public LandRateResponse(MessageDataParent messageDataParent, String strKey)
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
     * CreateProductResponseMessageData Method.
     */
    public ProductResponseMessageData createProductResponseMessageData()
    {
        return new LandRateResponseMessageData(this, BaseProductResponse.PRODUCT_RESPONSE_MESSAGE);
    }

}
