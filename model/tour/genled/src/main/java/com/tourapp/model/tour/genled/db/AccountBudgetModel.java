/**
 * @(#)AccountBudgetModel.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.model.tour.genled.db;

import org.jbundle.model.db.*;

public interface AccountBudgetModel extends Rec
{
    public static final String ACCOUNT_BUDGET_SCREEN_CLASS = "com.tourapp.tour.genled.screen.misc.AccountBudgetScreen";
    public static final String ACCOUNT_BUDGET_GRID_SCREEN_CLASS = "com.tourapp.tour.genled.screen.misc.AccountBudgetGridScreen";

    public static final String ACCOUNT_BUDGET_FILE = "AccountBudget";
    public static final String THIN_CLASS = "com.tourapp.thin.tour.genled.db.AccountBudget";
    public static final String THICK_CLASS = "com.tourapp.tour.genled.db.AccountBudget";

}
