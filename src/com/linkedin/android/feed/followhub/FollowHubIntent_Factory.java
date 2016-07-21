package com.linkedin.android.feed.followhub;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FollowHubIntent_Factory
  implements Factory<FollowHubIntent>
{
  private final MembersInjector<FollowHubIntent> membersInjector;
  
  static
  {
    if (!FollowHubIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FollowHubIntent_Factory(MembersInjector<FollowHubIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FollowHubIntent> create(MembersInjector<FollowHubIntent> paramMembersInjector)
  {
    return new FollowHubIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */