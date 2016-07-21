package com.linkedin.android.growth.calendar;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class CalendarSyncHelper$1
  extends TrackingOnClickListener
{
  CalendarSyncHelper$1(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, View.OnClickListener paramOnClickListener, FragmentComponent paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (val$onClickListener != null) {
      val$onClickListener.onClick(paramView);
    }
    int i;
    if ((PermissionRequester.hasPermission(val$fragmentComponent.context(), "android.permission.READ_CALENDAR")) && (val$fragmentComponent.activity().applicationComponent.flagshipSharedPreferences().getCalendarSyncEnabled()))
    {
      i = 1;
      if (i == 0) {
        break label129;
      }
      paramView = new CalendarSyncSettingsFragment();
      label76:
      if (i == 0) {
        break label140;
      }
    }
    label129:
    label140:
    for (String str = null;; str = CalendarSyncSplashFragment.BACK_STACK_NAME)
    {
      i = CalendarSyncHelper.getContainerViewId(val$fragmentComponent.activity());
      val$fragmentComponent.activity().getSupportFragmentManager().beginTransaction().add(i, paramView).addToBackStack(str).commit();
      return;
      i = 0;
      break;
      paramView = new CalendarSyncSplashFragment();
      break label76;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */