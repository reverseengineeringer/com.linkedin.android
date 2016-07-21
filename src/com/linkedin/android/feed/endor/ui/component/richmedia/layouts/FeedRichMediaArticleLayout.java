package com.linkedin.android.feed.endor.ui.component.richmedia.layouts;

import android.content.Context;
import android.content.res.Resources;
import com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaViewHolder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.AspectRatioImageView;

public final class FeedRichMediaArticleLayout
  extends FeedRichMediaLayout
{
  private final int aspectRatioHeight;
  private final int aspectRatioWidth;
  
  public FeedRichMediaArticleLayout(FragmentComponent paramFragmentComponent, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramFragmentComponent, paramBoolean1, paramBoolean2);
    paramFragmentComponent = paramFragmentComponent.context().getResources();
    aspectRatioWidth = paramFragmentComponent.getInteger(2131558442);
    aspectRatioHeight = paramFragmentComponent.getInteger(2131558441);
  }
  
  public final void apply(FeedRichMediaViewHolder paramFeedRichMediaViewHolder)
  {
    super.apply(paramFeedRichMediaViewHolder);
    imageView.setAspectRatio(aspectRatioWidth, aspectRatioHeight);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaArticleLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */