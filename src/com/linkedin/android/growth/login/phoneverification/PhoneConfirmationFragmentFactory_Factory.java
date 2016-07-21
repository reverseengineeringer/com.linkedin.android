package com.linkedin.android.growth.login.phoneverification;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class PhoneConfirmationFragmentFactory_Factory
  implements Factory<PhoneConfirmationFragmentFactory>
{
  private final MembersInjector<PhoneConfirmationFragmentFactory> membersInjector;
  
  static
  {
    if (!PhoneConfirmationFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PhoneConfirmationFragmentFactory_Factory(MembersInjector<PhoneConfirmationFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<PhoneConfirmationFragmentFactory> create(MembersInjector<PhoneConfirmationFragmentFactory> paramMembersInjector)
  {
    return new PhoneConfirmationFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */