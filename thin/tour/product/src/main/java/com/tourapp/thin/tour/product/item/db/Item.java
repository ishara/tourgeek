/**
 * @(#)Item.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.thin.tour.product.item.db;

import java.util.*;
import org.jbundle.thin.base.util.*;

import org.jbundle.thin.base.db.*;

import com.tourapp.thin.tour.product.base.db.*;
import com.tourapp.model.tour.product.item.db.*;

public class Item extends Product
    implements ItemModel
{

    public Item()
    {
        super();
    }
    public Item(Object recordOwner)
    {
        this();
        this.init(recordOwner);
    }
    public static final String ITEM_FILE = "Item";
    /**
     *  Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? Item.ITEM_FILE : super.getTableNames(bAddQuotes);
    }
    /**
     *  Get the Database Name.
     */
    public String getDatabaseName()
    {
        return "product";
    }
    /**
     *  Is this a local (vs remote) file?.
     */
    public int getDatabaseType()
    {
        return Constants.LOCAL | Constants.USER_DATA;
    }
    /**
    * Set up the screen input fields.
    */
    public void setupFields()
    {
        FieldInfo field = null;
        field = new FieldInfo(this, "ID", 8, null, null);
        field.setDataClass(Integer.class);
        field.setHidden(true);
        field = new FieldInfo(this, "LastChanged", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Date.class);
        field.setHidden(true);
        field = new FieldInfo(this, "Deleted", 10, null, new Boolean(false));
        field.setDataClass(Boolean.class);
        field.setHidden(true);
        field = new FieldInfo(this, "Description", 50, null, null);
        field = new FieldInfo(this, "Code", 10, null, null);
        field = new FieldInfo(this, "VendorID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "OperatorsCode", 20, null, null);
        field = new FieldInfo(this, "ProductChainID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "CityID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "Etd", 10, null, null);
        field.setDataClass(Date.class);
        field.setScale(Constants.TIME_ONLY);
        field = new FieldInfo(this, "AckDays", 2, null, null);
        field.setDataClass(Short.class);
        field = new FieldInfo(this, "Comments", 32767, null, null);
        field.setDataClass(Object.class);
        field = new FieldInfo(this, "Properties", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Object.class);
        field = new FieldInfo(this, "ItineraryDesc", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Object.class);
        field = new FieldInfo(this, "DescSort", 10, null, null);
        //field = new FieldInfo(this, "ProductType", 15, null, null);
        //field = new FieldInfo(this, "ProductCost", 18, null, null);
        //field.setDataClass(Double.class);
        //field = new FieldInfo(this, "ProductCostLocal", 18, null, null);
        //field.setDataClass(Double.class);
        field = new FieldInfo(this, "ProductMessageTransportID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        //field = new FieldInfo(this, "DisplayInventoryStatusID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //field.setDataClass(Integer.class);
        //field = new FieldInfo(this, "InventoryAvailability", 5, null, null);
        //field.setDataClass(Short.class);
        //field = new FieldInfo(this, "CurrencyCode", 3, null, null);
        //field = new FieldInfo(this, "CurrencyCodeLocal", 3, null, null);
        //field = new FieldInfo(this, "VendorName", 30, null, null);
        //field = new FieldInfo(this, "DisplayCostStatusID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //field.setDataClass(Integer.class);
        //field = new FieldInfo(this, "PPCost", 18, null, null);
        //field.setDataClass(Double.class);
        //field = new FieldInfo(this, "PPCostLocal", 18, null, null);
        //field.setDataClass(Double.class);
        //field = new FieldInfo(this, "RateID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //field.setDataClass(Integer.class);
        //field = new FieldInfo(this, "ClassID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //field.setDataClass(Integer.class);
        //field = new FieldInfo(this, "ProductPriceLocal", 18, null, null);
        //field.setDataClass(Double.class);
        //field = new FieldInfo(this, "PPPriceLocal", 18, null, null);
        //field.setDataClass(Double.class);
    }
    /**
    * Set up the key areas.
    */
    public void setupKeys()
    {
        KeyAreaInfo keyArea = null;
        keyArea = new KeyAreaInfo(this, Constants.UNIQUE, "PrimaryKey");
        keyArea.addKeyField("ID", Constants.ASCENDING);
        keyArea = new KeyAreaInfo(this, Constants.SECONDARY_KEY, "Code");
        keyArea.addKeyField("Code", Constants.ASCENDING);
        keyArea = new KeyAreaInfo(this, Constants.NOT_UNIQUE, "Description");
        keyArea.addKeyField("Description", Constants.ASCENDING);
    }

}
