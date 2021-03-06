/**
  * @(#)CreditCardEntryGridScreen.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.acctrec.screen.credit;

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
import com.tourgeek.tour.acctrec.db.*;
import com.tourgeek.tour.genled.db.*;
import com.tourgeek.tour.booking.db.*;
import com.tourgeek.tour.product.tour.db.*;
import com.tourgeek.tour.acctrec.screen.mco.*;
import com.tourgeek.tour.product.base.db.*;
import com.tourgeek.tour.acctrec.screen.credit.dist.*;

/**
 *  CreditCardEntryGridScreen - Credit Card File.
 */
public class CreditCardEntryGridScreen extends GridScreen
{
    /**
     * Default constructor.
     */
    public CreditCardEntryGridScreen()
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
    public CreditCardEntryGridScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
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
        return "Credit Card File";
    }
    /**
     * Override this to open the main file.
     * <p />You should pass this record owner to the new main file (ie., new MyNewTable(thisRecordOwner)).
     * @return The new record.
     */
    public Record openMainRecord()
    {
        return new CreditCard(this);
    }
    /**
     * Override this to open the other files in the query.
     */
    public void openOtherRecords()
    {
        super.openOtherRecords();
        new ArControl(this);
        new TrxStatus(this);
    }
    /**
     * Add all the screen listeners.
     */
    public void addListeners()
    {
        super.addListeners();
        this.getMainRecord().getField(CreditCard.CARD_ID).addListener(new InitFieldHandler(this.getRecord(ArControl.AR_CONTROL_FILE).getField(ArControl.CARD_ID)));
        this.getMainRecord().getField(CreditCard.SVC_PER).addListener(new InitFieldHandler(this.getRecord(ArControl.AR_CONTROL_FILE).getField(ArControl.CREDIT_CARD_SVC_PER)));
        
        ((TrxStatus)this.getRecord(TrxStatus.TRX_STATUS_FILE)).getTrxStatusID(TransactionType.ACCTREC, CreditCard.CREDIT_CARD_FILE, CreditCard.BATCH);
        this.getMainRecord().setKeyArea(CreditCard.TRX_STATUS_ID_KEY);
        this.getMainRecord().addListener(new SubFileFilter(this.getRecord(TrxStatus.TRX_STATUS_FILE)));
        
        this.getMainRecord().getField(CreditCard.NET).setEnabled(false);
        
        this.getMainRecord().addListener(new SubFileIntegrityHandler(CreditCardBatchDist.class.getName(), true));
    }
    /**
     * Add button(s) to the toolbar.
     */
    public void addToolbarButtons(ToolScreen toolScreen)
    {
        String strDesc = "Distribution";
        if (this.getTask() != null)
            strDesc = ((BaseApplication)this.getTask().getApplication()).getResources(ResourceConstants.ACCTREC_RESOURCE, true).getString(strDesc);
        new SCannedBox(toolScreen.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.SET_ANCHOR), toolScreen, null, ScreenConstants.DEFAULT_DISPLAY, null, strDesc, MenuConstants.FORMDETAIL, MenuConstants.FORMDETAIL, null);
        new SCannedBox(toolScreen.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.SET_ANCHOR), toolScreen, null, ScreenConstants.DEFAULT_DISPLAY, null, MenuConstants.POST, MenuConstants.POST, MenuConstants.POST, null);
    }
    /**
     * SetupSFields Method.
     */
    public void setupSFields()
    {
        Converter converter = this.getRecord(CreditCard.CREDIT_CARD_FILE).getField(CreditCard.BOOKING_ID);
        converter = new CreditCardDistConverter(converter);
        converter.setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(CreditCard.CREDIT_CARD_FILE).getField(CreditCard.CARD_NO).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(CreditCard.CREDIT_CARD_FILE).getField(CreditCard.EXPIRATION).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(CreditCard.CREDIT_CARD_FILE).getField(CreditCard.GROSS).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(CreditCard.CREDIT_CARD_FILE).getField(CreditCard.NET).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(CreditCard.CREDIT_CARD_FILE).getField(CreditCard.CARD_ID).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
    }

}
