package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzj$zza
  extends Handler
{
  zzj$zza(zzj paramzzj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.w("GoogleApiClientImpl", "Unknown message id: " + what);
      return;
    case 1: 
      zzj.zzc(zzaid);
      return;
    }
    zzj.zzb(zzaid);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzj.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */