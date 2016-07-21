package com.linkedin.android.growth.login.phoneverification;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.design.widget.Snackbar;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.xmsg.util.StringUtils;

class PhoneConfirmationFragment$3
  extends ResultReceiver
{
  PhoneConfirmationFragment$3(PhoneConfirmationFragment paramPhoneConfirmationFragment, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    String str;
    CheckpointChallengeResponseData localCheckpointChallengeResponseData;
    if (paramInt == 1)
    {
      str = paramBundle.getString("registrationUri");
      localCheckpointChallengeResponseData = (CheckpointChallengeResponseData)paramBundle.getParcelable("checkpointResponseData");
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
      this$0.preRegListener.showPinVerificationScreen(str, localCheckpointChallengeResponseData, paramBundle);
      return;
      str = paramBundle.getString("sendSmsError");
      paramBundle = str;
      if (StringUtils.isEmpty(str)) {
        paramBundle = this$0.i18NManager.getString(2131231634);
      }
      paramBundle = this$0.snackbar.make(paramBundle, 0);
    } while (paramBundle == null);
    paramBundle.show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */