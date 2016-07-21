package com.linkedin.android.growth.login.prereg;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PreRegPropFragment$$ViewInjector<T extends PreRegPropFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    joinButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756186, "field 'joinButton'"), 2131756186, "field 'joinButton'"));
    signInButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756187, "field 'signInButton'"), 2131756187, "field 'signInButton'"));
  }
  
  public void reset(T paramT)
  {
    joinButton = null;
    signInButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegPropFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */