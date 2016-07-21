package com.linkedin.android.growth.abi;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class AbiIntent_Factory
  implements Factory<AbiIntent>
{
  private final MembersInjector<AbiIntent> membersInjector;
  
  static
  {
    if (!AbiIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiIntent_Factory(MembersInjector<AbiIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<AbiIntent> create(MembersInjector<AbiIntent> paramMembersInjector)
  {
    return new AbiIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */