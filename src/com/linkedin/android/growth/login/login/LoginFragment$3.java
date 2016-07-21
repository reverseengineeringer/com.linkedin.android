package com.linkedin.android.growth.login.login;

import android.view.KeyEvent;
import android.widget.TextView;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnEditorActionListener;

final class LoginFragment$3
  extends TrackingOnEditorActionListener
{
  LoginFragment$3(LoginFragment paramLoginFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    super.onEditorAction(paramTextView, paramInt, paramKeyEvent);
    paramTextView = this$0;
    if (paramInt == 6)
    {
      paramTextView.signIn();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */