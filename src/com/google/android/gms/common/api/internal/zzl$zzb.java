package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzl$zzb
  extends Handler
{
  zzl$zzb(zzl paramzzl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.w("GACStateManager", "Unknown message id: " + what);
      return;
    case 1: 
      ((zzl.zza)obj).zzd(zzaiu);
      return;
    }
    throw ((RuntimeException)obj);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzl.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */