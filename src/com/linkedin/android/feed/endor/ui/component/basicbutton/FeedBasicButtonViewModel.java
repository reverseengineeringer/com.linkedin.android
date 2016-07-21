package com.linkedin.android.feed.endor.ui.component.basicbutton;

import android.view.LayoutInflater;
import android.widget.Button;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedBasicButtonViewModel
  extends FeedComponentViewModel<FeedBasicButtonViewHolder, FeedBasicButtonLayout>
{
  public TrackingOnClickListener clickListener;
  public CharSequence text;
  
  public FeedBasicButtonViewModel(FeedBasicButtonLayout paramFeedBasicButtonLayout)
  {
    super(paramFeedBasicButtonLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedBasicButtonViewHolder paramFeedBasicButtonViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedBasicButtonViewHolder);
    updateViewHolder(paramFeedBasicButtonViewHolder);
  }
  
  private void updateViewHolder(FeedBasicButtonViewHolder paramFeedBasicButtonViewHolder)
  {
    button.setText(text);
    button.setOnClickListener(clickListener);
  }
  
  public final ViewHolderCreator<FeedBasicButtonViewHolder> getCreator()
  {
    return FeedBasicButtonViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */