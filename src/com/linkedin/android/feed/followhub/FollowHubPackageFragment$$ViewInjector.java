package com.linkedin.android.feed.followhub;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FollowHubPackageFragment$$ViewInjector<T extends FollowHubPackageFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755781, "field 'recyclerView'"), 2131755781, "field 'recyclerView'"));
  }
  
  public void reset(T paramT)
  {
    recyclerView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubPackageFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */