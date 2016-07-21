package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appdatasearch.zza;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza.zza;

abstract class zzkk$zzb<T extends Result>
  extends zza.zza<T, zzki>
{
  public zzkk$zzb(GoogleApiClient paramGoogleApiClient)
  {
    super(zza.zzTy, paramGoogleApiClient);
  }
  
  protected abstract void zza(zzkf paramzzkf)
    throws RemoteException;
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkk.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */