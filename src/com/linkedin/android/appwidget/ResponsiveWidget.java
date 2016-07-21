package com.linkedin.android.appwidget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexCompletionCallback;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.voyager.common.BadgeCount;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ResponsiveWidget
  extends AppWidgetProvider
{
  private static PendingIntent pendingIntentForAction(Context paramContext, String paramString)
  {
    return PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, ResponsiveWidget.class).setAction(paramString), 0);
  }
  
  private static RemoteViews setupAsNotifications(Context paramContext, AppWidgetKeyValueStore.WidgetDataModel paramWidgetDataModel)
  {
    int j = 8;
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968606);
    localRemoteViews.setOnClickPendingIntent(2131755164, pendingIntentForAction(paramContext, "home"));
    localRemoteViews.setOnClickPendingIntent(2131755165, pendingIntentForAction(paramContext, "nav_feed"));
    localRemoteViews.setOnClickPendingIntent(2131755168, pendingIntentForAction(paramContext, "nav_people"));
    localRemoteViews.setOnClickPendingIntent(2131755171, pendingIntentForAction(paramContext, "nav_messaging"));
    localRemoteViews.setOnClickPendingIntent(2131755174, pendingIntentForAction(paramContext, "nav_notifications"));
    localRemoteViews.setOnClickPendingIntent(2131755177, pendingIntentForAction(paramContext, "nav_me"));
    if (feedBadge)
    {
      i = 0;
      localRemoteViews.setViewVisibility(2131755167, i);
      if (networkBadge > 0L) {
        break label257;
      }
      i = 8;
      label125:
      localRemoteViews.setViewVisibility(2131755170, i);
      localRemoteViews.setTextViewText(2131755170, Long.toString(networkBadge));
      if (messagesBadge > 0L) {
        break label262;
      }
      i = 8;
      label159:
      localRemoteViews.setViewVisibility(2131755173, i);
      localRemoteViews.setTextViewText(2131755173, Long.toString(messagesBadge));
      if (notifications > 0L) {
        break label267;
      }
      i = 8;
      label193:
      localRemoteViews.setViewVisibility(2131755176, i);
      localRemoteViews.setTextViewText(2131755176, Long.toString(notifications));
      if (meBadge > 0L) {
        break label272;
      }
    }
    label257:
    label262:
    label267:
    label272:
    for (int i = j;; i = 0)
    {
      localRemoteViews.setViewVisibility(2131755179, i);
      localRemoteViews.setTextViewText(2131755179, Long.toString(meBadge));
      return localRemoteViews;
      i = 8;
      break;
      i = 0;
      break label125;
      i = 0;
      break label159;
      i = 0;
      break label193;
    }
  }
  
  private static void startNewTask(Context paramContext, Intent paramIntent)
  {
    FeatureLog.i("ResponsiveWidget", "starting new task with intent: " + paramIntent, "App Widget");
    paramContext.startActivity(paramIntent.addFlags(335544320));
  }
  
  public static void updateAllAppWidgets(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    if (localAppWidgetManager != null)
    {
      updateAllAppWidgets(paramContext, localAppWidgetManager.getAppWidgetIds(new ComponentName(paramContext, ResponsiveWidget.class)));
      return;
    }
    Util.safeThrow$7a8b4789(new RuntimeException("No app widget manager found, unable to update all app widgets"));
  }
  
  public static void updateAllAppWidgets(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = paramContext.getApplicationContext();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      updateAppWidget(paramContext, paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  private static void updateAppWidget(final Context paramContext, final int paramInt)
  {
    Object localObject1 = paramContext.getApplicationContext();
    if (paramInt == 0)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Can't update widget without an appwidget id."));
      return;
    }
    final AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance((Context)localObject1);
    if (localAppWidgetManager == null)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Can't update widget without a manager."));
      return;
    }
    paramContext = AppWidgetUtils.getAppComponent((Context)localObject1);
    if (paramContext == null)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("No app component! Can't update the widget."));
      return;
    }
    final Object localObject2 = paramContext.flagshipSharedPreferences();
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    final String str1 = HomeFragmentDataProvider.getFetchRoute(paramContext, HomeTabInfo.FEED, ((FlagshipSharedPreferences)localObject2).getBadgeLastUpdateTimeStamp(HomeTabInfo.FEED));
    localBuilder.required(Request.get().url(str1).builder(BadgeCount.BUILDER));
    final String str2 = HomeFragmentDataProvider.getFetchRoute(paramContext, HomeTabInfo.RELATIONSHIPS, ((FlagshipSharedPreferences)localObject2).getBadgeLastUpdateTimeStamp(HomeTabInfo.RELATIONSHIPS));
    localBuilder.required(Request.get().url(str2).builder(BadgeCount.BUILDER));
    final String str3 = HomeFragmentDataProvider.getFetchRoute(paramContext, HomeTabInfo.MESSAGING, ((FlagshipSharedPreferences)localObject2).getBadgeLastUpdateTimeStamp(HomeTabInfo.MESSAGING));
    localBuilder.required(Request.get().url(str3).builder(BadgeCount.BUILDER));
    localObject2 = HomeFragmentDataProvider.getFetchRoute(paramContext, HomeTabInfo.NOTIFICATIONS, ((FlagshipSharedPreferences)localObject2).getBadgeLastUpdateTimeStamp(HomeTabInfo.NOTIFICATIONS));
    localBuilder.required(Request.get().url((String)localObject2).builder(BadgeCount.BUILDER));
    localObject1 = new MultiplexCompletionCallback()
    {
      public final void onRequestComplete(Map<String, DataStoreResponse> paramAnonymousMap, DataManagerException paramAnonymousDataManagerException, DataStore.Type paramAnonymousType)
      {
        ResponsiveWidget.access$100(val$context, localAppWidgetManager, paramContext, paramInt, new AppWidgetKeyValueStore.WidgetDataModel(ResponsiveWidget.access$000((DataStoreResponse)paramAnonymousMap.get(str1)), ResponsiveWidget.access$000((DataStoreResponse)paramAnonymousMap.get(str2)), ResponsiveWidget.access$000((DataStoreResponse)paramAnonymousMap.get(str3)), ResponsiveWidget.access$000((DataStoreResponse)paramAnonymousMap.get(localObject2))));
      }
    };
    long l = paramContext.appwidgetValues().getPreferences().getLong(AppWidgetKeyValueStore.lastUpdateKey(paramInt), -1L);
    if (System.currentTimeMillis() - l > AppWidgetUtils.MAX_CACHE_AGE_MS)
    {
      localBuilder.filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      completionCallback = ((MultiplexCompletionCallback)localObject1);
      paramContext.dataManager().submit(localBuilder.build());
      return;
    }
    AppWidgetUtils.tryCacheThenNetwork(paramContext, localBuilder, (MultiplexCompletionCallback)localObject1);
  }
  
  @TargetApi(16)
  public void onAppWidgetOptionsChanged(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt, Bundle paramBundle)
  {
    int j = 1;
    super.onAppWidgetOptionsChanged(paramContext, paramAppWidgetManager, paramInt, paramBundle);
    FeatureLog.i("ResponsiveWidget", "[" + paramInt + "] widget options changed to: " + paramBundle, "App Widget");
    paramAppWidgetManager = AppWidgetUtils.getAppComponent(paramContext);
    int i;
    int k;
    if (paramAppWidgetManager != null)
    {
      paramAppWidgetManager = paramAppWidgetManager.appwidgetValues();
      i = paramBundle.getInt("appWidgetMinHeight");
      k = paramBundle.getInt("appWidgetMinWidth");
      if (i >= 110) {
        break label143;
      }
      i = 1;
      if (k >= 110) {
        break label177;
      }
    }
    for (;;)
    {
      paramAppWidgetManager.getPreferences().edit().putInt(AppWidgetKeyValueStore.rowsKey(paramInt), i).putInt(AppWidgetKeyValueStore.columnsKey(paramInt), j).apply();
      updateAppWidget(paramContext, paramInt);
      return;
      label143:
      if (i < 180)
      {
        i = 2;
        break;
      }
      if (i < 250)
      {
        i = 3;
        break;
      }
      i = 4;
      break;
      label177:
      if (k < 180) {
        j = 2;
      } else if (k < 250) {
        j = 3;
      } else {
        j = 4;
      }
    }
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = AppWidgetUtils.getAppComponent(paramContext);
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.appwidgetValues();
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        paramContext.getPreferences().edit().remove(AppWidgetKeyValueStore.lastUpdateKey(k)).remove(AppWidgetKeyValueStore.columnsKey(k)).remove(AppWidgetKeyValueStore.rowsKey(k)).apply();
        i += 1;
      }
    }
  }
  
  public void onDisabled(Context paramContext)
  {
    AppWidgetUtils.updateActiveUserListenerState(paramContext, null);
    paramContext = AppWidgetUtils.getAppComponent(paramContext);
    if (paramContext != null)
    {
      paramContext.appwidgetValues().clear();
      paramContext.tracker();
      AppWidgetUtils.trackWidgetEvent$42c523c("last_removed");
    }
  }
  
  public void onEnabled(Context paramContext)
  {
    FeatureLog.registerFeature("App Widget");
    AppWidgetUtils.updateActiveUserListenerState(paramContext, null);
    if (SystemClock.elapsedRealtime() >= TimeUnit.MINUTES.toMillis(1L))
    {
      paramContext = AppWidgetUtils.getAppComponent(paramContext);
      if (paramContext != null)
      {
        paramContext.tracker();
        AppWidgetUtils.trackWidgetEvent$42c523c("first_added");
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    CrashReporter.logComponentInfo("Starting broadcast receiver " + ResponsiveWidget.class.getSimpleName(), paramIntent);
    super.onReceive(paramContext, paramIntent);
    paramIntent = paramIntent.getAction();
    ApplicationComponent localApplicationComponent = AppWidgetUtils.getAppComponent(paramContext);
    int j;
    int i;
    if ((!TextUtils.isEmpty(paramIntent)) && (localApplicationComponent != null))
    {
      FeatureLog.i("ResponsiveWidget", "received action: " + paramIntent, "App Widget");
      j = 1;
      i = -1;
      switch (paramIntent.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          i = 0;
        }
        break;
      }
    }
    for (;;)
    {
      if (i != 0) {
        AppWidgetUtils.trackWidgetButtonPress(localApplicationComponent.tracker(), paramIntent);
      }
      return;
      if (!paramIntent.equals("home")) {
        break;
      }
      i = 0;
      break;
      if (!paramIntent.equals("nav_feed")) {
        break;
      }
      i = 1;
      break;
      if (!paramIntent.equals("nav_people")) {
        break;
      }
      i = 2;
      break;
      if (!paramIntent.equals("nav_messaging")) {
        break;
      }
      i = 3;
      break;
      if (!paramIntent.equals("nav_notifications")) {
        break;
      }
      i = 4;
      break;
      if (!paramIntent.equals("nav_me")) {
        break;
      }
      i = 5;
      break;
      startNewTask(paramContext, intentRegistryhome.newIntent(paramContext, null));
      i = j;
      continue;
      HomeBundle localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.FEED;
      startNewTask(paramContext, intentRegistryhome.newIntent(paramContext, localHomeBundle));
      i = j;
      continue;
      localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.RELATIONSHIPS;
      startNewTask(paramContext, intentRegistryhome.newIntent(paramContext, localHomeBundle));
      i = j;
      continue;
      localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.MESSAGING;
      startNewTask(paramContext, intentRegistryhome.newIntent(paramContext, localHomeBundle));
      i = j;
      continue;
      localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.NOTIFICATIONS;
      startNewTask(paramContext, intentRegistryhome.newIntent(paramContext, localHomeBundle));
      i = j;
      continue;
      localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.ME;
      startNewTask(paramContext, intentRegistryhome.newIntent(paramContext, localHomeBundle));
      i = j;
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    updateAllAppWidgets(paramContext, paramArrayOfInt);
  }
  
  public static class ActiveUserListener
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (!"android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
        return;
      }
      CrashReporter.logComponentInfo("Starting broadcast receiver " + ActiveUserListener.class.getSimpleName(), paramIntent);
      ResponsiveWidget.updateAllAppWidgets(paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.appwidget.ResponsiveWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */