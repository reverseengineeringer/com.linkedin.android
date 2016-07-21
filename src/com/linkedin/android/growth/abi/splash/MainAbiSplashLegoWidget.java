package com.linkedin.android.growth.abi.splash;

import android.support.v4.app.Fragment;
import com.linkedin.android.growth.abi.AbiIntentBundle;
import com.linkedin.android.infra.FragmentRegistry;

public final class MainAbiSplashLegoWidget
  extends AbiSplashBaseLegoWidget
{
  public final Fragment getLandingFragment()
  {
    currentFragmentTag = "abi_splash_main";
    return fragmentRegistry.abiSplashMain.newFragment(new AbiIntentBundle(getArguments()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */