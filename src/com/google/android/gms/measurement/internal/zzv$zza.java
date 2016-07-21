package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzv$zza<V>
  extends FutureTask<V>
{
  private final String zzaXR;
  
  zzv$zza(zzv paramzzv, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, null);
    zzx.zzz(paramString);
    zzaXR = paramString;
  }
  
  zzv$zza(Callable<V> paramCallable, String paramString)
  {
    super(paramString);
    Object localObject;
    zzx.zzz(localObject);
    zzaXR = ((String)localObject);
  }
  
  protected final void setException(Throwable paramThrowable)
  {
    zzaXS.zzAo().zzaWC.zzj(zzaXR, paramThrowable);
    super.setException(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzv.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */