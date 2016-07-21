package com.linkedin.android.infra.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.CrashReporter;
import java.util.concurrent.TimeUnit;

public class AppLaunchRateLimiter
{
  private static final String TAG = AppLaunchRateLimiter.class.getSimpleName();
  
  private static boolean isLastAppLaunchWithinRelaunchWindow(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      long l = Long.parseLong(paramString.substring(1));
      return paramLong2 - paramLong1 < l;
    }
    catch (Exception localException)
    {
      CrashReporter.reportNonFatal(new Throwable("Bad lix treatment: " + paramString, localException));
    }
    return false;
  }
  
  public static boolean shouldLimitAppLaunchNetworkCalls(LixManager paramLixManager, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    paramLixManager = paramLixManager.getTreatment(Lix.INFRA_APP_LAUNCH_RATE_LIMITER);
    Log.d(TAG, "shouldLimitAppLaunchNetworkCalls: " + paramLixManager);
    boolean bool = isLastAppLaunchWithinRelaunchWindow(paramLixManager, TimeUnit.MILLISECONDS.toSeconds(paramFlagshipSharedPreferences.getPreferences().getLong("appColdLaunchNetworkTime", 0L)), TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
    paramFlagshipSharedPreferences.getPreferences().edit().putLong("appColdLaunchNetworkTime", System.currentTimeMillis()).commit();
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.AppLaunchRateLimiter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */