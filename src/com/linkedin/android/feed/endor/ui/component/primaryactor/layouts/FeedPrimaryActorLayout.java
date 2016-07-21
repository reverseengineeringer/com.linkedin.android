package com.linkedin.android.feed.endor.ui.component.primaryactor.layouts;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.linkedin.android.artdeco.ArtDeco;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorViewHolder;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.ui.TintableImageView;

public class FeedPrimaryActorLayout
  extends FeedComponentLayout<FeedPrimaryActorViewHolder>
{
  private boolean centerPrimaryButton;
  public final boolean invertColors;
  private boolean showBorder;
  private boolean showImage;
  int type;
  
  public FeedPrimaryActorLayout(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    type = paramInt;
    showImage = paramBoolean1;
    invertColors = paramBoolean2;
    showBorder = paramBoolean3;
    centerPrimaryButton = paramBoolean4;
  }
  
  public static void setLines(TextView paramTextView, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    for (;;)
    {
      paramTextView.setSingleLine(bool);
      paramTextView.setMinLines(paramInt);
      paramTextView.setMaxLines(paramInt);
      return;
      bool = false;
    }
  }
  
  public void apply(FeedPrimaryActorViewHolder paramFeedPrimaryActorViewHolder)
  {
    super.apply(paramFeedPrimaryActorViewHolder);
    Object localObject = itemView.getContext().getResources();
    int i = ((Resources)localObject).getDimensionPixelSize(2131492989);
    int j = ((Resources)localObject).getDimensionPixelSize(2131492991);
    itemView.setOnClickListener(null);
    ViewUtils.setMargins(actorInfoContainer, 0, i, j, 0);
    actorName.setText(null);
    actorHeadline.setText(null);
    secondaryHeadline.setText(null);
    setLines(actorHeadline, 1);
    ActorDataModel.prepareImageViewHolderForActor(type, actorImage, showImage);
    actorImage.setImageDrawable(null);
    actorImage.setOnClickListener(null);
    localObject = actorImage;
    if (showImage)
    {
      i = 0;
      ((LiImageView)localObject).setVisibility(i);
      actionButton.setVisibility(8);
      actionButton.setOnClickListener(null);
      actionButton.setText(null);
      actionButton.setTextColor(ContextCompat.getColorStateList(itemView.getContext(), 2130837641));
      sponsoredFollowButton.setVisibility(8);
      sponsoredFollowButton.setOnClickListener(null);
      sponsoredFollowButton.setClickable(false);
      sponsoredFollowButton.setEnabled(true);
      downloadButton.setVisibility(8);
      downloadButton.setOnClickListener(null);
      downloadButton.setClickable(false);
      controlDropdown.setVisibility(8);
      if (!invertColors) {
        break label429;
      }
      i = 2131624056;
      label257:
      controlDropdown.setTintColor(ContextCompat.getColor(itemView.getContext(), i));
      localObject = actorName;
      Context localContext = itemView.getContext();
      if (!invertColors) {
        break label435;
      }
      i = 2131362510;
      label300:
      ArtDeco.setTextViewAppearance((TextView)localObject, i, localContext);
      localObject = actorHeadline;
      localContext = itemView.getContext();
      if (!invertColors) {
        break label441;
      }
      i = 2131362483;
      label333:
      ArtDeco.setTextViewAppearance((TextView)localObject, i, localContext);
      localObject = secondaryHeadline;
      localContext = itemView.getContext();
      if (!invertColors) {
        break label447;
      }
      i = 2131362479;
      label366:
      ArtDeco.setTextViewAppearance((TextView)localObject, i, localContext);
      if (type != 2) {
        break label453;
      }
      actorImage.setOval(true);
      actorImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    for (;;)
    {
      if (!centerPrimaryButton) {
        break label511;
      }
      actionButton.getLayoutParams()).gravity = 17;
      return;
      i = 8;
      break;
      label429:
      i = 2131623995;
      break label257;
      label435:
      i = 2131361905;
      break label300;
      label441:
      i = 2131361851;
      break label333;
      label447:
      i = 2131361842;
      break label366;
      label453:
      if (type == 1)
      {
        actorImage.setOval(false);
        actorImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      else if (type == 3)
      {
        actorImage.setOval(false);
        actorImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
    }
    label511:
    actionButton.getLayoutParams()).gravity = 48;
  }
  
  public final FeedComponentLayout.Borders getBorders()
  {
    if (showBorder) {
      return SMALL_INNER_BORDERS;
    }
    return super.getBorders();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.primaryactor.layouts.FeedPrimaryActorLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */