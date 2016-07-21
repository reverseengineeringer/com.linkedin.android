package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class EmployeeQuoteItemViewHolder$$ViewInjector<T extends EmployeeQuoteItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    body = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755487, "field 'body'"), 2131755487, "field 'body'"));
  }
  
  public void reset(T paramT)
  {
    body = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EmployeeQuoteItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */