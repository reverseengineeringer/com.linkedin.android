package com.linkedin.android.growth.newtovoyager.organic;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.infra.ui.ViewPager;

public class NewToVoyagerIntroFragment$$ViewInjector<T extends NewToVoyagerIntroFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    viewPager = ((ViewPager)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756060, "field 'viewPager'"), 2131756060, "field 'viewPager'"));
    carousel = ((HorizontalViewPagerCarousel)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756061, "field 'carousel'"), 2131756061, "field 'carousel'"));
  }
  
  public void reset(T paramT)
  {
    viewPager = null;
    carousel = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */