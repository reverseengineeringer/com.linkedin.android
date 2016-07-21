package com.linkedin.android.growth.newtovoyager.organic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class NewToVoyagerIntroFragment
  extends PageFragment
{
  @InjectView(2131756061)
  HorizontalViewPagerCarousel carousel;
  @Inject
  LegoTrackingDataProvider legoTrackingDataProvider;
  @InjectView(2131756060)
  ViewPager viewPager;
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968824, paramViewGroup, false);
  }
  
  @Subscribe
  public void onEvent(NewToVoyagerIntroWelcomeFragment.NewToVoyagerSkipEvent paramNewToVoyagerSkipEvent)
  {
    paramNewToVoyagerSkipEvent = getArguments().getString("legoTrackingTokenKey");
    if (paramNewToVoyagerSkipEvent != null) {
      legoTrackingDataProvider.sendActionEvent$67c7f505(paramNewToVoyagerSkipEvent, ActionCategory.SKIP);
    }
  }
  
  public void onViewCreated(View paramView, final Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    paramView = new NewToVoyagerIntroPagerAdapter(getFragmentManager());
    paramBundle = new NewToVoyagerIntroPageChangeListener(fragmentComponent, paramView);
    viewPager.addOnPageChangeListener(paramBundle);
    viewPager.setAdapter(paramView);
    viewPager.post(new Runnable()
    {
      public final void run()
      {
        if (viewPager != null) {
          paramBundle.onPageSelected(viewPager.getCurrentItem());
        }
      }
    });
    carousel.setViewPager(viewPager);
    paramView = getArguments().getString("legoTrackingTokenKey");
    if (paramView != null) {
      legoTrackingDataProvider.sendWidgetImpressionEvent$4bb724c7(paramView, Visibility.SHOW);
    }
  }
  
  public final String pageKey()
  {
    return "";
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */