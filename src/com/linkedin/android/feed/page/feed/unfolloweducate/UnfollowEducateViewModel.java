package com.linkedin.android.feed.page.feed.unfolloweducate;

import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.unfollow.education.UnfollowEducateViewHolder;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.FragmentComponent;

public final class UnfollowEducateViewModel
  extends FeedUpdateViewModel<UnfollowEducateViewHolder>
{
  public UnfollowEducateViewModel(FeedComponentsViewPool paramFeedComponentsViewPool, FragmentComponent paramFragmentComponent)
  {
    super(null, paramFragmentComponent.context(), paramFeedComponentsViewPool, paramFragmentComponent.sponsoredUpdateTracker(), paramFragmentComponent.lixManager());
  }
  
  public final ViewHolderCreator<UnfollowEducateViewHolder> getCreator()
  {
    return UnfollowEducateViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */