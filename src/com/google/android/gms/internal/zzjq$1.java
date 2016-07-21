package com.google.android.gms.internal;

import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.overlay.zzd;

final class zzjq$1
  implements Runnable
{
  zzjq$1(zzjq paramzzjq) {}
  
  public final void run()
  {
    zzNL.zzpD.zzid();
    zzd localzzd = zzNL.zzpD.zzhS();
    if (localzzd != null)
    {
      zzDm.removeView(zzEj);
      localzzd.zzw(true);
    }
    if (zzjq.zzd(zzNL) != null)
    {
      zzjq.zzd(zzNL);
      zzjq.zza$7a7499f(zzNL);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjq.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */