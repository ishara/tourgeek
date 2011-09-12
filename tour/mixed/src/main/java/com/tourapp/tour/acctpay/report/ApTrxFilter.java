/**
 * @(#)ApTrxFilter.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.acctpay.report;

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
import com.tourapp.tour.acctpay.db.*;
import com.tourapp.tour.genled.db.*;

/**
 *  ApTrxFilter - Filter the ApTrx depending on the flags in the ApReportScreenRecord:
- Vouchers
- Finalization Estimates
- Departure Estimates
- Open Items
- Paid Items.
 */
public class ApTrxFilter extends ApTrxBaseFilter
{
    protected boolean m_bDepEst = true;
    protected boolean m_bOpenItems = true;
    protected boolean m_bPaidItems = true;
    protected boolean m_bVouchers = true;
    protected ScreenRecord m_screenRecord = null;
    /**
     * Default constructor.
     */
    public ApTrxFilter()
    {
        super();
    }
    /**
     * Constructor.
     */
    public ApTrxFilter(int fsTarget, ScreenRecord screenRecord)
    {
        this();
        this.init(fsTarget, screenRecord);
    }
    /**
     * Initialize class fields.
     */
    public void init(int fsTarget, ScreenRecord screenRecord)
    {
        m_screenRecord = null;
        m_screenRecord = screenRecord;
        super.init(null, fsTarget);
    }
    /**
     * Has the filter changed from the last time this was used?
     * If yes, return true and change your compare values for next time.
     * Usually Override this (default logic returns true on first time).
     * @return True if filter has changed.
     */
    public boolean isFilterChange()
    {
        if ((m_screenRecord.getField(ApReportScreenRecord.kVouchers).getState() != m_bVouchers)
            || (m_screenRecord.getField(ApReportScreenRecord.kDepEstimates).getState() != m_bDepEst)
            || (m_screenRecord.getField(ApReportScreenRecord.kOpenItems).getState() != m_bOpenItems)
            || (m_screenRecord.getField(ApReportScreenRecord.kShowPaid).getState() != m_bPaidItems))
        {
            m_bVouchers = m_screenRecord.getField(ApReportScreenRecord.kVouchers).getState();
            m_bDepEst = m_screenRecord.getField(ApReportScreenRecord.kDepEstimates).getState();
            m_bOpenItems = m_screenRecord.getField(ApReportScreenRecord.kOpenItems).getState();
            m_bPaidItems = m_screenRecord.getField(ApReportScreenRecord.kShowPaid).getState();
            return true;
        }
        return false;
    }
    /**
     * Should I add this Status to the filter?
     * Override this!
     * @return true if status is valid.
     */
    public boolean checkTrxStatus(TrxStatus recTrxStatus)
    {
        if (recTrxStatus.getField(TrxStatus.kStatusCode).toString().indexOf(ApTrx.VOUCHER) != -1)
            return m_bVouchers;
        else if (recTrxStatus.getField(TrxStatus.kStatusCode).toString().indexOf(ApTrx.DEPARTURE_ESTIMATE.substring(0, 6)) != -1)
            return m_bDepEst;
        else if (recTrxStatus.getField(TrxStatus.kActiveTrx).getState() == false)
            return m_bPaidItems;
        else
            return m_bOpenItems;
    }

}
