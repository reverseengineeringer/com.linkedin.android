package com.linkedin.android.l2m.badge;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.TabScrolledEvent;
import com.linkedin.android.home.TabSelectedEvent;
import com.linkedin.android.home.badging.BadgeUpdateEvent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.ApplicationLifecycleEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.BadgeCount;
import com.linkedin.gen.avro2pegasus.events.common.ControlInteractionType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.Subscribe;

public class Badger
{
  private static final String TAG = Badger.class.getSimpleName();
  private static final long WAKE_LOCK_TIMEOUT = TimeUnit.SECONDS.toMillis(10L);
  private final Bus bus;
  private Context context;
  public final FlagshipDataManager dataManager;
  private final HomeCachedLix homeCachedLix;
  private final LixManager lixManager;
  Badger.BadgeRequestCallback pendingBadgeRequestCallback;
  private final FlagshipSharedPreferences sharedPreferences;
  private final Tracker tracker;
  
  public Badger(FlagshipDataManager paramFlagshipDataManager, LixManager paramLixManager, HomeCachedLix paramHomeCachedLix, Bus paramBus, FlagshipSharedPreferences paramFlagshipSharedPreferences, Context paramContext, Tracker paramTracker)
  {
    dataManager = paramFlagshipDataManager;
    lixManager = paramLixManager;
    homeCachedLix = paramHomeCachedLix;
    bus = paramBus;
    sharedPreferences = paramFlagshipSharedPreferences;
    context = paramContext;
    tracker = paramTracker;
    Bus.subscribe(this);
  }
  
  public final void cancelPendingUpdateIfAny(HomeTabInfo paramHomeTabInfo)
  {
    if (pendingBadgeRequestCallback != null)
    {
      Badger.BadgeRequestCallback localBadgeRequestCallback = pendingBadgeRequestCallback;
      if (hasBadging)
      {
        Iterator localIterator = routeToTabMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          HomeTabInfo localHomeTabInfo = (HomeTabInfo)routeToTabMap.get(localEntry.getValue());
          if ((localHomeTabInfo != null) && (trackingControlName.equals(trackingControlName)))
          {
            routeToTabMap.remove(localEntry.getKey());
            Log.w("Pending badge request invalidated for tab " + trackingControlName);
          }
        }
      }
    }
  }
  
  public final void doFetchData(List<HomeTabInfo> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      MultiplexRequest.Builder localBuilder;
      ArrayMap localArrayMap;
      Object localObject;
      Uri.Builder localBuilder1;
      try
      {
        if (pendingBadgeRequestCallback != null)
        {
          Log.w(TAG, "Badge fetch request ignored because of a pending request");
          return;
        }
        localBuilder = MultiplexRequest.Builder.parallel();
        multiplexerUrl = Routes.MUX.buildUponRoot().toString();
        localArrayMap = new ArrayMap();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label250;
        }
        HomeTabInfo localHomeTabInfo = (HomeTabInfo)paramList.next();
        if (!hasBadging) {
          continue;
        }
        localObject = homeCachedLix;
        long l = getLastUpdateTimestamp(localHomeTabInfo);
        localBuilder1 = BadgeRouteFetcher.getBaseRoute(localHomeTabInfo).buildUponRoot().buildUpon().appendQueryParameter("countFrom", String.valueOf(l));
        if (localHomeTabInfo == HomeTabInfo.NOTIFICATIONS)
        {
          localBuilder1.appendQueryParameter("version", "8");
          if (((HomeCachedLix)localObject).isNavV2PropsInNotifications()) {
            localBuilder1.appendQueryParameter("includeProps", Boolean.TRUE.toString());
          }
          localObject = localBuilder1.build().toString();
          localBuilder.required(Request.get().url((String)localObject).builder(BadgeCount.BUILDER));
          localArrayMap.put(localObject, localHomeTabInfo);
          continue;
        }
        if (localHomeTabInfo != HomeTabInfo.RELATIONSHIPS) {
          continue;
        }
      }
      finally {}
      if ((((HomeCachedLix)localObject).isNavV2PropsInNotifications()) || (((HomeCachedLix)localObject).isInvitationBadgeNumberDisplay()))
      {
        localBuilder1.appendQueryParameter("includeProps", Boolean.FALSE.toString());
        continue;
        label250:
        localBuilder.filter(DataManager.DataStoreFilter.NETWORK_ONLY);
        paramList = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "BadgeFetch");
        pendingBadgeRequestCallback = new Badger.BadgeRequestCallback(localArrayMap, this, new BadgerWakeLock(paramList), paramBoolean);
        completionCallback = pendingBadgeRequestCallback;
        paramList.acquire(WAKE_LOCK_TIMEOUT);
        dataManager.submit(localBuilder.build());
        Log.d(TAG, "Fetching badge data");
      }
    }
  }
  
  public final long getBadgeCount(HomeTabInfo paramHomeTabInfo)
  {
    return sharedPreferences.getBadgeCount(paramHomeTabInfo);
  }
  
  public final long getLastUpdateTimestamp(HomeTabInfo paramHomeTabInfo)
  {
    return sharedPreferences.getBadgeLastUpdateTimeStamp(paramHomeTabInfo);
  }
  
  @Subscribe
  public final void onEvent(TabScrolledEvent paramTabScrolledEvent)
  {
    if ((source == 1) && (end) && ("enabled".equals(lixManager.getTreatment(Lix.GROWTH_BADGING_TRACKING)))) {
      BadgeTrackingUtils.trackBadgeInteractionActionEvent(tracker, sharedPreferences, tab, ControlInteractionType.SWIPE_LEFT);
    }
  }
  
  @Subscribe
  public final void onEvent(TabSelectedEvent paramTabSelectedEvent)
  {
    if ((tapSelected) && (!alreadySelected) && ("enabled".equals(lixManager.getTreatment(Lix.GROWTH_BADGING_TRACKING)))) {
      BadgeTrackingUtils.trackBadgeInteractionActionEvent(tracker, sharedPreferences, tab, ControlInteractionType.SHORT_PRESS);
    }
  }
  
  @Subscribe
  public final void onEvent(ApplicationLifecycleEvent paramApplicationLifecycleEvent)
  {
    if (newState == 1) {}
    while (!"enabled".equals(lixManager.getTreatment(Lix.GROWTH_BADGING_TRACKING))) {
      return;
    }
    BadgeTrackingUtils.trackAppForegroundBadgeEvent(tracker, sharedPreferences);
  }
  
  public final void setBadgeCount(HomeTabInfo paramHomeTabInfo, long paramLong, boolean paramBoolean)
  {
    long l = Math.max(0L, paramLong);
    sharedPreferences.getPreferences().edit().putLong("badgeCount_" + HomeTabInfo.idForTab(paramHomeTabInfo), l).apply();
    if (paramBoolean) {}
    for (BadgeUpdateEvent localBadgeUpdateEvent = BadgeUpdateEvent.createWithShouldUpdateOuterBadge(paramHomeTabInfo, Long.valueOf(paramLong));; localBadgeUpdateEvent = BadgeUpdateEvent.createWithShouldNotUpdateOuterBadge(paramHomeTabInfo, Long.valueOf(paramLong)))
    {
      Bus.publish(localBadgeUpdateEvent);
      Log.i(TAG, "Tab " + trackingControlName + " has badge count " + l);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.badge.Badger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */