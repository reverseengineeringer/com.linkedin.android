package com.linkedin.android.feed.endor.ui.component.comment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.TintableImageView;
import com.makeramen.roundedimageview.RoundedImageView;

public class FeedCommentViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedCommentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968714;
    }
  };
  @InjectView(2131755636)
  View bottomDivider;
  @InjectView(2131755634)
  TextView bullet;
  @InjectView(2131755620)
  View commentContainer;
  @InjectView(2131755627)
  public LikeButton commentLike;
  @InjectView(2131755626)
  public LinearLayout commentLikeLayout;
  @InjectView(2131755628)
  public TextView commentLikeText;
  @InjectView(2131755630)
  public TintableImageView commentReply;
  @InjectView(2131755629)
  public LinearLayout commentReplyLayout;
  @InjectView(2131755631)
  public TextView commentReplyText;
  @InjectView(2131755625)
  public ExpandableTextView commentText;
  @InjectView(2131755622)
  public TextView commentTime;
  @InjectView(2131755624)
  public TextView commenterHeadline;
  @InjectView(2131755621)
  public RoundedImageView commenterImage;
  @InjectView(2131755623)
  public TextView commenterName;
  @InjectView(2131755632)
  public View divider;
  @InjectView(2131755633)
  TextView likeCount;
  @InjectView(2131755635)
  TextView replyCount;
  @InjectView(2131755619)
  View replyTrackableView;
  
  public FeedCommentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */