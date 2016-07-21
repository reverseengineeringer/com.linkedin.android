package com.linkedin.android.infra.shared;

import android.app.Activity;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;

public final class CrossActivitySnackbarCallbacks
  extends DefaultActivityLifecycleCallbacks
{
  private FlagshipApplication application;
  private SnackbarUtil.Builder snackbarBuilder;
  
  public CrossActivitySnackbarCallbacks(FlagshipApplication paramFlagshipApplication, int paramInt)
  {
    this(paramFlagshipApplication, new SnackbarBuilder.1(paramFlagshipApplication, paramInt));
  }
  
  public CrossActivitySnackbarCallbacks(FlagshipApplication paramFlagshipApplication, SnackbarUtil.Builder paramBuilder)
  {
    application = paramFlagshipApplication;
    snackbarBuilder = paramBuilder;
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = snackbarBuilder.build();
    application.getAppComponent().snackbarUtil();
    SnackbarUtil.show(paramActivity, application.getAppComponent().tracker());
    application.unregisterActivityLifecycleCallbacks(this);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.CrossActivitySnackbarCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */