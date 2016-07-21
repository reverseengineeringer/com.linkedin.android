package com.linkedin.android.growth.login.sso;

import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuthProvider;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import java.util.List;

public final class SSOManager
{
  public final BaseActivity activity;
  public final LiAuth liAuth;
  public final LoginUtils loginUtils;
  public final FlagshipSharedPreferences sharedPreferences;
  private List<LiSSOInfo> ssoUsers;
  
  public SSOManager(BaseActivity paramBaseActivity, FlagshipSharedPreferences paramFlagshipSharedPreferences, LoginUtils paramLoginUtils)
  {
    activity = paramBaseActivity;
    sharedPreferences = paramFlagshipSharedPreferences;
    liAuth = LiAuthProvider.getInstance(paramBaseActivity.getApplicationContext());
    loginUtils = paramLoginUtils;
  }
  
  public final List<LiSSOInfo> getSSOUsers()
  {
    if (ssoUsers == null) {
      ssoUsers = liAuth.getSSOUsers();
    }
    return ssoUsers;
  }
  
  public static abstract interface SSOListener
  {
    public abstract void onFail();
    
    public abstract void onSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.sso.SSOManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */