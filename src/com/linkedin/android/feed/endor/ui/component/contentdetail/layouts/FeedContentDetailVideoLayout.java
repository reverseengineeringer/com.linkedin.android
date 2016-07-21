package com.linkedin.android.feed.endor.ui.component.contentdetail.layouts;

import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewHolder;

public final class FeedContentDetailVideoLayout
  extends FeedContentDetailLayout
{
  private final boolean removeBorder;
  
  public FeedContentDetailVideoLayout(boolean paramBoolean)
  {
    removeBorder = paramBoolean;
  }
  
  public final void apply(FeedContentDetailViewHolder paramFeedContentDetailViewHolder)
  {
    super.apply(paramFeedContentDetailViewHolder);
  }
  
  public final FeedComponentLayout.Borders getBorders()
  {
    if (removeBorder) {
      return null;
    }
    return super.getBorders();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailVideoLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */