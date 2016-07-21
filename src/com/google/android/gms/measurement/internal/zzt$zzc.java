package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import java.security.SecureRandom;

public final class zzt$zzc
{
  final long zzTl;
  final String zzaXC;
  final String zzaXD;
  final String zzaXE;
  
  private zzt$zzc(zzt paramzzt, String paramString, long paramLong)
  {
    zzx.zzcM(paramString);
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzac(bool);
      zzaXC = (paramString + ":start");
      zzaXD = (paramString + ":count");
      zzaXE = (paramString + ":value");
      zzTl = paramLong;
      return;
    }
  }
  
  public final void zzf(String paramString, long paramLong)
  {
    zzaXA.zzjk();
    if (zzlO() == 0L) {
      zzlL();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    long l = zzt.zza(zzaXA).getLong(zzaXD, 0L);
    if (l <= 0L)
    {
      paramString = zzt.zza(zzaXA).edit();
      paramString.putString(zzaXE, str);
      paramString.putLong(zzaXD, paramLong);
      paramString.apply();
      return;
    }
    if ((zzt.zzb(zzaXA).nextLong() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + paramLong) * paramLong) {}
    for (int i = 1;; i = 0)
    {
      paramString = zzt.zza(zzaXA).edit();
      if (i != 0) {
        paramString.putString(zzaXE, str);
      }
      paramString.putLong(zzaXD, l + paramLong);
      paramString.apply();
      return;
    }
  }
  
  final void zzlL()
  {
    zzaXA.zzjk();
    long l = zzaXA.zzjl().currentTimeMillis();
    SharedPreferences.Editor localEditor = zzt.zza(zzaXA).edit();
    localEditor.remove(zzaXD);
    localEditor.remove(zzaXE);
    localEditor.putLong(zzaXC, l);
    localEditor.apply();
  }
  
  final long zzlO()
  {
    return zzt.zzc(zzaXA).getLong(zzaXC, 0L);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzt.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */