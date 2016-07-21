package com.linkedin.android.feed.endor.ui;

import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.infra.ViewHolderCreator;

public final class FeedLoadingAnimationViewModel
  extends FeedItemViewModel<FeedLoadingAnimationViewHolder>
{
  public final ViewHolderCreator<FeedLoadingAnimationViewHolder> getCreator()
  {
    return FeedLoadingAnimationViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedLoadingAnimationViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */