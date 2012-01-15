/**
 * @(#)BaseDataStatusModel.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.model.tour.product.base.db;

import org.jbundle.model.main.msg.db.base.*;

public interface BaseDataStatusModel extends BaseStatusModel
{
    public static final String DATA_STATUS = "dataStatus"; // MessageDataDesc.DATA_STATUS;
    public static final String DATA_ERROR_MESSAGE = "dataErrorMessage";

    public static final String BASE_DATA_STATUS_FILE = "BaseDataStatus";
    public static final String THIN_CLASS = "com.tourapp.thin.tour.product.base.db.BaseDataStatus";
    public static final String THICK_CLASS = "com.tourapp.tour.product.base.db.BaseDataStatus";

}
