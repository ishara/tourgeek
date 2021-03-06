/**
  * @(#)HotelRateResponseMessageData.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.tour.message.hotel.response.data;

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
import com.tourgeek.tour.message.base.response.data.*;
import org.jbundle.thin.base.message.*;
import org.jbundle.model.message.*;
import com.tourgeek.model.tour.booking.detail.db.*;
import com.tourgeek.model.tour.product.hotel.db.*;
import com.tourgeek.model.tour.product.base.db.*;

/**
 *  HotelRateResponseMessageData - .
 */
public class HotelRateResponseMessageData extends ProductRateResponseMessageData
{
    /**
     * Default constructor.
     */
    public HotelRateResponseMessageData()
    {
        super();
    }
    /**
     * HotelRateResponseMessageData Method.
     */
    public HotelRateResponseMessageData(MessageDataParent messageDataParent, String strKey)
    {
        this();
        this.init(messageDataParent, strKey);
    }
    /**
     * Initialize class fields.
     */
    public void init(MessageDataParent messageDataParent, String strKey)
    {
        super.init(messageDataParent, strKey);
    }
    /**
     * Setup sub-Message Data.
     */
    public void setupMessageDataDesc()
    {
        super.setupMessageDataDesc();
        this.addMessageFieldDesc(BookingDetailModel.TOTAL_COST, Double.class, MessageFieldDesc.OPTIONAL, null);
        this.addMessageFieldDesc(BookingHotelModel.ROOM_COST, Double.class, MessageFieldDesc.OPTIONAL, null);
        this.addMessageFieldDesc(BookingHotelModel.MEAL_COST, Double.class, MessageFieldDesc.OPTIONAL, null);
    }
    /**
     * Get the data description for this param.
     */
    public MessageDataDesc getMessageDataDesc(String strParam)
    {
        String strParamOrig = strParam;
        if (strParam.startsWith(BookingDetailModel.TOTAL_COST))
            strParam = BookingDetailModel.TOTAL_COST;
        MessageDataDesc messageDataDesc = super.getMessageDataDesc(strParam);
        if (strParamOrig.startsWith(BookingDetailModel.TOTAL_COST))
            messageDataDesc.setKey(strParamOrig);
        return messageDataDesc;
    }
    /**
     * Move the map values to the correct record fields.
     * If this method is used, is must be overidden to move the correct fields.
     */
    public int getRawRecordData(Rec record)
    {
        int iInfoStatus = super.getRawRecordData(record);
        BookingHotelModel recBookingHotel = (BookingHotelModel)record;
        for (int iFieldSeq = ((Record)recBookingHotel).getFieldSeq(BookingHotelModel.SINGLE_COST), iRoomCategory = PaxCategoryModel.SINGLE_ID; iFieldSeq <= ((Record)recBookingHotel).getFieldSeq(BookingHotelModel.QUAD_COST); iFieldSeq++, iRoomCategory++)
        {
            double dRoomCost = this.getRoomCost(iRoomCategory);
            recBookingHotel.getField(iFieldSeq).setValue(dRoomCost);
        }
        this.getRawFieldData(recBookingHotel.getField(BookingHotelModel.ROOM_COST));
        this.getRawFieldData(recBookingHotel.getField(BookingHotelModel.MEAL_COST));
        return iInfoStatus;
    }
    /**
     * SetRoomCost Method.
     */
    public void setRoomCost(int iRoomCategory, double dCost)
    {
        this.put(BookingDetailModel.TOTAL_COST + Integer.toString(iRoomCategory - PaxCategoryModel.SINGLE_ID + 1), new Double(dCost));
    }
    /**
     * SetTotalRoomCost Method.
     */
    public void setTotalRoomCost(double dCost)
    {
        this.put(BookingHotelModel.ROOM_COST, new Double(dCost));
    }
    /**
     * SetTotalMealCost Method.
     */
    public void setTotalMealCost(double dCost)
    {
        this.put(BookingHotelModel.MEAL_COST, new Double(dCost));
    }
    /**
     * GetRoomCost Method.
     */
    public double getRoomCost(int iRoomCategory)
    {
        Double dblRoomCost = (Double)this.get(BookingDetailModel.TOTAL_COST + Integer.toString(iRoomCategory - PaxCategoryModel.SINGLE_ID + 1));
        if (dblRoomCost == null)
            return 0;
        return dblRoomCost.doubleValue();
    }
    /**
     * Get/Create the product record.
     * @param bFindFirst If true, try to lookup the record first.
     * @return The product record.
     */
    public ProductModel getProductRecord(RecordOwner recordOwner, boolean bFindFirst)
    {
        if (bFindFirst)
            if (recordOwner != null)
                if (recordOwner.getRecord(HotelModel.HOTEL_FILE) != null)
                    return (HotelModel)recordOwner.getRecord(HotelModel.HOTEL_FILE);
        return (HotelModel)Record.makeRecordFromClassName(HotelModel.THICK_CLASS, recordOwner);
    }

}
