package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zziu;

@zzhb
final class zzd$zzb
  extends RelativeLayout
{
  zziu zzrU;
  
  public zzd$zzb(Context paramContext, String paramString)
  {
    super(paramContext);
    zzrU = new zziu(paramContext, paramString);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    zziu localzziu = zzrU;
    int j = paramMotionEvent.getHistorySize();
    int i = 0;
    while (i < j)
    {
      localzziu.zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i), paramMotionEvent.getHistoricalY(0, i));
      i += 1;
    }
    localzziu.zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */