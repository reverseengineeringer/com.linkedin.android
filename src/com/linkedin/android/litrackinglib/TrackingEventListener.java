package com.linkedin.android.litrackinglib;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public abstract interface TrackingEventListener
{
  public abstract void onTrackingEventReceived(TrackingEventBuilder paramTrackingEventBuilder);
  
  public abstract void onTrackingEventReceived(String paramString);
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.TrackingEventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */