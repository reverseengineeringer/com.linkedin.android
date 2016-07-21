package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public final class zzo
  extends zzj<zzm>
{
  public zzo(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 93, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected final String zzgu()
  {
    return "com.google.android.gms.measurement.START";
  }
  
  protected final String zzgv()
  {
    return "com.google.android.gms.measurement.internal.IMeasurementService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */