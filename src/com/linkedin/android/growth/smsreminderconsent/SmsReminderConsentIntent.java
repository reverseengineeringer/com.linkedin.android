package com.linkedin.android.growth.smsreminderconsent;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class SmsReminderConsentIntent
  extends IntentFactory<SmsReminderConsentIntentBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, SmsReminderConsentActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */