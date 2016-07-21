package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.feed.events.LoadMoreEvent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class FeedTracking$6
  extends TrackingOnClickListener
{
  FeedTracking$6(Tracker paramTracker, String paramString1, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Update paramUpdate, String paramString2, Comment paramVarArgs)
  {
    super(paramTracker, paramString1, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    val$fragmentComponent.eventBus();
    Bus.publish(LoadMoreEvent.comments(0));
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, "expandMoreComments");
    FeedTracking.access$000(val$fragmentComponent, val$update, val$controlName, val$comment);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */