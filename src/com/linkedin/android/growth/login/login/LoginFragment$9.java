package com.linkedin.android.growth.login.login;

import android.support.design.widget.Snackbar;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class LoginFragment$9
  implements LoginManager.LoginListener
{
  LoginFragment$9(LoginFragment paramLoginFragment) {}
  
  public final void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode)
  {
    this$0.googleIdTokenManager.sendTrackingEvent("googleidtoken_signin_failure");
    paramLiAuthErrorCode = this$0.snackbar.make(2131232797, 0);
    if (paramLiAuthErrorCode != null) {
      paramLiAuthErrorCode.show();
    }
  }
  
  public final void onSuccess()
  {
    this$0.googleIdTokenManager.sendTrackingEvent("googleidtoken_signin_success");
    this$0.preRegListener.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */