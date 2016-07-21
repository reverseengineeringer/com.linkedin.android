package com.linkedin.android.identity.profile.view.connections;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class ConnectionsContainerFragment
  extends PageFragment
{
  @InjectView(2131757906)
  ViewPager pager;
  private String profileId;
  private ProfileViewListener profileViewListener;
  private List<ScreenElement> screenElements;
  @InjectView(2131757905)
  TabLayout tabLayout;
  @InjectView(2131757904)
  Toolbar toolbar;
  
  public static ConnectionsContainerFragment newInstance(ConnectionsContainerFragmentBundleBuilder paramConnectionsContainerFragmentBundleBuilder)
  {
    ConnectionsContainerFragment localConnectionsContainerFragment = new ConnectionsContainerFragment();
    localConnectionsContainerFragment.setArguments(paramConnectionsContainerFragmentBundleBuilder.build());
    return localConnectionsContainerFragment;
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if ((profileId != null) && (fragmentComponent.memberUtil().isSelf(profileId))) {}
    for (String str = "profile_view_self_connections_container";; str = "profile_view_connections_container")
    {
      delayedExecution.postExecution(ProfileViewUtils.getPageViewEventRunnable(tracker, str));
      return;
    }
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    if (screenElements == null)
    {
      screenElements = new ArrayList();
      screenElements.add(pager);
    }
    return screenElements;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeActivity)) {
      profileViewListener = new ProfileViewListenerImpl((HomeActivity)paramActivity);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    profileId = ConnectionsContainerFragmentBundleBuilder.getProfileId(getArguments());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969254, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    toolbar.setNavigationOnClickListener(new ConnectionsContainerFragment.1(this));
    paramView = getArguments();
    toolbar.setTitle(paramView.getString("toolbarTitle", ""));
    int i = paramView.getInt("allConnectionsCount", 0);
    int j = paramView.getInt("commonConnectionsCount", 0);
    int k = paramView.getInt("tabDisplayMode", 2);
    int m = paramView.getInt("activeTab", 0);
    paramView = new ConnectionsContainerFragment.ViewPagerAdapter(this, getChildFragmentManager(), k, i, j);
    pager.setAdapter(paramView);
    tabLayout.setupWithViewPager$4740f1a6(pager, 0, 0, null);
    if (k == 2)
    {
      tabLayout.setVisibility(0);
      if (m == 0)
      {
        pager.setCurrentItem(1);
        return;
      }
      pager.setCurrentItem(0);
      return;
    }
    tabLayout.setVisibility(8);
  }
  
  public final String pageKey()
  {
    return "profile_view_base_connections_container";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.connections.ConnectionsContainerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */