package com.linkedin.android.tracking.v2.listeners;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.AbstractTrackingEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class MultipleTrackingEventSender
{
  private final List<TrackingEventBuilder> customEventBuilders;
  private final AbstractTrackingEvent mainEvent;
  private final Tracker tracker;
  
  public MultipleTrackingEventSender(Tracker paramTracker, AbstractTrackingEvent paramAbstractTrackingEvent, TrackingEventBuilder... paramVarArgs)
  {
    tracker = paramTracker;
    mainEvent = paramAbstractTrackingEvent;
    customEventBuilders = new ArrayList(Arrays.asList(paramVarArgs));
  }
  
  public final void addCustomTrackingEventBuilder(TrackingEventBuilder paramTrackingEventBuilder)
  {
    customEventBuilders.add(paramTrackingEventBuilder);
  }
  
  public final void sendAll()
  {
    mainEvent.send();
    Iterator localIterator = customEventBuilders.iterator();
    while (localIterator.hasNext())
    {
      TrackingEventBuilder localTrackingEventBuilder = (TrackingEventBuilder)localIterator.next();
      if (localTrackingEventBuilder != null) {
        tracker.send(localTrackingEventBuilder);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.listeners.MultipleTrackingEventSender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */