package com.linkedin.android.feed.endor.ui.component.insight;

import android.content.res.Resources;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.infra.shared.JellyBeanUtils;

public final class EntityInsightLayout
  extends FeedBasicTextLayout
{
  public EntityInsightLayout(Resources paramResources)
  {
    super(paramResources, 2131361842);
  }
  
  public final void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    Resources localResources = textView.getResources();
    textView.setPadding(0, localResources.getDimensionPixelSize(2131492987), textView.getPaddingRight(), 0);
    textView.setGravity(17);
    JellyBeanUtils.setBackground(textView, null);
    textView.setClickable(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.insight.EntityInsightLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */