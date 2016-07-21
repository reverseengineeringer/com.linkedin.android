package com.linkedin.android.growth.login;

import com.linkedin.android.growth.login.login.LoginManager.LoginListener;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class LoginActivity$5
  implements LoginManager.LoginListener
{
  LoginActivity$5(LoginActivity paramLoginActivity) {}
  
  public final void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode)
  {
    paramLiAuthErrorCode = this$0.smartLockManager;
    SmartLockManager.sendTrackingEvent(this$0.activityComponent.tracker(), "smartlock_auto_signin_failed");
    paramLiAuthErrorCode = this$0;
    if (LoginActivity.access$100(this$0) == null) {}
    for (boolean bool = true;; bool = false)
    {
      LoginActivity.access$200(paramLiAuthErrorCode, bool);
      return;
    }
  }
  
  public final void onSuccess()
  {
    SmartLockManager localSmartLockManager = this$0.smartLockManager;
    SmartLockManager.sendTrackingEvent(this$0.activityComponent.tracker(), "smartlock_auto_signin_success");
    this$0.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginActivity.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */