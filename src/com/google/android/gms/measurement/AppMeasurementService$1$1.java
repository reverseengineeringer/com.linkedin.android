package com.google.android.gms.measurement;

import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzp.zza;

final class AppMeasurementService$1$1
  implements Runnable
{
  AppMeasurementService$1$1(AppMeasurementService.1 param1) {}
  
  public final void run()
  {
    if (zzaTZ.zzaTY.stopSelfResult(zzaTZ.zzOP))
    {
      if (zzd.zzkr()) {
        zzaTZ.zzaTX.zzaWK.zzfg("Device AppMeasurementService processed last upload request");
      }
    }
    else {
      return;
    }
    zzaTZ.zzaTX.zzaWK.zzfg("Local AppMeasurementService processed last upload request");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementService.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */