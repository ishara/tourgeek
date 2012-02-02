/**
 * @(#)FinStmtHeaderModel.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.model.tour.genled.db;

import org.jbundle.model.db.*;

public interface FinStmtHeaderModel extends Rec
{

    //public static final String ID = ID;
    public static final String DESCRIPTION = "Description";

    public static final String DESCRIPTION_KEY = "Description";
    public static final String FIN_STMT_HEADER_SCREEN_CLASS = "com.tourapp.tour.genled.finstmt.screen.FinStmtHeaderScreen";
    public static final String FIN_STMT_HEADER_GRID_SCREEN_CLASS = "com.tourapp.tour.genled.finstmt.screen.FinStmtHeaderGridScreen";

    public static final String FIN_STMT_HEADER_FILE = "FinStmtHeader";
    public static final String THIN_CLASS = "com.tourapp.thin.tour.genled.db.FinStmtHeader";
    public static final String THICK_CLASS = "com.tourapp.tour.genled.db.FinStmtHeader";

}
