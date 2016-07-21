package com.linkedin.android.growth.onboarding.base;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class OnboardingProfileEditFragment$$ViewInjector<T extends OnboardingProfileEditFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    continueButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756106, "field 'continueButton'"), 2131756106, "field 'continueButton'"));
    skipButton = ((Button)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131756107, null), 2131756107, "field 'skipButton'"));
  }
  
  public void reset(T paramT)
  {
    continueButton = null;
    skipButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */