/**
  * @(#)TrxDescModel.
  * Copyright © 2012 tourapp.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourapp.model.tour.genled.db;

import org.jbundle.model.db.*;

public interface TrxDescModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String DESC_CODE = "DescCode";
    public static final String DESCRIPTION = "Description";
    public static final String SOURCE_FILE = "SourceFile";
    public static final String TRX_SYSTEM_ID = "TrxSystemID";

    public static final String DESC_CODE_KEY = "DescCode";

    public static final String DESCRIPTION_KEY = "Description";

    public static final String TRX_SYSTEM_ID_KEY = "TrxSystemID";

    public static final String SOURCE_FILE_KEY = "SourceFile";
    public static final String TRX_DESC_SCREEN_CLASS = "com.tourapp.tour.genled.screen.trx.TrxDescScreen";
    public static final String TRX_DESC_GRID_SCREEN_CLASS = "com.tourapp.tour.genled.screen.trx.TrxDescGridScreen";

    public static final String TRX_DESC_FILE = "TrxDesc";
    public static final String THIN_CLASS = "com.tourapp.thin.tour.genled.db.TrxDesc";
    public static final String THICK_CLASS = "com.tourapp.tour.genled.db.TrxDesc";

}
