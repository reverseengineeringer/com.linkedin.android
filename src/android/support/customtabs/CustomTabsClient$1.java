package android.support.customtabs;

import android.os.Bundle;
import android.os.RemoteException;

final class CustomTabsClient$1
  extends ICustomTabsCallback.Stub
{
  CustomTabsClient$1(CustomTabsClient paramCustomTabsClient, CustomTabsCallback paramCustomTabsCallback) {}
  
  public final void extraCallback(String paramString, Bundle paramBundle)
    throws RemoteException
  {}
  
  public final void onNavigationEvent(int paramInt, Bundle paramBundle)
  {
    if (val$callback != null) {
      val$callback.onNavigationEvent(paramInt, paramBundle);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */