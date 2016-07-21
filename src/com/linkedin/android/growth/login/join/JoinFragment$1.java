package com.linkedin.android.growth.login.join;

import android.view.View;
import com.linkedin.android.growth.utils.ThirdPartySdkTrackingUtils;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class JoinFragment$1
  extends TrackingOnClickListener
{
  JoinFragment$1(JoinFragment paramJoinFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (this$0.isRegistrationViaThirdPartySdk) {
      ThirdPartySdkTrackingUtils.emitCustomRegistrationActionEvent(this$0.tracker, this$0.thirdPartyApplicationPackageName);
    }
    this$0.join();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */