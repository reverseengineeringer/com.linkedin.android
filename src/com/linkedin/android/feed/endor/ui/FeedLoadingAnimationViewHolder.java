package com.linkedin.android.feed.endor.ui;

import android.view.View;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public final class FeedLoadingAnimationViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedLoadingAnimationViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968760;
    }
  };
  
  public FeedLoadingAnimationViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedLoadingAnimationViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */