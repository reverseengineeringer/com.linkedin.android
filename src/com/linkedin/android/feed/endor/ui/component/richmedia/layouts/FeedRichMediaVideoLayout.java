package com.linkedin.android.feed.endor.ui.component.richmedia.layouts;

import android.content.Context;
import android.content.res.Resources;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaViewHolder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.AspectRatioImageView;
import com.linkedin.android.infra.ui.TintableImageButton;

public final class FeedRichMediaVideoLayout
  extends FeedRichMediaLayout
{
  private final int aspectRatioHeight;
  private final int aspectRatioWidth;
  private final boolean removeBorders;
  
  public FeedRichMediaVideoLayout(FragmentComponent paramFragmentComponent, boolean paramBoolean)
  {
    super(paramFragmentComponent, false, false);
    paramFragmentComponent = paramFragmentComponent.context().getResources();
    removeBorders = paramBoolean;
    aspectRatioWidth = paramFragmentComponent.getInteger(2131558465);
    aspectRatioHeight = paramFragmentComponent.getInteger(2131558464);
  }
  
  public FeedRichMediaVideoLayout(FragmentComponent paramFragmentComponent, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramFragmentComponent, false, false);
    removeBorders = paramBoolean;
    aspectRatioWidth = paramInt1;
    aspectRatioHeight = paramInt2;
  }
  
  public final void apply(FeedRichMediaViewHolder paramFeedRichMediaViewHolder)
  {
    super.apply(paramFeedRichMediaViewHolder);
    playButton.setVisibility(0);
    imageView.setAspectRatio(aspectRatioWidth, aspectRatioHeight);
  }
  
  public final FeedComponentLayout.Borders getBorders()
  {
    if (removeBorders) {
      return null;
    }
    return SMALL_INNER_BORDERS;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaVideoLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */