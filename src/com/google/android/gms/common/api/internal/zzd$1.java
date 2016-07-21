package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class zzd$1
  implements zzp.zza
{
  zzd$1(zzd paramzzd) {}
  
  public final void zzc(int paramInt, boolean paramBoolean)
  {
    zzahh.zzXG.lock();
    try
    {
      if ((zzahh.zzahf) || (zzahh.zzahe == null) || (!zzahh.zzahe.isSuccess()))
      {
        zzahh.zzahf = false;
        zzd.zza(zzahh, paramInt, paramBoolean);
        return;
      }
      zzahh.zzahf = true;
      zzahh.zzagY.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzahh.zzXG.unlock();
    }
  }
  
  public final void zzd(ConnectionResult paramConnectionResult)
  {
    zzahh.zzXG.lock();
    try
    {
      zzahh.zzahd = paramConnectionResult;
      zzd.zzb(zzahh);
      return;
    }
    finally
    {
      zzahh.zzXG.unlock();
    }
  }
  
  /* Error */
  public final void zzi(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
    //   4: getfield 26	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   7: invokeinterface 31 1 0
    //   12: aload_0
    //   13: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
    //   16: astore_2
    //   17: aload_2
    //   18: getfield 76	com/google/android/gms/common/api/internal/zzd:zzahc	Landroid/os/Bundle;
    //   21: ifnonnull +38 -> 59
    //   24: aload_2
    //   25: aload_1
    //   26: putfield 76	com/google/android/gms/common/api/internal/zzd:zzahc	Landroid/os/Bundle;
    //   29: aload_0
    //   30: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
    //   33: getstatic 79	com/google/android/gms/common/ConnectionResult:zzafB	Lcom/google/android/gms/common/ConnectionResult;
    //   36: putfield 67	com/google/android/gms/common/api/internal/zzd:zzahd	Lcom/google/android/gms/common/ConnectionResult;
    //   39: aload_0
    //   40: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
    //   43: invokestatic 70	com/google/android/gms/common/api/internal/zzd:zzb	(Lcom/google/android/gms/common/api/internal/zzd;)V
    //   46: aload_0
    //   47: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
    //   50: getfield 26	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 52 1 0
    //   58: return
    //   59: aload_1
    //   60: ifnull -31 -> 29
    //   63: aload_2
    //   64: getfield 76	com/google/android/gms/common/api/internal/zzd:zzahc	Landroid/os/Bundle;
    //   67: aload_1
    //   68: invokevirtual 84	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   71: goto -42 -> 29
    //   74: astore_1
    //   75: aload_0
    //   76: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
    //   79: getfield 26	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 52 1 0
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	1
    //   0	89	1	paramBundle	android.os.Bundle
    //   16	48	2	localzzd	zzd
    // Exception table:
    //   from	to	target	type
    //   12	29	74	finally
    //   29	46	74	finally
    //   63	71	74	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzd.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */