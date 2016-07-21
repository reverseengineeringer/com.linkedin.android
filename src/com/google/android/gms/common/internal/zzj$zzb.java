package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import java.util.concurrent.atomic.AtomicInteger;

final class zzj$zzb
  extends Handler
{
  public zzj$zzb(zzj paramzzj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private static void zza(Message paramMessage)
  {
    ((zzj.zzc)obj).unregister();
  }
  
  private static boolean zzb(Message paramMessage)
  {
    return (what == 2) || (what == 1) || (what == 5);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (zzalL.zzalI.get() != arg1)
    {
      if (zzb(paramMessage)) {
        zza(paramMessage);
      }
      return;
    }
    if (((what == 1) || (what == 5)) && (!zzalL.isConnecting()))
    {
      zza(paramMessage);
      return;
    }
    if (what == 3)
    {
      paramMessage = new ConnectionResult(arg2, null);
      zzj.zzb(zzalL).zza(paramMessage);
      zzalL.onConnectionFailed(paramMessage);
      return;
    }
    if (what == 4)
    {
      zzj.zza$4495c6b5(zzalL, 4);
      if (zzj.zzc(zzalL) != null) {
        zzj.zzc(zzalL).onConnectionSuspended(arg2);
      }
      zzj localzzj = zzalL;
      zzals = arg2;
      zzalt = System.currentTimeMillis();
      zzj.zza(zzalL, 4, 1, null);
      return;
    }
    if ((what == 2) && (!zzalL.isConnected()))
    {
      zza(paramMessage);
      return;
    }
    if (zzb(paramMessage))
    {
      ((zzj.zzc)obj).zzqN();
      return;
    }
    Log.wtf("GmsClient", "Don't know how to handle message: " + what, new Exception());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */