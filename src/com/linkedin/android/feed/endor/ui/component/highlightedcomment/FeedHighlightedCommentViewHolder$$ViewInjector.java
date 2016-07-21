package com.linkedin.android.feed.endor.ui.component.highlightedcomment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.TintableImageView;

public class FeedHighlightedCommentViewHolder$$ViewInjector<T extends FeedHighlightedCommentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    commenterImage = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755673, "field 'commenterImage'"), 2131755673, "field 'commenterImage'"));
    actorAndCommentText = ((ExpandableTextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755674, "field 'actorAndCommentText'"), 2131755674, "field 'actorAndCommentText'"));
    commentLikeLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755675, "field 'commentLikeLayout'"), 2131755675, "field 'commentLikeLayout'"));
    commentLike = ((LikeButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755676, "field 'commentLike'"), 2131755676, "field 'commentLike'"));
    commentLikeText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755677, "field 'commentLikeText'"), 2131755677, "field 'commentLikeText'"));
    commentReplyLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755678, "field 'commentReplyLayout'"), 2131755678, "field 'commentReplyLayout'"));
    commentReply = ((TintableImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755679, "field 'commentReply'"), 2131755679, "field 'commentReply'"));
    commentReplyText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755680, "field 'commentReplyText'"), 2131755680, "field 'commentReplyText'"));
    divider = ((View)paramFinder.findRequiredView(paramObject, 2131755681, "field 'divider'"));
    commentLikeCount = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755682, "field 'commentLikeCount'"), 2131755682, "field 'commentLikeCount'"));
    bullet = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755683, "field 'bullet'"), 2131755683, "field 'bullet'"));
    commentReplyCount = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755684, "field 'commentReplyCount'"), 2131755684, "field 'commentReplyCount'"));
  }
  
  public void reset(T paramT)
  {
    commenterImage = null;
    actorAndCommentText = null;
    commentLikeLayout = null;
    commentLike = null;
    commentLikeText = null;
    commentReplyLayout = null;
    commentReply = null;
    commentReplyText = null;
    divider = null;
    commentLikeCount = null;
    bullet = null;
    commentReplyCount = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.highlightedcomment.FeedHighlightedCommentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */