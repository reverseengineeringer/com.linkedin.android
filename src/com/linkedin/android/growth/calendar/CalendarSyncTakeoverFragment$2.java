package com.linkedin.android.growth.calendar;

import android.view.View;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class CalendarSyncTakeoverFragment$2
  extends TrackingOnClickListener
{
  CalendarSyncTakeoverFragment$2(CalendarSyncTakeoverFragment paramCalendarSyncTakeoverFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    ((CalendarLearnMoreFragment)this$0.fragmentRegistry.calendarLearnMore.newFragment(null)).show(((BaseActivity)this$0.getActivity()).getSupportFragmentManager(), CalendarLearnMoreFragment.TAG);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */