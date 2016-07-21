package com.linkedin.android.growth.abi.splash;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class MainAbiSplashFragmentFactory_Factory
  implements Factory<MainAbiSplashFragmentFactory>
{
  private final MembersInjector<MainAbiSplashFragmentFactory> membersInjector;
  
  static
  {
    if (!MainAbiSplashFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private MainAbiSplashFragmentFactory_Factory(MembersInjector<MainAbiSplashFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<MainAbiSplashFragmentFactory> create(MembersInjector<MainAbiSplashFragmentFactory> paramMembersInjector)
  {
    return new MainAbiSplashFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */