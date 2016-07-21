package com.linkedin.android.growth.onboarding.abi;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class OnboardingAbiResultFragment$1
  extends TrackingOnClickListener
{
  OnboardingAbiResultFragment$1(OnboardingAbiResultFragment paramOnboardingAbiResultFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.goNext();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.OnboardingAbiResultFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */