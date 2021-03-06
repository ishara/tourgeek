/**
  * @(#)OTACodesModel.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.model.tour.product.base.ota.db;

import org.jbundle.model.db.*;

public interface OTACodesModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String OTA_CODE_TABLE_ID = "OTACodeTableID";
    public static final String VALUE = "Value";
    public static final String NAME = "Name";
    public static final String CREATION_DATE = "CreationDate";
    public static final String DELETION_DATE = "DeletionDate";
    public static final String PROPERTIES = "Properties";

    public static final String OTA_CODE_TABLE_ID_KEY = "OTACodeTableID";
    public static final String OTA_CODES_SCREEN_CLASS = "com.tourgeek.tour.product.base.ota.screen.OTACodesScreen";
    public static final String OTA_CODES_GRID_SCREEN_CLASS = "com.tourgeek.tour.product.base.ota.screen.OTACodesGridScreen";

    public static final String OTA_CODES_FILE = "OTACodes";
    public static final String THIN_CLASS = "com.tourgeek.thin.tour.product.base.ota.db.OTACodes";
    public static final String THICK_CLASS = "com.tourgeek.tour.product.base.ota.db.OTACodes";

}
