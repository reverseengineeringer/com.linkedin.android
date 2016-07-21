package com.google.android.gms.common.api.internal;

import android.os.Message;
import java.util.concurrent.locks.Lock;

abstract class zzh$zzf
  implements Runnable
{
  private zzh$zzf(zzh paramzzh) {}
  
  public void run()
  {
    zzahC.zzXG.lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool) {
        return;
      }
      zzpt();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzl localzzl = zzahC.zzahj;
      Message localMessage = zzain.obtainMessage(2, localRuntimeException);
      zzain.sendMessage(localMessage);
      return;
    }
    finally
    {
      zzahC.zzXG.unlock();
    }
  }
  
  protected abstract void zzpt();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzh.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */