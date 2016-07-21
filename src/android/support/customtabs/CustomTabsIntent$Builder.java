package android.support.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.BundleCompatDonut;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class CustomTabsIntent$Builder
{
  public final Intent mIntent = new Intent("android.intent.action.VIEW");
  private ArrayList<Bundle> mMenuItems = null;
  public Bundle mStartAnimationBundle = null;
  
  public CustomTabsIntent$Builder()
  {
    this(null);
  }
  
  public CustomTabsIntent$Builder(CustomTabsSession paramCustomTabsSession)
  {
    if (paramCustomTabsSession != null) {
      mIntent.setPackage(mComponentName.getPackageName());
    }
    Bundle localBundle = new Bundle();
    if (paramCustomTabsSession == null)
    {
      paramCustomTabsSession = null;
      if (Build.VERSION.SDK_INT < 18) {
        break label98;
      }
      localBundle.putBinder("android.support.customtabs.extra.SESSION", paramCustomTabsSession);
    }
    for (;;)
    {
      mIntent.putExtras(localBundle);
      return;
      paramCustomTabsSession = mCallback.asBinder();
      break;
      label98:
      if (!BundleCompatDonut.sPutIBinderMethodFetched) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        BundleCompatDonut.sPutIBinderMethod = localMethod;
        localMethod.setAccessible(true);
        BundleCompatDonut.sPutIBinderMethodFetched = true;
        if (BundleCompatDonut.sPutIBinderMethod == null) {
          continue;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          BundleCompatDonut.sPutIBinderMethod.invoke(localBundle, new Object[] { "android.support.customtabs.extra.SESSION", paramCustomTabsSession });
        }
        catch (InvocationTargetException paramCustomTabsSession)
        {
          for (;;)
          {
            Log.i("BundleCompatDonut", "Failed to invoke putIBinder via reflection", paramCustomTabsSession);
            BundleCompatDonut.sPutIBinderMethod = null;
            break;
            localNoSuchMethodException = localNoSuchMethodException;
            Log.i("BundleCompatDonut", "Failed to retrieve putIBinder method", localNoSuchMethodException);
          }
        }
        catch (IllegalAccessException paramCustomTabsSession)
        {
          for (;;) {}
        }
        catch (IllegalArgumentException paramCustomTabsSession)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public final Builder addMenuItem(String paramString, PendingIntent paramPendingIntent)
  {
    if (mMenuItems == null) {
      mMenuItems = new ArrayList();
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", paramString);
    localBundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", paramPendingIntent);
    mMenuItems.add(localBundle);
    return this;
  }
  
  public final CustomTabsIntent build()
  {
    if (mMenuItems != null) {
      mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", mMenuItems);
    }
    return new CustomTabsIntent(mIntent, mStartAnimationBundle, (byte)0);
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsIntent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */