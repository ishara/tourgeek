/**
  * @(#)GetTourHeaderCostHandler.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.product.tour.event;

import java.util.*;

import org.jbundle.base.db.*;
import org.jbundle.thin.base.util.*;
import org.jbundle.thin.base.db.*;
import org.jbundle.base.db.event.*;
import org.jbundle.base.db.filter.*;
import org.jbundle.base.field.*;
import org.jbundle.base.field.convert.*;
import org.jbundle.base.field.event.*;
import org.jbundle.base.model.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import com.tourgeek.tour.product.base.event.*;

/**
 *  GetTourHeaderCostHandler - Get the tour header cost.
 */
public class GetTourHeaderCostHandler extends GetProductCostHandler
{
    /**
     * Default constructor.
     */
    public GetTourHeaderCostHandler()
    {
        super();
    }
    /**
     * GetTourHeaderCostHandler Method.
     */
    public GetTourHeaderCostHandler(Record recProductVars, Integer intRegistryID)
    {
        this();
        this.init(recProductVars, intRegistryID);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record recProductVars, Integer intRegistryID)
    {
        super.init(recProductVars, intRegistryID);
    }
    /**
     * If all the data in the screen record that is required for a query is there,
     * return true. If not, false.
     */
    public boolean isQueryComplete()
    {
        return super.isQueryComplete();
    }
    /**
     * Move this product cost from to virtual fields to the ProductCost
     * field in recProduct. Also move the status to the product cost status.
     * (Override this to set the correct fields!).
     */
    public void setupScreenStatus(Record recProduct, int iStatus)
    {
        super.setupScreenStatus(recProduct, iStatus);
    }

}
