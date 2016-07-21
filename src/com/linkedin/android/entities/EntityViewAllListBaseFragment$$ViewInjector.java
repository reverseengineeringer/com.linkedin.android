package com.linkedin.android.entities;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class EntityViewAllListBaseFragment$$ViewInjector<T extends EntityViewAllListBaseFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
    loadingSpinner = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755459, "field 'loadingSpinner'"), 2131755459, "field 'loadingSpinner'"));
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755458, "field 'recyclerView'"), 2131755458, "field 'recyclerView'"));
    errorViewStub = ((ViewStub)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755460, "field 'errorViewStub'"), 2131755460, "field 'errorViewStub'"));
  }
  
  public void reset(T paramT)
  {
    toolbar = null;
    loadingSpinner = null;
    recyclerView = null;
    errorViewStub = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityViewAllListBaseFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */