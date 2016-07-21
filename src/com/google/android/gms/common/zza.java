package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class zza
  implements ServiceConnection
{
  private final BlockingQueue<IBinder> zzafA = new LinkedBlockingQueue();
  boolean zzafz = false;
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zzafA.add(paramIBinder);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final IBinder zzoJ()
    throws InterruptedException
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
    }
    if (zzafz) {
      throw new IllegalStateException();
    }
    zzafz = true;
    return (IBinder)zzafA.take();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */