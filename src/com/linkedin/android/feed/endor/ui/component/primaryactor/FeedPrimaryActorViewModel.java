package com.linkedin.android.feed.endor.ui.component.primaryactor;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.TopBarComponent;
import com.linkedin.android.feed.endor.ui.component.primaryactor.layouts.FeedPrimaryActorLayout;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedPrimaryActorViewModel
  extends FeedComponentViewModel<FeedPrimaryActorViewHolder, FeedPrimaryActorLayout>
  implements TopBarComponent
{
  public TrackingOnClickListener actionButtonOnClickListener;
  public TrackingOnClickListener actorClickListener;
  public CharSequence actorHeadline;
  public String actorId;
  public ImageModel actorImage;
  public CharSequence actorName;
  public TrackingOnClickListener actorPictureClickListener;
  public int buttonType = 0;
  public TrackingOnClickListener controlMenuClickListener;
  public boolean isInfluencer;
  private boolean isTopBar;
  public CharSequence secondaryHeadline;
  public CharSequence secondaryHeadlineContentDescription;
  
  public FeedPrimaryActorViewModel(FeedPrimaryActorLayout paramFeedPrimaryActorLayout)
  {
    super(paramFeedPrimaryActorLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedPrimaryActorViewHolder paramFeedPrimaryActorViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedPrimaryActorViewHolder);
    updateViewHolder(paramFeedPrimaryActorViewHolder, paramMediaCenter, true, true, false);
  }
  
  private void updateViewHolder(FeedPrimaryActorViewHolder paramFeedPrimaryActorViewHolder, MediaCenter paramMediaCenter, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ViewUtils.setTextAndUpdateVisibility(actorName, actorName);
    if (isInfluencer) {
      ViewUtils.appendImageSpanToText$71405874(actorName);
    }
    ViewUtils.setTextAndUpdateVisibility(actorHeadline, actorHeadline);
    ViewUtils.setTextAndUpdateVisibility(secondaryHeadline, secondaryHeadline, secondaryHeadlineContentDescription);
    if ((paramBoolean2) && (actorImage != null)) {
      actorImage.setImageView(paramMediaCenter, actorImage);
    }
    if (paramBoolean1) {
      switch (buttonType)
      {
      }
    }
    for (;;)
    {
      actorImage.setOnClickListener(actorPictureClickListener);
      itemView.setOnClickListener(actorClickListener);
      if (isTopBar) {
        ViewUtils.setOnClickListenerAndUpdateVisibility(controlDropdown, controlMenuClickListener);
      }
      return;
      actionButton.setVisibility(8);
      continue;
      actionButton.setText(2131231271);
      ViewUtils.setOnClickListenerAndUpdateVisibility(actionButton, actionButtonOnClickListener);
      actionButton.setTextColor(ContextCompat.getColorStateList(itemView.getContext(), 2130837641));
      continue;
      sponsoredFollowButton.setVisibility(8);
      actionButton.setText(2131231272);
      actionButton.setTextColor(ContextCompat.getColor(actionButton.getContext(), 2131623957));
      ViewUtils.setOnClickListenerAndUpdateClickable(actionButton, null, true);
      actionButton.setVisibility(0);
      if (paramBoolean3)
      {
        ViewCompat.setAlpha(actionButton, 0.0F);
        ViewCompat.animate(actionButton).alpha(1.0F).setDuration(500L).start();
        continue;
        actionButton.setVisibility(8);
        sponsoredFollowButton.setOnClickListener(actionButtonOnClickListener);
        sponsoredFollowButton.setVisibility(0);
        continue;
        actionButton.setText(2131231162);
        ViewUtils.setOnClickListenerAndUpdateVisibility(actionButton, actionButtonOnClickListener);
        actionButton.setTextColor(ContextCompat.getColorStateList(itemView.getContext(), 2130837641));
        continue;
        actionButton.setText(2131231164);
        actionButton.setTextColor(ContextCompat.getColor(actionButton.getContext(), 2131623957));
        ViewUtils.setOnClickListenerAndUpdateClickable(actionButton, null, true);
        actionButton.setVisibility(0);
        if (paramBoolean3)
        {
          ViewCompat.setAlpha(actionButton, 0.0F);
          ViewCompat.animate(actionButton).alpha(1.0F).setDuration(500L).start();
          continue;
          actionButton.setText(2131231167);
          ViewUtils.setOnClickListenerAndUpdateVisibility(actionButton, actionButtonOnClickListener);
          continue;
          downloadButton.setVisibility(0);
          downloadButton.setOnClickListener(actorClickListener);
          continue;
          actionButton.setText(2131231205);
          actionButton.setVisibility(0);
          actionButton.setOnClickListener(actorClickListener);
        }
      }
    }
  }
  
  public final boolean canRenderControlDropdown()
  {
    return controlMenuClickListener != null;
  }
  
  public final ViewHolderCreator<FeedPrimaryActorViewHolder> getCreator()
  {
    return FeedPrimaryActorViewHolder.CREATOR;
  }
  
  public final void setIsTopBar(boolean paramBoolean)
  {
    isTopBar = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */