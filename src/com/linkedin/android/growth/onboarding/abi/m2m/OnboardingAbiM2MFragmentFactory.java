package com.linkedin.android.growth.onboarding.abi.m2m;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class OnboardingAbiM2MFragmentFactory
  extends FragmentFactory<DefaultBundle>
{
  protected final Fragment provideFragment()
  {
    return new OnboardingAbiM2MFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2m.OnboardingAbiM2MFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */