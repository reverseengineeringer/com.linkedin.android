package com.linkedin.android.feed.endor.ui.component.contentdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailLayout;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.ExpandableTextView.OnHeightChangeListener;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedContentDetailViewModel
  extends FeedComponentViewModel<FeedContentDetailViewHolder, FeedContentDetailLayout>
{
  public CharSequence bodyText;
  TrackingOnClickListener containerClickListener;
  final ExpandableTextView.OnHeightChangeListener heightChangeListener = new ExpandableTextView.OnHeightChangeListener()
  {
    public final void onHeightChanged$2231e745(ExpandableTextView paramAnonymousExpandableTextView)
    {
      isTextExpanded = paramAnonymousExpandableTextView.isExpanded();
    }
  };
  public ImageModel image;
  boolean isTextExpanded;
  public CharSequence subtitle;
  public CharSequence tertiaryText;
  public CharSequence time;
  public CharSequence timeContentDescription;
  public CharSequence title;
  public TrackingData trackingData;
  public String updateUrn;
  
  public FeedContentDetailViewModel(FeedContentDetailLayout paramFeedContentDetailLayout)
  {
    super(paramFeedContentDetailLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedContentDetailViewHolder paramFeedContentDetailViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedContentDetailViewHolder);
    updateViewHolder(paramFeedContentDetailViewHolder, paramMediaCenter);
  }
  
  private void updateViewHolder(FeedContentDetailViewHolder paramFeedContentDetailViewHolder, MediaCenter paramMediaCenter)
  {
    ViewUtils.setTextAndUpdateVisibility(title, title);
    ViewUtils.setTextAndUpdateVisibility(subtitle, subtitle);
    ViewUtils.setTextAndUpdateVisibility(tertiaryText, tertiaryText);
    ViewUtils.setTextAndUpdateVisibility(bodyText, bodyText);
    ViewUtils.setTextAndUpdateVisibility(time, time, timeContentDescription);
    FeedTextUtils.setTextIsSelectable$352fc170(Util.getAppComponent(itemView.getContext()), bodyText);
    if (isTextExpanded)
    {
      bodyText.expand(false);
      if (image == null) {
        break label170;
      }
      image.setVisibility(0);
      image.setImageView(paramMediaCenter, image);
    }
    for (;;)
    {
      if (containerClickListener != null)
      {
        itemView.setOnClickListener(containerClickListener);
        bodyText.setOnClickListener(containerClickListener);
      }
      bodyText.setOnHeightChangedListener(heightChangeListener);
      return;
      bodyText.collapse(false);
      break;
      label170:
      image.setVisibility(8);
    }
  }
  
  public final ViewHolderCreator<FeedContentDetailViewHolder> getCreator()
  {
    return FeedContentDetailViewHolder.CREATOR;
  }
  
  public final void onRestoreUpdateViewState(ViewState paramViewState)
  {
    super.onRestoreUpdateViewState(paramViewState);
    isTextExpanded = bundle.getBoolean("isFeedShareContentDetailTextExpanded", false);
  }
  
  public final void onSaveUpdateViewState(ViewState paramViewState)
  {
    super.onSaveUpdateViewState(paramViewState);
    bundle.putBoolean("isFeedShareContentDetailTextExpanded", isTextExpanded);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */