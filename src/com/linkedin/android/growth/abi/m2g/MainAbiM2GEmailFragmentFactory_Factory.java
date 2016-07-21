package com.linkedin.android.growth.abi.m2g;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class MainAbiM2GEmailFragmentFactory_Factory
  implements Factory<MainAbiM2GEmailFragmentFactory>
{
  private final MembersInjector<MainAbiM2GEmailFragmentFactory> membersInjector;
  
  static
  {
    if (!MainAbiM2GEmailFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private MainAbiM2GEmailFragmentFactory_Factory(MembersInjector<MainAbiM2GEmailFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<MainAbiM2GEmailFragmentFactory> create(MembersInjector<MainAbiM2GEmailFragmentFactory> paramMembersInjector)
  {
    return new MainAbiM2GEmailFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2g.MainAbiM2GEmailFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */