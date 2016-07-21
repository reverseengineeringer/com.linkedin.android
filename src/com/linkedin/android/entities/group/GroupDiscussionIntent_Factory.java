package com.linkedin.android.entities.group;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class GroupDiscussionIntent_Factory
  implements Factory<GroupDiscussionIntent>
{
  private final MembersInjector<GroupDiscussionIntent> membersInjector;
  
  static
  {
    if (!GroupDiscussionIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private GroupDiscussionIntent_Factory(MembersInjector<GroupDiscussionIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<GroupDiscussionIntent> create(MembersInjector<GroupDiscussionIntent> paramMembersInjector)
  {
    return new GroupDiscussionIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupDiscussionIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */