package com.linkedin.android.growth.onboarding.abi.splash;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.growth.abi.AbiDataProvider.AbiState;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseFragment;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseLegoWidget;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.growth.lego.LegoFlowNavigation;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public class OnboardingAbiSplashFragment
  extends AbiSplashBaseFragment
{
  @InjectView(2131755965)
  View container;
  @InjectView(2131755960)
  TextView learnMoreText;
  @InjectView(2131756079)
  Button skipButton;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968831, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    skipButton.setOnClickListener(new LegoActionTrackingOnClickListener(legoWidget.getTrackingToken(), ActionCategory.SKIP, legoTrackingDataProvider, tracker, "skip", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = legoWidget;
        if (!stopped)
        {
          while (paramAnonymousView.getChildFragmentManager().popBackStackImmediate()) {}
          legoNavigator.moveToNextGroupLegoWidget();
        }
      }
    });
    container.setOnClickListener(new TrackingOnClickListener(tracker, "learn_more", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        abiSplashLegoWidget.showLearnMoreFragment();
      }
    });
    learnMoreText.setTypeface(null, 1);
    paramView = OwlTrackingUtils.trackAbookImportImpressionEvent(tracker, fragmentComponent.lixManager(), "mobile-voyager-onboarding");
    getActivityactivityComponent.abiDataProvider().state).abookImportTransactionId = paramView;
  }
  
  public final String pageKey()
  {
    return "onboarding_abi";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */