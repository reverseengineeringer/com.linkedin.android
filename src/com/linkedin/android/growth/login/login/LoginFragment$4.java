package com.linkedin.android.growth.login.login;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class LoginFragment$4
  extends TrackingOnClickListener
{
  LoginFragment$4(LoginFragment paramLoginFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    LoginFragment.access$000(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */