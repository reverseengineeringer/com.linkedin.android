package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.internal.zzx;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class zzh$zza
  implements GoogleApiClient.zza
{
  private final Api<?> zzagT;
  private final int zzagU;
  private final WeakReference<zzh> zzahD;
  
  public zzh$zza(zzh paramzzh, Api<?> paramApi, int paramInt)
  {
    zzahD = new WeakReference(paramzzh);
    zzagT = paramApi;
    zzagU = paramInt;
  }
  
  public final void zza(ConnectionResult paramConnectionResult)
  {
    boolean bool = false;
    zzh localzzh = (zzh)zzahD.get();
    if (localzzh == null) {
      return;
    }
    if (Looper.myLooper() == zzahj.zzagW.zzagr) {
      bool = true;
    }
    zzx.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zzXG.lock();
    try
    {
      bool = localzzh.zzbz(0);
      if (!bool) {
        return;
      }
      if (!paramConnectionResult.isSuccess()) {
        localzzh.zzb(paramConnectionResult, zzagT, zzagU);
      }
      if (localzzh.zzpu()) {
        localzzh.zzpv();
      }
      return;
    }
    finally
    {
      zzXG.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzh.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */