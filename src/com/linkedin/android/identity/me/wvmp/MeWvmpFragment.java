package com.linkedin.android.identity.me.wvmp;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.me.shared.paging.MeWvmpPagingHelper;
import com.linkedin.android.identity.me.shared.util.MeTrackableViewModelArrayAdapter;
import com.linkedin.android.identity.me.wvmp.analytics.AnalyticsProfileViewsPanelViewModel;
import com.linkedin.android.identity.me.wvmp.freeanonymous.MeWvmpFreeAnonymousPremiumViewHolder;
import com.linkedin.android.identity.me.wvmp.freeanonymous.MeWvmpFreeAnonymousPremiumViewModel;
import com.linkedin.android.identity.me.wvmp.transformers.AnalyticsProfileViewsPanelTransformer;
import com.linkedin.android.identity.me.wvmp.transformers.MeWvmpTransformer;
import com.linkedin.android.identity.shared.IdentityLoadingAdapter;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.ReplayableEventSubscriber;
import com.linkedin.android.infra.events.SettingsChangedEvent;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.TimeRange;
import com.linkedin.android.pegasus.gen.voyager.common.DiscloseAsProfileViewerInfo;
import com.linkedin.android.pegasus.gen.voyager.common.MySettings;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Panel;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Panel.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpMetadata;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class MeWvmpFragment
  extends PageFragment
{
  ErrorPageViewModel emptyPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @InjectView(2131756774)
  LinearLayout freeAnonymousPremiumLayout;
  MeWvmpFreeAnonymousPremiumViewModel freeAnonymousPremiumViewModel;
  InfiniteScrollListener infiniteScrollListener = new MeWvmpFragment.1(this);
  boolean isNonPremiumUserInitially;
  IdentityLoadingAdapter loadingAdapter;
  MergeAdapter mergeAdapter;
  ViewModelArrayAdapter<AnalyticsProfileViewsPanelViewModel> panelAdapter;
  MeTrackableViewModelArrayAdapter<ViewModel> profileViewsAdapter;
  @InjectView(2131756772)
  RecyclerView recyclerView;
  @InjectView(2131756771)
  SwipeRefreshLayout refreshLayout;
  private SwipeRefreshLayout.OnRefreshListener refreshListener = new MeWvmpFragment.3(this);
  private final ReplayableEventSubscriber settingsChangeEventSubscriber = new ReplayableEventSubscriber(this)
  {
    public final void consumeEvents$61fb9e66()
    {
      MeWvmpFragment localMeWvmpFragment = (MeWvmpFragment)fragmentWeakReference.get();
      if (localMeWvmpFragment != null)
      {
        getActivity();
        MeWvmpFragment.access$000$75c16cf9$45dced3b(localMeWvmpFragment);
      }
    }
    
    @Subscribe
    public final void onEvent(SettingsChangedEvent paramAnonymousSettingsChangedEvent)
    {
      consumeEvent(paramAnonymousSettingsChangedEvent);
    }
  };
  @InjectView(2131755468)
  Toolbar toolbar;
  @Inject
  ViewPortManager viewPortManager;
  
  private void fetchWvmp$af9e7a8(boolean paramBoolean)
  {
    if ((BaseActivity)getActivity() != null)
    {
      getActivityactivityComponent.meWvmpDataProvider().fetchAllData(busSubscriberId, getRumSessionId(), paramBoolean, Tracker.createPageInstanceHeader(getPageInstance()));
      return;
    }
    Util.safeThrow$7a8b4789(new RuntimeException("WVMP fetched without activity"));
  }
  
  private void forceFetchAllData()
  {
    if ((BaseActivity)getActivity() != null)
    {
      refreshLayout.setRefreshing(true);
      getActivityactivityComponent.meWvmpDataProvider().fetchAllData(busSubscriberId, RUMHelper.pageInitRefresh(this), true, Tracker.createPageInstanceHeader(getPageInstance()));
    }
  }
  
  private void hideWvmpViews()
  {
    panelAdapter.clearValues();
    profileViewsAdapter.clearValues();
    refreshLayout.setVisibility(8);
    recyclerView.setVisibility(8);
    recyclerView.removeOnScrollListener(infiniteScrollListener);
  }
  
  public static MeWvmpFragment newInstance()
  {
    return new MeWvmpFragment();
  }
  
  private void setFreeAnonymousLayoutEnabled(boolean paramBoolean)
  {
    if (freeAnonymousPremiumLayout == null) {}
    TrackingEventBuilder localTrackingEventBuilder;
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (freeAnonymousPremiumLayout.getVisibility() == 0);
      freeAnonymousPremiumLayout.setVisibility(0);
      localTrackingEventBuilder = freeAnonymousPremiumViewModel.onTrackImpression(new ImpressionData());
    } while (localTrackingEventBuilder == null);
    tracker.send(localTrackingEventBuilder);
    return;
    freeAnonymousPremiumLayout.setVisibility(8);
  }
  
  public final void doEnter()
  {
    super.doEnter();
    viewPortManager.trackAll(tracker);
  }
  
  public final void doLeave()
  {
    super.doLeave();
    viewPortManager.untrackAll();
  }
  
  public final void doResume()
  {
    super.doResume();
    settingsChangeEventSubscriber.replayEvents();
    if ((isNonPremiumUserInitially) && (fragmentComponent.memberUtil().isPremium())) {
      forceFetchAllData();
    }
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(profileViewsAdapter);
    return localArrayList;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final String loadMorePageKey()
  {
    return "me_wvm_views";
  }
  
  protected final void onCollectionDataEvent(int paramInt, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString1, String paramString2)
  {
    if (((elements == null) || (elements.size() == 0) || ((elements.get(0) instanceof Card))) && ((metadata == null) || ((metadata instanceof WvmpMetadata))))
    {
      if (paramString2 == null) {
        break label126;
      }
      paramInt = 1;
      if (paramType == DataStore.Type.NETWORK) {
        break label131;
      }
    }
    label126:
    label131:
    for (boolean bool = true;; bool = false)
    {
      if (paramInt != 0) {
        RUMTiming.renderStart(paramString2, bool, shouldAggregateMultipleRenders());
      }
      paramCollectionTemplate = elements;
      loadingAdapter.setLoading(false);
      paramCollectionTemplate = MeWvmpTransformer.toCardViewModels(fragmentComponent, paramCollectionTemplate);
      profileViewsAdapter.appendValues(paramCollectionTemplate);
      if (paramInt != 0) {
        RUMHelper.callRenderEndOnNextLoop(paramString2, bool);
      }
      return;
      paramInt = 0;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    fragmentComponent.eventBus();
    Bus.subscribe(settingsChangeEventSubscriber);
    boolean bool;
    if ((paramBundle != null) && (paramBundle.containsKey("is_non_premium_user_initially"))) {
      bool = paramBundle.getBoolean("is_non_premium_user_initially");
    }
    for (;;)
    {
      isNonPremiumUserInitially = bool;
      return;
      if (!fragmentComponent.memberUtil().isPremium()) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968999, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramType == DataStore.Type.NETWORK)
    {
      loadingAdapter.setLoading(false);
      Log.e(MeWvmpDataProvider.TAG, "Error loading WVMP " + paramDataManagerException.toString());
      refreshLayout.setRefreshing(false);
      loadingAdapter.setLoading(false);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet == null) || (!paramSet.contains(MeWvmpDataProvider.WVMP_CARDS_ROUTE.toString()))) {}
    do
    {
      return;
      loadingAdapter.setLoading(false);
      refreshLayout.setRefreshing(false);
      paramType = getActivityactivityComponent.meWvmpDataProvider();
    } while (!paramType.isDataAvailable());
    if ((!fragmentComponent.memberUtil().isPremium()) && (DiscloseAsProfileViewerInfo.DISCLOSE_FULL != state).settings().discloseAsProfileViewer))
    {
      emptyPageViewModel.remove();
      hideWvmpViews();
      setFreeAnonymousLayoutEnabled(true);
      return;
    }
    if ((state).wvmp().elements == null) || (state).wvmp().elements.size() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      hideWvmpViews();
      setFreeAnonymousLayoutEnabled(false);
      paramType = (ErrorPageViewHolder)emptyPageViewModel.getCreator().createViewHolder(getView());
      emptyPageViewModel.errorImage = 2130838589;
      emptyPageViewModel.errorHeaderText = getContext().getString(2131232174);
      emptyPageViewModel.errorDescriptionText = getContext().getString(2131232173);
      emptyPageViewModel.errorButtonText = getContext().getString(2131232172);
      emptyPageViewModel.onErrorButtonClick = new MeWvmpFragment.5(this, fragmentComponent.tracker(), "wvm_empty_page");
      paramSet = emptyPageViewModel;
      paramMap = getActivity().getLayoutInflater();
      applicationComponent.mediaCenter();
      paramSet.onBindViewHolder$49e9e35b(paramMap, paramType);
      return;
    }
    emptyPageViewModel.remove();
    setFreeAnonymousLayoutEnabled(false);
    refreshLayout.setVisibility(0);
    recyclerView.setVisibility(0);
    if (((MeWvmpDataProvider.MeWvmpState)state).wvmp() != null)
    {
      paramSet = (MeWvmpDataProvider.MeWvmpState)state;
      paramMap = activityComponent;
      Uri.Builder localBuilder = MeWvmpDataProvider.WVMP_CARDS_ROUTE.buildUpon();
      if (paramType.isDataAvailable())
      {
        Object localObject = ((MeWvmpDataProvider.MeWvmpState)state).wvmp();
        if ((hasMetadata) && (metadata).hasTimeRange))
        {
          localObject = metadata).timeRange;
          if (hasStart) {
            localBuilder.appendQueryParameter("startTime", Long.toString(start));
          }
          if (hasEnd) {
            localBuilder.appendQueryParameter("endTime", Long.toString(end));
          }
        }
      }
      wvmpHelper = new MeWvmpPagingHelper(paramMap, localBuilder.build().toString(), ((MeWvmpDataProvider.MeWvmpState)state).wvmp());
    }
    for (;;)
    {
      if (((MeWvmpDataProvider.MeWvmpState)state).analyticsPanels() == null) {
        Util.safeThrow(new RuntimeException("getAnalyticsPanels should not be called when data is not available"));
      }
      paramSet = state).analyticsPanels().elements;
      if ((paramSet != null) && (!paramSet.isEmpty()))
      {
        paramSet = get0value;
        if (profileViewsByTimePanelValue != null)
        {
          paramSet = AnalyticsProfileViewsPanelTransformer.toAnalyticsProfileViewsPanelViewModel(fragmentComponent, profileViewsByTimePanelValue);
          if (paramSet != null)
          {
            paramMap = new ArrayList(1);
            paramMap.add(paramSet);
            panelAdapter.setValues(paramMap);
          }
        }
      }
      if (paramType.getWvmpCards() == null) {
        break;
      }
      profileViewsAdapter.setValues(MeWvmpTransformer.toCardViewModels(fragmentComponent, getWvmpCardselements));
      recyclerView.removeOnScrollListener(infiniteScrollListener);
      recyclerView.addOnScrollListener(infiniteScrollListener);
      return;
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(MeWvmpDataProvider.TAG + ": cards state is null!"));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    fragmentComponent.eventBus();
    Bus.unsubscribe(settingsChangeEventSubscriber);
  }
  
  public void onDestroyView()
  {
    viewPortManager.untrackAll();
    super.onDestroyView();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("is_non_premium_user_initially", isNonPremiumUserInitially);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    viewPortManager.container = recyclerView;
    panelAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
    profileViewsAdapter = new MeTrackableViewModelArrayAdapter(fragmentComponent, "me_wvm_views");
    loadingAdapter = new IdentityLoadingAdapter();
    loadingAdapter.setLoading(true);
    mergeAdapter = new MergeAdapter();
    mergeAdapter.setViewPortManager(viewPortManager);
    mergeAdapter.addAdapter(panelAdapter);
    mergeAdapter.addAdapter(profileViewsAdapter);
    mergeAdapter.addAdapter(loadingAdapter);
    recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
    recyclerView.setAdapter(mergeAdapter);
    paramView = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(paramView);
    refreshLayout.setOnRefreshListener(refreshListener);
    refreshLayout.setColorSchemeResources(ViewUtils.SWIPE_REFRESH_LAYOUT_COLOR_SCHEME);
    toolbar.setTitle(2131232185);
    toolbar.setNavigationOnClickListener(new MeWvmpFragment.4(this));
    paramView = new MeWvmpFreeAnonymousPremiumViewHolder(freeAnonymousPremiumLayout);
    freeAnonymousPremiumViewModel = MeWvmpTransformer.createMeWvmpFreeAnonymousPremiumModel$20fdd4c5(fragmentComponent);
    paramBundle = freeAnonymousPremiumViewModel;
    getLayoutInflater(null);
    fragmentComponent.mediaCenter();
    paramBundle.onBindViewHolder$eae5f3e(paramView);
    setFreeAnonymousLayoutEnabled(false);
    recyclerView.setVisibility(8);
    refreshLayout.setVisibility(8);
    emptyPageViewModel = new ErrorPageViewModel(errorViewStub);
    emptyPageViewModel.remove();
    getActivity();
    fetchWvmp$af9e7a8(false);
  }
  
  public final String pageKey()
  {
    return "me_wvm";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmp.MeWvmpFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */