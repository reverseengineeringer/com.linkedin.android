package com.linkedin.android.growth.login;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.login.sso.SSOManager.SSOListener;

final class LoginTransformer$4
  implements SSOManager.SSOListener
{
  LoginTransformer$4(PreRegListener paramPreRegListener, Context paramContext) {}
  
  public final void onFail()
  {
    Snackbar.make(((Activity)val$context).findViewById(16908290), 2131231741, 0).show();
    val$preRegListener.showLoginScreen();
  }
  
  public final void onSuccess()
  {
    val$preRegListener.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginTransformer.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */