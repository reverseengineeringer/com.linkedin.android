package com.linkedin.android.growth.login.phoneverification;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.widget.Button;
import com.linkedin.android.growth.login.join.JoinManager.JoinListener;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;

final class PinVerificationFragment$4
  implements JoinManager.JoinListener
{
  PinVerificationFragment$4(PinVerificationFragment paramPinVerificationFragment) {}
  
  public final void onCaptcha(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationResponseData paramRegistrationResponseData, RegistrationInfo paramRegistrationInfo)
  {
    this$0.pinVerifyButton.setEnabled(true);
    paramString = this$0.snackbar.make(2131230833, 0);
    if (paramString != null) {
      paramString.show();
    }
  }
  
  public final void onFail(LiRegistrationResponse paramLiRegistrationResponse)
  {
    this$0.pinVerifyButton.setEnabled(true);
    if (paramLiRegistrationResponse == null)
    {
      paramLiRegistrationResponse = this$0.snackbar.make(2131230833, 0);
      if (paramLiRegistrationResponse != null) {
        paramLiRegistrationResponse.show();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (statusCode == 200);
        if ((error == null) || (TextUtils.isEmpty(error.errorMsg))) {
          break;
        }
        paramLiRegistrationResponse = this$0.snackbar.make(error.errorMsg, 0);
      } while (paramLiRegistrationResponse == null);
      paramLiRegistrationResponse.show();
      return;
      paramLiRegistrationResponse = this$0.snackbar.make(2131230833, 0);
    } while (paramLiRegistrationResponse == null);
    paramLiRegistrationResponse.show();
  }
  
  public final void onSuccess()
  {
    this$0.pinVerifyButton.setEnabled(true);
    this$0.preRegListener.onJoinSuccess(null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */