package com.linkedin.android.growth.onboarding.base;

import android.view.View;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class OnboardingProfileEditFragment$2
  extends LegoActionTrackingOnClickListener
{
  OnboardingProfileEditFragment$2(OnboardingProfileEditFragment paramOnboardingProfileEditFragment, String paramString1, ActionCategory paramActionCategory, LegoTrackingDataProvider paramLegoTrackingDataProvider, Tracker paramTracker, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramString1, paramActionCategory, paramLegoTrackingDataProvider, paramTracker, paramString2, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = this$0.keyboardUtil;
    KeyboardUtil.hideKeyboard(this$0.skipButton);
    OnboardingProfileEditFragment.access$000(this$0).finishCurrentFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */