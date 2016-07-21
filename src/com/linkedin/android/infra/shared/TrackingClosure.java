package com.linkedin.android.infra.shared;

import com.linkedin.android.litrackinglib.metric.Tracker;

public abstract class TrackingClosure<IN, OUT>
  implements Closure<IN, OUT>
{
  public final String controlName;
  public final Tracker tracker;
  
  public TrackingClosure(Tracker paramTracker, String paramString)
  {
    tracker = paramTracker;
    controlName = paramString;
  }
  
  public static TrackingClosure<Void, Void> createEmptyTrackingClosure(Tracker paramTracker, String paramString)
  {
    return new TrackingClosure.1(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.TrackingClosure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */