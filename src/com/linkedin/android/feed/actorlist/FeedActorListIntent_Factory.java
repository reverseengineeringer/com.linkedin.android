package com.linkedin.android.feed.actorlist;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FeedActorListIntent_Factory
  implements Factory<FeedActorListIntent>
{
  private final MembersInjector<FeedActorListIntent> membersInjector;
  
  static
  {
    if (!FeedActorListIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedActorListIntent_Factory(MembersInjector<FeedActorListIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FeedActorListIntent> create(MembersInjector<FeedActorListIntent> paramMembersInjector)
  {
    return new FeedActorListIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.FeedActorListIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */