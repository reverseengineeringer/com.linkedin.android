package com.linkedin.android.entities.job;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class JobDataProvider_Factory
  implements Factory<JobDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<JobDataProvider> membersInjector;
  
  static
  {
    if (!JobDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private JobDataProvider_Factory(MembersInjector<JobDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<JobDataProvider> create(MembersInjector<JobDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new JobDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */