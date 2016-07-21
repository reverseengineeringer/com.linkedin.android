package com.linkedin.android.feed.endor.ui.component.richmedia.layouts;

import android.widget.ImageView.ScaleType;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaViewHolder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.AspectRatioImageView;
import com.linkedin.android.infra.ui.TintableImageButton;

public abstract class FeedRichMediaLayout
  extends FeedComponentLayout<FeedRichMediaViewHolder>
{
  protected final boolean isReshare;
  protected final boolean isSharePreview;
  protected final boolean isSponsored;
  
  public FeedRichMediaLayout(FragmentComponent paramFragmentComponent, boolean paramBoolean1, boolean paramBoolean2)
  {
    isReshare = paramBoolean1;
    isSponsored = paramBoolean2;
    isSharePreview = FeedViewTransformerHelpers.isSharePreview(paramFragmentComponent);
  }
  
  public void apply(FeedRichMediaViewHolder paramFeedRichMediaViewHolder)
  {
    super.apply(paramFeedRichMediaViewHolder);
    imageView.setOnClickListener(null);
    imageView.setClickable(false);
    playButton.setVisibility(8);
    playButton.setOnClickListener(null);
    if ((isSponsored) && (!isReshare))
    {
      imageView.setBackgroundResource(2131624166);
      imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      return;
    }
    imageView.setBackgroundResource(0);
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public FeedComponentLayout.Borders getBorders()
  {
    if ((isReshare) || (isSponsored)) {
      return SMALL_INNER_BORDERS_WITH_DIVIDERS;
    }
    if (isSharePreview) {
      return new FeedComponentLayout.Borders(1, 1, 1, 1);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */