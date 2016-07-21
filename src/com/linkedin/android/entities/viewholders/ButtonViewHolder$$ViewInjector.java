package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ButtonViewHolder$$ViewInjector<T extends ButtonViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    button = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755404, "field 'button'"), 2131755404, "field 'button'"));
  }
  
  public void reset(T paramT)
  {
    button = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.ButtonViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */