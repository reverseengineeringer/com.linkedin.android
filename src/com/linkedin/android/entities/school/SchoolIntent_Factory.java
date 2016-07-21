package com.linkedin.android.entities.school;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class SchoolIntent_Factory
  implements Factory<SchoolIntent>
{
  private final MembersInjector<SchoolIntent> membersInjector;
  
  static
  {
    if (!SchoolIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private SchoolIntent_Factory(MembersInjector<SchoolIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<SchoolIntent> create(MembersInjector<SchoolIntent> paramMembersInjector)
  {
    return new SchoolIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.SchoolIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */