package com.linkedin.android.growth.login.login;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialSaveListener;
import com.linkedin.android.logger.Log;

final class LoginManager$1$1
  implements SmartLockCredentialSaveListener
{
  LoginManager$1$1(LoginManager.1 param1) {}
  
  public final void onCredentialSaveFail()
  {
    this$1.this$0.onLoginSuccess(this$1.val$loginListener);
  }
  
  public final void onCredentialSaveResolution(Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      try
      {
        paramStatus.startResolutionForResult(LoginManager.access$200(this$1.this$0), 1);
        return;
      }
      catch (IntentSender.SendIntentException paramStatus)
      {
        Log.e(LoginManager.access$300(), "STATUS: Failed to send resolution.", paramStatus);
      }
    }
    access$100this$1.this$0).isSmartLockOn = false;
    this$1.this$0.onLoginSuccess(this$1.val$loginListener);
  }
  
  public final void onCredentialSaveSuccess()
  {
    this$1.this$0.onLoginSuccess(this$1.val$loginListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginManager.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */