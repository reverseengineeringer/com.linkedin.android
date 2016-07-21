package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

final class zzi
{
  final String mName;
  final String zzaUa;
  final long zzaVP;
  final long zzaVQ;
  final long zzaVR;
  
  zzi(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    zzx.zzcM(paramString1);
    zzx.zzcM(paramString2);
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      zzx.zzac(bool1);
      if (paramLong2 < 0L) {
        break label81;
      }
    }
    label81:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzac(bool1);
      zzaUa = paramString1;
      mName = paramString2;
      zzaVP = paramLong1;
      zzaVQ = paramLong2;
      zzaVR = paramLong3;
      return;
      bool1 = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */