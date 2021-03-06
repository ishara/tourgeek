/**
  * @(#)ArControl.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.acctrec.db;

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
import com.tourgeek.tour.assetdr.db.*;
import com.tourgeek.tour.genled.db.*;
import com.tourgeek.tour.base.field.*;
import com.tourgeek.tour.profile.db.*;
import com.tourgeek.model.tour.acctrec.db.*;

/**
 *  ArControl - Control File.
 */
public class ArControl extends ControlRecord
     implements ArControlModel
{
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ArControl()
    {
        super();
    }
    /**
     * Constructor.
     */
    public ArControl(RecordOwner screen)
    {
        this();
        this.init(screen);
    }
    /**
     * Initialize class fields.
     */
    public void init(RecordOwner screen)
    {
        super.init(screen);
    }
    /**
     * Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? Record.formatTableNames(AR_CONTROL_FILE, bAddQuotes) : super.getTableNames(bAddQuotes);
    }
    /**
     * Get the name of a single record.
     */
    public String getRecordName()
    {
        return "Control";
    }
    /**
     * Get the Database Name.
     */
    public String getDatabaseName()
    {
        return "acctrec";
    }
    /**
     * Is this a local (vs remote) file?.
     */
    public int getDatabaseType()
    {
        return DBConstants.LOCAL | DBConstants.USER_DATA;
    }
    /**
     * Make a default screen.
     */
    public ScreenParent makeScreen(ScreenLoc itsLocation, ComponentParent parentScreen, int iDocMode, Map<String,Object> properties)
    {
        ScreenParent screen = null;
        if ((iDocMode & ScreenConstants.MAINT_MODE) == ScreenConstants.MAINT_MODE)
            screen = Record.makeNewScreen(AR_CONTROL_SCREEN_CLASS, itsLocation, parentScreen, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties, this, true);
        else if ((iDocMode & ScreenConstants.DISPLAY_MODE) == ScreenConstants.DISPLAY_MODE)
            screen = Record.makeNewScreen(AR_CONTROL_SCREEN_2_CLASS, itsLocation, parentScreen, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties, this, true);
        else
            screen = super.makeScreen(itsLocation, parentScreen, iDocMode, properties);
        return screen;
    }
    /**
     * Add this field in the Record's field sequence.
     */
    public BaseField setupField(int iFieldSeq)
    {
        BaseField field = null;
        //if (iFieldSeq == 0)
        //{
        //  field = new CounterField(this, ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.setHidden(true);
        //}
        //if (iFieldSeq == 1)
        //{
        //  field = new RecordChangedField(this, LAST_CHANGED, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.setHidden(true);
        //}
        //if (iFieldSeq == 2)
        //{
        //  field = new BooleanField(this, DELETED, Constants.DEFAULT_FIELD_LENGTH, null, new Boolean(false));
        //  field.setHidden(true);
        //}
        if (iFieldSeq == 3)
            field = new BankAcctField(this, AR_BANK_ACCT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 4)
            field = new AccountField(this, AR_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 5)
            field = new AccountField(this, MCO_REC_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 6)
            field = new AccountField(this, MCO_VAR_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 7)
            field = new AccountField(this, MCO_SUSPENSE_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 8)
            field = new PercentField(this, MCO_COMM_PER, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 9)
            field = new PercentField(this, MCO_SVC_PER, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 10)
            field = new PercentField(this, MCO_TAX_PER, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 11)
            field = new AccountField(this, NON_TOUR_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 12)
            field = new BankAcctField(this, REFUND_BANK_ACCT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 13)
            field = new AccountField(this, REFUND_SUSPENSE_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 14)
            field = new AirlineField(this, AIRLINE_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 15)
            field = new CardField(this, CARD_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 16)
            field = new AccountField(this, CREDIT_CARD_REC_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 17)
            field = new AccountField(this, CREDIT_CARD_SUSPENSE_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 18)
            field = new AccountField(this, CREDIT_CARD_VAR_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 19)
            field = new PercentField(this, CREDIT_CARD_SVC_PER, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 20)
            field = new AccountField(this, CREDIT_DEBIT_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (field == null)
            field = super.setupField(iFieldSeq);
        return field;
    }
    /**
     * Add this key area description to the Record.
     */
    public KeyArea setupKey(int iKeyArea)
    {
        KeyArea keyArea = null;
        if (iKeyArea == 0)
        {
            keyArea = this.makeIndex(DBConstants.UNIQUE, ID_KEY);
            keyArea.addKeyField(ID, DBConstants.ASCENDING);
        }
        if (keyArea == null)
            keyArea = super.setupKey(iKeyArea);     
        return keyArea;
    }

}
