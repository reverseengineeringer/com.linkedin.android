package com.linkedin.android.feed.endor.ui.component.insight;

import android.content.res.Resources;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;

public final class FeedInsightLayout
  extends FeedBasicTextLayout
{
  public FeedInsightLayout(Resources paramResources)
  {
    super(paramResources, 2131361842);
  }
  
  public final void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    Resources localResources = textView.getResources();
    textView.setPadding((int)localResources.getDimension(2131493130), 0, textView.getPaddingRight(), (int)localResources.getDimension(2131492991));
    textView.setGravity(17);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.insight.FeedInsightLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */