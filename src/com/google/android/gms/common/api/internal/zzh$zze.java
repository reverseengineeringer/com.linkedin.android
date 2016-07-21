package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzrn;

final class zzh$zze
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private zzh$zze(zzh paramzzh) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    zzahC.zzahs.zza(new zzh.zzd(zzahC));
  }
  
  /* Error */
  public final void onConnectionFailed(com.google.android.gms.common.ConnectionResult paramConnectionResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
    //   4: getfield 45	com/google/android/gms/common/api/internal/zzh:zzXG	Ljava/util/concurrent/locks/Lock;
    //   7: invokeinterface 50 1 0
    //   12: aload_0
    //   13: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
    //   16: aload_1
    //   17: invokevirtual 54	com/google/android/gms/common/api/internal/zzh:zzf	(Lcom/google/android/gms/common/ConnectionResult;)Z
    //   20: ifeq +30 -> 50
    //   23: aload_0
    //   24: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
    //   27: invokevirtual 57	com/google/android/gms/common/api/internal/zzh:zzpy	()V
    //   30: aload_0
    //   31: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
    //   34: invokevirtual 60	com/google/android/gms/common/api/internal/zzh:zzpv	()V
    //   37: aload_0
    //   38: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
    //   41: getfield 45	com/google/android/gms/common/api/internal/zzh:zzXG	Ljava/util/concurrent/locks/Lock;
    //   44: invokeinterface 63 1 0
    //   49: return
    //   50: aload_0
    //   51: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
    //   54: aload_1
    //   55: invokevirtual 66	com/google/android/gms/common/api/internal/zzh:zzg	(Lcom/google/android/gms/common/ConnectionResult;)V
    //   58: goto -21 -> 37
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
    //   66: getfield 45	com/google/android/gms/common/api/internal/zzh:zzXG	Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 63 1 0
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	zze
    //   0	76	1	paramConnectionResult	com.google.android.gms.common.ConnectionResult
    // Exception table:
    //   from	to	target	type
    //   12	37	61	finally
    //   50	58	61	finally
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzh.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */