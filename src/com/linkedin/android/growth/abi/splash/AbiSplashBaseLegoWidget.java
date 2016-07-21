package com.linkedin.android.growth.abi.splash;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.growth.abi.AbiLoadContactsFragment;
import com.linkedin.android.growth.lego.LegoFlowNavigation;
import com.linkedin.android.growth.lego.MultiFragmentLegoWidget;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import java.util.Set;

public abstract class AbiSplashBaseLegoWidget
  extends MultiFragmentLegoWidget
{
  public final void finishCurrentFragment()
  {
    getChildFragmentManager().popBackStack();
    legoNavigator.moveToNextLegoWidget();
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    super.onRequestPermissionsResult(paramSet1, paramSet2);
    Fragment localFragment = getChildFragmentManager().findFragmentByTag("load_contacts");
    if ((localFragment instanceof AbiLoadContactsFragment)) {
      ((BaseFragment)localFragment).onRequestPermissionsResult(paramSet1, paramSet2);
    }
  }
  
  public final void showLearnMoreFragment()
  {
    currentFragmentTag = "learn_more";
    switchCurrentFragment(fragmentRegistry.abiLearnMore.newFragment(new DefaultBundle()), true, currentFragmentTag);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiSplashBaseLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */