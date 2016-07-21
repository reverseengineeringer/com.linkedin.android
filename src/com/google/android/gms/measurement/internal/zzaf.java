package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;

final class zzaf
{
  long zzCv;
  final zzmq zzqW;
  
  public zzaf(zzmq paramzzmq)
  {
    zzx.zzz(paramzzmq);
    zzqW = paramzzmq;
  }
  
  public final void start()
  {
    zzCv = zzqW.elapsedRealtime();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */