package com.linkedin.android.infra.shared;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.VoyagerActivityCallbacks;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.MobileApplicationErrorEvent;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.gen.avro2pegasus.events.ApplicationBuildType;
import com.linkedin.gen.avro2pegasus.events.ErrorType;
import javax.inject.Inject;

public final class SnackbarUtil
{
  @Inject
  FlagshipApplication app;
  
  public SnackbarUtil(Context paramContext)
  {
    app = ((FlagshipApplication)paramContext.getApplicationContext());
  }
  
  public static Snackbar make(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView != null) {
      return Snackbar.make(paramView, paramInt1, paramInt2);
    }
    return null;
  }
  
  public static void show(Snackbar paramSnackbar, Tracker paramTracker)
  {
    if (paramSnackbar != null)
    {
      paramSnackbar.show();
      new PageViewEvent(paramTracker, "snackbar", false).send();
    }
  }
  
  public static void showWithErrorTracking$6c58675c(Snackbar paramSnackbar, Tracker paramTracker, PageInstance paramPageInstance, String paramString)
  {
    if (paramSnackbar == null) {
      return;
    }
    show(paramSnackbar, paramTracker);
    new MobileApplicationErrorEvent(paramTracker, ApplicationBuildType.PRODUCTION, "Voyager", "0.21.208", paramString, null, ErrorType.LOGGED_ERROR, paramPageInstance).send();
  }
  
  public final Snackbar make(int paramInt1, int paramInt2)
  {
    return make(app.getCurrentContentView(), paramInt1, paramInt2);
  }
  
  public final Snackbar make(CharSequence paramCharSequence, int paramInt)
  {
    View localView = app.getCurrentContentView();
    if (localView != null) {
      return Snackbar.make(localView, paramCharSequence, paramInt);
    }
    return null;
  }
  
  public final void showWhenAvailable(SnackbarUtil.Builder paramBuilder)
  {
    showWhenAvailableWithErrorTracking$62c2858b(paramBuilder, null, null, null);
  }
  
  public final void showWhenAvailableWithErrorTracking$62c2858b(SnackbarUtil.Builder paramBuilder, Tracker paramTracker, PageInstance paramPageInstance, String paramString)
  {
    Snackbar localSnackbar = paramBuilder.build();
    Activity localActivity = app.activityLifecycleCallbacks.currentActivity;
    if ((localSnackbar != null) && (localActivity != null) && (!localActivity.isFinishing()))
    {
      if ((paramTracker != null) && (paramPageInstance != null) && (paramString != null))
      {
        showWithErrorTracking$6c58675c(localSnackbar, paramTracker, paramPageInstance, paramString);
        return;
      }
      show(localSnackbar, app.getAppComponent().tracker());
      return;
    }
    app.registerActivityLifecycleCallbacks(new CrossActivitySnackbarCallbacks(app, paramBuilder));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.SnackbarUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */