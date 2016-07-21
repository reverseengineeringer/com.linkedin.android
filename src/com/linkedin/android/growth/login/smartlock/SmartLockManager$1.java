package com.linkedin.android.growth.login.smartlock;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.linkedin.android.logger.Log;

final class SmartLockManager$1
  implements GoogleApiClient.OnConnectionFailedListener
{
  SmartLockManager$1(SmartLockManager paramSmartLockManager, SmartLockConnectListener paramSmartLockConnectListener) {}
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    Log.e(SmartLockManager.access$000(), "onConnectionFailed:" + paramConnectionResult);
    val$listener.onConnectFailed();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.smartlock.SmartLockManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */