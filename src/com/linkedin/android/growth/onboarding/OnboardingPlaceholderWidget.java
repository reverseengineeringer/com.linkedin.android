package com.linkedin.android.growth.onboarding;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import com.linkedin.android.growth.lego.SingleFragmentLegoWidget;

@SuppressLint({"ValidFragment"})
public final class OnboardingPlaceholderWidget
  extends SingleFragmentLegoWidget
{
  public final Fragment getLandingFragment()
  {
    return new OnboardingPlaceholderFragment("Placeholder");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingPlaceholderWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */