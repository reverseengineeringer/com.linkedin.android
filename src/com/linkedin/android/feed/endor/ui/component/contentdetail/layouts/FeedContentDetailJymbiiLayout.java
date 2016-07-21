package com.linkedin.android.feed.endor.ui.component.contentdetail.layouts;

import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewHolder;
import com.linkedin.android.imageloader.LiImageView;

public final class FeedContentDetailJymbiiLayout
  extends FeedContentDetailLayout
{
  public final void apply(FeedContentDetailViewHolder paramFeedContentDetailViewHolder)
  {
    super.apply(paramFeedContentDetailViewHolder);
    int i = getPixelFromDp(image.getResources(), 48);
    image.getLayoutParams().width = i;
    image.getLayoutParams().height = i;
  }
  
  public final FeedComponentLayout.Borders getBorders()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailJymbiiLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */