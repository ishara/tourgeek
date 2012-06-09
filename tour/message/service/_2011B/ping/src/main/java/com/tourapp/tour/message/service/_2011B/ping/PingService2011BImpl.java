/**
 * @(#)PingService2011BImpl.
 * Copyright © 2012 tourapp.com. All rights reserved.
 */
package com.tourapp.tour.message.service._2011B.ping;

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
import org.jbundle.base.message.service.*;
import org.jibx.schema.org.opentravel._2011B.ping.*;
import org.jibx.schema.org.opentravel._2011B.ping.ws.*;

/**
 *  PingService2011BImpl - .
 */
public class PingService2011BImpl extends BaseServiceMessageTransport
     implements PingService
{
    /**
     * Default constructor.
     */
    public PingService2011BImpl()
    {
        super();
    }
    /**
     * Constructor.
     */
    public PingService2011BImpl(RecordOwnerParent parent, Rec recordMain, Map<String, Object> properties)
    {
        this();
        this.init(parent, recordMain, properties);
    }
    /**
     * Initialize class fields.
     */
    public void init(RecordOwnerParent parent, Rec recordMain, Map<String, Object> properties)
    {
        super.init(parent, recordMain, properties);
    }
    /**
     * Ping Method.
     */
    public PingRS ping(PingRQ request)
    {
        return (PingRS)this.processMessage(request);
    }

}
