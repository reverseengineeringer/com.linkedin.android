package com.linkedin.android.search.facet;

import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.search.SearchFacet;
import com.linkedin.android.pegasus.gen.voyager.search.SearchFacetType;
import com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue;
import com.linkedin.android.search.SearchDataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public final class SearchFacetTransformer
{
  final SearchDataProvider dataProvider;
  private final Bus eventBus;
  final I18NManager i18NManager;
  private final Tracker tracker;
  
  @Inject
  public SearchFacetTransformer(ActivityComponent paramActivityComponent)
  {
    eventBus = paramActivityComponent.eventBus();
    tracker = paramActivityComponent.tracker();
    i18NManager = paramActivityComponent.i18NManager();
    dataProvider = paramActivityComponent.searchDataProvider();
  }
  
  private SearchFacetPlusViewModel getPlusModel(SearchFacet paramSearchFacet)
  {
    SearchFacetPlusViewModel localSearchFacetPlusViewModel = new SearchFacetPlusViewModel();
    type = facetType;
    name = i18NManager.getString(2131233489);
    onFacetClick = new SearchFacetTransformer.1(this, tracker, "facet_value_item");
    return localSearchFacetPlusViewModel;
  }
  
  final TrackingClosure<SearchFacetViewModel, Void> getOnFacetClickClosure()
  {
    return new SearchFacetTransformer.2(this, tracker, "facet_value_item");
  }
  
  public final List<ViewModel> transformToFacetModelList(SearchFacet paramSearchFacet, FacetParameterMap paramFacetParameterMap, FragmentComponent paramFragmentComponent)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = facetValues.iterator();
    while (localIterator.hasNext())
    {
      SearchFacetValue localSearchFacetValue = (SearchFacetValue)localIterator.next();
      String str = facetParameterName;
      SearchFacetType localSearchFacetType = facetType;
      SearchFacetViewModel localSearchFacetViewModel = new SearchFacetViewModel();
      name = displayValue;
      onContentDescription = i18NManager.getString(2131233536, new Object[] { name });
      offContentDescription = i18NManager.getString(2131233535, new Object[] { name });
      isSelected = paramFacetParameterMap.contains(str, value);
      parameterKey = str;
      parameterValue = value;
      type = localSearchFacetType;
      companyImage = new ImageModel(image, GhostImageUtils.getUnstructuredCompany(2131492961), Util.retrieveRumSessionId(paramFragmentComponent));
      onFacetClick = getOnFacetClickClosure();
      localArrayList.add(localSearchFacetViewModel);
    }
    if (facetType != SearchFacetType.NETWORK)
    {
      if (!localArrayList.isEmpty()) {
        localArrayList.add(0, getPlusModel(paramSearchFacet));
      }
      localArrayList.add(getPlusModel(paramSearchFacet));
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.facet.SearchFacetTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */