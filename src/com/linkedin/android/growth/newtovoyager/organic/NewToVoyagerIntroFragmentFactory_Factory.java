package com.linkedin.android.growth.newtovoyager.organic;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class NewToVoyagerIntroFragmentFactory_Factory
  implements Factory<NewToVoyagerIntroFragmentFactory>
{
  private final MembersInjector<NewToVoyagerIntroFragmentFactory> membersInjector;
  
  static
  {
    if (!NewToVoyagerIntroFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private NewToVoyagerIntroFragmentFactory_Factory(MembersInjector<NewToVoyagerIntroFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<NewToVoyagerIntroFragmentFactory> create(MembersInjector<NewToVoyagerIntroFragmentFactory> paramMembersInjector)
  {
    return new NewToVoyagerIntroFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */