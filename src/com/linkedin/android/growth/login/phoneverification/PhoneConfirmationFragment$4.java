package com.linkedin.android.growth.login.phoneverification;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;

final class PhoneConfirmationFragment$4
  implements LiRegistrationResponse.RegistrationListener
{
  PhoneConfirmationFragment$4(PhoneConfirmationFragment paramPhoneConfirmationFragment) {}
  
  public final void onResponse(LiRegistrationResponse paramLiRegistrationResponse)
  {
    if (paramLiRegistrationResponse == null)
    {
      paramLiRegistrationResponse = this$0.snackbar.make(2131231628, 0);
      if (paramLiRegistrationResponse != null) {
        paramLiRegistrationResponse.show();
      }
    }
    label108:
    do
    {
      do
      {
        do
        {
          return;
          if (statusCode == 200) {
            break label108;
          }
          if ((error == null) || (TextUtils.isEmpty(error.errorMsg))) {
            break;
          }
          paramLiRegistrationResponse = this$0.snackbar.make(error.errorMsg, 0);
        } while (paramLiRegistrationResponse == null);
        paramLiRegistrationResponse.show();
        return;
        paramLiRegistrationResponse = this$0.snackbar.make(2131231628, 0);
      } while (paramLiRegistrationResponse == null);
      paramLiRegistrationResponse.show();
      return;
    } while (mCheckpointResponseData == null);
    mRegistrationInfo.mPhoneNumber = mRegistrationResponseData.mFormattedPhoneNumber;
    mRegistrationInfo.mCountryCode = mRegistrationResponseData.mCountryCode;
    this$0.sendSMSPin(mRegistrationUri, mRegistrationInfo, mCheckpointResponseData);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */