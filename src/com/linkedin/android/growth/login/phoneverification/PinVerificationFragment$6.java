package com.linkedin.android.growth.login.phoneverification;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.design.widget.Snackbar;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;

class PinVerificationFragment$6
  extends ResultReceiver
{
  PinVerificationFragment$6(PinVerificationFragment paramPinVerificationFragment, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 1) && (paramBundle != null))
    {
      String str = paramBundle.getString("registrationUri");
      CheckpointChallengeResponseData localCheckpointChallengeResponseData = (CheckpointChallengeResponseData)paramBundle.getParcelable("checkpointResponseData");
      paramBundle = (RegistrationInfo)paramBundle.getParcelable("registrationInfo");
      if ((str == null) || (localCheckpointChallengeResponseData == null) || (paramBundle == null))
      {
        paramBundle = this$0.snackbar.make(2131231634, 0);
        if (paramBundle != null) {
          paramBundle.show();
        }
      }
    }
    do
    {
      return;
      paramBundle = this$0.snackbar.make(2131231634, 0);
    } while (paramBundle == null);
    paramBundle.show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */