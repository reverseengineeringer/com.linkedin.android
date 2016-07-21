package com.linkedin.android.growth.abi;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class WyloIntent_Factory
  implements Factory<WyloIntent>
{
  private final MembersInjector<WyloIntent> membersInjector;
  
  static
  {
    if (!WyloIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private WyloIntent_Factory(MembersInjector<WyloIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<WyloIntent> create(MembersInjector<WyloIntent> paramMembersInjector)
  {
    return new WyloIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.WyloIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */