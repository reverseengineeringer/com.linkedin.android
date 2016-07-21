package com.linkedin.android.feed.endor.ui.component.likesrollup;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.shared.rollup.RollupView;

public class FeedLikesRollupViewHolder$$ViewInjector<T extends FeedLikesRollupViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    likesRollupView = ((RollupView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755705, "field 'likesRollupView'"), 2131755705, "field 'likesRollupView'"));
  }
  
  public void reset(T paramT)
  {
    likesRollupView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likesrollup.FeedLikesRollupViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */