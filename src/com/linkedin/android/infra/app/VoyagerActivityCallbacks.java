package com.linkedin.android.infra.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.linkedin.android.axle.InstallReferrerReceiver;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.events.ApplicationLifecycleEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.logger.Log;
import com.linkedin.gen.avro2pegasus.events.mobile.ApplicationStateChangeType;
import java.util.concurrent.atomic.AtomicBoolean;

public class VoyagerActivityCallbacks
  implements Application.ActivityLifecycleCallbacks
{
  private static final String TAG = VoyagerActivityCallbacks.class.getSimpleName();
  private final FlagshipApplication application;
  public Activity currentActivity;
  private boolean isFirstLaunch;
  
  public VoyagerActivityCallbacks(FlagshipApplication paramFlagshipApplication)
  {
    application = paramFlagshipApplication;
    isFirstLaunch = true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Log.v(TAG, "onActivityCreated " + paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Log.v(TAG, "onActivityDestroyed " + paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Log.v(TAG, "onActivityPaused " + paramActivity.getClass().getSimpleName());
    if (paramActivity == currentActivity) {
      currentActivity = null;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Log.v(TAG, "onActivityResumed " + paramActivity.getClass().getSimpleName());
    currentActivity = paramActivity;
    if (FlagshipApplication.IS_BACKGROUND.getAndSet(false))
    {
      paramActivity = application;
      boolean bool = isFirstLaunch;
      paramActivity.getAppComponent().launchUtils().onAppEnteredForeground(paramActivity, paramActivity.getAppComponent().auth().isAuthenticated(), bool);
      paramActivity.sendApplicationSessionEvent(ApplicationStateChangeType.APPLICATION_FOREGROUND);
      InstallReferrerReceiver.trackAppLaunched(paramActivity);
      paramActivity.getAppComponent().eventBus();
      Bus.publish(new ApplicationLifecycleEvent(0));
      isFirstLaunch = false;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    Log.v(TAG, "onActivitySaveInstanceState " + paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    Log.v(TAG, "onActivityStarted " + paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Log.v(TAG, "onActivityStopped " + paramActivity.getClass().getSimpleName());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.VoyagerActivityCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */