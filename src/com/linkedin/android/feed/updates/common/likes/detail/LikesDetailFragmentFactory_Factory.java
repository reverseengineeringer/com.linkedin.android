package com.linkedin.android.feed.updates.common.likes.detail;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class LikesDetailFragmentFactory_Factory
  implements Factory<LikesDetailFragmentFactory>
{
  private final MembersInjector<LikesDetailFragmentFactory> membersInjector;
  
  static
  {
    if (!LikesDetailFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LikesDetailFragmentFactory_Factory(MembersInjector<LikesDetailFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<LikesDetailFragmentFactory> create(MembersInjector<LikesDetailFragmentFactory> paramMembersInjector)
  {
    return new LikesDetailFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */