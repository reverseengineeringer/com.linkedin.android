package com.linkedin.android.growth.abi.splash;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AbiSplashBaseFragment$$ViewInjector<T extends AbiSplashBaseFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    continueButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755958, "field 'continueButton'"), 2131755958, "field 'continueButton'"));
  }
  
  public void reset(T paramT)
  {
    continueButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiSplashBaseFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */