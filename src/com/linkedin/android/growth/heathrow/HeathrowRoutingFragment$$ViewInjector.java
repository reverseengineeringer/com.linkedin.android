package com.linkedin.android.growth.heathrow;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HeathrowRoutingFragment$$ViewInjector<T extends HeathrowRoutingFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    heathrowRedirectTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756006, "field 'heathrowRedirectTextView'"), 2131756006, "field 'heathrowRedirectTextView'"));
  }
  
  public void reset(T paramT)
  {
    heathrowRedirectTextView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowRoutingFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */