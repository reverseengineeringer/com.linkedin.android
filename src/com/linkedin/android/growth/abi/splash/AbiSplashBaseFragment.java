package com.linkedin.android.growth.abi.splash;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.growth.abi.AbiLoadContactsFragmentFactory;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import javax.inject.Inject;

public abstract class AbiSplashBaseFragment
  extends LegoFragment
{
  public AbiSplashBaseLegoWidget abiSplashLegoWidget;
  @InjectView(2131755958)
  Button continueButton;
  @Inject
  FragmentManager fragmentManager;
  @Inject
  FragmentRegistry fragmentRegistry;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    fragmentComponent.inject(this);
    super.onViewCreated(paramView, paramBundle);
    abiSplashLegoWidget = ((AbiSplashBaseLegoWidget)legoWidget);
    continueButton.setOnClickListener(new TrackingOnClickListener(tracker, "continue", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        trackLegoWidgetPrimaryAction();
        paramAnonymousView = abiSplashLegoWidget;
        currentFragmentTag = "load_contacts";
        paramAnonymousView.switchCurrentFragment(fragmentRegistry.abiLoadContacts.newFragment(new DefaultBundle()), true, currentFragmentTag);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiSplashBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */