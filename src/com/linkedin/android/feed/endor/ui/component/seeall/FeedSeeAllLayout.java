package com.linkedin.android.feed.endor.ui.component.seeall;

import android.view.View;
import com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonLayout;
import com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonViewHolder;

public final class FeedSeeAllLayout
  extends FeedBasicButtonLayout
{
  public final void apply(FeedBasicButtonViewHolder paramFeedBasicButtonViewHolder)
  {
    super.apply(paramFeedBasicButtonViewHolder);
    topDivider.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.seeall.FeedSeeAllLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */