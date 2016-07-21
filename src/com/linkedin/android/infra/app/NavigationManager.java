package com.linkedin.android.infra.app;

import android.app.Activity;
import android.content.Intent;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.logger.Log;
import javax.inject.Inject;

public class NavigationManager
{
  private static final String TAG = NavigationManager.class.getSimpleName();
  private final FlagshipApplication application;
  
  @Inject
  public NavigationManager(FlagshipApplication paramFlagshipApplication)
  {
    application = paramFlagshipApplication;
  }
  
  public final void navigate(Intent paramIntent)
  {
    Activity localActivity = application.activityLifecycleCallbacks.currentActivity;
    if (localActivity == null)
    {
      Log.e(TAG, "No current activity, ignoring request for navigation to " + paramIntent);
      return;
    }
    localActivity.startActivity(paramIntent);
  }
  
  public final <B extends BundleBuilder> void navigate(IntentFactory<B> paramIntentFactory, B paramB)
  {
    Activity localActivity = application.activityLifecycleCallbacks.currentActivity;
    if (localActivity == null)
    {
      Log.e(TAG, "No current activity, ignoring request for navigation to " + paramIntentFactory);
      return;
    }
    navigate(paramIntentFactory.newIntent(localActivity, paramB));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.NavigationManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */