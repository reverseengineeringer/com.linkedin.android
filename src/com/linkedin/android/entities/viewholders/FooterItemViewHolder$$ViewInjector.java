package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FooterItemViewHolder$$ViewInjector<T extends FooterItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    text = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755502, "field 'text'"), 2131755502, "field 'text'"));
  }
  
  public void reset(T paramT)
  {
    text = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.FooterItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */