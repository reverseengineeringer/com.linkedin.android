package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzp.zza;
import com.google.android.gms.measurement.internal.zzw;

public final class AppMeasurementReceiver
  extends BroadcastReceiver
{
  static zzrp zzOM;
  static Boolean zzON;
  static final Object zzqy = new Object();
  
  public static boolean zzY(Context paramContext)
  {
    zzx.zzz(paramContext);
    if (zzON != null) {
      return zzON.booleanValue();
    }
    boolean bool = zzaj.zza$6aa51a6e(paramContext, AppMeasurementReceiver.class);
    zzON = Boolean.valueOf(bool);
    return bool;
  }
  
  public final void onReceive(Context paramContext, Intent arg2)
  {
    localzzp = zzw.zzaT(paramContext).zzAo();
    ??? = ???.getAction();
    if (zzd.zzkr()) {
      zzaWK.zzj("Device AppMeasurementReceiver got", ???);
    }
    for (;;)
    {
      boolean bool;
      Object localObject1;
      if ("com.google.android.gms.measurement.UPLOAD".equals(???))
      {
        bool = AppMeasurementService.zzZ(paramContext);
        localObject1 = new Intent(paramContext, AppMeasurementService.class);
        ((Intent)localObject1).setAction("com.google.android.gms.measurement.UPLOAD");
      }
      int i;
      synchronized (zzqy)
      {
        paramContext.startService((Intent)localObject1);
        if (!bool)
        {
          return;
          zzaWK.zzj("Local AppMeasurementReceiver got", ???);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */