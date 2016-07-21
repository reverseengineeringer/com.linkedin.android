package com.linkedin.android.growth;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class InviteAcceptIntent_Factory
  implements Factory<InviteAcceptIntent>
{
  private final MembersInjector<InviteAcceptIntent> membersInjector;
  
  static
  {
    if (!InviteAcceptIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private InviteAcceptIntent_Factory(MembersInjector<InviteAcceptIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<InviteAcceptIntent> create(MembersInjector<InviteAcceptIntent> paramMembersInjector)
  {
    return new InviteAcceptIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.InviteAcceptIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */