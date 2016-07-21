package com.linkedin.android.feed.endor.ui.component.highlightedcomment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.TintableImageView;

public class FeedHighlightedCommentViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedHighlightedCommentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968725;
    }
  };
  @InjectView(2131755674)
  public ExpandableTextView actorAndCommentText;
  @InjectView(2131755683)
  public TextView bullet;
  @InjectView(2131755676)
  public LikeButton commentLike;
  @InjectView(2131755682)
  public TextView commentLikeCount;
  @InjectView(2131755675)
  public LinearLayout commentLikeLayout;
  @InjectView(2131755677)
  public TextView commentLikeText;
  @InjectView(2131755679)
  public TintableImageView commentReply;
  @InjectView(2131755684)
  public TextView commentReplyCount;
  @InjectView(2131755678)
  public LinearLayout commentReplyLayout;
  @InjectView(2131755680)
  public TextView commentReplyText;
  @InjectView(2131755673)
  public LiImageView commenterImage;
  @InjectView(2131755681)
  public View divider;
  
  public FeedHighlightedCommentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.highlightedcomment.FeedHighlightedCommentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */