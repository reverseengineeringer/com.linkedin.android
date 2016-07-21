package com.linkedin.android.tracking.v2.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public class TrackingOnClickListener
  implements View.OnClickListener
{
  private final MultipleTrackingEventSender sender;
  
  public TrackingOnClickListener(Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    sender = new MultipleTrackingEventSender(paramTracker, new ControlInteractionEvent(paramTracker, paramString, ControlType.BUTTON, InteractionType.SHORT_PRESS), paramVarArgs);
  }
  
  public final void addCustomTrackingEventBuilder(TrackingEventBuilder paramTrackingEventBuilder)
  {
    sender.addCustomTrackingEventBuilder(paramTrackingEventBuilder);
  }
  
  public void onClick(View paramView)
  {
    sender.sendAll();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */