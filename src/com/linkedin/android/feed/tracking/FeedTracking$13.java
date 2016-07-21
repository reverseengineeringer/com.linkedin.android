package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.feed.shared.FeedFollowEntityOnClickListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$13
  extends FeedFollowEntityOnClickListener
{
  FeedTracking$13(FragmentComponent paramFragmentComponent1, String paramString1, FollowingInfo paramFollowingInfo, String paramString2, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent2, Update paramVarArgs)
  {
    super(paramFragmentComponent1, 1, paramString1, paramFollowingInfo, paramString2, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, "followCompany");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */