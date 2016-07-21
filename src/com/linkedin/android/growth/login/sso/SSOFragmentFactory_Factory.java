package com.linkedin.android.growth.login.sso;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class SSOFragmentFactory_Factory
  implements Factory<SSOFragmentFactory>
{
  private final MembersInjector<SSOFragmentFactory> membersInjector;
  
  static
  {
    if (!SSOFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private SSOFragmentFactory_Factory(MembersInjector<SSOFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<SSOFragmentFactory> create(MembersInjector<SSOFragmentFactory> paramMembersInjector)
  {
    return new SSOFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.sso.SSOFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */