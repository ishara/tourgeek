/**
 * @(#)BookingLine.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.thin.tour.booking.detail.db;

import java.util.*;
import org.jbundle.thin.base.util.*;

import org.jbundle.thin.base.db.*;

import com.tourapp.thin.tour.booking.detail.db.*;
import com.tourapp.model.tour.booking.detail.db.*;

public class BookingLine extends BookingSub
    implements BookingLineModel
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    //public static final String BOOKING_ID = BOOKING_ID;
    //public static final String BOOKING_PAX_ID = BOOKING_PAX_ID;
    //public static final String MODULE_ID = MODULE_ID;
    //public static final String TOUR_HEADER_DETAIL_ID = TOUR_HEADER_DETAIL_ID;
    //public static final String TOUR_HEADER_OPTION_ID = TOUR_HEADER_OPTION_ID;
    //public static final String MODULE_START_DATE = MODULE_START_DATE;
    //public static final String DESCRIPTION = DESCRIPTION;
    //public static final String PRODUCT_TYPE = PRODUCT_TYPE;
    //public static final String REMOTE_REFERENCE_NO = REMOTE_REFERENCE_NO;

    public BookingLine()
    {
        super();
    }
    public BookingLine(Object recordOwner)
    {
        this();
        this.init(recordOwner);
    }
    public static final String BOOKING_LINE_FILE = "BookingLine";
    /**
     *  Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? BookingLine.BOOKING_LINE_FILE : super.getTableNames(bAddQuotes);
    }
    /**
     *  Get the Database Name.
     */
    public String getDatabaseName()
    {
        return "booking";
    }
    /**
     *  Is this a local (vs remote) file?.
     */
    public int getDatabaseType()
    {
        return Constants.REMOTE | Constants.USER_DATA;
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
        field = new FieldInfo(this, "BookingID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "BookingPaxID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "ModuleID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "TourHeaderDetailID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "TourHeaderOptionID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "ModuleStartDate", 25, null, null);
        field.setDataClass(Date.class);
        field = new FieldInfo(this, "Description", 60, null, null);
        //field = new FieldInfo(this, "ProductType", 15, null, null);
        field = new FieldInfo(this, "RemoteReferenceNo", 60, null, null);
        field = new FieldInfo(this, "Sequence", 4, null, new Short((short)9999));
        field.setDataClass(Short.class);
        field = new FieldInfo(this, "Price", 18, null, null);
        field.setDataClass(Double.class);
        field = new FieldInfo(this, "Quantity", 3, null, null);
        field.setDataClass(Short.class);
        //field = new FieldInfo(this, "Gross", 18, null, null);
        //field.setDataClass(Double.class);
        field = new FieldInfo(this, "Commissionable", 1, null, new Boolean(true));
        field.setDataClass(Boolean.class);
        field = new FieldInfo(this, "CommissionRate", 5, null, null);
        field.setDataClass(Float.class);
        //field = new FieldInfo(this, "Commission", 18, null, null);
        //field.setDataClass(Double.class);
        //field = new FieldInfo(this, "Net", 18, null, null);
        //field.setDataClass(Double.class);
        field = new FieldInfo(this, "PricingStatusID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "PayAt", 1, null, null);
        field = new FieldInfo(this, "PaxGroups", 8, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "BookingDetailID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
        field = new FieldInfo(this, "PaxCategoryID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        field.setDataClass(Integer.class);
    }
    /**
    * Set up the key areas.
    */
    public void setupKeys()
    {
        KeyAreaInfo keyArea = null;
        keyArea = new KeyAreaInfo(this, Constants.UNIQUE, "PrimaryKey");
        keyArea.addKeyField("ID", Constants.ASCENDING);
        keyArea = new KeyAreaInfo(this, Constants.NOT_UNIQUE, "DetailAccess");
        keyArea.addKeyField("BookingID", Constants.ASCENDING);
        keyArea.addKeyField("BookingPaxID", Constants.ASCENDING);
        keyArea.addKeyField("ModuleID", Constants.ASCENDING);
        keyArea.addKeyField("TourHeaderDetailID", Constants.ASCENDING);
        keyArea.addKeyField("ModuleStartDate", Constants.ASCENDING);
        keyArea = new KeyAreaInfo(this, Constants.NOT_UNIQUE, "BookingID");
        keyArea.addKeyField("BookingID", Constants.ASCENDING);
        keyArea.addKeyField("Sequence", Constants.ASCENDING);
        keyArea = new KeyAreaInfo(this, Constants.NOT_UNIQUE, "BookingDetailID");
        keyArea.addKeyField("BookingID", Constants.ASCENDING);
        keyArea.addKeyField("BookingPaxID", Constants.ASCENDING);
        keyArea.addKeyField("BookingDetailID", Constants.ASCENDING);
        keyArea.addKeyField("PaxCategoryID", Constants.ASCENDING);
    }

}
