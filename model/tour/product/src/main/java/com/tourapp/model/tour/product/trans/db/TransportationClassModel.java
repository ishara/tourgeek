/**
 * @(#)TransportationClassModel.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.model.tour.product.trans.db;

import com.tourapp.model.tour.product.base.db.*;

public interface TransportationClassModel extends BaseClassModel
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    //public static final String DESCRIPTION = DESCRIPTION;
    //public static final String CODE = CODE;
    public static final String FIRST_CLASS = "1";
    public static final String SECOND_CLASS = "2";
    public static final String THIRD_CLASS = "3";

    public static final String TRANSPORTATION_CLASS_FILE = "TransportationClass";
    public static final String THIN_CLASS = "com.tourapp.thin.tour.product.trans.db.TransportationClass";
    public static final String THICK_CLASS = "com.tourapp.tour.product.trans.db.TransportationClass";

}
