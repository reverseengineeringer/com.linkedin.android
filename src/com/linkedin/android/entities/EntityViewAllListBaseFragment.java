package com.linkedin.android.entities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.ui.DividerItemDecoration;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import java.util.List;
import java.util.Set;

public abstract class EntityViewAllListBaseFragment
  extends PageFragment
{
  private static final String TAG = EntityViewAllListBaseFragment.class.getSimpleName();
  public EndlessViewModelAdapter<ViewModel> arrayAdapter;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131755460)
  protected ViewStub errorViewStub;
  private boolean isDataDisplayed;
  private LinearLayoutManager layoutManager;
  @InjectView(2131755459)
  protected ViewGroup loadingSpinner;
  @InjectView(2131755458)
  public RecyclerView recyclerView;
  public boolean shouldTrackImpressions;
  @InjectView(2131755468)
  public Toolbar toolbar;
  private ViewPortManager viewPortManager;
  
  public final void doEnter()
  {
    super.doEnter();
    if (shouldTrackImpressions) {
      viewPortManager.trackAll(tracker);
    }
  }
  
  public final void doLeave()
  {
    if (shouldTrackImpressions) {
      viewPortManager.untrackAll();
    }
    super.doLeave();
  }
  
  public abstract DataLoadListener getDataLoadListener();
  
  public EndlessViewModelAdapter getEndlessViewModelAdapter(List<ViewModel> paramList)
  {
    return new EndlessViewModelAdapter(getActivity(), applicationComponent.mediaCenter(), paramList);
  }
  
  public List<ViewModel> getHeaderViewModels()
  {
    return null;
  }
  
  public abstract TrackingClosure<Void, Void> getOnErrorButtonClickClosure();
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final String loadMorePageKey()
  {
    return pageKey() + "_load_more";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    fragmentComponent.inject(this);
    paramBundle = setupInitialRows();
    if (paramBundle == null) {
      loadingSpinner.setVisibility(0);
    }
    arrayAdapter = getEndlessViewModelAdapter(paramBundle);
    recyclerView.setAdapter(arrayAdapter);
    if (shouldTrackImpressions)
    {
      viewPortManager = applicationComponent.viewportManager();
      viewPortManager.container = recyclerView;
      arrayAdapter.setViewPortManager(viewPortManager);
      paramBundle = new RecyclerViewPortListener(viewPortManager);
      recyclerView.addOnScrollListener(paramBundle);
    }
  }
  
  protected void onCollectionDataEvent(int paramInt, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString1, String paramString2)
  {
    if (!isDataDisplayed)
    {
      if (!CollectionUtils.isNonEmpty(elements)) {
        break label69;
      }
      isDataDisplayed = true;
      loadingSpinner.setVisibility(8);
      recyclerView.setVisibility(0);
      errorPageViewModel.remove();
      paramString1 = getDataLoadListener();
      if (paramString1 != null) {
        paramString1.onSuccess(paramCollectionTemplate, paramType, getRumSessionId());
      }
    }
    label69:
    while (paramType != DataStore.Type.NETWORK) {
      return;
    }
    showErrorPage();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968676, paramViewGroup, false);
  }
  
  public void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((!isDataDisplayed) && (paramType == DataStore.Type.NETWORK)) {
      showErrorPage();
    }
    arrayAdapter.showLoadingView(false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    isDataDisplayed = false;
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    setupItemDividers();
    toolbar.setBackgroundColor(ContextCompat.getColor(getContext(), 2131624108));
    toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), 2131624058));
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        NavigationUtils.onUpPressed(getActivity(), false);
      }
    });
    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    setupBackgroundColor();
  }
  
  public void setupBackgroundColor()
  {
    recyclerView.setBackgroundColor(ContextCompat.getColor(getContext(), 2131624058));
  }
  
  public abstract List<ViewModel> setupInitialRows();
  
  public void setupItemDividers()
  {
    DividerItemDecoration localDividerItemDecoration = new DividerItemDecoration(1);
    ActivityComponent localActivityComponent = getActivityactivityComponent;
    localDividerItemDecoration.setStartMargin(localActivityComponent.context().getResources(), 2131493095);
    localDividerItemDecoration.setEndMargin$7828b937(localActivityComponent.context().getResources());
    localDividerItemDecoration.setDivider(localActivityComponent.context().getResources(), 2130837654);
    recyclerView.addItemDecoration(localDividerItemDecoration);
  }
  
  public final void setupLoadMoreScrollListener(final CollectionTemplateHelper paramCollectionTemplateHelper, final String paramString)
  {
    paramCollectionTemplateHelper = new InfiniteScrollListener()
    {
      public final void loadMore()
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramCollectionTemplateHelper.hasMoreDataToFetch()))
        {
          arrayAdapter.showLoadingView(true);
          EntityViewAllListBaseFragment.DataLoadListener localDataLoadListener = getDataLoadListener();
          if (localDataLoadListener != null)
          {
            String str = RUMHelper.pageInitLoadMore(EntityViewAllListBaseFragment.this);
            paramCollectionTemplateHelper.fetchLoadMoreData(Tracker.createPageInstanceHeader(getPageInstance()), 0, null, Uri.parse(paramString), localDataLoadListener, str);
          }
        }
        else
        {
          return;
        }
        arrayAdapter.showLoadingView(false);
      }
    };
    recyclerView.addOnScrollListener(paramCollectionTemplateHelper);
  }
  
  public final void showErrorPage()
  {
    if ((!isAdded()) || (getView() == null)) {
      return;
    }
    isDataDisplayed = false;
    loadingSpinner.setVisibility(8);
    recyclerView.setVisibility(8);
    ErrorPageViewHolder localErrorPageViewHolder = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
    errorPageViewModel.setupDefaultErrorConfiguration(getContext(), getOnErrorButtonClickClosure());
    ErrorPageViewModel localErrorPageViewModel = errorPageViewModel;
    LayoutInflater localLayoutInflater = getActivity().getLayoutInflater();
    fragmentComponent.mediaCenter();
    localErrorPageViewModel.onBindViewHolderWithErrorTracking$18b8048(localLayoutInflater, localErrorPageViewHolder, tracker, getPageInstance());
  }
  
  protected abstract class DataLoadListener<ROW_DATA_MODEL extends FissileDataModel<ROW_DATA_MODEL>>
    implements RecordTemplateListener<CollectionTemplate<ROW_DATA_MODEL, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata>>
  {
    public DataLoadListener() {}
    
    public final void onResponse(DataStoreResponse<CollectionTemplate<ROW_DATA_MODEL, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata>> paramDataStoreResponse)
    {
      if (error != null)
      {
        arrayAdapter.showLoadingView(false);
        Log.e(EntityViewAllListBaseFragment.TAG, "Error fetching load more data: " + error.getMessage());
        return;
      }
      onSuccess((CollectionTemplate)model, type, request.trackingSessionId);
    }
    
    public final void onSuccess(CollectionTemplate<ROW_DATA_MODEL, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate, DataStore.Type paramType, String paramString)
    {
      int j = 1;
      boolean bool;
      if (paramType == DataStore.Type.LOCAL)
      {
        bool = true;
        RUMTiming.renderStart(paramString, bool);
        arrayAdapter.showLoadingView(false);
        paramType = transformModels(paramCollectionTemplate.copyWithNewElements(elements));
        if ((hasPaging) && (paging.start != 0)) {
          break label74;
        }
      }
      label74:
      for (int i = 1;; i = 0)
      {
        if (paramType != null) {
          break label80;
        }
        return;
        bool = false;
        break;
      }
      label80:
      if ((i != 0) && (!bool)) {}
      for (i = j;; i = 0)
      {
        if (i != 0)
        {
          arrayAdapter.clearValues();
          paramCollectionTemplate = getHeaderViewModels();
          if (paramCollectionTemplate != null) {
            arrayAdapter.appendValues(paramCollectionTemplate);
          }
        }
        arrayAdapter.appendValues(paramType);
        RUMHelper.callRenderEndOnNextLoop(paramString, bool);
        return;
      }
    }
    
    public abstract List<? extends ViewModel> transformModels(CollectionTemplate<ROW_DATA_MODEL, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityViewAllListBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */