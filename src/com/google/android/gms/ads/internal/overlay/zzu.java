package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import android.widget.FrameLayout;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzir;

@zzhb
public final class zzu
  implements Runnable
{
  public boolean mCancelled = false;
  private zzk zzFo;
  
  zzu(zzk paramzzk)
  {
    zzFo = paramzzk;
  }
  
  public final void run()
  {
    if (!mCancelled)
    {
      zzk localzzk = zzFo;
      if (zzEP != null)
      {
        long l = zzEP.getCurrentPosition();
        if ((zzET != l) && (l > 0L))
        {
          if (localzzk.zzfI()) {
            zzEN.removeView(zzES);
          }
          localzzk.zza("timeupdate", new String[] { "time", String.valueOf((float)l / 1000.0F) });
          zzET = l;
        }
      }
      zzfQ();
    }
  }
  
  public final void zzfQ()
  {
    zzir.zzMc.postDelayed(this, 250L);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */