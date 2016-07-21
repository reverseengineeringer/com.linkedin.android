package com.linkedin.android.growth.takeover;

import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentIntent;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentIntentBundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;

public final class SmsReminderConsentTakeover
  extends TakeoverLauncher
{
  public SmsReminderConsentTakeover(Takeover paramTakeover)
  {
    super(paramTakeover);
  }
  
  public final void launch(BaseActivity paramBaseActivity, IntentRegistry paramIntentRegistry)
  {
    paramBaseActivity.startActivity(smsReminderConsent.newIntent(paramBaseActivity, new SmsReminderConsentIntentBundleBuilder().legoTrackingToken(takeover.legoTrackingToken)));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.SmsReminderConsentTakeover
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */