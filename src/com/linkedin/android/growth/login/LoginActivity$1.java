package com.linkedin.android.growth.login;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.liauthlib.LiAuth.LogoutReason;
import com.linkedin.android.pegasus.gen.common.JsonModel;

final class LoginActivity$1
  implements RecordTemplateListener<JsonModel>
{
  LoginActivity$1(LoginActivity paramLoginActivity, LiAuth.LogoutReason paramLogoutReason) {}
  
  public final void onResponse(DataStoreResponse<JsonModel> paramDataStoreResponse)
  {
    LoginActivity.access$000(this$0, val$logoutReason);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */