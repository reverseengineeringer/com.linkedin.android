package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class zzj$zze
  implements ServiceConnection
{
  private final int zzalO;
  
  public zzj$zze(zzj paramzzj, int paramInt)
  {
    zzalO = paramInt;
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    zzx.zzb(paramIBinder, "Expecting a valid IBinder");
    synchronized (zzj.zza(zzalL))
    {
      zzj.zza(zzalL, zzs.zza.zzaS(paramIBinder));
      zzalL.zzm(0, zzalO);
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName arg1)
  {
    synchronized (zzj.zza(zzalL))
    {
      zzj.zza(zzalL, null);
      zzalL.mHandler.sendMessage(zzalL.mHandler.obtainMessage(4, zzalO, 1));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */