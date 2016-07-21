package com.linkedin.android.growth.login.join;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import com.linkedin.android.growth.boost.BoostUtil;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.onboarding.OnboardingBundleBuilder;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;

final class JoinFragment$5
  implements JoinManager.JoinListener
{
  JoinFragment$5(JoinFragment paramJoinFragment) {}
  
  public final void onCaptcha(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationResponseData paramRegistrationResponseData, RegistrationInfo paramRegistrationInfo)
  {
    this$0.preRegListener.showPhoneNumberConfirmationScreen(paramString, paramCheckpointChallengeResponseData, paramRegistrationResponseData, paramRegistrationInfo);
  }
  
  public final void onFail(LiRegistrationResponse paramLiRegistrationResponse)
  {
    if (this$0.getActivity() == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramLiRegistrationResponse != null) {
              break;
            }
            paramLiRegistrationResponse = this$0.snackBar.make(2131230833, 0);
          } while (paramLiRegistrationResponse == null);
          paramLiRegistrationResponse.show();
          return;
        } while (statusCode == 200);
        if ((error == null) || (TextUtils.isEmpty(error.errorMsg))) {
          break;
        }
        paramLiRegistrationResponse = this$0.snackBar.make(error.errorMsg, 0);
      } while (paramLiRegistrationResponse == null);
      paramLiRegistrationResponse.show();
      return;
      paramLiRegistrationResponse = this$0.snackBar.make(2131230833, 0);
    } while (paramLiRegistrationResponse == null);
    paramLiRegistrationResponse.show();
  }
  
  public final void onSuccess()
  {
    BoostUtil.verifyAndUpgradeAccount(this$0.dataManager, this$0.flagshipSharedPreferences, this$0.getActivity());
    OnboardingBundleBuilder localOnboardingBundleBuilder = null;
    if (JoinFragment.access$100(this$0) != null)
    {
      localOnboardingBundleBuilder = new OnboardingBundleBuilder(new Bundle());
      Uri localUri = JoinFragment.access$100(this$0);
      bundle.putParcelable("smartlockImageUri", localUri);
    }
    this$0.preRegListener.onJoinSuccess(localOnboardingBundleBuilder);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */