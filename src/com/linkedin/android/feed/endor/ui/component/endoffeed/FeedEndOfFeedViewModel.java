package com.linkedin.android.feed.endor.ui.component.endoffeed;

import android.view.LayoutInflater;
import android.widget.Button;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedEndOfFeedViewModel
  extends FeedComponentViewModel<FeedEndOfFeedViewHolder, FeedEndOfFeedLayout>
{
  public CharSequence buttonText;
  public TrackingOnClickListener clickListener;
  public CharSequence linkText;
  public CharSequence text;
  
  public FeedEndOfFeedViewModel(FeedEndOfFeedLayout paramFeedEndOfFeedLayout)
  {
    super(paramFeedEndOfFeedLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedEndOfFeedViewHolder paramFeedEndOfFeedViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedEndOfFeedViewHolder);
    updateViewHolder(paramFeedEndOfFeedViewHolder);
  }
  
  private void updateViewHolder(FeedEndOfFeedViewHolder paramFeedEndOfFeedViewHolder)
  {
    ViewUtils.setTextAndUpdateVisibility(text, text);
    ViewUtils.setTextAndUpdateVisibility(button, buttonText);
    ViewUtils.setTextAndUpdateVisibility(link, linkText);
    button.setOnClickListener(clickListener);
    link.setOnClickListener(clickListener);
  }
  
  public final ViewHolderCreator<FeedEndOfFeedViewHolder> getCreator()
  {
    return FeedEndOfFeedViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.endoffeed.FeedEndOfFeedViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */