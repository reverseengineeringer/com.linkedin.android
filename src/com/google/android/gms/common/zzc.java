package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzn;

public class zzc
{
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final zzc zzafF = new zzc();
  
  public static void zzak(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    zze.zzad(paramContext);
  }
  
  public static void zzal(Context paramContext)
  {
    zze.zzal(paramContext);
  }
  
  public static boolean zzi(Context paramContext, String paramString)
  {
    return zze.zzi(paramContext, paramString);
  }
  
  private static String zzj(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append("-");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getPackageName());
    }
    localStringBuilder.append("-");
    if (paramContext != null) {}
    try
    {
      localStringBuilder.append(getPackageManagergetPackageInfogetPackageName0versionCode);
      return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static zzc zzoK()
  {
    return zzafF;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return zza(paramContext, paramInt1, paramInt2, null);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    int j = zze.isGooglePlayServicesAvailable(paramContext);
    int i = j;
    if (zze.zzd(paramContext, j)) {
      i = 18;
    }
    return i;
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    return zze.isUserRecoverableError(paramInt);
  }
  
  public PendingIntent zza(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    paramString = zza(paramContext, paramInt1, paramString);
    if (paramString == null) {
      return null;
    }
    return PendingIntent.getActivity(paramContext, paramInt2, paramString, 268435456);
  }
  
  public Intent zza(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return zzn.zzx("com.google.android.gms", zzj(paramContext, paramString));
    case 42: 
      return zzn.zzqU();
    }
    return zzn.zzcJ("com.google.android.gms");
  }
  
  @Deprecated
  public Intent zzbu(int paramInt)
  {
    return zza(null, paramInt, null);
  }
  
  public boolean zzd(Context paramContext, int paramInt)
  {
    return zze.zzd(paramContext, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */