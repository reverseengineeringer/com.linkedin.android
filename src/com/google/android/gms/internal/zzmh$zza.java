package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;

final class zzmh$zza
  extends zzme
{
  private final zza.zzb<Status> zzamC;
  
  public zzmh$zza(zza.zzb<Status> paramzzb)
  {
    zzamC = paramzzb;
  }
  
  public final void zzcb(int paramInt)
    throws RemoteException
  {
    zzamC.zzs(new Status(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmh.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */