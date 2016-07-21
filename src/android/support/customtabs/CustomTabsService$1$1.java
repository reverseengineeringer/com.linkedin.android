package android.support.customtabs;

import android.os.IBinder.DeathRecipient;

final class CustomTabsService$1$1
  implements IBinder.DeathRecipient
{
  CustomTabsService$1$1(CustomTabsService.1 param1, CustomTabsSessionToken paramCustomTabsSessionToken) {}
  
  public final void binderDied()
  {
    this$1.this$0.cleanUpSession(val$sessionToken);
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsService.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */