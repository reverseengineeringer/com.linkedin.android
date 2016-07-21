package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zza$zza<R extends Result, A extends Api.zzb>
  extends zzb<R>
  implements zza.zzb<R>, zzj.zze<A>
{
  final Api.zzc<A> zzaeE;
  private AtomicReference<zzj.zzd> zzagH = new AtomicReference();
  
  public zza$zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
  {
    super((GoogleApiClient)zzx.zzb(paramGoogleApiClient, "GoogleApiClient must not be null"));
    zzaeE = ((Api.zzc)zzx.zzz(paramzzc));
  }
  
  private void zza(RemoteException paramRemoteException)
  {
    zzw(new Status(8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  public abstract void zza(A paramA)
    throws RemoteException;
  
  public final void zza(zzj.zzd paramzzd)
  {
    zzagH.set(paramzzd);
  }
  
  public final void zzb(A paramA)
    throws DeadObjectException
  {
    try
    {
      zza(paramA);
      return;
    }
    catch (DeadObjectException paramA)
    {
      zza(paramA);
      throw paramA;
    }
    catch (RemoteException paramA)
    {
      zza(paramA);
    }
  }
  
  public final Api.zzc<A> zzoR()
  {
    return zzaeE;
  }
  
  public final void zzpe()
  {
    setResultCallback(null);
  }
  
  protected final void zzpf()
  {
    zzj.zzd localzzd = (zzj.zzd)zzagH.getAndSet(null);
    if (localzzd != null) {
      localzzd.zzc(this);
    }
  }
  
  public final void zzw(Status paramStatus)
  {
    if (!paramStatus.isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Failed result must not be success");
      zza(zzc(paramStatus));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */