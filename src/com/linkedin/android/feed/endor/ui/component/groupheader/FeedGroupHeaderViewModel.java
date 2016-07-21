package com.linkedin.android.feed.endor.ui.component.groupheader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;

public final class FeedGroupHeaderViewModel
  extends FeedComponentViewModel<FeedGroupHeaderViewHolder, FeedComponentLayout<FeedGroupHeaderViewHolder>>
{
  public View.OnClickListener groupHeaderClickListener;
  public ImageModel groupHeaderIcon;
  public String groupHeaderName;
  
  public FeedGroupHeaderViewModel(FeedComponentLayout paramFeedComponentLayout)
  {
    super(paramFeedComponentLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedGroupHeaderViewHolder paramFeedGroupHeaderViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedGroupHeaderViewHolder);
    ViewUtils.setTextAndUpdateVisibility(groupHeaderName, groupHeaderName);
    if (groupHeaderIcon != null) {
      groupHeaderIcon.setImageView(paramMediaCenter, groupHeaderIcon);
    }
    itemView.setOnClickListener(groupHeaderClickListener);
  }
  
  public final ViewHolderCreator<FeedGroupHeaderViewHolder> getCreator()
  {
    return FeedGroupHeaderViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.groupheader.FeedGroupHeaderViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */