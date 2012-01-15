/**
 * @(#)BaseProductStatus.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.thin.tour.product.base.db;

import java.util.*;
import org.jbundle.thin.base.util.*;

import org.jbundle.thin.base.db.*;

import org.jbundle.thin.main.msg.db.base.*;
import com.tourapp.model.tour.product.base.db.*;

public class BaseProductStatus extends BaseStatus
    implements BaseProductStatusModel
{

    public BaseProductStatus()
    {
        super();
    }
    public BaseProductStatus(Object recordOwner)
    {
        this();
        this.init(recordOwner);
    }

}
