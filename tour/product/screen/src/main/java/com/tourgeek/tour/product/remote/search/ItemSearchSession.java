
package com.tourgeek.tour.product.remote.search;

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
import com.tourgeek.tour.product.item.db.*;
import com.tourgeek.tour.product.remote.*;
import org.jbundle.thin.base.remote.*;
import org.jbundle.base.remote.*;
import com.tourgeek.tour.product.item.event.*;
import com.tourgeek.tour.product.base.event.*;
import org.jbundle.thin.base.message.*;
import com.tourgeek.tour.product.base.db.*;
import com.tourgeek.tour.product.item.screen.*;

/**
 *  ItemSearchSession - .
 */
public class ItemSearchSession extends ProductSearchSession
{
    /**
     * Default constructor.
     */
    public ItemSearchSession() throws RemoteException
    {
        super();
    }
    /**
     * ItemSearchSession Method.
     */
    public ItemSearchSession(BaseSession parentSessionObject, Record record, Map<String, Object> objectID) throws RemoteException
    {
        this();
        this.init(parentSessionObject, record, objectID);
    }
    /**
     * Initialize class fields.
     */
    public void init(BaseSession parentSessionObject, Record record, Map<String, Object> objectID)
    {
        super.init(parentSessionObject, record, objectID);
    }
    /**
     * Override this to open the main file for this session.
     */
    public Record openMainRecord()
    {
        Record record = new Item(this);
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
    }
    /**
     * Add the screen record to this session.
     */
    public Record addScreenRecord()
    {
        return new ItemScreenRecord(this);
    }
    /**
     * Add behaviors to this session.
     */
    public void addListeners()
    {
        super.addListeners(); 
        
        this.getMainRecord().addListener(new ExtractRangeFilter(Product.DESC_SORT, this.getScreenRecord().getField(ProductScreenRecord.DESCRIPTION)));
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
        return new ItemRateMessageListener(null, recProduct, false, messageFilter);
    }
    /**
     * GetProductCostHandler Method.
     */
    public GetProductCostHandler getProductCostHandler(ProductScreenRecord screenRecord, Integer intRegistryID)
    {
        return new GetItemCostHandler(screenRecord, intRegistryID);
    }
    /**
     * SetScreenFields Method.
     */
    public void setScreenFields(Map<String,Object> properties)
    {
        super.setScreenFields(properties);
        Record recProduct = this.getMainRecord();
        Record recProductControl = this.getRecord(ProductControl.PRODUCT_CONTROL_FILE);
        
        this.getScreenRecord().getField(ProductScreenRecord.CLASS_ID).moveFieldToThis(recProductControl.getField(ProductControl.ITEM_CLASS_ID));
        this.getScreenRecord().getField(ProductScreenRecord.RATE_ID).moveFieldToThis(recProductControl.getField(ProductControl.ITEM_RATE_ID));
    }

}
