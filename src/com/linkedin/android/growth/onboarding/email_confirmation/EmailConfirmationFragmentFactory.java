package com.linkedin.android.growth.onboarding.email_confirmation;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class EmailConfirmationFragmentFactory
  extends FragmentFactory<EmailConfirmationBundle>
{
  protected final Fragment provideFragment()
  {
    return new EmailConfirmationFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */