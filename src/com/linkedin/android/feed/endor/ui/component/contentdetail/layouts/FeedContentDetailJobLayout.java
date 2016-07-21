package com.linkedin.android.feed.endor.ui.component.contentdetail.layouts;

import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewHolder;
import com.linkedin.android.imageloader.LiImageView;

public final class FeedContentDetailJobLayout
  extends FeedContentDetailLayout
{
  public final void apply(FeedContentDetailViewHolder paramFeedContentDetailViewHolder)
  {
    super.apply(paramFeedContentDetailViewHolder);
    image.setOval(false);
    int i = getPixelFromDp(image.getResources(), 56);
    image.getLayoutParams().width = i;
    image.getLayoutParams().height = i;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailJobLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */