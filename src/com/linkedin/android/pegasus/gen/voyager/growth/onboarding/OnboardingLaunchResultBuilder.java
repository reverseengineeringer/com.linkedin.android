package com.linkedin.android.pegasus.gen.voyager.growth.onboarding;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class OnboardingLaunchResultBuilder
  implements FissileDataModelBuilder<OnboardingLaunchResult>, DataTemplateBuilder<OnboardingLaunchResult>
{
  public static final OnboardingLaunchResultBuilder INSTANCE = new OnboardingLaunchResultBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("launchOnboarding");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.onboarding.OnboardingLaunchResultBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */