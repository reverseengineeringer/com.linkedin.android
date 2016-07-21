package com.linkedin.android.litrackinglib.viewport;

import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public abstract interface ImpressionTracker
{
  public abstract void send(TrackingEventBuilder paramTrackingEventBuilder, PageInstance paramPageInstance);
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.viewport.ImpressionTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */