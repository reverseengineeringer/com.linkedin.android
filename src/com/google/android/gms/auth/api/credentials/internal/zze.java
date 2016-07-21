package com.google.android.gms.auth.api.credentials.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza.zza;

abstract class zze<R extends Result>
  extends zza.zza<R, zzf>
{
  zze(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.zzVu, paramGoogleApiClient);
  }
  
  protected abstract void zza$48b76efb(zzj paramzzj)
    throws DeadObjectException, RemoteException;
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */