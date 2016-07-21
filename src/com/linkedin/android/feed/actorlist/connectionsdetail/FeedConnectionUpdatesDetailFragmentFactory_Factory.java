package com.linkedin.android.feed.actorlist.connectionsdetail;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FeedConnectionUpdatesDetailFragmentFactory_Factory
  implements Factory<FeedConnectionUpdatesDetailFragmentFactory>
{
  private final MembersInjector<FeedConnectionUpdatesDetailFragmentFactory> membersInjector;
  
  static
  {
    if (!FeedConnectionUpdatesDetailFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedConnectionUpdatesDetailFragmentFactory_Factory(MembersInjector<FeedConnectionUpdatesDetailFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FeedConnectionUpdatesDetailFragmentFactory> create(MembersInjector<FeedConnectionUpdatesDetailFragmentFactory> paramMembersInjector)
  {
    return new FeedConnectionUpdatesDetailFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.connectionsdetail.FeedConnectionUpdatesDetailFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */