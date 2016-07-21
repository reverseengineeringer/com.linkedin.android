package com.linkedin.android.growth.login.prereg;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class PreRegPropFragment$1
  extends TrackingOnClickListener
{
  PreRegPropFragment$1(PreRegPropFragment paramPreRegPropFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    PreRegPropFragment.access$000(this$0).goToSignInPage();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegPropFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */