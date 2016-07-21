package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BarItemViewHolder$$ViewInjector<T extends BarItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    fullBar = ((View)paramFinder.findRequiredView(paramObject, 2131755482, "field 'fullBar'"));
    emptyBar = ((View)paramFinder.findRequiredView(paramObject, 2131755483, "field 'emptyBar'"));
    value = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755484, "field 'value'"), 2131755484, "field 'value'"));
    caption = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755485, "field 'caption'"), 2131755485, "field 'caption'"));
  }
  
  public void reset(T paramT)
  {
    fullBar = null;
    emptyBar = null;
    value = null;
    caption = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.BarItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */