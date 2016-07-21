package com.linkedin.android.feed.endor.ui.component.comment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.TintableImageView;
import com.makeramen.roundedimageview.RoundedImageView;

public class FeedCommentViewHolder$$ViewInjector<T extends FeedCommentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    commenterImage = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755621, "field 'commenterImage'"), 2131755621, "field 'commenterImage'"));
    commenterName = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755623, "field 'commenterName'"), 2131755623, "field 'commenterName'"));
    commenterHeadline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755624, "field 'commenterHeadline'"), 2131755624, "field 'commenterHeadline'"));
    commentTime = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755622, "field 'commentTime'"), 2131755622, "field 'commentTime'"));
    commentText = ((ExpandableTextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755625, "field 'commentText'"), 2131755625, "field 'commentText'"));
    commentLikeText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755628, "field 'commentLikeText'"), 2131755628, "field 'commentLikeText'"));
    commentLike = ((LikeButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755627, "field 'commentLike'"), 2131755627, "field 'commentLike'"));
    commentLikeLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755626, "field 'commentLikeLayout'"), 2131755626, "field 'commentLikeLayout'"));
    commentReplyText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755631, "field 'commentReplyText'"), 2131755631, "field 'commentReplyText'"));
    commentReply = ((TintableImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755630, "field 'commentReply'"), 2131755630, "field 'commentReply'"));
    commentReplyLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755629, "field 'commentReplyLayout'"), 2131755629, "field 'commentReplyLayout'"));
    divider = ((View)paramFinder.findRequiredView(paramObject, 2131755632, "field 'divider'"));
    likeCount = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755633, "field 'likeCount'"), 2131755633, "field 'likeCount'"));
    bullet = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755634, "field 'bullet'"), 2131755634, "field 'bullet'"));
    replyCount = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755635, "field 'replyCount'"), 2131755635, "field 'replyCount'"));
    bottomDivider = ((View)paramFinder.findRequiredView(paramObject, 2131755636, "field 'bottomDivider'"));
    replyTrackableView = ((View)paramFinder.findRequiredView(paramObject, 2131755619, "field 'replyTrackableView'"));
    commentContainer = ((View)paramFinder.findRequiredView(paramObject, 2131755620, "field 'commentContainer'"));
  }
  
  public void reset(T paramT)
  {
    commenterImage = null;
    commenterName = null;
    commenterHeadline = null;
    commentTime = null;
    commentText = null;
    commentLikeText = null;
    commentLike = null;
    commentLikeLayout = null;
    commentReplyText = null;
    commentReply = null;
    commentReplyLayout = null;
    divider = null;
    likeCount = null;
    bullet = null;
    replyCount = null;
    bottomDivider = null;
    replyTrackableView = null;
    commentContainer = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */