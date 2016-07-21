package com.linkedin.android.growth.login.join;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class JoinFragmentFactory_Factory
  implements Factory<JoinFragmentFactory>
{
  private final MembersInjector<JoinFragmentFactory> membersInjector;
  
  static
  {
    if (!JoinFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private JoinFragmentFactory_Factory(MembersInjector<JoinFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<JoinFragmentFactory> create(MembersInjector<JoinFragmentFactory> paramMembersInjector)
  {
    return new JoinFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */