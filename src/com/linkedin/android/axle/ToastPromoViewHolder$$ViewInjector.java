package com.linkedin.android.axle;

import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ToastPromoViewHolder$$ViewInjector<T extends ToastPromoViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    container = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756510, "field 'container'"), 2131756510, "field 'container'"));
  }
  
  public void reset(T paramT)
  {
    container = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromoViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */