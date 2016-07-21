package com.linkedin.android.infra.performance;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.perftimer.RUMTiming;
import java.util.Locale;

public final class RUMHelper
{
  private static final String CUSTOM_PAGE_KEY_FORMAT = "p_flagship3".concat("_%s");
  private static final String TAG = RUMHelper.class.getSimpleName();
  private static Context appContext;
  private static Handler handler;
  
  public static void callRenderEndOnNextLoop(String paramString, boolean paramBoolean)
  {
    if (handler == null) {
      handler = new Handler(Looper.getMainLooper());
    }
    paramString = new RUMHelper.1(paramString, paramBoolean);
    handler.post(paramString);
  }
  
  private static void log(String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.US, "%s\nsessionId:%s\ntime:%d", new Object[] { paramString1, paramString2, Long.valueOf(SystemClock.elapsedRealtime()) });
    FeatureLog.d(TAG, paramString1, "Rum");
  }
  
  public static String pageInit(TrackableFragment paramTrackableFragment)
  {
    return pageInit(paramTrackableFragment.pageKey());
  }
  
  public static String pageInit(String paramString)
  {
    paramString = String.format(Locale.US, CUSTOM_PAGE_KEY_FORMAT, new Object[] { paramString });
    String str = RUMTiming.initialize(appContext, paramString);
    log("page init for page key: " + paramString, str);
    return str;
  }
  
  @Deprecated
  public static String pageInit$46894ca9(String paramString)
  {
    return pageInit(paramString);
  }
  
  public static String pageInitLoadMore(TrackableFragment paramTrackableFragment)
  {
    return pageInit(paramTrackableFragment.loadMorePageKey());
  }
  
  public static String pageInitRefresh(TrackableFragment paramTrackableFragment)
  {
    return pageInit(paramTrackableFragment.refreshPageKey());
  }
  
  public static void setAppContext(Context paramContext)
  {
    appContext = paramContext;
  }
  
  public static void setColdLaunchThreshold(LixManager paramLixManager)
  {
    paramLixManager = paramLixManager.getTreatment(Lix.COLD_START_THRESHOLD);
    if ("control".equalsIgnoreCase(paramLixManager))
    {
      RUMTiming.setColdLaunchThreshold(500L);
      Log.i(TAG, "RUM cold launch threshold set to control value of 500");
      return;
    }
    if ((paramLixManager.length() > 2) && (paramLixManager.indexOf("t-") == 0)) {
      try
      {
        long l = Long.parseLong(paramLixManager.substring(2));
        RUMTiming.setColdLaunchThreshold(l);
        Log.i(TAG, "RUM cold launch threshold set to " + l);
        return;
      }
      catch (NumberFormatException paramLixManager)
      {
        Log.w(TAG, "RUM cold launch lix format is not valid, defaulting to 500");
        RUMTiming.setColdLaunchThreshold(500L);
        return;
      }
    }
    Log.w(TAG, "RUM cold launch lix format is not valid, defaulting to 500");
    RUMTiming.setColdLaunchThreshold(500L);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.performance.RUMHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */