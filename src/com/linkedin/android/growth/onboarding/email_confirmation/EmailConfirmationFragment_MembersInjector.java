package com.linkedin.android.growth.onboarding.email_confirmation;

import com.linkedin.android.ConfirmEmailAddress.EmailManagementController;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.login.presenters.InputValidationPresenter;
import com.linkedin.android.growth.utils.InputValidator;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.DelayedExecution;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class EmailConfirmationFragment_MembersInjector
  implements MembersInjector<EmailConfirmationFragment>
{
  private final Provider<DelayedExecution> delayedExecutionProvider;
  private final Provider<EmailManagementController> emailSenderProvider;
  private final Provider<InputValidationPresenter> inputValidationPresenterProvider;
  private final Provider<InputValidator> inputValidatorProvider;
  private final Provider<IntentRegistry> intentRegistryProvider;
  private final Provider<FlagshipSharedPreferences> sharedPreferencesProvider;
  private final MembersInjector<LegoFragment> supertypeInjector;
  
  static
  {
    if (!EmailConfirmationFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private EmailConfirmationFragment_MembersInjector(MembersInjector<LegoFragment> paramMembersInjector, Provider<FlagshipSharedPreferences> paramProvider, Provider<InputValidator> paramProvider1, Provider<InputValidationPresenter> paramProvider2, Provider<DelayedExecution> paramProvider3, Provider<EmailManagementController> paramProvider4, Provider<IntentRegistry> paramProvider5)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    sharedPreferencesProvider = paramProvider;
    assert (paramProvider1 != null);
    inputValidatorProvider = paramProvider1;
    assert (paramProvider2 != null);
    inputValidationPresenterProvider = paramProvider2;
    assert (paramProvider3 != null);
    delayedExecutionProvider = paramProvider3;
    assert (paramProvider4 != null);
    emailSenderProvider = paramProvider4;
    assert (paramProvider5 != null);
    intentRegistryProvider = paramProvider5;
  }
  
  public static MembersInjector<EmailConfirmationFragment> create(MembersInjector<LegoFragment> paramMembersInjector, Provider<FlagshipSharedPreferences> paramProvider, Provider<InputValidator> paramProvider1, Provider<InputValidationPresenter> paramProvider2, Provider<DelayedExecution> paramProvider3, Provider<EmailManagementController> paramProvider4, Provider<IntentRegistry> paramProvider5)
  {
    return new EmailConfirmationFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */