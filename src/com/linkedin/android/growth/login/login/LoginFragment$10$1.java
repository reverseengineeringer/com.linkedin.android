package com.linkedin.android.growth.login.login;

import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class LoginFragment$10$1
  implements LoginManager.LoginListener
{
  LoginFragment$10$1(LoginFragment.10 param10) {}
  
  public final void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode) {}
  
  public final void onSuccess()
  {
    this$1.this$0.preRegListener.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.10.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */