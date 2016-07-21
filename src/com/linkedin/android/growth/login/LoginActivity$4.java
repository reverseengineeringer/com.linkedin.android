package com.linkedin.android.growth.login;

import android.text.TextUtils;
import com.linkedin.android.growth.login.sso.SSOManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.liauthlib.sso.LiSSOServiceBindingListener;
import java.util.List;

final class LoginActivity$4
  implements LiSSOServiceBindingListener
{
  LoginActivity$4(LoginActivity paramLoginActivity) {}
  
  public final void onBindSuccess()
  {
    Object localObject = Util.safeGet(this$0.ssoManager.getSSOUsers());
    int i = ((List)localObject).size() - 1;
    while (i >= 0)
    {
      if (!TextUtils.isEmpty(getfirstName))
      {
        localObject = this$0;
        if (LoginActivity.access$100(this$0) == null) {}
        for (boolean bool = true;; bool = false)
        {
          LoginActivity.access$500((LoginActivity)localObject, bool);
          return;
        }
      }
      i -= 1;
    }
    if (LoginActivity.access$600(this$0))
    {
      this$0.showLoginScreen(true);
      return;
    }
    LoginActivity.access$702$46badd47(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginActivity.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */