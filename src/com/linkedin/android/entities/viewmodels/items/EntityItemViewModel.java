package com.linkedin.android.entities.viewmodels.items;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.linkedin.android.entities.viewholders.EntityItemViewHolder;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.feed.endor.ui.component.insight.FeedInsightViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.makeramen.roundedimageview.RoundedImageView;

public final class EntityItemViewModel
  extends EntityBaseItemViewModel<EntityItemViewHolder>
{
  public String badge;
  public String badgeContentDescription;
  public int ctaButtonIcon;
  public int ctaClickedButtonIcon;
  public Drawable footerIcon;
  public String footerText;
  public ImageModel image;
  public FeedInsightViewModel insight;
  public Animation insightAnimation;
  public boolean isCtaButtonClicked;
  public boolean isImageOval;
  public TrackingClosure<Boolean, Void> onCtaButtonClick;
  public TrackingClosure<ImageView, Void> onRowClick;
  public boolean showNewBadge;
  public String subtitle;
  public String subtitle2;
  public Drawable subtitle2Icon;
  public String superTitle;
  public CharSequence title;
  
  public final ViewHolderCreator<EntityItemViewHolder> getCreator()
  {
    return EntityItemViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, final EntityItemViewHolder paramEntityItemViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramEntityItemViewHolder);
    if (image != null) {
      image.setImageView(paramMediaCenter, image);
    }
    image.setVisibility(0);
    image.setOval(isImageOval);
    title.setText(title);
    ViewUtils.setTextAndUpdateVisibility(superTitle, superTitle);
    ViewUtils.setTextAndUpdateVisibility(subtitle, subtitle);
    if (subtitle2Icon != null)
    {
      subtitle2.setCompoundDrawables(subtitle2Icon, null, null, null);
      ViewUtils.setTextAndUpdateVisibility(subtitle2, subtitle2);
    }
    if (showNewBadge) {
      newBadge.setVisibility(0);
    }
    for (;;)
    {
      if ((footerText != null) || (insight != null)) {
        footer.setVisibility(0);
      }
      ViewUtils.setTextAndUpdateVisibility(footerTextView, footerText);
      if ((footerIcon != null) && (footerText != null)) {
        footerTextView.setCompoundDrawables(footerIcon, null, null, null);
      }
      if ((footerText != null) && (insight != null))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)footerTextView.getLayoutParams();
        localLayoutParams.setMargins((int)footerTextView.getResources().getDimension(2131492989), 0, 0, 0);
        footerTextView.setLayoutParams(localLayoutParams);
      }
      if (insight != null)
      {
        insight.onBindViewHolder(paramLayoutInflater, paramMediaCenter, insightViewHolder);
        if (insightAnimation != null)
        {
          insightViewHolder.textView.startAnimation(insightAnimation);
          insightAnimation = null;
        }
      }
      if ((onCtaButtonClick != null) && (ctaButtonIcon != 0))
      {
        paramLayoutInflater = new TrackingOnClickListener(onCtaButtonClick.tracker, onCtaButtonClick.controlName, new TrackingEventBuilder[0])
        {
          public final void onClick(View paramAnonymousView)
          {
            super.onClick(paramAnonymousView);
            paramAnonymousView = EntityItemViewModel.this;
            if (!isCtaButtonClicked) {}
            for (boolean bool = true;; bool = false)
            {
              isCtaButtonClicked = bool;
              toggleButtonClicked(paramEntityItemViewHolderctaButton, paramEntityItemViewHolderctaClickedButton, isCtaButtonClicked);
              onCtaButtonClick.apply(Boolean.valueOf(isCtaButtonClicked));
              return;
            }
          }
        };
        ctaButton.setImageResource(ctaButtonIcon);
        ctaButton.setOnClickListener(paramLayoutInflater);
        if (ctaClickedButtonIcon != 0)
        {
          ctaClickedButton.setImageResource(ctaClickedButtonIcon);
          ctaClickedButton.setOnClickListener(paramLayoutInflater);
        }
        toggleButtonClicked(ctaButton, ctaClickedButton, isCtaButtonClicked);
      }
      itemView.setOnClickListener(new TrackingOnClickListener(onRowClick.tracker, onRowClick.controlName, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          onRowClick.apply(paramEntityItemViewHolderimage);
        }
      });
      return;
      ViewUtils.setTextAndUpdateVisibility(badge, badge, badgeContentDescription);
    }
  }
  
  final void toggleButtonClicked(ImageButton paramImageButton1, ImageButton paramImageButton2, boolean paramBoolean)
  {
    if ((paramBoolean) && (ctaClickedButtonIcon != 0))
    {
      paramImageButton2.setVisibility(0);
      paramImageButton1.setVisibility(8);
      return;
    }
    paramImageButton2.setVisibility(8);
    paramImageButton1.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.EntityItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */