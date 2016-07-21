package com.linkedin.android.feed.endor.ui.component.basictext;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public class FeedBasicTextViewModel
  extends FeedComponentViewModel<FeedBasicTextViewHolder, FeedBasicTextLayout>
{
  public float backgroundAlpha = 1.0F;
  public TrackingOnClickListener clickListener;
  public String componentType;
  public String contentDescription;
  public CharSequence text;
  
  public FeedBasicTextViewModel(FeedBasicTextLayout paramFeedBasicTextLayout)
  {
    super(paramFeedBasicTextLayout);
  }
  
  private void updateViewHolder(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    ViewUtils.setTextAndUpdateVisibility(textView, text);
    ViewUtils.setOnClickListenerAndUpdateClickable(textView, clickListener, true);
    textView.setContentDescription(contentDescription);
    textView.setTag(2131755018, componentType);
    itemView.setAlpha(backgroundAlpha);
  }
  
  public ViewHolderCreator<FeedBasicTextViewHolder> getCreator()
  {
    return FeedBasicTextViewHolder.CREATOR;
  }
  
  public void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedBasicTextViewHolder);
    updateViewHolder(paramFeedBasicTextViewHolder);
  }
  
  public void onViewModelChange$5a968a75(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    updateViewHolder(paramFeedBasicTextViewHolder);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */