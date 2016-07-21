package com.linkedin.android.feed.endor.ui.component.comment;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.linkedin.android.infra.shared.ViewUtils;
import com.makeramen.roundedimageview.RoundedImageView;

public final class FeedReplyLayout
  extends FeedCommentLayout
{
  public FeedReplyLayout(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super(paramBoolean1, paramBoolean2);
    maxLines = paramInt;
  }
  
  public final void apply(FeedCommentViewHolder paramFeedCommentViewHolder)
  {
    super.apply(paramFeedCommentViewHolder);
    Resources localResources = itemView.getContext().getResources();
    if (showBottomDivider)
    {
      bottomDivider.setVisibility(0);
      ViewUtils.setStartMargin(bottomDivider, 0);
    }
    for (;;)
    {
      ViewCompat.setPaddingRelative(commentContainer, localResources.getDimensionPixelSize(2131493109), localResources.getDimensionPixelSize(2131492991), 0, 0);
      commenterImage.getLayoutParams().width = localResources.getDimensionPixelSize(2131492960);
      commenterImage.getLayoutParams().height = localResources.getDimensionPixelSize(2131492960);
      ViewUtils.setStartMargin(commenterImage, 0);
      return;
      bottomDivider.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedReplyLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */