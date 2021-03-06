/**
  * @(#)BankTrxBatchDistModel.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.model.tour.assetdr.db;

import org.jbundle.model.db.*;

public interface BankTrxBatchDistModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String BANK_TRX_BATCH_DETAIL_ID = "BankTrxBatchDetailID";
    public static final String ACCOUNT_ID = "AccountID";
    public static final String AMOUNT = "Amount";

    public static final String BANK_TRX_BATCH_DETAIL_ID_KEY = "BankTrxBatchDetailID";
    public static final String BANK_TRX_BATCH_DIST_SCREEN_CLASS = "com.tourgeek.tour.assetdr.screen.batch.BankTrxBatchDistScreen";
    public static final String BANK_TRX_BATCH_DIST_GRID_SCREEN_CLASS = "com.tourgeek.tour.assetdr.screen.batch.BankTrxBatchDistGridScreen";

    public static final String BANK_TRX_BATCH_DIST_FILE = "BankTrxBatchDist";
    public static final String THIN_CLASS = "com.tourgeek.thin.tour.assetdr.db.BankTrxBatchDist";
    public static final String THICK_CLASS = "com.tourgeek.tour.assetdr.db.BankTrxBatchDist";

}
