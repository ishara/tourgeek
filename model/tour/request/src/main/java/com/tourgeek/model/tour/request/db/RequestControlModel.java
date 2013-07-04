
package com.tourgeek.model.tour.request.db;

import org.jbundle.model.db.*;

public interface RequestControlModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String SEND_VIA_CODE = "SendViaCode";
    public static final String BROCHURE_QTY = "BrochureQty";
    public static final String BULK_PERMIT_CODE = "BulkPermitCode";
    public static final String BULK_PERMIT_TEXT = "BulkPermitText";
    public static final String BUNDLE_ID = "BundleID";
    public static final String THIN_BUNDLE_ID = "ThinBundleID";
    public static final String HTML_BUNDLE_ID = "HtmlBundleID";
    public static final String PROFILE_TYPE_ID = "ProfileTypeID";

    public static final String REQUEST_CONTROL_FILE = "RequestControl";
    public static final String THIN_CLASS = "com.tourgeek.thin.tour.request.db.RequestControl";
    public static final String THICK_CLASS = "com.tourgeek.tour.request.db.RequestControl";

}
