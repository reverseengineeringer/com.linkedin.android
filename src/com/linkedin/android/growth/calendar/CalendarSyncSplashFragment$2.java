package com.linkedin.android.growth.calendar;

import android.view.View;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class CalendarSyncSplashFragment$2
  extends TrackingOnClickListener
{
  CalendarSyncSplashFragment$2(CalendarSyncSplashFragment paramCalendarSyncSplashFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = this$0;
    ((CalendarLearnMoreFragment)fragmentRegistry.calendarLearnMore.newFragment(null)).show(paramView.getFragmentManager(), CalendarLearnMoreFragment.TAG);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncSplashFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */