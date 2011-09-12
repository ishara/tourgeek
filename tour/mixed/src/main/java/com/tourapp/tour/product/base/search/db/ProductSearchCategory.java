/**
 * @(#)ProductSearchCategory.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.product.base.search.db;

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
import com.tourapp.tour.product.base.search.screen.*;

/**
 *  ProductSearchCategory - .
 */
public class ProductSearchCategory extends VirtualRecord
{
    private static final long serialVersionUID = 1L;

    //public static final int kID = kID;
    public static final int kProductSearchTypeID = kVirtualRecordLastField + 1;
    public static final int kDescription = kProductSearchTypeID + 1;
    public static final int kValue = kDescription + 1;
    public static final int kProductSearchCategoryLastField = kValue;
    public static final int kProductSearchCategoryFields = kValue - DBConstants.MAIN_FIELD + 1;

    public static final int kIDKey = DBConstants.MAIN_KEY_FIELD;
    public static final int kProductSearchTypeIDKey = kIDKey + 1;
    public static final int kProductSearchCategoryLastKey = kProductSearchTypeIDKey;
    public static final int kProductSearchCategoryKeys = kProductSearchTypeIDKey - DBConstants.MAIN_KEY_FIELD + 1;
    /**
     * Default constructor.
     */
    public ProductSearchCategory()
    {
        super();
    }
    /**
     * Constructor.
     */
    public ProductSearchCategory(RecordOwner screen)
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

    public static final String kProductSearchCategoryFile = "ProductSearchCategory";
    /**
     * Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? Record.formatTableNames(kProductSearchCategoryFile, bAddQuotes) : super.getTableNames(bAddQuotes);
    }
    /**
     * Get the Database Name.
     */
    public String getDatabaseName()
    {
        return "product";
    }
    /**
     * Is this a local (vs remote) file?.
     */
    public int getDatabaseType()
    {
        return DBConstants.LOCAL;
    }
    /**
     * Make a default screen.
     */
    public BaseScreen makeScreen(ScreenLocation itsLocation, BasePanel parentScreen, int iDocMode, Map<String,Object> properties)
    {
        BaseScreen screen = null;
        if ((iDocMode & ScreenConstants.MAINT_MODE) != 0)
            screen = new ProductSearchCategoryScreen(this, itsLocation, parentScreen, null, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties);
        else if ((iDocMode & ScreenConstants.DISPLAY_MODE) != 0)
            screen = new ProductSearchCategoryGridScreen(this, itsLocation, parentScreen, null, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties);
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
        //if (iFieldSeq == kID)
        //{
        //  field = new CounterField(this, "ID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.setHidden(true);
        //}
        if (iFieldSeq == kProductSearchTypeID)
            field = new ProductSearchTypeField(this, "ProductSearchTypeID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kDescription)
            field = new StringField(this, "Description", 30, null, null);
        if (iFieldSeq == kValue)
            field = new IntegerField(this, "Value", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (field == null)
        {
            field = super.setupField(iFieldSeq);
            if (field == null) if (iFieldSeq < kProductSearchCategoryLastField)
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
        if (iKeyArea == kProductSearchTypeIDKey)
        {
            keyArea = this.makeIndex(DBConstants.SECONDARY_KEY, "ProductSearchTypeID");
            keyArea.addKeyField(kProductSearchTypeID, DBConstants.ASCENDING);
            keyArea.addKeyField(kDescription, DBConstants.ASCENDING);
        }
        if (keyArea == null) if (iKeyArea < kProductSearchCategoryLastKey)
        {
            keyArea = super.setupKey(iKeyArea);     
            if (keyArea == null) if (iKeyArea < kProductSearchCategoryLastKey)
                keyArea = new EmptyKey(this);
        }
        return keyArea;
    }

}
