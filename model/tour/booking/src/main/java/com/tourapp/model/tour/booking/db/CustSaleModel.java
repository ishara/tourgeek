/**
 * @(#)CustSaleModel.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.model.tour.booking.db;

import org.jbundle.model.db.*;

public interface CustSaleModel extends Rec
{

    //public static final String ID = ID;
    public static final String CUST_SALE_DATE = "CustSaleDate";
    public static final String CUST_SALE_AGENT = "CustSaleAgent";
    public static final String CUST_SALE_CUST_ID = "CustSaleCustID";
    public static final String CUST_SALE_CUST_NO = "CustSaleCustNo";

    public static final String CUST_SALE_FILE = "CustSale";
    public static final String THIN_CLASS = "com.tourapp.thin.tour.booking.db.CustSale";
    public static final String THICK_CLASS = "com.tourapp.tour.booking.db.CustSale";

}
