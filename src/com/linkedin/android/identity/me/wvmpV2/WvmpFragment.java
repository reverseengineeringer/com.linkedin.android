package com.linkedin.android.identity.me.wvmpV2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.shared.MiniCompanyOnClickListener;
import com.linkedin.android.identity.me.shared.actions.MeActionEventManager;
import com.linkedin.android.identity.me.shared.actions.MeActionViewModelAdapterFragment;
import com.linkedin.android.identity.me.shared.paging.MeWvmpPagingHelper;
import com.linkedin.android.identity.me.shared.util.ImpressionPageAdapter;
import com.linkedin.android.identity.me.shared.util.MeTrackableViewModelArrayAdapter;
import com.linkedin.android.identity.me.shared.util.MeTrackingUtils;
import com.linkedin.android.identity.me.shared.util.MeTrackingUtils.WvmpAnalyticsActionEventBuilderWrapper;
import com.linkedin.android.identity.me.shared.util.MeTrackingUtils.WvmpAnalyticsInsightActionEventBuilderWrapper;
import com.linkedin.android.identity.me.shared.util.ViewPagerManager;
import com.linkedin.android.identity.me.shared.util.ViewPagerManager.1;
import com.linkedin.android.identity.me.wvmp.MeWvmpDataProvider;
import com.linkedin.android.identity.me.wvmp.freeanonymous.MeWvmpFreeAnonymousPremiumViewHolder;
import com.linkedin.android.identity.me.wvmp.freeanonymous.MeWvmpFreeAnonymousPremiumViewModel;
import com.linkedin.android.identity.me.wvmp.transformers.MeWvmpTransformer;
import com.linkedin.android.identity.me.wvmpV2.analytics.WvmpAnalyticsAdapter;
import com.linkedin.android.identity.me.wvmpV2.analytics.WvmpAnalyticsPagerAdapter;
import com.linkedin.android.identity.me.wvmpV2.analytics.cardparts.WvmpAnalyticsPagerViewModel;
import com.linkedin.android.identity.me.wvmpV2.analytics.cardparts.WvmpAnalyticsTitleViewModel;
import com.linkedin.android.identity.me.wvmpV2.analytics.insights.WvmpAnalyticsBaseViewModel;
import com.linkedin.android.identity.me.wvmpV2.analytics.insights.WvmpDetailAnalyticsViewModel;
import com.linkedin.android.identity.me.wvmpV2.analytics.insights.WvmpOnboardingAnalyticsViewModel;
import com.linkedin.android.identity.me.wvmpV2.analytics.insights.WvmpSummaryAnalyticsViewModel;
import com.linkedin.android.identity.me.wvmpV2.list.WvmpCtaSendInvitationEvent;
import com.linkedin.android.identity.me.wvmpV2.list.WvmpItemDecoration;
import com.linkedin.android.identity.me.wvmpV2.list.items.WvmpListItemViewModel;
import com.linkedin.android.identity.me.wvmpV2.transformers.WvmpAnalyticsTransformer;
import com.linkedin.android.identity.me.wvmpV2.transformers.WvmpAnalyticsTransformer.1;
import com.linkedin.android.identity.me.wvmpV2.transformers.WvmpAnalyticsTransformer.2;
import com.linkedin.android.identity.me.wvmpV2.transformers.WvmpListItemTransformer;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
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
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.ReplayableEventSubscriber;
import com.linkedin.android.infra.events.SettingsChangedEvent;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DiscloseAsProfileViewerInfo;
import com.linkedin.android.pegasus.gen.voyager.common.MySettings;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Insight;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Insight.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.TimeFrame;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCard.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpOnboardingCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSourceInsightCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpViewersCard;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpOverviewInsightActionEvent.Builder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class WvmpFragment
  extends PageFragment
  implements MeActionViewModelAdapterFragment<Card, ViewModel>
{
  MeActionEventManager<Card, ViewModel> actionManager;
  ErrorPageViewModel emptyPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @InjectView(2131756774)
  LinearLayout freeAnonymousPremiumLayout;
  MeWvmpFreeAnonymousPremiumViewModel freeAnonymousPremiumViewModel;
  InfiniteScrollListener infiniteScrollListener = new WvmpFragment.1(this);
  private final Object invitationsSubscriber = new Object()
  {
    @Subscribe
    public final void onEvent(WvmpCtaSendInvitationEvent paramAnonymousWvmpCtaSendInvitationEvent)
    {
      if ((BaseActivity)getActivity() == null) {
        return;
      }
      WvmpDataProvider localWvmpDataProvider = getActivity()).activityComponent.wvmpDataProvider();
      Object localObject2 = miniProfile;
      paramAnonymousWvmpCtaSendInvitationEvent = activityComponent.profilePendingConnectionRequestManager();
      Object localObject1 = new WvmpDataProvider.1(localWvmpDataProvider, paramAnonymousWvmpCtaSendInvitationEvent, (MiniProfile)localObject2);
      try
      {
        String str = entityUrn.getId();
        Object localObject3 = new InviteeProfile.Builder().setProfileId(str).build(RecordTemplate.Flavor.RECORD);
        localObject3 = new NormInvitation.Invitee.Builder().setInviteeProfileValue((InviteeProfile)localObject3).build();
        localObject2 = new NormInvitation.Builder().setInvitee((NormInvitation.Invitee)localObject3).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
        localObject1 = Request.post().url(RelationshipsRoutesHelper.makeSendGrowthInvitationRoute()).model((RecordTemplate)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener((RecordTemplateListener)localObject1).customHeaders(null);
        activityComponent.dataManager().submit((Request.Builder)localObject1);
        activityComponent.eventBus();
        Bus.publish(new InvitationUpdatedEvent(str, InvitationUpdatedEvent.Type.SENT));
        paramAnonymousWvmpCtaSendInvitationEvent.setPendingState(str, ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT);
        return;
      }
      catch (BuilderException paramAnonymousWvmpCtaSendInvitationEvent)
      {
        activityComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException("Unable to send invite", paramAnonymousWvmpCtaSendInvitationEvent));
      }
    }
  };
  boolean isNonPremiumUserInitially;
  IdentityLoadingAdapter loadingAdapter;
  MergeAdapter mergeAdapter;
  @InjectView(2131756772)
  RecyclerView recyclerView;
  @InjectView(2131756771)
  SwipeRefreshLayout refreshLayout;
  private final ReplayableEventSubscriber settingsChangeEventSubscriber = new ReplayableEventSubscriber(this)
  {
    public final void consumeEvents$61fb9e66()
    {
      WvmpFragment localWvmpFragment = (WvmpFragment)fragmentWeakReference.get();
      if (localWvmpFragment != null)
      {
        getActivity();
        WvmpFragment.access$000$3ec57a73$69547227(localWvmpFragment);
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
  ViewPagerManager viewPagerManager;
  @Inject
  ViewPortManager viewPortManager;
  MeTrackableViewModelArrayAdapter<ViewModel> viewersAdapter;
  WvmpAnalyticsAdapter wvmpAnalyticsAdapter;
  
  private void fetchWvmp$af9e7a8$1385ff()
  {
    if ((BaseActivity)getActivity() != null)
    {
      getActivityactivityComponent.wvmpDataProvider().fetchAllData$294d6e3a(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()));
      return;
    }
    Util.safeThrow$7a8b4789(new RuntimeException("WVMP fetched without activity"));
  }
  
  public static WvmpFragment newInstance()
  {
    return new WvmpFragment();
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
    if ((BaseActivity)getActivity() != null) {
      actionManager.startActionHandling();
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    viewPortManager.untrackAll();
    viewPagerManager.untrackPages();
    actionManager.stopActionHandling();
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(invitationsSubscriber);
  }
  
  public final void doResume()
  {
    super.doResume();
    settingsChangeEventSubscriber.replayEvents();
    if ((isNonPremiumUserInitially) && (fragmentComponent.memberUtil().isPremium()))
    {
      getActivity();
      fetchWvmp$af9e7a8$1385ff();
    }
    fragmentComponent.eventBus();
    Bus.subscribe(invitationsSubscriber);
  }
  
  public final DataTemplateBuilder<Card> getDataModelParser()
  {
    return Card.BUILDER;
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.wvmpDataProvider();
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(viewersAdapter);
    return localArrayList;
  }
  
  public final ViewModel getViewModel(String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = viewersAdapter.getValues().iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (ViewModel)localIterator.next();
    } while ((!(localObject1 instanceof WvmpListItemViewModel)) || (!paramString.equals(entityUrn)));
    Object localObject1 = (WvmpListItemViewModel)localObject1;
    return (ViewModel)localObject1;
  }
  
  public final ViewModelArrayAdapter<ViewModel> getViewModelAdapter()
  {
    return viewersAdapter;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean isParentFragment()
  {
    return true;
  }
  
  public final String loadMorePageKey()
  {
    return "me_wvm_v2_views";
  }
  
  protected final void onCollectionDataEvent(int paramInt, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString1, String paramString2)
  {
    if ((wvmpAnalyticsAdapter != null) && ((elements == null) || (elements.size() == 0) || ((elements.get(0) instanceof Card))) && ((metadata == null) || ((metadata instanceof WvmpMetadata))))
    {
      Object localObject = wvmpAnalyticsAdapter;
      if ((mPagerViewModel == null) || (mPagerViewModel.analyticsAdapter == null)) {
        break label133;
      }
      localObject = mPagerViewModel.analyticsAdapter.getCurrentPagingHelper();
      if ((localObject == null) || (!((MeWvmpPagingHelper)localObject).getRoute().equalsIgnoreCase(paramString1))) {
        break label128;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label133;
      }
    }
    label128:
    label133:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label138;
      }
      return;
      paramInt = 0;
      break;
    }
    label138:
    label145:
    boolean bool1;
    label155:
    int i;
    if (paramString2 != null)
    {
      paramInt = 1;
      if (paramType == DataStore.Type.NETWORK) {
        break label290;
      }
      bool1 = true;
      if (paramInt != 0) {
        RUMTiming.renderStart(paramString2, bool1, shouldAggregateMultipleRenders());
      }
      paramCollectionTemplate = elements;
      loadingAdapter.setLoading(false);
      paramType = wvmpAnalyticsAdapter;
      if ((mPagerViewModel == null) || (mPagerViewModel.analyticsAdapter == null)) {
        break label302;
      }
      paramType = mPagerViewModel.analyticsAdapter;
      paramType = (WvmpAnalyticsBaseViewModel)paramType.getItem(mCurrentPage);
      if (((paramType instanceof WvmpDetailAnalyticsViewModel)) && (!shouldShowViewerSource)) {
        break label296;
      }
      i = 1;
      label245:
      if (i == 0) {
        break label302;
      }
    }
    label290:
    label296:
    label302:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramCollectionTemplate = WvmpListItemTransformer.toListViewModels(fragmentComponent, paramCollectionTemplate, false, bool2);
      viewersAdapter.appendValues(paramCollectionTemplate);
      if (paramInt == 0) {
        break;
      }
      RUMHelper.callRenderEndOnNextLoop(paramString2, bool1);
      return;
      paramInt = 0;
      break label145;
      bool1 = false;
      break label155;
      i = 0;
      break label245;
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
      actionManager = new MeActionEventManager(fragmentComponent, this);
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
      Log.e(WvmpDataProvider.TAG, "Error loading WVMP " + paramDataManagerException.toString());
      loadingAdapter.setLoading(false);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet == null) || (!paramSet.contains(WvmpDataProvider.WVMP_OVERVIEW_CARDS_ROUTE.toString()))) {}
    for (;;)
    {
      return;
      loadingAdapter.setLoading(false);
      paramType = getActivityactivityComponent.wvmpDataProvider();
      if (paramType.isDataAvailable())
      {
        if ((!fragmentComponent.memberUtil().isPremium()) && (DiscloseAsProfileViewerInfo.DISCLOSE_FULL != getSettingsdiscloseAsProfileViewer))
        {
          wvmpAnalyticsAdapter.clearValues();
          refreshLayout.setVisibility(8);
          recyclerView.setVisibility(8);
          setFreeAnonymousLayoutEnabled(true);
          recyclerView.removeOnScrollListener(infiniteScrollListener);
          return;
        }
        if ((((WvmpDataProvider.MeWvmpOverviewState)state).cards() == null) || (state).cards().elements == null) || (state).cards().elements.size() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          wvmpAnalyticsAdapter.clearValues();
          viewersAdapter.clearValues();
          refreshLayout.setVisibility(8);
          recyclerView.setVisibility(8);
          recyclerView.removeOnScrollListener(infiniteScrollListener);
          setFreeAnonymousLayoutEnabled(false);
          paramType = (ErrorPageViewHolder)emptyPageViewModel.getCreator().createViewHolder(getView());
          emptyPageViewModel.errorImage = 2130838589;
          emptyPageViewModel.errorHeaderText = getContext().getString(2131232174);
          emptyPageViewModel.errorDescriptionText = getContext().getString(2131232173);
          emptyPageViewModel.errorButtonText = getContext().getString(2131232172);
          emptyPageViewModel.onErrorButtonClick = new WvmpFragment.6(this, fragmentComponent.tracker(), "wvm_empty_page");
          paramSet = emptyPageViewModel;
          paramMap = getActivity().getLayoutInflater();
          applicationComponent.mediaCenter();
          paramSet.onBindViewHolder$49e9e35b(paramMap, paramType);
          return;
        }
        setFreeAnonymousLayoutEnabled(false);
        refreshLayout.setVisibility(0);
        recyclerView.setVisibility(0);
        if ((paramType.isDataAvailable()) && (getCardselements != null))
        {
          recyclerView.removeOnScrollListener(infiniteScrollListener);
          paramType = paramType.getCards();
          paramSet = wvmpAnalyticsAdapter;
          paramMap = new WvmpAnalyticsTitleViewModel();
          FragmentComponent localFragmentComponent;
          Object localObject3;
          Object localObject1;
          Object localObject2;
          if (paramSet.getValues().size() > 0)
          {
            paramSet.getValues().set(0, paramMap);
            paramSet.notifyItemChanged(0);
            localFragmentComponent = fragmentComponent;
            localObject3 = elements;
            paramSet = viewersAdapter;
            paramMap = loadingAdapter;
            localObject1 = viewPagerManager;
            localObject2 = viewPortManager;
            paramType = null;
            if (((List)localObject3).size() > 0)
            {
              paramType = (WvmpCard)((List)localObject3).get(0);
              if (value.wvmpViewersCardValue == null) {
                break label2278;
              }
              paramType = value.wvmpViewersCardValue;
              paramSet = new WvmpAnalyticsPagerViewModel(paramSet, paramMap, localFragmentComponent.tracker(), (ViewPagerManager)localObject1, (ViewPortManager)localObject2);
              analyticsAdapter = new WvmpAnalyticsPagerAdapter(localFragmentComponent.mediaCenter());
              localObject1 = analyticsAdapter;
              paramType = insightCards;
              localObject2 = new ArrayList();
              localObject3 = paramType.iterator();
            }
          }
          else
          {
            label610:
            label758:
            label808:
            label923:
            label1013:
            label1219:
            label1236:
            label1383:
            label1400:
            label1477:
            label1493:
            label1509:
            label1525:
            label2038:
            label2044:
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label2046;
              }
              Object localObject5 = (WvmpInsightCard)((Iterator)localObject3).next();
              Object localObject4 = MeTrackingUtils.trackingObject(localFragmentComponent, trackingId, objectUrn.toString());
              paramType = null;
              long l;
              double d;
              if (value.wvmpSummaryInsightCardValue != null)
              {
                paramMap = value.wvmpSummaryInsightCardValue;
                localObject5 = localFragmentComponent.i18NManager();
                paramType = new WvmpSummaryAnalyticsViewModel();
                l = numViews;
                count = ((I18NManager)localObject5).getString(2131233020, new Object[] { Long.valueOf(l) });
                if (TimeFrame.LAST_7_DAYS.equals(timeFrame))
                {
                  title = ((I18NManager)localObject5).getString(2131232772, new Object[] { Long.valueOf(l) });
                  if (hasNumViewsChangeInPercentage)
                  {
                    d = numViewsChangeInPercentage / 100.0F;
                    if (d <= 0.0D) {
                      break label1013;
                    }
                    difference = ((I18NManager)localObject5).getString(2131232770, new Object[] { Double.valueOf(d) });
                  }
                  swipeControl = "wvmp_summary";
                  viewersList = WvmpListItemTransformer.toListViewModels(localFragmentComponent, cards, true, true);
                  if ((numViews > cards.size()) && (localFragmentComponent.memberUtil().isPremium()))
                  {
                    localObject5 = WvmpAnalyticsTransformer.getCollectionTemplateForSomeViewers(cards, wvmpMetadata);
                    if (localObject5 != null)
                    {
                      paramMap = WvmpAnalyticsTransformer.getWvmpMetadataRoute(WvmpDataProvider.WVMP_PROFILE_LIST_ROUTE.toString(), wvmpMetadata);
                      pagingHelper = new MeWvmpPagingHelper(activityactivityComponent, paramMap, (CollectionTemplate)localObject5);
                    }
                  }
                  trackingObject = ((TrackingObject)localObject4);
                  if (paramType != null) {
                    if (Util.isEnglish(localFragmentComponent.context())) {
                      break label2038;
                    }
                  }
                }
              }
              for (descriptionMaxLines = 3;; descriptionMaxLines = 2)
              {
                if (paramType == null) {
                  break label2044;
                }
                ((List)localObject2).add(paramType);
                break label610;
                paramSet.getValues().add(paramMap);
                break;
                TimeFrame.LAST_90_DAYS.equals(timeFrame);
                title = ((I18NManager)localObject5).getString(2131232771, new Object[] { Long.valueOf(l) });
                break label758;
                if (d >= 0.0D) {
                  break label808;
                }
                difference = ((I18NManager)localObject5).getString(2131232769, new Object[] { Double.valueOf(d) });
                break label808;
                Object localObject6;
                if (value.wvmpCompanyInsightCardValue != null)
                {
                  paramMap = value.wvmpCompanyInsightCardValue;
                  localObject5 = objectUrn;
                  localObject6 = localFragmentComponent.i18NManager();
                  paramType = new WvmpDetailAnalyticsViewModel();
                  icon = new ImageModel(miniCompany.logo, GhostImageUtils.getCompany(2131492962, miniCompany), Util.retrieveRumSessionId(localFragmentComponent));
                  description = ((I18NManager)localObject6).getString(2131232756, new Object[] { Long.valueOf(numViews), miniCompany.name });
                  Object localObject7 = miniCompany;
                  Object localObject8 = activityactivityComponent;
                  Object localObject9 = new MeTrackingUtils.WvmpAnalyticsActionEventBuilderWrapper("wvmp_company_logo", localFragmentComponent.tracker());
                  ActionCategory localActionCategory = ActionCategory.VIEW;
                  if (localActionCategory == null)
                  {
                    hasActionCategory = false;
                    actionCategory = null;
                    if (localObject4 != null) {
                      break label1477;
                    }
                    hasWvmpOverviewInsight = false;
                    wvmpOverviewInsight = null;
                    iconClickListener = new MiniCompanyOnClickListener((MiniCompany)localObject7, (ActivityComponent)localObject8, "wvmp_company_logo", new TrackingEventBuilder[] { localObject9 });
                    swipeControl = "wvmp_company";
                    iconContentDescription = ((I18NManager)localObject6).getString(2131232755);
                    if (hasInsight)
                    {
                      if (insight.value.wvmpJymbiiInsightValue == null) {
                        break label1525;
                      }
                      insightTrackingObject = MeTrackingUtils.insightTrackingObject(localFragmentComponent, insight);
                      insightDescription = ((I18NManager)localObject6).getString(2131232757);
                      localObject6 = localFragmentComponent.tracker();
                      localObject7 = insightTrackingObject;
                      localObject8 = new MeTrackingUtils.WvmpAnalyticsInsightActionEventBuilderWrapper("wvmp_company_jymbii", localFragmentComponent.tracker());
                      localObject9 = ActionCategory.VIEW;
                      if (localObject9 != null) {
                        break label1493;
                      }
                      hasActionCategory = false;
                      actionCategory = null;
                      if (localObject7 != null) {
                        break label1509;
                      }
                      hasInsight = false;
                      insight = null;
                      insightClickListener = new WvmpAnalyticsTransformer.1((Tracker)localObject6, "wvmp_company_jymbii", new TrackingEventBuilder[] { localObject8 }, paramMap, localFragmentComponent);
                    }
                  }
                  for (;;)
                  {
                    localObject5 = WvmpDataProvider.getCompanyInsightViewersRoute((Urn)localObject5);
                    WvmpAnalyticsTransformer.setupSubsequentListAndPaging(localFragmentComponent, paramType, cards, (String)localObject5, wvmpMetadata, true);
                    trackingObject = ((TrackingObject)localObject4);
                    break;
                    hasActionCategory = true;
                    actionCategory = localActionCategory;
                    break label1219;
                    hasWvmpOverviewInsight = true;
                    wvmpOverviewInsight = ((TrackingObject)localObject4);
                    break label1236;
                    hasActionCategory = true;
                    actionCategory = ((ActionCategory)localObject9);
                    break label1383;
                    hasInsight = true;
                    insight = ((TrackingObject)localObject7);
                    break label1400;
                    localFragmentComponent.context();
                    Util.safeThrow$7a8b4789(new RuntimeException("Unsupported insight type in WvmpCompanyInsightCard!"));
                  }
                }
                if (value.wvmpJobTitleInsightCardValue != null)
                {
                  paramMap = value.wvmpJobTitleInsightCardValue;
                  localObject5 = objectUrn;
                  localObject6 = localFragmentComponent.i18NManager();
                  paramType = new WvmpDetailAnalyticsViewModel();
                  icon = new ImageModel(null, GhostImageUtils.getUnstructuredJob(2131492962), Util.retrieveRumSessionId(localFragmentComponent));
                  description = ((I18NManager)localObject6).getString(2131232759, new Object[] { Long.valueOf(numViews), viewerTitle });
                  swipeControl = "wvmp_occupation";
                  iconContentDescription = ((I18NManager)localObject6).getString(2131232758);
                  localObject5 = WvmpDataProvider.getJobTitleInsightViewersRoute((Urn)localObject5);
                  WvmpAnalyticsTransformer.setupSubsequentListAndPaging(localFragmentComponent, paramType, cards, (String)localObject5, wvmpMetadata, true);
                  trackingObject = ((TrackingObject)localObject4);
                  break label923;
                }
                if (value.wvmpSourceInsightCardValue != null)
                {
                  paramMap = value.wvmpSourceInsightCardValue;
                  localObject5 = objectUrn;
                  localObject6 = localFragmentComponent.i18NManager();
                  paramType = new WvmpDetailAnalyticsViewModel();
                  icon = new ImageModel(null, new GhostImage(2131492962, 2131623973, 2130837970, 2131624055, 1), Util.retrieveRumSessionId(localFragmentComponent));
                  description = ((I18NManager)localObject6).getString(2131232768, new Object[] { Long.valueOf(numViews), AttributedTextUtils.getAttributedString(referrer, localFragmentComponent.context()) });
                  swipeControl = "wvmp_source";
                  iconContentDescription = ((I18NManager)localObject6).getString(2131232767);
                  localObject5 = WvmpDataProvider.getViewerSourceInsightViewersRoute((Urn)localObject5);
                  WvmpAnalyticsTransformer.setupSubsequentListAndPaging(localFragmentComponent, paramType, cards, (String)localObject5, wvmpMetadata, false);
                  trackingObject = ((TrackingObject)localObject4);
                  break label923;
                }
                if (value.wvmpOnboardingCardValue == null) {
                  break label923;
                }
                localObject5 = value.wvmpOnboardingCardValue;
                paramMap = new WvmpOnboardingAnalyticsViewModel();
                swipeControl = "wvmp_onboarding";
                trackingObject = ((TrackingObject)localObject4);
                legoImpressionClosure = new WvmpAnalyticsTransformer.2(localFragmentComponent);
                legoTrackingToken = legoTrackingToken;
                viewersList = WvmpListItemTransformer.toListViewModels(localFragmentComponent, cards, true, true);
                paramType = paramMap;
                if (!localFragmentComponent.memberUtil().isPremium()) {
                  break label923;
                }
                localObject4 = WvmpAnalyticsTransformer.getCollectionTemplateForSomeViewers(cards, wvmpMetadata);
                paramType = paramMap;
                if (localObject4 == null) {
                  break label923;
                }
                paramType = WvmpAnalyticsTransformer.getWvmpMetadataRoute(MeWvmpDataProvider.WVMP_CARDS_ROUTE.toString(), wvmpMetadata);
                pagingHelper = new MeWvmpPagingHelper(activityactivityComponent, paramType, (CollectionTemplate)localObject4);
                paramType = paramMap;
                break label923;
              }
            }
            label2046:
            ((WvmpAnalyticsPagerAdapter)localObject1).setViewModels((List)localObject2);
            pageMargin = localFragmentComponent.context().getResources().getDimensionPixelSize(2131492989);
            extraCardSpace = localFragmentComponent.context().getResources().getDimensionPixelSize(2131492989);
            paramType = localFragmentComponent.context();
            paramMap = paramType.getResources();
            if (Util.isEnglish(paramType)) {
              break label2248;
            }
            pagerHeight = paramMap.getDimensionPixelSize(2131493281);
            paramType = paramSet;
          }
          while (paramType != null)
          {
            viewersAdapter.clear();
            viewersAdapter.registerAdapterDataObserver(new WvmpFragment.7(this));
            paramSet = viewPagerManager;
            paramMap = analyticsAdapter;
            if (isTracking) {
              paramSet.untrackPages();
            }
            adapter = paramMap;
            if (adapter != null)
            {
              adapter.viewPagerManager = paramSet;
              adapter.registerDataSetObserver(new ViewPagerManager.1(paramSet));
            }
            paramSet = wvmpAnalyticsAdapter;
            mPagerViewModel = paramType;
            if (paramSet.getValues().size() > 1) {
              paramSet.getValues().set(1, paramType);
            }
            for (;;)
            {
              paramSet.notifyDataSetChanged();
              return;
              label2248:
              pagerHeight = paramMap.getDimensionPixelSize(2131493280);
              paramType = paramSet;
              break;
              paramSet.getValues().add(paramType);
            }
            label2278:
            paramType = null;
          }
        }
      }
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
    viewPagerManager.untrackPages();
    wvmpAnalyticsAdapter = null;
    viewersAdapter = null;
    loadingAdapter = null;
    mergeAdapter = null;
    recyclerView.setAdapter(null);
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    viewPortManager.container = recyclerView;
    mergeAdapter = new MergeAdapter();
    mergeAdapter.setViewPortManager(viewPortManager);
    wvmpAnalyticsAdapter = new WvmpAnalyticsAdapter(getActivity(), fragmentComponent.mediaCenter());
    viewersAdapter = new MeTrackableViewModelArrayAdapter(fragmentComponent, "me_wvm_v2_views");
    loadingAdapter = new IdentityLoadingAdapter();
    mergeAdapter.addAdapter(wvmpAnalyticsAdapter);
    mergeAdapter.addAdapter(viewersAdapter);
    mergeAdapter.addAdapter(loadingAdapter);
    recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
    recyclerView.setClipChildren(false);
    recyclerView.setClipToPadding(false);
    recyclerView.setAdapter(mergeAdapter);
    recyclerView.setLayoutManager(new WvmpFragment.4(this, getActivity()));
    recyclerView.addItemDecoration(new WvmpItemDecoration(getActivity()));
    refreshLayout.setEnabled(false);
    toolbar.setTitle(2131232185);
    toolbar.setNavigationOnClickListener(new WvmpFragment.5(this));
    paramView = new MeWvmpFreeAnonymousPremiumViewHolder(freeAnonymousPremiumLayout);
    freeAnonymousPremiumViewModel = MeWvmpTransformer.createMeWvmpFreeAnonymousPremiumModel$20fdd4c5(fragmentComponent);
    paramBundle = freeAnonymousPremiumViewModel;
    getLayoutInflater(null);
    fragmentComponent.mediaCenter();
    paramBundle.onBindViewHolder$eae5f3e(paramView);
    setFreeAnonymousLayoutEnabled(false);
    loadingAdapter.setLoading(true);
    emptyPageViewModel = new ErrorPageViewModel(errorViewStub);
    emptyPageViewModel.remove();
    getActivity();
    fetchWvmp$af9e7a8$1385ff();
  }
  
  public final String pageKey()
  {
    return "me_wvm_v2";
  }
  
  public final void showSnackbar(String paramString, Intent paramIntent, int paramInt1, int paramInt2) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmpV2.WvmpFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */