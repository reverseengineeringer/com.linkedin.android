package com.linkedin.android.liauthlib.thirdparty;

final class LiThirdPartyAuthorizeActivity$4
  implements LiThirdPartyAuthorizeResponse.AuthListener
{
  LiThirdPartyAuthorizeActivity$4(LiThirdPartyAuthorizeActivity paramLiThirdPartyAuthorizeActivity) {}
  
  public final void onResponse(LiThirdPartyAuthorizeResponse paramLiThirdPartyAuthorizeResponse)
  {
    this$0.finishWithAccessToken(m_accessToken, m_expiresOn);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeActivity.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */