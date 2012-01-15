/**
 * @(#)TrxSystem.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.genled.db;

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
import com.tourapp.tour.genled.screen.trx.*;
import com.tourapp.model.tour.genled.db.*;

/**
 *  TrxSystem - Transaction type.
 */
public class TrxSystem extends VirtualRecord
     implements TrxSystemModel
{
    private static final long serialVersionUID = 1L;

    //public static final int kID = kID;
    public static final int kSystemCode = kVirtualRecordLastField + 1;
    public static final int kSystemDesc = kSystemCode + 1;
    public static final int kTrxSystemLastField = kSystemDesc;
    public static final int kTrxSystemFields = kSystemDesc - DBConstants.MAIN_FIELD + 1;

    public static final int kIDKey = DBConstants.MAIN_KEY_FIELD;
    public static final int kSystemCodeKey = kIDKey + 1;
    public static final int kSystemDescKey = kSystemCodeKey + 1;
    public static final int kTrxSystemLastKey = kSystemDescKey;
    public static final int kTrxSystemKeys = kSystemDescKey - DBConstants.MAIN_KEY_FIELD + 1;
    /**
     * Default constructor.
     */
    public TrxSystem()
    {
        super();
    }
    /**
     * Constructor.
     */
    public TrxSystem(RecordOwner screen)
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

    public static final String kTrxSystemFile = "TrxSystem";
    /**
     * Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? Record.formatTableNames(kTrxSystemFile, bAddQuotes) : super.getTableNames(bAddQuotes);
    }
    /**
     * Get the name of a single record.
     */
    public String getRecordName()
    {
        return "System";
    }
    /**
     * Get the Database Name.
     */
    public String getDatabaseName()
    {
        return "genled";
    }
    /**
     * Is this a local (vs remote) file?.
     */
    public int getDatabaseType()
    {
        return DBConstants.LOCAL | DBConstants.SHARED_DATA | DBConstants.LOCALIZABLE;
    }
    /**
     * MakeScreen Method.
     */
    public BaseScreen makeScreen(ScreenLocation itsLocation, BasePanel parentScreen, int iDocMode, Map<String,Object> properties)
    {
        BaseScreen screen = null;
        if ((iDocMode & ScreenConstants.DOC_MODE_MASK) == ScreenConstants.DETAIL_MODE)
            screen = new TrxDescGridScreen(this, null, itsLocation, parentScreen, null, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties);
        else if ((iDocMode & ScreenConstants.MAINT_MODE) == ScreenConstants.MAINT_MODE)
            screen = new TrxSystemScreen(this, itsLocation, parentScreen, null, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties);
        else
            screen = new TrxSystemGridScreen(this, itsLocation, parentScreen, null, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties);
        return screen;
    }
    /**
     * Add this field in the Record's field sequence.
     */
    public BaseField setupField(int iFieldSeq)
    {
        BaseField field = null;
        //if (iFieldSeq == kID)
        //{
        //  field = new CounterField(this, "ID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.setHidden(true);
        //}
        if (iFieldSeq == kSystemCode)
            field = new StringField(this, "SystemCode", 20, null, null);
        if (iFieldSeq == kSystemDesc)
            field = new StringField(this, "SystemDesc", 30, null, null);
        if (field == null)
        {
            field = super.setupField(iFieldSeq);
            if (field == null) if (iFieldSeq < kTrxSystemLastField)
                field = new EmptyField(this);
        }
        return field;
    }
    /**
     * Add this key area description to the Record.
     */
    public KeyArea setupKey(int iKeyArea)
    {
        KeyArea keyArea = null;
        if (iKeyArea == kIDKey)
        {
            keyArea = this.makeIndex(DBConstants.UNIQUE, "PrimaryKey");
            keyArea.addKeyField(kID, DBConstants.ASCENDING);
        }
        if (iKeyArea == kSystemCodeKey)
        {
            keyArea = this.makeIndex(DBConstants.SECONDARY_KEY, "SystemCode");
            keyArea.addKeyField(kSystemCode, DBConstants.ASCENDING);
        }
        if (iKeyArea == kSystemDescKey)
        {
            keyArea = this.makeIndex(DBConstants.NOT_UNIQUE, "SystemDesc");
            keyArea.addKeyField(kSystemDesc, DBConstants.ASCENDING);
        }
        if (keyArea == null) if (iKeyArea < kTrxSystemLastKey)
        {
            keyArea = super.setupKey(iKeyArea);     
            if (keyArea == null) if (iKeyArea < kTrxSystemLastKey)
                keyArea = new EmptyKey(this);
        }
        return keyArea;
    }

}
