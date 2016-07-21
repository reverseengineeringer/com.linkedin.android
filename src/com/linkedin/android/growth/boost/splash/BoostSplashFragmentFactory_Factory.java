package com.linkedin.android.growth.boost.splash;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class BoostSplashFragmentFactory_Factory
  implements Factory<BoostSplashFragmentFactory>
{
  private final MembersInjector<BoostSplashFragmentFactory> membersInjector;
  
  static
  {
    if (!BoostSplashFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private BoostSplashFragmentFactory_Factory(MembersInjector<BoostSplashFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<BoostSplashFragmentFactory> create(MembersInjector<BoostSplashFragmentFactory> paramMembersInjector)
  {
    return new BoostSplashFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.splash.BoostSplashFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */