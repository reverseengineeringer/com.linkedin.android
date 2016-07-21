package com.linkedin.android.liauthlib.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public final class LiSharedPrefUtils
{
  public static boolean atLeastGinerBread()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static int getInt$607b6e67(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("auth_library_prefs", 0).getInt(paramString, -1);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("auth_library_prefs", 0).getString(paramString1, paramString2);
  }
  
  public static void putString(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("auth_library_prefs", 0).edit().putString(paramString1, paramString2);
    if (atLeastGinerBread())
    {
      paramContext.apply();
      return;
    }
    paramContext.commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.common.LiSharedPrefUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */