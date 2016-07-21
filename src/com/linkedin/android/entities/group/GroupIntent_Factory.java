package com.linkedin.android.entities.group;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class GroupIntent_Factory
  implements Factory<GroupIntent>
{
  private final MembersInjector<GroupIntent> membersInjector;
  
  static
  {
    if (!GroupIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private GroupIntent_Factory(MembersInjector<GroupIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<GroupIntent> create(MembersInjector<GroupIntent> paramMembersInjector)
  {
    return new GroupIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */