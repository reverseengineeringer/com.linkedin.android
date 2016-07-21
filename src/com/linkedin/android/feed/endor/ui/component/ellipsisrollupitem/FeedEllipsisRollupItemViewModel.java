package com.linkedin.android.feed.endor.ui.component.ellipsisrollupitem;

import android.view.LayoutInflater;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;

public final class FeedEllipsisRollupItemViewModel
  extends FeedComponentViewModel<FeedEllipsisRollupItemViewHolder, FeedEllipsisRollupItemLayout>
{
  public FeedEllipsisRollupItemViewModel()
  {
    super(new FeedEllipsisRollupItemLayout());
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedEllipsisRollupItemViewHolder paramFeedEllipsisRollupItemViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedEllipsisRollupItemViewHolder);
    paramFeedEllipsisRollupItemViewHolder.show();
  }
  
  public final ViewHolderCreator<FeedEllipsisRollupItemViewHolder> getCreator()
  {
    return FeedEllipsisRollupItemViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.ellipsisrollupitem.FeedEllipsisRollupItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */