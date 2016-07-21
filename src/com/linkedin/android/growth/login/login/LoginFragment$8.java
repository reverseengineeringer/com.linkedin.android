package com.linkedin.android.growth.login.login;

import com.google.android.gms.auth.api.credentials.Credential;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenListener;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;

final class LoginFragment$8
  implements GoogleIdTokenListener
{
  LoginFragment$8(LoginFragment paramLoginFragment, Credential paramCredential) {}
  
  public final void onFetchFailed()
  {
    LoginFragment.access$200(this$0, val$credential);
  }
  
  public final void onFetchSucceed(String paramString)
  {
    this$0.googleIdTokenManager.sendTrackingEvent("googleidtoken_choose_hint_email");
    this$0.loginManager.loginWithGoogleIdToken(val$credential.zzyv, paramString, new LoginFragment.9(this$0));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */