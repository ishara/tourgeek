/**
 * @(#)CreditCollectScreen.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.acctrec.screen.credit;

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
import com.tourapp.tour.genled.db.*;
import com.tourapp.tour.acctrec.db.*;
import com.tourapp.tour.acctrec.screen.mco.*;

/**
 *  CreditCollectScreen - Enter amount collected from credit card company.
 */
public class CreditCollectScreen extends CreditBaseScreen
{
    /**
     * Default constructor.
     */
    public CreditCollectScreen()
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
    public CreditCollectScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
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
        return "Enter amount collected from credit card company";
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
     * Add the screen fields.
     * Override this to create (and return) the screen record for this recordowner.
     * @return The screen record.
     */
    public Record addScreenRecord()
    {
        return new McoScreenRecord(this);
    }
    /**
     * Add all the screen listeners.
     */
    public void addListeners()
    {
        super.addListeners();
        
        TrxStatus recTrxStatus = (TrxStatus)this.getRecord(TrxStatus.kTrxStatusFile);
        
        this.getMainRecord().getField(Mco.kPaid).addListener(new MoveOnChangeHandler(this.getMainRecord().getField(CreditCard.kAmountPaid), this.getMainRecord().getField(CreditCard.kNet)));
        this.getMainRecord().getField(Mco.kPaid).addListener(new MoveOnChangeHandler(this.getMainRecord().getField(CreditCard.kDatePaid), this.getScreenRecord().getField(McoScreenRecord.kToday)));
        
        this.getMainRecord().setKeyArea(CreditCard.kTrxStatusIDKey);
        recTrxStatus.getTrxStatusID(TransactionType.ACCTREC, CreditCard.kCreditCardFile, CreditCard.APPROVED);
        this.getMainRecord().addListener(new SubFileFilter(recTrxStatus));
        
        this.setEnabled(false);
        this.getMainRecord().getField(CreditCard.kDatePaid).setEnabled(true);
        this.getMainRecord().getField(CreditCard.kAmountPaid).setEnabled(true);
        this.getMainRecord().getField(Mco.kPaid).setEnabled(true);
    }
    /**
     * Set up all the screen fields.
     */
    public void setupSFields()
    {
        super.setupSFields();
        
        String strDesc = CreditCard.PAID;
        if (this.getTask() != null)
            strDesc = ((BaseApplication)this.getTask().getApplication()).getString(strDesc);
        this.getMainRecord().getField(Mco.kPaid).setFieldDesc(strDesc);
        new SButtonBox(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, this.getMainRecord().getField(Mco.kPaid), ScreenConstants.DISPLAY_FIELD_DESC);
    }

}
