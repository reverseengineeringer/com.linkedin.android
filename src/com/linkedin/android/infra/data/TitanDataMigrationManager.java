package com.linkedin.android.infra.data;

import android.content.Context;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.logger.Log;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

public class TitanDataMigrationManager
{
  private static final Set<String> DEPRECATED_FILES;
  public static final Set<String> DEPRECATED_SHARED_PREFERENCES;
  public static final String TAG = TitanDataMigrationManager.class.getSimpleName();
  public final Auth auth;
  public final Context context;
  public final FlagshipSharedPreferences flagshipSharedPreferences;
  public final LixManager lixManager;
  
  static
  {
    DEPRECATED_FILES = new HashSet();
    DEPRECATED_SHARED_PREFERENCES = new HashSet();
    DEPRECATED_FILES.add("DEVICE_DATA");
    DEPRECATED_FILES.add("LiSnappyDBSharedPrefs");
    DEPRECATED_FILES.add("li_sdcard_abi_temp");
    DEPRECATED_SHARED_PREFERENCES.add("LinkedInPrefs.xml");
    DEPRECATED_SHARED_PREFERENCES.add("com.linkedin.android_preferences.xml");
    DEPRECATED_SHARED_PREFERENCES.add("com.linkedin.android.persistentCookieStore.xml");
    DEPRECATED_SHARED_PREFERENCES.add("LinkedInDebugPrefs.xml");
    DEPRECATED_SHARED_PREFERENCES.add("LinkedInWidgetPrefs.xml");
    DEPRECATED_SHARED_PREFERENCES.add("perfLibSp.xml");
    DEPRECATED_SHARED_PREFERENCES.add("WebViewChromiumPrefs.xml");
  }
  
  @Inject
  public TitanDataMigrationManager(Context paramContext, Auth paramAuth, FlagshipSharedPreferences paramFlagshipSharedPreferences, LixManager paramLixManager)
  {
    context = paramContext;
    auth = paramAuth;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    lixManager = paramLixManager;
  }
  
  public final void removeFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        removeFile(arrayOfFile[i]);
        i += 1;
      }
    }
    if (!paramFile.delete()) {
      Log.e(TAG, "Unable to delete " + paramFile.toString());
    }
  }
  
  public final void removeTitanData()
  {
    try
    {
      File[] arrayOfFile = context.getFilesDir().listFiles();
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (DEPRECATED_FILES.contains(localFile.getName())) {
          removeFile(localFile);
        }
        i += 1;
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e(TAG, "Could not delete files during migration", localNullPointerException);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.TitanDataMigrationManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */