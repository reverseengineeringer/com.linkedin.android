package com.linkedin.android.relationships.invitations;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.TrackableViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationView;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationsSummary;
import com.linkedin.android.relationships.RelationshipsSecondaryBaseFragment;
import com.linkedin.android.relationships.home.InvitationsViewedEvent;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.relationships.shared.RelationshipsTracking;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class PendingInvitationListFragment
  extends RelationshipsSecondaryBaseFragment
  implements InvitationCellViewModelChangedListener
{
  private ViewModelArrayAdapter<InvitationAbiCardViewModel> abiCardAdapter;
  private ErrorPageViewModel errorOrEmptyPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  private InfiniteScrollListener infiniteScrollListener;
  @Inject
  InvitationsDataProvider invitationsDataProvider;
  private TrackableViewModelArrayAdapter<InvitationCellViewModel> invitationsListAdapter;
  private boolean isLoading;
  private int pageStart;
  private int pageState;
  @Inject
  PendingInvitationDataProvider pendingInvitationDataProvider;
  @InjectView(2131756626)
  ProgressBar progressBar;
  @InjectView(2131758357)
  RecyclerView recyclerView;
  @Inject
  SnackbarUtil snackbarUtil;
  private int unseenInvitesCount;
  
  private void fetchInitialPage()
  {
    isLoading = true;
    pageState = -1;
    updatePageVisibilities();
    pageStart = 0;
    PendingInvitationDataProvider localPendingInvitationDataProvider = pendingInvitationDataProvider;
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    int i = pageStart;
    state).invitationsRoute = RelationshipsRoutesHelper.makeInvitationViewsRoute$13d12155(i);
    state).invitationSummaryRoute = RelationshipsRoutesHelper.makeInvitationSummaryRoute();
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    localPendingInvitationDataProvider.performMultiplexedFetch(str1, str2, localMap, localBuilder.required(Request.get().url(state).invitationsRoute).builder(CollectionTemplate.of(InvitationView.BUILDER))).required(Request.get().url(state).invitationSummaryRoute).builder(InvitationsSummary.BUILDER)));
  }
  
  private void resetIsLoading()
  {
    new Handler().post(new PendingInvitationListFragment.3(this));
  }
  
  private void updatePageVisibilities()
  {
    int j = 0;
    Object localObject = progressBar;
    if (pageState == -1)
    {
      i = 0;
      ((ProgressBar)localObject).setVisibility(i);
      localObject = recyclerView;
      if (pageState != 0) {
        break label71;
      }
    }
    label71:
    for (int i = j;; i = 8)
    {
      ((RecyclerView)localObject).setVisibility(i);
      if ((pageState != 1) || (pageState != 2)) {
        errorOrEmptyPageViewModel.remove();
      }
      return;
      i = 8;
      break;
    }
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    return Collections.singletonList(invitationsListAdapter);
  }
  
  protected final int getTitleRes()
  {
    return 2131233434;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    fragmentComponent.inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969373, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    paramDataManagerException = getView();
    if ((paramDataManagerException == null) || (paramSet == null) || (paramType != DataStore.Type.NETWORK)) {
      return;
    }
    paramType = snackbarUtil.make(2131233411, 0);
    if (paramType != null) {
      paramType.show();
    }
    if (pageState != 0)
    {
      paramSet = new PendingInvitationListFragment.2(this, fragmentComponent.tracker(), "try_again");
      paramType = (ErrorPageViewHolder)errorOrEmptyPageViewModel.getCreator().createViewHolder(paramDataManagerException);
      errorOrEmptyPageViewModel.setupDefaultErrorConfiguration(getContext(), paramSet);
      paramSet = errorOrEmptyPageViewModel;
      paramDataManagerException = getActivity().getLayoutInflater();
      applicationComponent.mediaCenter();
      paramSet.onBindViewHolderWithErrorTracking$18b8048(paramDataManagerException, paramType, tracker, getPageInstance());
    }
    resetIsLoading();
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    boolean bool = true;
    Object localObject = getView();
    if ((localObject == null) || (paramSet == null)) {}
    label145:
    label158:
    label194:
    label442:
    label448:
    label454:
    label460:
    label553:
    label620:
    for (;;)
    {
      return;
      paramMap = pendingInvitationDataProvider;
      ProfilePendingConnectionRequestManager localProfilePendingConnectionRequestManager = profilePendingConnectionRequestManager;
      paramMap = (PendingInvitationDataProvider.State)state;
      paramMap = (CollectionTemplate)paramMap.getModel(invitationsRoute);
      int i;
      if (paramMap == null)
      {
        if ((!paramSet.contains(pendingInvitationDataProvider.state).invitationsRoute)) || (!paramSet.contains(pendingInvitationDataProvider.state).invitationSummaryRoute))) {
          break label553;
        }
        if (CollectionUtils.isEmpty(paramMap)) {
          break label460;
        }
        if (unseenInvitesCount <= 0)
        {
          paramSet = (PendingInvitationDataProvider.State)pendingInvitationDataProvider.state;
          paramSet = (InvitationsSummary)paramSet.getModel(invitationSummaryRoute);
          if (paramSet == null) {
            break label442;
          }
          i = numNewInvitations;
          unseenInvitesCount = i;
        }
        if (paramType != DataStore.Type.NETWORK) {
          break label448;
        }
        pageState = 0;
        updatePageVisibilities();
        paramSet = elements;
        paramMap = fragmentComponent;
        localObject = invitationsDataProvider;
        if (!bool) {
          break label454;
        }
        i = unseenInvitesCount;
        paramSet = InvitationCellViewTransformer.toPendingInvitationCellViewModels$1b91cb2b(paramSet, paramMap, (InvitationsDataProvider)localObject, this, i, 0, bool);
        invitationsListAdapter.setValues(paramSet);
        recyclerView.scrollToPosition(0);
        invitationsListAdapter.notifyDataSetChanged();
        if ((bool) && (paramSet.size() <= 3) && (abiCardAdapter != null))
        {
          if (abiCardAdapter != null)
          {
            paramSet = OwlTrackingUtils.trackAbookImportImpressionEvent(fragmentComponent.tracker(), fragmentComponent.lixManager(), "mobile-voyager-people-pending-invites");
            paramSet = InvitationAbiCardViewTransformer.toInvitationAbiCardViewModel(fragmentComponent, paramSet, "mobile-voyager-people-pending-invites");
            abiCardAdapter.setValues(Collections.singletonList(paramSet));
          }
          recyclerView.removeOnScrollListener(infiniteScrollListener);
        }
      }
      for (;;)
      {
        if (paramType != DataStore.Type.NETWORK) {
          break label620;
        }
        pageStart += 20;
        resetIsLoading();
        return;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = Util.safeGet(elements).iterator();
        while (localIterator.hasNext())
        {
          InvitationView localInvitationView = (InvitationView)localIterator.next();
          if ((!PendingInvitationsHelper.acceptedOrIgnored(localProfilePendingConnectionRequestManager, invitation.fromMember)) && (!PendingInvitationsHelper.acceptedOrIgnored(localProfilePendingConnectionRequestManager, invitation.toMember))) {
            localArrayList.add(localInvitationView);
          }
        }
        paramMap = paramMap.copyWithNewElements(localArrayList);
        break;
        i = 0;
        break label145;
        bool = false;
        break label158;
        i = 0;
        break label194;
        if ((pageState != 0) && (paramType == DataStore.Type.NETWORK))
        {
          paramSet = (ErrorPageViewHolder)errorOrEmptyPageViewModel.getCreator().createViewHolder((View)localObject);
          errorOrEmptyPageViewModel.errorImage = 2130838586;
          errorOrEmptyPageViewModel.errorHeaderText = getContext().getString(2131233398);
          paramMap = errorOrEmptyPageViewModel;
          localObject = getActivity().getLayoutInflater();
          applicationComponent.mediaCenter();
          paramMap.onBindViewHolder$49e9e35b((LayoutInflater)localObject, paramSet);
          continue;
          if ((paramSet.contains(pendingInvitationDataProvider.state).invitationsRoute)) && (!CollectionUtils.isEmpty(paramMap)))
          {
            paramSet = InvitationCellViewTransformer.toPendingInvitationCellViewModels$1b91cb2b(elements, fragmentComponent, invitationsDataProvider, this, unseenInvitesCount, invitationsListAdapter.getItemCount(), true);
            invitationsListAdapter.appendValues(paramSet);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    if ((type == InvitationUpdatedEvent.Type.IGNORE) || (type == InvitationUpdatedEvent.Type.ACCEPT))
    {
      int k = 0;
      int j = invitationsListAdapter.getValues().size() - 1;
      if (j >= 0)
      {
        InvitationCellViewModel localInvitationCellViewModel = (InvitationCellViewModel)invitationsListAdapter.getValues().get(j);
        int i = k;
        if (TextUtils.equals(profileId, profileId))
        {
          if (type != InvitationUpdatedEvent.Type.IGNORE) {
            break label114;
          }
          invitationsListAdapter.getValues().remove(j);
          i = 1;
        }
        for (;;)
        {
          j -= 1;
          k = i;
          break;
          label114:
          i = k;
          if (type == InvitationUpdatedEvent.Type.ACCEPT)
          {
            i = k;
            if (!isConnected)
            {
              isConnected = true;
              i = 1;
            }
          }
        }
      }
      if (k != 0) {
        invitationsListAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getArguments();
    if (paramView != null) {
      unseenInvitesCount = paramView.getInt("unseen_count");
    }
    errorOrEmptyPageViewModel = new ErrorPageViewModel(errorViewStub);
    invitationsListAdapter = new TrackableViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter());
    invitationsListAdapter.enablePageViewTracking(tracker, delayedExecution, "people_invitations_list", RelationshipsTracking.getListPageSize(fragmentComponent));
    paramView = new MergeAdapter();
    paramView.addAdapter(invitationsListAdapter);
    if (!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.LIX_GROWTH_ABI_PENDING_INVITATIONS_SHOW_ABI))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        abiCardAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
        paramView.addAdapter(abiCardAdapter);
      }
      recyclerView.setAdapter(paramView);
      recyclerView.setLayoutManager(new LinearLayoutManager((BaseActivity)getActivity()));
      infiniteScrollListener = new PendingInvitationListFragment.1(this);
      recyclerView.addOnScrollListener(infiniteScrollListener);
      fetchInitialPage();
      invitationsDataProvider.clearUnseenCount();
      fragmentComponent.eventBus();
      Bus.publish(new InvitationsViewedEvent());
      return;
    }
  }
  
  public final String pageKey()
  {
    return "people_invitations";
  }
  
  public final void removeInvitation(InvitationCellViewModel paramInvitationCellViewModel)
  {
    int i = invitationsListAdapter.getValues().indexOf(paramInvitationCellViewModel);
    if (i >= 0)
    {
      invitationsListAdapter.getValues().remove(i);
      invitationsListAdapter.notifyItemRemoved(i);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.invitations.PendingInvitationListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */