package com.linkedin.android.feed.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

final class FeedUpdateDetailFragment$11
  implements View.OnClickListener
{
  FeedUpdateDetailFragment$11(FeedUpdateDetailFragment paramFeedUpdateDetailFragment) {}
  
  public final void onClick(View paramView)
  {
    FeatureLog.i(FeedUpdateDetailFragment.access$2700(), "dismissComposeView onClick", "Feed Logging");
    this$0.dismissComposeView.setVisibility(8);
    FeedUpdateDetailFragment.access$2300(this$0).setupSocialFooterState(0);
    this$0.detailRecyclerView.setEnabled(true);
    this$0.detailRecyclerView.setClickable(true);
    FeedUpdateDetailFragment.access$2800(this$0, "feed_detail_container");
    if ((FeedUpdateDetailFragment.access$200(this$0) != null) && (access$200this$0).tracking != null) && (access$200this$0).urn != null)) {
      FeedTracking.trackFAE(this$0.tracker, "feed_detail_container", ActionCategory.DISMISS, "dismissComment", access$200this$0).tracking, access$200this$0).urn, this$0.fragmentComponent);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */