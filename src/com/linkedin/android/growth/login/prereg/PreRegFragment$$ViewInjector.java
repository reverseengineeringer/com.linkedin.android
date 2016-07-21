package com.linkedin.android.growth.login.prereg;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.infra.ui.ViewPager;

public class PreRegFragment$$ViewInjector<T extends PreRegFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    viewPager = ((ViewPager)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756184, "field 'viewPager'"), 2131756184, "field 'viewPager'"));
    carousel = ((HorizontalViewPagerCarousel)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756185, "field 'carousel'"), 2131756185, "field 'carousel'"));
    joinButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756186, "field 'joinButton'"), 2131756186, "field 'joinButton'"));
    signInButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756187, "field 'signInButton'"), 2131756187, "field 'signInButton'"));
  }
  
  public void reset(T paramT)
  {
    viewPager = null;
    carousel = null;
    joinButton = null;
    signInButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */