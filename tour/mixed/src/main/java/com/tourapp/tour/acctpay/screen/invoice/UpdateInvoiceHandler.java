/**
 * @(#)UpdateInvoiceHandler.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.acctpay.screen.invoice;

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
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import com.tourapp.tour.acctpay.db.*;
import com.tourapp.tour.product.base.db.*;
import com.tourapp.tour.base.db.*;
import com.tourapp.tour.genled.db.*;

/**
 *  UpdateInvoiceHandler - Update the A/P G/L on receipt of an Invoice.
 */
public class UpdateInvoiceHandler extends UpdateNonTourInvoiceHandler
{
    /**
     * Default constructor.
     */
    public UpdateInvoiceHandler()
    {
        super();
    }
    /**
     * UpdateInvoiceHandler Method.
     */
    public UpdateInvoiceHandler(Record record)
    {
        this();
        this.init(record);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record record)
    {
        super.init(record);
    }
    /**
     * Get the transaction amount for this type of transaction.
     * @param fldTypicalBalance The typical balance field (Debit/Credit/none).
     * @return The transaction amount.
     */
    public double getTrxAmount(BaseField fldTypicalBalance)
    {
        double dAmountUSD = 0;
        Record recApTrx = this.getOwner();
        double dDrAmountUSD = recApTrx.getField(ApTrx.kDepartureEstimateLocal).getValue();
        double dCrAmountUSD = this.getInvoiceAmtUSD();
        if (dDrAmountUSD == 0)
            dDrAmountUSD = dCrAmountUSD;
        if (fldTypicalBalance.getString().equals(Account.DEBIT))
            dAmountUSD = dDrAmountUSD; // HACK - Much better to scan the amount (and accounts) credited on the departure date posting
        else if (fldTypicalBalance.getString().equals(Account.CREDIT))
            dAmountUSD = dCrAmountUSD;
        else
            dAmountUSD = dCrAmountUSD - dDrAmountUSD;  // Calculate the differential amount
        return dAmountUSD;
    }
    /**
     * Get the transaction date.
     * @return The transaction date for this type of transaction.
     */
    public BaseField getTrxDate()
    {
        return this.getOwner().getField(ApTrx.kInvoiceDate);
    }
    /**
     * Get the Debit Account field.
     * @return The debit account field.
     */
    public ReferenceField getDrAccount()
    {
        Record recApTrx = this.getOwner();
        if (recApTrx.getField(ApTrx.kDepartureEstimateLocal).isNull())
                return (ReferenceField)this.getProductCategory().getField(ProductCategory.kLandAccountID);
        return (ReferenceField)this.getProductCategory().getField(ProductCategory.kUninvAccountID);
    }
    /**
     * Get the Credit Account field.
     * @return The credit account field.
     */
    public ReferenceField getCrAccount()
    {
        return (ReferenceField)this.getProductCategory().getField(ProductCategory.kApAccountID);
    }
    /**
     * Get the differential account (Cost Over/Under) for this type of trx.
     * @return The field that contains the differential account.
     */
    public ReferenceField getDiffAccount()
    {
        Record recApTrx = this.getOwner();
        if (recApTrx.getField(ApTrx.kDepartureEstimateLocal).isNull())
            return null;
        return (ReferenceField)this.getProductCategory().getField(ProductCategory.kCostOUAccountID);
    }
    /**
     * Is this a new (invoice) trx?
     * It is if is a new record or is being changed from an estimate.
     */
    public boolean isNewTrx(int iChangeType)
    {
        if (iChangeType == DBConstants.AFTER_ADD_TYPE)
            return true;
        if (this.getOwner().getField(ApTrx.kTrxStatusID).getValue() == this.getTrxStatusID(ApTrx.DEPARTURE_EST_MANUAL))
            return true;
        if (this.getOwner().getField(ApTrx.kTrxStatusID).getValue() == this.getTrxStatusID(ApTrx.DEPARTURE_ESTIMATE))
            return true;
        return false;
    }

}
