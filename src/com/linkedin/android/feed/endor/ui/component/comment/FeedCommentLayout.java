package com.linkedin.android.feed.endor.ui.component.comment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.infra.accessibility.AccessibilityRoleDelegate;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.TintableImageView;
import com.makeramen.roundedimageview.RoundedImageView;

public class FeedCommentLayout
  extends FeedComponentLayout<FeedCommentViewHolder>
{
  protected int maxLines;
  protected final boolean showBottomDivider;
  protected final boolean showTextBottomMargin;
  
  public FeedCommentLayout(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramBoolean1, paramBoolean2, Integer.MAX_VALUE);
  }
  
  public FeedCommentLayout(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    showTextBottomMargin = paramBoolean1;
    showBottomDivider = paramBoolean2;
    maxLines = paramInt;
  }
  
  @TargetApi(17)
  public void apply(FeedCommentViewHolder paramFeedCommentViewHolder)
  {
    super.apply(paramFeedCommentViewHolder);
    commentText.setText("");
    commentText.collapse(false);
    commentText.setMaxLinesWhenCollapsed(maxLines);
    commenterImage.setImageDrawable(null);
    commenterName.setText("");
    commenterHeadline.setText("");
    commentTime.setText("");
    commentLike.setContentDescription("");
    commentLikeText.setContentDescription("");
    commentLikeLayout.setAccessibilityDelegate(AccessibilityRoleDelegate.button());
    commentReply.setContentDescription("");
    commentReplyText.setContentDescription("");
    commentReplyLayout.setAccessibilityDelegate(AccessibilityRoleDelegate.button());
    itemView.setBackgroundResource(0);
    itemView.setAlpha(1.0F);
    JellyBeanMr1Utils.setTextAlignment(commenterName, 5);
    Resources localResources = itemView.getContext().getResources();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)commentText.getLayoutParams();
    if (showTextBottomMargin)
    {
      bottomMargin = localResources.getDimensionPixelSize(2131492991);
      if (!showBottomDivider) {
        break label322;
      }
      bottomDivider.setVisibility(0);
      ViewUtils.setStartMargin(bottomDivider, localResources.getDimensionPixelSize(2131493107));
    }
    for (;;)
    {
      ViewCompat.setPaddingRelative(commentContainer, 0, localResources.getDimensionPixelSize(2131492991), 0, 0);
      commenterImage.getLayoutParams().width = localResources.getDimensionPixelSize(2131492961);
      commenterImage.getLayoutParams().height = localResources.getDimensionPixelSize(2131492961);
      ViewUtils.setStartMargin(commenterImage, localResources.getDimensionPixelSize(2131492991));
      if (!Util.isEnglish(itemView.getContext())) {
        break label334;
      }
      commentLikeText.setVisibility(0);
      commentReplyText.setVisibility(0);
      ViewUtils.setStartMargin(divider, 0);
      return;
      bottomMargin = 0;
      break;
      label322:
      bottomDivider.setVisibility(8);
    }
    label334:
    commentLikeText.setVisibility(8);
    commentReplyText.setVisibility(8);
    ViewUtils.setStartMargin(divider, localResources.getDimensionPixelSize(2131492987));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */