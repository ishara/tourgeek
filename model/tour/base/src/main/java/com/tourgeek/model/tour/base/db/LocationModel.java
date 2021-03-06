/**
  * @(#)LocationModel.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.model.tour.base.db;

import org.jbundle.model.db.*;

public interface LocationModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String NAME = "Name";
    public static final String CODE = "Code";

    public static final String NAME_KEY = "Name";

    public static final String CODE_KEY = "Code";

    public static final String LOCATION_FILE = "Location";
    public static final String THIN_CLASS = "com.tourgeek.thin.tour.base.db.Location";
    public static final String THICK_CLASS = "com.tourgeek.tour.base.db.Location";

}
