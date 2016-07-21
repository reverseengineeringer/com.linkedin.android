package com.linkedin.android.feed.endor.ui.component.divider;

import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;

public final class FeedDividerViewModel
  extends FeedComponentViewModel<FeedDividerViewHolder, FeedDividerLayout>
{
  public FeedDividerViewModel(FeedDividerLayout paramFeedDividerLayout)
  {
    super(paramFeedDividerLayout);
  }
  
  public final ViewHolderCreator<FeedDividerViewHolder> getCreator()
  {
    return FeedDividerViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */