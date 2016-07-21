package com.linkedin.android.l2m.badge;

import android.content.Context;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.badging.AggregatedBadgeUpdateEvent;
import com.linkedin.android.home.badging.BadgeUpdateEvent;
import com.linkedin.android.infra.LogoutEvent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.ApplicationLifecycleEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.HiddenPushReceivedEvent;
import com.linkedin.android.infra.events.PushNotificationReceivedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.logger.Log;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.greenrobot.eventbus.Subscribe;

public final class OuterBadge
{
  long allCount;
  int applicationState;
  private final Badger badger;
  private final Context context;
  private final FlagshipSharedPreferences flagshipSharedPreferences;
  private final LixManager lixManager;
  
  @Inject
  public OuterBadge(Context paramContext, LixManager paramLixManager, Bus paramBus, Badger paramBadger, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    context = paramContext;
    lixManager = paramLixManager;
    badger = paramBadger;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    if (!ShortcutBadger.isDeviceSupported(paramContext)) {
      paramFlagshipSharedPreferences.setAppBadgeCount(-1L);
    }
    Bus.subscribe(this);
  }
  
  private long getAggregatedBadgeCount()
  {
    long l = 0L;
    Iterator localIterator = HomeTabInfo.TABS_V2.iterator();
    while (localIterator.hasNext())
    {
      HomeTabInfo localHomeTabInfo = (HomeTabInfo)localIterator.next();
      if ((!localHomeTabInfo.equals(HomeTabInfo.FEED)) && (hasBadging)) {
        l += badger.getBadgeCount(localHomeTabInfo);
      }
    }
    return l;
  }
  
  private void storeAndApplyOuterBadgeCount(long paramLong)
  {
    flagshipSharedPreferences.setAppBadgeCount(paramLong);
    ShortcutBadger.applyCount(context, (int)paramLong);
  }
  
  private void updateOuterBadge()
  {
    long l = 999L;
    allCount = getAggregatedBadgeCount();
    if (allCount > 999L) {}
    for (;;)
    {
      allCount = l;
      storeAndApplyOuterBadgeCount(allCount);
      return;
      l = allCount;
    }
  }
  
  @Subscribe
  public final void onEvent(AggregatedBadgeUpdateEvent paramAggregatedBadgeUpdateEvent)
  {
    if (("enabled".equals(lixManager.getTreatment(Lix.GROWTH_BADGING_APPBADGE))) && (ShortcutBadger.isDeviceSupported(context))) {
      updateOuterBadge();
    }
  }
  
  @Subscribe
  public final void onEvent(BadgeUpdateEvent paramBadgeUpdateEvent)
  {
    if (!shouldUpdateOuterBadge) {}
    while ((!"enabled".equals(lixManager.getTreatment(Lix.GROWTH_BADGING_APPBADGE))) || (!ShortcutBadger.isDeviceSupported(context))) {
      return;
    }
    updateOuterBadge();
  }
  
  @Subscribe
  public final void onEvent(LogoutEvent paramLogoutEvent)
  {
    if ("enabled".equals(lixManager.getTreatment(Lix.GROWTH_BADGING_APPBADGE)))
    {
      allCount = 0L;
      ShortcutBadger.applyCount(context, (int)allCount);
    }
  }
  
  @Subscribe
  public final void onEvent(ApplicationLifecycleEvent paramApplicationLifecycleEvent)
  {
    applicationState = newState;
  }
  
  @Subscribe
  public final void onEvent(HiddenPushReceivedEvent paramHiddenPushReceivedEvent)
  {
    if ("HiddenFlockPing".equalsIgnoreCase(notificationType)) {
      return;
    }
    Log.i("Updating badge count on receiving a hidden push of type " + notificationType);
    onEvent(paramHiddenPushReceivedEvent);
  }
  
  @Subscribe
  public final void onEvent(PushNotificationReceivedEvent paramPushNotificationReceivedEvent)
  {
    if (applicationState != 0)
    {
      if (("enabled".equals(lixManager.getTreatment(Lix.GROWTH_BADGING_APPBADGE))) && (ShortcutBadger.isDeviceSupported(context)))
      {
        if (badgeCount >= 0)
        {
          allCount = badgeCount;
          storeAndApplyOuterBadgeCount(allCount);
        }
      }
      else {
        return;
      }
      if (("enabled".equals(lixManager.getTreatment(Lix.GROWTH_BADGING_PREEMPTUPDATE))) && (0L == getAggregatedBadgeCount()))
      {
        allCount = 1L;
        storeAndApplyOuterBadgeCount(allCount);
      }
    }
    badger.doFetchData(HomeTabInfo.TABS_V2, false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.badge.OuterBadge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */