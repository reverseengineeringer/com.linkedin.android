package com.linkedin.android.relationships.connectFlow;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.LoadingAdapter;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.relationships.RelationshipsSecondaryBaseFragment;
import com.linkedin.android.relationships.pymk.PymkAdapter;
import com.linkedin.android.relationships.pymk.PymkCardTransformer;
import com.linkedin.android.relationships.shared.RelationshipsTracking;
import com.linkedin.android.relationships.widgets.VerticalSpaceItemDecoration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class ConnectFlowFragment
  extends RelationshipsSecondaryBaseFragment
{
  private int connectAction;
  private ConnectFlowDataProvider connectFlowDataProvider;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  private boolean isDataDisplayed;
  private boolean isLoading;
  private LoadingAdapter loadingAdapter;
  private MergeAdapter mergeAdapter;
  private int nextPymkPageStart;
  private String profileId;
  private PymkAdapter pymkAdapter;
  @InjectView(2131758308)
  RecyclerView recyclerView;
  private ViewModelArrayAdapter<ViewModel> topCardAdapter;
  @Inject
  ViewPortManager viewPortManager;
  
  private String getUsageContext()
  {
    if (connectAction == 1) {
      return "p-flagship3-people-accept-invite";
    }
    return "p-flagship3-people-sent-invite";
  }
  
  private void updateNextPage(CollectionTemplate paramCollectionTemplate)
  {
    if (paging != null) {
      nextPymkPageStart = (paging.start + 20);
    }
  }
  
  public final void doEnter()
  {
    super.doEnter();
    viewPortManager.trackAll(tracker);
  }
  
  public final void doPause()
  {
    super.doPause();
    viewPortManager.untrackAll();
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.connectFlowDataProvider();
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    return Collections.singletonList(pymkAdapter);
  }
  
  protected final int getTitleRes()
  {
    if (connectAction == 1) {
      return 2131233376;
    }
    return 2131233379;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    connectAction = getArguments().getInt("key_connect_action");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969346, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramType == DataStore.Type.NETWORK)
    {
      isLoading = false;
      loadingAdapter.setLoading(false, false);
      if (!isDataDisplayed)
      {
        paramSet = new ConnectFlowFragment.2(this, fragmentComponent.tracker(), "try_again");
        paramType = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
        errorPageViewModel.setupDefaultErrorConfiguration(getContext(), paramSet);
        paramSet = errorPageViewModel;
        paramDataManagerException = getActivity().getLayoutInflater();
        applicationComponent.mediaCenter();
        paramSet.onBindViewHolderWithErrorTracking$18b8048(paramDataManagerException, paramType, tracker, getPageInstance());
      }
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    loadingAdapter.setLoading(false, false);
    if (paramType == DataStore.Type.NETWORK) {
      isLoading = false;
    }
    paramType = connectFlowDataProvider;
    int i;
    if ((paramSet != null) && (paramSet.contains(state).miniProfileRoute)))
    {
      i = 1;
      if (i == 0) {
        break label388;
      }
      paramType = (ConnectFlowDataProvider.State)connectFlowDataProvider.state;
      paramSet = (MiniProfile)paramType.getModel(miniProfileRoute);
      if (paramSet != null) {
        break label91;
      }
    }
    label91:
    label388:
    do
    {
      return;
      i = 0;
      break;
      viewPortManager.clearAll();
      if (connectAction == 1)
      {
        paramMap = fragmentComponent;
        paramType = new ConnectFlowMiniTopCardViewModel();
        paramMap.i18NManager();
        headline = paramMap.i18NManager().getSpannedString(2131233377, new Object[] { I18NManager.getName(paramSet) });
        profileImage = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, paramSet), Util.retrieveRumSessionId(paramMap));
        cellClickListener = ConnectFlowActionHelper.createViewProfileClickListener(paramMap, paramSet);
        showMessageButton = true;
        messageButtonClickListener = ConnectFlowActionHelper.createOpenMessageClickListener(paramMap, paramSet);
      }
      for (;;)
      {
        topCardAdapter.setValues(Collections.singletonList(paramType));
        if (!isDataDisplayed)
        {
          isDataDisplayed = true;
          errorPageViewModel.remove();
        }
        paramType = connectFlowDataProvider.getPeopleYouMayKnow();
        if (CollectionUtils.isEmpty(paramType)) {
          break;
        }
        paramSet = new ArrayList();
        paramSet.add(PymkCardTransformer.toPymkHeaderCell(fragmentComponent));
        paramSet.addAll(PymkCardTransformer.toPeopleYouMayKnowCellList(fragmentComponent, elements, getUsageContext()));
        updateNextPage(paramType);
        pymkAdapter.setValues(paramSet);
        return;
        paramMap = fragmentComponent;
        paramType = new ConnectFlowMiniTopCardViewModel();
        headline = paramMap.i18NManager().getSpannedString(2131233378, new Object[] { I18NManager.getName(paramSet) });
        profileImage = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, paramSet), Util.retrieveRumSessionId(paramMap));
        cellClickListener = ConnectFlowActionHelper.createViewProfileClickListener(paramMap, paramSet);
        showMessageButton = false;
      }
      paramType = connectFlowDataProvider.getPeopleYouMayKnow();
    } while (CollectionUtils.isEmpty(paramType));
    pymkAdapter.appendValues(PymkCardTransformer.toPeopleYouMayKnowCellList(fragmentComponent, elements, getUsageContext()));
    updateNextPage(paramType);
  }
  
  public void onDestroyView()
  {
    Bus.unsubscribe(pymkAdapter);
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    profileId = getArguments().getString("key_profile_id");
    if (profileId == null)
    {
      Util.safeThrow(new RuntimeException("Cannot have pass null profileId into ConnectFlowFragment as bundle data"));
      return;
    }
    mergeAdapter = new MergeAdapter();
    topCardAdapter = new ViewModelArrayAdapter(getActivity(), fragmentComponent.mediaCenter(), null);
    pymkAdapter = new PymkAdapter(fragmentComponent, mergeAdapter);
    loadingAdapter = new LoadingAdapter();
    mergeAdapter.addAdapter(topCardAdapter);
    mergeAdapter.addAdapter(pymkAdapter);
    mergeAdapter.addAdapter(loadingAdapter);
    if (connectAction == 1) {}
    for (paramView = "people_invite_accept_landing_pymk";; paramView = "people_invite_sent_landing_pymk")
    {
      pymkAdapter.enablePageViewTracking(fragmentComponent.tracker(), fragmentComponent.delayedExecution(), paramView, RelationshipsTracking.getListPageSize(fragmentComponent));
      recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      recyclerView.setAdapter(mergeAdapter);
      int i = (int)getResources().getDimension(2131492993);
      recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(1, i));
      viewPortManager.container = recyclerView;
      mergeAdapter.setViewPortManager(viewPortManager);
      recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
      paramView = new ConnectFlowFragment.1(this);
      recyclerView.addOnScrollListener(paramView);
      connectFlowDataProvider = fragmentComponent.activity().activityComponent.connectFlowDataProvider();
      connectFlowDataProvider.fetchInitialData$5f5e66bf(busSubscriberId, getRumSessionId(), profileId, getUsageContext(), Tracker.createPageInstanceHeader(getPageInstance()));
      isLoading = true;
      return;
    }
  }
  
  public final String pageKey()
  {
    if (connectAction == 1) {
      return "people_invite_accept_landing";
    }
    return "people_invite_sent_landing";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.connectFlow.ConnectFlowFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */