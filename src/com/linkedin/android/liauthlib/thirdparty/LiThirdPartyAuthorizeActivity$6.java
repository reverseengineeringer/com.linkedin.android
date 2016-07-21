package com.linkedin.android.liauthlib.thirdparty;

import android.os.Handler;
import com.linkedin.android.liauthlib.LiAuth;

final class LiThirdPartyAuthorizeActivity$6
  implements LiThirdPartyAuthorizeResponse.AuthListener
{
  LiThirdPartyAuthorizeActivity$6(LiThirdPartyAuthorizeActivity paramLiThirdPartyAuthorizeActivity) {}
  
  public final void onResponse(LiThirdPartyAuthorizeResponse paramLiThirdPartyAuthorizeResponse)
  {
    LiThirdPartyAuthorizeActivity localLiThirdPartyAuthorizeActivity = this$0;
    new StringBuilder("response received for authorize view ").append(statusCode).append(" ").append(m_appName);
    if (statusCode / 100 != 2)
    {
      if ((statusCode == 400) && (errorInfo.equals("unauthorized_client")))
      {
        localLiThirdPartyAuthorizeActivity.startLoginActivity(true);
        return;
      }
      localLiThirdPartyAuthorizeActivity.finishWithError$5647b3fe(LiThirdPartyErrorCode.fromMobileSDKUasCode(errorInfo), errorDescription);
      return;
    }
    if (m_accessToken != null)
    {
      localLiThirdPartyAuthorizeActivity.finishWithAccessToken(m_accessToken, m_expiresOn);
      return;
    }
    paramLiThirdPartyAuthorizeResponse = m_appInfoHandler.obtainMessage(1000, paramLiThirdPartyAuthorizeResponse);
    m_appInfoHandler.sendMessage(paramLiThirdPartyAuthorizeResponse);
    m_auth.startSSOService(new LiThirdPartyAuthorizeActivity.7(localLiThirdPartyAuthorizeActivity));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeActivity.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */