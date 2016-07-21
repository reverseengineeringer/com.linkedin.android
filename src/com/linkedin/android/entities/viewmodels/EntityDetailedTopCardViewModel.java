package com.linkedin.android.entities.viewmodels;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.linkedin.android.entities.shared.AutofitHelper;
import com.linkedin.android.entities.shared.AutofitHelper.OnTextSizeChangeListener;
import com.linkedin.android.entities.shared.AutofitTextButton;
import com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.feed.endor.ui.component.insight.FeedInsightViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class EntityDetailedTopCardViewModel
  extends ViewModel<EntityDetailedTopCardViewHolder>
{
  public Integer coverImageColor;
  public String detail;
  public ImageModel heroImage;
  public ImageModel icon;
  public FeedInsightViewModel insight;
  public boolean isPrimaryButtonClicked;
  public boolean isSecondaryButtonClicked;
  public TrackingClosure<ImageView, Void> onLogoClick;
  public TrackingClosure<Boolean, Void> onPrimaryButtonClick;
  public TrackingClosure<Boolean, Void> onSecondaryButtonClick;
  public Drawable primaryButtonClickedIcon;
  public String primaryButtonClickedText;
  public Drawable primaryButtonDefaultIcon;
  public String primaryButtonDefaultText;
  public int primaryButtonIconPadding;
  public String secondaryButtonClickedText;
  public String secondaryButtonDefaultText;
  public String subtitle1;
  public String subtitle2;
  public String subtitle2ContentDescription;
  public String title;
  public float topCardTopScrimWeight;
  
  private static void setButtonIcon(Button paramButton, Drawable paramDrawable, int paramInt)
  {
    paramButton.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    paramButton.setCompoundDrawablePadding(paramInt);
  }
  
  public final void bindDetailText(EntityDetailedTopCardViewHolder paramEntityDetailedTopCardViewHolder)
  {
    ViewUtils.setTextAndUpdateVisibility(detailView, detail);
  }
  
  public final void bindPrimaryButtonClickedText(EntityDetailedTopCardViewHolder paramEntityDetailedTopCardViewHolder)
  {
    primaryButtonClicked.setSizeToFit(true);
    ViewUtils.setTextAndUpdateVisibility(primaryButtonClicked, primaryButtonClickedText);
  }
  
  public final void bindPrimaryButtonText(EntityDetailedTopCardViewHolder paramEntityDetailedTopCardViewHolder)
  {
    primaryButton.setSizeToFit(true);
    ViewUtils.setTextAndUpdateVisibility(primaryButton, primaryButtonDefaultText);
  }
  
  public final void bindSecondaryButtonText(EntityDetailedTopCardViewHolder paramEntityDetailedTopCardViewHolder)
  {
    secondaryButton.setSizeToFit(true);
    AutofitTextButton localAutofitTextButton = secondaryButton;
    if (isSecondaryButtonClicked) {}
    for (paramEntityDetailedTopCardViewHolder = secondaryButtonClickedText;; paramEntityDetailedTopCardViewHolder = secondaryButtonDefaultText)
    {
      ViewUtils.setTextAndUpdateVisibility(localAutofitTextButton, paramEntityDetailedTopCardViewHolder);
      return;
    }
  }
  
  public final void bindText(EntityDetailedTopCardViewHolder paramEntityDetailedTopCardViewHolder)
  {
    ViewUtils.setTextAndUpdateVisibility(titleView, title);
    ViewUtils.setTextAndUpdateVisibility(subtitleView1, subtitle1);
    ViewUtils.setTextAndUpdateVisibility(subtitleView2, subtitle2, subtitle2ContentDescription);
  }
  
  public final ViewHolderCreator<EntityDetailedTopCardViewHolder> getCreator()
  {
    return EntityDetailedTopCardViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, final EntityDetailedTopCardViewHolder paramEntityDetailedTopCardViewHolder)
  {
    bindText(paramEntityDetailedTopCardViewHolder);
    bindDetailText(paramEntityDetailedTopCardViewHolder);
    if (insight != null)
    {
      insight.onBindViewHolder(paramLayoutInflater, paramMediaCenter, insightViewHolder);
      coverImageTopGradientView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, topCardTopScrimWeight));
      coverImageBottomGradientView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0F - topCardTopScrimWeight));
      if (heroImage == null) {
        break label495;
      }
      heroImage.setImageView(paramMediaCenter, coverView);
      label91:
      if (icon != null) {
        icon.setImageView(paramMediaCenter, iconView);
      }
      if (onLogoClick != null) {
        iconView.setOnClickListener(new TrackingOnClickListener(onLogoClick.tracker, onLogoClick.controlName, new TrackingEventBuilder[0])
        {
          public final void onClick(View paramAnonymousView)
          {
            super.onClick(paramAnonymousView);
            onLogoClick.apply(paramEntityDetailedTopCardViewHoldericonView);
          }
        });
      }
      bindPrimaryButtonText(paramEntityDetailedTopCardViewHolder);
      primaryButton.getAutofitHelper().addOnTextSizeChangeListener(new AutofitHelper.OnTextSizeChangeListener()
      {
        public final void onTextSizeChange$2548a35()
        {
          EntityDetailedTopCardViewModel.access$000(EntityDetailedTopCardViewModel.this, paramEntityDetailedTopCardViewHolder);
        }
      });
      primaryButton.setEnabled(true);
      if (primaryButtonDefaultIcon != null) {
        setButtonIcon(primaryButton, primaryButtonDefaultIcon, primaryButtonIconPadding);
      }
      bindPrimaryButtonClickedText(paramEntityDetailedTopCardViewHolder);
      primaryButtonClicked.getAutofitHelper().addOnTextSizeChangeListener(new AutofitHelper.OnTextSizeChangeListener()
      {
        public final void onTextSizeChange$2548a35()
        {
          EntityDetailedTopCardViewModel.access$000(EntityDetailedTopCardViewModel.this, paramEntityDetailedTopCardViewHolder);
        }
      });
      if (primaryButtonClickedIcon != null) {
        setButtonIcon(primaryButtonClicked, primaryButtonClickedIcon, primaryButtonIconPadding);
      }
      if (onPrimaryButtonClick == null) {
        break label512;
      }
      primaryButton.setOnClickListener(new TrackingOnClickListener(onPrimaryButtonClick.tracker, onPrimaryButtonClick.controlName, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          onPrimaryButtonClick.apply(Boolean.valueOf(false));
        }
      });
      primaryButtonClicked.setOnClickListener(new TrackingOnClickListener(onPrimaryButtonClick.tracker, onPrimaryButtonClick.controlName, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          onPrimaryButtonClick.apply(Boolean.valueOf(true));
        }
      });
      label326:
      togglePrimaryButtonClicked(primaryButton, primaryButtonClicked, isPrimaryButtonClicked);
      bindSecondaryButtonText(paramEntityDetailedTopCardViewHolder);
      secondaryButton.getAutofitHelper().addOnTextSizeChangeListener(new AutofitHelper.OnTextSizeChangeListener()
      {
        public final void onTextSizeChange$2548a35()
        {
          EntityDetailedTopCardViewModel.access$000(EntityDetailedTopCardViewModel.this, paramEntityDetailedTopCardViewHolder);
        }
      });
      if (onSecondaryButtonClick == null) {
        break label531;
      }
      secondaryButton.setOnClickListener(new TrackingOnClickListener(onSecondaryButtonClick.tracker, onSecondaryButtonClick.controlName, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          paramAnonymousView = EntityDetailedTopCardViewModel.this;
          boolean bool;
          AutofitTextButton localAutofitTextButton;
          if (!isSecondaryButtonClicked)
          {
            bool = true;
            isSecondaryButtonClicked = bool;
            onSecondaryButtonClick.apply(Boolean.valueOf(isSecondaryButtonClicked));
            localAutofitTextButton = paramEntityDetailedTopCardViewHoldersecondaryButton;
            if (!isSecondaryButtonClicked) {
              break label85;
            }
          }
          label85:
          for (paramAnonymousView = secondaryButtonClickedText;; paramAnonymousView = secondaryButtonDefaultText)
          {
            localAutofitTextButton.setText(paramAnonymousView);
            return;
            bool = false;
            break;
          }
        }
      });
    }
    for (;;)
    {
      secondaryButton.setEnabled(true);
      if ((primaryButton.getVisibility() == 0) || (primaryButtonClicked.getVisibility() == 0) || (secondaryButton.getVisibility() == 0)) {
        break label542;
      }
      overlayContainer.getLayoutParams().height = ((int)paramLayoutInflater.getContext().getResources().getDimension(2131493083));
      buttonContainer.setVisibility(8);
      return;
      insightViewHolder.textView.setVisibility(8);
      break;
      label495:
      coverView.setBackgroundColor(coverImageColor.intValue());
      break label91;
      label512:
      primaryButton.setClickable(false);
      primaryButtonClicked.setClickable(false);
      break label326;
      label531:
      secondaryButton.setClickable(false);
    }
    label542:
    overlayContainer.getLayoutParams().height = ((int)paramLayoutInflater.getContext().getResources().getDimension(2131493085));
    buttonContainer.setVisibility(0);
  }
  
  public final void togglePrimaryButtonClicked(Button paramButton1, Button paramButton2, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(primaryButtonClickedText)))
    {
      paramButton2.setVisibility(0);
      paramButton1.setVisibility(8);
      return;
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(primaryButtonDefaultText)))
    {
      paramButton2.setVisibility(8);
      paramButton1.setVisibility(0);
      return;
    }
    paramButton2.setVisibility(8);
    paramButton1.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */