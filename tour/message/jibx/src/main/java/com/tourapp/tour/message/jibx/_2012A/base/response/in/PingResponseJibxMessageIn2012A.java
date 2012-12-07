/**
  * @(#)PingResponseJibxMessageIn2012A.
  * Copyright © 2012 tourapp.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourapp.tour.message.jibx._2012A.base.response.in;

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
import org.jbundle.base.model.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import com.tourapp.tour.message.jibx._2012A.base.request.in.*;
import org.jibx.schema.org.opentravel._2012A.ping.*;
import org.jibx.schema.org.opentravel._2012A.base.*;
import org.jbundle.base.message.trx.message.external.*;
import org.jbundle.thin.base.message.*;
import com.tourapp.tour.message.base.request.in.*;

/**
 *  PingResponseJibxMessageIn2012A - .
 */
public class PingResponseJibxMessageIn2012A extends BaseJibxMessageIn2012A
{
    /**
     * Default constructor.
     */
    public PingResponseJibxMessageIn2012A()
    {
        super();
    }
    /**
     * Initialize new BaseTrxMessage.
     * This is used for outgoing EC transactions where you have the jaxb message and you need to convert it.
     * @param objRawMessage The (optional) raw data of the message.
     */
    public PingResponseJibxMessageIn2012A(ExternalTrxMessageIn message)
    {
        this();
        this.init(message);
    }
    /**
     * Initialize class fields.
     */
    public void init(ExternalTrxMessageIn message)
    {
        super.init(message);
    }
    /**
     * Convert the external form to the internal message form.
     * You must override this method.
     * @param root The root object of the marshallable object.
     * @param recordOwner The recordowner
     * @return The error code.
     */
    public int convertMarshallableObjectToInternal(Object root, RecordOwner recordOwner)
    {
        if (root instanceof PingRS)
        {       // Always
            PingRS msg = (PingRS)root;
            java.util.List<PingRS.Sequence> list = msg.getSuccessList();
            Errors errors = msg.getErrors();
            String messageText = null;
            String errorMessage = null;
            boolean bSuccess = true;    // Who uses this?
            for (PingRS.Sequence data : list)
            {
                Success success = data.getSuccess();
                if (success != null)
                    bSuccess = true;
                messageText = data.getEchoData();
            }
            if (errors != null)
            for (_Error error : errors.getErrorList())
            {
                errorMessage = error.getString();
            }
            
            BaseMessage message = this.getMessage();
            message.put(PingRequestMessageInProcessor.MESSAGE_PARAM, messageText);
            
            OTAPayloadStdAttributes payloadStdAttributes = msg.getPayloadStdAttributes();
            this.addPayloadProperties(payloadStdAttributes, message);
        }
        return DBConstants.NORMAL_RETURN;
    }

}
