package com.linkedin.android.feed.endor.ui.component.likesrollup.rollupitem;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedLikesRollupItemViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedLikesRollupItemViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968730;
    }
  };
  @InjectView(2131755706)
  public LiImageView actorImage;
  
  public FeedLikesRollupItemViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likesrollup.rollupitem.FeedLikesRollupItemViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */