package com.linkedin.android.growth.onboarding.email_confirmation;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class EmailConfirmationLoadingFragmentFactory
  extends FragmentFactory<EmailConfirmationBundle>
{
  protected final Fragment provideFragment()
  {
    return new EmailConfirmationLoadingFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */