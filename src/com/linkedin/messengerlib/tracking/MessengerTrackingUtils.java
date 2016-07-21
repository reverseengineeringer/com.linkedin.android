package com.linkedin.messengerlib.tracking;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.MultipleTrackingEventSender;

public final class MessengerTrackingUtils
{
  public static void sendButtonShortPressEvent(Tracker paramTracker, String paramString)
  {
    sendEvent(paramTracker, paramString, ControlType.BUTTON, InteractionType.SHORT_PRESS);
  }
  
  public static void sendEvent(Tracker paramTracker, String paramString, ControlType paramControlType, InteractionType paramInteractionType)
  {
    new MultipleTrackingEventSender(paramTracker, new ControlInteractionEvent(paramTracker, paramString, paramControlType, paramInteractionType), new TrackingEventBuilder[0]).sendAll();
  }
  
  public static void sendPageViewEvent(Tracker paramTracker, String paramString, boolean paramBoolean)
  {
    new PageViewEvent(paramTracker, paramString, paramBoolean).send();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.tracking.MessengerTrackingUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */