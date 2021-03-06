/**
  * @(#)BookingAirHeaderGridScreen.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.booking.entry.detail.air;

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
import com.tourgeek.tour.booking.entry.base.*;
import com.tourgeek.tour.booking.detail.db.*;
import com.tourgeek.tour.booking.db.*;
import com.tourgeek.tour.product.base.db.*;
import com.tourgeek.tour.booking.db.event.*;

/**
 *  BookingAirHeaderGridScreen - Booking Ticket Header Detail.
 */
public class BookingAirHeaderGridScreen extends BookingSubGridScreen
{
    /**
     * Default constructor.
     */
    public BookingAirHeaderGridScreen()
    {
        super();
    }
    /**
     * Constructor.
     * @param record The main record for this screen.
     * @param itsLocation The location of this component within the parent.
     * @param parentScreen The parent screen.
     * @param fieldConverter The field this screen field is linked to.
     * @param iDisplayFieldDesc Do I display the field desc?.
     */
    public BookingAirHeaderGridScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        this();
        this.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Constructor.
     * @param record The main record for this screen.
     * @param itsLocation The location of this component within the parent.
     * @param parentScreen The parent screen.
     * @param fieldConverter The field this screen field is linked to.
     * @param iDisplayFieldDesc Do I display the field desc?.
     */
    public void init(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        parentScreen.setProperty(BookingScreenHandler.SUB_SCREEN_PARAM, Integer.toString(BookingScreenHandler.AIR_HEADER_SCREEN));
        super.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Get the screen display title.
     */
    public String getTitle()
    {
        return "Booking Ticket Header Detail";
    }
    /**
     * Override this to open the main file.
     * <p />You should pass this record owner to the new main file (ie., new MyNewTable(thisRecordOwner)).
     * @return The new record.
     */
    public Record openMainRecord()
    {
        return new BookingAirHeader(this);
    }
    /**
     * Add all the screen listeners.
     */
    public void addListeners()
    {
        super.addListeners();
        BookingAirHeader recBookingAirHeader = (BookingAirHeader)this.getMainRecord();
        Booking recBooking = (Booking)this.getRecord(Booking.BOOKING_FILE);
        Tour recTour = (Tour)this.getRecord(Tour.TOUR_FILE);
        recBookingAirHeader.addDetailBehaviors(recBooking, recTour);
    }
    /**
     * Add button(s) to the toolbar.
     */
    public void addToolbarButtons(ToolScreen toolScreen)
    {
        super.addToolbarButtons(toolScreen);
        ResourceBundle resources = ((BaseApplication)this.getTask().getApplication()).getResources(ResourceConstants.BOOKING_RESOURCE, true);
        BaseField field = ((Record)this.getRecord(Booking.BOOKING_FILE).getRecordOwner().getScreenRecord()).getField(BookingScreenRecord.BK_SUB_SCREEN);
        new SCannedBox(toolScreen.getNextLocation(ScreenConstants.RIGHT_OF_LAST, ScreenConstants.DONT_SET_ANCHOR), toolScreen, field, ScreenConstants.DEFAULT_DISPLAY, null, resources.getString(ProductType.AIR), Booking.BUTTON_LOCATION + ProductType.AIR, Integer.toString(BookingScreenHandler.AIR_SCREEN), resources.getString(ProductType.AIR + "Tip"));
    }
    /**
     * SetupSFields Method.
     */
    public void setupSFields()
    {
        this.getRecord(BookingAirHeader.BOOKING_AIR_HEADER_FILE).getField(BookingAirHeader.AIRLINE_DESC).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
    }

}
