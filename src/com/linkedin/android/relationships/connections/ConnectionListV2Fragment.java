package com.linkedin.android.relationships.connections;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.ViewHolderCreator;
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
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.TrackableViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.ConnectionSortType;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.relationships.shared.RelationshipsTracking;
import com.linkedin.android.relationships.widgets.fastScoller.RecyclerViewFastScrollerLayout;
import com.linkedin.android.relationships.widgets.superslim.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class ConnectionListV2Fragment
  extends PageFragment
{
  @Inject
  ActivityComponent activityComponent;
  private ConnectionSectionAdapter connectionSectionAdapter;
  private ConnectionSortType connectionSortType;
  private TrackableViewModelArrayAdapter<ConnectionCellViewModel> connectionsListAdapter;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @InjectView(2131758323)
  RecyclerViewFastScrollerLayout fastScrollerLayout;
  @Inject
  FragmentComponent fragmentComponent;
  private boolean hasLocalData;
  private boolean isDataDisplayed;
  @InjectView(2131756626)
  ProgressBar progressBar;
  @InjectView(2131758324)
  RecyclerView recyclerView;
  private String rumSessionId;
  private List<ScreenElement> screenElements;
  
  private void fetchConnectionsFromDB()
  {
    String str;
    switch (ConnectionListV2Fragment.6.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$relationships$shared$connection$ConnectionSortType[connectionSortType.ordinal()])
    {
    default: 
      str = "firstName";
    }
    for (;;)
    {
      new ConnectionListV2Fragment.4(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
      str = "firstName";
      continue;
      str = "lastName";
    }
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.connectionsV2DataProvider();
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    if (screenElements == null)
    {
      screenElements = new ArrayList();
      screenElements.add(connectionsListAdapter);
    }
    return screenElements;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    paramBundle = fragmentComponent.context().getResources().getConfiguration().locale.getLanguage();
    int i = -1;
    switch (paramBundle.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (paramBundle = ConnectionSortType.FIRSTNAME_LASTNAME;; paramBundle = ConnectionSortType.LASTNAME_FIRSTNAME)
    {
      connectionSortType = paramBundle;
      return;
      if (!paramBundle.equals("ja")) {
        break;
      }
      i = 0;
      break;
      if (!paramBundle.equals("zh")) {
        break;
      }
      i = 1;
      break;
      if (!paramBundle.equals("ko")) {
        break;
      }
      i = 2;
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969351, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (!isDataDisplayed)
    {
      progressBar.setVisibility(8);
      recyclerView.setVisibility(8);
      fastScrollerLayout.setVisibility(8);
      paramSet = new ConnectionListV2Fragment.2(this, fragmentComponent.tracker(), "try_again");
      paramType = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
      errorPageViewModel.setupDefaultErrorConfiguration(getContext(), paramSet);
      paramSet = errorPageViewModel;
      paramDataManagerException = getActivity().getLayoutInflater();
      applicationComponent.mediaCenter();
      paramSet.onBindViewHolderWithErrorTracking$18b8048(paramDataManagerException, paramType, tracker, getPageInstance());
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (!isAdded()) {}
    while (hasLocalData) {
      return;
    }
    if (rumSessionId != null)
    {
      paramSet = rumSessionId;
      if (DataStore.Type.NETWORK == paramType) {
        break label262;
      }
    }
    label262:
    for (boolean bool = true;; bool = false)
    {
      RUMTiming.renderStart(paramSet, bool);
      paramSet = ((ConnectionsV2DataProvider.State)activityComponent.connectionsV2DataProvider().state).connections();
      if ((paramType != DataStore.Type.NETWORK) || (!CollectionUtils.isEmpty(paramSet))) {
        break;
      }
      progressBar.setVisibility(8);
      recyclerView.setVisibility(8);
      fastScrollerLayout.setVisibility(8);
      paramType = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
      errorPageViewModel.errorImage = 2130838478;
      errorPageViewModel.errorHeaderText = getContext().getString(2131233397);
      errorPageViewModel.errorDescriptionText = getContext().getString(2131233396);
      errorPageViewModel.errorButtonText = getContext().getString(2131233395);
      paramSet = OwlTrackingUtils.trackAbookImportImpressionEvent(tracker, fragmentComponent.lixManager(), "mobile-voyager-people-connections");
      errorPageViewModel.onErrorButtonClick = new ConnectionListV2Fragment.3(this, fragmentComponent.tracker(), "abi", paramSet);
      paramSet = errorPageViewModel;
      paramMap = getActivity().getLayoutInflater();
      applicationComponent.mediaCenter();
      paramSet.onBindViewHolder$49e9e35b(paramMap, paramType);
      return;
    }
    new ConnectionListV2Fragment.5(this, new ArrayList(elements), paramType).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  @Subscribe
  public void onEvent(ConnectionListSortChangeEvent paramConnectionListSortChangeEvent)
  {
    connectionSortType = connectionSortType;
    connectionSectionAdapter.connectionSortType = connectionSortType;
    fetchConnectionsFromDB();
  }
  
  @Subscribe
  public void onEvent(RemoveConnectionEvent paramRemoveConnectionEvent)
  {
    Object localObject = connection;
    if (entityUrn == null)
    {
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("fail to delete connection, connection has null entityUrn"));
      return;
    }
    int i = 0;
    while (i < connectionsListAdapter.getValues().size())
    {
      if (connectionsListAdapter.getValues().get(i)).connectionId.equals(entityUrn.getId()))
      {
        connectionsListAdapter.getValues().remove(i);
        connectionsListAdapter.notifyItemRemoved(i);
      }
      i += 1;
    }
    paramRemoveConnectionEvent = activityComponent.connectionsV2DataProvider();
    fragmentComponent.context();
    localObject = entityUrn.getId();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    ConnectionListV2Fragment.DeleteCollectionModelListener localDeleteCollectionModelListener = new ConnectionListV2Fragment.DeleteCollectionModelListener(this);
    if (((ConnectionsV2DataProvider.State)state).connections() != null) {}
    for (i = 1; i == 0; i = 0)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot remove connection when data is not loaded, please call loadConnections() method first"));
      return;
    }
    dataManager.submit(Request.delete().customHeaders(localMap).url(Routes.CONNECTIONS.buildUponRoot().buildUpon().appendPath((String)localObject).build().toString()).listener(localDeleteCollectionModelListener));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    progressBar.animate();
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    connectionsListAdapter = new TrackableViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter());
    connectionsListAdapter.enablePageViewTracking(tracker, delayedExecution, "people_connections_list", RelationshipsTracking.getListPageSize(fragmentComponent));
    connectionSectionAdapter = new ConnectionSectionAdapter(getActivity(), connectionsListAdapter, connectionSortType);
    recyclerView.setAdapter(connectionSectionAdapter);
    recyclerView.setLayoutManager(new LayoutManager(getActivity()));
    fastScrollerLayout.setFastScrollerDelegate(new ConnectionListV2Fragment.1(this));
    fetchConnectionsFromDB();
  }
  
  public final String pageKey()
  {
    return "people_connections";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.connections.ConnectionListV2Fragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */