package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.Settings.LazyHolder;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Answers
  extends Kit<Boolean>
{
  public SessionAnalyticsManager analyticsManager;
  
  private Boolean doInBackground()
  {
    try
    {
      Object localObject2 = Settings.LazyHolder.access$100().awaitSettingsData();
      if (localObject2 == null)
      {
        Fabric.getLogger().e("Answers", "Failed to retrieve settings");
        return Boolean.valueOf(false);
      }
      Object localObject3;
      if (featuresData.collectAnalytics)
      {
        Fabric.getLogger().d("Answers", "Analytics collection enabled");
        localObject1 = analyticsManager;
        localObject2 = analyticsSettingsData;
        localObject3 = CommonUtils.getStringsFileValue(context, "com.crashlytics.ApiEndpoint");
        backgroundManager.flushOnBackground = flushOnBackground;
        localObject1 = eventsHandler;
        ((AnswersEventsHandler)localObject1).executeAsync(new AnswersEventsHandler.1((AnswersEventsHandler)localObject1, (AnalyticsSettingsData)localObject2, (String)localObject3));
        return Boolean.valueOf(true);
      }
      Fabric.getLogger().d("Answers", "Analytics collection disabled");
      Object localObject1 = analyticsManager;
      localObject2 = lifecycleManager;
      if (callbacksWrapper != null)
      {
        localObject2 = callbacksWrapper;
        localObject3 = registeredCallbacks.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)((Iterator)localObject3).next();
          application.unregisterActivityLifecycleCallbacks(localActivityLifecycleCallbacks);
        }
      }
      localAnswersEventsHandler = eventsHandler;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Error dealing with settings", localException);
      return Boolean.valueOf(false);
    }
    AnswersEventsHandler localAnswersEventsHandler;
    localAnswersEventsHandler.executeAsync(new AnswersEventsHandler.2(localAnswersEventsHandler));
    return Boolean.valueOf(false);
  }
  
  public final String getIdentifier()
  {
    return "com.crashlytics.sdk.android:answers";
  }
  
  public final String getVersion()
  {
    return "1.3.6.97";
  }
  
  @SuppressLint({"NewApi"})
  protected final boolean onPreExecute()
  {
    for (;;)
    {
      try
      {
        Object localObject2 = context;
        Object localObject3 = ((Context)localObject2).getPackageManager();
        Object localObject4 = ((Context)localObject2).getPackageName();
        Object localObject5 = ((PackageManager)localObject3).getPackageInfo((String)localObject4, 0);
        Object localObject6 = Integer.toString(versionCode);
        Object localObject1;
        if (versionName == null)
        {
          localObject1 = "0.0";
          if (Build.VERSION.SDK_INT >= 9)
          {
            l = firstInstallTime;
            localObject1 = new SessionMetadataCollector((Context)localObject2, idManager, (String)localObject6, (String)localObject1);
            localObject3 = new AnswersFilesManagerProvider((Context)localObject2, new FileStoreImpl(this));
            localObject4 = new DefaultHttpRequestFactory(Fabric.getLogger());
            localObject5 = new ActivityLifecycleManager((Context)localObject2);
            localObject6 = Executors.newSingleThreadScheduledExecutor(ExecutorUtils.getNamedThreadFactory("Answers Events Handler"));
            ExecutorUtils.addDelayedShutdownHook("Answers Events Handler", (ExecutorService)localObject6);
            BackgroundManager localBackgroundManager = new BackgroundManager((ScheduledExecutorService)localObject6);
            analyticsManager = new SessionAnalyticsManager(new AnswersEventsHandler(this, (Context)localObject2, (AnswersFilesManagerProvider)localObject3, (SessionMetadataCollector)localObject1, (HttpRequestFactory)localObject4, (ScheduledExecutorService)localObject6), (ActivityLifecycleManager)localObject5, localBackgroundManager, new AnswersPreferenceManager(new PreferenceStoreImpl((Context)localObject2, "settings")), l);
            localObject1 = analyticsManager;
            localObject2 = eventsHandler;
            ((AnswersEventsHandler)localObject2).executeAsync(new AnswersEventsHandler.4((AnswersEventsHandler)localObject2));
            lifecycleManager.registerCallbacks(new AnswersLifecycleCallbacks((SessionAnalyticsManager)localObject1, backgroundManager));
            backgroundManager.listeners.add(localObject1);
            l = installedAt;
            if (preferenceManager.prefStore.get().getBoolean("analytics_launched", false)) {
              continue;
            }
            if (System.currentTimeMillis() - l >= 3600000L) {
              continue;
            }
            i = 1;
            break label463;
            if (i == 0) {
              break;
            }
            Fabric.getLogger().d("Answers", "Logged install");
            eventsHandler.processEvent(new SessionEvent.Builder(SessionEvent.Type.INSTALL), false, true);
            localObject1 = preferenceManager;
            prefStore.save(prefStore.edit().putBoolean("analytics_launched", true));
            break;
          }
        }
        else
        {
          localObject1 = versionName;
          continue;
        }
        long l = new File(getApplicationInfo0sourceDir).lastModified();
        continue;
        i = 0;
        break label463;
        i = 0;
        continue;
        if (i == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Fabric.getLogger().e("Answers", "Error retrieving app properties", localException);
        return false;
      }
      label463:
      int i = 1;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.Answers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */