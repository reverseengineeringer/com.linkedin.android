package com.linkedin.android.feed.followhub;

import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;

public class FollowHubFragment$$ViewInjector<T extends FollowHubFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    tabLayout = ((TabLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755779, "field 'tabLayout'"), 2131755779, "field 'tabLayout'"));
    viewPager = ((ViewPager)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755780, "field 'viewPager'"), 2131755780, "field 'viewPager'"));
    toolbarLayout = ((CollapsingToolbarLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755775, "field 'toolbarLayout'"), 2131755775, "field 'toolbarLayout'"));
    exitButton = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755776, "field 'exitButton'"), 2131755776, "field 'exitButton'"));
  }
  
  public void reset(T paramT)
  {
    tabLayout = null;
    viewPager = null;
    toolbarLayout = null;
    exitButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */