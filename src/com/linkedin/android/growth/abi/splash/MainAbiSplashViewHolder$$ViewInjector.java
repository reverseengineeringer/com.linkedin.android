package com.linkedin.android.growth.abi.splash;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MainAbiSplashViewHolder$$ViewInjector<T extends MainAbiSplashViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    learnMoreButton = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755960, "field 'learnMoreButton'"), 2131755960, "field 'learnMoreButton'"));
    abiSplashHeadingText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755964, "field 'abiSplashHeadingText'"), 2131755964, "field 'abiSplashHeadingText'"));
    abiSplashDisclaimerText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755959, "field 'abiSplashDisclaimerText'"), 2131755959, "field 'abiSplashDisclaimerText'"));
  }
  
  public void reset(T paramT)
  {
    learnMoreButton = null;
    abiSplashHeadingText = null;
    abiSplashDisclaimerText = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */