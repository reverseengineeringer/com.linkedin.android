package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;

public final class zzj$zzf
  implements GoogleApiClient.zza
{
  public zzj$zzf(zzj paramzzj) {}
  
  public final void zza(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess()) {
      zzalL.zza(null, zzj.zze(zzalL));
    }
    while (zzj.zzf(zzalL) == null) {
      return;
    }
    zzj.zzf(zzalL).onConnectionFailed(paramConnectionResult);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */