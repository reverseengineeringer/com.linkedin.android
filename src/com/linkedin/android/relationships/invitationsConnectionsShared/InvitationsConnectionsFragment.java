package com.linkedin.android.relationships.invitationsConnectionsShared;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import com.linkedin.android.relationships.RelationshipsSecondaryBaseFragment;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.messengerlib.ui.animation.ScrollAwareFABBehavior;
import java.util.ArrayList;
import java.util.List;

public class InvitationsConnectionsFragment
  extends RelationshipsSecondaryBaseFragment
{
  @InjectView(2131758356)
  FloatingActionButton floatingActionButton;
  private InvitationsConnectionsBundleBuilder.Actions fragmentAction = InvitationsConnectionsBundleBuilder.Actions.INVITATIONS_CONNECTIONS;
  private List<ScreenElement> screenElements;
  @InjectView(2131758354)
  TabLayout tabLayout;
  @InjectView(2131758355)
  ViewPager viewPager;
  
  public final List<ScreenElement> getScreenElements()
  {
    if (screenElements == null)
    {
      screenElements = new ArrayList();
      screenElements.add(viewPager);
    }
    return screenElements;
  }
  
  protected final int getTitleRes()
  {
    switch (InvitationsConnectionsFragment.2.$SwitchMap$com$linkedin$android$relationships$invitationsConnectionsShared$InvitationsConnectionsBundleBuilder$Actions[fragmentAction.ordinal()])
    {
    default: 
      return 0;
    case 1: 
      return 2131233394;
    }
    return 2131233434;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969360, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    paramBundle = getArguments();
    fragmentAction = InvitationsConnectionsBundleBuilder.getAction(paramBundle);
    ViewPager localViewPager = viewPager;
    paramView = fragmentComponent.lixManager();
    switch (InvitationsConnectionsFragment.2.$SwitchMap$com$linkedin$android$relationships$invitationsConnectionsShared$InvitationsConnectionsBundleBuilder$Actions[fragmentAction.ordinal()])
    {
    default: 
      paramView = new InvitationsConnectionsPagerAdapter(getChildFragmentManager(), getActivity(), paramView);
      localViewPager.setAdapter(paramView);
      tabLayout.setSelectedTabIndicatorColor(getResources().getColor(2131624058));
      tabLayout.setupWithViewPager$4740f1a6(viewPager, 0, 0, null);
      if (InvitationsConnectionsBundleBuilder.Actions.CONNECTIONS == fragmentAction) {
        if (fragmentComponent.homeCachedLix().isNavV2PropsInNotifications()) {
          break label335;
        }
      }
      break;
    }
    label335:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramView = (CoordinatorLayout.LayoutParams)floatingActionButton.getLayoutParams();
        paramView.setBehavior(new ScrollAwareFABBehavior());
        floatingActionButton.setLayoutParams(paramView);
        floatingActionButton.setVisibility(0);
        floatingActionButton.setOnClickListener(new InvitationsConnectionsFragment.1(this, fragmentComponent.tracker(), "add_connections", new TrackingEventBuilder[0]));
      }
      getActivity().findViewById(2131758354).setVisibility(8);
      if (fragmentAction == InvitationsConnectionsBundleBuilder.Actions.INVITATIONS_CONNECTIONS) {
        viewPager.setCurrentItem(InvitationsConnectionsBundleBuilder.getActiveTab(paramBundle));
      }
      return;
      paramView = new ConnectionsPagerAdapter(getChildFragmentManager(), getActivity(), paramView);
      break;
      paramView = new InvitationsPagerAdapter(getChildFragmentManager(), getActivity(), getArguments());
      break;
      paramView = new InvitationsConnectionsPagerAdapter(getChildFragmentManager(), getActivity(), paramView);
      break;
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
  
  public final boolean shouldTrackRUM()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.invitationsConnectionsShared.InvitationsConnectionsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */