package com.linkedin.android.growth.onboarding.abi.m2g;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class OnboardingAbiM2GEmailFragmentFactory
  extends FragmentFactory<DefaultBundle>
{
  protected final Fragment provideFragment()
  {
    return new OnboardingAbiM2GEmailFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GEmailFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */