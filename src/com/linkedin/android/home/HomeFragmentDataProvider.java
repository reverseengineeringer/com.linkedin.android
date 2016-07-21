package com.linkedin.android.home;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.l2m.badge.BadgeRouteFetcher;
import com.linkedin.android.l2m.badge.Badger;
import com.linkedin.android.l2m.badge.Badger.ClearCountListener;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragmentDataProvider
  extends DataProvider<HomeFragmentDataProvider.State, DataProvider.DataProviderListener>
{
  public static final String LAUCHER_URL = Routes.APP_LAUNCHER.buildUponRoot().toString();
  public static final String TAG = HomeFragmentDataProvider.class.getSimpleName();
  private static long reloadBadgingTimeout = 120000L;
  private final Badger badger;
  
  @Inject
  public HomeFragmentDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
    badger = paramActivityComponent.badger();
  }
  
  private static Routes getBaseRoute(HomeTabInfo paramHomeTabInfo)
  {
    if (paramHomeTabInfo == HomeTabInfo.FEED) {
      return Routes.FEED_BADGING;
    }
    if (paramHomeTabInfo == HomeTabInfo.NOTIFICATIONS) {
      return Routes.ME_FEED_BADGING;
    }
    if (paramHomeTabInfo == HomeTabInfo.MESSAGING) {
      return Routes.MESSAGING_BADGING;
    }
    if (paramHomeTabInfo == HomeTabInfo.RELATIONSHIPS) {
      return Routes.RELATIONSHIPS_BADGING;
    }
    Util.safeThrow(new RuntimeException("Tried to setup badging for a tab that is not supported"));
    return null;
  }
  
  public static String getClearSomeRoute(HomeTabInfo paramHomeTabInfo)
  {
    return getBaseRoute(paramHomeTabInfo).buildUponRoot().buildUpon().appendQueryParameter("action", "markItemsAsSeen").build().toString();
  }
  
  public static String getFetchRoute(ApplicationComponent paramApplicationComponent, HomeTabInfo paramHomeTabInfo, long paramLong)
  {
    Uri.Builder localBuilder = getBaseRoute(paramHomeTabInfo).buildUponRoot().buildUpon().appendQueryParameter("countFrom", String.valueOf(paramLong));
    if (paramHomeTabInfo == HomeTabInfo.NOTIFICATIONS)
    {
      localBuilder.appendQueryParameter("version", "8");
      if (paramApplicationComponent.homeCachedLix().isNavV2PropsInNotifications()) {
        localBuilder.appendQueryParameter("includeProps", Boolean.TRUE.toString());
      }
    }
    if ((paramHomeTabInfo == HomeTabInfo.RELATIONSHIPS) && ((paramApplicationComponent.homeCachedLix().isNavV2PropsInNotifications()) || (paramApplicationComponent.homeCachedLix().isInvitationBadgeNumberDisplay()))) {
      localBuilder.appendQueryParameter("includeProps", Boolean.FALSE.toString());
    }
    return localBuilder.build().toString();
  }
  
  public static long getReloadBadgeTimeout()
  {
    return reloadBadgingTimeout;
  }
  
  public static boolean shouldAutoClearBadgeForTab(HomeTabInfo paramHomeTabInfo)
  {
    return (hasBadging) && (shouldAutoClearBadges);
  }
  
  public final void clearAllBadgeCount(HomeTabInfo paramHomeTabInfo, Map<String, String> paramMap, Map<String, Object> paramMap1)
  {
    Badger localBadger = badger;
    JSONObject localJSONObject;
    if (hasBadging)
    {
      localBadger.cancelPendingUpdateIfAny(paramHomeTabInfo);
      localBadger.setBadgeCount(paramHomeTabInfo, 0L, true);
      long l = localBadger.getLastUpdateTimestamp(paramHomeTabInfo);
      if (l > 0L) {
        try
        {
          localJSONObject = new JSONObject().put("until", l);
          if (paramMap1 != null)
          {
            Iterator localIterator = paramMap1.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              Object localObject = paramMap1.get(str);
              if (localObject != null)
              {
                localJSONObject.put(str, localObject);
                continue;
                return;
              }
            }
          }
        }
        catch (JSONException paramHomeTabInfo)
        {
          Util.safeThrow(new RuntimeException("Error creating json object for badge clearing (clear all)"));
        }
      }
    }
    paramMap1 = new JsonModel(localJSONObject);
    dataManager.submit(Request.post().url(BadgeRouteFetcher.getBaseRoute(paramHomeTabInfo).buildUponRoot().buildUpon().appendQueryParameter("action", "markAllItemsAsSeen").build().toString()).customHeaders(paramMap).model(paramMap1).listener(new Badger.ClearCountListener(paramHomeTabInfo)).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public final void clearAllBadgeCountByLastUpdateTimestamp(HomeTabInfo paramHomeTabInfo, long paramLong, Map<String, String> paramMap)
  {
    clearAllBadgeCountByLastUpdateTimestamp(paramHomeTabInfo, paramLong, paramMap, null);
  }
  
  public final void clearAllBadgeCountByLastUpdateTimestamp(HomeTabInfo paramHomeTabInfo, long paramLong, Map<String, String> paramMap, Map<String, Object> paramMap1)
  {
    setLastUpdateTimestamp(paramHomeTabInfo, paramLong);
    clearAllBadgeCount(paramHomeTabInfo, paramMap, paramMap1);
  }
  
  public final void clearSomeBadgeCount(HomeTabInfo paramHomeTabInfo, String[] paramArrayOfString, Map<String, String> paramMap)
  {
    Badger localBadger = badger;
    if (!hasBadging) {
      return;
    }
    long l = Math.max(0L, localBadger.getBadgeCount(paramHomeTabInfo) - 1L);
    localBadger.cancelPendingUpdateIfAny(paramHomeTabInfo);
    localBadger.setBadgeCount(paramHomeTabInfo, l, true);
    try
    {
      dataManager.submit(Request.post().url(BadgeRouteFetcher.getBaseRoute(paramHomeTabInfo).buildUponRoot().buildUpon().appendQueryParameter("action", "markItemsAsSeen").build().toString()).customHeaders(paramMap).model(new JsonModel(new JSONObject().put("items", new JSONArray(Arrays.asList(paramArrayOfString))))).listener(new Badger.ClearCountListener(paramHomeTabInfo)).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      return;
    }
    catch (JSONException paramHomeTabInfo)
    {
      Util.safeThrow(new RuntimeException("Error creating json object for badge clearing (clear all)"));
    }
  }
  
  public final void fetchData$7708a69c(boolean paramBoolean)
  {
    String str = activityComponent.activity().activityComponent.lixManager().getTreatment(Lix.AXLE_BADGING_RELOAD_TIME);
    if ((!"control".equals(str)) && (str.indexOf("value_") == 0)) {}
    try
    {
      reloadBadgingTimeout = Long.parseLong(str.substring(6)) * 1000L;
      if ((paramBoolean) || (System.currentTimeMillis() - state).lastBadgeReload > reloadBadgingTimeout))
      {
        state).lastBadgeReload = System.currentTimeMillis();
        badger.doFetchData(state).tabs, paramBoolean);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        reloadBadgingTimeout = 120000L;
        activityComponent.context();
        Util.safeThrow$7a8b4789(localNumberFormatException);
      }
    }
  }
  
  public final void setLastUpdateTimestamp(HomeTabInfo paramHomeTabInfo, long paramLong)
  {
    state).sharedPreferences.getPreferences().edit().putLong("badgeLastUpdate" + HomeTabInfo.idForTab(paramHomeTabInfo), paramLong).apply();
  }
  
  public final void setRumSessionId(String paramString)
  {
    state).rumSessionId = paramString;
  }
  
  public final void setSubscriberId(String paramString)
  {
    state).subscriberId = paramString;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.home.HomeFragmentDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */