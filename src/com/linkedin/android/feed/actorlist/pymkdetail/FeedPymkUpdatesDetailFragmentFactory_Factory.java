package com.linkedin.android.feed.actorlist.pymkdetail;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FeedPymkUpdatesDetailFragmentFactory_Factory
  implements Factory<FeedPymkUpdatesDetailFragmentFactory>
{
  private final MembersInjector<FeedPymkUpdatesDetailFragmentFactory> membersInjector;
  
  static
  {
    if (!FeedPymkUpdatesDetailFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedPymkUpdatesDetailFragmentFactory_Factory(MembersInjector<FeedPymkUpdatesDetailFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FeedPymkUpdatesDetailFragmentFactory> create(MembersInjector<FeedPymkUpdatesDetailFragmentFactory> paramMembersInjector)
  {
    return new FeedPymkUpdatesDetailFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.pymkdetail.FeedPymkUpdatesDetailFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */