/**
 * @(#)CruiseBookingResponse.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.message.cruise.response;

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
import com.tourapp.tour.message.base.request.*;
import com.tourapp.tour.booking.detail.db.*;
import com.tourapp.tour.product.base.db.*;
import org.jbundle.thin.base.message.*;
import com.tourapp.tour.message.base.request.data.*;
import com.tourapp.tour.message.cruise.request.data.*;
import com.tourapp.tour.message.base.response.*;
import com.tourapp.tour.message.cruise.request.*;
import org.jbundle.main.msg.db.*;

/**
 *  CruiseBookingResponse - .
 */
public class CruiseBookingResponse extends ProductBookingResponse
{
    /**
     * Default constructor.
     */
    public CruiseBookingResponse()
    {
        super();
    }
    /**
     * CruiseBookingResponse Method.
     */
    public CruiseBookingResponse(MessageDataParent messageDataParent, String strKey)
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
