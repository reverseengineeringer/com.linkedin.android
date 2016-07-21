package com.linkedin.android.l2m.notification;

import android.content.Intent;
import com.google.android.gms.iid.InstanceIDListenerService;
import com.linkedin.android.infra.performance.CrashReporter;

public class TokenRefreshListenerService
  extends InstanceIDListenerService
{
  public final void onTokenRefresh()
  {
    CrashReporter.logComponentInfo("Starting service " + TokenRefreshListenerService.class.getSimpleName(), null);
    startService(new Intent(this, RegistrationIntentService.class));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.TokenRefreshListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */