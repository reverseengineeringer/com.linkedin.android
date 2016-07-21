package com.linkedin.android.logger;

import java.util.HashSet;
import java.util.Set;

public final class FeatureLog
{
  private static final Set<String> ENABLED_FEATURES = new HashSet();
  static final Set<String> FEATURES = new HashSet();
  
  static boolean canLogFeature(String paramString)
  {
    return ENABLED_FEATURES.contains(paramString);
  }
  
  public static int d(String paramString1, String paramString2)
  {
    if (canLogFeature(paramString2)) {
      return Log.d(paramString1);
    }
    return 0;
  }
  
  public static int d(String paramString1, String paramString2, String paramString3)
  {
    if (canLogFeature(paramString3)) {
      return Log.d(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable, String paramString3)
  {
    if (canLogFeature(paramString3)) {
      return Log.d(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public static void enableFeatureLogging(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      ENABLED_FEATURES.add(paramString);
      return;
    }
    ENABLED_FEATURES.remove(paramString);
  }
  
  public static int i(String paramString1, String paramString2)
  {
    if (canLogFeature(paramString2)) {
      return Log.i(paramString1);
    }
    return 0;
  }
  
  public static int i(String paramString1, String paramString2, String paramString3)
  {
    if (canLogFeature(paramString3)) {
      return Log.i(paramString1, paramString2);
    }
    return 0;
  }
  
  public static void registerFeature(String paramString)
  {
    FEATURES.add(paramString);
  }
  
  public static int v(String paramString1, String paramString2, String paramString3)
  {
    if (canLogFeature(paramString3)) {
      return Log.v(paramString1, paramString2);
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.logger.FeatureLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */