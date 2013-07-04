
package com.tourgeek.model.tour.product.tour.schedule.db;

import org.jbundle.model.db.*;

public interface TourEventModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String DESCRIPTION = "Description";
    public static final String CODE = "Code";
    public static final String BOOKING_OR_TOUR = "BookingOrTour";
    public static final String EVENT_OR_DATE = "EventOrDate";

    public static final String DESCRIPTION_KEY = "Description";

    public static final String CODE_KEY = "Code";
    public static final int NO_EVENT = 0;
    public static final int BOOKING = 1;
    public static final int BOOKING_STATUS = 2;
    public static final int DEPOSIT_DUE = 4;
    public static final int DEPOSIT_RECEIVED = 5;
    public static final int FINAL_PAY_DUE = 6;
    public static final int FINAL_PAYMENT_RECEIVED = 7;
    public static final int FINALIZATION = 8;
    public static final int TOUR_CLOSED = 9;
    public static final int ORDER_COMPONENTS = 10;
    public static final int SERVICES_CONFIRMED = 11;
    public static final int FINAL_DOCS = 12;
    public static final int TICKETING = 13;
    public static final int SPECIAL_1 = 14;
    public static final int SPECIAL_2 = 15;
    public static final int DEPARTURE = 16;
    public static final int CANCELLATION = 17;
    public static final int TOUR_CANCELLED = 18;

    public static final String TOUR_EVENT_FILE = "TourEvent";
    public static final String THIN_CLASS = "com.tourgeek.thin.tour.product.tour.schedule.db.TourEvent";
    public static final String THICK_CLASS = "com.tourgeek.tour.product.tour.schedule.db.TourEvent";

}
