/**
  * @(#)BookingHotelBookingMsgReplyInProcessor.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.message.hotel.response.in;

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
import com.tourgeek.tour.message.base.response.in.*;
import org.jbundle.thin.base.message.*;
import com.tourgeek.tour.booking.detail.db.*;

/**
 *  BookingHotelBookingMsgReplyInProcessor - .
 */
public class BookingHotelBookingMsgReplyInProcessor extends BookingDetailBookingMsgReplyInProcessor
{
    /**
     * Default constructor.
     */
    public BookingHotelBookingMsgReplyInProcessor()
    {
        super();
    }
    /**
     * Constructor.
     */
    public BookingHotelBookingMsgReplyInProcessor(RecordOwnerParent taskParent, Record recordMain, Map<String,Object> properties)
    {
        this();
        this.init(taskParent, recordMain, properties);
    }
    /**
     * Initialize class fields.
     */
    public void init(RecordOwnerParent taskParent, Record recordMain, Map<String, Object> properties)
    {
        super.init(taskParent, recordMain, properties);
    }
    /**
     * Open the main file.
     */
    public Record openMainRecord()
    {
        return new BookingHotel(this);
    }
    /**
     * Process this internal message.
     * @param internalMessage The message to process.
     * @return (optional) The return message if applicable.
     */
    public BaseMessage processMessage(BaseMessage internalMessage)
    {
        return super.processMessage(internalMessage);
    }

}
