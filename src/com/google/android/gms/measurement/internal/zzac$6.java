package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzac$6
  implements Runnable
{
  zzac$6(zzac paramzzac) {}
  
  public final void run()
  {
    zzm localzzm = zzaYU.zzaYO;
    if (localzzm == null)
    {
      zzaYU.zzAo().zzaWC.zzfg("Discarding data. Failed to send app launch");
      return;
    }
    try
    {
      localzzm.zza(zzaYU.zzCg().zzfe(zzaYU.zzAo().zzCL()));
      zzac.zzd(zzaYU);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaYU.zzAo().zzaWC.zzj("Failed to send app launch to AppMeasurementService", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzac.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */