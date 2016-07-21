package com.linkedin.android.growth.abi.splash;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class AbiLearnMoreFragmentFractory_Factory
  implements Factory<AbiLearnMoreFragmentFractory>
{
  private final MembersInjector<AbiLearnMoreFragmentFractory> membersInjector;
  
  static
  {
    if (!AbiLearnMoreFragmentFractory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiLearnMoreFragmentFractory_Factory(MembersInjector<AbiLearnMoreFragmentFractory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<AbiLearnMoreFragmentFractory> create(MembersInjector<AbiLearnMoreFragmentFractory> paramMembersInjector)
  {
    return new AbiLearnMoreFragmentFractory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiLearnMoreFragmentFractory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */