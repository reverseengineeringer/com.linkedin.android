package android.support.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public abstract class CustomTabsServiceConnection
  implements ServiceConnection
{
  public abstract void onCustomTabsServiceConnected$51e7d8cd(CustomTabsClient paramCustomTabsClient);
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    onCustomTabsServiceConnected$51e7d8cd(new CustomTabsClient(ICustomTabsService.Stub.asInterface(paramIBinder), paramComponentName) {});
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsServiceConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */