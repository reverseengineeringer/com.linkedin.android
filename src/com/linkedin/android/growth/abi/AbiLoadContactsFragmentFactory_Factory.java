package com.linkedin.android.growth.abi;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class AbiLoadContactsFragmentFactory_Factory
  implements Factory<AbiLoadContactsFragmentFactory>
{
  private final MembersInjector<AbiLoadContactsFragmentFactory> membersInjector;
  
  static
  {
    if (!AbiLoadContactsFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiLoadContactsFragmentFactory_Factory(MembersInjector<AbiLoadContactsFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<AbiLoadContactsFragmentFactory> create(MembersInjector<AbiLoadContactsFragmentFactory> paramMembersInjector)
  {
    return new AbiLoadContactsFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiLoadContactsFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */