package com.linkedin.android.feed.endor.ui.component.likesrollup.rollupitem;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;

public class FeedLikesRollupItemViewHolder$$ViewInjector<T extends FeedLikesRollupItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    actorImage = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755706, "field 'actorImage'"), 2131755706, "field 'actorImage'"));
  }
  
  public void reset(T paramT)
  {
    actorImage = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likesrollup.rollupitem.FeedLikesRollupItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */