/**
 * @(#)McoCollScreen.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.acctrec.screen.mco;

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
import org.jbundle.base.model.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import com.tourapp.tour.acctrec.db.*;
import com.tourapp.tour.genled.db.*;
import com.tourapp.tour.acctrec.screen.cash.*;
import com.tourapp.tour.product.air.db.*;

/**
 *  McoCollScreen - Mco carrier collection entry screen.
 */
public class McoCollScreen extends Screen
{
    /**
     * Default constructor.
     */
    public McoCollScreen()
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
    public McoCollScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
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
        return "Mco carrier collection entry screen";
    }
    /**
     * Override this to open the main file.
     * <p />You should pass this record owner to the new main file (ie., new MyNewTable(thisRecordOwner)).
     * @return The new record.
     */
    public Record openMainRecord()
    {
        return new Mco(this);
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
        
        this.getScreenRecord().getField(McoScreenRecord.AIRLINE_ID).addListener(new InitFieldHandler(this.getRecord(ArControl.AR_CONTROL_FILE).getField(ArControl.AIRLINE_ID)));
        
        TrxStatus recTrxStatus = (TrxStatus)this.getRecord(TrxStatus.TRX_STATUS_FILE);
        recTrxStatus.getTrxStatusID(TransactionType.ACCTREC, Mco.MCO_FILE, Mco.SUBMITTED);
        this.getMainRecord().addListener(new SubFileFilter(recTrxStatus));
        
        this.getMainRecord().addListener(new McoCollCalcNetBeh(null));
        
        this.getMainRecord().addListener(new CompareFileFilter(Mco.AIRLINE_ID, this.getScreenRecord().getField(McoScreenRecord.AIRLINE_ID), "=", null, false));
        
        this.getMainRecord().getField(Mco.PAID).addListener(new MoveOnChangeHandler(this.getMainRecord().getField(Mco.AMOUNT_PAID), this.getScreenRecord().getField(McoScreenRecord.NET)));
        FieldListener fieldBehavior = new MoveOnChangeHandler(this.getMainRecord().getField(Mco.DATE_PAID), this.getScreenRecord().getField(McoScreenRecord.TODAY), false, true);
        fieldBehavior.setRespondsToMode(DBConstants.INIT_MOVE, false);
        fieldBehavior.setRespondsToMode(DBConstants.READ_MOVE, false);
        this.getMainRecord().getField(Mco.AMOUNT_PAID).addListener(fieldBehavior);
        
        this.setEnabled(false);
        this.getScreenRecord().getField(McoScreenRecord.AIRLINE_ID).setEnabled(true);
        this.getMainRecord().getField(Mco.DATE_PAID).setEnabled(true);
        this.getMainRecord().getField(Mco.AMOUNT_PAID).setEnabled(true);
        this.getMainRecord().getField(Mco.PAID).setEnabled(true);
    }
    /**
     * Add the screen fields.
     * Override this to create (and return) the screen record for this recordowner.
     * @return The screen record.
     */
    public Record addScreenRecord()
    {
        return new McoScreenRecord(this);
    }
    /**
     * Set up all the screen fields.
     */
    public void setupSFields()
    {
        this.getRecord(Mco.kMcoFile).getField(Mco.kMcoNo).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(Mco.kMcoFile).getField(Mco.kGross).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(Mco.kMcoFile).getField(Mco.kCommAmt).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(McoScreenRecord.kMcoScreenRecordFile).getField(McoScreenRecord.kServiceCharge).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(McoScreenRecord.kMcoScreenRecordFile).getField(McoScreenRecord.kNet).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(Mco.kMcoFile).getField(Mco.kDatePaid).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(Mco.kMcoFile).getField(Mco.kAmountPaid).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        new SButtonBox(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, this.getRecord(Mco.MCO_FILE).getField(Mco.PAID), ScreenConstants.DISPLAY_FIELD_DESC);
    }

}
