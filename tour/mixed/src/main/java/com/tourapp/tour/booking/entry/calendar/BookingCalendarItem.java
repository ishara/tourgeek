/**
 * @(#)BookingCalendarItem.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.booking.entry.calendar;

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
import org.jbundle.util.calendarpanel.model.*;
import com.tourapp.tour.booking.db.*;
import com.tourapp.tour.booking.detail.db.*;
import com.tourapp.tour.booking.entry.detail.base.*;
import com.tourapp.tour.booking.entry.base.*;
import org.jbundle.thin.base.message.*;
import org.jbundle.base.message.record.*;
import org.jbundle.thin.base.screen.cal.popup.*;
import org.jbundle.base.screen.view.swing.*;
import org.jbundle.util.calendarpanel.*;
import org.jbundle.model.db.*;
import com.tourapp.tour.product.tour.db.*;
import com.tourapp.tour.product.hotel.db.*;
import com.tourapp.tour.product.land.db.*;
import com.tourapp.tour.product.trans.db.*;
import com.tourapp.tour.product.car.db.*;
import com.tourapp.tour.product.cruise.db.*;
import com.tourapp.tour.product.air.db.*;
import com.tourapp.tour.product.item.db.*;
import org.jbundle.base.screen.model.calendar.*;
import javax.swing.*;
import org.jbundle.thin.base.screen.*;
import com.tourapp.tour.product.base.db.*;
import com.tourapp.thin.app.booking.entry.*;

/**
 *  BookingCalendarItem - .
 */
public class BookingCalendarItem extends CalendarRecordItem
     implements CalendarItem
{
    public static Hashtable<String,Color> m_htcolorHighlight = new Hashtable<String,Color>();
    static  {
        m_htcolorHighlight.put(ProductType.AIR, new Color(255, 192, 192));
        m_htcolorHighlight.put(ProductType.HOTEL, new Color(192, 192, 255));
        m_htcolorHighlight.put(ProductType.LAND, new Color(192, 255, 255));
        m_htcolorHighlight.put(ProductType.CAR, new Color(255, 192, 255));
        m_htcolorHighlight.put(ProductType.CRUISE, new Color(192, 255, 192));
        m_htcolorHighlight.put(ProductType.TRANSPORTATION, new Color(192, 192, 192));
        m_htcolorHighlight.put(ProductType.TOUR, new Color(255, 255, 255));
        m_htcolorHighlight.put(ProductType.ITEM, new Color(224, 224, 224));
    };
    protected static ImageIcon m_iconLookup = null;
    protected static ImageIcon m_iconPrice = null;
    protected static ImageIcon m_iconInventory = null;
    protected static ImageIcon m_iconProduct = null;
    /**
     * Default constructor.
     */
    public BookingCalendarItem()
    {
        super();
    }
    /**
     * A class to return a CalendarItem from a record.
     */
    public BookingCalendarItem(BaseScreen gridScreen, int iIconField, int iStartDateTimeField, int iEndDateTimeField, int iDescriptionField, int iStatusField)
    {
        this();
        this.init(gridScreen, iIconField, iStartDateTimeField, iEndDateTimeField, iDescriptionField, iStatusField);
    }
    /**
     * Initialize class fields.
     */
    public void init(BaseScreen gridScreen, int iIconField, int iStartDateTimeField, int iEndDateTimeField, int iDescriptionField, int iStatusField)
    {
        super.init(gridScreen, iIconField, iStartDateTimeField, iEndDateTimeField, iDescriptionField, iStatusField);
        if (m_iconLookup == null) // First time only
            m_iconLookup = this.getTask().loadImageIcon(BookingConstants.BUTTON_LOCATION + MenuConstants.LOOKUP, MenuConstants.LOOKUP);
        if (m_iconPrice == null)
            m_iconPrice = this.getTask().loadImageIcon(BookingConstants.BUTTON_LOCATION + BookingConstants.COST, BookingConstants.COST);
        if (m_iconInventory == null)
            m_iconInventory = this.getTask().loadImageIcon(BookingConstants.BUTTON_LOCATION + BookingConstants.INVENTORY, BookingConstants.INVENTORY);
        if (m_iconProduct == null)
            m_iconProduct = this.getTask().loadImageIcon(BookingConstants.BUTTON_LOCATION + BookingConstants.PRODUCT, BookingConstants.PRODUCT);
    }
    /**
     * Get the description.
     * @return The description.
     */
    public String getDescription()
    {
        return this.getBookingDetail().getProductDesc();
    }
    /**
     * Get the start time of this service.
     * @return The start date.
     */
    public Date getStartDate()
    {
        return this.getBookingDetail().getStartDate();
    }
    /**
     * Get the ending time of this service.
     * @return The end date.
     */
    public Date getEndDate()
    {
        return this.getBookingDetail().getEndDate();
    }
    /**
     * Get the icon (opt).
     * @return The icon.
     */
    public ImageIcon getIcon(int iIconType)
    {
        String strIcon = null;
        if (iIconType == CalendarConstants.START_ICON)
            strIcon = this.getBookingDetail().getStartIcon();
        else if (iIconType == CalendarConstants.END_ICON)
            strIcon = this.getBookingDetail().getEndIcon();
        else if (iIconType == CalendarConstants.START_ICON + BookingConstants.INFO_LOOKUP)
            return m_iconLookup;
        else if (iIconType == CalendarConstants.START_ICON + BookingConstants.COST_LOOKUP)
            return m_iconPrice;
        else if (iIconType == CalendarConstants.START_ICON + BookingConstants.INVENTORY_LOOKUP)
            return m_iconInventory;
        else if (iIconType == CalendarConstants.START_ICON + BookingConstants.PRODUCT_LOOKUP)
            return m_iconProduct;
        else
            return null;    //??        if (strIcon == null)
        if (strIcon == null)
            return null;
        return this.getTask().loadImageIcon(strIcon, null);
    }
    /**
     * Get the status of this object.
     * @return The status.
     */
    public int getStatus()
    {
        return this.getBookingDetail().getStatus();
    }
    /**
     * Get the meal description on this date.
     * @return The meal description.
     */
    public String getMealDesc(Date date)
    {
        return this.getBookingDetail().getMealDesc(date, false, null);
    }
    /**
     * Highlight color (optional).
     * @return The highlight color (green).
     */
    public Color getHighlightColor()
    {
        String strProductType = this.getBookingDetail().getField(BookingDetail.kProductType).toString();
        Color color = null;
        if (strProductType != null)
            color = m_htcolorHighlight.get(strProductType);
        if (color == null)
            color = Color.green;
        return color;
    }
    /**
     * Get the selection colot.
     */
    public Color getSelectColor()
    {
        return null;    // Have the calendar screen figure out a color
    }
    /**
     * Get the Visual Javabean.
     */
    public Object getVisualJavaBean(int iPanelType)
    {
        return null;
    }
    /**
     * Change the start time of this service.
     * @param time The new start date.
     */
    public Date setStartDate(Date date)
    {
        this.editTargetRecord();
        date = this.getBookingDetail().setStartDate(date);
        this.updateTargetRecord();
        return date;
    }
    /**
     * Change the ending time of this service.
     * @param date The new end date.
     */
    public Date setEndDate(Date date)
    {
        this.editTargetRecord();
        date = this.getBookingDetail().setEndDate(date);
        this.updateTargetRecord();
        return date;
    }
    /**
     * Get the detail record.
     */
    public BookingDetail getBookingDetail()
    {
        return (BookingDetail)this.getMainRecord().getTable().getCurrentTable().getRecord();
    }
    /**
     * Utility method to get the (applet) task so I can load a graphic.
     */
    public BaseApplet getTask()
    {
        return (BaseApplet)this.getBookingDetail().getRecordOwner().getTask();
    }

}
