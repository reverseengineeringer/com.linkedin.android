package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public final class zzj$zzd
  extends zzr.zza
{
  private zzj zzalN;
  private final int zzalO;
  
  public zzj$zzd(zzj paramzzj, int paramInt)
  {
    zzalN = paramzzj;
    zzalO = paramInt;
  }
  
  public final void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    zzx.zzb(zzalN, "onPostInitComplete can be called only once per call to getRemoteService");
    zzj localzzj = zzalN;
    int i = zzalO;
    mHandler.sendMessage(mHandler.obtainMessage(1, i, -1, new zzj.zzg(localzzj, paramInt, paramIBinder, paramBundle)));
    zzalN = null;
  }
  
  public final void zzb(int paramInt, Bundle paramBundle)
  {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */