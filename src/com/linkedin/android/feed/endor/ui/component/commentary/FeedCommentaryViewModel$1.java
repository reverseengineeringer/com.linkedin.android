package com.linkedin.android.feed.endor.ui.component.commentary;

import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.ExpandableTextView.OnHeightChangeListener;

final class FeedCommentaryViewModel$1
  implements ExpandableTextView.OnHeightChangeListener
{
  FeedCommentaryViewModel$1(FeedCommentaryViewModel paramFeedCommentaryViewModel) {}
  
  public final void onHeightChanged$2231e745(ExpandableTextView paramExpandableTextView)
  {
    this$0.isCommentaryExpanded = paramExpandableTextView.isExpanded();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentary.FeedCommentaryViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */