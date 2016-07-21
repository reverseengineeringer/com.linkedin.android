package com.linkedin.android.growth.onboarding.pymk;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class PymkFragmentFactory
  extends FragmentFactory<DefaultBundle>
{
  protected final Fragment provideFragment()
  {
    return new PymkFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.pymk.PymkFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */