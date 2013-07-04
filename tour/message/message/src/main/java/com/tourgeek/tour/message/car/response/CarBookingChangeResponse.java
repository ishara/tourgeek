
package com.tourgeek.tour.message.car.response;

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
import com.tourgeek.tour.message.car.request.*;
import org.jbundle.main.msg.db.*;
import com.tourgeek.tour.message.base.request.data.*;
import org.jbundle.model.message.*;
import com.tourgeek.model.tour.booking.detail.db.*;
import com.tourgeek.tour.message.base.request.*;
import org.jbundle.thin.base.message.*;
import com.tourgeek.tour.message.car.request.data.*;
import com.tourgeek.model.tour.product.base.db.*;
import org.jbundle.model.main.msg.db.*;

/**
 *  CarBookingChangeResponse - .
 */
public class CarBookingChangeResponse extends CarBookingResponse
{
    /**
     * Default constructor.
     */
    public CarBookingChangeResponse()
    {
        super();
    }
    /**
     * CarBookingChangeResponse Method.
     */
    public CarBookingChangeResponse(MessageDataParent messageDataParent, String strKey)
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

}
