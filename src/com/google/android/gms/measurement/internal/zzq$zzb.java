package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

final class zzq$zzb
  implements Runnable
{
  private final int zzBc;
  private final String zzTJ;
  private final zzq.zza zzaWP;
  private final Throwable zzaWQ;
  private final byte[] zzaWR;
  
  private zzq$zzb(String paramString, zzq.zza paramzza, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    zzx.zzz(paramzza);
    zzaWP = paramzza;
    zzBc = paramInt;
    zzaWQ = paramThrowable;
    zzaWR = paramArrayOfByte;
    zzTJ = paramString;
  }
  
  public final void run()
  {
    zzaWP.zza(zzTJ, zzBc, zzaWQ, zzaWR);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzq.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */