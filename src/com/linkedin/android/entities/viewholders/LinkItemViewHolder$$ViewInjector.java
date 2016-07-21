package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class LinkItemViewHolder$$ViewInjector<T extends LinkItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    linkText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755506, "field 'linkText'"), 2131755506, "field 'linkText'"));
  }
  
  public void reset(T paramT)
  {
    linkText = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.LinkItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */