package com.linkedin.android.growth.onboarding.abi;

import android.support.v4.app.Fragment;
import com.linkedin.android.growth.lego.SingleFragmentLegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingPlaceholderFragment;

public final class OnboardingAbiM2GLegoWidget
  extends SingleFragmentLegoWidget
{
  public final Fragment getLandingFragment()
  {
    return OnboardingPlaceholderFragment.newInstance("ABI M2G");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.OnboardingAbiM2GLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */