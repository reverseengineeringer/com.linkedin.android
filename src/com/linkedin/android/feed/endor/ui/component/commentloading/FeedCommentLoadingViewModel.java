package com.linkedin.android.feed.endor.ui.component.commentloading;

import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedCommentLoadingViewModel
  extends FeedComponentViewModel<FeedCommentLoadingViewHolder, FeedCommentLoadingLayout>
{
  public boolean isLoading;
  public int loadType;
  public TrackingOnClickListener loadingListener;
  public String loadingText;
  
  public FeedCommentLoadingViewModel(FeedCommentLoadingLayout paramFeedCommentLoadingLayout)
  {
    super(paramFeedCommentLoadingLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedCommentLoadingViewHolder paramFeedCommentLoadingViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedCommentLoadingViewHolder);
    setupViews(paramFeedCommentLoadingViewHolder);
  }
  
  private void setupViews(FeedCommentLoadingViewHolder paramFeedCommentLoadingViewHolder)
  {
    if (loadType == 1)
    {
      title.setVisibility(8);
      progressBar.setVisibility(8);
      spinner.setVisibility(0);
      return;
    }
    if (isLoading)
    {
      title.setVisibility(8);
      title.setEnabled(false);
      progressBar.setVisibility(0);
      spinner.setVisibility(8);
      return;
    }
    ViewUtils.setTextAndUpdateVisibility(title, loadingText);
    title.setEnabled(true);
    title.setOnClickListener(loadingListener);
    progressBar.setVisibility(8);
    spinner.setVisibility(8);
  }
  
  public final ViewHolderCreator<FeedCommentLoadingViewHolder> getCreator()
  {
    return FeedCommentLoadingViewHolder.CREATOR;
  }
  
  public final boolean handlesViewModelChanges()
  {
    return true;
  }
  
  public final boolean isChangeableTo(ViewModel paramViewModel)
  {
    return (super.isChangeableTo(paramViewModel)) && ((paramViewModel instanceof FeedCommentLoadingViewModel)) && (loadType == loadType);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */