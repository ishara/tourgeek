/**
  * @(#)BookingLineScreen.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.booking.entry.acctrec;

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
import com.tourgeek.tour.booking.detail.event.*;
import com.tourgeek.tour.product.base.db.*;
import com.tourgeek.tour.acctrec.db.*;

/**
 *  BookingLineScreen - Booking Line Items.
 */
public class BookingLineScreen extends BookingSubScreen
{
    /**
     * Default constructor.
     */
    public BookingLineScreen()
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
    public BookingLineScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        this();
        this.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Open the files and setup the screen.
     * @param record The main record for this screen.
     * @param itsLocation The location of this component within the parent.
     * @param parentScreen The parent screen.
     * @param fieldConverter The field this screen field is linked to.
     * @param iDisplayFieldDesc Do I display the field desc?
     * @param properties Additional properties to pass to the screen.
     */
    public void init(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        parentScreen.setProperty(BookingScreenHandler.SUB_SCREEN_PARAM, Integer.toString(BookingScreenHandler.LINE_SCREEN));
        super.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Get the screen display title.
     */
    public String getTitle()
    {
        return "Booking Line Items";
    }
    /**
     * Override this to open the main file.
     * <p />You should pass this record owner to the new main file (ie., new MyNewTable(thisRecordOwner)).
     * @return The new record.
     */
    public Record openMainRecord()
    {
        if (this.getRecord(BookingLine.BOOKING_LINE_FILE) != null)
            return this.getRecord(BookingLine.BOOKING_LINE_FILE);
        return new BookingLine(this);
    }
    /**
     * Add all the screen listeners.
     */
    public void addListeners()
    {
        super.addListeners();
        BookingLine recBookingLine = (BookingLine)this.getRecord(BookingLine.BOOKING_LINE_FILE);
        Booking recBooking = (Booking)this.getRecord(Booking.BOOKING_FILE);
        recBooking.addArDetail(null, recBookingLine, false);
        
        recBookingLine.getField(BookingLine.PRICE).addListener(new CopyDataHandler(recBookingLine.getField(BookingLine.PRICING_STATUS_ID), new Integer(PricingStatus.MANUAL), null));
        recBookingLine.addListener(new BookingLineStatusHandler(null));
    }
    /**
     * Add the toolbars that belong with this screen.
     * @return The new toolbar.
     */
    public ToolScreen addToolbars()
    {
        ToolScreen toolbar = super.addToolbars();
        
        ToolScreen toolbar2 = new EmptyToolbar(this.getNextLocation(ScreenConstants.LAST_LOCATION, ScreenConstants.DONT_SET_ANCHOR), this, null, ScreenConstants.DONT_DISPLAY_FIELD_DESC, null);
        BaseField converter = null;
        converter = this.getRecord(Booking.BOOKING_FILE).getField(Booking.GROSS);
        ScreenComponent sField = converter.setupDefaultView(toolbar2.getNextLocation(ScreenConstants.NEXT_INPUT_LOCATION, ScreenConstants.ANCHOR_DEFAULT), toolbar2, ScreenConstants.DEFAULT_DISPLAY);
        sField.setEnabled(false);
        converter = this.getRecord(Booking.BOOKING_FILE).getField(Booking.NET);
        sField = converter.setupDefaultView(toolbar2.getNextLocation(ScreenConstants.RIGHT_WITH_DESC, ScreenConstants.ANCHOR_DEFAULT), toolbar2, ScreenConstants.DEFAULT_DISPLAY);
        sField.setEnabled(false);
        converter = this.getRecord(Booking.BOOKING_FILE).getField(Booking.PRICING_STATUS_ID);
        sField = converter.setupDefaultView(toolbar2.getNextLocation(ScreenConstants.RIGHT_WITH_DESC, ScreenConstants.ANCHOR_DEFAULT), toolbar2, ScreenConstants.DEFAULT_DISPLAY);
        sField.setEnabled(false);
        
        return toolbar;
    }
    /**
     * Set up all the screen fields.
     */
    public void setupSFields()
    {
        this.getRecord(BookingLine.BOOKING_LINE_FILE).getField(BookingLine.DESCRIPTION).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(BookingLine.BOOKING_LINE_FILE).getField(BookingLine.PRICE).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(BookingLine.BOOKING_LINE_FILE).getField(BookingLine.QUANTITY).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(BookingLine.BOOKING_LINE_FILE).getField(BookingLine.GROSS).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(BookingLine.BOOKING_LINE_FILE).getField(BookingLine.COMMISSION).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(BookingLine.BOOKING_LINE_FILE).getField(BookingLine.NET).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(BookingLine.BOOKING_LINE_FILE).getField(BookingLine.PRICING_STATUS_ID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
    }

}
