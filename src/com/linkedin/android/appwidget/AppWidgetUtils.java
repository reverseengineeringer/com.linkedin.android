package com.linkedin.android.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexCompletionCallback;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class AppWidgetUtils
{
  public static final long MAX_CACHE_AGE_MS = TimeUnit.MINUTES.toMillis(30L);
  
  public static int[] getActiveWidgetIds(Context paramContext, Class<?> paramClass)
  {
    paramContext = paramContext.getApplicationContext();
    return AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, paramClass));
  }
  
  public static ApplicationComponent getAppComponent(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = paramContext.getApplicationContext();
    } while (!(paramContext instanceof FlagshipApplication));
    return ((FlagshipApplication)paramContext).getAppComponent();
  }
  
  private static int[] getAppWidgetIds(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    if (localAppWidgetManager != null) {
      return localAppWidgetManager.getAppWidgetIds(new ComponentName(paramContext, ResponsiveWidget.class));
    }
    return null;
  }
  
  public static void handleSignin(Context paramContext)
  {
    int[] arrayOfInt = getAppWidgetIds(paramContext);
    if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
      ResponsiveWidget.updateAllAppWidgets(paramContext, arrayOfInt);
    }
    updateActiveUserListenerState(paramContext, arrayOfInt);
  }
  
  public static void handleSignout(ApplicationComponent paramApplicationComponent)
  {
    FeatureLog.i("AppWidgetUtils", "sign out, widget clearing everything", "App Widget");
    paramApplicationComponent.appwidgetValues().clear();
    paramApplicationComponent = paramApplicationComponent.appContext();
    int[] arrayOfInt = getAppWidgetIds(paramApplicationComponent);
    if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
      ResponsiveWidget.updateAllAppWidgets(paramApplicationComponent, arrayOfInt);
    }
    updateActiveUserListenerState(paramApplicationComponent, arrayOfInt);
  }
  
  public static void recordWidgetLoad(ApplicationComponent paramApplicationComponent, int paramInt)
  {
    FeatureLog.i("AppWidgetUtils", "[" + paramInt + "] widget loaded", "App Widget");
    AppWidgetKeyValueStore localAppWidgetKeyValueStore = paramApplicationComponent.appwidgetValues();
    paramApplicationComponent.timeWrapper();
    long l = System.currentTimeMillis();
    localAppWidgetKeyValueStore.getPreferences().edit().putLong(AppWidgetKeyValueStore.lastUpdateKey(paramInt), l).apply();
  }
  
  public static void trackWidgetButtonPress(Tracker paramTracker, String paramString)
  {
    FeatureLog.i("AppWidgetUtils", "widget button press [" + paramString + "]", "App Widget");
    PageInstance localPageInstance = new PageInstance(paramTracker, "androidwidget", UUID.randomUUID());
    currentPageInstance = localPageInstance;
    new PageViewEvent(paramTracker, "androidwidget", true, localPageInstance).send();
    new ControlInteractionEvent(paramTracker, paramString, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
  }
  
  public static void trackWidgetEvent$42c523c(String paramString)
  {
    FeatureLog.i("AppWidgetUtils", "widget event [" + paramString + "]", "App Widget");
  }
  
  public static void tryCacheThenNetwork(final ApplicationComponent paramApplicationComponent, MultiplexRequest.Builder paramBuilder, final MultiplexCompletionCallback paramMultiplexCompletionCallback)
  {
    paramBuilder.filter(DataManager.DataStoreFilter.LOCAL_ONLY);
    completionCallback = new MultiplexCompletionCallback()
    {
      public final void onRequestComplete(Map<String, DataStoreResponse> paramAnonymousMap, DataManagerException paramAnonymousDataManagerException, DataStore.Type paramAnonymousType)
      {
        if ((paramAnonymousType == DataStore.Type.LOCAL) && ((paramAnonymousDataManagerException != null) || (paramAnonymousMap.isEmpty())))
        {
          val$builder.filter(DataManager.DataStoreFilter.NETWORK_ONLY);
          paramApplicationComponent.dataManager().submit(val$builder.build());
          return;
        }
        paramMultiplexCompletionCallback.onRequestComplete(paramAnonymousMap, paramAnonymousDataManagerException, paramAnonymousType);
      }
    };
    paramApplicationComponent.dataManager().submit(paramBuilder.build());
  }
  
  public static boolean updateActiveUserListenerState(Context paramContext, int[] paramArrayOfInt)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = getAppWidgetIds(paramContext);
    }
    boolean bool = false;
    paramArrayOfInt = getAppComponent(paramContext);
    if (paramArrayOfInt != null)
    {
      if ((paramArrayOfInt.auth().isAuthenticated()) && (arrayOfInt != null) && (arrayOfInt.length > 0)) {
        bool = true;
      }
    }
    else
    {
      Util.setComponentEnabled(paramContext, ResponsiveWidget.ActiveUserListener.class, bool);
      paramArrayOfInt = new StringBuilder("widget active user listener is now ");
      if (!bool) {
        break label95;
      }
    }
    label95:
    for (paramContext = "enabled";; paramContext = "disabled")
    {
      FeatureLog.i("AppWidgetUtils", paramContext, "App Widget");
      return bool;
      bool = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.appwidget.AppWidgetUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */