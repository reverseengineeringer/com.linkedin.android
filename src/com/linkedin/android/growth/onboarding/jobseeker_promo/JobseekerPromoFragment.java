package com.linkedin.android.growth.onboarding.jobseeker_promo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingTransformer.4;
import com.linkedin.android.growth.onboarding.OnboardingTransformer.5;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import javax.inject.Inject;

public final class JobseekerPromoFragment
  extends LegoFragment
{
  @Inject
  MediaCenter mediaCenter;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968836, paramViewGroup, false);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    paramView = (JobseekerPromoFragmentViewHolder)JobseekerPromoFragmentViewHolder.CREATOR.createViewHolder(paramView);
    FragmentActivity localFragmentActivity = getActivity();
    LegoWidget localLegoWidget = legoWidget;
    LegoTrackingDataProvider localLegoTrackingDataProvider = legoTrackingDataProvider;
    Tracker localTracker = tracker;
    JobseekerPromoFragmentViewModel localJobseekerPromoFragmentViewModel = new JobseekerPromoFragmentViewModel();
    topButtonClickListener = new OnboardingTransformer.4(localLegoWidget.getTrackingToken(), ActionCategory.PRIMARY_ACTION, localLegoTrackingDataProvider, localTracker, "get_the_app", new TrackingEventBuilder[0], localFragmentActivity);
    bottomButtonClickListener = new OnboardingTransformer.5(localLegoWidget.getTrackingToken(), ActionCategory.SKIP, localLegoTrackingDataProvider, localTracker, "continue", new TrackingEventBuilder[0], localLegoWidget);
    getLayoutInflater(paramBundle);
    localJobseekerPromoFragmentViewModel.onBindViewHolder$1d58125f(paramView);
  }
  
  public final String pageKey()
  {
    return "onboarding_gta_jsa";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.jobseeker_promo.JobseekerPromoFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */