package com.linkedin.android.entities.group;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GroupDataProvider_Factory
  implements Factory<GroupDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<GroupDataProvider> membersInjector;
  
  static
  {
    if (!GroupDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private GroupDataProvider_Factory(MembersInjector<GroupDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<GroupDataProvider> create(MembersInjector<GroupDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new GroupDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */