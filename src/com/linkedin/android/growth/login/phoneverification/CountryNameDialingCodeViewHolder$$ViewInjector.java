package com.linkedin.android.growth.login.phoneverification;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CountryNameDialingCodeViewHolder$$ViewInjector<T extends CountryNameDialingCodeViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    countryName = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756173, "field 'countryName'"), 2131756173, "field 'countryName'"));
    dialingCode = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756174, "field 'dialingCode'"), 2131756174, "field 'dialingCode'"));
  }
  
  public void reset(T paramT)
  {
    countryName = null;
    dialingCode = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.CountryNameDialingCodeViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */