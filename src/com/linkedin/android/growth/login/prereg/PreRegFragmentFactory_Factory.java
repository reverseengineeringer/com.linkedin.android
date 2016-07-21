package com.linkedin.android.growth.login.prereg;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class PreRegFragmentFactory_Factory
  implements Factory<PreRegFragmentFactory>
{
  private final MembersInjector<PreRegFragmentFactory> membersInjector;
  
  static
  {
    if (!PreRegFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PreRegFragmentFactory_Factory(MembersInjector<PreRegFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<PreRegFragmentFactory> create(MembersInjector<PreRegFragmentFactory> paramMembersInjector)
  {
    return new PreRegFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */