package com.google.android.gms.measurement;

import android.os.Handler;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzp.zza;
import com.google.android.gms.measurement.internal.zzw;

final class AppMeasurementService$1
  implements Runnable
{
  AppMeasurementService$1(AppMeasurementService paramAppMeasurementService, zzw paramzzw, int paramInt, zzp paramzzp) {}
  
  public final void run()
  {
    zzaTW.zzDc();
    AppMeasurementService.zza(zzaTY).post(new Runnable()
    {
      public final void run()
      {
        if (zzaTY.stopSelfResult(zzOP))
        {
          if (zzd.zzkr()) {
            zzaTX.zzaWK.zzfg("Device AppMeasurementService processed last upload request");
          }
        }
        else {
          return;
        }
        zzaTX.zzaWK.zzfg("Local AppMeasurementService processed last upload request");
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */