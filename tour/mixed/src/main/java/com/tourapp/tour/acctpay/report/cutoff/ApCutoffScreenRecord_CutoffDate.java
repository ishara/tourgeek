/**
 * @(#)ApCutoffScreenRecord_CutoffDate.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.acctpay.report.cutoff;

import java.awt.*;
import java.util.*;

import org.jbundle.base.db.*;
import org.jbundle.thin.base.util.*;
import org.jbundle.thin.base.db.*;
import org.jbundle.base.db.event.*;
import org.jbundle.base.db.filter.*;
import org.jbundle.base.field.*;
import org.jbundle.base.field.convert.*;
import org.jbundle.base.field.event.*;
import org.jbundle.base.screen.model.*;
import org.jbundle.base.screen.model.util.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;

/**
 *  ApCutoffScreenRecord_CutoffDate - .
 */
public class ApCutoffScreenRecord_CutoffDate extends DateField
{
    /**
     * Default constructor.
     */
    public ApCutoffScreenRecord_CutoffDate()
    {
        super();
    }
    /**
     * ApCutoffScreenRecord_CutoffDate Method.
     */
    public ApCutoffScreenRecord_CutoffDate(Record record, String strName, int iDataLength, String strDesc, Object strDefault)
    {
        this();
        this.init(record, strName, iDataLength, strDesc, strDefault);
    }
    /**
     * Initialize the field.
     */
    public int initField(boolean displayOption)
    {
        return this.setValue(todaysDate(), displayOption, DBConstants.INIT_MOVE);
    }

}
