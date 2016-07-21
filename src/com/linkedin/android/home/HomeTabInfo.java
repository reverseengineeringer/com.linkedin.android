package com.linkedin.android.home;

import java.util.Arrays;
import java.util.List;

public final class HomeTabInfo
{
  public static final HomeTabInfo FEED = new HomeTabInfo(2130838145, 2131231768, "nav_feed", true, true, 0);
  public static final HomeTabInfo ME = new HomeTabInfo(2130838162, 2131231772, "nav_selfview", false, false, 2);
  public static final HomeTabInfo MESSAGING = new HomeTabInfo(2130838163, 2131231769, "nav_messaging", true, true, 3);
  public static final HomeTabInfo NOTIFICATIONS = new HomeTabInfo(2130838174, 2131231771, "nav_notifications", true, true, 6);
  public static final HomeTabInfo RELATIONSHIPS = new HomeTabInfo(2130838181, 2131231773, "nav_people", true, false, 4);
  public static final HomeTabInfo SEARCH = new HomeTabInfo(2130838186, 2131231774, "nav_search", false, false, 5);
  public static final List<HomeTabInfo> TABS_V2 = Arrays.asList(new HomeTabInfo[] { FEED, RELATIONSHIPS, MESSAGING, NOTIFICATIONS, ME });
  final int contentDescriptionResId;
  public final boolean hasBadging;
  final int iconResId;
  private final int id;
  public final boolean shouldAutoClearBadges;
  public final String trackingControlName;
  
  private HomeTabInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    iconResId = paramInt1;
    contentDescriptionResId = paramInt2;
    trackingControlName = paramString;
    hasBadging = paramBoolean1;
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      shouldAutoClearBadges = paramBoolean1;
      id = paramInt3;
      return;
    }
  }
  
  public static HomeTabInfo getDefault()
  {
    return FEED;
  }
  
  public static int idForTab(HomeTabInfo paramHomeTabInfo)
  {
    return id;
  }
  
  public static HomeTabInfo tabForId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return FEED;
    case 2: 
      return ME;
    case 3: 
      return MESSAGING;
    case 4: 
      return RELATIONSHIPS;
    case 5: 
      return SEARCH;
    }
    return NOTIFICATIONS;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.home.HomeTabInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */