package com.linkedin.android.growth.login;

import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.login.LoginManager.LoginListener;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.logger.Log;

final class LoginActivity$6
  implements LoginManager.LoginListener
{
  LoginActivity$6(LoginActivity paramLoginActivity) {}
  
  public final void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode)
  {
    Log.e(LoginActivity.access$800(), "Login using Google ID token failed");
    this$0.googleIdTokenManager.sendTrackingEvent("googleidtoken_signin_failure");
    if (LoginActivity.access$900(this$0))
    {
      LoginActivity.access$1000(this$0);
      paramLiAuthErrorCode = this$0;
      if ((LoginActivity.access$100(this$0) != null) && (LoginActivity.access$1200(this$0))) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      LoginActivity.access$200(paramLiAuthErrorCode, bool);
      return;
      LoginActivity.access$1102$46badd47(this$0);
      break;
    }
  }
  
  public final void onSuccess()
  {
    this$0.googleIdTokenManager.sendTrackingEvent("googleidtoken_signin_success");
    this$0.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginActivity.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */