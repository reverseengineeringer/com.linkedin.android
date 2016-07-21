package com.linkedin.android.growth.onboarding.abi.m2g;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class OnboardingAbiM2GUnifiedSMSEmailFragmentFactory_Factory
  implements Factory<OnboardingAbiM2GUnifiedSMSEmailFragmentFactory>
{
  private final MembersInjector<OnboardingAbiM2GUnifiedSMSEmailFragmentFactory> membersInjector;
  
  static
  {
    if (!OnboardingAbiM2GUnifiedSMSEmailFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingAbiM2GUnifiedSMSEmailFragmentFactory_Factory(MembersInjector<OnboardingAbiM2GUnifiedSMSEmailFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<OnboardingAbiM2GUnifiedSMSEmailFragmentFactory> create(MembersInjector<OnboardingAbiM2GUnifiedSMSEmailFragmentFactory> paramMembersInjector)
  {
    return new OnboardingAbiM2GUnifiedSMSEmailFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GUnifiedSMSEmailFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */