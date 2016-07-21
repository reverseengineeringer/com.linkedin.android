package com.linkedin.android.growth.login.join;

import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;

final class JoinManager$1
  implements LiRegistrationResponse.RegistrationListener
{
  JoinManager$1(JoinManager paramJoinManager, JoinManager.JoinListener paramJoinListener) {}
  
  public final void onResponse(LiRegistrationResponse paramLiRegistrationResponse)
  {
    Object localObject;
    if ((paramLiRegistrationResponse == null) || (statusCode != 200))
    {
      localObject = val$joinListener;
      if (localObject != null) {
        ((JoinManager.JoinListener)localObject).onFail(paramLiRegistrationResponse);
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
        paramLiRegistrationResponse = mRegistrationInfo;
        localJoinListener = val$joinListener;
      } while (localJoinListener == null);
      localJoinListener.onCaptcha((String)localObject, localCheckpointChallengeResponseData, localRegistrationResponseData, paramLiRegistrationResponse);
      return;
      paramLiRegistrationResponse = this$0;
      localObject = val$joinListener;
      loginUtils.onSignin(activity);
    } while (localObject == null);
    ((JoinManager.JoinListener)localObject).onSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */