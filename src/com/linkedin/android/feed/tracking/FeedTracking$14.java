package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.feed.page.feed.newupdatespill.FeedNewUpdatesPillEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class FeedTracking$14
  extends TrackingOnClickListener
{
  FeedTracking$14(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, Bus paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    Bus.publish(new FeedNewUpdatesPillEvent(3));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */