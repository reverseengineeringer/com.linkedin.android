package com.linkedin.android.growth.login.phoneverification;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class PinVerificationFragmentFactory_Factory
  implements Factory<PinVerificationFragmentFactory>
{
  private final MembersInjector<PinVerificationFragmentFactory> membersInjector;
  
  static
  {
    if (!PinVerificationFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PinVerificationFragmentFactory_Factory(MembersInjector<PinVerificationFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<PinVerificationFragmentFactory> create(MembersInjector<PinVerificationFragmentFactory> paramMembersInjector)
  {
    return new PinVerificationFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */