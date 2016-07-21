package com.linkedin.android.feed.page.feed.unfolloweducate;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class UnfollowEducateFactory_Factory
  implements Factory<UnfollowEducateFactory>
{
  private final MembersInjector<UnfollowEducateFactory> membersInjector;
  
  static
  {
    if (!UnfollowEducateFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private UnfollowEducateFactory_Factory(MembersInjector<UnfollowEducateFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<UnfollowEducateFactory> create(MembersInjector<UnfollowEducateFactory> paramMembersInjector)
  {
    return new UnfollowEducateFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */