package com.linkedin.android.feed.updates.common.likes.detail;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;

public class LikesDetailFragment$$ViewInjector<T extends LikesDetailFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    likesHeader = ((FeedComponentsView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755824, "field 'likesHeader'"), 2131755824, "field 'likesHeader'"));
    likesRecyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755825, "field 'likesRecyclerView'"), 2131755825, "field 'likesRecyclerView'"));
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
  }
  
  public void reset(T paramT)
  {
    likesHeader = null;
    likesRecyclerView = null;
    toolbar = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */