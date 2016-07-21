package com.linkedin.android.growth.onboarding.abi;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.linkedin.android.growth.abi.AbiResultFragment..ViewInjector;
import com.linkedin.android.infra.ui.TintableButton;

public class OnboardingAbiResultFragment$$ViewInjector<T extends OnboardingAbiResultFragment>
  extends AbiResultFragment..ViewInjector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    super.inject(paramFinder, paramT, paramObject);
    nextButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756107, "field 'nextButton'"), 2131756107, "field 'nextButton'"));
    inviteAllButton = ((TintableButton)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131756106, null), 2131756106, "field 'inviteAllButton'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131756076, null), 2131756076, "field 'subtitle'"));
  }
  
  public void reset(T paramT)
  {
    super.reset(paramT);
    nextButton = null;
    inviteAllButton = null;
    subtitle = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.OnboardingAbiResultFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */