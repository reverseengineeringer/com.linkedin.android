package com.linkedin.android.growth.smsreminderconsent;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class SmsReminderConsentFragmentFactory
  extends FragmentFactory<SmsReminderConsentIntentBundleBuilder>
{
  protected final Fragment provideFragment()
  {
    return new SmsReminderConsentFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */