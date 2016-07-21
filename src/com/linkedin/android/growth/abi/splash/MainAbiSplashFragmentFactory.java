package com.linkedin.android.growth.abi.splash;

import android.support.v4.app.Fragment;
import com.linkedin.android.growth.abi.AbiIntentBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class MainAbiSplashFragmentFactory
  extends FragmentFactory<AbiIntentBundle>
{
  protected final Fragment provideFragment()
  {
    return new MainAbiSplashFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */