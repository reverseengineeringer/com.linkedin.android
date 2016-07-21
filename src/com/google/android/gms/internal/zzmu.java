package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;

public final class zzmu
{
  @TargetApi(20)
  public static boolean zzaw(Context paramContext)
  {
    return (zzne.zzcp(20)) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */