package com.linkedin.android.growth.calendar;

import android.view.View;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class CalendarSyncTakeoverFragment$3
  extends TrackingOnClickListener
{
  CalendarSyncTakeoverFragment$3(CalendarSyncTakeoverFragment paramCalendarSyncTakeoverFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (PermissionRequester.hasPermission(this$0.getContext(), "android.permission.READ_CALENDAR"))
    {
      CalendarSyncTakeoverFragment.access$000(this$0);
      return;
    }
    CalendarSyncHelper.requestCalendarSyncPermission(this$0.fragmentComponent.fragment());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */