package com.linkedin.android.feed.endor.ui.component.commentloading;

import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;

public final class FeedCommentLoadingLayout
  extends FeedComponentLayout<FeedCommentLoadingViewHolder>
{
  private boolean showBottomDivider;
  private boolean showTopDivider;
  private int startMargin;
  
  public FeedCommentLoadingLayout(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    showTopDivider = paramBoolean1;
    showBottomDivider = paramBoolean2;
    startMargin = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */