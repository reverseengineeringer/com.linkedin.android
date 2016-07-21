package com.linkedin.android.feed.tracking;

import android.text.TextUtils;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent;
import com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent.Builder;

final class FeedTracking$FeedActionEventBuilder
  extends FeedActionEvent.Builder
{
  private String controlName;
  private Tracker tracker;
  
  public final FeedActionEvent build()
    throws BuilderException
  {
    String str;
    if ((tracker != null) && (!TextUtils.isEmpty(controlName)))
    {
      str = TrackingUtils.makeControlUrnFromControlName(tracker, controlName);
      if (str != null) {
        break label48;
      }
      hasControlUrn = false;
    }
    for (controlUrn = null;; controlUrn = str)
    {
      return super.build();
      label48:
      hasControlUrn = true;
    }
  }
  
  public final FeedActionEventBuilder setControlName(Tracker paramTracker, String paramString)
  {
    tracker = paramTracker;
    controlName = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.FeedActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */