/**
  * @(#)LookupScreenRecord_BookingListFormat.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.booking.lookup;

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

/**
 *  LookupScreenRecord_BookingListFormat - .
 */
public class LookupScreenRecord_BookingListFormat extends IntegerField
{
    /**
     * Default constructor.
     */
    public LookupScreenRecord_BookingListFormat()
    {
        super();
    }
    /**
     * LookupScreenRecord_BookingListFormat Method.
     */
    public LookupScreenRecord_BookingListFormat(Record record, String strName, int iDataLength, String strDesc, Object strDefault)
    {
        this();
        this.init(record, strName, iDataLength, strDesc, strDefault);
    }
    /**
     * Initialize the field.
     */
    public int initField(boolean displayOption)
    {
        return this.setString(""/**ID_LYNX_REPORT*/, displayOption, DBConstants.INIT_MOVE);
    }

}
