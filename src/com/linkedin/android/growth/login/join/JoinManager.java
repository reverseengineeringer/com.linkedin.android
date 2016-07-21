package com.linkedin.android.growth.login.join;

import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;
import javax.inject.Inject;

public final class JoinManager
{
  final BaseActivity activity;
  final Auth auth;
  final LoginUtils loginUtils;
  
  @Inject
  public JoinManager(Auth paramAuth, LoginUtils paramLoginUtils, BaseActivity paramBaseActivity)
  {
    auth = paramAuth;
    loginUtils = paramLoginUtils;
    activity = paramBaseActivity;
  }
  
  public final LiRegistrationResponse.RegistrationListener createRegistrationListener(final JoinListener paramJoinListener)
  {
    new LiRegistrationResponse.RegistrationListener()
    {
      public final void onResponse(LiRegistrationResponse paramAnonymousLiRegistrationResponse)
      {
        Object localObject;
        if ((paramAnonymousLiRegistrationResponse == null) || (statusCode != 200))
        {
          localObject = paramJoinListener;
          if (localObject != null) {
            ((JoinManager.JoinListener)localObject).onFail(paramAnonymousLiRegistrationResponse);
          }
        }
        do
        {
          CheckpointChallengeResponseData localCheckpointChallengeResponseData;
          RegistrationResponseData localRegistrationResponseData;
          JoinManager.JoinListener localJoinListener;
          do
          {
            return;
            if (mCheckpointResponseData == null) {
              break;
            }
            mRegistrationInfo.mPhoneNumber = mRegistrationResponseData.mFormattedPhoneNumber;
            mRegistrationInfo.mCountryCode = mRegistrationResponseData.mCountryCode;
            localObject = mRegistrationUri;
            localCheckpointChallengeResponseData = mCheckpointResponseData;
            localRegistrationResponseData = mRegistrationResponseData;
            paramAnonymousLiRegistrationResponse = mRegistrationInfo;
            localJoinListener = paramJoinListener;
          } while (localJoinListener == null);
          localJoinListener.onCaptcha((String)localObject, localCheckpointChallengeResponseData, localRegistrationResponseData, paramAnonymousLiRegistrationResponse);
          return;
          paramAnonymousLiRegistrationResponse = JoinManager.this;
          localObject = paramJoinListener;
          loginUtils.onSignin(activity);
        } while (localObject == null);
        ((JoinManager.JoinListener)localObject).onSuccess();
      }
    };
  }
  
  public static abstract interface JoinListener
  {
    public abstract void onCaptcha(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationResponseData paramRegistrationResponseData, RegistrationInfo paramRegistrationInfo);
    
    public abstract void onFail(LiRegistrationResponse paramLiRegistrationResponse);
    
    public abstract void onSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */