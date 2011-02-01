/**
 *  @(#)PingResponseJaxbMessageOut2010A.
 *  Copyright © 2010 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.message.jaxb.ota2010a.base.response.out;

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
import org.jbundle.base.message.trx.message.external.convert.jaxb.*;
import net.sourceforge.ota_tools.jaxb.ota2010a.ping.*;
import org.jbundle.thin.base.message.*;
import com.tourapp.tour.message.base.request.in.*;
import com.tourapp.tour.message.base.response.*;
import org.jbundle.base.message.trx.message.external.*;

/**
 *  PingResponseJaxbMessageOut2010A - .
 */
public class PingResponseJaxbMessageOut2010A extends JaxbConvertToNative
{
    /**
     * Default constructor.
     */
    public PingResponseJaxbMessageOut2010A()
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
    public PingResponseJaxbMessageOut2010A(ExternalTrxMessageOut message)
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
        
        ObjectFactory factory = new ObjectFactory();
        OTAPingRS root = factory.createOTAPingRS();
        
        if (strMessage != null)
        {
            SuccessType successType = factory.createSuccessType();
            root.getSuccessAndWarningsAndEchoData().add(successType);
            root.getSuccessAndWarningsAndEchoData().add(strMessage);
        }
        else
        {
            ErrorsType errorsType = factory.createErrorsType();
            root.setErrors(errorsType);
            ErrorType errorType = factory.createErrorType();
            errorsType.getError().add(errorType);
            String strErrorMessage = null;
            if (message.getMessageDataDesc(null) instanceof BaseProductResponse)
            {   // Always
                BaseProductResponse productResponse = (BaseProductResponse)message.getMessageDataDesc(null);
                if (productResponse.getMessageDataStatus() == MessageDataDesc.ERROR)
                {   // Always
                    strErrorMessage = productResponse.getMessageDataError();
                }
            }
            if (strErrorMessage == null)
                strErrorMessage = "Error - No data to PING";
            errorType.setShortText(strErrorMessage);
            errorType.setType("1");
            errorType.setLanguage("en");    // TODO
        }
        
        this.setPayloadProperties(message, root);
        
        return root;
    }

}
