package com.linkedin.android.growth.abi.m2m;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class MainAbiM2MFragmentFactory_Factory
  implements Factory<MainAbiM2MFragmentFactory>
{
  private final MembersInjector<MainAbiM2MFragmentFactory> membersInjector;
  
  static
  {
    if (!MainAbiM2MFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private MainAbiM2MFragmentFactory_Factory(MembersInjector<MainAbiM2MFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<MainAbiM2MFragmentFactory> create(MembersInjector<MainAbiM2MFragmentFactory> paramMembersInjector)
  {
    return new MainAbiM2MFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2m.MainAbiM2MFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */