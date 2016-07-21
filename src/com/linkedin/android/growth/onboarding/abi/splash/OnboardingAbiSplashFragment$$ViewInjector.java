package com.linkedin.android.growth.onboarding.abi.splash;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseFragment..ViewInjector;

public class OnboardingAbiSplashFragment$$ViewInjector<T extends OnboardingAbiSplashFragment>
  extends AbiSplashBaseFragment..ViewInjector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    super.inject(paramFinder, paramT, paramObject);
    skipButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756079, "field 'skipButton'"), 2131756079, "field 'skipButton'"));
    learnMoreText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755960, "field 'learnMoreText'"), 2131755960, "field 'learnMoreText'"));
    container = ((View)paramFinder.findRequiredView(paramObject, 2131755965, "field 'container'"));
  }
  
  public void reset(T paramT)
  {
    super.reset(paramT);
    skipButton = null;
    learnMoreText = null;
    container = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */