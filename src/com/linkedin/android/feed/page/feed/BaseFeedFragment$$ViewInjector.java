package com.linkedin.android.feed.page.feed;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BaseFeedFragment$$ViewInjector<T extends BaseFeedFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755797, "field 'recyclerView'"), 2131755797, "field 'recyclerView'"));
    swipeRefreshLayout = ((SwipeRefreshLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755796, "field 'swipeRefreshLayout'"), 2131755796, "field 'swipeRefreshLayout'"));
  }
  
  public void reset(T paramT)
  {
    recyclerView = null;
    swipeRefreshLayout = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.BaseFeedFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */