/**
 * @(#)HotelBookingResponseScreen.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.message.hotel.screen;

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
import com.tourapp.tour.booking.message.base.screen.*;
import org.jbundle.thin.base.message.*;
import com.tourapp.tour.message.hotel.request.*;
import com.tourapp.tour.product.base.db.*;

/**
 *  HotelBookingResponseScreen - .
 */
public class HotelBookingResponseScreen extends BaseProductResponseScreen
{
    /**
     * Default constructor.
     */
    public HotelBookingResponseScreen()
    {
        super();
    }
    /**
     * Constructor.
     * @param record The main record for this screen.
     * @param itsLocation The location of this component within the parent.
     * @param parentScreen The parent screen.
     * @param fieldConverter The field this screen field is linked to.
     * @param iDisplayFieldDesc Do I display the field desc?
     * @param properties Addition properties to pass to the screen.
     */
    public HotelBookingResponseScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        this();
        this.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        super.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Add all the screen listeners.
     */
    public void addListeners()
    {
        super.addListeners();
    }
    /**
     * Add the screen fields.
     * Override this to create (and return) the screen record for this recordowner.
     * @return The screen record.
     */
    public Record addScreenRecord()
    {
        return new HotelInfoScreenRecord(this);
    }
    /**
     * Move the original(sent) message params to this screen.
     */
    public void moveMessageParamsToScreen(BaseMessage message)
    {
        super.moveMessageParamsToScreen(message);
    }
    /**
     * Move to entered fields to the return message.
     */
    public void moveScreenParamsToMessage(BaseMessage message)
    {
        super.moveScreenParamsToMessage(message);
    }
    /**
     * Set up all the screen fields.
     */
    public void setupSFields()
    {
        this.getRecord(HotelInfoScreenRecord.kHotelInfoScreenRecordFile).getField(HotelInfoScreenRecord.kProductID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.kHotelInfoScreenRecordFile).getField(HotelInfoScreenRecord.kRateID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.kHotelInfoScreenRecordFile).getField(HotelInfoScreenRecord.kClassID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.kHotelInfoScreenRecordFile).getField(HotelInfoScreenRecord.kDetailDate).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.kHotelInfoScreenRecordFile).getField(HotelInfoScreenRecord.kConfirmationNo).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.kHotelInfoScreenRecordFile).getField(HotelInfoScreenRecord.kConfirmedBy).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
    }

}
