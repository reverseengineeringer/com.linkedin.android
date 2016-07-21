package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public final class zzf
  extends com.google.android.gms.common.internal.zzj<zzj>
{
  final Auth.AuthCredentialsOptions zzWA;
  
  public zzf(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 68, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzWA = paramAuthCredentialsOptions;
  }
  
  protected final String zzgu()
  {
    return "com.google.android.gms.auth.api.credentials.service.START";
  }
  
  protected final String zzgv()
  {
    return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
  }
  
  protected final Bundle zzml()
  {
    if (zzWA == null) {
      return new Bundle();
    }
    Auth.AuthCredentialsOptions localAuthCredentialsOptions = zzWA;
    Bundle localBundle = new Bundle();
    localBundle.putString("consumer_package", zzVL);
    localBundle.putParcelable("password_specification", zzVM);
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */