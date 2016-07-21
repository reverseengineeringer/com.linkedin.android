package com.linkedin.android.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.appwidget.ResponsiveWidget;
import com.linkedin.android.axle.SplashPromoInflater;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.growth.abi.AbiAutoSyncToast.2;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.abi.AbiDataProvider.AbiState;
import com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedDismissEvent;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedBundleBuilder;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedIntent;
import com.linkedin.android.home.badging.AggregatedBadgeUpdateEvent;
import com.linkedin.android.home.badging.BadgeCountRunnable;
import com.linkedin.android.home.badging.BadgeUpdateEvent;
import com.linkedin.android.home.launcher.AppLauncher;
import com.linkedin.android.home.launcher.AppLauncher.1;
import com.linkedin.android.home.launcher.AppLauncher.2;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.PushNotificationReceivedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.AppUniverse;
import com.linkedin.android.pegasus.gen.voyager.common.BadgeCount;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.consistency.DefaultConsistencyListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class HomeFragment
  extends PageFragment
  implements OnBackPressedListener
{
  public static final String TAG = HomeFragment.class.getSimpleName();
  private HomePagerAdapter adapter;
  @InjectView(2131756472)
  @Optional
  AppBarLayout appBarLayout;
  private int appBarLayoutOffset;
  private AppLauncher appLauncher;
  private final Handler badgeRefreshHandler = new Handler(Looper.getMainLooper());
  private HomeFragmentDataProvider dataProvider;
  @Inject
  Bus eventBus;
  private final HomeFragment.FinishAdapterUpdatesRunnable finishAdapterUpdates = new HomeFragment.FinishAdapterUpdatesRunnable(this, (byte)0);
  @Inject
  HomeCachedLix homeCachedLix;
  private boolean isDogfoodSplashDisplayed;
  private boolean isOpenSearchBar40;
  private HomeTabInfo lastTab;
  private final List<WeakReference<View>> navBarTranslationUpdateViewRefs = new ArrayList();
  private boolean openSearchBar;
  private final Handler pagerAdapterUpdateHandler = new Handler(Looper.getMainLooper());
  private BadgeCountRunnable refreshBadgeCounts;
  private List<ScreenElement> screenElements;
  @InjectView(2131758545)
  @Optional
  View searchBarDivider;
  @InjectView(2131756483)
  @Optional
  View searchBarDividerHorizontal;
  @InjectView(2131756474)
  @Optional
  View searchBarInFeed;
  @InjectView(2131756476)
  @Optional
  View searchBarInOthers;
  @InjectView(2131756477)
  @Optional
  TextView searchBarTitle;
  @InjectView(2131755145)
  @Optional
  View searchBox;
  @InjectView(2131755328)
  @Optional
  TextView searchBoxText;
  @InjectView(2131756478)
  @Optional
  View searchLaunchIcon;
  @InjectView(2131756479)
  TabLayout tabStrip;
  List<HomeTabInfo> tabs;
  private final Map<Integer, TrackingOnClickListener> trackingOnClickListenerMap = new ArrayMap();
  @InjectView(2131756480)
  ViewPager viewPager;
  private TrackingOnClickListener viewPagerTrackingOnClickListener;
  
  private void clearBadge(HomeTabInfo paramHomeTabInfo)
  {
    if ((HomeFragmentDataProvider.shouldAutoClearBadgeForTab(paramHomeTabInfo)) && (((HomeFragmentDataProvider.State)dataProvider.state).getBadgeCount(paramHomeTabInfo) != 0L)) {
      dataProvider.clearAllBadgeCount(paramHomeTabInfo, Tracker.createPageInstanceHeader(getPageInstance()), null);
    }
  }
  
  private void clearBadgesForTab(HomeTabInfo paramHomeTabInfo)
  {
    if (hasBadging) {
      clearBadge(paramHomeTabInfo);
    }
    if ((lastTab != null) && (lastTab.hasBadging)) {
      clearBadge(lastTab);
    }
    lastTab = paramHomeTabInfo;
  }
  
  private View.OnClickListener getOpenSearchBoxListener()
  {
    return new HomeFragment.4(this, tracker, "open_search_box", new TrackingEventBuilder[0]);
  }
  
  public static HomeFragment newInstance(Bundle paramBundle)
  {
    HomeFragment localHomeFragment = new HomeFragment();
    localHomeFragment.setArguments(paramBundle);
    return localHomeFragment;
  }
  
  private void setSearchBar(HomeTabInfo paramHomeTabInfo)
  {
    if ((searchBarInFeed == null) || (searchBarInOthers == null) || (searchLaunchIcon == null) || (searchBarTitle == null) || (searchBarDivider == null)) {}
    do
    {
      do
      {
        return;
        if (!openSearchBar) {
          break label155;
        }
        if (isOpenSearchBar40) {
          searchBarDivider.setVisibility(8);
        }
        if (paramHomeTabInfo != HomeTabInfo.MESSAGING) {
          break;
        }
        searchBarTitle.setText(MESSAGINGcontentDescriptionResId);
        searchBarInOthers.setVisibility(0);
        searchBarInFeed.setVisibility(8);
        searchLaunchIcon.setVisibility(8);
      } while (searchBarDividerHorizontal == null);
      searchBarDividerHorizontal.setVisibility(8);
      return;
      searchBarInFeed.setVisibility(0);
      searchBarInOthers.setVisibility(8);
    } while (searchBarDividerHorizontal == null);
    searchBarDividerHorizontal.setVisibility(0);
    return;
    label155:
    if (paramHomeTabInfo == HomeTabInfo.FEED)
    {
      searchBarInFeed.setVisibility(0);
      searchBarInOthers.setVisibility(8);
      return;
    }
    View localView = searchLaunchIcon;
    if (paramHomeTabInfo == HomeTabInfo.MESSAGING) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      searchBarInFeed.setVisibility(8);
      searchBarTitle.setText(contentDescriptionResId);
      searchBarInOthers.setVisibility(0);
      return;
    }
  }
  
  private void setupTabStripOnClickListeners(Tracker paramTracker)
  {
    viewPagerTrackingOnClickListener = new TrackingOnClickListener(paramTracker, "home_viewpager", new TrackingEventBuilder[0]);
    int i = 0;
    while (i < tabs.size())
    {
      HomeTabInfo localHomeTabInfo = (HomeTabInfo)tabs.get(i);
      trackingOnClickListenerMap.put(Integer.valueOf(i), new TrackingOnClickListener(paramTracker, trackingControlName, new TrackingEventBuilder[0]));
      i += 1;
    }
  }
  
  private void setupViewPagerInteractionTracking()
  {
    int i = 0;
    while (i < tabs.size())
    {
      Object localObject = (HomeTabInfo)tabs.get(i);
      ViewPager localViewPager = viewPager;
      localObject = trackingControlName;
      controlIdList.add(i, localObject);
      i += 1;
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    clearBadgesForTab(applicationComponent.flagshipSharedPreferences().getLastActiveTab());
    BadgeCountRunnable localBadgeCountRunnable = refreshBadgeCounts;
    running = false;
    badgeRefreshHandler.removeCallbacks(localBadgeCountRunnable);
  }
  
  public final void doResume()
  {
    super.doResume();
    Object localObject1 = ((HomeFragmentDataProvider.State)dataProvider.state).getUniverse();
    appLauncher.onResume((AppUniverse)localObject1);
    if ("enabled".equals(applicationComponent.lixManager().getTreatment(Lix.AXLE_BADGING_RELOAD_FIX))) {
      refreshBadgeCounts.run(true);
    }
    for (;;)
    {
      if (!"control".equalsIgnoreCase(applicationComponent.lixManager().getTreatment(Lix.LIX_ABI_AUTO_SYNC_TOAST)))
      {
        Object localObject2 = (BaseActivity)getActivity();
        localObject1 = getRumSessionId();
        Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
        if (applicationComponent.flagshipSharedPreferences().getPreferences().getBoolean("hasNewAutoSyncContactsToToast", false))
        {
          AbiDataProvider localAbiDataProvider = activityComponent.abiDataProvider();
          localObject2 = new AbiAutoSyncToast.2((BaseActivity)localObject2);
          Routes localRoutes = Routes.ABI_AUTOSYNC_TOAST;
          state).abiLegoToastRoute = localRoutes.buildUponRoot().buildUpon().toString();
          localObject2 = Request.get().url(state).abiLegoToastRoute).builder(PageContent.BUILDER).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
          ((Request.Builder)localObject2).customHeaders(localMap).trackingSessionId((String)localObject1);
          activityComponent.dataManager().submit((Request.Builder)localObject2);
        }
      }
      return;
      refreshBadgeCounts.run();
    }
  }
  
  final int getAdjacentPosition(boolean paramBoolean)
  {
    if (viewPager != null)
    {
      int j = viewPager.getCurrentItem();
      int k = tabs.size();
      if (paramBoolean) {}
      for (int i = 1;; i = -1)
      {
        j = (j + i) % k;
        i = j;
        if (j < 0) {
          i = j + k;
        }
        return i;
      }
    }
    return tabs.indexOf(HomeTabInfo.FEED);
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    if (screenElements == null)
    {
      screenElements = new ArrayList();
      screenElements.add(viewPager);
    }
    return screenElements;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = getChildFragmentManager().getFragments();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Fragment)((Iterator)localObject).next()).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    Object localObject = appLauncher;
    if (drawerLayout.isDrawerOpen$134632()) {
      drawerLayout.closeDrawer$13462e();
    }
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    i = tabs.indexOf(HomeTabInfo.FEED);
    localObject = (BaseActivity)getActivity();
    if ((viewPager.getCurrentItem() != i) && (localObject != null))
    {
      ((BaseActivity)localObject).fireBackPressedControlInteractionEvent();
      localObject = viewPager;
      backSelected = true;
      ((ViewPager)localObject).setCurrentItem(i);
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    openSearchBar = "enabled".equals(homeCachedLix.getTreatment(Lix.INFRA_NAV_V2_OPEN_SEARCH_BAR));
    paramBundle = homeCachedLix;
    if (("enabled".equals(paramBundle.getTreatment(Lix.INFRA_NAV_V2_OPEN_SEARCH_BAR))) && ("enabled".equals(paramBundle.getTreatment(Lix.INFRA_NAV_V2_OPEN_SEARCH_BAR_40)))) {}
    for (boolean bool = true;; bool = false)
    {
      isOpenSearchBar40 = bool;
      tabs = HomeTabInfo.TABS_V2;
      adapter = new HomePagerAdapter(getChildFragmentManager(), applicationComponent.fragmentRegistry(), tabs, homeCachedLix);
      dataProvider = fragmentComponent.homeFragmentDataProvider();
      dataProvider.state).tabs = tabs;
      paramBundle = dataProvider;
      Object localObject = busSubscriberId;
      String str = getRumSessionId();
      localObject = paramBundle.newModelListener((String)localObject, str);
      localObject = Request.get().url(HomeFragmentDataProvider.LAUCHER_URL).builder(AppUniverse.BUILDER).filter(DataManager.DataStoreFilter.ALL).listener((RecordTemplateListener)localObject);
      ((Request.Builder)localObject).trackingSessionId(str);
      activityComponent.dataManager().submit((Request.Builder)localObject);
      refreshBadgeCounts = new BadgeCountRunnable(badgeRefreshHandler, dataProvider, this, applicationComponent.lixManager());
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (isOpenSearchBar40) {}
    for (int i = 2130968915;; i = 2130968914) {
      return paramLayoutInflater.inflate(i, paramViewGroup, false);
    }
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramType == DataStore.Type.NETWORK) {
      Log.e(TAG, "Error fetching or clearing badge count: " + paramDataManagerException.getMessage());
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramType = dataProvider;
    paramSet = state).tabs;
    int i;
    if (paramSet != null)
    {
      paramSet = paramSet.iterator();
      for (;;)
      {
        if (paramSet.hasNext())
        {
          paramMap = (HomeTabInfo)paramSet.next();
          if ((hasBadging) && (((HomeFragmentDataProvider.State)state).getModel((String)state).tabToRouteMap.get(paramMap)) != null))
          {
            i = 1;
            if (i == 0) {
              break label380;
            }
            i = 0;
            label94:
            if (i >= tabs.size()) {
              break label251;
            }
            paramType = (HomeTabInfo)tabs.get(i);
            if (hasBadging)
            {
              paramSet = (HomeFragmentDataProvider.State)dataProvider.state;
              paramMap = (BadgeCount)paramSet.getModel((String)tabToRouteMap.get(paramType));
              if (paramMap == null) {
                break label245;
              }
              l = count;
              if (!hasBadging) {
                break label232;
              }
              badgeCounts.put(paramType, Long.valueOf(l));
            }
          }
        }
      }
    }
    label191:
    label232:
    label245:
    for (long l = paramSet.getBadgeCount(paramType);; l = 0L)
    {
      if (paramType != HomeTabInfo.FEED) {
        Bus.publish(BadgeUpdateEvent.createWithShouldNotUpdateOuterBadge(paramType, Long.valueOf(l)));
      }
      i += 1;
      break label94;
      i = 0;
      break;
      Log.e(HomeFragmentDataProvider.TAG, "Tried to set badge count for unsupported tab");
      break label191;
    }
    label251:
    Bus.publish(new AggregatedBadgeUpdateEvent());
    ResponsiveWidget.updateAllAppWidgets(getContext());
    paramType = (HomeFragmentDataProvider.State)dataProvider.state;
    paramSet = tabToRouteMap.values().iterator();
    while (paramSet.hasNext())
    {
      paramMap = (String)paramSet.next();
      if (errors.containsKey(paramMap)) {
        errors.remove(paramMap);
      }
      if (modelListenerMap.containsKey(paramMap))
      {
        DefaultConsistencyListener localDefaultConsistencyListener = (DefaultConsistencyListener)modelListenerMap.get(paramMap);
        dataManager.removeListener(localDefaultConsistencyListener);
        modelListenerMap.remove(paramMap);
      }
    }
    label380:
    paramType = ((HomeFragmentDataProvider.State)dataProvider.state).getUniverse();
    appLauncher.onResume(paramType);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Bus.unsubscribe(this);
    finishAdapterUpdates.stop();
  }
  
  @Subscribe
  public void onEvent(NewToVoyagerFeedDismissEvent paramNewToVoyagerFeedDismissEvent)
  {
    boolean bool = false;
    if (shouldOpenRbmf)
    {
      if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_FOLLOW_HUB))
      {
        FeedNavigationUtils.openFollowHub(fragmentComponent);
        return;
      }
      paramNewToVoyagerFeedDismissEvent = fragmentComponent.intentRegistry().rebuildMyFeedIntent.newIntent(getActivity(), RebuildMyFeedBundleBuilder.createBundle(false));
      paramNewToVoyagerFeedDismissEvent.setFlags(67108864);
      getActivity().overridePendingTransition(2131034140, 2131034141);
      getContext().startActivity(paramNewToVoyagerFeedDismissEvent);
      return;
    }
    paramNewToVoyagerFeedDismissEvent = adapter;
    if (viewPager.getCurrentItem() == 0) {
      bool = true;
    }
    paramNewToVoyagerFeedDismissEvent.resetFeedTabIfNecessary(null, bool);
  }
  
  @Subscribe
  public void onEvent(NavigateToTabEvent paramNavigateToTabEvent)
  {
    setActiveTab(homeTabInfo, true);
  }
  
  @Subscribe
  public void onEvent(RegisterForNavUpdatesEvent paramRegisterForNavUpdatesEvent)
  {
    View localView = (View)viewReference.get();
    if (localView != null) {
      if (!isOpenSearchBar40) {
        break label60;
      }
    }
    label60:
    for (float f = getResources().getDimension(2131493508);; f = getResources().getDimension(2131493507))
    {
      localView.setTranslationY(-(f - appBarLayoutOffset));
      navBarTranslationUpdateViewRefs.add(viewReference);
      return;
    }
  }
  
  @Subscribe
  public void onEvent(BadgeUpdateEvent paramBadgeUpdateEvent)
  {
    int i;
    if ((applicationComponent.homeCachedLix().isInvitationBadgeNumberDisplay()) && (tabInfo == HomeTabInfo.RELATIONSHIPS))
    {
      i = 1;
      if (viewPager.getCurrentItem() != tabs.indexOf(tabInfo)) {
        break label152;
      }
    }
    label152:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j == 0) || (count.longValue() == 0L))
      {
        HomePagerAdapter localHomePagerAdapter = adapter;
        HomeTabInfo localHomeTabInfo = tabInfo;
        long l = count.longValue();
        paramBadgeUpdateEvent = (Long)badgeCounts.get(localHomeTabInfo);
        if ((paramBadgeUpdateEvent == null) || (paramBadgeUpdateEvent.longValue() != l))
        {
          badgeCounts.put(localHomeTabInfo, Long.valueOf(l));
          localHomePagerAdapter.notifyDataSetChanged();
        }
      }
      return;
      i = 0;
      break;
    }
  }
  
  @Subscribe
  public void onEvent(PushNotificationReceivedEvent paramPushNotificationReceivedEvent)
  {
    if ("enabled".equals(applicationComponent.lixManager().getTreatment(Lix.GROWTH_BADGING_APPBADGE))) {}
    while (dataProvider == null) {
      return;
    }
    paramPushNotificationReceivedEvent = dataProvider;
    Tracker.createPageInstanceHeader(getPageInstance());
    paramPushNotificationReceivedEvent.fetchData$7708a69c(true);
  }
  
  public void onStart()
  {
    super.onStart();
    String str = applicationComponent.flagshipSharedPreferences().getNewToVoyagerLegoTrackingToken();
    adapter.resetFeedTabIfNecessary(str, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Bus.subscribe(this);
    float f;
    if (appBarLayout != null)
    {
      if (!isOpenSearchBar40) {
        break label740;
      }
      f = getResources().getDimension(2131493508);
      appBarLayout.addOnOffsetChangedListener(new HomeFragment.2(this, f));
      if ("enabled".equals(homeCachedLix.getTreatment(Lix.INFRA_NAV_V2_COLLAPSE_SEARCH_BAR))) {
        new Handler(Looper.getMainLooper()).postDelayed(new HomeFragment.3(this), 4000L);
      }
    }
    if (!"enabled".equals(applicationComponent.lixManager().getTreatment(Lix.AXLE_BADGING_RELOAD_FIX))) {
      refreshBadgeCounts.run(true);
    }
    tabStrip.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), 2131624058));
    appLauncher = new AppLauncher(fragmentComponent);
    paramBundle = appLauncher;
    ButterKnife.inject(paramBundle, paramView);
    appLauncherButton.setImageResource(2130838043);
    paramView = fragmentComponent.activity().obtainStyledAttributes(new int[] { 16843534 });
    int i = paramView.getResourceId(0, 0);
    appLauncherButton.setBackgroundResource(i);
    paramView.recycle();
    appLauncherButton.setOnClickListener(new AppLauncher.1(paramBundle));
    appLauncherAdapter = new ViewModelArrayAdapter(fragmentComponent.activity(), fragmentComponent.mediaCenter(), null);
    appLauncher.setLayoutManager(new LinearLayoutManager(fragmentComponent.activity()));
    appLauncher.setAdapter(appLauncherAdapter);
    drawerLayout.setDrawerListener(new AppLauncher.2(paramBundle));
    if ((searchBox != null) && (searchLaunchIcon != null))
    {
      if ("enabled".equals(applicationComponent.lixManager().getTreatment(Lix.SEARCH_VERTICAL_NAV)))
      {
        searchBoxText.setText(i18NManager.getString(2131233543));
        label375:
        searchBox.setOnClickListener(getOpenSearchBoxListener());
        searchLaunchIcon.setOnClickListener(getOpenSearchBoxListener());
      }
    }
    else
    {
      paramView = applicationComponent.flagshipSharedPreferences().getNewToVoyagerLegoTrackingToken();
      adapter.legoTrackingToken = paramView;
      paramView = viewPager;
      if (applicationComponent.deviceClass() < 2013) {
        break label774;
      }
    }
    label740:
    label774:
    for (i = tabs.size();; i = 1)
    {
      paramView.setOffscreenPageLimit(i);
      viewPager.setAdapter(adapter);
      viewPager.enableInteractionTracking(fragmentComponent.tracker(), "home_viewpager");
      setupViewPagerInteractionTracking();
      setupTabStripOnClickListeners(fragmentComponent.tracker());
      tabStrip.setupWithViewPager$4740f1a6(viewPager, 2130968923, 2131756492, new HomeFragment.1(this, fragmentComponent.eventBus()));
      paramView = HomeBundle.getActiveTab(applicationComponent.flagshipSharedPreferences(), getArguments());
      paramBundle = HomeBundle.getActiveTabBundle(getArguments());
      adapter.fragmentArguments = paramBundle;
      setActiveTab(paramView, false);
      applicationComponent.flagshipSharedPreferences().setLastActiveTab(paramView);
      setSearchBar(paramView);
      paramView = (BadgeUpdateEvent)Bus.getAndClearStickyEvent(BadgeUpdateEvent.class);
      if (paramView != null) {
        onEvent(paramView);
      }
      if ("enabled".equals(applicationComponent.lixManager().getTreatment(Lix.AXLE_DOGFOOD)))
      {
        paramView = (ViewGroup)getActivity().getWindow().findViewById(2131755475);
        if ((paramView != null) && (getResourcesgetConfigurationorientation == 1) && (!isDogfoodSplashDisplayed))
        {
          isDogfoodSplashDisplayed = true;
          new SplashPromoInflater(paramView, fragmentComponent, true).fetchPromo(applicationComponent.tracker().trackingCodePrefix + "_" + "dogfood", null);
        }
      }
      return;
      f = getResources().getDimension(2131493559);
      break;
      searchBoxText.setText(i18NManager.getString(2131233547));
      break label375;
    }
  }
  
  public final String pageKey()
  {
    return "home_viewpager";
  }
  
  public final void setActiveTab(int paramInt, boolean paramBoolean)
  {
    if (viewPager != null) {
      viewPager.setCurrentItem(paramInt, paramBoolean);
    }
  }
  
  public final void setActiveTab(HomeTabInfo paramHomeTabInfo, boolean paramBoolean)
  {
    if (tabs.contains(paramHomeTabInfo)) {}
    for (int i = tabs.indexOf(paramHomeTabInfo);; i = 0)
    {
      setActiveTab(i, paramBoolean);
      return;
    }
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.home.HomeFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */