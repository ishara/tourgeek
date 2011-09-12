/**
 * @(#)PostingType.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.genled.db;

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
 *  PostingType - The posting hint to tell the BaseTrx what side of the transaction this belongs on..
 */
public class PostingType extends StringField
{
    public static final String DIFFERENCE_POST = "Diff";
    public static final String DIST_POST = "X";
    public static final String OPTIONAL_POST = "Optional";
    public static final String TRX_POST = "T";
    /**
     * Default constructor.
     */
    public PostingType()
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
    public PostingType(Record record, String strName, int iDataLength, String strDesc, Object strDefault)
    {
        this();
        this.init(record, strName, iDataLength, strDesc, strDefault);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record record, String strName, int iDataLength, String strDesc, Object strDefault)
    {
        if (iDataLength == DBConstants.DEFAULT_FIELD_LENGTH)
            m_iMaxLength = 1;
        super.init(record, strName, iDataLength, strDesc, strDefault);
    }
    /**
     * Convert this index to a display field.
     * @param index The index to convert.
     * @return The display string.
     */
    public String convertIndexToDisStr(int index)
    {
        String tempString = null;
        switch(index)
        {
        case 0:
        default:
            tempString = "";break;
        case 1:
            tempString = "Transaction side";break;
        case 2:
            tempString = "Distribution side";break;
        }
        return tempString;
    }
    /**
     * Convert this index to a string.
     * This method is usually overidden by popup fields.
     * @param index The index to convert.
     * @return The display string.
     */
    public String convertIndexToString(int index)
    {
        String tempString = null;
        if (index == 2)
            tempString = DIST_POST;
        else if (index == 1)
            tempString = TRX_POST;
        return tempString;
    }
    /**
     * Convert this string to it's index value.
     */
    public int convertStringToIndex(String tempString)
    {
        if (tempString.equalsIgnoreCase(DIST_POST))
            return 2;
        else if (tempString.equalsIgnoreCase(TRX_POST))
            return 1;
        else
            return 0;
    }
    /**
     * Set up the default screen control for this field.
     * @param itsLocation Location of this component on screen (ie., GridBagConstraint).
     * @param targetScreen Where to place this component (ie., Parent screen or GridBagLayout).
     * @param converter The converter to set the screenfield to.
     * @param iDisplayFieldDesc Display the label? (optional).
     * @return Return the component or ScreenField that is created for this field.
     */
    public ScreenField setupDefaultView(ScreenLocation itsLocation, BasePanel targetScreen, Converter converter, int iDisplayFieldDesc)
    {
        return new SPopupBox(itsLocation, targetScreen, this, iDisplayFieldDesc);
    }

}
