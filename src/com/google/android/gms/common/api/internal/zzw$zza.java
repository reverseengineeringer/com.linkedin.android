package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public final class zzw$zza
  implements GoogleApiClient.OnConnectionFailedListener
{
  public final int zzaiF;
  public final GoogleApiClient zzaiG;
  public final GoogleApiClient.OnConnectionFailedListener zzaiH;
  
  public zzw$zza(zzw paramzzw, int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaiF = paramInt;
    zzaiG = paramGoogleApiClient;
    zzaiH = paramOnConnectionFailedListener;
    paramGoogleApiClient.registerConnectionFailedListener(this);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzw.zzc(zzaiI).post(new zzw.zzb(zzaiI, zzaiF, paramConnectionResult));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzw.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */