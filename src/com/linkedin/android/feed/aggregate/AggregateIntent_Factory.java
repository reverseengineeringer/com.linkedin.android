package com.linkedin.android.feed.aggregate;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class AggregateIntent_Factory
  implements Factory<AggregateIntent>
{
  private final MembersInjector<AggregateIntent> membersInjector;
  
  static
  {
    if (!AggregateIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AggregateIntent_Factory(MembersInjector<AggregateIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<AggregateIntent> create(MembersInjector<AggregateIntent> paramMembersInjector)
  {
    return new AggregateIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */