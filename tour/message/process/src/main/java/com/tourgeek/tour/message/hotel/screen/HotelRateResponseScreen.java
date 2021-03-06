/**
  * @(#)HotelRateResponseScreen.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.message.hotel.screen;

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
import org.jbundle.base.model.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import com.tourgeek.tour.booking.message.base.screen.*;
import com.tourgeek.tour.product.hotel.db.*;
import com.tourgeek.tour.message.hotel.request.in.*;
import com.tourgeek.tour.product.base.db.*;
import com.tourgeek.tour.message.hotel.request.*;
import org.jbundle.thin.base.message.*;

/**
 *  HotelRateResponseScreen - Enter the hotel availabilty price.
 */
public class HotelRateResponseScreen extends BaseProductResponseScreen
{
    /**
     * Default constructor.
     */
    public HotelRateResponseScreen()
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
    public HotelRateResponseScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
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
     * Get the screen display title.
     */
    public String getTitle()
    {
        return "Enter the hotel availabilty price";
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
     * Add all the screen listeners.
     */
    public void addListeners()
    {
        super.addListeners();
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
        this.getRecord(HotelInfoScreenRecord.HOTEL_INFO_SCREEN_RECORD_FILE).getField(HotelInfoScreenRecord.PRODUCT_ID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.HOTEL_INFO_SCREEN_RECORD_FILE).getField(HotelInfoScreenRecord.RATE_ID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.HOTEL_INFO_SCREEN_RECORD_FILE).getField(HotelInfoScreenRecord.CLASS_ID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.HOTEL_INFO_SCREEN_RECORD_FILE).getField(HotelInfoScreenRecord.DETAIL_DATE).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(HotelInfoScreenRecord.HOTEL_INFO_SCREEN_RECORD_FILE).getField(HotelInfoScreenRecord.TOTAL_COST).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
    }

}
