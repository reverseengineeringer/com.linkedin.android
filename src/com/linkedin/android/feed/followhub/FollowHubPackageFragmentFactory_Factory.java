package com.linkedin.android.feed.followhub;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FollowHubPackageFragmentFactory_Factory
  implements Factory<FollowHubPackageFragmentFactory>
{
  private final MembersInjector<FollowHubPackageFragmentFactory> membersInjector;
  
  static
  {
    if (!FollowHubPackageFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FollowHubPackageFragmentFactory_Factory(MembersInjector<FollowHubPackageFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FollowHubPackageFragmentFactory> create(MembersInjector<FollowHubPackageFragmentFactory> paramMembersInjector)
  {
    return new FollowHubPackageFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubPackageFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */