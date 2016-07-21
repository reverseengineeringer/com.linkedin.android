package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk
  implements Handler.Callback
{
  public final Handler mHandler;
  public final zza zzalQ;
  public final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalR = new ArrayList();
  public final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalS = new ArrayList();
  public final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzalT = new ArrayList();
  public volatile boolean zzalU = false;
  public final AtomicInteger zzalV = new AtomicInteger(0);
  public boolean zzalW = false;
  public final Object zzpV = new Object();
  
  public zzk(Looper paramLooper, zza paramzza)
  {
    zzalQ = paramzza;
    mHandler = new Handler(paramLooper, this);
  }
  
  public final boolean handleMessage(Message arg1)
  {
    if (what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)obj;
      synchronized (zzpV)
      {
        if ((zzalU) && (zzalQ.isConnected()) && (zzalR.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(null);
        }
        return true;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle message: " + what, new Exception());
    return false;
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzz(paramOnConnectionFailedListener);
    synchronized (zzpV)
    {
      if (zzalT.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      zzalT.add(paramOnConnectionFailedListener);
    }
  }
  
  public final void zzqQ()
  {
    zzalU = false;
    zzalV.incrementAndGet();
  }
  
  public static abstract interface zza
  {
    public abstract boolean isConnected();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */