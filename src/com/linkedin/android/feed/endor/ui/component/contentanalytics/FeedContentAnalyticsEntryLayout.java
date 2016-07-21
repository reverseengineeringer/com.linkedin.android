package com.linkedin.android.feed.endor.ui.component.contentanalytics;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.infra.accessibility.AccessibilityRoleDelegate;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;

public final class FeedContentAnalyticsEntryLayout
  extends FeedBasicTextLayout
{
  private final Drawable analyticsDrawable;
  
  public FeedContentAnalyticsEntryLayout(Resources paramResources)
  {
    super(paramResources, 2131361796);
    analyticsDrawable = paramResources.getDrawable(2130837891);
  }
  
  public final void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    Resources localResources = textView.getResources();
    int i = (int)localResources.getDimension(2131492991);
    int j = (int)localResources.getDimension(2131492989);
    textView.setPadding(i, i, i, i);
    textView.setGravity(8388627);
    textView.setCompoundDrawablePadding(j);
    JellyBeanMr1Utils.setCompoundDrawablesWithIntrinsicBounds$16207aff(textView, analyticsDrawable, null);
    textView.setAccessibilityDelegate(AccessibilityRoleDelegate.button());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentanalytics.FeedContentAnalyticsEntryLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */