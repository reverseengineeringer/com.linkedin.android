package com.linkedin.android.entities.viewmodels;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import com.linkedin.android.entities.shared.AutofitTextButton;
import com.linkedin.android.entities.viewholders.EntityTopCardViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class EntityTopCardViewModel
  extends ViewModel<EntityTopCardViewHolder>
{
  public ImageModel heroImage;
  public ImageModel icon;
  public boolean isPrimaryButtonClicked;
  public TrackingClosure<Boolean, Void> onPrimaryButtonClick;
  public Drawable primaryButtonClickedIcon;
  public String primaryButtonClickedText;
  public Drawable primaryButtonDefaultIcon;
  public String primaryButtonDefaultText;
  public int primaryButtonIconPadding;
  public String subtitle1;
  public String subtitle2;
  public String title;
  
  private static void setButtonIcon(Button paramButton, Drawable paramDrawable, int paramInt)
  {
    paramButton.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    paramButton.setCompoundDrawablePadding(paramInt);
  }
  
  public static void toggleButtonClicked(Button paramButton1, Button paramButton2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramButton2.setVisibility(0);
      paramButton1.setVisibility(8);
      return;
    }
    paramButton2.setVisibility(8);
    paramButton1.setVisibility(0);
  }
  
  public final void bindText(EntityTopCardViewHolder paramEntityTopCardViewHolder)
  {
    ViewUtils.setTextAndUpdateVisibility(titleView, title);
    ViewUtils.setTextAndUpdateVisibility(subtitle1View, subtitle1);
    ViewUtils.setTextAndUpdateVisibility(subtitle2View, subtitle2);
  }
  
  public final ViewHolderCreator<EntityTopCardViewHolder> getCreator()
  {
    return EntityTopCardViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$2e9a8560(MediaCenter paramMediaCenter, EntityTopCardViewHolder paramEntityTopCardViewHolder)
  {
    bindText(paramEntityTopCardViewHolder);
    heroImage.setImageView(paramMediaCenter, coverView);
    icon.setImageView(paramMediaCenter, iconView);
    paramMediaCenter = ctaButton;
    paramEntityTopCardViewHolder = ctaClickedButton;
    toggleButtonClicked(paramMediaCenter, paramEntityTopCardViewHolder, isPrimaryButtonClicked);
    paramMediaCenter.setText(primaryButtonDefaultText);
    paramMediaCenter.setOnClickListener(new TrackingOnClickListener(onPrimaryButtonClick.tracker, onPrimaryButtonClick.controlName, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        onPrimaryButtonClick.apply(Boolean.valueOf(false));
      }
    });
    if (primaryButtonDefaultIcon != null) {
      setButtonIcon(paramMediaCenter, primaryButtonDefaultIcon, primaryButtonIconPadding);
    }
    paramEntityTopCardViewHolder.setText(primaryButtonClickedText);
    paramEntityTopCardViewHolder.setOnClickListener(new TrackingOnClickListener(onPrimaryButtonClick.tracker, onPrimaryButtonClick.controlName, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        onPrimaryButtonClick.apply(Boolean.valueOf(true));
      }
    });
    if (primaryButtonClickedIcon != null) {
      setButtonIcon(paramEntityTopCardViewHolder, primaryButtonClickedIcon, primaryButtonIconPadding);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.EntityTopCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */