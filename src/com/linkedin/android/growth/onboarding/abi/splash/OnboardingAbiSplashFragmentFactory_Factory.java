package com.linkedin.android.growth.onboarding.abi.splash;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class OnboardingAbiSplashFragmentFactory_Factory
  implements Factory<OnboardingAbiSplashFragmentFactory>
{
  private final MembersInjector<OnboardingAbiSplashFragmentFactory> membersInjector;
  
  static
  {
    if (!OnboardingAbiSplashFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingAbiSplashFragmentFactory_Factory(MembersInjector<OnboardingAbiSplashFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<OnboardingAbiSplashFragmentFactory> create(MembersInjector<OnboardingAbiSplashFragmentFactory> paramMembersInjector)
  {
    return new OnboardingAbiSplashFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */