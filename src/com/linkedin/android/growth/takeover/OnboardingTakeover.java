package com.linkedin.android.growth.takeover;

import android.os.Bundle;
import com.linkedin.android.growth.onboarding.OnboardingBundleBuilder;
import com.linkedin.android.growth.onboarding.OnboardingIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;

public final class OnboardingTakeover
  extends TakeoverLauncher
{
  public OnboardingTakeover(Takeover paramTakeover)
  {
    super(paramTakeover);
  }
  
  public final void launch(BaseActivity paramBaseActivity, IntentRegistry paramIntentRegistry)
  {
    paramIntentRegistry = onboarding;
    OnboardingBundleBuilder localOnboardingBundleBuilder = new OnboardingBundleBuilder();
    String str = takeover.legoTrackingToken;
    bundle.putString("lapseOnboardingLegoToken", str);
    paramBaseActivity.startActivity(paramIntentRegistry.newIntent(paramBaseActivity, localOnboardingBundleBuilder));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.OnboardingTakeover
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */