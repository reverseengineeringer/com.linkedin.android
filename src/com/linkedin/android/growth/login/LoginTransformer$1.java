package com.linkedin.android.growth.login;

import android.content.Context;
import android.view.View;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.login.sso.SSOManager;
import com.linkedin.android.growth.login.sso.SSOManager.SSOListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class LoginTransformer$1
  extends TrackingOnClickListener
{
  public LoginTransformer$1(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, SSOManager paramSSOManager, LiSSOInfo paramLiSSOInfo, Context paramContext, PreRegListener paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = val$ssoManager;
    LiSSOInfo localLiSSOInfo = val$ssoUser;
    Object localObject = val$context;
    localObject = new LoginTransformer.4(val$preRegListener, (Context)localObject);
    if (liAuth.getSSOTokens(activity.getApplicationContext(), localLiSSOInfo)) {
      sharedPreferences.setMemberEmail(username);
    }
    for (int i = 1; i != 0; i = 0)
    {
      loginUtils.onSignin(activity);
      ((SSOManager.SSOListener)localObject).onSuccess();
      return;
    }
    ((SSOManager.SSOListener)localObject).onFail();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */