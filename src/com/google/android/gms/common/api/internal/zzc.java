package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;

public final class zzc
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> zzagT;
  private final int zzagU;
  zzl zzagV;
  
  public zzc(Api<?> paramApi, int paramInt)
  {
    zzagT = paramApi;
    zzagU = paramInt;
  }
  
  private void zzpi()
  {
    zzx.zzb(zzagV, "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    zzpi();
    zzl localzzl = zzagV;
    zzXG.lock();
    try
    {
      zzaip.onConnected(paramBundle);
      return;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzpi();
    zzl localzzl = zzagV;
    Api localApi = zzagT;
    int i = zzagU;
    zzXG.lock();
    try
    {
      zzaip.zza(paramConnectionResult, localApi, i);
      return;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzpi();
    zzagV.onConnectionSuspended(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */