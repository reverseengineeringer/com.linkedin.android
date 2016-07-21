package com.linkedin.android.growth.newtovoyager.organic;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class NewToVoyagerIntroIntent_Factory
  implements Factory<NewToVoyagerIntroIntent>
{
  private final MembersInjector<NewToVoyagerIntroIntent> membersInjector;
  
  static
  {
    if (!NewToVoyagerIntroIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private NewToVoyagerIntroIntent_Factory(MembersInjector<NewToVoyagerIntroIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<NewToVoyagerIntroIntent> create(MembersInjector<NewToVoyagerIntroIntent> paramMembersInjector)
  {
    return new NewToVoyagerIntroIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */