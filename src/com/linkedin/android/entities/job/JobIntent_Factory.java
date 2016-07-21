package com.linkedin.android.entities.job;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class JobIntent_Factory
  implements Factory<JobIntent>
{
  private final MembersInjector<JobIntent> membersInjector;
  
  static
  {
    if (!JobIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private JobIntent_Factory(MembersInjector<JobIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<JobIntent> create(MembersInjector<JobIntent> paramMembersInjector)
  {
    return new JobIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */