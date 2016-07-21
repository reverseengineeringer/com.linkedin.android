package com.linkedin.android.feed.page.feed.unfolloweducate;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UnfollowEducateDataProvider_Factory
  implements Factory<UnfollowEducateDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<UnfollowEducateDataProvider> membersInjector;
  
  static
  {
    if (!UnfollowEducateDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private UnfollowEducateDataProvider_Factory(MembersInjector<UnfollowEducateDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<UnfollowEducateDataProvider> create(MembersInjector<UnfollowEducateDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new UnfollowEducateDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */