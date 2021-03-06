/**
  * @(#)MembershipsModel.
  * Copyright © 2013 tourgeek.com. All rights reserved.
  * GPL3 Open Source Software License.
  */
package com.tourgeek.model.tour.profile.detail;

import org.jbundle.model.db.*;

public interface MembershipsModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String PROFILE_ID = "ProfileID";
    public static final String PROGRAM_CODE = "ProgramCode";
    public static final String ACCOUNT_ID = "AccountID";
    public static final String LEVEL_CODE = "LevelCode";
    public static final String MEMBERSHIP_CATEGORY = "MembershipCategory";
    public static final String EXPIRE_DATE = "ExpireDate";
    public static final String SIGNUP_DATE = "SignupDate";
    public static final String START_DATE = "StartDate";

    public static final String PROFILE_ID_KEY = "ProfileID";

    public static final String MEMBERSHIPS_FILE = "Memberships";
    public static final String THIN_CLASS = "com.tourgeek.thin.tour.profile.detail.Memberships";
    public static final String THICK_CLASS = "com.tourgeek.tour.profile.detail.Memberships";

}
