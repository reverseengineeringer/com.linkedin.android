package com.linkedin.android.feed.page.feed;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FeedFragmentFactory_Factory
  implements Factory<FeedFragmentFactory>
{
  private final MembersInjector<FeedFragmentFactory> membersInjector;
  
  static
  {
    if (!FeedFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedFragmentFactory_Factory(MembersInjector<FeedFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FeedFragmentFactory> create(MembersInjector<FeedFragmentFactory> paramMembersInjector)
  {
    return new FeedFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */