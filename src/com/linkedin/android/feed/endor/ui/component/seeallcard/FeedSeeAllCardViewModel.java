package com.linkedin.android.feed.endor.ui.component.seeallcard;

import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselComponentViewModel;
import com.linkedin.android.feed.shared.StackedImagesDrawable.Builder;
import com.linkedin.android.imageloader.ManagedDrawableWrapper;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.List;

public final class FeedSeeAllCardViewModel
  extends FeedCarouselComponentViewModel<FeedSeeAllCardViewHolder, FeedSeeAllCardLayout>
{
  public List<ImageModel> images;
  private final ManagedDrawableWrapper managedDrawable = new ManagedDrawableWrapper();
  public int rollupCount;
  public TrackingOnClickListener seeAllOnClickListener;
  
  public FeedSeeAllCardViewModel(FeedSeeAllCardLayout paramFeedSeeAllCardLayout)
  {
    super(paramFeedSeeAllCardLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedSeeAllCardViewHolder paramFeedSeeAllCardViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedSeeAllCardViewHolder);
    if (images != null)
    {
      paramLayoutInflater = new StackedImagesDrawable.Builder(itemView.getContext(), paramMediaCenter, images);
      rollupCount = rollupCount;
      paramLayoutInflater = paramLayoutInflater.build();
      JellyBeanUtils.setBackground(stackedImages, paramLayoutInflater);
      managedDrawable.setDrawable(paramLayoutInflater);
    }
    ViewUtils.setOnClickListenerAndUpdateClickable(actionButton, seeAllOnClickListener, true);
    ViewUtils.setOnClickListenerAndUpdateClickable(itemView, seeAllOnClickListener);
  }
  
  private void onRecycleViewHolder(FeedSeeAllCardViewHolder paramFeedSeeAllCardViewHolder)
  {
    managedDrawable.release();
    JellyBeanUtils.setBackground(stackedImages, null);
    super.onRecycleViewHolder(paramFeedSeeAllCardViewHolder);
  }
  
  public final ViewHolderCreator<FeedSeeAllCardViewHolder> getCreator()
  {
    return FeedSeeAllCardViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.seeallcard.FeedSeeAllCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */