/**
  * @(#)CrDrScreenRecord.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.acctrec.screen.misc;

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
import com.tourgeek.tour.booking.entry.acctrec.*;
import com.tourgeek.tour.acctrec.db.*;
import com.tourgeek.tour.booking.db.*;
import com.tourgeek.tour.genled.db.*;
import com.tourgeek.tour.acctrec.db.event.*;
import com.tourgeek.tour.product.base.db.*;

/**
 *  CrDrScreenRecord - Screen Fields for Screen Record entry.
 */
public class CrDrScreenRecord extends ScreenRecord
{
    private static final long serialVersionUID = 1L;

    public static final String COUNTER_ACCOUNT_ID = "CounterAccountID";
    /**
     * Default constructor.
     */
    public CrDrScreenRecord()
    {
        super();
    }
    /**
     * Constructor.
     */
    public CrDrScreenRecord(RecordOwner screen)
    {
        this();
        this.init(screen);
    }
    /**
     * Initialize class fields.
     */
    public void init(RecordOwner screen)
    {
        super.init(screen);
    }

    public static final String CR_DR_SCREEN_RECORD_FILE = null;   // Screen field
    /**
     * Add this field in the Record's field sequence.
     */
    public BaseField setupField(int iFieldSeq)
    {
        BaseField field = null;
        if (iFieldSeq == 0)
            field = new AccountField(this, COUNTER_ACCOUNT_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (field == null)
            field = super.setupField(iFieldSeq);
        return field;
    }

}
