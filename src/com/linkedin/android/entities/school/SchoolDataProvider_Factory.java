package com.linkedin.android.entities.school;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SchoolDataProvider_Factory
  implements Factory<SchoolDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<SchoolDataProvider> membersInjector;
  
  static
  {
    if (!SchoolDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private SchoolDataProvider_Factory(MembersInjector<SchoolDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<SchoolDataProvider> create(MembersInjector<SchoolDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new SchoolDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.SchoolDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */