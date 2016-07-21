package com.linkedin.android.growth.onboarding.welcome_mat;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class WelcomeMatFragmentFactory
  extends FragmentFactory<DefaultBundle>
{
  public final Fragment provideFragment()
  {
    return new WelcomeMatFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */