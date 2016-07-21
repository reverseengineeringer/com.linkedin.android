package com.linkedin.android.feed.endor.ui.component.contentanalytics;

import android.view.LayoutInflater;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;

public final class FeedContentAnalyticsEntryViewModel
  extends FeedBasicTextViewModel
{
  public FeedContentAnalyticsEntryViewModel(FeedBasicTextLayout paramFeedBasicTextLayout)
  {
    super(paramFeedBasicTextLayout);
  }
  
  private void bind(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    textView.setText(text);
    ViewUtils.setOnClickListenerAndUpdateClickable(textView, clickListener, true);
  }
  
  public final ViewHolderCreator<FeedBasicTextViewHolder> getCreator()
  {
    return FeedBasicTextViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedBasicTextViewHolder);
    bind(paramFeedBasicTextViewHolder);
  }
  
  public final void onViewModelChange$5a968a75(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    bind(paramFeedBasicTextViewHolder);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentanalytics.FeedContentAnalyticsEntryViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */