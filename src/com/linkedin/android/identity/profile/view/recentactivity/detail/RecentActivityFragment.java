package com.linkedin.android.identity.profile.view.recentactivity.detail;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.profile.ProfileViewActivity;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.profile.view.ProfileViewTransformer;
import com.linkedin.android.identity.profile.view.topcard.events.ProfileFollowEvent;
import com.linkedin.android.identity.profile.view.topcard.events.UnfollowEvent;
import com.linkedin.android.identity.shared.MiniProfileOnClickListener;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;

public class RecentActivityFragment
  extends PageFragment
{
  private static final int[] DEFAULT_LIST = { 2131233266, 2131233264 };
  private static final int[] INTERESTS_LIST = { 2131233266, 2131233264, 2131233233 };
  private static final int[] SHARES_AND_INTERESTS_LIST = { 2131233266, 2131233267, 2131233233, 2131233264 };
  private static final int[] SHARES_LIST = { 2131233266, 2131233267, 2131233264 };
  @InjectView(2131757976)
  LinearLayout header;
  private ProfileDataProvider profileDataProvider;
  private String profileId;
  private ProfileViewListener profileViewListener;
  @InjectView(2131758048)
  TabLayout tabLayout;
  @InjectView(2131758047)
  Toolbar toolbar;
  @InjectView(2131758049)
  ViewPager viewPager;
  
  public static RecentActivityFragment newInstance(Bundle paramBundle)
  {
    RecentActivityFragment localRecentActivityFragment = new RecentActivityFragment();
    localRecentActivityFragment.setArguments(paramBundle);
    return localRecentActivityFragment;
  }
  
  private void setupHeader(Profile paramProfile, ProfileNetworkInfo paramProfileNetworkInfo)
  {
    boolean bool2 = true;
    if (paramProfile == null)
    {
      header.setVisibility(8);
      return;
    }
    RecentActivityHeaderViewHolder localRecentActivityHeaderViewHolder = new RecentActivityHeaderViewHolder(header);
    paramProfile = miniProfile;
    FragmentComponent localFragmentComponent = fragmentComponent;
    RecentActivityHeaderViewModel localRecentActivityHeaderViewModel = new RecentActivityHeaderViewModel();
    I18NManager localI18NManager = localFragmentComponent.i18NManager();
    profileImage = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, paramProfile), Util.retrieveRumSessionId(localFragmentComponent));
    name = ProfileViewTransformer.getFormattedFullName(paramProfile, localI18NManager);
    int i;
    boolean bool1;
    if (paramProfileNetworkInfo != null)
    {
      followerCount = localI18NManager.getString(2131233269, new Object[] { Long.valueOf(followersCount) });
      if (distance.value == GraphDistance.SELF)
      {
        i = 1;
        if (!hasFollowingInfo) {
          break label292;
        }
        bool1 = followingInfo.following;
        label158:
        isFollowing = bool1;
        if ((i != 0) || (!followable)) {
          break label301;
        }
        label176:
        isFollowable = bool2;
        if ((i != 0) || (!bool1)) {
          break label307;
        }
        followToggleListener = new RecentActivityDetailTransformer.1(localFragmentComponent.tracker(), "unfollow", new TrackingEventBuilder[0], localFragmentComponent);
      }
    }
    else
    {
      label219:
      if (!(localFragmentComponent.activity() instanceof ProfileViewActivity)) {
        break label342;
      }
    }
    label292:
    label301:
    label307:
    label342:
    for (profileImageClickListener = new RecentActivityDetailTransformer.3(localFragmentComponent.tracker(), "recent_activity_header_clicked", new TrackingEventBuilder[0], localFragmentComponent);; profileImageClickListener = new MiniProfileOnClickListener(paramProfile, localFragmentComponent, "recent_activity_header_clicked", new TrackingEventBuilder[0]))
    {
      LayoutInflater.from(header.getContext());
      localRecentActivityHeaderViewModel.onBindViewHolder$516120e4(applicationComponent.mediaCenter(), localRecentActivityHeaderViewHolder);
      return;
      i = 0;
      break;
      bool1 = following;
      break label158;
      bool2 = false;
      break label176;
      if (i != 0) {
        break label219;
      }
      followToggleListener = new RecentActivityDetailTransformer.2(localFragmentComponent.tracker(), "follow", new TrackingEventBuilder[0], localFragmentComponent);
      break label219;
    }
  }
  
  private void setupTabs(int paramInt)
  {
    RecentActivityFragment.PagerAdapter localPagerAdapter = new RecentActivityFragment.PagerAdapter(this, getChildFragmentManager(), getContext());
    viewPager.setAdapter(localPagerAdapter);
    tabLayout.setupWithViewPager$4740f1a6(viewPager, 0, 0, null);
    viewPager.setCurrentItem(paramInt);
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if ((profileId != null) && (fragmentComponent.memberUtil().isSelf(profileId))) {}
    for (String str = "profile_self_recent_activity_container";; str = "profile_view_recent_activity_container")
    {
      delayedExecution.postExecution(ProfileViewUtils.getPageViewEventRunnable(tracker, str));
      return;
    }
  }
  
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
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeActivity)) {
      profileViewListener = new ProfileViewListenerImpl((HomeActivity)paramActivity);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969289, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException) {}
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    int j = 0;
    setupHeader(profileDataProvider.getProfileModel(), profileDataProvider.getNetworkInfoModel());
    int i = j;
    if (paramSet != null)
    {
      if (profileId != null) {
        break label61;
      }
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        setupTabs(getArguments().getInt("activeTab", 1));
      }
      return;
      label61:
      paramType = ProfileRoutes.buildProfileViewRoute(profileId).toString();
      paramMap = ProfileRoutes.buildProfileRoute(profileId).toString();
      if (!paramSet.contains(paramType))
      {
        i = j;
        if (!paramSet.contains(paramMap)) {}
      }
      else
      {
        i = 1;
      }
    }
  }
  
  @Subscribe
  public void onEvent(ProfileFollowEvent paramProfileFollowEvent)
  {
    if (profileId != null)
    {
      ProfileDataProvider localProfileDataProvider = profileDataProvider;
      String str1 = busSubscriberId;
      String str2 = getRumSessionId();
      String str3 = profileId;
      boolean bool = fetchNetworkInfo;
      paramProfileFollowEvent = Tracker.createPageInstanceHeader(getPageInstance());
      getContext();
      localProfileDataProvider.followMember$4543a37c(str1, str2, str3, bool, paramProfileFollowEvent);
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Cannot follow. Profile ID null"));
  }
  
  @Subscribe
  public void onEvent(UnfollowEvent paramUnfollowEvent)
  {
    if (profileId != null)
    {
      ProfileDataProvider localProfileDataProvider = profileDataProvider;
      String str1 = busSubscriberId;
      String str2 = getRumSessionId();
      String str3 = profileId;
      boolean bool = fetchNetworkInfo;
      paramUnfollowEvent = Tracker.createPageInstanceHeader(getPageInstance());
      getContext();
      localProfileDataProvider.unFollowMember$4543a37c(str1, str2, str3, bool, paramUnfollowEvent);
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Cannot unfollow. Profile ID null"));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    int i = 1;
    super.onViewCreated(paramView, paramBundle);
    toolbar.setNavigationOnClickListener(new RecentActivityFragment.1(this));
    toolbar.setTitle(2131233271);
    profileId = getArguments().getString("profileId");
    int j = getArguments().getInt("activeTab", 1);
    if (profileId == null)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Fragment cannot be created without a profileId in the bundle"));
    }
    do
    {
      return;
      profileDataProvider = fragmentComponent.activity().activityComponent.profileDataProvider();
    } while (profileDataProvider == null);
    paramView = profileDataProvider;
    if ((paramView.isDataAvailable()) && (paramView.getNetworkInfoModel() != null)) {}
    while (i != 0)
    {
      setupHeader(profileDataProvider.getProfileModel(), profileDataProvider.getNetworkInfoModel());
      setupTabs(j);
      return;
      i = 0;
    }
    paramView = profileDataProvider;
    paramBundle = busSubscriberId;
    String str = getRumSessionId();
    Object localObject = profileId;
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    state).profileViewRoute = ProfileRoutes.buildProfileViewRoute((String)localObject).toString();
    state).profileRoute = ProfileRoutes.buildProfileRoute((String)localObject).toString();
    state).networkInfoRoute = ProfileRoutes.buildNetworkInfoRoute((String)localObject).toString();
    localObject = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    localObject = ((MultiplexRequest.Builder)localObject).optional(Request.get().url(state).networkInfoRoute).builder(ProfileNetworkInfo.BUILDER));
    if (profileViewApiEnabled) {
      ((MultiplexRequest.Builder)localObject).required(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
    }
    for (;;)
    {
      paramView.performMultiplexedFetch(paramBundle, str, localMap, (MultiplexRequest.Builder)localObject);
      return;
      ((MultiplexRequest.Builder)localObject).required(Request.get().url(state).profileRoute).builder(Profile.BUILDER));
    }
  }
  
  public final String pageKey()
  {
    return "profile_view_base_recent_activity_container";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.recentactivity.detail.RecentActivityFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */