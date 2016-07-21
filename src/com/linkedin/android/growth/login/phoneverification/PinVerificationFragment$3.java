package com.linkedin.android.growth.login.phoneverification;

import android.support.v4.app.FragmentManager;
import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class PinVerificationFragment$3
  extends TrackingOnClickListener
{
  PinVerificationFragment$3(PinVerificationFragment paramPinVerificationFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.getFragmentManager().popBackStack();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */