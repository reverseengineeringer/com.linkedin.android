package android.support.customtabs;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService
  extends Service
{
  private ICustomTabsService.Stub mBinder = new ICustomTabsService.Stub()
  {
    public final Bundle extraCommand(String paramAnonymousString, Bundle paramAnonymousBundle)
    {
      return extraCommand$5f15a07();
    }
    
    public final boolean mayLaunchUrl(ICustomTabsCallback paramAnonymousICustomTabsCallback, Uri paramAnonymousUri, Bundle paramAnonymousBundle, List<Bundle> paramAnonymousList)
    {
      paramAnonymousUri = CustomTabsService.this;
      new CustomTabsSessionToken(paramAnonymousICustomTabsCallback);
      return paramAnonymousUri.mayLaunchUrl$28898044();
    }
    
    public final boolean newSession(ICustomTabsCallback paramAnonymousICustomTabsCallback)
    {
      ??? = new CustomTabsSessionToken(paramAnonymousICustomTabsCallback);
      try
      {
        IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
        {
          public final void binderDied()
          {
            cleanUpSession(localObject);
          }
        };
        synchronized (mDeathRecipientMap)
        {
          paramAnonymousICustomTabsCallback.asBinder().linkToDeath(local1, 0);
          mDeathRecipientMap.put(paramAnonymousICustomTabsCallback.asBinder(), local1);
          boolean bool = newSession$26d819e();
          return bool;
        }
        return false;
      }
      catch (RemoteException paramAnonymousICustomTabsCallback) {}
    }
    
    public final boolean updateVisuals(ICustomTabsCallback paramAnonymousICustomTabsCallback, Bundle paramAnonymousBundle)
    {
      paramAnonymousBundle = CustomTabsService.this;
      new CustomTabsSessionToken(paramAnonymousICustomTabsCallback);
      return paramAnonymousBundle.updateVisuals$7708c702();
    }
    
    public final boolean warmup(long paramAnonymousLong)
    {
      return warmup$1349f3();
    }
  };
  private final Map<IBinder, IBinder.DeathRecipient> mDeathRecipientMap = new ArrayMap();
  
  protected final boolean cleanUpSession(CustomTabsSessionToken paramCustomTabsSessionToken)
  {
    try
    {
      synchronized (mDeathRecipientMap)
      {
        paramCustomTabsSessionToken = paramCustomTabsSessionToken.getCallbackBinder();
        paramCustomTabsSessionToken.unlinkToDeath((IBinder.DeathRecipient)mDeathRecipientMap.get(paramCustomTabsSessionToken), 0);
        mDeathRecipientMap.remove(paramCustomTabsSessionToken);
        return true;
      }
      return false;
    }
    catch (NoSuchElementException paramCustomTabsSessionToken) {}
  }
  
  protected abstract Bundle extraCommand$5f15a07();
  
  protected abstract boolean mayLaunchUrl$28898044();
  
  protected abstract boolean newSession$26d819e();
  
  protected abstract boolean updateVisuals$7708c702();
  
  protected abstract boolean warmup$1349f3();
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */