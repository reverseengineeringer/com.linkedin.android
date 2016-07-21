package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzac$4
  implements Runnable
{
  zzac$4(zzac paramzzac, String paramString, EventParcel paramEventParcel) {}
  
  public final void run()
  {
    zzm localzzm = zzaYU.zzaYO;
    if (localzzm == null)
    {
      zzaYU.zzAo().zzaWC.zzfg("Discarding data. Failed to send event to service");
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(zzaHU))
        {
          localzzm.zza(zzaYz, zzaYU.zzCg().zzfe(zzaYU.zzAo().zzCL()));
          zzac.zzd(zzaYU);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        zzaYU.zzAo().zzaWC.zzj("Failed to send event to AppMeasurementService", localRemoteException);
        return;
      }
      localRemoteException.zza(zzaYz, zzaHU, zzaYU.zzAo().zzCL());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzac.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */