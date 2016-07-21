package com.linkedin.android.feed.page.feed;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.feed.FeedUpdatesDataProvider.State;
import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.actions.UpdateActionPublisher.DeleteUpdateActionListener;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformerConstants;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.utils.FeedCollectionHelper;
import com.linkedin.android.feed.utils.FeedKeyValueStore;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.consistency.ModelListItemChangedListener;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public abstract class BaseFeedFragment
  extends FeedTrackableFragment
  implements FeedPageType, VoyagerShakeDelegate.ShakeDebugDataProvider
{
  private ActivityComponent activityComponent;
  private Throwable errorForErrorScreen;
  public FeedAdapter feedAdapter;
  private CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>> feedDataProviderListener;
  public FeedUpdatesDataProvider feedUpdatesDataProvider;
  protected boolean initialLoadComplete;
  protected boolean isDataReady;
  protected RecyclerView.LayoutManager layoutManager;
  private boolean loadMoreFailed;
  @InjectView(2131755797)
  RecyclerView recyclerView;
  protected final RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener()
  {
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (!isActive()) {}
      label62:
      do
      {
        return;
        loadMoreUpdatesIfNecessary();
        if (!paramAnonymousRecyclerView.canScrollVertically(-1)) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 == 0) {
            break label62;
          }
          if (swipeRefreshLayout.isEnabled()) {
            break;
          }
          swipeRefreshLayout.setEnabled(true);
          return;
        }
      } while (!swipeRefreshLayout.isEnabled());
      swipeRefreshLayout.setEnabled(false);
    }
  };
  @InjectView(2131755796)
  public SwipeRefreshLayout swipeRefreshLayout;
  protected final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  public FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  @Inject
  ViewPortManager viewPortManager;
  
  private void collapseUpdate(UpdateActionEvent paramUpdateActionEvent)
  {
    collapseUpdate(update, updateAction);
  }
  
  protected final void collapseUpdate(Update paramUpdate, UpdateActionModel paramUpdateActionModel)
  {
    ModelTransformedCallback local6 = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (!isAdded()) {
          return;
        }
        feedAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel);
      }
    };
    FragmentComponent localFragmentComponent = fragmentComponent;
    localFragmentComponent.updateChangeCoordinator().setCollapsed(urn, paramUpdateActionModel);
    FeedViewTransformer.toCollapsedViewModel(localFragmentComponent, viewPool, paramUpdate, paramUpdateActionModel, local6);
  }
  
  public FeedAdapter createFeedAdapter()
  {
    return new FeedAdapter(getActivity(), applicationComponent, this);
  }
  
  public abstract void deleteUpdate(String paramString);
  
  public void displayInitialUpdates(CollectionTemplate<Update, Metadata> paramCollectionTemplate, List<FeedUpdateViewModel> paramList, DataStore.Type paramType)
  {
    resetFeedAdapter(paramList);
  }
  
  protected void displayRefreshUpdates(CollectionTemplate<Update, Metadata> paramCollectionTemplate, List<FeedUpdateViewModel> paramList, DataStore.Type paramType)
  {
    feedAdapter.lastPageTracked = -1;
    resetFeedAdapter(paramList);
  }
  
  public void doEnter()
  {
    super.doEnter();
    if (viewPortManager != null) {
      viewPortManager.trackAll(tracker);
    }
    if (feedAdapter != null) {
      feedAdapter.onScreen = true;
    }
  }
  
  public void doLeave()
  {
    super.doLeave();
    if (viewPortManager != null) {
      viewPortManager.untrackAll();
    }
    if (feedAdapter != null) {
      feedAdapter.onLeave();
    }
  }
  
  public void doResume()
  {
    super.doResume();
    if ((!initialLoadComplete) && (feedUpdatesDataProvider != null))
    {
      int i = filterForInitialFetch();
      feedUpdatesDataProvider.performInitialFetch(Tracker.createPageInstanceHeader(getPageInstance()), i, getRumSessionId(), getInitialFetchRoute());
      onInitialFetchRequested(i);
    }
  }
  
  protected int filterForInitialFetch()
  {
    return 2;
  }
  
  public final void getFeedUpdateViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate, ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel> paramModelTransformedCallback)
  {
    fragmentComponent.updateChangeCoordinator().listenForUpdates(paramUpdate, updateChangedListener);
    FeedViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, paramUpdate, FeedDataModelMetadata.DEFAULT, paramModelTransformedCallback);
  }
  
  protected void getFeedUpdateViewModels(List<Update> paramList, ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsTransformedCallback)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramModelsTransformedCallback.onModelsTransformed(ModelTransformerConstants.emptyListData());
      return;
    }
    fragmentComponent.updateChangeCoordinator().listenForUpdates(paramList, updateChangedListener);
    FeedViewTransformer.toViewModels(fragmentComponent, viewPool, paramList, FeedDataModelMetadata.DEFAULT, paramModelsTransformedCallback);
  }
  
  public final int getFeedWidth()
  {
    int j = getResourcesgetDisplayMetricswidthPixels;
    int i = j;
    if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_STAGGERED_GRID_LAYOUT)) {
      i = j / getResources().getInteger(2131558403);
    }
    return i;
  }
  
  public abstract String getInitialFetchRoute();
  
  public abstract Uri getLoadMoreRoute();
  
  public abstract String getLogTag();
  
  public FeedUpdatesDataProvider getUpdatesDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.feedUpdatesDataProvider();
  }
  
  public void hideErrorView()
  {
    errorForErrorScreen = null;
  }
  
  public final boolean isActive()
  {
    return (isAdded()) && (recyclerView != null);
  }
  
  protected final void loadMoreUpdatesIfNecessary()
  {
    int i = 1;
    Uri localUri = getLoadMoreRoute();
    Object localObject;
    if (localUri != null)
    {
      localObject = layoutManager;
      if (com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(localObject)[1] < ((RecyclerView.LayoutManager)localObject).getItemCount() - Math.max(1, FeedLixHelper.parseInt$7e416bce(applicationComponent.lixManager(), Lix.FEED_PREFETCH_UPDATES, 0))) {
        break label109;
      }
    }
    for (;;)
    {
      if ((i != 0) && (feedUpdatesDataProvider != null))
      {
        if ((!feedUpdatesDataProvider.state).collectionHelper.hasMoreDataToFetch()) || (loadMoreFailed)) {
          break;
        }
        localObject = RUMHelper.pageInitLoadMore(this);
        feedUpdatesDataProvider.loadMoreData$727f7092(Tracker.createPageInstanceHeader(getPageInstance()), (String)localObject, localUri);
      }
      return;
      label109:
      i = 0;
    }
    onNoMoreData();
  }
  
  protected final void nukeFeed()
  {
    viewPortManager.untrackAll();
    if (feedAdapter != null) {
      feedAdapter.clear();
    }
    if (feedUpdatesDataProvider != null)
    {
      String str = RUMHelper.pageInitRefresh(this);
      feedUpdatesDataProvider.refreshFeed(Tracker.createPageInstanceHeader(getPageInstance()), FeedRouteUtils.getFeedUpdatesRoute(fragmentComponent, getFeedWidth()), str);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity = (BaseActivity)getActivity();
    if (paramActivity != null)
    {
      activityComponent = activityComponent;
      feedUpdatesDataProvider = getUpdatesDataProvider(activityComponent);
      feedDataProviderListener = new CollectionDataProvider.CollectionDataProviderListener()
      {
        public final void onDataFinishedLoading(DataStore.Type paramAnonymousType, DataManagerException paramAnonymousDataManagerException)
        {
          if (!isActive()) {
            return;
          }
          if ((paramAnonymousDataManagerException != null) && (paramAnonymousType == DataStore.Type.NETWORK))
          {
            showErrorView(paramAnonymousDataManagerException);
            return;
          }
          hideErrorView();
        }
        
        public final void onFetching()
        {
          isDataReady = false;
          if (!isActive()) {}
          while ((swipeRefreshLayout == null) || (swipeRefreshLayout.mRefreshing)) {
            return;
          }
          BaseFeedFragment.access$100(BaseFeedFragment.this, true);
        }
        
        public final void onFinishedFetching()
        {
          isDataReady = true;
          if (!isActive()) {}
          while ((swipeRefreshLayout == null) || (!swipeRefreshLayout.mRefreshing)) {
            return;
          }
          swipeRefreshLayout.setRefreshing(false);
        }
      };
      feedUpdatesDataProvider.addListener(feedDataProviderListener);
    }
    feedAdapter = createFeedAdapter();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((layoutManager instanceof StaggeredGridLayoutManager))
    {
      int j = layoutManager).mSpanCount;
      int i = getResources().getInteger(2131558403);
      if (j != i)
      {
        j = com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(layoutManager)[0];
        layoutManager = new StaggeredGridLayoutManager(i, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.scrollToPosition(j);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public void onDestroyView()
  {
    if (recyclerView != null)
    {
      recyclerView.setAdapter(null);
      recyclerView.clearOnScrollListeners();
    }
    if (layoutManager != null)
    {
      if ((layoutManager instanceof LinearLayoutManager)) {
        layoutManager).mRecycleChildrenOnDetach = true;
      }
      layoutManager = null;
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    fragmentComponent.updateChangeCoordinator().removeListener(updateChangedListener);
    feedAdapter = null;
    if (feedUpdatesDataProvider != null) {
      feedUpdatesDataProvider.removeListener(feedDataProviderListener);
    }
    feedUpdatesDataProvider = null;
    feedDataProviderListener = null;
    activityComponent = null;
  }
  
  @Subscribe
  public void onEvent(UpdateActionEvent paramUpdateActionEvent)
  {
    if (!isActive) {
      return;
    }
    final Update localUpdate = update;
    final UpdateActionModel localUpdateActionModel = updateAction;
    final FragmentComponent localFragmentComponent = fragmentComponent;
    switch (type)
    {
    }
    for (;;)
    {
      UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(getPageInstance()), localFragmentComponent, urn.toString(), localUpdateActionModel, localUpdate);
      return;
      UpdateActionPublisher.showDeleteConfirmationDialog$79962340(localFragmentComponent, new UpdateActionPublisher.DeleteUpdateActionListener()
      {
        public final void onDeleteUpdateAction()
        {
          deleteUpdate(localUpdateurn.toString());
          UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(getPageInstance()), localFragmentComponent, localUpdateurn.toString(), localUpdateActionModel, localUpdate);
        }
      });
      return;
      nukeFeed();
      return;
      collapseUpdate(paramUpdateActionEvent);
      return;
      UpdateActionPublisher.sendShareViaIntent(this, paramUpdateActionEvent);
      return;
      UpdateActionPublisher.editShare(this, paramUpdateActionEvent);
      return;
      collapseUpdate(paramUpdateActionEvent);
    }
  }
  
  protected void onInitialFetchRequested(int paramInt) {}
  
  protected void onNoMoreData() {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (feedAdapter == null)
    {
      getActivity();
      Util.safeThrow$7a8b4789(new RuntimeException("Should not call getViewState() after fragment is destroyed"));
    }
    for (ViewState localViewState = new ViewState();; localViewState = feedAdapter.getViewState())
    {
      paramBundle.putParcelable("BaseFeedUpdatesFragment", localViewState);
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setupRecyclerView();
    setupScrollListeners();
    setupRefreshListener();
    paramView = null;
    if (paramBundle != null) {
      paramView = (ViewState)paramBundle.getParcelable("BaseFeedUpdatesFragment");
    }
    if (paramView != null)
    {
      paramBundle = feedAdapter;
      if (paramView == null) {
        Util.safeThrow$7a8b4789(new RuntimeException("Can't pass null to setViewState!"));
      }
    }
    else
    {
      return;
    }
    viewState = paramView;
  }
  
  public final String provideDebugData()
  {
    if (layoutManager == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(layoutManager)[0];
    int j = com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(layoutManager)[1];
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((i != -1) && (j != -1))
    {
      localObject1 = new ArrayList();
      localObject2 = feedAdapter.getValues();
      if ((i <= j) && (i < ((List)localObject2).size()))
      {
        localObject3 = (FeedItemViewModel)((List)localObject2).get(i);
        if ((localObject3 instanceof FeedUpdateViewModel)) {
          ((List)localObject1).add(updateUrn);
        }
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject1).add("(item)");
        }
      }
      localArrayList.add("Feed Activity Ids:" + TextUtils.join(", ", (Iterable)localObject1));
    }
    if (errorForErrorScreen != null)
    {
      localObject3 = errorForErrorScreen.toString();
      localObject1 = null;
      if ((errorForErrorScreen instanceof DataManagerException)) {
        localObject1 = errorForErrorScreen).errorResponse;
      }
      localObject2 = localObject3;
      if (localObject1 != null) {
        localObject2 = (String)localObject3 + " with status code " + ((RawResponse)localObject1).code();
      }
      localArrayList.add("Last Feed Error: " + (String)localObject2);
    }
    return TextUtils.join("\n", localArrayList);
  }
  
  public void resetFeedAdapter(List<? extends FeedItemViewModel> paramList)
  {
    viewPortManager.untrackAll();
    feedAdapter.clearViewState();
    feedAdapter.setValues(paramList);
    if (recyclerView != null) {
      recyclerView.scrollToPosition(0);
    }
  }
  
  protected void setupRecyclerView()
  {
    if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_STAGGERED_GRID_LAYOUT)) {}
    for (layoutManager = new StaggeredGridLayoutManager(getResources().getInteger(2131558403), 1);; layoutManager = new LinearLayoutManager(getActivity()))
    {
      recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(feedAdapter);
      recyclerView.setVerticalScrollBarEnabled(FeedLixHelper.showScrollbars(fragmentComponent.lixManager()));
      viewPortManager.container = recyclerView;
      feedAdapter.setViewPortManager(viewPortManager);
      return;
    }
  }
  
  public abstract void setupRefreshListener();
  
  protected void setupScrollListeners()
  {
    if (recyclerView != null)
    {
      recyclerView.clearOnScrollListeners();
      recyclerView.addOnScrollListener(scrollListener);
      recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
    }
  }
  
  public void showEmptyMessage() {}
  
  public void showErrorView(Throwable paramThrowable)
  {
    errorForErrorScreen = paramThrowable;
  }
  
  protected final void updateMostRecentFeedTime(long paramLong)
  {
    fragmentComponent.feedValues().setMostRecentFeedTime(paramLong);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.BaseFeedFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */