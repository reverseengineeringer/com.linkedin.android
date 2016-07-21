package com.linkedin.android.feed.endor.ui.component.likerow;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.makeramen.roundedimageview.RoundedImageView;

public class FeedLikeRowViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedLikeRowViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968728;
    }
  };
  @InjectView(2131755700)
  public TextView likeActorBullet;
  @InjectView(2131755701)
  public TextView likeActorDistance;
  @InjectView(2131755702)
  public TextView likeActorHeadline;
  @InjectView(2131755697)
  public RoundedImageView likeActorImage;
  @InjectView(2131755703)
  public TextView likeActorInsight;
  @InjectView(2131755699)
  public TextView likeActorName;
  @InjectView(2131755698)
  public TextView likeTime;
  
  public FeedLikeRowViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likerow.FeedLikeRowViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */