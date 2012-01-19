/**
 * @(#)TourEntryField.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.booking.db;

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
import com.tourapp.tour.product.tour.db.*;
import java.util.*;
import com.tourapp.tour.acctpay.db.*;
import com.tourapp.tour.booking.detail.db.*;
import com.tourapp.tour.product.hotel.db.*;
import com.tourapp.tour.product.land.db.*;
import com.tourapp.tour.booking.lookup.*;
import com.tourapp.tour.booking.detail.event.*;
import com.tourapp.tour.product.tour.other.screen.*;
import com.tourapp.tour.product.tour.schedule.db.*;
import com.tourapp.tour.booking.db.event.*;
import com.tourapp.tour.acctpay.screen.findepest.*;
import org.jbundle.main.db.base.*;

/**
 *  TourEntryField - .
 */
public class TourEntryField extends TourField
{
    /**
     * Default constructor.
     */
    public TourEntryField()
    {
        super();
    }
    /**
     * Constructor.
     * @param record The parent record.
     * @param strName The field name.
     * @param iDataLength The maximum string length (pass -1 for default).
     * @param strDesc The string description (usually pass null, to use the resource file desc).
     * @param strDefault The default value (if object, this value is the default value, if string, the string is the default).
     */
    public TourEntryField(Record record, String strName, int iDataLength, String strDesc, Object strDefault)
    {
        this();
        this.init(record, strName, iDataLength, strDesc, strDefault);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record record, String strName, int iDataLength, String strDesc, Object strDefault)
    {
        super.init(record, strName, iDataLength, strDesc, strDefault);
    }
    /**
     * Set up the default screen control for this field.
     * @param itsLocation Location of this component on screen (ie., GridBagConstraint).
     * @param targetScreen Where to place this component (ie., Parent screen or GridBagLayout).
     * @param converter The converter to set the screenfield to.
     * @param iDisplayFieldDesc Display the label? (optional).
     * @param properties Extra properties
     * @return Return the component or ScreenField that is created for this field.
     */
    public ScreenComponent setupDefaultView(ScreenLoc itsLocation, ComponentParent targetScreen, Convert converter, int iDisplayFieldDesc, Map<String, Object> properties)
    {
        Record recTour = this.getReferenceRecord();
        BaseField fldDepartureDate = recTour.getField(Tour.kDepartureDate);
        //+BaseField fldTourCode = recTour.getField(Tour.kTourCode);
        BaseField fldTourDesc = recTour.getField(Tour.kDescription);
        //?fldAcctNo.addListener(new MainReadOnlyHandler(Account.kAccountNoKey));
        Converter conv = new FieldDescConverter(fldDepartureDate, this);    // Use the description for this field
        conv.setupDefaultView(itsLocation, targetScreen, conv, iDisplayFieldDesc, properties);
        //fldTourCode.setupDefaultView(targetScreen.getNextLocation(ScreenConstants.RIGHT_OF_LAST, ScreenConstants.DONT_SET_ANCHOR), targetScreen, null, ScreenConstants.DONT_DISPLAY_FIELD_DESC);
        
        conv = new FieldLengthConverter(fldTourDesc, 30);
        //return this.setupTableLookup(targetScreen.getNextLocation(ScreenConstants.RIGHT_OF_LAST, ScreenConstants.DONT_SET_ANCHOR), targetScreen, converter, ScreenConstants.DONT_DISPLAY_FIELD_DESC, recTour, -1, Tour.kDescription, false, false);
        this.addListener(new ReadSecondaryHandler(recTour, DBConstants.MAIN_FIELD, DBConstants.CLOSE_ON_FREE, false, false));
        ScreenField sfDesc = new SEditText(targetScreen.getNextLocation(ScreenConstants.RIGHT_OF_LAST, ScreenConstants.DONT_SET_ANCHOR), targetScreen, conv, ScreenConstants.DONT_DISPLAY_DESC);
        sfDesc.setEnabled(false);
        return sfDesc;
    }

}
