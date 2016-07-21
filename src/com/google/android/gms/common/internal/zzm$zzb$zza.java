package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Iterator;
import java.util.Set;

public final class zzm$zzb$zza
  implements ServiceConnection
{
  public zzm$zzb$zza(zzm.zzb paramzzb) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (zzm.zza(zzami.zzamh))
    {
      zzami.zzakD = paramIBinder;
      zzami.zzamc = paramComponentName;
      Iterator localIterator = zzami.zzame.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    zzami.mState = 1;
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (zzm.zza(zzami.zzamh))
    {
      zzami.zzakD = null;
      zzami.zzamc = paramComponentName;
      Iterator localIterator = zzami.zzame.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    zzami.mState = 2;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm.zzb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */