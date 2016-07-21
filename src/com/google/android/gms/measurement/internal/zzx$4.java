package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

final class zzx$4
  implements Runnable
{
  zzx$4(zzx paramzzx, AppMetadata paramAppMetadata, UserAttributeParcel paramUserAttributeParcel) {}
  
  public final void run()
  {
    zzaYy.zzfl(zzaYx.zzaVx);
    zzw localzzw = zzx.zza(zzaYy);
    UserAttributeParcel localUserAttributeParcel = zzaYB;
    AppMetadata localAppMetadata = zzaYx;
    localzzw.zzCn().zzjk();
    localzzw.zzjv();
    if (!TextUtils.isEmpty(zzaVt))
    {
      if (!zzaVy) {
        localzzw.zze(localAppMetadata);
      }
    }
    else {
      return;
    }
    zzAozzaWJ.zzj("Removing user property", name);
    localzzw.zzCj().beginTransaction();
    try
    {
      localzzw.zze(localAppMetadata);
      localzzw.zzCj().zzJ(packageName, name);
      localzzw.zzCj().setTransactionSuccessful();
      zzAozzaWJ.zzj("User property removed", name);
      return;
    }
    finally
    {
      localzzw.zzCj().endTransaction();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzx.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */