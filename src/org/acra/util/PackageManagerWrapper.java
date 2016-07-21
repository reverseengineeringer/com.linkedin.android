package org.acra.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import org.acra.ACRA;
import org.acra.log.ACRALog;

public final class PackageManagerWrapper
{
  private final Context context;
  
  public PackageManagerWrapper(Context paramContext)
  {
    context = paramContext;
  }
  
  public final PackageInfo getPackageInfo()
  {
    Object localObject = context.getPackageManager();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(context.getPackageName(), 0);
      return (PackageInfo)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ACRA.log.v(ACRA.LOG_TAG, "Failed to find PackageInfo for current App : " + context.getPackageName());
      return null;
    }
    catch (RuntimeException localRuntimeException) {}
    return null;
  }
  
  public final boolean hasPermission(String paramString)
  {
    PackageManager localPackageManager = context.getPackageManager();
    if (localPackageManager == null) {}
    for (;;)
    {
      return false;
      try
      {
        int i = localPackageManager.checkPermission(paramString, context.getPackageName());
        if (i == 0) {
          return true;
        }
      }
      catch (RuntimeException paramString) {}
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     org.acra.util.PackageManagerWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */