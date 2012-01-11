/**
 * @(#)BookingCar.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.booking.detail.db;

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
import com.tourapp.tour.booking.entry.detail.car.*;
import org.jbundle.base.db.shared.*;
import java.util.*;
import com.tourapp.tour.product.tour.detail.db.*;
import com.tourapp.tour.message.car.response.in.*;
import com.tourapp.tour.booking.detail.event.*;
import com.tourapp.tour.booking.db.*;
import com.tourapp.tour.product.tour.db.*;
import com.tourapp.tour.product.base.db.*;
import com.tourapp.tour.product.car.db.*;
import com.tourapp.tour.acctpay.db.*;
import com.tourapp.tour.base.db.*;
import org.jbundle.main.msg.db.*;

/**
 *  BookingCar - Rental car detail.
 */
public class BookingCar extends BookingDetail
{
    private static final long serialVersionUID = 1L;
    public static final String DAYS = "Days";
    public static final String QUANTITY = "Quantity";

    //public static final int kID = kID;
    //public static final int kBookingID = kBookingID;
    //public static final int kBookingPaxID = kBookingPaxID;
    //public static final int kModuleID = kModuleID;
    //public static final int kTourHeaderDetailID = kTourHeaderDetailID;
    //public static final int kTourHeaderOptionID = kTourHeaderOptionID;
    //public static final int kDescription = kDescription;
    //public static final int kProductType = kProductType;
    //public static final int kProductTypeID = kProductTypeID;
    //public static final int kDetailDate = kDetailDate;
    //public static final int kGMTDate = kGMTDate;
    //public static final int kGMTOffset = kGMTOffset;
    //public static final int kProductID = kProductID;
    //public static final int kRateID = kRateID;
    //public static final int kClassID = kClassID;
    //public static final int kMarkupFromLast = kMarkupFromLast;
    //public static final int kVendorID = kVendorID;
    //public static final int kTourID = kTourID;
    //public static final int kApTrxID = kApTrxID;
    //public static final int kPricingDetailKey = kPricingDetailKey;
    //public static final int kTotalCost = kTotalCost;
    //public static final int kExchange = kExchange;
    //public static final int kCurrencyCode = kCurrencyCode;
    //public static final int kTotalCostLocal = kTotalCostLocal;
    //public static final int kTotalPriceLocal = kTotalPriceLocal;
    //public static final int kInfoMessageTransportID = kInfoMessageTransportID;
    //public static final int kInfoStatusID = kInfoStatusID;
    //public static final int kInfoRequestKey = kInfoRequestKey;
    //public static final int kInfoStatusRequest = kInfoStatusRequest;
    //public static final int kCostMessageTransportID = kCostMessageTransportID;
    //public static final int kCostStatusID = kCostStatusID;
    //public static final int kCostRequestKey = kCostRequestKey;
    //public static final int kCostStatusRequest = kCostStatusRequest;
    //public static final int kInventoryMessageTransportID = kInventoryMessageTransportID;
    //public static final int kInventoryStatusID = kInventoryStatusID;
    //public static final int kInventoryRequestKey = kInventoryRequestKey;
    //public static final int kInventoryStatusRequest = kInventoryStatusRequest;
    //public static final int kProductMessageTransportID = kProductMessageTransportID;
    //public static final int kProductStatusID = kProductStatusID;
    //public static final int kProductRequestKey = kProductRequestKey;
    //public static final int kProductStatusRequest = kProductStatusRequest;
    //public static final int kRemoteBookingNo = kRemoteBookingNo;
    //public static final int kAckDays = kAckDays;
    //public static final int kLastChanged = kLastChanged;
    //public static final int kDeleted = kDeleted;
    //public static final int kDetailEndDate = kDetailEndDate;
    //public static final int kGMTEndDate = kGMTEndDate;
    //public static final int kMealSummary = kMealSummary;
    //public static final int kStatusSummary = kStatusSummary;
    //public static final int kItineraryDesc = kItineraryDesc;
    //public static final int kProperties = kProperties;
    //public static final int kErrorProperties = kErrorProperties;
    //public static final int kPPCost = kPPCost;
    //public static final int kPPPriceLocal = kPPPriceLocal;
    //public static final int kNights = kNights;
    //public static final int kMealPlan1ID = kMealPlan1ID;
    //public static final int kMealPlan1Qty = kMealPlan1Qty;
    //public static final int kMealPlan1Days = kMealPlan1Days;
    //public static final int kMealPlan2ID = kMealPlan2ID;
    //public static final int kMealPlan2Qty = kMealPlan2Qty;
    //public static final int kMealPlan2Days = kMealPlan2Days;
    //public static final int kMealPlan3ID = kMealPlan3ID;
    //public static final int kMealPlan3Qty = kMealPlan3Qty;
    //public static final int kMealPlan3Days = kMealPlan3Days;
    //public static final int kMealPlan4ID = kMealPlan4ID;
    //public static final int kMealPlan4Qty = kMealPlan4Qty;
    //public static final int kMealPlan4Days = kMealPlan4Days;
    //public static final int kSinglePax = kSinglePax;
    //public static final int kDoublePax = kDoublePax;
    //public static final int kTriplePax = kTriplePax;
    //public static final int kQuadPax = kQuadPax;
    //public static final int kChildren = kChildren;
    //public static final int kSingleCost = kSingleCost;
    //public static final int kDoubleCost = kDoubleCost;
    //public static final int kTripleCost = kTripleCost;
    //public static final int kQuadCost = kQuadCost;
    //public static final int kChildrenCost = kChildrenCost;
    //public static final int kRoomCost = kRoomCost;
    //public static final int kMealCost = kMealCost;
    //public static final int kRoomCostLocal = kRoomCostLocal;
    //public static final int kMealCostLocal = kMealCostLocal;
    //public static final int kVariesCode = kVariesCode;
    //public static final int kVariesQty = kVariesQty;
    //public static final int kVariesCost = kVariesCost;
    //public static final int kPMCCutoff = kPMCCutoff;
    //public static final int kPMCCost = kPMCCost;
    //public static final int kSICCost = kSICCost;
    //public static final int kBookingAirHeaderID = kBookingAirHeaderID;
    //public static final int kGMTTime = kGMTTime;
    //public static final int kEtd = kEtd;
    //public static final int kXO = kXO;
    //public static final int kCityCode = kCityCode;
    //public static final int kCityDesc = kCityDesc;
    //public static final int kAirlineID = kAirlineID;
    //public static final int kCarrier = kCarrier;
    //public static final int kFlightNo = kFlightNo;
    //public static final int kFlightClass = kFlightClass;
    //public static final int kToCityCode = kToCityCode;
    //public static final int kToCityDesc = kToCityDesc;
    //public static final int kArriveTime = kArriveTime;
    //public static final int kAddDays = kAddDays;
    //public static final int kARCStatus = kARCStatus;
    //public static final int kFareBasis = kFareBasis;
    //public static final int kStartDate = kStartDate;
    //public static final int kEndDate = kEndDate;
    //public static final int kAllow = kAllow;
    //public static final int kDetFare = kDetFare;
    //public static final int kSegmentConfNo = kSegmentConfNo;
    //public static final int kSegmentConfirmedBy = kSegmentConfirmedBy;
    //public static final int kCoupon = kCoupon;
    //public static final int kSeat = kSeat;
    //public static final int kGate = kGate;
    //public static final int kSeatPref = kSeatPref;
    //public static final int kSmoking = kSmoking;
    //public static final int kMeals = kMeals;
    //public static final int kDays = kDays;
    //public static final int kQuantity = kQuantity;
    //public static final int kAskForAnswer = kAskForAnswer;
    //public static final int kAlwaysResolve = kAlwaysResolve;
    //public static final int kPricingTypeID = kPricingTypeID;
    public static final int kBookingCarLastField = kBookingDetailLastField;
    public static final int kBookingCarFields = kBookingDetailLastField - DBConstants.MAIN_FIELD + 1;
    /**
     * Default constructor.
     */
    public BookingCar()
    {
        super();
    }
    /**
     * Constructor.
     */
    public BookingCar(RecordOwner screen)
    {
        this();
        this.init(screen);
    }
    /**
     * Initialize class fields.
     */
    public void init(RecordOwner screen)
    {
        super.init(screen);
    }

    public static final String kBookingCarFile = "BookingDetail";
    /**
     * Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? Record.formatTableNames(kBookingCarFile, bAddQuotes) : super.getTableNames(bAddQuotes);
    }
    /**
     * Get the name of a single record.
     */
    public String getRecordName()
    {
        return "Rental Car detail";
    }
    /**
     * Get the Database Name.
     */
    public String getDatabaseName()
    {
        return "booking";
    }
    /**
     * Is this a local (vs remote) file?.
     */
    public int getDatabaseType()
    {
        return DBConstants.REMOTE | DBConstants.SHARED_TABLE | DBConstants.USER_DATA;
    }
    /**
     * Make a default screen.
     */
    public BaseScreen makeScreen(ScreenLocation itsLocation, BasePanel parentScreen, int iDocMode, Map<String,Object> properties)
    {
        BaseScreen screen = null;
        if ((iDocMode & ScreenConstants.MAINT_MODE) != 0)
            screen = new BookingCarScreen(this, itsLocation, parentScreen, null, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties);
        else if ((iDocMode & ScreenConstants.DISPLAY_MODE) != 0)
            screen = new BookingCarGridScreen(this, itsLocation, parentScreen, null, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties);
        else
            screen = super.makeScreen(itsLocation, parentScreen, iDocMode, properties);
        return screen;
    }
    /**
     * Add this field in the Record's field sequence.
     */
    public BaseField setupField(int iFieldSeq)
    {
        BaseField field = null;
        //if (iFieldSeq == kID)
        //{
        //  field = new CounterField(this, "ID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.setHidden(true);
        //}
        if (iFieldSeq == kBookingID)
        {
            field = new BookingField(this, "BookingID", Constants.DEFAULT_FIELD_LENGTH, null, null);
            field.setNullable(false);
        }
        //if (iFieldSeq == kBookingPaxID)
        //  field = new BookingPaxField(this, "BookingPaxID", Constants.DEFAULT_FIELD_LENGTH, null, new Integer(0));
        //if (iFieldSeq == kModuleID)
        //  field = new TourHeaderField(this, "ModuleID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kTourHeaderDetailID)
        //  field = new TourHeaderDetailField(this, "TourHeaderDetailID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kTourHeaderOptionID)
        //  field = new TourHeaderOptionField(this, "TourHeaderOptionID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kDescription)
        //  field = new StringField(this, "Description", 60, null, null);
        if (iFieldSeq == kProductType)
        {
            field = new StringField(this, "ProductType", 15, null, null);
            field.setVirtual(true);
        }
        //if (iFieldSeq == kProductTypeID)
        //  field = new ProductTypeField(this, "ProductTypeID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kDetailDate)
        //{
        //  field = new DateTimeField(this, "DetailDate", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.addListener(new InitOnceFieldHandler(null));
        //}
        //if (iFieldSeq == kGMTDate)
        //{
        //  field = new DateTimeField(this, "GMTDate", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.addListener(new InitOnceFieldHandler(null));
        //}
        //if (iFieldSeq == kGMTOffset)
        //  field = new DoubleField(this, "GMTOffset", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kProductID)
            field = new CarField(this, "ProductID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kRateID)
            field = new CarRateSelect(this, "RateID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kClassID)
            field = new CarClassSelect(this, "ClassID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kMarkupFromLast)
        //  field = new PercentField(this, "MarkupFromLast", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kVendorID)
        //  field = new VendorField(this, "VendorID", 8, null, null);
        //if (iFieldSeq == kTourID)
        //  field = new TourField(this, "TourID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kApTrxID)
        //  field = new ApTrxField(this, "ApTrxID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kPricingDetailKey)
        //  field = new StringField(this, "PricingDetailKey", 128, null, null);
        //if (iFieldSeq == kTotalCost)
        //  field = new FullCurrencyField(this, "TotalCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kExchange)
        //  field = new RealField(this, "Exchange", 10, null, new Double(1.0));
        if (iFieldSeq == kCurrencyCode)
        {
            field = new StringField(this, "CurrencyCode", 3, null, null);
            field.setVirtual(true);
        }
        //if (iFieldSeq == kTotalCostLocal)
        //  field = new CurrencyField(this, "TotalCostLocal", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kTotalPriceLocal)
        //  field = new CurrencyField(this, "TotalPriceLocal", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kInfoMessageTransportID)
        //  field = new MessageTransportSelect(this, "InfoMessageTransportID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kInfoStatusID)
        //  field = new InfoStatusSelect(this, "InfoStatusID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kInfoRequestKey)
        //  field = new StringField(this, "InfoRequestKey", 128, null, null);
        if (iFieldSeq == kInfoStatusRequest)
        {
            field = new BooleanField(this, "InfoStatusRequest", Constants.DEFAULT_FIELD_LENGTH, null, null);
            field.setVirtual(true);
        }
        //if (iFieldSeq == kCostMessageTransportID)
        //  field = new MessageTransportSelect(this, "CostMessageTransportID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kCostStatusID)
        //  field = new CostStatusSelect(this, "CostStatusID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kCostRequestKey)
        //  field = new StringField(this, "CostRequestKey", 128, null, null);
        if (iFieldSeq == kCostStatusRequest)
        {
            field = new BooleanField(this, "CostStatusRequest", Constants.DEFAULT_FIELD_LENGTH, null, null);
            field.setVirtual(true);
        }
        //if (iFieldSeq == kInventoryMessageTransportID)
        //  field = new MessageTransportSelect(this, "InventoryMessageTransportID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kInventoryStatusID)
        //  field = new InventoryStatusSelect(this, "InventoryStatusID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kInventoryRequestKey)
        //  field = new StringField(this, "InventoryRequestKey", 128, null, null);
        if (iFieldSeq == kInventoryStatusRequest)
        {
            field = new BooleanField(this, "InventoryStatusRequest", Constants.DEFAULT_FIELD_LENGTH, null, null);
            field.setVirtual(true);
        }
        //if (iFieldSeq == kProductMessageTransportID)
        //  field = new MessageTransportSelect(this, "ProductMessageTransportID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kProductStatusID)
        //  field = new ProductStatusSelect(this, "ProductStatusID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kProductRequestKey)
        //  field = new StringField(this, "ProductRequestKey", 128, null, null);
        if (iFieldSeq == kProductStatusRequest)
        {
            field = new BooleanField(this, "ProductStatusRequest", Constants.DEFAULT_FIELD_LENGTH, null, null);
            field.setVirtual(true);
        }
        //if (iFieldSeq == kRemoteBookingNo)
        //  field = new StringField(this, "RemoteBookingNo", 127, null, null);
        //if (iFieldSeq == kAckDays)
        //  field = new ShortField(this, "AckDays", 4, null, null);
        //if (iFieldSeq == kLastChanged)
        //{
        //  field = new RecordChangedField(this, "LastChanged", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.setHidden(true);
        //}
        //if (iFieldSeq == kDeleted)
        //{
        //  field = new BooleanField(this, "Deleted", Constants.DEFAULT_FIELD_LENGTH, null, new Boolean(false));
        //  field.setHidden(true);
        //}
        //if (iFieldSeq == kDetailEndDate)
        //  field = new DateTimeField(this, "DetailEndDate", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kGMTEndDate)
        //  field = new DateTimeField(this, "GMTEndDate", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kMealSummary)
        {
            field = new StringField(this, "MealSummary", 255, null, null);
            field.setVirtual(true);
        }
        if (iFieldSeq == kStatusSummary)
        {
            field = new StatusSummaryField(this, "StatusSummary", 20, null, null);
            field.setVirtual(true);
        }
        //if (iFieldSeq == kItineraryDesc)
        //  field = new XmlField(this, "ItineraryDesc", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kProperties)
        //  field = new PropertiesField(this, "Properties", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kErrorProperties)
        //  field = new PropertiesField(this, "ErrorProperties", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kPPCost)
        //  field = new FullCurrencyField(this, "PPCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == kPPPriceLocal)
        //  field = new CurrencyField(this, "PPPriceLocal", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kNights)
            field = new UnusedField(this, "Nights", 2, null, null);
        if (iFieldSeq == kMealPlan1ID)
            field = new UnusedField(this, "MealPlan1ID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kMealPlan1Qty)
            field = new UnusedField(this, "MealPlan1Qty", 2, null, null);
        if (iFieldSeq == kMealPlan1Days)
            field = new UnusedField(this, "MealPlan1Days", 9, null, null);
        if (iFieldSeq == kMealPlan2ID)
            field = new UnusedField(this, "MealPlan2ID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kMealPlan2Qty)
            field = new UnusedField(this, "MealPlan2Qty", 2, null, null);
        if (iFieldSeq == kMealPlan2Days)
            field = new UnusedField(this, "MealPlan2Days", 9, null, null);
        if (iFieldSeq == kMealPlan3ID)
            field = new UnusedField(this, "MealPlan3ID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kMealPlan3Qty)
            field = new UnusedField(this, "MealPlan3Qty", 2, null, null);
        if (iFieldSeq == kMealPlan3Days)
            field = new UnusedField(this, "MealPlan3Days", 9, null, null);
        if (iFieldSeq == kMealPlan4ID)
            field = new UnusedField(this, "MealPlan4ID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kMealPlan4Qty)
            field = new UnusedField(this, "MealPlan4Qty", 2, null, null);
        if (iFieldSeq == kMealPlan4Days)
            field = new UnusedField(this, "MealPlan4Days", 9, null, null);
        if (iFieldSeq == kSinglePax)
        {
            field = new UnusedField(this, "SinglePax", 4, null, null);
            field.setVirtual(true);
        }
        if (iFieldSeq == kDoublePax)
        {
            field = new UnusedField(this, "DoublePax", 2, null, null);
            field.setVirtual(true);
        }
        if (iFieldSeq == kTriplePax)
        {
            field = new UnusedField(this, "TriplePax", 2, null, null);
            field.setVirtual(true);
        }
        if (iFieldSeq == kQuadPax)
        {
            field = new UnusedField(this, "QuadPax", 2, null, null);
            field.setVirtual(true);
        }
        if (iFieldSeq == kChildren)
            field = new UnusedField(this, "Children", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kSingleCost)
            field = new UnusedField(this, "SingleCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kDoubleCost)
            field = new UnusedField(this, "DoubleCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kTripleCost)
            field = new UnusedField(this, "TripleCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kQuadCost)
            field = new UnusedField(this, "QuadCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kChildrenCost)
            field = new UnusedField(this, "ChildrenCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kRoomCost)
            field = new UnusedField(this, "RoomCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kMealCost)
            field = new UnusedField(this, "MealCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kRoomCostLocal)
        {
            field = new UnusedField(this, "RoomCostLocal", Constants.DEFAULT_FIELD_LENGTH, null, null);
            field.setVirtual(true);
        }
        if (iFieldSeq == kMealCostLocal)
        {
            field = new UnusedField(this, "MealCostLocal", Constants.DEFAULT_FIELD_LENGTH, null, null);
            field.setVirtual(true);
        }
        if (iFieldSeq == kVariesCode)
            field = new UnusedField(this, "VariesCode", 1, null, null);
        if (iFieldSeq == kVariesQty)
            field = new UnusedField(this, "VariesQty", 2, null, null);
        if (iFieldSeq == kVariesCost)
            field = new UnusedField(this, "VariesCost", 9, null, null);
        if (iFieldSeq == kPMCCutoff)
            field = new UnusedField(this, "PMCCutoff", 3, null, null);
        if (iFieldSeq == kPMCCost)
            field = new UnusedField(this, "PMCCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kSICCost)
            field = new UnusedField(this, "SICCost", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kBookingAirHeaderID)
            field = new UnusedField(this, "BookingAirHeaderID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kGMTTime)
            field = new UnusedField(this, "GMTTime", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kEtd)
            field = new UnusedField(this, "Etd", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kXO)
            field = new UnusedField(this, "XO", 1, null, null);
        if (iFieldSeq == kCityCode)
            field = new UnusedField(this, "CityCode", 3, null, null);
        if (iFieldSeq == kCityDesc)
            field = new UnusedField(this, "CityDesc", 17, null, null);
        if (iFieldSeq == kAirlineID)
            field = new UnusedField(this, "AirlineID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kCarrier)
            field = new UnusedField(this, "Carrier", 2, null, null);
        if (iFieldSeq == kFlightNo)
            field = new UnusedField(this, "FlightNo", 4, null, null);
        if (iFieldSeq == kFlightClass)
            field = new UnusedField(this, "FlightClass", 1, null, null);
        if (iFieldSeq == kToCityCode)
            field = new UnusedField(this, "ToCityCode", 3, null, null);
        if (iFieldSeq == kToCityDesc)
            field = new UnusedField(this, "ToCityDesc", 17, null, null);
        if (iFieldSeq == kArriveTime)
            field = new UnusedField(this, "ArriveTime", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kAddDays)
            field = new UnusedField(this, "AddDays", 2, null, null);
        if (iFieldSeq == kARCStatus)
            field = new UnusedField(this, "ARCStatus", 2, null, null);
        if (iFieldSeq == kFareBasis)
            field = new UnusedField(this, "FareBasis", 15, null, null);
        if (iFieldSeq == kStartDate)
            field = new UnusedField(this, "StartDate", 5, null, null);
        if (iFieldSeq == kEndDate)
            field = new UnusedField(this, "EndDate", 5, null, null);
        if (iFieldSeq == kAllow)
            field = new UnusedField(this, "Allow", 3, null, null);
        if (iFieldSeq == kDetFare)
            field = new UnusedField(this, "DetFare", 10, null, null);
        if (iFieldSeq == kSegmentConfNo)
            field = new UnusedField(this, "SegmentConfNo", 128, null, null);
        if (iFieldSeq == kSegmentConfirmedBy)
            field = new UnusedField(this, "SegmentConfirmedBy", 50, null, null);
        if (iFieldSeq == kCoupon)
            field = new UnusedField(this, "Coupon", 1, null, null);
        if (iFieldSeq == kSeat)
            field = new UnusedField(this, "Seat", 5, null, null);
        if (iFieldSeq == kGate)
            field = new UnusedField(this, "Gate", 5, null, null);
        if (iFieldSeq == kSeatPref)
            field = new UnusedField(this, "SeatPref", 1, null, null);
        if (iFieldSeq == kSmoking)
            field = new UnusedField(this, "Smoking", 1, null, null);
        if (iFieldSeq == kMeals)
            field = new UnusedField(this, "Meals", 2, null, null);
        if (iFieldSeq == kDays)
        {
            field = new FloatField(this, "Days", Constants.DEFAULT_FIELD_LENGTH, null, new Float(1));
            field.addListener(new InitOnceFieldHandler(null));
        }
        if (iFieldSeq == kQuantity)
        {
            field = new ShortField(this, "Quantity", Constants.DEFAULT_FIELD_LENGTH, null, new Short((short)1));
            field.addListener(new InitOnceFieldHandler(null));
        }
        if (iFieldSeq == kAskForAnswer)
            field = new UnusedField(this, "AskForAnswer", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == kAlwaysResolve)
        {
            field = new UnusedField(this, "AlwaysResolve", Constants.DEFAULT_FIELD_LENGTH, null, null);
            field.setVirtual(true);
        }
        if (iFieldSeq == kPricingTypeID)
            field = new UnusedField(this, "PricingTypeID", Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (field == null)
        {
            field = super.setupField(iFieldSeq);
            if (field == null) if (iFieldSeq < kBookingCarLastField)
                field = new EmptyField(this);
        }
        return field;
    }
    /**
     * Add all standard file & field behaviors.
     * Override this to add record listeners and filters.
     */
    public void addListeners()
    {
        super.addListeners();
        
        this.addListener(new SharedFileHandler(BookingDetail.kProductTypeID, ProductType.CAR_ID));
    }
    /**
     * Add the listeners to do the price and inventory lookups.
     * Typically these are only done in the concrete classes.
     */
    public void addLookupListeners()
    {
        super.addLookupListeners();
        
        Boolean boolRequestRequiredFlag = Boolean.TRUE;
        String strManualTransportID = Integer.toString(((ReferenceField)this.getField(BookingDetail.kCostMessageTransportID)).getIDFromCode(MessageTransport.MANUAL));
        Converter converterNotInfoManualTransport = new CheckConverter(this.getField(BookingDetail.kInfoMessageTransportID), strManualTransportID, null, false);
        Converter converterNotCostManualTransport = new CheckConverter(this.getField(BookingDetail.kCostMessageTransportID), strManualTransportID, null, false);
        Converter converterNotInventoryManualTransport = new CheckConverter(this.getField(BookingDetail.kInventoryMessageTransportID), strManualTransportID, null, false);
        Converter converterNotProductManualTransport = new CheckConverter(this.getField(BookingDetail.kProductMessageTransportID), strManualTransportID, null, false);
        
        FieldListener dependentStateListener = this.getField(BookingDetail.kProductID).getListener(CopyDataHandler.class);
        FieldListener fieldListener = null;
        this.getField(BookingCar.kDays).addListener(fieldListener = new CalcCarReturnDate(null));
        fieldListener.setDependentStateListener(dependentStateListener);
        
        // If any of these values change, you will have to re-lookup the price.
        this.getField(BookingCar.kDays).addListener(fieldListener = new CopyDataHandler(this.getField(BookingDetail.kInfoStatusRequest), boolRequestRequiredFlag, converterNotInfoManualTransport));
        fieldListener.setDependentStateListener(dependentStateListener);
        this.getField(BookingCar.kDays).addListener(fieldListener = new CopyDataHandler(this.getField(BookingDetail.kCostStatusRequest), boolRequestRequiredFlag, converterNotCostManualTransport));
        fieldListener.setDependentStateListener(dependentStateListener);
        this.getField(BookingCar.kDays).addListener(fieldListener = new CopyDataHandler(this.getField(BookingDetail.kInventoryStatusRequest), boolRequestRequiredFlag, converterNotInventoryManualTransport));
        fieldListener.setDependentStateListener(dependentStateListener);
        // If this changes, re-request the booking
        this.getField(BookingCar.kDays).addListener(fieldListener = new CopyDataHandler(this.getField(BookingDetail.kProductStatusRequest), boolRequestRequiredFlag, converterNotProductManualTransport));
        fieldListener.setDependentStateListener(dependentStateListener);
        
        // If any of these values change, you will have to re-lookup the price.
        this.getField(BookingCar.kQuantity).addListener(fieldListener = new CopyDataHandler(this.getField(BookingDetail.kInfoStatusRequest), boolRequestRequiredFlag, converterNotInfoManualTransport));
        fieldListener.setDependentStateListener(dependentStateListener);
        this.getField(BookingCar.kQuantity).addListener(fieldListener = new CopyDataHandler(this.getField(BookingDetail.kCostStatusRequest), boolRequestRequiredFlag, converterNotCostManualTransport));
        fieldListener.setDependentStateListener(dependentStateListener);
        this.getField(BookingCar.kQuantity).addListener(fieldListener = new CopyDataHandler(this.getField(BookingDetail.kInventoryStatusRequest), boolRequestRequiredFlag, converterNotInventoryManualTransport));
        fieldListener.setDependentStateListener(dependentStateListener);
        // If this changes, re-request the booking
        this.getField(BookingCar.kQuantity).addListener(fieldListener = new CopyDataHandler(this.getField(BookingDetail.kProductStatusRequest), boolRequestRequiredFlag, converterNotProductManualTransport));
        fieldListener.setDependentStateListener(dependentStateListener);
    }
    /**
     * SetupEndDate Method.
     */
    public Date setupEndDate()
    {
        Date dateStart = this.getStartDate();
        if (dateStart == null)
            return dateStart;
        float fDays = (float)this.getField(BookingCar.kDays).getValue();
        Date dateEnd = new Date(dateStart.getTime() + (long)(fDays * DBConstants.KMS_IN_A_DAY));
        Calendar calendar = DateTimeField.m_calendar;
        
        calendar.setTime(dateEnd);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        dateEnd = calendar.getTime();
        return dateEnd;
    }
    /**
     * Set the ending time for this tour product.
     * Then, return the actual ending date that was set.
     */
    public Date setEndDate(Date time)
    {
        // First get the number of nights
        Calendar startDate = ((DateTimeField)this.getField(BookingCar.kDetailDate)).getCalendar();
        if (startDate != null)
        {
            boolean[] rgbEnabled = this.getField(BookingHotel.kDetailEndDate).setEnableListeners(false);  // No echos
        
            startDate.set(Calendar.SECOND, 0);
            startDate.set(Calendar.MILLISECOND, 0);
            long lStartDate = startDate.getTime().getTime();
            startDate.setTime(time);
            startDate.set(Calendar.SECOND, 0);
            startDate.set(Calendar.MILLISECOND, 0);
            long lEndDate = startDate.getTime().getTime();
            float fDays = (float)((lEndDate - lStartDate) / DBConstants.KMS_IN_A_DAY);
        
            if (fDays > 0)
            {
                float fOldDays = (float)this.getField(BookingCar.kDays).getValue();
                int iErrorCode = this.getField(BookingCar.kDays).setValue(fDays);
            }
        
            this.getField(BookingHotel.kDetailEndDate).setEnableListeners(rgbEnabled);  // Restore state
        }
        return this.getEndDate();
    }
    /**
     * From the current detail and product info,
     * setup the product description.
     * @return The product description (using the product).
     */
    public String setupProductDesc()
    {
        String string = super.setupProductDesc();
        if (string != null)
            if (string.length() > 0)
                if (!this.getField(BookingCar.kDays).isNull())
        {
            string += " - ";
            String tempString = this.getField(BookingCar.kDays).toString();
            int i = 0;
            for (i = tempString.length() - 1; i >= 0; i--)
            {
                if (tempString.charAt(i) == '0')
                    tempString = tempString.substring(0, i);
                else
                    break;
            }
            if (tempString.charAt(i) == '.')
                tempString = tempString.substring(0, i);
            string += tempString;
            string += " day";
            if (this.getField(BookingCar.kDays).getValue() != 1)
                string += "s";
        }
        return string;
    }
    /**
     * When a new record is set up and you have the booking and tour
     * records, init the detail fields.
     */
    public int initBookingDetailFields(Booking recBooking, Tour recTour, boolean bOnlyIfTargetIsNull)
    {
        int iErrorCode = super.initBookingDetailFields(recBooking, recTour, bOnlyIfTargetIsNull);
        if ((!bOnlyIfTargetIsNull) || (this.getField(BookingCar.kDays).isNull()))
            this.getField(BookingCar.kDays).setValue(1, DBConstants.DISPLAY, DBConstants.INIT_MOVE);
        if ((!bOnlyIfTargetIsNull) || (this.getField(BookingCar.kRateID).isNull()))
            this.getField(BookingCar.kRateID).moveFieldToThis(recTour.getField(Tour.kCarRateID), DBConstants.DISPLAY, DBConstants.INIT_MOVE);
        if ((!bOnlyIfTargetIsNull) || (this.getField(BookingCar.kClassID).isNull()))
            this.getField(BookingCar.kClassID).moveFieldToThis(recTour.getField(Tour.kCarClassID), DBConstants.DISPLAY, DBConstants.INIT_MOVE);
        return iErrorCode;
    }
    /**
     * Move from the tour header record to this record.
     * NOTE: Be careful as the TourHeaderDetail record can be null (so fields that depend on Tour can be set).
     * @param recTourHeaderDetail The tour header record.
     * @return An error code.
     */
    public int moveTourHeaderFields(TourSub recTourHeaderDetail, Tour recTour)
    {
        int iErrorCode = super.moveTourHeaderFields(recTourHeaderDetail, recTour);
        if (recTourHeaderDetail != null)
        {
            this.getField(BookingCar.kDays).moveFieldToThis(recTourHeaderDetail.getField(TourHeaderCar.kDays));
            if (recTourHeaderDetail.getField(TourHeaderCar.kDays).getLength() != 0)
                this.getField(BookingCar.kDays).moveFieldToThis(recTourHeaderDetail.getField(TourHeaderCar.kDays));
        }
        return iErrorCode;
    }
    /**
     * SetDetailProductProperties Method.
     */
    public int setDetailProductProperties(Map<String,Object> properties)
    {
        int iErrorCode = super.setDetailProductProperties(properties);
        if (iErrorCode != DBConstants.NORMAL_RETURN)
            return iErrorCode;
        float fDays = ((Float)Utility.getAs(properties, BookingCar.DAYS, Float.class, FloatField.ZERO)).intValue();
        int iRateTypeID = ((Integer)Utility.getAs(properties, BookingCar.RATE_ID, Integer.class, IntegerField.ZERO)).intValue();
        int iRateClassID = ((Integer)Utility.getAs(properties, BookingCar.CLASS_ID, Integer.class, IntegerField.ZERO)).intValue();
        if ((this.getField(BookingCar.kDays).getValue() == 0) || (fDays > 0))
        {
            if (fDays == 0)
                fDays = 1;
            this.getField(BookingCar.kDays).setValue(fDays);
        }
        Record recBooking = null;
        if (!this.getField(BookingDetail.kBookingID).isNull())
            recBooking = ((ReferenceField)this.getField(BookingDetail.kBookingID)).getReference();
        Record recTour = null;
        if (recBooking != null)
            recTour = ((ReferenceField)recBooking.getField(Booking.kTourID)).getReference();
        if ((this.getField(BookingCar.kRateID).getValue() == 0) || (iRateTypeID != 0))
        {
            if (iRateTypeID == 0)
                if (recTour != null)
                    iRateTypeID = (int)recTour.getField(Tour.kCarRateID).getValue();
        if (iRateTypeID != 0)
            this.getField(BookingCar.kRateID).setValue(iRateTypeID);
        }
        if ((this.getField(BookingCar.kClassID).getValue() == 0) || (iRateClassID != 0))
        {
            if (iRateClassID == 0)
                if (recTour != null)
                    iRateClassID = (int)recTour.getField(Tour.kCarClassID).getValue();
            if (iRateClassID != 0)
                this.getField(BookingCar.kClassID).setValue(iRateClassID);
        }
        return iErrorCode;
    }
    /**
     * Get the ending icon for this in a calendar.
     */
    public String getEndIcon()
    {
        return this.getStartIcon();
    }
    /**
     * UpdateBookingComponentCostPricing Method.
     */
    public int updateBookingComponentCostPricing(Booking recBooking, int iChangeType)
    {
        int iErrorCode = DBConstants.NORMAL_RETURN;
        
        double dCost = this.getField(BookingDetail.kTotalCostLocal).getValue();
        int iQuantity = (int)this.getField(BookingCar.kQuantity).getValue();
        iErrorCode = this.updateBookingLine(this.getBookingLine(), PricingType.COMPONENT_COST_PRICING, PaxCategory.ALL_ID, iQuantity, dCost, true, recBooking.getField(Booking.kCommission).getValue(), null, PricingStatus.OKAY, iChangeType);
        
        return iErrorCode;
    }
    /**
     * Pre-check to see if the minimal required params are set.
     * @return If okay, return 0, otherwise return the field that is required.
     */
    public int checkRequiredParams(int iStatusType)
    {
        if (iStatusType != BookingDetail.kInfoStatusID)
        {
            if (this.getField(BookingDetail.kRateID).isNull())
                return BookingDetail.kRateID;
            if (this.getField(BookingDetail.kClassID).isNull())
                return BookingDetail.kClassID;
            if (this.getField(BookingCar.kQuantity).isNull())
                return BookingCar.kQuantity;
            if (this.getField(BookingCar.kDays).isNull())
                return BookingCar.kDays;
        }
        return super.checkRequiredParams(iStatusType);
    }

}
