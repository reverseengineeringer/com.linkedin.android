package com.linkedin.android.feed.tracking;

import android.text.TextUtils;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent;
import com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent.Builder;

final class FeedTracking$FeedCommentActionEventBuilder
  extends FeedCommentActionEvent.Builder
{
  private String controlName;
  private Tracker tracker;
  
  public final FeedCommentActionEvent build()
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
  
  public final FeedCommentActionEventBuilder setControlName(Tracker paramTracker, String paramString)
  {
    tracker = paramTracker;
    controlName = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.FeedCommentActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */