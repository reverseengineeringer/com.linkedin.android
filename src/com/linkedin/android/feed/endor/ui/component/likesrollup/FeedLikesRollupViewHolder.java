package com.linkedin.android.feed.endor.ui.component.likesrollup;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.shared.rollup.RollupView;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedLikesRollupViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedLikesRollupViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968729;
    }
  };
  @InjectView(2131755705)
  public RollupView likesRollupView;
  
  public FeedLikesRollupViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likesrollup.FeedLikesRollupViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */