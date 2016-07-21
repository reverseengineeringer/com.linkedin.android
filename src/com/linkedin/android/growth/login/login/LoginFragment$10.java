package com.linkedin.android.growth.login.login;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialRequestListener;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class LoginFragment$10
  implements SmartLockCredentialRequestListener
{
  LoginFragment$10(LoginFragment paramLoginFragment) {}
  
  public final void onCredentialRequestFailed() {}
  
  public final void onCredentialRequestHintSelector(Status paramStatus)
  {
    LoginFragment.access$300(this$0, paramStatus, 3);
  }
  
  public final void onCredentialRequestMultipleResults(Status paramStatus)
  {
    LoginFragment.access$300(this$0, paramStatus, 2);
  }
  
  public final void onCredentialRequestSuccess(Credential paramCredential)
  {
    this$0.loginManager.performLogin(zzyv, zzVX, new LoginManager.LoginListener()
    {
      public final void onFail(LiError.LiAuthErrorCode paramAnonymousLiAuthErrorCode) {}
      
      public final void onSuccess()
      {
        this$0.preRegListener.onLoginSuccess();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */