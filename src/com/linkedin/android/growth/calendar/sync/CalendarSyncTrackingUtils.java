package com.linkedin.android.growth.calendar.sync;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.MultipleTrackingEventSender;

public final class CalendarSyncTrackingUtils
{
  public static void trackCalendarSyncControlInteractionEvent(Tracker paramTracker, String paramString, ControlType paramControlType, InteractionType paramInteractionType)
  {
    new MultipleTrackingEventSender(paramTracker, new ControlInteractionEvent(paramTracker, paramString, paramControlType, paramInteractionType), new TrackingEventBuilder[0]).sendAll();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.sync.CalendarSyncTrackingUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */