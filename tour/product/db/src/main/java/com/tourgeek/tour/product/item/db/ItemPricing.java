/**
  * @(#)ItemPricing.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.product.item.db;

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
import com.tourgeek.tour.product.base.db.*;
import com.tourgeek.model.tour.product.item.db.*;

/**
 *  ItemPricing - Product pricing.
 */
public class ItemPricing extends ProductPricing
     implements ItemPricingModel
{
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ItemPricing()
    {
        super();
    }
    /**
     * Constructor.
     */
    public ItemPricing(RecordOwner screen)
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
        return (m_tableName == null) ? Record.formatTableNames(ITEM_PRICING_FILE, bAddQuotes) : super.getTableNames(bAddQuotes);
    }
    /**
     * Get the name of a single record.
     */
    public String getRecordName()
    {
        return "Item";
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
        return DBConstants.LOCAL | DBConstants.USER_DATA;
    }
    /**
     * Make a default screen.
     */
    public ScreenParent makeScreen(ScreenLoc itsLocation, ComponentParent parentScreen, int iDocMode, Map<String,Object> properties)
    {
        ScreenParent screen = null;
        if ((iDocMode & ScreenConstants.MAINT_MODE) == ScreenConstants.MAINT_MODE)
            screen = Record.makeNewScreen(ITEM_PRICING_SCREEN_CLASS, itsLocation, parentScreen, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties, this, true);
        else if ((iDocMode & ScreenConstants.DISPLAY_MODE) == ScreenConstants.DISPLAY_MODE)
            screen = Record.makeNewScreen(ITEM_PRICING_GRID_SCREEN_CLASS, itsLocation, parentScreen, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties, this, true);
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
        {
            field = new ReferenceField(this, PRODUCT_ID, 8, null, null);
            field.setNullable(false);
        }
        //if (iFieldSeq == 4)
        //{
        //  field = new PaxBaseCategoryField(this, PAX_CATEGORY_ID, Constants.DEFAULT_FIELD_LENGTH, null, new Integer(PaxCategory.ALL_ID));
        //  field.addListener(new InitOnceFieldHandler(null));
        //}
        if (iFieldSeq == 5)
        {
            field = new ItemRateField(this, RATE_ID, Constants.DEFAULT_FIELD_LENGTH, null, new Integer(0));
            field.addListener(new InitOnceFieldHandler(null));
        }
        if (iFieldSeq == 6)
        {
            field = new ItemClassField(this, CLASS_ID, Constants.DEFAULT_FIELD_LENGTH, null, new Integer(0));
            field.addListener(new InitOnceFieldHandler(null));
        }
        //if (iFieldSeq == 7)
        //{
        //  field = new DateField(this, START_DATE, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.addListener(new InitOnceFieldHandler(null));
        //}
        //if (iFieldSeq == 8)
        //{
        //  field = new DateField(this, END_DATE, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.addListener(new InitOnceFieldHandler(null));
        //}
        //if (iFieldSeq == 9)
        //  field = new FullCurrencyField(this, COST, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == 10)
        //{
        //  field = new ProductTermsField(this, PRODUCT_TERMS_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.addListener(new InitOnceFieldHandler(null));
        //}
        //if (iFieldSeq == 11)
        //  field = new CurrencyField(this, PRICE, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == 12)
        //{
        //  field = new BooleanField(this, COMMISSIONABLE, Constants.DEFAULT_FIELD_LENGTH, null, new Boolean(true));
        //  field.addListener(new InitOnceFieldHandler(null));
        //}
        //if (iFieldSeq == 13)
        //{
        //  field = new PercentField(this, COMMISSION_RATE, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.addListener(new InitOnceFieldHandler(null));
        //}
        //if (iFieldSeq == 14)
        //  field = new PayAtField(this, PAY_AT, Constants.DEFAULT_FIELD_LENGTH, null, null);
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
        if (iKeyArea == 1)
        {
            keyArea = this.makeIndex(DBConstants.NOT_UNIQUE, PRODUCT_ID_KEY);
            keyArea.addKeyField(PRODUCT_ID, DBConstants.ASCENDING);
            keyArea.addKeyField(RATE_ID, DBConstants.ASCENDING);
            keyArea.addKeyField(CLASS_ID, DBConstants.ASCENDING);
            keyArea.addKeyField(END_DATE, DBConstants.ASCENDING);
        }
        if (keyArea == null)
            keyArea = super.setupKey(iKeyArea);     
        return keyArea;
    }
    /**
     * GetItemCost Method.
     */
    public ItemPricing getItemCost(Item recItem, Date dateTarget, int iRateID, int iClassID)
    {
        return (ItemPricing)this.getProductCost(recItem, dateTarget, iRateID, iClassID);
    }

}
