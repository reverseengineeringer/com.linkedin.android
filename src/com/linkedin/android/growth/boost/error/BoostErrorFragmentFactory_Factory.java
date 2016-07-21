package com.linkedin.android.growth.boost.error;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class BoostErrorFragmentFactory_Factory
  implements Factory<BoostErrorFragmentFactory>
{
  private final MembersInjector<BoostErrorFragmentFactory> membersInjector;
  
  static
  {
    if (!BoostErrorFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private BoostErrorFragmentFactory_Factory(MembersInjector<BoostErrorFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<BoostErrorFragmentFactory> create(MembersInjector<BoostErrorFragmentFactory> paramMembersInjector)
  {
    return new BoostErrorFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.error.BoostErrorFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */