package com.linkedin.android.relationships.addConnections;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.calendar.CalendarSyncHelper;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.infra.LoadingAdapter;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.viewmodel.TrackableViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.relationships.RelationshipsSecondaryBaseFragment;
import com.linkedin.android.relationships.pymk.PymkAdapter;
import com.linkedin.android.relationships.pymk.PymkCardTransformer;
import com.linkedin.android.relationships.pymk.PymkHelper;
import com.linkedin.android.relationships.shared.RelationshipsTracking;
import com.linkedin.android.relationships.widgets.VerticalSpaceItemDecoration;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

public class AddConnectionsFragment
  extends RelationshipsSecondaryBaseFragment
{
  private TrackableViewModelArrayAdapter<CalendarCellViewModel> calendarCellAdapter;
  private TrackableViewModelArrayAdapter<ContactsCellViewModel> contactsCellAdapter;
  private boolean isLoading;
  private LoadingAdapter loadingAdapter;
  private MergeAdapter mergeAdapter;
  private int nextPageStart;
  private PymkAdapter pymkAdapter;
  private PymkDataProvider pymkDataProvider;
  @InjectView(2131758307)
  RecyclerView recyclerView;
  private List<ScreenElement> screenElements;
  @Inject
  ViewPortManager viewPortManager;
  
  private boolean showCalendarSyncButtonCell()
  {
    return !"control".equals(fragmentComponent.lixManager().getTreatment(Lix.MYNETWORK_CALENDAR_SYNC_BUTTON));
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
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.pymkDataProvider();
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    if (screenElements == null)
    {
      screenElements = new ArrayList();
      screenElements.add(contactsCellAdapter);
      if (showCalendarSyncButtonCell()) {
        screenElements.add(calendarCellAdapter);
      }
      screenElements.add(pymkAdapter);
    }
    return screenElements;
  }
  
  protected final int getTitleRes()
  {
    return 2131233360;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final void onCollectionDataEvent(int paramInt, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString1, String paramString2)
  {
    if (!isAdded()) {
      return;
    }
    if (paramType == DataStore.Type.LOCAL) {}
    for (boolean bool = true;; bool = false)
    {
      paramType = pymkDataProvider;
      paramCollectionTemplate = profilePendingConnectionRequestManager;
      paramType = (PymkDataProvider.State)state;
      paramType = PymkHelper.filterPendingInvitesPeopleYouMayKnow(paramCollectionTemplate, (CollectionTemplate)paramType.getModel(peopleYouMayKnowRoute));
      if (!CollectionUtils.isEmpty(paramType))
      {
        if (paramString2 != null) {
          RUMTiming.renderStart(paramString2, bool);
        }
        paramCollectionTemplate = PymkCardTransformer.toPeopleYouMayKnowCellList(fragmentComponent, elements, "p-flagship3-people-add-connections");
        paramType = paging;
        if (paramType != null)
        {
          if (start == 0)
          {
            viewPortManager.clearAll();
            pymkAdapter.clear();
            pymkAdapter.appendValues(Collections.singletonList(PymkCardTransformer.toPymkHeaderCell(fragmentComponent)));
          }
          pymkAdapter.appendValues(paramCollectionTemplate);
          nextPageStart = (start + 20);
        }
        if (paramString2 != null) {
          RUMHelper.callRenderEndOnNextLoop(paramString2, bool);
        }
      }
      loadingAdapter.setLoading(false, false);
      new Handler().post(new AddConnectionsFragment.2(this));
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969345, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramType == DataStore.Type.NETWORK) {
      loadingAdapter.setLoading(false, false);
    }
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
    paramView = new ContactsCellViewModel();
    contactsCellAdapter = new TrackableViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter());
    contactsCellAdapter.appendValues(Collections.singletonList(paramView));
    contactsCellAdapter.enablePageViewTracking(tracker, delayedExecution, "people_add_connections_abi", 1);
    paramBundle = OwlTrackingUtils.trackAbookImportImpressionEvent(tracker, fragmentComponent.lixManager(), "mobile-voyager-people-add-connections");
    clickListener = new AddConnectionsFragment.3(this, tracker, "abi", new TrackingEventBuilder[0], paramBundle);
    mergeAdapter = new MergeAdapter();
    paramView = new CalendarCellViewModel();
    calendarCellAdapter = new TrackableViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter());
    calendarCellAdapter.appendValues(Collections.singletonList(paramView));
    calendarCellAdapter.enablePageViewTracking(tracker, delayedExecution, "people_add_connections_calendar_sync", 1);
    clickListener = CalendarSyncHelper.buildOnClickListenerToGoToSplashPage(fragmentComponent, "calendar_sync", null);
    pymkAdapter = new PymkAdapter(fragmentComponent, mergeAdapter);
    pymkAdapter.offset = 1;
    pymkAdapter.enablePageViewTracking(fragmentComponent.tracker(), fragmentComponent.delayedExecution(), "people_add_connections_pymk", RelationshipsTracking.getListPageSize(fragmentComponent));
    loadingAdapter = new LoadingAdapter();
    mergeAdapter.addAdapter(contactsCellAdapter);
    boolean bool = showCalendarSyncButtonCell();
    if (bool) {
      mergeAdapter.addAdapter(calendarCellAdapter);
    }
    mergeAdapter.addAdapter(pymkAdapter);
    mergeAdapter.addAdapter(loadingAdapter);
    paramView = recyclerView;
    int j = contactsCellAdapter.getItemCount();
    if (bool) {}
    for (int i = calendarCellAdapter.getItemCount();; i = 0)
    {
      paramView.addItemDecoration(new VerticalSpaceItemDecoration(i + j, (int)getResources().getDimension(2131492993)));
      recyclerView.setAdapter(mergeAdapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      recyclerView.addOnScrollListener(new AddConnectionsFragment.1(this));
      viewPortManager.container = recyclerView;
      mergeAdapter.setViewPortManager(viewPortManager);
      recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
      if ((BaseActivity)getActivity() != null)
      {
        pymkDataProvider = getActivityactivityComponent.pymkDataProvider();
        pymkDataProvider.fetchData$379dfc29(busSubscriberId, getRumSessionId(), 0);
        isLoading = true;
        loadingAdapter.setLoading(true, false);
      }
      return;
    }
  }
  
  public final String pageKey()
  {
    return "people_add_connections";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.addConnections.AddConnectionsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */