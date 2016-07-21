package com.linkedin.android.growth.onboarding.greeting;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class GreetingFragmentFactory
  extends FragmentFactory<GreetingBundle>
{
  public final Fragment provideFragment()
  {
    return new GreetingFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.greeting.GreetingFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */