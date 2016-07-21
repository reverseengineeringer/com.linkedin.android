package com.linkedin.android.growth.onboarding;

import android.view.View;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public final class OnboardingTransformer$5
  extends LegoActionTrackingOnClickListener
{
  public OnboardingTransformer$5(String paramString1, ActionCategory paramActionCategory, LegoTrackingDataProvider paramLegoTrackingDataProvider, Tracker paramTracker, String paramString2, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, LegoWidget paramVarArgs)
  {
    super(paramString1, paramActionCategory, paramLegoTrackingDataProvider, paramTracker, paramString2, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    val$legoWidget.finishCurrentFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingTransformer.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */