package com.linkedin.android.entities.viewmodels.cards;

import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class EntityFeedUpdateWrapperCardViewModel
  extends EntityBaseCardViewModel<FeedSingleUpdateViewHolder>
{
  public FeedUpdateViewModel feedUpdateViewModel;
  
  public final ViewHolderCreator<FeedSingleUpdateViewHolder> getCreator()
  {
    return FeedSingleUpdateViewHolder.CREATOR;
  }
  
  public final boolean handlesViewModelChanges()
  {
    if (feedUpdateViewModel != null) {
      return feedUpdateViewModel.handlesViewModelChanges();
    }
    return super.handlesViewModelChanges();
  }
  
  public final boolean isChangeableTo(ViewModel paramViewModel)
  {
    if (feedUpdateViewModel != null) {
      return feedUpdateViewModel.isChangeableTo(feedUpdateViewModel);
    }
    return super.isChangeableTo(paramViewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */