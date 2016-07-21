package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzac$5
  implements Runnable
{
  zzac$5(zzac paramzzac, UserAttributeParcel paramUserAttributeParcel) {}
  
  public final void run()
  {
    zzm localzzm = zzaYU.zzaYO;
    if (localzzm == null)
    {
      zzaYU.zzAo().zzaWC.zzfg("Discarding data. Failed to set user attribute");
      return;
    }
    try
    {
      localzzm.zza(zzaYB, zzaYU.zzCg().zzfe(zzaYU.zzAo().zzCL()));
      zzac.zzd(zzaYU);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaYU.zzAo().zzaWC.zzj("Failed to send attribute to AppMeasurementService", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzac.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */