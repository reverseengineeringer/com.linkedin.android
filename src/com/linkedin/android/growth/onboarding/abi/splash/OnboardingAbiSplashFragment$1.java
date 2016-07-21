package com.linkedin.android.growth.onboarding.abi.splash;

import android.support.v4.app.FragmentManager;
import android.view.View;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.growth.lego.LegoFlowNavigation;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class OnboardingAbiSplashFragment$1
  extends LegoActionTrackingOnClickListener
{
  OnboardingAbiSplashFragment$1(OnboardingAbiSplashFragment paramOnboardingAbiSplashFragment, String paramString1, ActionCategory paramActionCategory, LegoTrackingDataProvider paramLegoTrackingDataProvider, Tracker paramTracker, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramString1, paramActionCategory, paramLegoTrackingDataProvider, paramTracker, paramString2, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = OnboardingAbiSplashFragment.access$000(this$0);
    if (!stopped)
    {
      while (paramView.getChildFragmentManager().popBackStackImmediate()) {}
      legoNavigator.moveToNextGroupLegoWidget();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */