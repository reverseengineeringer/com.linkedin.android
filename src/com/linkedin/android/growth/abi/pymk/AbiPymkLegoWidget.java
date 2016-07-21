package com.linkedin.android.growth.abi.pymk;

import android.support.v4.app.Fragment;
import com.linkedin.android.growth.lego.SingleFragmentLegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingPlaceholderFragment;

public final class AbiPymkLegoWidget
  extends SingleFragmentLegoWidget
{
  public final Fragment getLandingFragment()
  {
    return OnboardingPlaceholderFragment.newInstance("ABI PYMK");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.pymk.AbiPymkLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */