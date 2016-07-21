package com.linkedin.android.growth.login.login;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credential.Builder;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialSaveListener;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.login.smartlock.SmartLockManager.5;
import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuth.LiAuthHost;
import com.linkedin.android.liauthlib.common.LiAuthResponse;
import com.linkedin.android.liauthlib.common.LiAuthResponse.AuthListener;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.logger.Log;
import javax.inject.Inject;

public class LoginManager
{
  private static final String TAG = LoginManager.class.getSimpleName();
  private final BaseActivity activity;
  private final com.linkedin.android.infra.network.Auth auth;
  private final LoginUtils loginUtils;
  private final NetworkClient networkClient;
  private final SmartLockManager smartLockManager;
  private final TakeoverManager takeoverManager;
  
  @Inject
  public LoginManager(com.linkedin.android.infra.network.Auth paramAuth, LoginUtils paramLoginUtils, BaseActivity paramBaseActivity, TakeoverManager paramTakeoverManager, NetworkClient paramNetworkClient)
  {
    auth = paramAuth;
    loginUtils = paramLoginUtils;
    activity = paramBaseActivity;
    smartLockManager = activityComponent.smartLockManager();
    takeoverManager = paramTakeoverManager;
    networkClient = paramNetworkClient;
  }
  
  public static int getErrorMessage(LiError.LiAuthErrorCode paramLiAuthErrorCode)
  {
    if (paramLiAuthErrorCode == null) {
      return 2131232797;
    }
    switch (paramLiAuthErrorCode)
    {
    default: 
      return 2131232797;
    }
    return 2131232773;
  }
  
  public final void loginWithGoogleIdToken(String paramString1, String paramString2, final LoginListener paramLoginListener)
  {
    com.linkedin.android.infra.network.Auth localAuth = auth;
    paramLoginListener = new LiAuthResponse.AuthListener()
    {
      public final void onResponse(LiAuthResponse paramAnonymousLiAuthResponse)
      {
        if ((paramAnonymousLiAuthResponse != null) && (statusCode == 200))
        {
          onLoginSuccess(paramLoginListener);
          return;
        }
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramAnonymousLiAuthResponse != null)
        {
          localObject1 = localObject2;
          if (error != null) {
            localObject1 = error.errorCode;
          }
        }
        LoginManager.access$000$2e8c21b4(paramLoginListener, (LiError.LiAuthErrorCode)localObject1);
      }
    };
    sharedPreferences.setMemberEmail(paramString1);
    liAuth.setHost(context, LiAuth.LiAuthHost.CUSTOM);
    liAuth.setCustomHostname(context, sharedPreferences.getAuthUrl());
    liAuth.authenticateWithGoogleIdToken(context, paramString1, paramString2, paramLoginListener);
    networkClient.handledUnauthorizedStatusCode = false;
  }
  
  final void onLoginSuccess(LoginListener paramLoginListener)
  {
    loginUtils.onSignin(activity);
    takeoverManager.loadTakeovers();
    if (paramLoginListener != null) {
      paramLoginListener.onSuccess();
    }
  }
  
  public final void performLogin(String paramString1, String paramString2, final LoginListener paramLoginListener)
  {
    smartLockManager.credentialEmail = paramString1;
    smartLockManager.credentialPassword = paramString2;
    com.linkedin.android.infra.network.Auth localAuth = auth;
    paramLoginListener = new LiAuthResponse.AuthListener()
    {
      public final void onResponse(LiAuthResponse paramAnonymousLiAuthResponse)
      {
        Object localObject2;
        Object localObject1;
        if ((paramAnonymousLiAuthResponse == null) || (statusCode != 200))
        {
          localObject2 = null;
          localObject1 = localObject2;
          if (paramAnonymousLiAuthResponse != null)
          {
            localObject1 = localObject2;
            if (error != null) {
              localObject1 = error.errorCode;
            }
          }
          LoginManager.access$000$2e8c21b4(paramLoginListener, (LiError.LiAuthErrorCode)localObject1);
          return;
        }
        if ((smartLockManager.isSmartLockOn()) && (smartLockManager.isConnected()))
        {
          paramAnonymousLiAuthResponse = smartLockManager;
          localObject1 = new SmartLockCredentialSaveListener()
          {
            public final void onCredentialSaveFail()
            {
              onLoginSuccess(val$loginListener);
            }
            
            public final void onCredentialSaveResolution(Status paramAnonymous2Status)
            {
              if (paramAnonymous2Status.hasResolution()) {
                try
                {
                  paramAnonymous2Status.startResolutionForResult(activity, 1);
                  return;
                }
                catch (IntentSender.SendIntentException paramAnonymous2Status)
                {
                  Log.e(LoginManager.TAG, "STATUS: Failed to send resolution.", paramAnonymous2Status);
                }
              }
              smartLockManager.isSmartLockOn = false;
              onLoginSuccess(val$loginListener);
            }
            
            public final void onCredentialSaveSuccess()
            {
              onLoginSuccess(val$loginListener);
            }
          };
          localObject2 = new Credential.Builder(credentialEmail);
          zzVX = credentialPassword;
          localObject2 = new Credential(3, zzyv, mName, zzVV, zzVW, zzVX, zzVY, zzVZ, zzWa);
          com.google.android.gms.auth.api.Auth.CredentialsApi.save(credentialsApiClient, (Credential)localObject2).setResultCallback(new SmartLockManager.5(paramAnonymousLiAuthResponse, (SmartLockCredentialSaveListener)localObject1));
          return;
        }
        onLoginSuccess(paramLoginListener);
      }
    };
    sharedPreferences.setMemberEmail(paramString1);
    liAuth.setHost(context, LiAuth.LiAuthHost.CUSTOM);
    liAuth.setCustomHostname(context, sharedPreferences.getAuthUrl());
    liAuth.authenticate(context, paramString1, paramString2, paramLoginListener);
    networkClient.handledUnauthorizedStatusCode = false;
  }
  
  public static abstract interface LoginListener
  {
    public abstract void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode);
    
    public abstract void onSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */