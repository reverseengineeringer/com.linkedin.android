package com.linkedin.android.feed.endor.ui.component.miniheader;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;

public final class FeedMiniHeaderLayout
  extends FeedBasicTextLayout
{
  public FeedMiniHeaderLayout(Resources paramResources)
  {
    super(paramResources, 2131361796);
  }
  
  public final void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    int i = res.getDimensionPixelSize(2131492993);
    int j = res.getDimensionPixelOffset(2131492991);
    ViewCompat.setPaddingRelative(textView, i, j, i, 0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.miniheader.FeedMiniHeaderLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */