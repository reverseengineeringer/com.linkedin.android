package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Status;

abstract interface zzj$zze<A extends Api.zzb>
{
  public abstract void cancel();
  
  public abstract boolean isReady();
  
  public abstract void zza(zzj.zzd paramzzd);
  
  public abstract void zzb(A paramA)
    throws DeadObjectException;
  
  public abstract Api.zzc<A> zzoR();
  
  public abstract Integer zzpa();
  
  public abstract void zzpe();
  
  public abstract void zzpg();
  
  public abstract void zzw(Status paramStatus);
  
  public abstract void zzx(Status paramStatus);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzj.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */