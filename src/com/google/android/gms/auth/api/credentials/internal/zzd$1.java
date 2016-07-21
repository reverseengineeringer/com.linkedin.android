package com.google.android.gms.auth.api.credentials.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzd$1
  extends zze<CredentialRequestResult>
{
  zzd$1(zzd paramzzd, GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void zza$48b76efb(zzj paramzzj)
    throws RemoteException
  {
    paramzzj.zza(new zza()
    {
      public final void zza(Status paramAnonymousStatus, Credential paramAnonymousCredential)
      {
        zza(new zzc(paramAnonymousStatus, paramAnonymousCredential));
      }
      
      public final void zzg(Status paramAnonymousStatus)
      {
        zza(zzc.zzh(paramAnonymousStatus));
      }
    }, zzWv);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzd.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */