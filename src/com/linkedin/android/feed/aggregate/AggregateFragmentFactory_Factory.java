package com.linkedin.android.feed.aggregate;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class AggregateFragmentFactory_Factory
  implements Factory<AggregateFragmentFactory>
{
  private final MembersInjector<AggregateFragmentFactory> membersInjector;
  
  static
  {
    if (!AggregateFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AggregateFragmentFactory_Factory(MembersInjector<AggregateFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<AggregateFragmentFactory> create(MembersInjector<AggregateFragmentFactory> paramMembersInjector)
  {
    return new AggregateFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */