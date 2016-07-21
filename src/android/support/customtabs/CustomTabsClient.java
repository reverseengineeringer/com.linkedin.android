package android.support.customtabs;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;

public class CustomTabsClient
{
  private final ICustomTabsService mService;
  private final ComponentName mServiceComponentName;
  
  CustomTabsClient(ICustomTabsService paramICustomTabsService, ComponentName paramComponentName)
  {
    mService = paramICustomTabsService;
    mServiceComponentName = paramComponentName;
  }
  
  public final CustomTabsSession newSession(final CustomTabsCallback paramCustomTabsCallback)
  {
    paramCustomTabsCallback = new ICustomTabsCallback.Stub()
    {
      public final void extraCallback(String paramAnonymousString, Bundle paramAnonymousBundle)
        throws RemoteException
      {}
      
      public final void onNavigationEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if (paramCustomTabsCallback != null) {
          paramCustomTabsCallback.onNavigationEvent(paramAnonymousInt, paramAnonymousBundle);
        }
      }
    };
    try
    {
      boolean bool = mService.newSession(paramCustomTabsCallback);
      if (!bool) {
        return null;
      }
      return new CustomTabsSession(mService, paramCustomTabsCallback, mServiceComponentName);
    }
    catch (RemoteException paramCustomTabsCallback) {}
    return null;
  }
  
  public final boolean warmup$1349f3()
  {
    try
    {
      boolean bool = mService.warmup(0L);
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */