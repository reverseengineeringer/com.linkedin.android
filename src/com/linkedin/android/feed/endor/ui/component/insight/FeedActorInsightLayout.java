package com.linkedin.android.feed.endor.ui.component.insight;

import android.content.res.Resources;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;

public final class FeedActorInsightLayout
  extends FeedBasicTextLayout
{
  public FeedActorInsightLayout(Resources paramResources)
  {
    super(paramResources, 2131361842);
  }
  
  public final void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    textView.setPadding(textView.getPaddingLeft(), 0, textView.getPaddingRight(), 0);
    textView.setGravity(17);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.insight.FeedActorInsightLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */