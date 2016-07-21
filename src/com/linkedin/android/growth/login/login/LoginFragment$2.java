package com.linkedin.android.growth.login.login;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class LoginFragment$2
  extends TrackingOnClickListener
{
  LoginFragment$2(LoginFragment paramLoginFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.signIn();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */