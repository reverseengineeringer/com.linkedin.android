package android.support.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public final class CustomTabsSessionToken
{
  private final CustomTabsCallback mCallback;
  final ICustomTabsCallback mCallbackBinder;
  
  CustomTabsSessionToken(ICustomTabsCallback paramICustomTabsCallback)
  {
    mCallbackBinder = paramICustomTabsCallback;
    mCallback = new CustomTabsCallback()
    {
      public final void onNavigationEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        try
        {
          mCallbackBinder.onNavigationEvent(paramAnonymousInt, paramAnonymousBundle);
          return;
        }
        catch (RemoteException paramAnonymousBundle)
        {
          Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
      }
    };
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CustomTabsSessionToken)) {
      return false;
    }
    return ((CustomTabsSessionToken)paramObject).getCallbackBinder().equals(mCallbackBinder.asBinder());
  }
  
  final IBinder getCallbackBinder()
  {
    return mCallbackBinder.asBinder();
  }
  
  public final int hashCode()
  {
    return getCallbackBinder().hashCode();
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsSessionToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */