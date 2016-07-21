package com.linkedin.android.liauthlib.thirdparty;

import com.linkedin.android.liauthlib.R.drawable;
import java.util.HashMap;

public final class LiThirdPartyPermissionInfo
{
  static HashMap<String, Integer> PERMISSION_IMAGES;
  public String m_description;
  public String m_name;
  public String m_title;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("r_basicprofile", Integer.valueOf(R.drawable.icon_profile));
    localHashMap.put("r_fullprofile", Integer.valueOf(R.drawable.icon_profile));
    localHashMap.put("r_emailaddress", Integer.valueOf(R.drawable.icon_email));
    localHashMap.put("r_network", Integer.valueOf(R.drawable.icon_network));
    localHashMap.put("r_contactinfo", Integer.valueOf(R.drawable.icon_contacts));
    localHashMap.put("r_addressbook", Integer.valueOf(R.drawable.icon_contacts));
    localHashMap.put("r_businesscards", Integer.valueOf(R.drawable.icon_contacts));
    localHashMap.put("offline_access", Integer.valueOf(R.drawable.icon_offline));
    localHashMap.put("w_messages", Integer.valueOf(R.drawable.icon_messages));
    localHashMap.put("rw_groups", Integer.valueOf(R.drawable.icon_groups));
    localHashMap.put("w_share", Integer.valueOf(R.drawable.icon_groups));
    localHashMap.put("rw_company_admin", Integer.valueOf(R.drawable.icon_company));
    localHashMap.put("rw_ad_campaigns", Integer.valueOf(R.drawable.icon_ads));
    localHashMap.put("rw_events", Integer.valueOf(R.drawable.icon_events));
    localHashMap.put("rsvp_events", Integer.valueOf(R.drawable.icon_rsvp_events));
    localHashMap.put("w_fullprofile", Integer.valueOf(R.drawable.icon_profile));
    localHashMap.put("w_wechat", Integer.valueOf(R.drawable.icon_wechat));
    localHashMap.put("rw_news", Integer.valueOf(R.drawable.icon_news));
    localHashMap.put("rw_nus", Integer.valueOf(R.drawable.icon_news));
    localHashMap.put("r_mailbox", Integer.valueOf(R.drawable.icon_mailbox));
    localHashMap.put("p_compliance", Integer.valueOf(R.drawable.icon_p_compliance));
    localHashMap.put("r_compliance", Integer.valueOf(R.drawable.icon_r_compliance));
    localHashMap.put("rw_social_media", Integer.valueOf(R.drawable.icon_social_media));
    localHashMap.put("rw_jobs", Integer.valueOf(R.drawable.icon_jobs));
    PERMISSION_IMAGES = localHashMap;
  }
  
  public LiThirdPartyPermissionInfo(String paramString1, String paramString2, String paramString3)
  {
    m_name = paramString1;
    m_title = paramString2;
    m_description = paramString3;
  }
  
  static int getPermissionImageResource(String paramString)
  {
    paramString = (Integer)PERMISSION_IMAGES.get(paramString);
    if (paramString == null) {
      return R.drawable.icon_profile;
    }
    return paramString.intValue();
  }
  
  public final String toString()
  {
    return "LiThirdPartyPermissionInfo '" + m_name + "' '" + m_title + "' " + m_description;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyPermissionInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */