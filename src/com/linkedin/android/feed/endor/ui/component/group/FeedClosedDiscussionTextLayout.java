package com.linkedin.android.feed.endor.ui.component.group;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;

public final class FeedClosedDiscussionTextLayout
  extends FeedBasicTextLayout
{
  public FeedClosedDiscussionTextLayout(Resources paramResources)
  {
    super(paramResources, 2131361901);
  }
  
  public final void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    int i = res.getDimensionPixelOffset(2131492991);
    ViewCompat.setPaddingRelative(textView, 0, i, 0, i);
    textView.setGravity(17);
    JellyBeanMr1Utils.setTextAlignment(textView, 4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.group.FeedClosedDiscussionTextLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */