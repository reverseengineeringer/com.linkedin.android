package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.feed.shared.FeedLikeOnClickListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$3
  extends FeedLikeOnClickListener
{
  FeedTracking$3(SocialDetail paramSocialDetail1, FragmentComponent paramFragmentComponent1, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, SocialDetail paramSocialDetail2, FragmentComponent paramFragmentComponent2, Update paramVarArgs)
  {
    super(paramSocialDetail1, paramFragmentComponent1, paramString, paramArrayOfTrackingEventBuilder, (byte)0);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (val$socialDetail.totalSocialActivityCounts.liked) {}
    for (paramView = "unlikeComment";; paramView = "likeComment")
    {
      FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, paramView);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */