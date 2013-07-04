
package com.tourgeek.thin.tour.booking.detail.db;

import com.tourgeek.model.tour.booking.db.*;
import com.tourgeek.model.tour.product.tour.detail.db.*;
import org.jbundle.model.db.*;
import java.util.*;
import org.jbundle.thin.base.util.*;

import org.jbundle.thin.base.db.*;

import com.tourgeek.model.tour.booking.detail.db.*;

public class BookingSub extends FieldList
    implements BookingSubModel
{
    private static final long serialVersionUID = 1L;


    public BookingSub()
    {
        super();
    }
    public BookingSub(Object recordOwner)
    {
        this();
        this.init(recordOwner);
    }
    /**
     * AddDetailBehaviors Method.
     */
    public void addDetailBehaviors(BookingModel recBooking, TourModel recTour)
    {
        // Empty implementation
    }
    /**
     * InitBookingDetailFields Method.
     */
    public int initBookingDetailFields(BookingModel recBooking, TourModel recTour, boolean bOnlyIfTargetIsNull)
    {
        return -1; // Empty implementation
    }
    /**
     * Set-up the current product info.
     * If properties are supplied, look in the properties for new values.
     * Else, if the target values are not already set, use the default values
     * supplied in the tour and booking records.
     */
    public int setDetailProductInfo(Map<String,Object> properties, TourSubModel recTourHeaderDetail, BookingModel recBooking, TourModel recTour, Field fldPaxID, Field fldQaID, Field fldModID)
    {
        return -1; // Empty implementation
    }
    /**
     * Get the main (Booking) record for this detail record.
     * Note: This will only return the main record if it already exists.
     */
    public BookingModel getBooking(boolean bCreateAndReadCurrent)
    {
        return null; // Empty implementation
    }

}
