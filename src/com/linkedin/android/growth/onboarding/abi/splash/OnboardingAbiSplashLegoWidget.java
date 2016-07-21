package com.linkedin.android.growth.onboarding.abi.splash;

import android.support.v4.app.Fragment;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseLegoWidget;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentRegistry;

public final class OnboardingAbiSplashLegoWidget
  extends AbiSplashBaseLegoWidget
{
  public final Fragment getLandingFragment()
  {
    currentFragmentTag = "abi_splash_onboarding";
    return fragmentRegistry.abiSplashOnboarding.newFragment(new DefaultBundle());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */