package com.linkedin.android.growth.login.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.utils.ThirdPartySdkTrackingUtils;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.gen.avro2pegasus.events.mobilesdk.VoyagerLoginResult;

final class LoginFragment$5
  implements LoginManager.LoginListener
{
  boolean isLoginFromThirdPartySdk;
  Intent loginActivityIntent;
  String thirdPartyApplicationPackageName;
  
  LoginFragment$5(LoginFragment paramLoginFragment)
  {
    if (this$0.getActivity() != null)
    {
      paramLoginFragment = this$0.getActivity().getIntent();
      loginActivityIntent = paramLoginFragment;
      if (loginActivityIntent != null) {
        break label74;
      }
      paramLoginFragment = (LoginFragment)localObject;
      label46:
      thirdPartyApplicationPackageName = paramLoginFragment;
      if (TextUtils.isEmpty(thirdPartyApplicationPackageName)) {
        break label88;
      }
    }
    label74:
    label88:
    for (boolean bool = true;; bool = false)
    {
      isLoginFromThirdPartySdk = bool;
      return;
      paramLoginFragment = null;
      break;
      paramLoginFragment = LoginIntentBundle.getThirdPartyApplicationPackageName(loginActivityIntent.getExtras());
      break label46;
    }
  }
  
  public final void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode)
  {
    if (isLoginFromThirdPartySdk) {
      ThirdPartySdkTrackingUtils.emitCustomLoginActionEvent(this$0.tracker, thirdPartyApplicationPackageName, VoyagerLoginResult.INVALID_LOGIN, null, -1L);
    }
    SnackbarUtil localSnackbarUtil = this$0.snackbar;
    paramLiAuthErrorCode = SnackbarUtil.make(this$0.getView(), LoginManager.getErrorMessage(paramLiAuthErrorCode), 0);
    if (paramLiAuthErrorCode != null) {
      paramLiAuthErrorCode.show();
    }
  }
  
  public final void onSuccess()
  {
    if (isLoginFromThirdPartySdk)
    {
      String str = this$0.applicationComponent.cookieUtil().getJsessionIdOrSetIfNull(this$0.sharedPreferences.getAuthUrl());
      ThirdPartySdkTrackingUtils.emitCustomLoginActionEvent(this$0.tracker, thirdPartyApplicationPackageName, VoyagerLoginResult.SUCCESS, str, this$0.memberUtil.getMemberId());
    }
    this$0.preRegListener.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */