/**
  * @(#)GenPaymentToolbar.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.acctpay.screen.genpymt;

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
import org.jbundle.base.screen.model.report.*;
import com.tourgeek.tour.acctpay.db.*;
import com.tourgeek.tour.genled.db.*;
import com.tourgeek.tour.assetdr.db.*;

/**
 *  GenPaymentToolbar - .
 */
public class GenPaymentToolbar extends ReportToolbar
{
    /**
     * Default constructor.
     */
    public GenPaymentToolbar()
    {
        super();
    }
    /**
     * Constructor.
     * @param itsLocation The location of this component within the parent.
     * @param parentScreen The parent screen.
     * @param fieldConverter The field this screen field is linked to.
     * @param iDisplayFieldDesc Do I display the field desc?.
     */
    public GenPaymentToolbar(ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        this();
        this.init(itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Initialize class fields.
     */
    public void init(ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        super.init(itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * SetupSFields Method.
     */
    public void setupSFields()
    {
        super.setupSFields();
        this.getRecord(GenPaymentScreenRecord.GEN_PAYMENT_SCREEN_RECORD_FILE).getField(GenPaymentScreenRecord.BANK_ACCT_ID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_INPUT_LOCATION, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(GenPaymentScreenRecord.GEN_PAYMENT_SCREEN_RECORD_FILE).getField(GenPaymentScreenRecord.PAYMENT_CODE_ID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_INPUT_LOCATION, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        Converter converter = this.getScreenRecord().getField(GenPaymentScreenRecord.USE_CURRENT_SELECTION);
        Converter convTrue = new RadioConverter(converter, Boolean.TRUE, true);
        new SRadioButton(this.getNextLocation(ScreenConstants.NEXT_INPUT_LOCATION, ScreenConstants.ANCHOR_DEFAULT), this, convTrue, ScreenConstants.DEFAULT_DISPLAY);
        Converter convFalse = new RadioConverter(converter, Boolean.FALSE, true);
        convFalse = new FieldDescConverter(convFalse, "Select Balance?");
        new SRadioButton(this.getNextLocation(ScreenConstants.RIGHT_WITH_DESC, ScreenConstants.DONT_SET_ANCHOR), this, convFalse, ScreenConstants.DEFAULT_DISPLAY);
        new SCannedBox(this.getNextLocation(ScreenConstants.NEXT_INPUT_LOCATION, ScreenConstants.SET_ANCHOR), this, null, ScreenConstants.DEFAULT_DISPLAY, null, MenuConstants.SELECT, MenuConstants.SELECT, MenuConstants.SELECT, null);
    }

}
