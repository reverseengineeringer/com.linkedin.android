package com.linkedin.android.feed.followhub;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FollowHubFragmentFactory_Factory
  implements Factory<FollowHubFragmentFactory>
{
  private final MembersInjector<FollowHubFragmentFactory> membersInjector;
  
  static
  {
    if (!FollowHubFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FollowHubFragmentFactory_Factory(MembersInjector<FollowHubFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FollowHubFragmentFactory> create(MembersInjector<FollowHubFragmentFactory> paramMembersInjector)
  {
    return new FollowHubFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */