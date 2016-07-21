package com.linkedin.android.growth.onboarding;

import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.lego.LegoWidgetMultiplexCompletionCallback;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;

final class OnboardingActivity$2
  extends LegoWidgetMultiplexCompletionCallback
{
  OnboardingActivity$2(OnboardingActivity paramOnboardingActivity, ActivityComponent paramActivityComponent, LegoWidget paramLegoWidget1, LegoWidget paramLegoWidget2, String paramString)
  {
    super(paramActivityComponent, paramLegoWidget1);
  }
  
  protected final void onDataReady$34d43c58()
  {
    int i = val$widget.getStatus(this$0.activityComponent);
    if (i == 2)
    {
      OnboardingActivity.access$000(this$0, val$widget.getTrackingToken());
      OnboardingActivity.access$100(this$0, val$widget.getTrackingToken());
      this$0.moveToNextLegoWidget();
      return;
    }
    if (i == 4)
    {
      OnboardingActivity.access$100(this$0, val$widget.getTrackingToken());
      this$0.moveToNextLegoWidget();
      return;
    }
    OnboardingActivity.access$200(this$0, val$widgetId, val$widget);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */