package com.linkedin.android.l2m.notification;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.gcm.GcmReceiver;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;

public class FlagshipGcmReceiver
  extends GcmReceiver
{
  private static final String TAG = FlagshipGcmReceiver.class.getSimpleName();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    CrashReporter.logComponentInfo("Starting broadcast receiver " + FlagshipGcmReceiver.class.getSimpleName(), paramIntent);
    try
    {
      super.onReceive(paramContext, paramIntent);
      return;
    }
    catch (SecurityException paramContext)
    {
      Log.e(TAG, "Failure in starting GcmReceiver : %s", paramContext);
      CrashReporter.reportNonFatal(paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.FlagshipGcmReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */