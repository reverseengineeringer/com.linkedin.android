package com.linkedin.android.growth.boost.splash;

import android.support.v4.app.Fragment;
import com.linkedin.android.growth.lego.SingleFragmentLegoWidget;

public final class BoostSplashLegoWidget
  extends SingleFragmentLegoWidget
{
  public final Fragment getLandingFragment()
  {
    return new BoostSplashFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.splash.BoostSplashLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */