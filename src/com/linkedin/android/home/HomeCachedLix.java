package com.linkedin.android.home;

import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixDefinition;
import com.linkedin.android.infra.lix.LixManager;
import java.util.HashMap;
import java.util.Map;

public final class HomeCachedLix
{
  static final Lix[] LIX_TO_MONITOR = { Lix.INFRA_NAV_V2_OPEN_SEARCH_BAR, Lix.INFRA_NAV_V2_OPEN_SEARCH_BAR_40, Lix.LIX_PROP_IN_NOTIFICATION_TAB, Lix.INFRA_NAV_V2_COLLAPSE_SEARCH_BAR, Lix.FEED_SHARE_ENTRY_POINT, Lix.MYNETWORK_INVITE_BADGE_NUMBER_DISPLAY, Lix.MYNETWORK_CALENDAR_SYNC_PROP_V2 };
  Map<LixDefinition, String> cachedLix;
  long lixChangeTimeStamp;
  LixManager lixManager;
  boolean lixValueChanged;
  FlagshipSharedPreferences sharedPreferences;
  
  public HomeCachedLix(LixManager paramLixManager, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    lixManager = paramLixManager;
    sharedPreferences = paramFlagshipSharedPreferences;
    cachedLix = new HashMap();
    initializeNavLixListener();
  }
  
  private void initializeNavLixListener()
  {
    Lix[] arrayOfLix = LIX_TO_MONITOR;
    int j = arrayOfLix.length;
    int i = 0;
    while (i < j)
    {
      Lix localLix = arrayOfLix[i];
      lixManager.addTreatmentListener(localLix, new HomeCachedLix.1(this, localLix));
      i += 1;
    }
  }
  
  public final String getTreatment(LixDefinition paramLixDefinition)
  {
    if (!cachedLix.containsKey(paramLixDefinition)) {
      cachedLix.put(paramLixDefinition, lixManager.getTreatment(paramLixDefinition));
    }
    return (String)cachedLix.get(paramLixDefinition);
  }
  
  public final boolean isInvitationBadgeNumberDisplay()
  {
    return "enabled".equals(getTreatment(Lix.MYNETWORK_INVITE_BADGE_NUMBER_DISPLAY));
  }
  
  public final boolean isNavV2PropsInNotifications()
  {
    return "enabled".equals(getTreatment(Lix.LIX_PROP_IN_NOTIFICATION_TAB));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.home.HomeCachedLix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */