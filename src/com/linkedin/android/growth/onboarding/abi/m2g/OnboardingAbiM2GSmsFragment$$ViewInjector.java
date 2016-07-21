package com.linkedin.android.growth.onboarding.abi.m2g;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.ButterKnife.Finder;
import com.linkedin.android.growth.onboarding.abi.OnboardingAbiResultFragment..ViewInjector;

public class OnboardingAbiM2GSmsFragment$$ViewInjector<T extends OnboardingAbiM2GSmsFragment>
  extends OnboardingAbiResultFragment..ViewInjector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    super.inject(paramFinder, paramT, paramObject);
    singleNextButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756077, "field 'singleNextButton'"), 2131756077, "field 'singleNextButton'"));
    doubleNavigationButtonContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756121, "field 'doubleNavigationButtonContainer'"), 2131756121, "field 'doubleNavigationButtonContainer'"));
  }
  
  public void reset(T paramT)
  {
    super.reset(paramT);
    singleNextButton = null;
    doubleNavigationButtonContainer = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GSmsFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */