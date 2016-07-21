package com.linkedin.android.growth.abi;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AbiDataProvider_Factory
  implements Factory<AbiDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<AbiDataProvider> membersInjector;
  
  static
  {
    if (!AbiDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiDataProvider_Factory(MembersInjector<AbiDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<AbiDataProvider> create(MembersInjector<AbiDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new AbiDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */