package com.linkedin.android.feed.endor.ui.component.likerow;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedLikeRowViewModel
  extends FeedComponentViewModel<FeedLikeRowViewHolder, FeedLikeRowLayout>
{
  public boolean isInfluencer;
  public TrackingOnClickListener likeActorClickListener;
  public CharSequence likeActorDistance;
  public CharSequence likeActorHeadline;
  public String likeActorId;
  public ImageModel likeActorImage;
  public CharSequence likeActorInsight;
  public CharSequence likeActorName;
  public CharSequence likeTime;
  public CharSequence likeTimeContentDescription;
  
  public FeedLikeRowViewModel(FeedLikeRowLayout paramFeedLikeRowLayout)
  {
    super(paramFeedLikeRowLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedLikeRowViewHolder paramFeedLikeRowViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedLikeRowViewHolder);
    updateViewHolder(paramFeedLikeRowViewHolder, paramMediaCenter);
  }
  
  private void updateViewHolder(FeedLikeRowViewHolder paramFeedLikeRowViewHolder, MediaCenter paramMediaCenter)
  {
    likeActorName.setText(likeActorName);
    if (isInfluencer) {
      ViewUtils.appendImageSpanToText$71405874(likeActorName);
    }
    TextView localTextView = likeActorBullet;
    if (likeActorDistance != null) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      ViewUtils.setTextAndUpdateVisibility(likeActorDistance, likeActorDistance);
      ViewUtils.setTextAndUpdateVisibility(likeActorHeadline, likeActorHeadline);
      ViewUtils.setTextAndUpdateVisibility(likeActorInsight, likeActorInsight);
      ViewUtils.setTextAndUpdateVisibility(likeTime, likeTime, likeTimeContentDescription);
      if (likeActorImage != null) {
        likeActorImage.setImageView(paramMediaCenter, likeActorImage);
      }
      itemView.setOnClickListener(likeActorClickListener);
      return;
    }
  }
  
  public final ViewHolderCreator<FeedLikeRowViewHolder> getCreator()
  {
    return FeedLikeRowViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likerow.FeedLikeRowViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */