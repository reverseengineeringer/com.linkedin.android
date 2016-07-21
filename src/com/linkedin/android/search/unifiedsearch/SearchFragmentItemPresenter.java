package com.linkedin.android.search.unifiedsearch;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata.Builder;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchMetadata;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.search.FollowingInfoChangeListener;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.SearchDataProvider.SearchState;
import com.linkedin.android.search.searchengine.SearchEngineTransformer;
import com.linkedin.android.search.secondaryresults.SecondaryResultsTransformer;
import com.linkedin.android.search.secondaryresults.SecondaryResultsViewModel;
import com.linkedin.android.search.shared.SearchRoutes;
import com.linkedin.android.search.shared.SearchTracking;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import com.linkedin.consistency.ModelListItemChangedListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public final class SearchFragmentItemPresenter
  implements FollowingInfoChangeListener<SecondaryResultsViewModel>
{
  private ActivityComponent activityComponent;
  SearchFragmentAdapter<ViewModel> adapter;
  ModelListConsistencyCoordinator<FollowingInfo> consistencyCoordinator;
  SearchDataProvider dataProvider;
  ErrorPageViewModel errorPageViewModel;
  View facetContainer;
  boolean facetOn;
  final FeedComponentsViewPool feedViewPool = new FeedComponentsViewPool();
  @Inject
  FragmentComponent fragmentComponent;
  int itemCount;
  boolean loading;
  Map<String, SecondaryResultsViewModel> modelMap;
  @Inject
  SearchEngineTransformer peopleTransformer;
  SparseIntArray positionMap = new SparseIntArray();
  RecyclerView recyclerView;
  private Map<Object, Integer> resultTypeCountMap = new HashMap();
  TextView searchBarText;
  final ModelListItemChangedListener<FollowingInfo> secondaryResultChangedListener = new SearchFragmentItemPresenter.1(this);
  @Inject
  SecondaryResultsTransformer secondaryTransformer;
  SearchFragmentState states;
  final ModelListItemChangedListener<Update> updateChangedListener = new SearchFragmentItemPresenter.2(this);
  
  @Inject
  public SearchFragmentItemPresenter(ActivityComponent paramActivityComponent)
  {
    dataProvider = paramActivityComponent.searchDataProvider();
    adapter = new SearchFragmentAdapter(paramActivityComponent.activity(), paramActivityComponent.mediaCenter(), dataProvider);
    activityComponent = paramActivityComponent;
  }
  
  private String getRumSessionId(boolean paramBoolean)
  {
    TrackableFragment localTrackableFragment = (TrackableFragment)fragmentComponent.fragment();
    if (paramBoolean) {
      return RUMHelper.pageInitLoadMore(localTrackableFragment);
    }
    return localTrackableFragment.getRumSessionId();
  }
  
  private String getSubscriberId()
  {
    return fragmentComponent.fragment()).busSubscriberId;
  }
  
  final boolean doFetch(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if ((TextUtils.isEmpty(states.query)) && (!TextUtils.isEmpty(states.jserpUrl))) {
      i = 1;
    }
    while (i != 0)
    {
      SearchDataProvider localSearchDataProvider = dataProvider;
      Object localObject = states.jserpUrl;
      String str1 = states.origin;
      String str2 = getSubscriberId();
      String str3 = getRumSessionId(paramBoolean2);
      Map localMap1 = states.trackingHeader;
      Map localMap2 = states.getNonFacetParams();
      if ((paramBoolean2) && (state).searchIndexStart >= state).searchPageTotal))
      {
        return false;
        i = 0;
      }
      else
      {
        if (!paramBoolean2)
        {
          state).searchIndexStart = 0;
          state).searchPageTotal = Integer.MAX_VALUE;
        }
        SearchType localSearchType = SearchType.JOBS;
        i = state).searchIndexStart;
        String str4 = localSearchDataProvider.getNewSearchId();
        localObject = SearchRoutes.buildBaseSearchQueryWithoutTrackingParams(null, (String)localObject, localSearchType, null, localMap2).buildUpon().appendQueryParameter("id", str4);
        if (str1 != null) {
          ((Uri.Builder)localObject).appendQueryParameter("origin", str1);
        }
        return localSearchDataProvider.makeSearchRequest(((Uri.Builder)localObject).build().buildUpon().appendQueryParameter("start", String.valueOf(i)).appendQueryParameter("count", "20").build(), str2, str3, localMap1, paramBoolean1, paramBoolean2);
      }
    }
    if (dataProvider.isGuidedSearch) {
      return dataProvider.fetchClusterData(states.query, getSubscriberId(), getRumSessionId(paramBoolean2), states.trackingHeader, states.origin, states.searchType, states.urlParameter, states.getFacetParams(), states.getNonFacetParams(), paramBoolean2, paramBoolean1);
    }
    return dataProvider.fetchSearchData(states.query, states.searchType, states.origin, getSubscriberId(), getRumSessionId(paramBoolean2), states.trackingHeader, states.getFacetParams(), states.getNonFacetParams(), paramBoolean2, paramBoolean1);
  }
  
  final FeedDataModelMetadata getFeedDataModelMetadata()
  {
    FeedDataModelMetadata.Builder localBuilder = new FeedDataModelMetadata.Builder();
    searchId = states.lastSearchId;
    return localBuilder.build();
  }
  
  public final void setLoading(boolean paramBoolean1, boolean paramBoolean2)
  {
    loading = paramBoolean1;
    if (paramBoolean2) {
      adapter.clearValues();
    }
    adapter.showLoadingView(paramBoolean1);
  }
  
  final void setSecondaryResultBackground()
  {
    Context localContext = recyclerView.getContext();
    JellyBeanUtils.setBackground(recyclerView, ContextCompat.getDrawable(localContext, 2130838735));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)recyclerView.getLayoutParams();
    int i = localContext.getResources().getDimensionPixelSize(2131493515);
    localMarginLayoutParams.setMargins(i, topMargin, i, bottomMargin);
  }
  
  public final void updateResult(CollectionTemplate<SearchHit, SearchMetadata> paramCollectionTemplate, boolean paramBoolean)
  {
    if ((paramCollectionTemplate == null) || (!hasElements) || (!hasMetadata)) {
      return;
    }
    int i;
    String str1;
    List localList;
    Object localObject;
    FragmentComponent localFragmentComponent;
    String str2;
    SparseIntArray localSparseIntArray;
    String str3;
    if (hasPaging)
    {
      i = paging.total;
      dataProvider.state).searchPageTotal = i;
      str1 = SearchUtils.getOriginFromString(metadata).origin);
      localList = elements;
      if (metadata).keywords != null) {
        states.query = metadata).keywords;
      }
      if (!paramBoolean)
      {
        itemCount = 1;
        positionMap.clear();
        resultTypeCountMap.clear();
        searchBarText.setOnClickListener(SearchUtils.searchBarTextListener(activityComponent.activity(), states.query, states.searchType, activityComponent.lixManager()));
      }
      recyclerView.setVisibility(0);
      localObject = SearchUtils.getOriginFromString(metadata).origin);
      if (!dataProvider.isGuidedSearch) {
        SearchTracking.trackSRPImpressions(fragmentComponent.tracker(), states.query, states.searchType, itemCount, paramCollectionTemplate, positionMap, resultTypeCountMap, (String)localObject, states.lastSearchId);
      }
      localObject = (SearchDataProvider.SearchState)dataProvider.state;
      searchIndexStart += 20;
      if (metadata).type != SearchType.PEOPLE) {
        break label572;
      }
      localObject = peopleTransformer;
      localFragmentComponent = fragmentComponent;
      str2 = states.query;
      i = itemCount;
      localSparseIntArray = positionMap;
      str3 = states.lastSearchId;
      if (!"enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.SEARCH_VERTICAL_NAV))) {
        break label550;
      }
      paramCollectionTemplate = new ArrayList(localList.size());
      if (!CollectionUtils.isEmpty(localList)) {
        break label458;
      }
      paramCollectionTemplate.add(SearchEngineTransformer.transformToEmptyResultViewModel(localFragmentComponent));
    }
    for (;;)
    {
      itemCount += localList.size();
      if (!paramBoolean) {
        break label621;
      }
      adapter.appendValues(paramCollectionTemplate);
      new PageViewEvent(fragmentComponent.tracker(), ((TrackableFragment)fragmentComponent.fragment()).pageKey(), true).send();
      return;
      i = Integer.MAX_VALUE;
      break;
      label458:
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        SearchHit localSearchHit = (SearchHit)localIterator.next();
        if (hitInfo.secondaryResultContainerValue == null) {
          localArrayList.add(localSearchHit);
        }
      }
      paramCollectionTemplate.addAll(((SearchEngineTransformer)localObject).transformToEngineViewModelWithBackground(localFragmentComponent, localArrayList, str2, localSparseIntArray, i, str1, str3));
      continue;
      label550:
      paramCollectionTemplate = ((SearchEngineTransformer)localObject).transformToViewModelList(localFragmentComponent, localList, str2, i, localSparseIntArray, str1, str3);
      continue;
      label572:
      if (!paramBoolean) {
        setSecondaryResultBackground();
      }
      paramCollectionTemplate = secondaryTransformer.transformSecondaryResultsModelList(fragmentComponent, states.query, localList, itemCount, positionMap, str1, states.lastSearchId);
    }
    label621:
    adapter.setValues(paramCollectionTemplate);
    if ((states.searchType == SearchType.PEOPLE) && ((!CollectionUtils.isEmpty(localList)) || (facetOn)))
    {
      facetContainer.setVisibility(0);
      facetContainer.setClickable(true);
      return;
    }
    facetContainer.setVisibility(8);
    facetContainer.setClickable(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.unifiedsearch.SearchFragmentItemPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */