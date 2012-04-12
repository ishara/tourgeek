/**
 * @(#)AirBookingResponse.
 * Copyright © 2012 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.message.air.response;

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
import org.jbundle.base.model.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import com.tourapp.tour.message.base.request.*;
import com.tourapp.tour.booking.detail.db.*;
import com.tourapp.tour.product.base.db.*;
import com.tourapp.tour.message.air.request.*;
import com.tourapp.tour.message.base.request.data.*;
import com.tourapp.tour.message.air.request.data.*;
import com.tourapp.tour.message.base.response.*;
import org.jbundle.model.message.*;
import org.jbundle.main.msg.db.*;
import org.jbundle.thin.base.message.*;
import com.tourapp.model.tour.booking.detail.db.*;

/**
 *  AirBookingResponse - .
 */
public class AirBookingResponse extends ProductBookingResponse
{
    /**
     * Default constructor.
     */
    public AirBookingResponse()
    {
        super();
    }
    /**
     * AirBookingResponse Method.
     */
    public AirBookingResponse(MessageDataParent messageDataParent, String strKey)
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

}
