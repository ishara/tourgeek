/**
 * @(#)CarInformationRequest.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.message.car.request;

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
import com.tourapp.tour.message.base.request.*;
import org.jbundle.thin.base.message.*;
import com.tourapp.tour.message.base.request.data.*;
import com.tourapp.tour.message.car.request.data.*;
import com.tourapp.tour.booking.detail.db.*;

/**
 *  CarInformationRequest - .
 */
public class CarInformationRequest extends ProductInformationRequest
{
    /**
     * Default constructor.
     */
    public CarInformationRequest()
    {
        super();
    }
    /**
     * CarInformationRequest Method.
     */
    public CarInformationRequest(MessageDataParent messageDataParent, String strKey)
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
     * CreateProductMessageData Method.
     */
    public ProductMessageData createProductMessageData()
    {
        return new CarMessageData(this, PRODUCT_MESSAGE);
    }
    /**
     * Setup sub-Message Data.
     */
    public void setupMessageDataDesc()
    {
        super.setupMessageDataDesc();
        ProductMessageData productMessageData = (ProductMessageData)this.getMessageDataDesc(PRODUCT_MESSAGE);
        // productMessageData.removeMessageDataDesc(BookingCar.DAYS);    // Yes - Days is required for the END DATE Not required for information
        productMessageData.removeMessageDataDesc(BookingCar.QUANTITY);
    }

}
