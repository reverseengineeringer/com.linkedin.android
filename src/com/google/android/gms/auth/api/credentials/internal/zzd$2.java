package com.google.android.gms.auth.api.credentials.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzd$2
  extends zze<Status>
{
  zzd$2(zzd paramzzd, GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void zza$48b76efb(zzj paramzzj)
    throws RemoteException
  {
    paramzzj.zza(new zzd.zza(this), new SaveRequest(zzWy));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzd.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */