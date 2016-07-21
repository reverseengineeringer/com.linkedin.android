package com.linkedin.android.growth.login.login;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class LoginFragmentFactory_Factory
  implements Factory<LoginFragmentFactory>
{
  private final MembersInjector<LoginFragmentFactory> membersInjector;
  
  static
  {
    if (!LoginFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LoginFragmentFactory_Factory(MembersInjector<LoginFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<LoginFragmentFactory> create(MembersInjector<LoginFragmentFactory> paramMembersInjector)
  {
    return new LoginFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */