package com.linkedin.android.deeplink.services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.linkedin.android.deeplink.IDeferredDeeplinkingService;
import com.linkedin.android.deeplink.IDeferredDeeplinkingService.Stub;

public class DeferredDeeplinkingServiceConnection
  implements ServiceConnection
{
  public static final String TAG = DeferredDeeplinkingServiceConnection.class.getSimpleName();
  public IDeferredDeeplinkingService deferredDeeplinkingService;
  private DeferredDeeplinkingServiceBindingListener listener;
  
  public DeferredDeeplinkingServiceConnection(DeferredDeeplinkingServiceBindingListener paramDeferredDeeplinkingServiceBindingListener)
  {
    listener = paramDeferredDeeplinkingServiceBindingListener;
  }
  
  public final String getDeferredDeeplink(String paramString)
  {
    try
    {
      paramString = deferredDeeplinkingService.getDeferredDeeplink(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      Log.e(TAG, "RemoteException on DeferredDeeplinkingService: getDeferredDeeplink");
    }
    return null;
  }
  
  public final long getDeferredDeeplinkTimestamp(String paramString)
  {
    try
    {
      long l = deferredDeeplinkingService.getDeferredDeeplinkTimestamp(paramString);
      return l;
    }
    catch (RemoteException paramString)
    {
      Log.e(TAG, "RemoteException on DeferredDeeplinkingService: getDeferredDeeplinkTimestamp");
    }
    return 0L;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    deferredDeeplinkingService = IDeferredDeeplinkingService.Stub.asInterface(paramIBinder);
    if (listener != null) {
      listener.onBindSuccess();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    deferredDeeplinkingService = null;
    listener = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.services.DeferredDeeplinkingServiceConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */