package com.linkedin.android.growth.onboarding.abi.splash;

import android.view.View;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseLegoWidget;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class OnboardingAbiSplashFragment$2
  extends TrackingOnClickListener
{
  OnboardingAbiSplashFragment$2(OnboardingAbiSplashFragment paramOnboardingAbiSplashFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    OnboardingAbiSplashFragment.access$100(this$0).showLearnMoreFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */