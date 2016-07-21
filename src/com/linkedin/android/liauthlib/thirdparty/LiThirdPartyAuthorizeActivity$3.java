package com.linkedin.android.liauthlib.thirdparty;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class LiThirdPartyAuthorizeActivity$3
  implements View.OnClickListener
{
  LiThirdPartyAuthorizeActivity$3(LiThirdPartyAuthorizeActivity paramLiThirdPartyAuthorizeActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this$0.getApplicationContext(), LiThirdPartyViewUrlActivity.class);
    paramView.putExtra("url", "https://www.linkedin.com/legal/pop/pop-privacy-policy");
    this$0.startActivity(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */