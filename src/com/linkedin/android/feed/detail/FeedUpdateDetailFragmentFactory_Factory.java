package com.linkedin.android.feed.detail;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FeedUpdateDetailFragmentFactory_Factory
  implements Factory<FeedUpdateDetailFragmentFactory>
{
  private final MembersInjector<FeedUpdateDetailFragmentFactory> membersInjector;
  
  static
  {
    if (!FeedUpdateDetailFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedUpdateDetailFragmentFactory_Factory(MembersInjector<FeedUpdateDetailFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FeedUpdateDetailFragmentFactory> create(MembersInjector<FeedUpdateDetailFragmentFactory> paramMembersInjector)
  {
    return new FeedUpdateDetailFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */