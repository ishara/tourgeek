/**
  * @(#)FinStmtDetailModel.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.model.tour.genled.db.finstmt;

import org.jbundle.model.db.*;

public interface FinStmtDetailModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String FIN_STMT_ID = "FinStmtID";
    public static final String SEQUENCE = "Sequence";
    public static final String ACCOUNT_ID = "AccountID";
    public static final String ACCOUNT_DESC = "AccountDesc";
    public static final String INDENT = "Indent";
    public static final String INVISIBLE = "Invisible";
    public static final String TYPICAL_BALANCE = "TypicalBalance";
    public static final String SUB_TOTAL_LEVEL = "SubTotalLevel";
    public static final String DATA_COLUMN = "DataColumn";
    public static final String SPECIAL_FORMAT = "SpecialFormat";
    public static final String NUMBER_FORMAT = "NumberFormat";
    public static final String SPECIAL_FUNCTION = "SpecialFunction";

    public static final String FIN_STMT_ID_KEY = "FinStmtID";
    public static final String FIN_STMT_DETAIL_SCREEN_CLASS = "com.tourgeek.tour.genled.finstmt.screen.FinStmtDetailScreen";
    public static final String FIN_STMT_DETAIL_GRID_SCREEN_CLASS = "com.tourgeek.tour.genled.finstmt.screen.FinStmtDetailGridScreen";
    public static final String RENUMBER = "Renumber";
    public static final String VALIDATE = "Validate";

    public static final String FIN_STMT_DETAIL_FILE = "FinStmtDetail";
    public static final String THIN_CLASS = "com.tourgeek.thin.tour.genled.db.finstmt.FinStmtDetail";
    public static final String THICK_CLASS = "com.tourgeek.tour.genled.db.finstmt.FinStmtDetail";

}
