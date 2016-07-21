package com.google.android.gms.auth.api.credentials.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzx;

public final class zzd
  implements CredentialsApi
{
  public final PendingResult<Status> disableAutoSignIn(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zze(paramGoogleApiClient)
    {
      protected final void zza$48b76efb(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zza(new zzd.zza(this));
      }
    });
  }
  
  public final PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest)
  {
    zzx.zzb(paramGoogleApiClient, "client must not be null");
    zzx.zzb(paramHintRequest, "request must not be null");
    zzx.zzb(paramGoogleApiClient.zza(Auth.CREDENTIALS_API), "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
    paramGoogleApiClient.getContext();
    Object localObject = zzazzVuzzWA;
    if ((localObject != null) && (zzVM != null)) {}
    for (localObject = zzVM;; localObject = PasswordSpecification.zzWl)
    {
      paramHintRequest = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.HintRequest", paramHintRequest).putExtra("com.google.android.gms.credentials.PasswordSpecification", (Parcelable)localObject);
      return PendingIntent.getActivity(paramGoogleApiClient.getContext(), 2000, paramHintRequest, 268435456);
    }
  }
  
  public final PendingResult<CredentialRequestResult> request(GoogleApiClient paramGoogleApiClient, final CredentialRequest paramCredentialRequest)
  {
    paramGoogleApiClient.zza(new zze(paramGoogleApiClient)
    {
      protected final void zza$48b76efb(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zza(new zza()
        {
          public final void zza(Status paramAnonymous2Status, Credential paramAnonymous2Credential)
          {
            zza(new zzc(paramAnonymous2Status, paramAnonymous2Credential));
          }
          
          public final void zzg(Status paramAnonymous2Status)
          {
            zza(zzc.zzh(paramAnonymous2Status));
          }
        }, paramCredentialRequest);
      }
    });
  }
  
  public final PendingResult<Status> save(GoogleApiClient paramGoogleApiClient, final Credential paramCredential)
  {
    paramGoogleApiClient.zzb(new zze(paramGoogleApiClient)
    {
      protected final void zza$48b76efb(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zza(new zzd.zza(this), new SaveRequest(paramCredential));
      }
    });
  }
  
  private static final class zza
    extends zza
  {
    private zza.zzb<Status> zzWz;
    
    zza(zza.zzb<Status> paramzzb)
    {
      zzWz = paramzzb;
    }
    
    public final void zzg(Status paramStatus)
    {
      zzWz.zzs(paramStatus);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */