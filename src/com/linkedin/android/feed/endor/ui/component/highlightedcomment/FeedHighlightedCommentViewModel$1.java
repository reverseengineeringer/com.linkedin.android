package com.linkedin.android.feed.endor.ui.component.highlightedcomment;

import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.ExpandableTextView.OnHeightChangeListener;

final class FeedHighlightedCommentViewModel$1
  implements ExpandableTextView.OnHeightChangeListener
{
  FeedHighlightedCommentViewModel$1(FeedHighlightedCommentViewModel paramFeedHighlightedCommentViewModel) {}
  
  public final void onHeightChanged$2231e745(ExpandableTextView paramExpandableTextView)
  {
    this$0.isHighlightedCommentaryExpanded = paramExpandableTextView.isExpanded();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.highlightedcomment.FeedHighlightedCommentViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */