package com.linkedin.android.growth.abi.splash;

import android.view.View;
import com.linkedin.android.growth.abi.AbiLoadContactsFragmentFactory;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class AbiSplashBaseFragment$1
  extends TrackingOnClickListener
{
  AbiSplashBaseFragment$1(AbiSplashBaseFragment paramAbiSplashBaseFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    AbiSplashBaseFragment.access$000(this$0);
    paramView = this$0.abiSplashLegoWidget;
    currentFragmentTag = "load_contacts";
    paramView.switchCurrentFragment(fragmentRegistry.abiLoadContacts.newFragment(new DefaultBundle()), true, currentFragmentTag);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiSplashBaseFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */