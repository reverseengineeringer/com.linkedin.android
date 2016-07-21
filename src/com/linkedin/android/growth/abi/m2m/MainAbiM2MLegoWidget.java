package com.linkedin.android.growth.abi.m2m;

import android.support.v4.app.Fragment;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.lego.SingleFragmentLegoWidget;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.components.ActivityComponent;

public final class MainAbiM2MLegoWidget
  extends SingleFragmentLegoWidget
{
  public final Fragment getLandingFragment()
  {
    return fragmentRegistry.abiM2MMain.newFragment(new DefaultBundle());
  }
  
  public final int getStatus(ActivityComponent paramActivityComponent)
  {
    if (paramActivityComponent.abiDataProvider().hasMemberContact()) {
      return 3;
    }
    return 2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2m.MainAbiM2MLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */