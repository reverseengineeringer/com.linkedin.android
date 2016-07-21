package com.linkedin.android.growth.login.join;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.login.LoginManager.LoginListener;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialRequestListener;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class JoinFragment$7
  implements SmartLockCredentialRequestListener
{
  JoinFragment$7(JoinFragment paramJoinFragment) {}
  
  public final void onCredentialRequestFailed() {}
  
  public final void onCredentialRequestHintSelector(Status paramStatus)
  {
    JoinFragment.access$300(this$0, paramStatus, 3);
  }
  
  public final void onCredentialRequestMultipleResults(Status paramStatus)
  {
    JoinFragment.access$300(this$0, paramStatus, 2);
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
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */