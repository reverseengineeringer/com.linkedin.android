package com.linkedin.android.growth.login;

import com.linkedin.android.growth.login.smartlock.SmartLockDisableAutoSignInListener;

final class LoginActivity$2$1
  implements SmartLockDisableAutoSignInListener
{
  LoginActivity$2$1(LoginActivity.2 param2) {}
  
  public final void onPostDisable()
  {
    LoginActivity localLoginActivity = this$1.this$0;
    if (LoginActivity.access$100(this$1.this$0) == null) {}
    for (boolean bool = true;; bool = false)
    {
      LoginActivity.access$200(localLoginActivity, bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginActivity.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */