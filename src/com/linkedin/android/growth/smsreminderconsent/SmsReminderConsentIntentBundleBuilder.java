package com.linkedin.android.growth.smsreminderconsent;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class SmsReminderConsentIntentBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public static String getLegoTrackingToken(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("legoTrackingToken");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final SmsReminderConsentIntentBundleBuilder legoTrackingToken(String paramString)
  {
    bundle.putString("legoTrackingToken", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentIntentBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */