package com.linkedin.android.feed.shared;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;

public class PullToRefreshListener
  implements SwipeRefreshLayout.OnRefreshListener
{
  private final ControlInteractionEvent trackingEvent;
  
  public PullToRefreshListener(Tracker paramTracker, String paramString)
  {
    trackingEvent = new ControlInteractionEvent(paramTracker, paramString, ControlType.GESTURE_AREA, InteractionType.SWIPE_DOWN);
  }
  
  public void onRefresh()
  {
    trackingEvent.send();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.PullToRefreshListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */