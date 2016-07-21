package com.linkedin.android.feed.aggregate;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AggregateFragment$$ViewInjector<T extends AggregateFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755581, "field 'recyclerView'"), 2131755581, "field 'recyclerView'"));
  }
  
  public void reset(T paramT)
  {
    toolbar = null;
    recyclerView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */