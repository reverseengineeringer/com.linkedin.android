package com.linkedin.android.growth.login.smartlock;

import com.linkedin.android.infra.lix.LixManager.TreatmentListener;

final class SmartLockManager$3
  implements LixManager.TreatmentListener
{
  SmartLockManager$3(SmartLockManager paramSmartLockManager) {}
  
  public final void onChange(String paramString)
  {
    if (paramString.equals("enabled")) {
      this$0.connect(new SmartLockConnectListener()
      {
        public final void onConnectFailed() {}
        
        public final void onConnectSucceed() {}
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.smartlock.SmartLockManager.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */