package com.linkedin.android.growth.boost;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class BoostIntent_Factory
  implements Factory<BoostIntent>
{
  private final MembersInjector<BoostIntent> membersInjector;
  
  static
  {
    if (!BoostIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private BoostIntent_Factory(MembersInjector<BoostIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<BoostIntent> create(MembersInjector<BoostIntent> paramMembersInjector)
  {
    return new BoostIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.BoostIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */