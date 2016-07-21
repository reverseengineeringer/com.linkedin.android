package com.linkedin.android.growth.onboarding.abi.m2g;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class OnboardingAbiM2GEmailFragmentFactory_Factory
  implements Factory<OnboardingAbiM2GEmailFragmentFactory>
{
  private final MembersInjector<OnboardingAbiM2GEmailFragmentFactory> membersInjector;
  
  static
  {
    if (!OnboardingAbiM2GEmailFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingAbiM2GEmailFragmentFactory_Factory(MembersInjector<OnboardingAbiM2GEmailFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<OnboardingAbiM2GEmailFragmentFactory> create(MembersInjector<OnboardingAbiM2GEmailFragmentFactory> paramMembersInjector)
  {
    return new OnboardingAbiM2GEmailFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GEmailFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */