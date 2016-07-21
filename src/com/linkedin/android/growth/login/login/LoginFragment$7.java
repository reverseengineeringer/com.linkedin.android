package com.linkedin.android.growth.login.login;

import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class LoginFragment$7
  implements LoginManager.LoginListener
{
  LoginFragment$7(LoginFragment paramLoginFragment) {}
  
  public final void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode)
  {
    LoginFragment.access$100$43fbe68(this$0);
  }
  
  public final void onSuccess()
  {
    this$0.preRegListener.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */