package com.linkedin.android.growth.login.login;

import com.linkedin.android.liauthlib.common.LiAuthResponse;
import com.linkedin.android.liauthlib.common.LiAuthResponse.AuthListener;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class LoginManager$2
  implements LiAuthResponse.AuthListener
{
  LoginManager$2(LoginManager paramLoginManager, LoginManager.LoginListener paramLoginListener) {}
  
  public final void onResponse(LiAuthResponse paramLiAuthResponse)
  {
    if ((paramLiAuthResponse != null) && (statusCode == 200))
    {
      this$0.onLoginSuccess(val$loginListener);
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramLiAuthResponse != null)
    {
      localObject1 = localObject2;
      if (error != null) {
        localObject1 = error.errorCode;
      }
    }
    LoginManager.access$000$2e8c21b4(val$loginListener, (LiError.LiAuthErrorCode)localObject1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */