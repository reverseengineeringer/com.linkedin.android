package com.linkedin.android.liauthlib.thirdparty;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.network.HttpStack;

final class LiThirdPartyAuthorizeActivity$1
  implements View.OnClickListener
{
  LiThirdPartyAuthorizeActivity$1(LiThirdPartyAuthorizeActivity paramLiThirdPartyAuthorizeActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = this$0;
    String str = m_auth.getHttpStack().getCookie("li_at", Uri.parse(m_auth.getBaseHost()).getHost());
    if (str != null) {
      str.length();
    }
    m_auth.thirdPartyAuthorize(paramView.getApplicationContext(), m_scope, m_locale, m_callerPackage, m_callerSignatureHash, m_serverData, true, new LiThirdPartyAuthorizeActivity.4(paramView));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */