package android.support.customtabs;

import android.content.ComponentName;

public final class CustomTabsSession
{
  final ICustomTabsCallback mCallback;
  final ComponentName mComponentName;
  private final ICustomTabsService mService;
  
  CustomTabsSession(ICustomTabsService paramICustomTabsService, ICustomTabsCallback paramICustomTabsCallback, ComponentName paramComponentName)
  {
    mService = paramICustomTabsService;
    mCallback = paramICustomTabsCallback;
    mComponentName = paramComponentName;
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */