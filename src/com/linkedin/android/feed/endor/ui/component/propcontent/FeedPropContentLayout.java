package com.linkedin.android.feed.endor.ui.component.propcontent;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;

public final class FeedPropContentLayout
  extends FeedBasicTextLayout
{
  public FeedPropContentLayout(Resources paramResources)
  {
    super(paramResources, -1);
  }
  
  public final void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    int i = res.getDimensionPixelSize(2131492991);
    ViewCompat.setPaddingRelative(textView, i, i, i, i);
  }
  
  public final FeedComponentLayout.Borders getBorders()
  {
    return SMALL_INNER_BORDERS;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.propcontent.FeedPropContentLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */