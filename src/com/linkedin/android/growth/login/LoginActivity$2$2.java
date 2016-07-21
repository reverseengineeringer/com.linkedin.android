package com.linkedin.android.growth.login;

import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.HintRequest.Builder;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialRequestListener;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.lix.PreAuthLix;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.logger.Log;

final class LoginActivity$2$2
  implements SmartLockCredentialRequestListener
{
  LoginActivity$2$2(LoginActivity.2 param2) {}
  
  public final void onCredentialRequestFailed()
  {
    LoginActivity localLoginActivity = this$1.this$0;
    if (LoginActivity.access$100(this$1.this$0) == null) {}
    for (boolean bool = true;; bool = false)
    {
      LoginActivity.access$200(localLoginActivity, bool);
      return;
    }
  }
  
  public final void onCredentialRequestHintSelector(Status paramStatus)
  {
    boolean bool = true;
    if (("enabled".equals(this$1.this$0.lixManager.getTreatment(PreAuthLix.GROWTH_GOOGLE_ID_TOKEN_SIGN_IN_APP_LAUNCH))) && (this$1.this$0.fragmentManager.findFragmentById(16908290) == null))
    {
      paramStatus = this$1.this$0.smartLockManager;
      Object localObject = new HintRequest.Builder();
      zzWi = true;
      zzWe = new String[] { "https://accounts.google.com" };
      if (zzWe == null) {
        zzWe = new String[0];
      }
      if ((!zzWi) && (!zzWj) && (zzWe.length == 0)) {
        throw new IllegalStateException("At least one authentication method must be specified");
      }
      localObject = new HintRequest((HintRequest.Builder)localObject, (byte)0);
      localObject = Auth.CredentialsApi.getHintPickerIntent(credentialsApiClient, (HintRequest)localObject);
      try
      {
        activity.startIntentSenderForResult(((PendingIntent)localObject).getIntentSender(), 3, null, 0, 0, 0);
        return;
      }
      catch (IntentSender.SendIntentException paramStatus)
      {
        Log.e(SmartLockManager.TAG, "loadHintCredentials: could not start hint picker intent");
        return;
      }
    }
    paramStatus = this$1.this$0;
    if (LoginActivity.access$100(this$1.this$0) == null) {}
    for (;;)
    {
      LoginActivity.access$200(paramStatus, bool);
      return;
      bool = false;
    }
  }
  
  public final void onCredentialRequestMultipleResults(Status paramStatus)
  {
    LoginActivity.access$400(this$1.this$0, paramStatus);
  }
  
  public final void onCredentialRequestSuccess(Credential paramCredential)
  {
    this$1.this$0.loginManager.performLogin(zzyv, zzVX, LoginActivity.access$300(this$1.this$0));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginActivity.2.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */