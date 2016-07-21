package com.linkedin.android.relationships;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.growth.calendar.CalendarSyncHelper;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.home.HomeFragmentDataProvider.State;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.TabScrolledEvent;
import com.linkedin.android.home.TabSelectedEvent;
import com.linkedin.android.home.badging.BadgeUpdateEvent;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider.GuidedEditState;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFragmentHelper;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.guidededit.uedit.pymk.UeditPymkLoadingViewModel;
import com.linkedin.android.identity.guidededit.uedit.pymk.UeditPymkTransformer;
import com.linkedin.android.identity.profile.view.guidededitentry.GuidedEditEntryTransformer;
import com.linkedin.android.infra.LoadingAdapter;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.RecyclerViewUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate.ProfileUpdate;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationsSummary;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.ConnectionsSummary;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropsCollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.relationships.home.AbstractPropViewModel;
import com.linkedin.android.relationships.home.BreakCardShownEvent;
import com.linkedin.android.relationships.home.BreakCardViewModel;
import com.linkedin.android.relationships.home.InvitationsViewedEvent;
import com.linkedin.android.relationships.home.PropCardViewModel;
import com.linkedin.android.relationships.home.PropCardViewModelTransformer;
import com.linkedin.android.relationships.home.PropStackContainerViewModel;
import com.linkedin.android.relationships.home.PropsUtil;
import com.linkedin.android.relationships.home.RemoveTopCardEvent;
import com.linkedin.android.relationships.home.TopSummaryViewModel;
import com.linkedin.android.relationships.home.TopSummaryViewModelTransformer;
import com.linkedin.android.relationships.pymk.PymkAdapter;
import com.linkedin.android.relationships.pymk.PymkCardTransformer;
import com.linkedin.android.relationships.pymk.PymkCardViewModel;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.relationships.shared.RelationshipsTracking;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.widgets.cardstack.CardContainer;
import com.linkedin.android.relationships.widgets.cardstack.ListCardStackAdapter;
import com.linkedin.android.relationships.widgets.cardstack.PropStackView;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class RelationshipsFragment
  extends ViewPagerFragment
{
  private static final long WAIT_TIME_FOR_NEXT_FETCH_IN_MS = TimeUnit.MINUTES.toMillis(15L);
  @Inject
  ActivityComponent component;
  @Inject
  ConsistencyManager consistencyManager;
  private List<ConsistencyManagerListener> consistencyManagerPropListeners;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @Inject
  FragmentComponent fragmentComponent;
  private String goToPropId;
  private GuidedEditProfileUpdate guidedEditProfileUpdate;
  private Handler handler;
  @Inject
  HomeCachedLix homeCachedLix;
  @Inject
  HomeFragmentDataProvider homeFragmentDataProvider;
  private boolean inviteBadgeNumberDisplayEnabledTreatment;
  private boolean isDataDisplayed;
  private boolean isEmptyPage;
  private boolean isLoading;
  private boolean isUedit;
  @Inject
  LixManager lixManager;
  private MergeAdapter mergeAdapter;
  private int nextPymkPageStart;
  private int numPropCardsSwiped;
  private PropStackContainerViewModel propStackContainerViewModel;
  private ViewModelArrayAdapter<PropStackContainerViewModel> propStackContainerViewModelAdapter;
  private PymkAdapter pymkAdapter;
  private String pymkLoadMoreSessionId;
  private LoadingAdapter pymkLoadingAdapter;
  @InjectView(2131758367)
  RecyclerView recyclerView;
  private ViewModelArrayAdapter<TopSummaryViewModel> summaryAdapter;
  private TopSummaryViewModel topSummaryViewModel;
  private long ueditLoadingStartTime;
  @Inject
  ViewPortManager viewPortManager;
  
  private void appendMorePeopleYouMayKnow(boolean paramBoolean, List<PeopleYouMayKnow> paramList)
  {
    clearLoadingSpinner(false);
    if (pymkLoadMoreSessionId != null) {
      RUMTiming.renderStart(pymkLoadMoreSessionId, paramBoolean);
    }
    pymkAdapter.appendValues(PymkCardTransformer.toPeopleYouMayKnowCellList(fragmentComponent, paramList, "p-flagship3-people-prop"));
    if (pymkLoadMoreSessionId != null) {
      RUMHelper.callRenderEndOnNextLoop(pymkLoadMoreSessionId, paramBoolean);
    }
    nextPymkPageStart += 20;
  }
  
  private void clearBadgeUI()
  {
    homeFragmentDataProvider.clearAllBadgeCount(HomeTabInfo.RELATIONSHIPS, Tracker.createPageInstanceHeader(getPageInstance()), null);
  }
  
  private void clearLoading(boolean paramBoolean)
  {
    if ((!isLoading) || (paramBoolean)) {
      return;
    }
    handler.post(new RelationshipsFragment.8(this));
  }
  
  private void clearLoadingSpinner(boolean paramBoolean)
  {
    if (pymkLoadingAdapter != null) {
      pymkLoadingAdapter.setLoading(false, paramBoolean);
    }
  }
  
  private void clearPropConsistencyManagerListeners()
  {
    if (consistencyManagerPropListeners != null)
    {
      Iterator localIterator = consistencyManagerPropListeners.iterator();
      while (localIterator.hasNext())
      {
        ConsistencyManagerListener localConsistencyManagerListener = (ConsistencyManagerListener)localIterator.next();
        consistencyManager.removeListener(localConsistencyManagerListener);
      }
      consistencyManagerPropListeners.clear();
      consistencyManagerPropListeners = null;
    }
  }
  
  private void dismissTopProp(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (propStackContainerViewModel == null) {
      CrashReporter.reportNonFatal(new Throwable("propStackContainerViewModel is null, given propId = " + paramString));
    }
    PropStackView localPropStackView;
    do
    {
      return;
      localPropStackView = propStackContainerViewModel.getPropStackView();
    } while ((paramString == null) || (localPropStackView == null));
    DelayedExecution localDelayedExecution = delayedExecution;
    paramString = new RelationshipsFragment.9(this, paramString, paramBoolean2, localPropStackView);
    if (paramBoolean1) {}
    for (long l = 500L;; l = 0L)
    {
      localDelayedExecution.postDelayedExecution(paramString, l);
      return;
    }
  }
  
  private void fetchUpdates(DataManager.DataStoreFilter paramDataStoreFilter)
  {
    RelationshipsDataProvider localRelationshipsDataProvider = component.relationshipsDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    long l = ((HomeFragmentDataProvider.State)fragmentComponent.homeFragmentDataProvider().state).getLastUpdateTimestamp(HomeTabInfo.RELATIONSHIPS);
    state).propsRoute = RelationshipsRoutesHelper.makePropsRoute(l, "p-flagship3-people");
    state).peopleYouMayKnowRoute = RelationshipsRoutesHelper.makePeopleYouMayKnowRoute$782597e1("p-flagship3-people-prop", 0);
    state).connectionsSummaryRoute = RelationshipsRoutesHelper.makeConnectionsSummaryRoute();
    state).invitationSummaryRoute = RelationshipsRoutesHelper.makeInvitationSummaryRoute();
    paramDataStoreFilter = MultiplexRequest.Builder.parallel().filter(paramDataStoreFilter);
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    localRelationshipsDataProvider.performMultiplexedFetch(str1, str2, localMap, paramDataStoreFilter.required(Request.get().url(state).propsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Prop.BUILDER, PropsCollectionMetadata.BUILDER))).required(Request.get().url(state).peopleYouMayKnowRoute).builder(CollectionTemplate.of(PeopleYouMayKnow.BUILDER))).required(Request.get().url(state).connectionsSummaryRoute).builder(ConnectionsSummary.BUILDER)).optional(Request.get().url(state).invitationSummaryRoute).builder(InvitationsSummary.BUILDER)));
    if ("enabled".equals(lixManager.getTreatment(Lix.GUIDED_EDIT_U_EDIT_PYMK_ENTRY))) {
      component.guidedEditDataProvider().fetchData(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), getActivityapplicationComponent.memberUtil().getProfileId(), GuidedEditSource.PYMK);
    }
  }
  
  private static boolean hasBreakCard(List<AbstractPropViewModel> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof BreakCardViewModel)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void movePushNotificationPropToFrontIfNeeded(List<AbstractPropViewModel> paramList)
  {
    int i = 0;
    int j;
    if ((goToPropId != null) && (paramList.size() > 0))
    {
      if (get0propType == PropType.NEW_TO_VOYAGER) {
        i = 1;
      }
      j = 0;
    }
    for (;;)
    {
      if (j < paramList.size())
      {
        if (TextUtils.equals(goToPropId, getpropId)) {
          paramList.add(i, paramList.remove(j));
        }
      }
      else {
        return;
      }
      j += 1;
    }
  }
  
  private void setupEmptyPage(String paramString)
  {
    if (getView() == null) {
      return;
    }
    isEmptyPage = true;
    recyclerView.setVisibility(8);
    ErrorPageViewHolder localErrorPageViewHolder = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
    errorPageViewModel.errorImage = 2130838478;
    errorPageViewModel.errorHeaderText = getContext().getString(2131233397);
    errorPageViewModel.errorDescriptionText = getContext().getString(2131233396);
    errorPageViewModel.errorButtonText = getContext().getString(2131233395);
    errorPageViewModel.onErrorButtonClick = new RelationshipsFragment.3(this, fragmentComponent.tracker(), "abi", paramString);
    paramString = errorPageViewModel;
    LayoutInflater localLayoutInflater = getActivity().getLayoutInflater();
    applicationComponent.mediaCenter();
    paramString.onBindViewHolder$49e9e35b(localLayoutInflater, localErrorPageViewHolder);
  }
  
  private void updateTopSummaryOnPropStackChanged()
  {
    if (topSummaryViewModel == null) {
      return;
    }
    topSummaryViewModel.updateProps(propStackContainerViewModel.getValues());
  }
  
  private void updateUIAndFetchUpdatesIfNeeded(boolean paramBoolean)
  {
    if ((!isLoading) && ((paramBoolean) || (!isDataDisplayed)))
    {
      isLoading = true;
      if (isDataDisplayed) {
        fetchUpdates(DataManager.DataStoreFilter.NETWORK_ONLY);
      }
    }
    else
    {
      return;
    }
    if (errorPageViewModel != null) {
      errorPageViewModel.remove();
    }
    if (pymkLoadingAdapter != null) {
      pymkLoadingAdapter.setLoading(true, true);
    }
    fetchUpdates(DataManager.DataStoreFilter.ALL);
  }
  
  public final void doEnter()
  {
    boolean bool = false;
    super.doEnter();
    numPropCardsSwiped = 0;
    if (viewPortManager != null) {
      viewPortManager.trackAll(tracker);
    }
    if (!isAdded()) {
      return;
    }
    if (isEmptyPage) {
      setupEmptyPage(OwlTrackingUtils.trackAbookImportImpressionEvent(fragmentComponent.tracker(), fragmentComponent.lixManager(), "mobile-voyager-people-home"));
    }
    long l1 = ((HomeFragmentDataProvider.State)homeFragmentDataProvider.state).getBadgeCount(HomeTabInfo.RELATIONSHIPS);
    if ((!inviteBadgeNumberDisplayEnabledTreatment) && (propStackContainerViewModel != null))
    {
      int i = propStackContainerViewModel.getValues().size();
      if (l1 != i) {
        CrashReporter.reportNonFatal(new Throwable("Found badge count different from prop count: badgeCount=" + l1 + " , propCount=" + i));
      }
    }
    long l2 = ((HomeFragmentDataProvider.State)homeFragmentDataProvider.state).getLastUpdateTimestamp(HomeTabInfo.RELATIONSHIPS);
    l2 = System.currentTimeMillis() - l2;
    if (inviteBadgeNumberDisplayEnabledTreatment)
    {
      if (l2 > WAIT_TIME_FOR_NEXT_FETCH_IN_MS) {}
      for (bool = true;; bool = false)
      {
        updateUIAndFetchUpdatesIfNeeded(bool);
        return;
      }
    }
    clearBadgeUI();
    if ((l1 > 0L) || (l2 > WAIT_TIME_FOR_NEXT_FETCH_IN_MS)) {
      bool = true;
    }
    updateUIAndFetchUpdatesIfNeeded(bool);
  }
  
  public final void doLeave()
  {
    super.doLeave();
    if (viewPortManager != null) {
      viewPortManager.untrackAll();
    }
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(pymkAdapter);
    localArrayList.add(propStackContainerViewModel);
    return localArrayList;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean isParentFragment()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      if (paramInt1 != 31) {
        break label29;
      }
      dismissTopProp(paramIntent.getStringExtra("PROP_ID"), true, true);
    }
    label29:
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 16) {
            break;
          }
          paramInt1 = paramIntent.getExtras().getInt("UPDATE_ACTION_TYPE", -1);
        } while ((3 != paramInt1) && (!UpdateActionModel.isUnfollowAction(paramInt1)));
        dismissTopProp(paramIntent.getExtras().getString("UPDATE_URN"), true, true);
        return;
      } while (paramInt1 != 42);
      paramIntent = paramIntent.getExtras();
      guidedEditProfileUpdate = ((GuidedEditProfileUpdate)RecordParceler.quietUnparcel(GuidedEditProfileUpdate.BUILDER, "guidedEditProfileUpdate", paramIntent));
    } while (guidedEditProfileUpdate == null);
    GuidedEditProfileUpdate localGuidedEditProfileUpdate = guidedEditProfileUpdate;
    ArrayList localArrayList = new ArrayList();
    I18NManager localI18NManager = i18NManager;
    Object localObject = localI18NManager.getString(2131231962);
    paramIntent = (Intent)localObject;
    NormEducation localNormEducation;
    if (localGuidedEditProfileUpdate != null)
    {
      paramIntent = profileUpdate.normPositionValue;
      localNormEducation = profileUpdate.normEducationValue;
      if ((paramIntent == null) || (companyUrn == null)) {
        break label287;
      }
      paramIntent = localI18NManager.getString(2131231963, new Object[] { companyName });
    }
    for (;;)
    {
      localObject = new UeditPymkLoadingViewModel();
      bodyText = paramIntent;
      localArrayList.add(localObject);
      pymkAdapter.setValues(localArrayList);
      isDataDisplayed = false;
      isLoading = true;
      isUedit = true;
      ueditLoadingStartTime = SystemClock.elapsedRealtime();
      component.guidedEditDataProvider().fetchUeditRewards$7cc26a56(0, localGuidedEditProfileUpdate, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()));
      return;
      label287:
      paramIntent = (Intent)localObject;
      if (localNormEducation != null)
      {
        paramIntent = (Intent)localObject;
        if (schoolUrn != null) {
          paramIntent = localI18NManager.getString(2131231963, new Object[] { schoolName });
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    handler = new Handler();
    component.relationshipsDataProvider().register(this);
    component.guidedEditDataProvider().register(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969367, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    boolean bool;
    if (paramType != DataStore.Type.NETWORK)
    {
      bool = true;
      clearLoading(bool);
      if (isAdded()) {
        break label30;
      }
    }
    label30:
    while ((isDataDisplayed) || (paramType != DataStore.Type.NETWORK))
    {
      return;
      bool = false;
      break;
    }
    if (getView() != null)
    {
      paramSet = new RelationshipsFragment.2(this, fragmentComponent.tracker(), "try_again");
      recyclerView.setVisibility(8);
      paramType = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
      errorPageViewModel.setupDefaultErrorConfiguration(getContext(), paramSet);
      paramSet = errorPageViewModel;
      paramDataManagerException = getActivity().getLayoutInflater();
      applicationComponent.mediaCenter();
      paramSet.onBindViewHolderWithErrorTracking$18b8048(paramDataManagerException, paramType, tracker, getPageInstance());
    }
    clearLoadingSpinner(true);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    boolean bool;
    if (paramType == DataStore.Type.LOCAL)
    {
      bool = true;
      clearLoading(bool);
      if ((paramSet != null) && (isAdded())) {
        break label34;
      }
    }
    label34:
    Object localObject1;
    label149:
    label226:
    label315:
    label323:
    label566:
    label572:
    label578:
    label584:
    label669:
    label756:
    label879:
    label885:
    label906:
    label1119:
    label1125:
    label1131:
    label1173:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        paramMap = component.relationshipsDataProvider();
        localObject1 = component.guidedEditDataProvider();
        Object localObject2 = component.relationshipsDataProvider();
        CollectionTemplate localCollectionTemplate;
        if ((paramSet.contains(state).propsRoute)) && (paramSet.contains(state).peopleYouMayKnowRoute)) && (paramSet.contains(state).connectionsSummaryRoute)) && (paramSet.contains(state).invitationSummaryRoute)))
        {
          i = 1;
          if (i == 0)
          {
            localObject2 = component.guidedEditDataProvider().state).guidedEditCategoriesRoute;
            if ((localObject2 == null) || (!paramSet.contains(localObject2)) || (!component.guidedEditDataProvider().isDataAvailable()) || (!CollectionUtils.isNonEmpty(component.relationshipsDataProvider().getPeopleYouMayKnow()))) {
              break label566;
            }
            i = 1;
            if (i == 0)
            {
              localObject2 = component.guidedEditDataProvider().state).ueditRoute;
              if ((localObject2 == null) || (!paramSet.contains(localObject2))) {
                break label578;
              }
              localObject2 = component.guidedEditDataProvider();
              if ((((GuidedEditDataProvider.GuidedEditState)state).getUeditItems() == null) || (!CollectionUtils.isNonEmpty(state).getUeditItems().elements))) {
                break label572;
              }
              i = 1;
              if (i == 0) {
                break label578;
              }
              i = 1;
              if (i == 0) {
                break label1131;
              }
            }
          }
          paramSet = (RelationshipsDataProvider.State)component.relationshipsDataProvider().state;
          localCollectionTemplate = (CollectionTemplate)paramSet.getModel(propsRoute);
          paramSet = component.relationshipsDataProvider().getPeopleYouMayKnow();
          paramMap = ((GuidedEditDataProvider.GuidedEditState)component.guidedEditDataProvider().state).getUeditItems();
          localObject1 = ((RelationshipsDataProvider.State)component.relationshipsDataProvider().state).connectionsSummary();
          localObject2 = ((RelationshipsDataProvider.State)component.relationshipsDataProvider().state).invitationsSummary();
          viewPortManager.clearAll();
          errorPageViewModel.remove();
          isDataDisplayed = true;
          isEmptyPage = false;
          if (paramType == DataStore.Type.NETWORK) {
            homeFragmentDataProvider.setLastUpdateTimestamp(HomeTabInfo.RELATIONSHIPS, System.currentTimeMillis());
          }
          if ((localCollectionTemplate != null) && (elements != null)) {
            break label584;
          }
        }
        for (;;)
        {
          if ((!CollectionUtils.isEmpty(localCollectionTemplate)) || (!CollectionUtils.isEmpty(paramSet)) || (!CollectionUtils.isEmpty(paramMap)) || ((localObject1 != null) && (numConnections != 0)) || ((localObject2 != null) && ((numNewInvitations != 0) || (numPendingInvitations != 0)))) {
            break label669;
          }
          if (paramType != DataStore.Type.NETWORK) {
            break;
          }
          clearLoadingSpinner(true);
          setupEmptyPage(null);
          return;
          i = 0;
          break label149;
          i = 0;
          break label226;
          i = 0;
          break label315;
          i = 0;
          break label323;
          Object localObject3 = elements;
          clearPropConsistencyManagerListeners();
          consistencyManagerPropListeners = new ArrayList();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            RelationshipsFragment.5 local5 = new RelationshipsFragment.5(this, (Prop)((Iterator)localObject3).next());
            consistencyManager.listenForUpdates(local5);
            consistencyManagerPropListeners.add(local5);
          }
        }
        recyclerView.setVisibility(0);
        clearLoadingSpinner(true);
        paramType = PropCardViewModelTransformer.toPropViewModels(fragmentComponent, localCollectionTemplate);
        movePushNotificationPropToFrontIfNeeded(paramType);
        int j;
        if ((PropsUtil.countNumberOfNewProps(paramType) > 0) && (!hasBreakCard(paramType)))
        {
          bool = true;
          propStackContainerViewModel.setListener(new RelationshipsFragment.6(this, bool));
          propStackContainerViewModel.adapter.setValues(paramType);
          if (localObject1 == null) {
            break label879;
          }
          j = numConnections;
          if (!inviteBadgeNumberDisplayEnabledTreatment) {
            break label885;
          }
          i = (int)((HomeFragmentDataProvider.State)homeFragmentDataProvider.state).getBadgeCount(HomeTabInfo.RELATIONSHIPS);
        }
        for (;;)
        {
          topSummaryViewModel = TopSummaryViewModelTransformer.toTopSummaryViewModel(fragmentComponent, propStackContainerViewModel.getValues(), j, i, inviteBadgeNumberDisplayEnabledTreatment);
          summaryAdapter.setValues(Collections.singletonList(topSummaryViewModel));
          if ((!isUedit) || (CollectionUtils.isEmpty(paramMap))) {
            break label906;
          }
          long l1 = ueditLoadingStartTime;
          long l2 = SystemClock.elapsedRealtime();
          delayedExecution.postDelayedExecution(new RelationshipsFragment.4(this, paramMap), l1 + 2000L - l2);
          return;
          bool = false;
          break;
          j = 0;
          break label756;
          if (localObject2 != null) {
            i = numNewInvitations;
          } else {
            i = 0;
          }
        }
        paramType = new ArrayList();
        if (CollectionUtils.isNonEmpty(paramSet))
        {
          paramType.add(PymkCardTransformer.toPymkHeaderCell(fragmentComponent));
          paramSet = PymkCardTransformer.toPeopleYouMayKnowCellList(fragmentComponent, elements, "p-flagship3-people-prop");
          paramType.addAll(paramSet);
          if ((!"enabled".equals(lixManager.getTreatment(Lix.GUIDED_EDIT_U_EDIT_PYMK_ENTRY))) || (!component.guidedEditDataProvider().isDataAvailable())) {
            break label1119;
          }
          i = 1;
          if (i != 0)
          {
            paramMap = lixManager;
            getContext();
            i = GuidedEditFragmentHelper.getGuidedEditEntryCardSlotInPymk$34bfd0e9(paramMap);
            if (i < 0) {
              break label1125;
            }
          }
        }
        for (int i = Math.min(i, paramType.size());; i = 0)
        {
          paramType.add(i + 1, GuidedEditEntryTransformer.toUeditPymkEntryViewModel((GuidedEditCategory)component.guidedEditDataProvider().getGuidedEditCategories().get(0), fragmentComponent, pymkAdapter, i + 1));
          if (i > 0) {
            get1hideBottomBorder = true;
          }
          pymkAdapter.setValues(paramType);
          nextPymkPageStart = 20;
          return;
          i = 0;
          break;
        }
        if (!paramSet.contains(state).morePeopleYouMayKnowRoute)) {
          break label1173;
        }
        paramType = paramMap.getMorePeopleYouMayKnow();
      } while (!CollectionUtils.isNonEmpty(paramType));
      appendMorePeopleYouMayKnow(bool, elements);
      return;
    } while (!paramSet.contains(state).ueditMoreRoute));
    paramType = (GuidedEditDataProvider.GuidedEditState)state;
    appendMorePeopleYouMayKnow(bool, (List)toPYMKListgetModelueditMoreRoute)).second);
  }
  
  public void onDestroy()
  {
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    Bus.unsubscribe(pymkAdapter);
    summaryAdapter = null;
    propStackContainerViewModelAdapter = null;
    pymkAdapter = null;
    pymkLoadingAdapter = null;
    mergeAdapter = null;
    topSummaryViewModel = null;
    errorPageViewModel = null;
    propStackContainerViewModel = null;
    clearPropConsistencyManagerListeners();
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(TabScrolledEvent paramTabScrolledEvent)
  {
    if ((viewPortManager != null) && (tab == HomeTabInfo.RELATIONSHIPS) && (source == 2) && (end)) {
      viewPortManager.trackAll(tracker);
    }
  }
  
  @Subscribe
  public final void onEvent(TabSelectedEvent paramTabSelectedEvent)
  {
    if ((tab == HomeTabInfo.RELATIONSHIPS) && (alreadySelected) && (tapSelected) && (!isDetached())) {
      RecyclerViewUtils.smoothScrollToTop(recyclerView, delayedExecution, 20);
    }
  }
  
  @Subscribe
  public void onEvent(BadgeUpdateEvent paramBadgeUpdateEvent)
  {
    if ((tabInfo == HomeTabInfo.RELATIONSHIPS) && (inviteBadgeNumberDisplayEnabledTreatment) && (topSummaryViewModel != null))
    {
      int i = count.intValue();
      int j = topSummaryViewModel.connectionsCount;
      topSummaryViewModel = TopSummaryViewModelTransformer.toTopSummaryViewModel(fragmentComponent, propStackContainerViewModel.getValues(), j, i, inviteBadgeNumberDisplayEnabledTreatment);
      summaryAdapter.changeViewModel(0, topSummaryViewModel);
    }
  }
  
  @Subscribe
  public void onEvent(BreakCardShownEvent paramBreakCardShownEvent)
  {
    if (topSummaryViewModel != null)
    {
      TopSummaryViewModel localTopSummaryViewModel = topSummaryViewModel;
      breakCardShown = isShown;
      localTopSummaryViewModel.updateView();
    }
  }
  
  @Subscribe
  public void onEvent(InvitationsViewedEvent paramInvitationsViewedEvent)
  {
    if (topSummaryViewModel != null)
    {
      paramInvitationsViewedEvent = topSummaryViewModel;
      numNewInvitations = 0;
      paramInvitationsViewedEvent.updateView();
    }
    if (inviteBadgeNumberDisplayEnabledTreatment) {
      clearBadgeUI();
    }
  }
  
  @Subscribe
  public void onEvent(RemoveTopCardEvent paramRemoveTopCardEvent)
  {
    dismissTopProp(propId, false, false);
  }
  
  @Subscribe
  public void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    if ((propStackContainerViewModel == null) || (propStackContainerViewModel.getPropStackView() == null)) {
      break label17;
    }
    for (;;)
    {
      label17:
      return;
      if (!fragmentComponent.fragment()).isActive)
      {
        CardContainer localCardContainer = propStackContainerViewModel.getPropStackView().getCardContainer();
        Object localObject = localCardContainer.getAdapter();
        if (localObject == null) {
          break;
        }
        localObject = ((ListCardStackAdapter)localObject).getValues();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          if ((((List)localObject).get(i) instanceof PropCardViewModel))
          {
            PropCardViewModel localPropCardViewModel = (PropCardViewModel)((List)localObject).get(i);
            if ((propType == PropType.INVITATION) && (TextUtils.equals(profileId, profileId)))
            {
              localCardContainer.removeItemAtIndexInAdapter(i);
              updateTopSummaryOnPropStackChanged();
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    if ((paramSet1.contains("android.permission.READ_CALENDAR")) || (paramSet2.contains("android.permission.READ_CALENDAR"))) {
      CalendarSyncHelper.onRequestPermissionsResult(fragmentComponent.activity(), paramSet2);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    isLoading = false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getArguments();
    if (paramView != null) {}
    for (paramView = paramView.getString("propId");; paramView = null)
    {
      goToPropId = paramView;
      nextPymkPageStart = 0;
      isDataDisplayed = false;
      inviteBadgeNumberDisplayEnabledTreatment = homeCachedLix.isInvitationBadgeNumberDisplay();
      mergeAdapter = new MergeAdapter();
      summaryAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
      propStackContainerViewModelAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
      propStackContainerViewModel = new PropStackContainerViewModel(fragmentComponent);
      propStackContainerViewModelAdapter.setValues(Collections.singletonList(propStackContainerViewModel));
      pymkLoadingAdapter = new LoadingAdapter();
      pymkAdapter = new PymkAdapter(fragmentComponent, mergeAdapter);
      pymkAdapter.offset = 1;
      pymkAdapter.enablePageViewTracking(fragmentComponent.tracker(), fragmentComponent.delayedExecution(), "people_pymk", RelationshipsTracking.getListPageSize(fragmentComponent));
      mergeAdapter.addAdapter(summaryAdapter);
      mergeAdapter.addAdapter(propStackContainerViewModelAdapter);
      mergeAdapter.addAdapter(pymkAdapter);
      mergeAdapter.addAdapter(pymkLoadingAdapter);
      mergeAdapter.setViewPortManager(viewPortManager);
      errorPageViewModel = new ErrorPageViewModel(errorViewStub);
      errorPageViewModel.remove();
      recyclerView.setAdapter(mergeAdapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      recyclerView.addOnScrollListener(new RelationshipsFragment.1(this));
      viewPortManager.container = recyclerView;
      recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
      updateUIAndFetchUpdatesIfNeeded(false);
      return;
    }
  }
  
  public final String pageKey()
  {
    return "people";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.RelationshipsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */