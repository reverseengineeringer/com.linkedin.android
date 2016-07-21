package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public final class zzac
{
  public static zzl zza$575a9856(Context paramContext)
  {
    File localFile = new File(paramContext.getCacheDir(), "volley");
    String str1 = "volley/0";
    try
    {
      String str2 = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str2, 0);
      paramContext = str2 + "/" + versionCode;
      if (Build.VERSION.SDK_INT >= 9) {}
      for (paramContext = new zzz();; paramContext = new zzw(AndroidHttpClient.newInstance(paramContext)))
      {
        paramContext = new zzt(paramContext);
        paramContext = new zzl(new zzv(localFile, (byte)0), paramContext, (byte)0);
        paramContext.start();
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */