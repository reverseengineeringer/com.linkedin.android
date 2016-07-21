package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzkk$1
  extends zzkk.zzc<Status>
{
  zzkk$1(zzkk paramzzkk, GoogleApiClient paramGoogleApiClient, String paramString, UsageInfo[] paramArrayOfUsageInfo)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void zza(zzkf paramzzkf)
    throws RemoteException
  {
    paramzzkf.zza(new zzkk.zzd(this), zzUA, zzUB);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkk.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */