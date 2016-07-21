package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

final class CustomTabsService$1
  extends ICustomTabsService.Stub
{
  CustomTabsService$1(CustomTabsService paramCustomTabsService) {}
  
  public final Bundle extraCommand(String paramString, Bundle paramBundle)
  {
    return this$0.extraCommand$5f15a07();
  }
  
  public final boolean mayLaunchUrl(ICustomTabsCallback paramICustomTabsCallback, Uri paramUri, Bundle paramBundle, List<Bundle> paramList)
  {
    paramUri = this$0;
    new CustomTabsSessionToken(paramICustomTabsCallback);
    return paramUri.mayLaunchUrl$28898044();
  }
  
  public final boolean newSession(ICustomTabsCallback paramICustomTabsCallback)
  {
    ??? = new CustomTabsSessionToken(paramICustomTabsCallback);
    try
    {
      IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
      {
        public final void binderDied()
        {
          this$0.cleanUpSession(localObject);
        }
      };
      synchronized (CustomTabsService.access$000(this$0))
      {
        paramICustomTabsCallback.asBinder().linkToDeath(local1, 0);
        CustomTabsService.access$000(this$0).put(paramICustomTabsCallback.asBinder(), local1);
        boolean bool = this$0.newSession$26d819e();
        return bool;
      }
      return false;
    }
    catch (RemoteException paramICustomTabsCallback) {}
  }
  
  public final boolean updateVisuals(ICustomTabsCallback paramICustomTabsCallback, Bundle paramBundle)
  {
    paramBundle = this$0;
    new CustomTabsSessionToken(paramICustomTabsCallback);
    return paramBundle.updateVisuals$7708c702();
  }
  
  public final boolean warmup(long paramLong)
  {
    return this$0.warmup$1349f3();
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */