package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Window;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzis;

@zzhb
final class zzd$zzd
  extends zzim
{
  private zzd$zzd(zzd paramzzd) {}
  
  public final void zzbr()
  {
    zzr.zzbC();
    final Object localObject = zzir.zzf(zzd.zza(zzEv), zzEv.zzEh.zzEM.zzqn);
    if (localObject != null)
    {
      localObject = zzr.zzbE().zza(zzd.zza(zzEv), (Bitmap)localObject, zzEv.zzEh.zzEM.zzqo, zzEv.zzEh.zzEM.zzqp);
      zzir.zzMc.post(new Runnable()
      {
        public final void run()
        {
          zzd.zza(zzEv).getWindow().setBackgroundDrawable(localObject);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */