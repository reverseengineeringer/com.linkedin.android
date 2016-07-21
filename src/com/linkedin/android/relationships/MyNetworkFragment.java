package com.linkedin.android.relationships;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.lego.LegoPageContentWithParser;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.home.HomeFragmentDataProvider.State;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.TabScrolledEvent;
import com.linkedin.android.home.TabSelectedEvent;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider.GuidedEditState;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFragmentHelper;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
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
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
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
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationFolder;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationsSummary;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.ConnectionsSummary;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.relationships.home.PymkAbiCellViewModel;
import com.linkedin.android.relationships.home.TopCardViewModel;
import com.linkedin.android.relationships.home.TopCardViewModelTransformer.1;
import com.linkedin.android.relationships.home.TopCardViewModelTransformer.2;
import com.linkedin.android.relationships.invitations.InvitationCellViewModel;
import com.linkedin.android.relationships.invitations.InvitationCellViewModelChangedListener;
import com.linkedin.android.relationships.invitations.InvitationsDataProvider;
import com.linkedin.android.relationships.invitationsPreview.InvitationsPreviewTransformer;
import com.linkedin.android.relationships.invitationsPreview.InvitationsPreviewZeroPendingViewModel;
import com.linkedin.android.relationships.pymk.PymkAdapter;
import com.linkedin.android.relationships.pymk.PymkCardTransformer;
import com.linkedin.android.relationships.pymk.PymkCardViewModel;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.relationships.shared.RelationshipsTracking;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class MyNetworkFragment
  extends ViewPagerFragment
  implements InvitationCellViewModelChangedListener
{
  @Inject
  ActivityComponent component;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @Inject
  FragmentComponent fragmentComponent;
  private Handler handler;
  @Inject
  HomeFragmentDataProvider homeFragmentDataProvider;
  @Inject
  InvitationsDataProvider invitationsDataProvider;
  private ViewModelArrayAdapter<ViewModel> invitationsPreviewAdapter;
  private boolean isDataReady;
  private boolean isEmptyPage;
  private boolean isLoading;
  @Inject
  LixManager lixManager;
  private MergeAdapter mergeAdapter;
  private boolean needToUpdateInvitePreview;
  private int nextPymkPageStart;
  private int numInviteInPreview;
  private int numNewInvitations;
  private int numPendingInvitations;
  private PymkAdapter pymkAdapter;
  private String pymkLoadMoreSessionId;
  private LoadingAdapter pymkLoadingAdapter;
  @InjectView(2131757113)
  RecyclerView recyclerView;
  private ViewModelArrayAdapter<TopCardViewModel> topCardAdapter;
  @Inject
  ViewPortManager viewPortManager;
  
  private void clearLoading(boolean paramBoolean)
  {
    if ((!isLoading) || (paramBoolean)) {
      return;
    }
    handler.post(new MyNetworkFragment.4(this));
  }
  
  private void clearLoadingSpinner(boolean paramBoolean)
  {
    if (pymkLoadingAdapter != null) {
      pymkLoadingAdapter.setLoading(false, paramBoolean);
    }
  }
  
  private void fetchUpdates(DataManager.DataStoreFilter paramDataStoreFilter)
  {
    RelationshipsDataProvider localRelationshipsDataProvider = component.relationshipsDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    int i = numInviteInPreview;
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    state).invitationsRoute = RelationshipsRoutesHelper.makeInvitationsPagingRoute(InvitationFolder.PENDING.name(), 0, i);
    state).peopleYouMayKnowRoute = RelationshipsRoutesHelper.makePeopleYouMayKnowRoute$782597e1("p-flagship3-people-prop", 0);
    state).connectionsSummaryRoute = RelationshipsRoutesHelper.makeConnectionsSummaryRoute();
    state).invitationSummaryRoute = RelationshipsRoutesHelper.makeInvitationSummaryRoute();
    state).abiInPymkRoute = Routes.MY_NETWORK_ABI_IN_PYMK.buildUponRoot().toString();
    paramDataStoreFilter = MultiplexRequest.Builder.parallel().filter(paramDataStoreFilter);
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    localRelationshipsDataProvider.performMultiplexedFetch(str1, str2, localMap, paramDataStoreFilter.required(Request.get().url(state).invitationsRoute).builder(CollectionTemplate.of(Invitation.BUILDER))).required(Request.get().url(state).peopleYouMayKnowRoute).builder(CollectionTemplate.of(PeopleYouMayKnow.BUILDER))).required(Request.get().url(state).connectionsSummaryRoute).builder(ConnectionsSummary.BUILDER)).optional(Request.get().url(state).abiInPymkRoute).builder(PageContent.BUILDER)).optional(Request.get().url(state).invitationSummaryRoute).builder(InvitationsSummary.BUILDER)));
    if ("enabled".equals(lixManager.getTreatment(Lix.GUIDED_EDIT_U_EDIT_PYMK_ENTRY))) {
      component.guidedEditDataProvider().fetchData(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), getActivityapplicationComponent.memberUtil().getProfileId(), GuidedEditSource.PYMK);
    }
  }
  
  private void setupEmptyPage(String paramString)
  {
    if (getView() == null) {
      return;
    }
    ErrorPageViewHolder localErrorPageViewHolder = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
    errorPageViewModel.errorImage = 2130838478;
    errorPageViewModel.errorHeaderText = getContext().getString(2131233397);
    errorPageViewModel.errorDescriptionText = getContext().getString(2131233396);
    errorPageViewModel.errorButtonText = getContext().getString(2131233395);
    errorPageViewModel.onErrorButtonClick = new MyNetworkFragment.3(this, fragmentComponent.tracker(), "abi", paramString);
    paramString = errorPageViewModel;
    LayoutInflater localLayoutInflater = getActivity().getLayoutInflater();
    applicationComponent.mediaCenter();
    paramString.onBindViewHolder$49e9e35b(localLayoutInflater, localErrorPageViewHolder);
  }
  
  private boolean showUnseenInvitePreviewOnly()
  {
    return lixManager.getTreatment(Lix.MYNETWORK_INVITE_PREVIEW).equals("unseenOnly");
  }
  
  private void updateUIAndFetchUpdatesIfNeeded(boolean paramBoolean)
  {
    if ((!isLoading) && ((paramBoolean) || (!isDataReady)))
    {
      isLoading = true;
      if (isDataReady) {
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
    super.doEnter();
    if (viewPortManager != null) {
      viewPortManager.trackAll(tracker);
    }
    if (!isAdded()) {
      return;
    }
    if (isEmptyPage) {
      setupEmptyPage(OwlTrackingUtils.trackAbookImportImpressionEvent(fragmentComponent.tracker(), fragmentComponent.lixManager(), "mobile-voyager-people-home"));
    }
    long l = ((HomeFragmentDataProvider.State)homeFragmentDataProvider.state).getBadgeCount(HomeTabInfo.RELATIONSHIPS);
    homeFragmentDataProvider.clearAllBadgeCount(HomeTabInfo.RELATIONSHIPS, Tracker.createPageInstanceHeader(getPageInstance()), null);
    if ((l > 0L) || (needToUpdateInvitePreview)) {}
    for (boolean bool = true;; bool = false)
    {
      updateUIAndFetchUpdatesIfNeeded(bool);
      return;
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    if (viewPortManager != null) {
      viewPortManager.untrackAll();
    }
    if (numNewInvitations > 0)
    {
      invitationsDataProvider.clearUnseenCount();
      numNewInvitations = 0;
      Object localObject = ((RelationshipsDataProvider.State)component.relationshipsDataProvider().state).invitations();
      localObject = InvitationsPreviewTransformer.getInvitationsPreview(fragmentComponent, (CollectionTemplate)localObject, this, numNewInvitations, numPendingInvitations, numInviteInPreview, showUnseenInvitePreviewOnly(), true);
      invitationsPreviewAdapter.setValues((List)localObject);
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    isLoading = false;
  }
  
  public final void doResume()
  {
    super.doResume();
    updateUIAndFetchUpdatesIfNeeded(false);
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(pymkAdapter);
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
    return paramLayoutInflater.inflate(2130969110, paramViewGroup, false);
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
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while (paramType != DataStore.Type.NETWORK);
      clearLoadingSpinner(true);
    } while ((isDataReady) || (getView() == null));
    paramSet = new MyNetworkFragment.2(this, fragmentComponent.tracker(), "try_again");
    paramType = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
    errorPageViewModel.setupDefaultErrorConfiguration(getContext(), paramSet);
    paramSet = errorPageViewModel;
    paramDataManagerException = getActivity().getLayoutInflater();
    applicationComponent.mediaCenter();
    paramSet.onBindViewHolderWithErrorTracking$18b8048(paramDataManagerException, paramType, tracker, getPageInstance());
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (paramType == DataStore.Type.LOCAL) {}
    for (boolean bool = true;; bool = false)
    {
      clearLoading(bool);
      if ((paramSet != null) && (isAdded())) {
        break;
      }
      return;
    }
    if (!isDataReady)
    {
      errorPageViewModel.remove();
      isDataReady = true;
    }
    if (paramSet.contains(component.relationshipsDataProvider().state).morePeopleYouMayKnowRoute))
    {
      clearLoadingSpinner(false);
      paramType = component.relationshipsDataProvider().getMorePeopleYouMayKnow();
      if ((paramType != null) && (elements != null))
      {
        if (pymkLoadMoreSessionId != null) {
          RUMTiming.renderStart(pymkLoadMoreSessionId, bool);
        }
        pymkAdapter.appendValues(PymkCardTransformer.toPeopleYouMayKnowCellList(fragmentComponent, elements, "p-flagship3-people-prop"));
        if (pymkLoadMoreSessionId != null) {
          RUMHelper.callRenderEndOnNextLoop(pymkLoadMoreSessionId, bool);
        }
      }
      nextPymkPageStart += 20;
      return;
    }
    paramMap = component.relationshipsDataProvider();
    if ((paramSet.contains(state).invitationsRoute)) && (paramSet.contains(state).peopleYouMayKnowRoute)) && (paramSet.contains(state).connectionsSummaryRoute)) && (paramSet.contains(state).invitationSummaryRoute)))
    {
      i = 1;
      label262:
      if (i == 0)
      {
        paramMap = component.guidedEditDataProvider().state).guidedEditCategoriesRoute;
        if ((paramMap == null) || (!paramSet.contains(paramMap)) || (!component.guidedEditDataProvider().isDataAvailable()) || (!CollectionUtils.isNonEmpty(component.relationshipsDataProvider().getPeopleYouMayKnow()))) {
          break label539;
        }
        i = 1;
        label336:
        if (i == 0) {
          break label543;
        }
      }
      paramMap = ((RelationshipsDataProvider.State)component.relationshipsDataProvider().state).invitations();
      paramSet = component.relationshipsDataProvider().getPeopleYouMayKnow();
      localObject1 = ((RelationshipsDataProvider.State)component.relationshipsDataProvider().state).connectionsSummary();
      localObject2 = ((RelationshipsDataProvider.State)component.relationshipsDataProvider().state).invitationsSummary();
      if (localObject2 == null) {
        break label545;
      }
      numNewInvitations = numNewInvitations;
      numPendingInvitations = numPendingInvitations;
      label436:
      viewPortManager.clearAll();
      if (paramType != DataStore.Type.NETWORK) {
        break label558;
      }
    }
    label539:
    label543:
    label545:
    label558:
    for (bool = true;; bool = false)
    {
      if (bool) {
        homeFragmentDataProvider.setLastUpdateTimestamp(HomeTabInfo.RELATIONSHIPS, System.currentTimeMillis());
      }
      if ((!CollectionUtils.isEmpty(paramSet)) || ((localObject1 != null) && (numConnections != 0)) || ((localObject2 != null) && ((numNewInvitations != 0) || (numPendingInvitations != 0)))) {
        break label564;
      }
      if (paramType == DataStore.Type.NETWORK)
      {
        clearLoadingSpinner(true);
        setupEmptyPage(null);
      }
      isEmptyPage = true;
      return;
      i = 0;
      break label262;
      i = 0;
      break label336;
      break;
      numNewInvitations = 0;
      numPendingInvitations = 0;
      break label436;
    }
    label564:
    isEmptyPage = false;
    clearLoadingSpinner(true);
    paramType = topCardAdapter;
    Object localObject3 = fragmentComponent;
    int i = numConnections;
    Object localObject1 = new TopCardViewModelTransformer.1(((FragmentComponent)localObject3).tracker(), "connections", new TrackingEventBuilder[0], (FragmentComponent)localObject3);
    Object localObject2 = new TopCardViewModelTransformer.2(((FragmentComponent)localObject3).tracker(), "add_connections", new TrackingEventBuilder[0], (FragmentComponent)localObject3);
    String str1 = ((FragmentComponent)localObject3).i18NManager().getString(2131233403, new Object[] { Integer.valueOf(i) });
    localObject3 = ((FragmentComponent)localObject3).context();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
    String str2 = NumberFormat.getNumberInstance(Locale.getDefault()).format(i);
    i = str1.indexOf(str2);
    int j = str2.length() + i;
    if ((i >= 0) && (j <= str1.length()))
    {
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor((Context)localObject3, 2131623966)), i, j, 17);
      localSpannableStringBuilder.setSpan(new RelativeSizeSpan(1.2F), i, j, 17);
      paramType.setValues(Collections.singletonList(new TopCardViewModel(new SpannedString(localSpannableStringBuilder), (View.OnClickListener)localObject1, (View.OnClickListener)localObject2)));
      paramType = InvitationsPreviewTransformer.getInvitationsPreview(fragmentComponent, paramMap, this, numNewInvitations, numPendingInvitations, numInviteInPreview, showUnseenInvitePreviewOnly(), bool);
      invitationsPreviewAdapter.setValues(paramType);
      paramType = new ArrayList();
      if (!CollectionUtils.isEmpty(paramSet))
      {
        paramType.add(PymkCardTransformer.toPymkHeaderCell(fragmentComponent));
        paramSet = PymkCardTransformer.toPeopleYouMayKnowCellList(fragmentComponent, elements, "p-flagship3-people-prop");
        paramMap = new ArrayList(paramSet);
        localObject1 = ((RelationshipsDataProvider.State)component.relationshipsDataProvider().state).invitationsSummary();
        if (localObject1 == null) {
          break label1129;
        }
        i = numPendingInvitations;
        label931:
        localObject1 = (RelationshipsDataProvider.State)component.relationshipsDataProvider().state;
        localObject1 = (PageContent)((RelationshipsDataProvider.State)localObject1).getModel(abiInPymkRoute);
        if (localObject1 != null)
        {
          localObject1 = new LegoPageContentWithParser((PageContent)localObject1).findFirstWidgetContent("voyager_my_network_abi_in_pymk", "abi_in_pymk");
          if (i > 0) {
            break label1135;
          }
          i = 0;
          label996:
          if ((localObject1 == null) || (TextUtils.isEmpty(trackingToken))) {
            break label1141;
          }
          paramMap.add(i, new PymkAbiCellViewModel(fragmentComponent, "mobile-voyager-people-home-pymk", trackingToken));
        }
      }
    }
    label1129:
    label1135:
    label1141:
    while ((!"enabled".equals(lixManager.getTreatment(Lix.GUIDED_EDIT_U_EDIT_PYMK_ENTRY))) || (!component.guidedEditDataProvider().isDataAvailable()))
    {
      paramType.addAll(paramMap);
      pymkAdapter.setValues(paramType);
      nextPymkPageStart = 20;
      return;
      CrashReporter.reportNonFatal(new IndexOutOfBoundsException("text=" + str1 + " length=" + str1.length() + " start=" + i + " end=" + j));
      break;
      i = 0;
      break label931;
      i = 1;
      break label996;
    }
    localObject1 = lixManager;
    getContext();
    j = GuidedEditFragmentHelper.getGuidedEditEntryCardSlotInPymk$34bfd0e9((LixManager)localObject1);
    if (j >= 0) {
      i = Math.min(j, paramSet.size());
    }
    for (;;)
    {
      paramMap.add(i, GuidedEditEntryTransformer.toUeditPymkEntryViewModel((GuidedEditCategory)component.guidedEditDataProvider().getGuidedEditCategories().get(0), fragmentComponent, pymkAdapter, i));
      if (i <= 0) {
        break;
      }
      get1hideBottomBorder = true;
      break;
    }
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
    pymkAdapter = null;
    pymkLoadingAdapter = null;
    mergeAdapter = null;
    errorPageViewModel = null;
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
  public void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    needToUpdateInvitePreview = true;
    if ((!type.equals(InvitationUpdatedEvent.Type.ACCEPT)) || (invitationsPreviewAdapter.getItemCount() < 3)) {
      return;
    }
    numPendingInvitations -= 1;
    int i = invitationsPreviewAdapter.getItemCount() - 1;
    if (numPendingInvitations == 0)
    {
      viewPortManager.untrackAndRemove(mergeAdapter.getAbsolutePosition(i, invitationsPreviewAdapter));
      invitationsPreviewAdapter.removeValueAtPosition(i);
      return;
    }
    invitationsPreviewAdapter.changeViewModel(i, InvitationsPreviewTransformer.getSeeAllButton(fragmentComponent, numNewInvitations, numPendingInvitations));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    nextPymkPageStart = 0;
    isDataReady = false;
    if (lixManager.getTreatment(Lix.MYNETWORK_INVITE_PREVIEW).equals("longList")) {}
    for (int i = 3;; i = 2)
    {
      numInviteInPreview = i;
      mergeAdapter = new MergeAdapter();
      topCardAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
      invitationsPreviewAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
      pymkLoadingAdapter = new LoadingAdapter();
      pymkAdapter = new PymkAdapter(fragmentComponent, mergeAdapter);
      pymkAdapter.offset = 1;
      pymkAdapter.enablePageViewTracking(fragmentComponent.tracker(), fragmentComponent.delayedExecution(), "people_pymk", RelationshipsTracking.getListPageSize(fragmentComponent));
      mergeAdapter.addAdapter(topCardAdapter);
      mergeAdapter.addAdapter(invitationsPreviewAdapter);
      mergeAdapter.addAdapter(pymkAdapter);
      mergeAdapter.addAdapter(pymkLoadingAdapter);
      mergeAdapter.setViewPortManager(viewPortManager);
      errorPageViewModel = new ErrorPageViewModel(errorViewStub);
      errorPageViewModel.remove();
      recyclerView.setAdapter(mergeAdapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      recyclerView.addOnScrollListener(new MyNetworkFragment.1(this));
      viewPortManager.container = recyclerView;
      recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
      return;
    }
  }
  
  public final String pageKey()
  {
    return "people";
  }
  
  public final void removeInvitation(InvitationCellViewModel paramInvitationCellViewModel)
  {
    int i = invitationsPreviewAdapter.getValues().indexOf(paramInvitationCellViewModel);
    if ((i <= 0) || (invitationsPreviewAdapter.getItemCount() < 3)) {
      return;
    }
    numPendingInvitations -= 1;
    if (isNewInvitation) {
      numNewInvitations -= 1;
    }
    if (numPendingInvitations == 0)
    {
      viewPortManager.untrackAndRemove(mergeAdapter.getAbsolutePosition(2, invitationsPreviewAdapter));
      viewPortManager.untrackAndRemove(mergeAdapter.getAbsolutePosition(1, invitationsPreviewAdapter));
      invitationsPreviewAdapter.removeValueAtPosition(2);
      invitationsPreviewAdapter.removeValueAtPosition(1);
      invitationsPreviewAdapter.changeViewModel(0, new InvitationsPreviewZeroPendingViewModel(showUnseenInvitePreviewOnly()));
      return;
    }
    viewPortManager.untrackAndRemove(mergeAdapter.getAbsolutePosition(i, invitationsPreviewAdapter));
    invitationsPreviewAdapter.getValues().remove(i);
    invitationsPreviewAdapter.notifyItemRemoved(i);
    invitationsPreviewAdapter.changeViewModel(invitationsPreviewAdapter.getItemCount() - 1, InvitationsPreviewTransformer.getSeeAllButton(fragmentComponent, numNewInvitations, numPendingInvitations));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.MyNetworkFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */