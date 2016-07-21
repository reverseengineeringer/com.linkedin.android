package com.linkedin.android.feed.endor.ui.component.comment;

import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.ExpandableTextView.OnHeightChangeListener;

final class FeedCommentViewModel$1
  implements ExpandableTextView.OnHeightChangeListener
{
  FeedCommentViewModel$1(FeedCommentViewModel paramFeedCommentViewModel) {}
  
  public final void onHeightChanged$2231e745(ExpandableTextView paramExpandableTextView)
  {
    this$0.isCommentExpanded = paramExpandableTextView.isExpanded();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */