/**
 *  @(#)TrialBalanceSubTotal.
 *  Copyright © 2010 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.genled.report.trialbal;

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
import org.jbundle.base.screen.model.report.*;
import com.tourapp.tour.genled.db.*;
import com.tourapp.tour.genled.finstmt.*;
import com.tourapp.tour.genled.report.*;

/**
 *  TrialBalanceSubTotal - .
 */
public class TrialBalanceSubTotal extends ReportBreakScreen
{
    /**
     * Default constructor.
     */
    public TrialBalanceSubTotal()
    {
        super();
    }
    /**
     * Constructor.
     * @param record The main record for this screen.
     * @param itsLocation The location of this component within the parent.
     * @param parentScreen The parent screen.
     * @param fieldConverter The field this screen field is linked to.
     * @param iDisplayFieldDesc Do I display the field desc?
     * @param properties Addition properties to pass to the screen.
     */
    public TrialBalanceSubTotal(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        this();
        this.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        super.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * SetupSFields Method.
     */
    public void setupSFields()
    {
        Converter converter = new FieldDescConverter(this.getRecord(GenledScreenRecord.kGenledScreenRecordFile).getField(GenledScreenRecord.kStartSource), this.getRecord(GenledScreenRecord.kGenledScreenRecordFile).getField(GenledScreenRecord.kSubTotal));
        new SStaticText(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, converter, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(GenledScreenRecord.kGenledScreenRecordFile).getField(GenledScreenRecord.kSubTotal).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
    }
    /**
     * Is this a control break?
     * @return True if it is a break.
     */
    public boolean isBreak()
    {
        boolean bBreak = super.isBreak();
        if (bBreak)
            bBreak = this.getRecord(GenledScreenRecord.kGenledScreenRecordFile).getField(GenledScreenRecord.kSubTotals).getState();
        if (bBreak)
            bBreak = this.getMainRecord().getField(Account.kSectionSubTotal).getState();
        return bBreak;
    }

}
