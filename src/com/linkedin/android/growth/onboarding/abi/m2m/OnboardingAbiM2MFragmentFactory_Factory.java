package com.linkedin.android.growth.onboarding.abi.m2m;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class OnboardingAbiM2MFragmentFactory_Factory
  implements Factory<OnboardingAbiM2MFragmentFactory>
{
  private final MembersInjector<OnboardingAbiM2MFragmentFactory> membersInjector;
  
  static
  {
    if (!OnboardingAbiM2MFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingAbiM2MFragmentFactory_Factory(MembersInjector<OnboardingAbiM2MFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<OnboardingAbiM2MFragmentFactory> create(MembersInjector<OnboardingAbiM2MFragmentFactory> paramMembersInjector)
  {
    return new OnboardingAbiM2MFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2m.OnboardingAbiM2MFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */