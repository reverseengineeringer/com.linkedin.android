package com.linkedin.android.growth.login.fastrack;

import com.linkedin.android.infra.network.Auth;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FastrackManager_Factory
  implements Factory<FastrackManager>
{
  private final Provider<Auth> authProvider;
  private final MembersInjector<FastrackManager> membersInjector;
  
  static
  {
    if (!FastrackManager_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FastrackManager_Factory(MembersInjector<FastrackManager> paramMembersInjector, Provider<Auth> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    authProvider = paramProvider;
  }
  
  public static Factory<FastrackManager> create(MembersInjector<FastrackManager> paramMembersInjector, Provider<Auth> paramProvider)
  {
    return new FastrackManager_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.fastrack.FastrackManager_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */