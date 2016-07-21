package com.linkedin.android.growth.login.join;

import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;

public abstract interface JoinManager$JoinListener
{
  public abstract void onCaptcha(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationResponseData paramRegistrationResponseData, RegistrationInfo paramRegistrationInfo);
  
  public abstract void onFail(LiRegistrationResponse paramLiRegistrationResponse);
  
  public abstract void onSuccess();
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinManager.JoinListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */