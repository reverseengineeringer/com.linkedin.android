package com.linkedin.android.growth.calendar;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class CalendarLearnMoreFragment$1
  extends TrackingOnClickListener
{
  CalendarLearnMoreFragment$1(CalendarLearnMoreFragment paramCalendarLearnMoreFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarLearnMoreFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */