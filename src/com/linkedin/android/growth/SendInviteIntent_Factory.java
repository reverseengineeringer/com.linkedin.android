package com.linkedin.android.growth;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class SendInviteIntent_Factory
  implements Factory<SendInviteIntent>
{
  private final MembersInjector<SendInviteIntent> membersInjector;
  
  static
  {
    if (!SendInviteIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private SendInviteIntent_Factory(MembersInjector<SendInviteIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<SendInviteIntent> create(MembersInjector<SendInviteIntent> paramMembersInjector)
  {
    return new SendInviteIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.SendInviteIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */