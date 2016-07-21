package com.linkedin.android.tracking.v2.event;

import com.linkedin.android.litrackinglib.metric.Tracker;

public class ControlInteractionEvent
  extends AbstractTrackingEvent
{
  public final String controlName;
  public final ControlType controlType;
  public final InteractionType interactionType;
  
  public ControlInteractionEvent(Tracker paramTracker, String paramString, ControlType paramControlType, InteractionType paramInteractionType)
  {
    super(paramTracker);
    controlName = paramString;
    controlType = paramControlType;
    interactionType = paramInteractionType;
  }
  
  public final String getTrackingDetailsForOverlay()
  {
    return ControlInteractionEvent.class.getSimpleName() + " - " + controlName + ", " + controlType + ", " + interactionType;
  }
  
  public String toString()
  {
    return "controlName: " + controlName + ", controlType: " + controlType + ", UIInteractionType: " + interactionType;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.event.ControlInteractionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */