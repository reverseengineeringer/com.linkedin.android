package com.linkedin.android.tracking.v2.event;

import com.linkedin.android.litrackinglib.metric.IMetricJSONAdapter;

public abstract interface TrackingEvent
  extends IMetricJSONAdapter
{
  public abstract String getTrackingDetailsForOverlay();
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.event.TrackingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */