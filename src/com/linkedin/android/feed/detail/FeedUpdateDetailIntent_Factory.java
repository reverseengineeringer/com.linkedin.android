package com.linkedin.android.feed.detail;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FeedUpdateDetailIntent_Factory
  implements Factory<FeedUpdateDetailIntent>
{
  private final MembersInjector<FeedUpdateDetailIntent> membersInjector;
  
  static
  {
    if (!FeedUpdateDetailIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedUpdateDetailIntent_Factory(MembersInjector<FeedUpdateDetailIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FeedUpdateDetailIntent> create(MembersInjector<FeedUpdateDetailIntent> paramMembersInjector)
  {
    return new FeedUpdateDetailIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */