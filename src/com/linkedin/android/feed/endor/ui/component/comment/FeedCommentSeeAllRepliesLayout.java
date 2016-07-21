package com.linkedin.android.feed.endor.ui.component.comment;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;

public final class FeedCommentSeeAllRepliesLayout
  extends FeedBasicTextLayout
{
  public FeedCommentSeeAllRepliesLayout(Resources paramResources)
  {
    super(paramResources, 2131361842);
  }
  
  public final void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    Resources localResources = textView.getResources();
    ViewCompat.setPaddingRelative(textView, (int)localResources.getDimension(2131493110), 0, ViewCompat.getPaddingEnd(textView), (int)localResources.getDimension(2131492991));
    textView.setTextColor(ContextCompat.getColor(itemView.getContext(), 2131623966));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentSeeAllRepliesLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */