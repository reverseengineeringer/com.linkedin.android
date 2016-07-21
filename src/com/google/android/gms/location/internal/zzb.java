package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzb
  extends zzj<zzi>
{
  private final String zzaOs;
  protected final zzp<zzi> zzaOt = new zzp()
  {
    public final void zzqI()
    {
      zzb.zza(zzb.this);
    }
  };
  
  public zzb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    super(paramContext, paramLooper, 23, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzaOs = paramString;
  }
  
  protected final String zzgu()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected final String zzgv()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  protected final Bundle zzml()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", zzaOs);
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */