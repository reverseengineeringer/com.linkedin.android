package com.linkedin.android.growth.heathrow;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HeathrowFlowDataProvider_Factory
  implements Factory<HeathrowFlowDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<HeathrowFlowDataProvider> membersInjector;
  
  static
  {
    if (!HeathrowFlowDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private HeathrowFlowDataProvider_Factory(MembersInjector<HeathrowFlowDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<HeathrowFlowDataProvider> create(MembersInjector<HeathrowFlowDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new HeathrowFlowDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowFlowDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */