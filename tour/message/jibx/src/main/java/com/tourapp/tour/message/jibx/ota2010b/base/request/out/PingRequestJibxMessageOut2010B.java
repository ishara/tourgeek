/**
 * @(#)PingRequestJibxMessageOut2010B.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.message.jibx.ota2010b.base.request.out;

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
import org.jibx.schema.org.opentravel._2010B.ping.*;
import org.jibx.schema.org.opentravel._2010B.base.*;
import org.joda.time.*;
import com.tourapp.tour.message.base.request.in.*;
import org.jbundle.base.message.trx.message.external.*;
import org.jbundle.thin.base.message.*;

/**
 *  PingRequestJibxMessageOut2010B - .
 */
public class PingRequestJibxMessageOut2010B extends BaseJibxMessageOut2010B
{
    /**
     * Default constructor.
     */
    public PingRequestJibxMessageOut2010B()
    {
        super();
    }
    /**
     * This is the base class for a transaction which is sent externally.
     * The two main sub-classes of this class are InternalTrxMessage and ExternalTrxMessage.
     * An InternalTrxMessage is the data I create internally to send to the destination. It
     * usually contains all the relative information needed to send to the destination.
     * An ExternalTrxMessage is the message converted to a format that the receiver can
     * understand (such as ebXML).
     */
    public PingRequestJibxMessageOut2010B(ExternalTrxMessageOut message)
    {
        this();
        this.init(message);
    }
    /**
     * Initialize class fields.
     */
    public void init(ExternalTrxMessageOut message)
    {
        super.init(message);
    }
    /**
     * Convert this source message to the ECXML format.
     * Typically you do not override this method, you override the getTransformer method
     * to supply a XSLT document to do the conversion.
     * @param recordOwner TODO
     * @param source The source XML document.
     * @return The XML tree that conforms to the ECXML format.
     */
    public Object convertInternalToMarshallableObject(RecordOwner recordOwner)
    {
        BaseMessage message = this.getMessage();
        String strMessage = message.getString(PingRequestMessageInProcessor.MESSAGE_PARAM);
            
        PingRQ root = new PingRQ();
        root.setEchoData(strMessage);
        
        OTAPayloadStdAttributes payloadStdAttributes = new OTAPayloadStdAttributes();
        this.setPayloadProperties(message, payloadStdAttributes);
        root.setPayloadStdAttributes(payloadStdAttributes);
        
        return root;
    }

}
