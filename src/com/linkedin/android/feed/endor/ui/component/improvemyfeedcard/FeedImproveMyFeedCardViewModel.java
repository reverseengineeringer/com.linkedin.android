package com.linkedin.android.feed.endor.ui.component.improvemyfeedcard;

import android.view.LayoutInflater;
import com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedImproveMyFeedCardViewModel
  extends FeedCarouselComponentViewModel<FeedImproveMyFeedCardViewHolder, FeedImproveMyFeedCardLayout>
{
  public TrackingOnClickListener improveMyFeedOnClickListener;
  
  public FeedImproveMyFeedCardViewModel(FeedImproveMyFeedCardLayout paramFeedImproveMyFeedCardLayout)
  {
    super(paramFeedImproveMyFeedCardLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedImproveMyFeedCardViewHolder paramFeedImproveMyFeedCardViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedImproveMyFeedCardViewHolder);
    ViewUtils.setOnClickListenerAndUpdateClickable(actionButton, improveMyFeedOnClickListener, true);
    ViewUtils.setOnClickListenerAndUpdateClickable(itemView, improveMyFeedOnClickListener);
  }
  
  public final ViewHolderCreator<FeedImproveMyFeedCardViewHolder> getCreator()
  {
    return FeedImproveMyFeedCardViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.improvemyfeedcard.FeedImproveMyFeedCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */