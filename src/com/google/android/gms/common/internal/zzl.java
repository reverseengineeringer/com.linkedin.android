package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl
{
  private static final Object zzalX = new Object();
  private static zzl zzalY;
  
  public static zzl zzau(Context paramContext)
  {
    synchronized (zzalX)
    {
      if (zzalY == null) {
        zzalY = new zzm(paramContext.getApplicationContext());
      }
      return zzalY;
    }
  }
  
  public abstract boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract boolean zza(String paramString1, ServiceConnection paramServiceConnection, String paramString2);
  
  public abstract void zzb$5fe800ef(String paramString, ServiceConnection paramServiceConnection);
  
  public abstract void zzb$9b3168c(ComponentName paramComponentName, ServiceConnection paramServiceConnection);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */