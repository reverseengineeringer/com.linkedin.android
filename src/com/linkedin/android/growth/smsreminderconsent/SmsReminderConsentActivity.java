package com.linkedin.android.growth.smsreminderconsent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.performance.CrashReporter;

public class SmsReminderConsentActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968943);
    activityComponent.inject(this);
    if (paramBundle == null)
    {
      paramBundle = SmsReminderConsentIntentBundleBuilder.getLegoTrackingToken(getIntent().getExtras());
      if (TextUtils.isEmpty(paramBundle))
      {
        CrashReporter.reportNonFatal(new IllegalStateException("SMS reminder consent cannot open because LegoTrackingToken is missing!"));
        finish();
      }
    }
    else
    {
      return;
    }
    paramBundle = new SmsReminderConsentIntentBundleBuilder().legoTrackingToken(paramBundle);
    getSupportFragmentManager().beginTransaction().add(16908290, fragmentRegistry.smsReminderConsent.newFragment(paramBundle)).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */