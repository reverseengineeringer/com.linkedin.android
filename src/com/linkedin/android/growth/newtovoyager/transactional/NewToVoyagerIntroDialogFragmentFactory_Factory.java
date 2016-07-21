package com.linkedin.android.growth.newtovoyager.transactional;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class NewToVoyagerIntroDialogFragmentFactory_Factory
  implements Factory<NewToVoyagerIntroDialogFragmentFactory>
{
  private final MembersInjector<NewToVoyagerIntroDialogFragmentFactory> membersInjector;
  
  static
  {
    if (!NewToVoyagerIntroDialogFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private NewToVoyagerIntroDialogFragmentFactory_Factory(MembersInjector<NewToVoyagerIntroDialogFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<NewToVoyagerIntroDialogFragmentFactory> create(MembersInjector<NewToVoyagerIntroDialogFragmentFactory> paramMembersInjector)
  {
    return new NewToVoyagerIntroDialogFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */