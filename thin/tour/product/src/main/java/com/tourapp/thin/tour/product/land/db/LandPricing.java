/**
 *  @(#)LandPricing.
 *  Copyright © 2010 tourapp.com. All rights reserved.
 */
package com.tourapp.thin.tour.product.land.db;

import java.util.*;
import org.jbundle.thin.base.util.*;

import org.jbundle.thin.base.db.*;

public class LandPricing extends FieldList
{

    public LandPricing()
    {
        super();
    }
    public LandPricing(Object recordOwner)
    {
        this();
        this.init(recordOwner);
    }
    public static final String LAND_PRICING_FILE = "LandPricing";
    /**
     *  Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? LandPricing.LAND_PRICING_FILE : super.getTableNames(bAddQuotes);
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
        field = new FieldInfo(this, "ID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field.setHidden(true);
        field = new FieldInfo(this, "LastChanged", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Date.class);
        field.setHidden(true);
        field = new FieldInfo(this, "Deleted", 10, null, new Boolean(false));
        field.setDataClass(Boolean.class);
        field.setHidden(true);
        field = new FieldInfo(this, "ProductID", 8, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "PaxCategoryID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "RateID", Constants.DEFAULT_FIELD_LENGTH, null, new Integer(0));
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "ClassID", Constants.DEFAULT_FIELD_LENGTH, null, new Integer(0));
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "StartDate", 12, null, null);
        field.setDataClass(Date.class);
        field.setScale(Constants.DATE_ONLY);
        field = new FieldInfo(this, "EndDate", 12, null, null);
        field.setDataClass(Date.class);
        field.setScale(Constants.DATE_ONLY);
        field = new FieldInfo(this, "Cost", 18, null, null);
        field.setDataClass(Double.class);
        field = new FieldInfo(this, "ProductTermsID", 1, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "Price", 18, null, null);
        field.setDataClass(Double.class);
        field = new FieldInfo(this, "Commissionable", 10, null, new Boolean(true));
        field.setDataClass(Boolean.class);
        field = new FieldInfo(this, "CommissionRate", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Float.class);
        field = new FieldInfo(this, "PayAt", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field = new FieldInfo(this, "FromPax", 3, null, null);
        field.setDataClass(Short.class);
        field = new FieldInfo(this, "ToPax", 3, null, null);
        field.setDataClass(Short.class);
        field = new FieldInfo(this, "LandVariesID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "VariesDesc", 16, null, null);
    }
    /**
    * Set up the key areas.
    */
    public void setupKeys()
    {
        KeyAreaInfo keyArea = null;
        keyArea = new KeyAreaInfo(this, Constants.UNIQUE, "PrimaryKey");
        keyArea.addKeyField("ID", Constants.ASCENDING);
        keyArea = new KeyAreaInfo(this, Constants.NOT_UNIQUE, "ProductID");
        keyArea.addKeyField("ProductID", Constants.ASCENDING);
        keyArea.addKeyField("ClassID", Constants.ASCENDING);
        keyArea.addKeyField("EndDate", Constants.ASCENDING);
        keyArea.addKeyField("ToPax", Constants.ASCENDING);
    }

}
