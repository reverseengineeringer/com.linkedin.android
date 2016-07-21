package com.linkedin.android.feed.updates.common.comment.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.feed.updates.common.footer.SocialFooterViewHolder;
import com.linkedin.android.infra.shared.KeyboardUtil;

final class CommentDetailFragment$9
  implements View.OnClickListener
{
  CommentDetailFragment$9(CommentDetailFragment paramCommentDetailFragment) {}
  
  public final void onClick(View paramView)
  {
    if ((this$0.mentionsRecyclerView != null) && (this$0.mentionsRecyclerView.getVisibility() == 0) && (CommentDetailFragment.access$500(this$0) != null))
    {
      CommentDetailFragment.access$500(this$0).displaySuggestions(false);
      return;
    }
    paramView = this$0.keyboardUtil;
    KeyboardUtil.hideKeyboard(access$1400this$0).reply);
    FeedNavigationUtils.navigateUp(this$0.activityComponent, false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */