package com.linkedin.android.growth.newtovoyager.banner;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public final class NewToVoyagerFeedFragment
  extends ViewPagerFragment
{
  private NewToVoyagerFeedCardViewModel viewModel;
  
  public final void doEnter()
  {
    super.doEnter();
    if ((viewModel != null) && (!TextUtils.isEmpty(viewModel.legoTrackingToken))) {
      NewToVoyagerBannerViewTransformer.sendLegoWidgetImpressionEvent(fragmentComponent, viewModel.legoTrackingToken);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    boolean bool = true;
    super.onConfigurationChanged(paramConfiguration);
    NewToVoyagerFeedCardViewModel localNewToVoyagerFeedCardViewModel = viewModel;
    if (orientation == 1) {}
    for (;;)
    {
      localNewToVoyagerFeedCardViewModel.showHideFeedPromoImage(bool);
      return;
      bool = false;
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968820, paramViewGroup, false);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    LayoutInflater.from(getContext());
    paramBundle = getArguments().getString("legoTrackingTokenKey");
    FragmentComponent localFragmentComponent = fragmentComponent;
    NewToVoyagerFeedCardViewModel localNewToVoyagerFeedCardViewModel = new NewToVoyagerFeedCardViewModel();
    heading = localFragmentComponent.i18NManager().getString(2131231452);
    legoTrackingToken = paramBundle;
    continueButtonOnClickListener = new NewToVoyagerBannerViewTransformer.3(localFragmentComponent.tracker(), "continue", new TrackingEventBuilder[0], localNewToVoyagerFeedCardViewModel, localFragmentComponent);
    notNowButtonOnClickListener = new NewToVoyagerBannerViewTransformer.4(localFragmentComponent.tracker(), "not_now", new TrackingEventBuilder[0], localNewToVoyagerFeedCardViewModel, localFragmentComponent);
    viewModel = localNewToVoyagerFeedCardViewModel;
    paramView = (NewToVoyagerFeedCardViewHolder)NewToVoyagerFeedCardViewHolder.CREATOR.createViewHolder(paramView);
    paramBundle = viewModel;
    applicationComponent.mediaCenter();
    paramBundle.onBindViewHolder$24bfd94d(paramView);
    paramView = viewModel;
    if (getResourcesgetConfigurationorientation == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.showHideFeedPromoImage(bool);
      return;
    }
  }
  
  public final String pageKey()
  {
    return "feed_splash";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */