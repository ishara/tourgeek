/**
  * @(#)HotelRateAvailRequest.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.message.hotel.request;

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
import com.tourgeek.tour.message.base.request.data.*;
import com.tourgeek.tour.message.base.request.*;
import org.jbundle.model.message.*;
import com.tourgeek.model.tour.booking.detail.db.*;

/**
 *  HotelRateAvailRequest - Combined rate and availability request.
 */
public class HotelRateAvailRequest extends HotelRateRequest
{
    /**
     * Default constructor.
     */
    public HotelRateAvailRequest()
    {
        super();
    }
    /**
     * HotelRateAvailRequest Method.
     */
    public HotelRateAvailRequest(MessageDataParent messageDataParent, String strKey)
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
        ((ProductMessageData)this.getMessageDataDesc(ProductRequest.PRODUCT_MESSAGE)).setSyncFields(BookingDetailModel.INVENTORY_STATUS_ID, BookingDetailModel.COST_STATUS_ID);
    }

}
