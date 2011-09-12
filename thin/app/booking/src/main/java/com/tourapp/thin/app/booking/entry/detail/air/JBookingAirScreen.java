/*
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package com.tourapp.thin.app.booking.entry.detail.air;

/**
 * OrderEntry.java:   Applet
 *  Copyright � 1997 tourgeek.com. All rights reserved.
 *  
 *  @author Don Corley don@donandann.com
 *  @version 1.0.0.
 */
import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.JComponent;

import org.jbundle.thin.base.db.Constants;
import org.jbundle.thin.base.db.Converter;
import org.jbundle.thin.base.db.FieldList;
import org.jbundle.thin.base.screen.BaseApplet;
import org.jbundle.thin.base.screen.util.JRemoteComboBox;

import com.tourapp.thin.app.booking.entry.BookingConstants;
import com.tourapp.thin.app.booking.entry.detail.JBaseBookingDetailScreen;
import com.tourapp.thin.tour.booking.detail.db.BookingAir;
import com.tourapp.thin.tour.booking.detail.db.BookingDetail;
import com.tourapp.thin.tour.product.air.db.Air;
import com.tourapp.thin.tour.product.air.db.AirClass;

/**
 * Main Class for applet OrderEntry
 */
public class JBookingAirScreen extends JBaseBookingDetailScreen
{
    private static final long serialVersionUID = 1L;

    /**
     *  OrderEntry Class Constructor.
     */
    public JBookingAirScreen()
    {
        super();
    }
    /**
     *  OrderEntry Class Constructor.
     */
    public JBookingAirScreen(Object parent, Object obj)
    {
        this();
        this.init(parent, obj);
    }
    /**
     * Constructor.
     */
    public void init(Object parent, Object obj)
    {
        super.init(parent, obj);
    }
    /**
     * Get the product record.
     * Override this to supply the correct product record.
     * @return The product record.
     */
    public FieldList getProductRecord()
    {
        return new Air(this);
    }
    /**
     * Build the list of fields that make up the screen.
     */
    public FieldList buildFieldList()
    {
        return new BookingAir(this);
    }
    /**
     * Add the screen controls to the second column of the grid.
     */
    public JComponent createScreenComponent(Converter fieldInfo)
    {
        JComponent component = null;

        String strDefault = fieldInfo.toString();
        if (strDefault == null)
            strDefault = Constants.BLANK;
        BaseApplet applet = this.getBaseApplet();
        
        if (fieldInfo.getFieldName().equals(BookingDetail.CLASS_ID))
        {
            AirClass recAirClass = new AirClass(this);
            component = new JRemoteComboBox(applet, this.getRemoteSession(null), recAirClass, applet.getString(BookingConstants.AIR_CLASS), AirClass.DESCRIPTION, BookingConstants.AIR_CLASS, true, AirClass.ID, null);
        }
        else
            component = super.createScreenComponent(fieldInfo);

        return component;
    }
    /**
     * Add the description labels to the first column of the grid.
     */
    public JComponent addScreenLabel(Container parent, Converter fieldInfo)
    {
        GridBagConstraints c = this.getGBConstraints();
        c.gridy = GridBagConstraints.RELATIVE;  // Bump Row each time
        if (fieldInfo.getFieldName().equals(BookingDetail.TOTAL_COST))
        {
            c.gridy = 0;
            c.gridx = 4;                            // Column 3
        }
        return super.addScreenLabel(parent, fieldInfo);
    }
    /**
     * Add the screen controls to the second column of the grid.
     */
    public JComponent addScreenControl(Container parent, Converter fieldInfo)
    {
        GridBagConstraints c = this.getGBConstraints();
        c.gridy = GridBagConstraints.RELATIVE;  // Bump Row each time
        if (fieldInfo.getFieldName().equals(BookingDetail.TOTAL_COST))
        {
            c.gridy = 0;
            c.gridx = 5;                            // Column 4
        }
        return super.addScreenControl(parent, fieldInfo);
    }
    /**
     * Get the field name at this location on the screen.
     * @param iScreenSeq The screen sequence to get the field name from.
     * @return The field name at this screen location.
     */
    public String getFieldName(int iScreenSeq)
    {
        if (iScreenSeq >= m_rgFieldNames.length)
            return null;
        return m_rgFieldNames[iScreenSeq];
    }
    /**
     * The fields in screen order.
     */
    public static String[] m_rgFieldNames = {
        BookingDetail.DESCRIPTION,
        BookingDetail.DETAIL_DATE,
        BookingDetail.CLASS_ID,

        BookingDetail.TOTAL_PRICE_LOCAL,
//        Currencys.CURRENCYS_FILE + '.' + Currencys.DESCRIPTION,
    };
}
