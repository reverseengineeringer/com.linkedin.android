package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;

public final class zzmh
  implements zzmg
{
  public final PendingResult<Status> zzf(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzmi.zza(paramGoogleApiClient) {});
  }
  
  private static final class zza
    extends zzme
  {
    private final zza.zzb<Status> zzamC;
    
    public zza(zza.zzb<Status> paramzzb)
    {
      zzamC = paramzzb;
    }
    
    public final void zzcb(int paramInt)
      throws RemoteException
    {
      zzamC.zzs(new Status(paramInt));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */