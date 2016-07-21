package com.linkedin.android.liauthlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.liauthlib.common.LiSharedPrefUtils;
import com.linkedin.android.liauthlib.cookies.CookieMigrator;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.liauthlib.network.impl.HttpClientStack;
import com.linkedin.android.liauthlib.network.impl.HurlStack;
import java.util.List;

public class LiAuthProvider
{
  private static volatile LiAuth sharedInstance;
  
  public static LiAuth getInstance(Context paramContext)
  {
    return getInstance(paramContext, true);
  }
  
  public static LiAuth getInstance(Context paramContext, boolean paramBoolean)
  {
    if (sharedInstance == null) {}
    try
    {
      if (sharedInstance == null) {
        sharedInstance = new LiAuthImpl(paramContext, paramBoolean);
      }
      return sharedInstance;
    }
    finally {}
  }
  
  public static void migrateLegacyCookies(Context paramContext, CookieMigrator paramCookieMigrator)
  {
    Context localContext = paramContext.getApplicationContext();
    int i = LiSharedPrefUtils.getInt$607b6e67(localContext, "auth_SELECTED_NETWORK_LIB");
    if (i == -1) {
      return;
    }
    if (i == LiAuthProvider.LegacyNetworkLibraryType.HTTP_CLIENT.ordinal()) {}
    for (paramContext = new HttpClientStack(localContext);; paramContext = new HurlStack(localContext))
    {
      List localList = paramContext.getCookies();
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramCookieMigrator.migrate(localList);
        paramContext.clearAuthCookies();
      }
      paramContext = localContext.getSharedPreferences("auth_library_prefs", 0).edit().remove("auth_SELECTED_NETWORK_LIB");
      if (!LiSharedPrefUtils.atLeastGinerBread()) {
        break label129;
      }
      paramContext.apply();
      return;
      if (i != LiAuthProvider.LegacyNetworkLibraryType.HTTP_URL_CONNECTION.ordinal()) {
        break;
      }
    }
    label129:
    paramContext.commit();
  }
  
  public static boolean needsLegacyCookieMigration(Context paramContext)
  {
    return LiSharedPrefUtils.getInt$607b6e67(paramContext.getApplicationContext(), "auth_SELECTED_NETWORK_LIB") != -1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.LiAuthProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */