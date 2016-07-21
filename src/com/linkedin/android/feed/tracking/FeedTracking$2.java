package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.feed.shared.FeedLikeOnClickListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$2
  extends FeedLikeOnClickListener
{
  FeedTracking$2(SocialDetail paramSocialDetail, FragmentComponent paramFragmentComponent1, String paramString, SponsoredMetadata paramSponsoredMetadata, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, Update paramUpdate, FragmentComponent paramVarArgs)
  {
    super(paramSocialDetail, paramFragmentComponent1, paramString, paramSponsoredMetadata, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (val$update.socialDetail.totalSocialActivityCounts.liked) {}
    for (paramView = "unlikeUpdate";; paramView = "likeUpdate")
    {
      FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, paramView);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */