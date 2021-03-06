/**
  * @(#)BaseDataStatusField.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.product.base.db;

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
import org.jbundle.main.db.base.*;
import org.jbundle.thin.base.message.*;
import com.tourgeek.model.tour.booking.detail.db.*;

/**
 *  BaseDataStatusField - .
 */
public class BaseDataStatusField extends BaseStatusField
{
    /**
     * Default constructor.
     */
    public BaseDataStatusField()
    {
        super();
    }
    /**
     * Constructor.
     * @param record The parent record.
     * @param strName The field name.
     * @param iDataLength The maximum string length (pass -1 for default).
     * @param strDesc The string description (usually pass null, to use the resource file desc).
     * @param strDefault The default value (if object, this value is the default value, if string, the string is the default).
     */
    public BaseDataStatusField(Record record, String strName, int iDataLength, String strDesc, Object strDefault)
    {
        this();
        this.init(record, strName, iDataLength, strDesc, strDefault);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record record, String strName, int iDataLength, String strDesc, Object strDefault)
    {
        super.init(record, strName, iDataLength, strDesc, strDefault);
    }
    /**
     * Merge my changed data back into field that I just restored from disk.
     * @param objData The value this field held before I refreshed from disk.
     * @return The setData error code.
     */
    public int doMergeData(Object objData)
    {
        if (objData instanceof Integer) // Always
            if (((Integer)objData).intValue() == BaseStatus.DATA_REQUIRED)
            {
                if (this.getRecord() instanceof BookingDetailModel)
                {
                    BookingDetailModel recBookingDetail = (BookingDetailModel)this.getRecord();
                    for (int iStatusType = 0; iStatusType < recBookingDetail.getFieldCount(); iStatusType++)
                    {
                        if (recBookingDetail.getField(iStatusType) == this)
                        {
                            if (recBookingDetail.checkRequiredParams(this.getFieldName()) == null) // Possible that the data is okay now, check it.
                            {   // If I say data required, but the refresh says something else, use the refresh status and recheck the data
                                recBookingDetail.getField(iStatusType + BookingDetailModel.MESSAGE_REQUEST_OFFSET).setState(true);
                                return DBConstants.NORMAL_RETURN;
                            }
                            break;
                        }
                    }
                }
            }
        return super.doMergeData(objData);
    }

}
