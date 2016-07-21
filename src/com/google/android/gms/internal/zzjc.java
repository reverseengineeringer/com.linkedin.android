package com.google.android.gms.internal;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public final class zzjc
{
  Activity zzMM;
  private boolean zzMN;
  boolean zzMO;
  boolean zzMP;
  private ViewTreeObserver.OnGlobalLayoutListener zzMQ;
  private ViewTreeObserver.OnScrollChangedListener zzMR;
  
  public zzjc(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    zzMM = paramActivity;
    zzMQ = paramOnGlobalLayoutListener;
    zzMR = null;
  }
  
  final void zzhG()
  {
    if (zzMM == null) {}
    while (zzMN) {
      return;
    }
    if (zzMQ != null)
    {
      zzr.zzbC();
      zzir.zza(zzMM, zzMQ);
    }
    if (zzMR != null)
    {
      zzr.zzbC();
      zzir.zza(zzMM, zzMR);
    }
    zzMN = true;
  }
  
  final void zzhH()
  {
    if (zzMM == null) {}
    while (!zzMN) {
      return;
    }
    if (zzMQ != null) {
      zzr.zzbE().zzb(zzMM, zzMQ);
    }
    if (zzMR != null)
    {
      zzr.zzbC();
      zzir.zzb(zzMM, zzMR);
    }
    zzMN = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */