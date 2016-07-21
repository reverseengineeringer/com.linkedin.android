package com.linkedin.android.entities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;

public class EntityCoordinatorBaseFragment$$ViewInjector<T extends EntityCoordinatorBaseFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    errorContainer = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755473, "field 'errorContainer'"), 2131755473, "field 'errorContainer'"));
    errorToolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755474, "field 'errorToolbar'"), 2131755474, "field 'errorToolbar'"));
    errorViewStub = ((ViewStub)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755460, "field 'errorViewStub'"), 2131755460, "field 'errorViewStub'"));
    mainContent = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755465, "field 'mainContent'"), 2131755465, "field 'mainContent'"));
    header = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755469, "field 'header'"), 2131755469, "field 'header'"));
    viewPager = ((ViewPager)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755472, "field 'viewPager'"), 2131755472, "field 'viewPager'"));
    loadingSpinner = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755471, "field 'loadingSpinner'"), 2131755471, "field 'loadingSpinner'"));
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
    searchBar = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755145, "field 'searchBar'"), 2131755145, "field 'searchBar'"));
    searchBarText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755328, "field 'searchBarText'"), 2131755328, "field 'searchBarText'"));
    searchBarDivider = ((View)paramFinder.findRequiredView(paramObject, 2131758545, "field 'searchBarDivider'"));
    collapsingToolbarLayout = ((CollapsingToolbarLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755467, "field 'collapsingToolbarLayout'"), 2131755467, "field 'collapsingToolbarLayout'"));
    appBarLayout = ((AppBarLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755466, "field 'appBarLayout'"), 2131755466, "field 'appBarLayout'"));
    tabLayout = ((TabLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755470, "field 'tabLayout'"), 2131755470, "field 'tabLayout'"));
  }
  
  public void reset(T paramT)
  {
    errorContainer = null;
    errorToolbar = null;
    errorViewStub = null;
    mainContent = null;
    header = null;
    viewPager = null;
    loadingSpinner = null;
    toolbar = null;
    searchBar = null;
    searchBarText = null;
    searchBarDivider = null;
    collapsingToolbarLayout = null;
    appBarLayout = null;
    tabLayout = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityCoordinatorBaseFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */