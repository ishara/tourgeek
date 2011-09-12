/**
 * @(#)CruiseSearchSession.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.product.remote.search;

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
import com.tourapp.tour.product.cruise.db.*;
import com.tourapp.tour.product.remote.*;
import java.rmi.*;
import org.jbundle.base.remote.*;
import org.jbundle.thin.opt.location.*;
import org.jbundle.thin.base.message.*;
import com.tourapp.tour.product.cruise.event.*;
import com.tourapp.tour.product.base.event.*;
import com.tourapp.tour.product.base.db.*;
import com.tourapp.tour.product.cruise.screen.*;
import com.tourapp.thin.app.booking.entry.search.*;
import com.tourapp.tour.base.db.*;

/**
 *  CruiseSearchSession - .
 */
public class CruiseSearchSession extends ProductSearchSession
{
    /**
     * Default constructor.
     */
    public CruiseSearchSession() throws RemoteException
    {
        super();
    }
    /**
     * CruiseSearchSession Method.
     */
    public CruiseSearchSession(BaseSession parentSessionObject, Record record, Object objectID) throws RemoteException
    {
        this();
        this.init(parentSessionObject, record, objectID);
    }
    /**
     * Initialize class fields.
     */
    public void init(BaseSession parentSessionObject, Record record, Object objectID)
    {
        super.init(parentSessionObject, record, objectID);
    }
    /**
     * Override this to open the main file for this session.
     */
    public Record openMainRecord()
    {
        Record record = new Cruise(this);
        try   {   // Wrap the record in a ProductSessionObject so the default TableSesionObject isn't used.
            ProductSession obj = new ProductSession(this, record, null);
        } catch (RemoteException ex)    {
            ex.printStackTrace();
        }
        return record;
    }
    /**
     * Override this to open other session files.
     */
    public void openOtherRecords()
    {
        super.openOtherRecords();
        new City(this);   // For thin
    }
    /**
     * Add the screen record to this session.
     */
    public Record addScreenRecord()
    {
        return new CruiseScreenRecord(this);
    }
    /**
     * Add behaviors to this session.
     */
    public void addListeners()
    {
        super.addListeners(); 
        
        ((ReferenceField)this.getScreenRecord().getField(ProductScreenRecord.kClassID)).getReferenceRecord(this);
        
        this.getMainRecord().addListener(new ExtractRangeFilter(Product.kDescSort, this.getScreenRecord().getField(ProductScreenRecord.kDescription)));
        this.getMainRecord().addListener(new CompareFileFilter(TransportProduct.kCityID, this.getScreenRecord().getField(ProductScreenRecord.kCityID), DBConstants.EQUALS, null, true));
        this.getMainRecord().addListener(new CompareFileFilter(TransportProduct.kToCityID, this.getScreenRecord().getField(ProductScreenRecord.kToCityID), DBConstants.EQUALS, null, true));
    }
    /**
     * Select the fields required for the grid screen.
     */
    public void selectGridFields()
    {
        super.selectGridFields();
    }
    /**
     * Select the fields for the maint screen.
     */
    public void selectMaintFields()
    {
        super.selectMaintFields();
        Record record = this.getMainRecord();
    }
    /**
     * AddProductRateMessageFilter Method.
     */
    public ProductRateMessageListener addProductRateMessageFilter(Product recProduct, BaseMessageFilter messageFilter)
    {
        return new CruiseRateMessageListener(null, recProduct, false, messageFilter);
    }
    /**
     * GetProductCostHandler Method.
     */
    public GetProductCostHandler getProductCostHandler(ProductScreenRecord screenRecord, Integer intRegistryID)
    {
        return new GetCruiseCostHandler(screenRecord, intRegistryID);
    }
    /**
     * SetScreenFields Method.
     */
    public void setScreenFields(Map<String,Object> properties)
    {
        super.setScreenFields(properties);
        Record recProduct = this.getMainRecord();
        
        this.addThisRecordFilter(properties, City.kCityFile, SearchConstants.LOCATION_TO, TransportProduct.kToCityID, ProductScreenRecord.kToCityID);
        
        String strCruiseClass = (String)properties.get(SearchConstants.CRUISE_CLASS);
        this.getScreenRecord().getField(ProductScreenRecord.kClassID).setString(strCruiseClass);
        
        Record recProductControl = this.getRecord(ProductControl.kProductControlFile);
        this.getScreenRecord().getField(ProductScreenRecord.kRateID).moveFieldToThis(recProductControl.getField(ProductControl.kCruiseRateID));
    }

}
