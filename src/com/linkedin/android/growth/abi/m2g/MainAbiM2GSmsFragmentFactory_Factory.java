package com.linkedin.android.growth.abi.m2g;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class MainAbiM2GSmsFragmentFactory_Factory
  implements Factory<MainAbiM2GSmsFragmentFactory>
{
  private final MembersInjector<MainAbiM2GSmsFragmentFactory> membersInjector;
  
  static
  {
    if (!MainAbiM2GSmsFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private MainAbiM2GSmsFragmentFactory_Factory(MembersInjector<MainAbiM2GSmsFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<MainAbiM2GSmsFragmentFactory> create(MembersInjector<MainAbiM2GSmsFragmentFactory> paramMembersInjector)
  {
    return new MainAbiM2GSmsFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2g.MainAbiM2GSmsFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */