package com.linkedin.android.feed.endor.ui.component.likesrollup.rollupitem;

import android.view.LayoutInflater;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;

public final class FeedLikesRollupItemViewModel
  extends FeedComponentViewModel<FeedLikesRollupItemViewHolder, FeedLikesRollupItemLayout>
{
  public String actorId;
  public ImageModel actorImage;
  
  public FeedLikesRollupItemViewModel()
  {
    super(new FeedLikesRollupItemLayout());
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedLikesRollupItemViewHolder paramFeedLikesRollupItemViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedLikesRollupItemViewHolder);
    paramFeedLikesRollupItemViewHolder.show();
    actorImage.setImageView(paramMediaCenter, actorImage);
  }
  
  public final ViewHolderCreator<FeedLikesRollupItemViewHolder> getCreator()
  {
    return FeedLikesRollupItemViewHolder.CREATOR;
  }
  
  public final boolean handlesViewModelChanges()
  {
    return true;
  }
  
  public final boolean isChangeableTo(ViewModel paramViewModel)
  {
    return ((paramViewModel instanceof FeedLikesRollupItemViewModel)) && (Util.safeEquals(actorId, actorId));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likesrollup.rollupitem.FeedLikesRollupItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */