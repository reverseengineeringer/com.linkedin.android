package com.linkedin.android.growth.login.login;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credential.Builder;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialSaveListener;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.login.smartlock.SmartLockManager.5;
import com.linkedin.android.liauthlib.common.LiAuthResponse;
import com.linkedin.android.liauthlib.common.LiAuthResponse.AuthListener;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.logger.Log;

final class LoginManager$1
  implements LiAuthResponse.AuthListener
{
  LoginManager$1(LoginManager paramLoginManager, LoginManager.LoginListener paramLoginListener) {}
  
  public final void onResponse(LiAuthResponse paramLiAuthResponse)
  {
    Object localObject2;
    Object localObject1;
    if ((paramLiAuthResponse == null) || (statusCode != 200))
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (paramLiAuthResponse != null)
      {
        localObject1 = localObject2;
        if (error != null) {
          localObject1 = error.errorCode;
        }
      }
      LoginManager.access$000$2e8c21b4(val$loginListener, (LiError.LiAuthErrorCode)localObject1);
      return;
    }
    if ((LoginManager.access$100(this$0).isSmartLockOn()) && (LoginManager.access$100(this$0).isConnected()))
    {
      paramLiAuthResponse = LoginManager.access$100(this$0);
      localObject1 = new SmartLockCredentialSaveListener()
      {
        public final void onCredentialSaveFail()
        {
          this$0.onLoginSuccess(val$loginListener);
        }
        
        public final void onCredentialSaveResolution(Status paramAnonymousStatus)
        {
          if (paramAnonymousStatus.hasResolution()) {
            try
            {
              paramAnonymousStatus.startResolutionForResult(LoginManager.access$200(this$0), 1);
              return;
            }
            catch (IntentSender.SendIntentException paramAnonymousStatus)
            {
              Log.e(LoginManager.access$300(), "STATUS: Failed to send resolution.", paramAnonymousStatus);
            }
          }
          access$100this$0).isSmartLockOn = false;
          this$0.onLoginSuccess(val$loginListener);
        }
        
        public final void onCredentialSaveSuccess()
        {
          this$0.onLoginSuccess(val$loginListener);
        }
      };
      localObject2 = new Credential.Builder(credentialEmail);
      zzVX = credentialPassword;
      localObject2 = new Credential(3, zzyv, mName, zzVV, zzVW, zzVX, zzVY, zzVZ, zzWa);
      Auth.CredentialsApi.save(credentialsApiClient, (Credential)localObject2).setResultCallback(new SmartLockManager.5(paramLiAuthResponse, (SmartLockCredentialSaveListener)localObject1));
      return;
    }
    this$0.onLoginSuccess(val$loginListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */