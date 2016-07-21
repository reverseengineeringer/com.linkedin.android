package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CrossPromoHeroViewHolder$$ViewInjector<T extends CrossPromoHeroViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    container = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755754, "field 'container'"), 2131755754, "field 'container'"));
  }
  
  public void reset(T paramT)
  {
    container = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */