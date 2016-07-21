package com.linkedin.android.growth.abi.splash;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class AbiLearnMoreFragmentFractory
  extends FragmentFactory<DefaultBundle>
{
  protected final Fragment provideFragment()
  {
    return new AbiLearnMoreFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiLearnMoreFragmentFractory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */