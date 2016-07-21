package com.linkedin.android.axle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;

public class SplashPromoViewHolder$$ViewInjector<T extends SplashPromoViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755227, "field 'title'"), 2131755227, "field 'title'"));
    viewPagerContainer = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755226, "field 'viewPagerContainer'"), 2131755226, "field 'viewPagerContainer'"));
    viewPager = ((WrapContentHeightViewPager)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755228, "field 'viewPager'"), 2131755228, "field 'viewPager'"));
    pagerIndicator = ((HorizontalViewPagerCarousel)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755229, "field 'pagerIndicator'"), 2131755229, "field 'pagerIndicator'"));
    dismissButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755231, "field 'dismissButton'"), 2131755231, "field 'dismissButton'"));
    promptButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755232, "field 'promptButton'"), 2131755232, "field 'promptButton'"));
    secondaryPromptButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755233, "field 'secondaryPromptButton'"), 2131755233, "field 'secondaryPromptButton'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    viewPagerContainer = null;
    viewPager = null;
    pagerIndicator = null;
    dismissButton = null;
    promptButton = null;
    secondaryPromptButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */