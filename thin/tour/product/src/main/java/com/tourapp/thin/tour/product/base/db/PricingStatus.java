/**
  * @(#)PricingStatus.
  * Copyright © 2012 tourapp.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourapp.thin.tour.product.base.db;

import java.util.*;
import org.jbundle.thin.base.util.*;

import org.jbundle.thin.base.db.*;

import org.jbundle.thin.main.db.base.*;
import com.tourapp.model.tour.product.base.db.*;

public class PricingStatus extends BaseStatus
    implements PricingStatusModel
{
    private static final long serialVersionUID = 1L;


    public PricingStatus()
    {
        super();
    }
    public PricingStatus(Object recordOwner)
    {
        this();
        this.init(recordOwner);
    }
    public static final String PRICING_STATUS_FILE = "PricingStatus";
    /**
     *  Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? PricingStatus.PRICING_STATUS_FILE : super.getTableNames(bAddQuotes);
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
        return Constants.TABLE | Constants.SHARED_DATA | Constants.LOCALIZABLE;
    }
    /**
    * Set up the screen input fields.
    */
    public void setupFields()
    {
        FieldInfo field = null;
        field = new FieldInfo(this, ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field.setHidden(true);
        field = new FieldInfo(this, LAST_CHANGED, Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Date.class);
        field.setHidden(true);
        field = new FieldInfo(this, DELETED, 10, null, new Boolean(false));
        field.setDataClass(Boolean.class);
        field.setHidden(true);
        field = new FieldInfo(this, DESCRIPTION, 20, null, null);
        field = new FieldInfo(this, ICON, Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Object.class);
    }
    /**
    * Set up the key areas.
    */
    public void setupKeys()
    {
        KeyAreaInfo keyArea = null;
        keyArea = new KeyAreaInfo(this, Constants.UNIQUE, ID_KEY);
        keyArea.addKeyField(ID, Constants.ASCENDING);
        keyArea = new KeyAreaInfo(this, Constants.NOT_UNIQUE, DESCRIPTION_KEY);
        keyArea.addKeyField(DESCRIPTION, Constants.ASCENDING);
    }

}
