package com.linkedin.android.feed.actorlist;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BaseFeedActorListFragment$$ViewInjector<T extends BaseFeedActorListFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755579, "field 'recyclerView'"), 2131755579, "field 'recyclerView'"));
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
  }
  
  public void reset(T paramT)
  {
    recyclerView = null;
    toolbar = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.BaseFeedActorListFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */