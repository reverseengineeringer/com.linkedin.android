package com.linkedin.android.growth.onboarding.abi.m2g;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class OnboardingAbiM2GSmsFragmentFactory_Factory
  implements Factory<OnboardingAbiM2GSmsFragmentFactory>
{
  private final MembersInjector<OnboardingAbiM2GSmsFragmentFactory> membersInjector;
  
  static
  {
    if (!OnboardingAbiM2GSmsFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingAbiM2GSmsFragmentFactory_Factory(MembersInjector<OnboardingAbiM2GSmsFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<OnboardingAbiM2GSmsFragmentFactory> create(MembersInjector<OnboardingAbiM2GSmsFragmentFactory> paramMembersInjector)
  {
    return new OnboardingAbiM2GSmsFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GSmsFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */