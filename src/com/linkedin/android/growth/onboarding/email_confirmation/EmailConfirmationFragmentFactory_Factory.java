package com.linkedin.android.growth.onboarding.email_confirmation;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class EmailConfirmationFragmentFactory_Factory
  implements Factory<EmailConfirmationFragmentFactory>
{
  private final MembersInjector<EmailConfirmationFragmentFactory> membersInjector;
  
  static
  {
    if (!EmailConfirmationFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private EmailConfirmationFragmentFactory_Factory(MembersInjector<EmailConfirmationFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<EmailConfirmationFragmentFactory> create(MembersInjector<EmailConfirmationFragmentFactory> paramMembersInjector)
  {
    return new EmailConfirmationFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */