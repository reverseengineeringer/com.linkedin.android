package com.linkedin.android.feed.updates.common.comment.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

final class CommentDetailFragment$4
  implements View.OnClickListener
{
  CommentDetailFragment$4(CommentDetailFragment paramCommentDetailFragment) {}
  
  public final void onClick(View paramView)
  {
    FeatureLog.i(CommentDetailFragment.access$600(), "dismissComposeView onClick", "Feed Logging");
    this$0.dismissComposeView.setVisibility(8);
    CommentDetailFragment.access$500(this$0).setupSocialFooterState(0);
    this$0.detailRecyclerView.setEnabled(true);
    this$0.detailRecyclerView.setClickable(true);
    CommentDetailFragment.access$700(this$0, "feed_detail_container");
    if ((CommentDetailFragment.access$000(this$0) != null) && (access$000this$0).tracking != null) && (access$000this$0).urn != null)) {
      FeedTracking.trackFAE(this$0.tracker, "feed_detail_container", ActionCategory.DISMISS, "dismissReply", access$000this$0).tracking, access$000this$0).urn, this$0.fragmentComponent);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */