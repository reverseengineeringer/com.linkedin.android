package com.linkedin.android.growth.login.smartlock;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

final class SmartLockManager$2
  implements GoogleApiClient.ConnectionCallbacks
{
  SmartLockManager$2(SmartLockManager paramSmartLockManager, SmartLockConnectListener paramSmartLockConnectListener) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    val$listener.onConnectSucceed();
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    SmartLockManager.access$100(this$0).reconnect();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.smartlock.SmartLockManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */