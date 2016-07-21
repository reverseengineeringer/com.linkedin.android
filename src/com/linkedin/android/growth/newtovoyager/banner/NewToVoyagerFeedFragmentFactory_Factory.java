package com.linkedin.android.growth.newtovoyager.banner;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class NewToVoyagerFeedFragmentFactory_Factory
  implements Factory<NewToVoyagerFeedFragmentFactory>
{
  private final MembersInjector<NewToVoyagerFeedFragmentFactory> membersInjector;
  
  static
  {
    if (!NewToVoyagerFeedFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private NewToVoyagerFeedFragmentFactory_Factory(MembersInjector<NewToVoyagerFeedFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<NewToVoyagerFeedFragmentFactory> create(MembersInjector<NewToVoyagerFeedFragmentFactory> paramMembersInjector)
  {
    return new NewToVoyagerFeedFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */