package com.linkedin.android.feed.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.feed.tracking.MentionsTracking;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionActionType;

final class FeedUpdateDetailFragment$9
  implements View.OnClickListener
{
  FeedUpdateDetailFragment$9(FeedUpdateDetailFragment paramFeedUpdateDetailFragment) {}
  
  public final void onClick(View paramView)
  {
    if ((this$0.mentionsRecyclerView != null) && (this$0.mentionsRecyclerView.getVisibility() == 0) && (FeedUpdateDetailFragment.access$2300(this$0) != null))
    {
      FeedUpdateDetailFragment.access$2300(this$0).displaySuggestions(false);
      MentionsTracking.fireMentionSuggestionActionEvent(this$0.fragmentComponent, this$0.mentionsPresenter.query, FeedUpdateDetailFragment.access$2400(this$0), MentionActionType.DISMISS, null);
      return;
    }
    FeedNavigationUtils.navigateUp(this$0.activityComponent, false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */