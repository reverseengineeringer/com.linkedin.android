package com.linkedin.android.growth.login;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class LoginIntent_Factory
  implements Factory<LoginIntent>
{
  private final MembersInjector<LoginIntent> membersInjector;
  
  static
  {
    if (!LoginIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LoginIntent_Factory(MembersInjector<LoginIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<LoginIntent> create(MembersInjector<LoginIntent> paramMembersInjector)
  {
    return new LoginIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */