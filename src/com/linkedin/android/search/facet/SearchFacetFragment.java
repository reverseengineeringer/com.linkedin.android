package com.linkedin.android.search.facet;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
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
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.DividerItemDecoration;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.search.SearchFacet;
import com.linkedin.android.pegasus.gen.voyager.search.SearchFacetType;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadIndustry;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadRegion;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.search.SearchActivity;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.SearchDataProvider.SearchState;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.RecordTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class SearchFacetFragment
  extends PageFragment
  implements View.OnClickListener
{
  @Inject
  ActivityComponent activityComponent;
  private ArrayMap<SearchFacetType, ViewModelArrayAdapter> adapters = new ArrayMap();
  @InjectView(2131758509)
  LinearLayout cellsContainer;
  private SearchDataProvider dataProvider;
  @Inject
  DelayedExecution delayedExecution;
  @InjectView(2131758507)
  Button doneButton;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @Inject
  Bus eventBus;
  @Inject
  SearchFacetTransformer facetTransformer;
  @InjectView(2131758508)
  View loading;
  private FacetParameterMap localParameterMap = new FacetParameterMap();
  private ArrayList<RecordTemplate> newlyAddedItemList = new ArrayList();
  private String query;
  @InjectView(2131758506)
  Button resetButton;
  private Set<SearchFacetType> swipedFacetTypes;
  private boolean useCache;
  
  private void addConnections(LayoutInflater paramLayoutInflater, SearchFacet paramSearchFacet, List<ViewModel> paramList)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    View localView1 = paramLayoutInflater.inflate(2130969398, cellsContainer, false);
    ((TextView)localView1.findViewById(2131758502)).setText(displayName);
    int j = getResources().getDimensionPixelSize(2131493511);
    int k = getResources().getDimensionPixelSize(2131493510);
    cellsContainer.addView(localView1);
    int i = 0;
    while (i < paramList.size())
    {
      paramSearchFacet = (ViewGroup)localView1.findViewById(2131758505);
      View localView2 = paramLayoutInflater.inflate(2130969396, paramSearchFacet, false);
      Object localObject = (ImageView)localView2.findViewById(2131758500);
      getLayoutParamswidth = j;
      getLayoutParamsheight = k;
      ((ImageView)localObject).setImageResource(2130838229);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject = (SearchFacetViewModel)paramList.get(i);
      updateConnectionButtonsState(getResources(), localView2, (SearchFacetViewModel)localObject);
      ((TextView)localView2.findViewById(2131758501)).setText(name);
      localView2.setTag(localObject);
      localView2.setOnClickListener(this);
      paramSearchFacet.addView(localView2, localLayoutParams);
      i += 1;
    }
  }
  
  private void addFacet(RecordTemplate paramRecordTemplate, FacetParameterMap paramFacetParameterMap, boolean paramBoolean)
  {
    Object localObject2 = facetTransformer;
    Object localObject3 = fragmentComponent;
    Object localObject1 = new SearchFacetViewModel();
    if ((paramRecordTemplate instanceof MiniCompany))
    {
      paramRecordTemplate = (MiniCompany)paramRecordTemplate;
      name = name;
      type = SearchFacetType.CURRENT_COMPANY;
      parameterValue = entityUrn.getId();
      companyImage = new ImageModel(logo, GhostImageUtils.getCompany(2131492961, paramRecordTemplate), Util.retrieveRumSessionId((FragmentComponent)localObject3));
      paramRecordTemplate = (SearchDataProvider.SearchState)dataProvider.state;
      localObject3 = type;
      parameterKey = ((String)facetTypeToParameterKeyMap.get(localObject3));
      if (parameterKey == null) {
        break label485;
      }
      onContentDescription = i18NManager.getString(2131233536, new Object[] { name });
      offContentDescription = i18NManager.getString(2131233535, new Object[] { name });
      isSelected = true;
      onFacetClick = ((SearchFacetTransformer)localObject2).getOnFacetClickClosure();
      paramRecordTemplate = (RecordTemplate)localObject1;
      label211:
      localObject1 = (ViewModelArrayAdapter)adapters.get(type);
      if ((paramFacetParameterMap != null) && (!paramFacetParameterMap.contains(parameterKey, parameterValue))) {
        break label490;
      }
    }
    int j;
    label485:
    label490:
    for (boolean bool = true;; bool = false)
    {
      isSelected = bool;
      if (!paramBoolean) {
        break label556;
      }
      paramFacetParameterMap = (RecyclerView)cellsContainer.findViewWithTag(type);
      i = paramFacetParameterMap.getHeight();
      localObject2 = activityComponent.activity().getLayoutInflater();
      localObject3 = new ArrayList();
      ((List)localObject3).add((ViewModel)((ViewModelArrayAdapter)localObject1).getValues().get(0));
      ((List)localObject3).add(paramRecordTemplate);
      j = getMaxRecyclerViewHeight((List)localObject3, (LayoutInflater)localObject2, new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), (List)localObject3));
      if (j > i) {
        break label496;
      }
      addItemWithAnimation(paramFacetParameterMap, (ViewModelArrayAdapter)localObject1, paramRecordTemplate);
      return;
      if ((!(paramRecordTemplate instanceof TypeaheadHit)) || (!hasHitInfo)) {
        break;
      }
      name = text.text;
      paramRecordTemplate = hitInfo;
      if (typeaheadRegionValue != null)
      {
        type = SearchFacetType.GEO_REGION;
        parameterValue = typeaheadRegionValue.id;
        break;
      }
      if (typeaheadIndustryValue == null) {
        break;
      }
      type = SearchFacetType.INDUSTRY;
      parameterValue = typeaheadIndustryValue.industryUrn.getId();
      break;
      paramRecordTemplate = null;
      break label211;
    }
    label496:
    populateFacetList(((ViewModelArrayAdapter)adapters.get(type)).getValues(), type, paramFacetParameterMap, (LayoutInflater)localObject2, j);
    paramFacetParameterMap.post(new SearchFacetFragment.1(this, paramFacetParameterMap, (ViewModelArrayAdapter)adapters.get(type), paramRecordTemplate));
    return;
    label556:
    int i = findDupIndex(paramRecordTemplate, ((ViewModelArrayAdapter)localObject1).getValues());
    if (i != -1) {
      ((ViewModelArrayAdapter)localObject1).removeValueAtPosition(i);
    }
    addItem(paramRecordTemplate, (ViewModelArrayAdapter)localObject1);
  }
  
  private void addItem(SearchFacetViewModel paramSearchFacetViewModel, ViewModelArrayAdapter paramViewModelArrayAdapter)
  {
    paramViewModelArrayAdapter.insertValue(1, paramSearchFacetViewModel);
    if (isSelected) {
      localParameterMap.add(parameterKey, parameterValue);
    }
    setResetButtonVisibility();
  }
  
  private void addItemWithAnimation(RecyclerView paramRecyclerView, ViewModelArrayAdapter paramViewModelArrayAdapter, SearchFacetViewModel paramSearchFacetViewModel)
  {
    int j = 1;
    Object localObject = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    boolean bool = "enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.LIX_SEARCH_FACET_ANIMATION));
    int i;
    int k;
    if (((LinearLayoutManager)localObject).findLastVisibleItemPosition() == paramViewModelArrayAdapter.getItemCount() - 1)
    {
      i = 1;
      k = findDupIndex(paramSearchFacetViewModel, paramViewModelArrayAdapter.getValues());
      if (k == -1) {
        break label166;
      }
      label70:
      localObject = new DefaultItemAnimator();
      if (!bool) {
        break label196;
      }
      if (j == 0) {
        break label172;
      }
      mAddDuration = 500L;
      mRemoveDuration = 500L;
    }
    label166:
    label172:
    label196:
    for (;;)
    {
      paramRecyclerView.setItemAnimator((RecyclerView.ItemAnimator)localObject);
      if (k != -1)
      {
        paramViewModelArrayAdapter.removeValueAtPosition(k);
        i = 0;
      }
      paramRecyclerView.scrollToPosition(0);
      if ((i != 0) && (bool))
      {
        paramRecyclerView.postDelayed(new SearchFacetFragment.2(this, paramSearchFacetViewModel, paramViewModelArrayAdapter), 500L);
        return;
        i = 0;
        break;
        j = 0;
        break label70;
        localObject = new FacetItemAnimator(paramRecyclerView, getItemSpacing());
        continue;
      }
      addItem(paramSearchFacetViewModel, paramViewModelArrayAdapter);
      return;
    }
  }
  
  private static int findDupIndex(SearchFacetViewModel paramSearchFacetViewModel, List<ViewModel> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      ViewModel localViewModel = (ViewModel)paramList.get(i);
      if (((localViewModel instanceof SearchFacetViewModel)) && (parameterValue.equals(parameterValue))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int getItemSpacing()
  {
    return getResources().getDimensionPixelOffset(2131492989);
  }
  
  @SuppressLint({"InflateParams"})
  private int getMaxRecyclerViewHeight(List<ViewModel> paramList, LayoutInflater paramLayoutInflater, ViewModelArrayAdapter paramViewModelArrayAdapter)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ViewModel)((Iterator)localObject2).next();
      if ((localObject3 instanceof SearchFacetViewModel)) {
        ((List)localObject1).add(name);
      }
    }
    Collections.sort((List)localObject1, new SearchFacetFragment.6(this));
    int k = getResources().getDimensionPixelOffset(2131493525);
    int i = 0;
    localObject1 = ((List)localObject1).iterator();
    int j;
    int m;
    do
    {
      do
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = paramLayoutInflater.inflate(2130969396, null, false);
        paramViewModelArrayAdapter.onBindViewHolder(new SearchFacetViewHolder((View)localObject3), getTextPosition(paramList, (String)localObject2));
        ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelOffset(2131493524), Integer.MIN_VALUE), 0);
        j = ((View)localObject3).getMeasuredHeight();
        m = ((View)localObject3).getMeasuredWidth();
      } while (j <= i);
      i = j;
    } while (m > k);
    paramList = paramLayoutInflater.inflate(2130969400, null, false);
    paramViewModelArrayAdapter.onBindViewHolder(new SearchFacetPlusViewHolder(paramList), 0);
    paramList.measure(0, 0);
    i = paramList.getMeasuredHeight();
    if (j > i) {
      return j;
    }
    return i;
  }
  
  private static int getTextPosition(List<ViewModel> paramList, String paramString)
  {
    int j = 1;
    int i = 0;
    while (i < paramList.size())
    {
      ViewModel localViewModel = (ViewModel)paramList.get(i);
      int k = j;
      if ((localViewModel instanceof SearchFacetViewModel))
      {
        k = j;
        if (paramString.equals(name)) {
          k = i;
        }
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static SearchFacetFragment newInstance(SearchBundleBuilder paramSearchBundleBuilder)
  {
    SearchFacetFragment localSearchFacetFragment = new SearchFacetFragment();
    localSearchFacetFragment.setArguments(paramSearchBundleBuilder.build());
    return localSearchFacetFragment;
  }
  
  private void populateFacetList(List<ViewModel> paramList, SearchFacetType paramSearchFacetType, RecyclerView paramRecyclerView, LayoutInflater paramLayoutInflater, int paramInt)
  {
    ViewModelArrayAdapter localViewModelArrayAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), paramList);
    adapters.put(paramSearchFacetType, localViewModelArrayAdapter);
    if (paramInt != 0) {}
    for (;;)
    {
      paramList = new LinearLayoutManager(getActivity(), 0, false);
      paramSearchFacetType = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramSearchFacetType);
      paramRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(widthPixels, paramInt));
      paramRecyclerView.setLayoutManager(paramList);
      paramRecyclerView.setAdapter(localViewModelArrayAdapter);
      return;
      paramInt = getMaxRecyclerViewHeight(paramList, paramLayoutInflater, localViewModelArrayAdapter);
    }
  }
  
  private void setResetButtonVisibility()
  {
    if (localParameterMap.isEmpty())
    {
      resetButton.setVisibility(8);
      return;
    }
    resetButton.setVisibility(0);
  }
  
  private void updateConnectionButtonsState(Resources paramResources, View paramView, SearchFacetViewModel paramSearchFacetViewModel)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131758500);
    TextView localTextView = (TextView)paramView.findViewById(2131758501);
    if (isSelected)
    {
      paramView.setContentDescription(activityComponent.i18NManager().getString(2131233536, new Object[] { name }));
      localImageView.setColorFilter(paramResources.getColor(2131624058));
      localImageView.setBackgroundResource(2130838743);
      localTextView.setTextColor(paramResources.getColor(2131623966));
      return;
    }
    paramView.setContentDescription(activityComponent.i18NManager().getString(2131233535, new Object[] { name }));
    localTextView.setTextColor(paramResources.getColor(2131624083));
    localImageView.setBackgroundResource(2130838742);
    localImageView.setColorFilter(paramResources.getColor(2131624342));
  }
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
    delayedExecution.postDelayedExecution(new SearchFacetFragment.5(this), 300L);
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.searchDataProvider();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    SearchFacetViewModel localSearchFacetViewModel = (SearchFacetViewModel)paramView.getTag();
    if (!isSelected) {}
    for (boolean bool = true;; bool = false)
    {
      isSelected = bool;
      updateConnectionButtonsState(getResources(), paramView, localSearchFacetViewModel);
      onFacetClick.apply(localSearchFacetViewModel);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      useCache = bool;
      super.onCreate(paramBundle);
      fragmentComponent.inject(this);
      query = SearchBundleBuilder.getQueryString(getArguments());
      dataProvider = activityComponent.searchDataProvider();
      if (paramBundle == null) {
        break;
      }
      localParameterMap.applyFacetParams(paramBundle.getBundle("facet_params"));
      paramBundle = dataProvider;
      Object localObject = paramBundle.newModelListener(busSubscriberId, getRumSessionId());
      localObject = Request.get().url("added_new_companies").filter(DataManager.DataStoreFilter.LOCAL_ONLY).builder(new CollectionTemplate.CollectionTemplateJsonParser(MiniCompany.BUILDER, CollectionMetadata.BUILDER)).listener((RecordTemplateListener)localObject);
      activityComponent.dataManager().submit((Request.Builder)localObject);
      paramBundle = dataProvider;
      localObject = paramBundle.newModelListener(busSubscriberId, getRumSessionId());
      localObject = Request.get().url("added_new_typeahead").filter(DataManager.DataStoreFilter.LOCAL_ONLY).builder(new CollectionTemplate.CollectionTemplateJsonParser(TypeaheadHit.BUILDER, CollectionMetadata.BUILDER)).listener((RecordTemplateListener)localObject);
      activityComponent.dataManager().submit((Request.Builder)localObject);
      return;
    }
    dataProvider.clearCache("added_new_companies");
    dataProvider.clearCache("added_new_typeahead");
    localParameterMap = dataProvider.getFacetParametereMap();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969399, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((paramSet == null) || (paramSet.isEmpty()) || (paramType == DataStore.Type.LOCAL)) {}
    do
    {
      return;
      loading.setVisibility(8);
      cellsContainer.setVisibility(8);
      paramSet = new SearchFacetFragment.8(this, fragmentComponent.tracker(), "try_again");
      paramType = getView();
    } while (paramType == null);
    paramType = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(paramType);
    errorPageViewModel.setupDefaultErrorConfiguration(fragmentComponent.context(), paramSet);
    paramSet = errorPageViewModel;
    paramDataManagerException = fragmentComponent.activity().getLayoutInflater();
    fragmentComponent.activity().applicationComponent.mediaCenter();
    paramSet.onBindViewHolder$49e9e35b(paramDataManagerException, paramType);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramSet.contains("added_new_companies")) {
            break;
          }
          paramType = (CollectionTemplate)((SearchDataProvider.SearchState)dataProvider.state).getModel("added_new_companies");
          if (paramType != null) {}
          for (paramType = elements; (paramType != null) && (!paramType.isEmpty()); paramType = null)
          {
            newlyAddedItemList.addAll(paramType);
            return;
          }
        }
        if (!paramSet.contains("added_new_typeahead")) {
          break;
        }
        paramType = ((SearchDataProvider.SearchState)dataProvider.state).typeaheadList("added_new_typeahead");
      } while ((paramType == null) || (paramType.isEmpty()));
      newlyAddedItemList.addAll(paramType);
      return;
      loading.setVisibility(8);
      cellsContainer.setVisibility(0);
      paramType = ((SearchDataProvider.SearchState)dataProvider.state).facetList();
    } while (paramType == null);
    cellsContainer.removeAllViews();
    adapters.clear();
    swipedFacetTypes = new HashSet();
    int i = 0;
    while (i < paramType.size())
    {
      paramSet = (SearchFacet)paramType.get(i);
      paramMap = (SearchDataProvider.SearchState)dataProvider.state;
      Object localObject1 = facetType;
      Object localObject2 = facetParameterName;
      facetTypeToParameterKeyMap.put(localObject1, localObject2);
      localObject2 = facetTransformer.transformToFacetModelList(paramSet, localParameterMap, fragmentComponent);
      LayoutInflater localLayoutInflater;
      if (!((List)localObject2).isEmpty())
      {
        localLayoutInflater = activityComponent.activity().getLayoutInflater();
        if (facetType == SearchFacetType.NETWORK) {
          addConnections(localLayoutInflater, paramSet, (List)localObject2);
        }
      }
      else
      {
        i += 1;
        continue;
      }
      paramMap = localLayoutInflater.inflate(2130969397, cellsContainer, false);
      cellsContainer.addView(paramMap);
      ((TextView)paramMap.findViewById(2131758502)).setText(displayName);
      localObject1 = (RecyclerView)paramMap.findViewById(2131758503);
      ((RecyclerView)localObject1).setTag(facetType);
      populateFacetList((List)localObject2, facetType, (RecyclerView)localObject1, localLayoutInflater, 0);
      ((RecyclerView)localObject1).addOnScrollListener(new SearchFacetFragment.7(this, paramSet));
      localObject2 = new DividerItemDecoration(0);
      ((DividerItemDecoration)localObject2).setEndMargin(getItemSpacing());
      ((DividerItemDecoration)localObject2).setDivider(getResources(), 2130837579);
      ((RecyclerView)localObject1).addItemDecoration((RecyclerView.ItemDecoration)localObject2);
      paramMap = (ViewGroup.MarginLayoutParams)paramMap.findViewById(2131758504).getLayoutParams();
      localObject1 = getResources();
      paramSet = facetType;
      switch (SearchFacetFragment.9.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$search$SearchFacetType[paramSet.ordinal()])
      {
      }
      for (int j = Math.round(((Resources)localObject1).getDimension(2131492993));; j = Math.round(((Resources)localObject1).getDimension(2131492995)))
      {
        paramMap.setMargins(0, j, 0, 0);
        break;
      }
    }
    paramType = newlyAddedItemList.iterator();
    while (paramType.hasNext()) {
      addFacet((RecordTemplate)paramType.next(), localParameterMap, false);
    }
    setResetButtonVisibility();
  }
  
  @Subscribe
  public void onEvent(ClickEvent paramClickEvent)
  {
    int i = 0;
    Object localObject1 = clickedItem;
    int j = type;
    if (j == 5) {
      if ((localObject1 instanceof SearchFacetPlusViewModel))
      {
        paramClickEvent = (SearchFacetPlusViewModel)localObject1;
        localObject1 = getActivity();
        if ((localObject1 instanceof SearchActivity))
        {
          localObject1 = (SearchActivity)localObject1;
          paramClickEvent = type;
          switch (com.linkedin.android.search.SearchActivity.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$search$SearchFacetType[paramClickEvent.ordinal()])
          {
          default: 
            paramClickEvent = null;
            if (paramClickEvent != null) {
              ((SearchActivity)localObject1).openPickerTypeaheadFragment(paramClickEvent, 1, i);
            }
            break;
          }
        }
      }
    }
    Object localObject2;
    Object localObject3;
    while (j != 6)
    {
      do
      {
        for (;;)
        {
          return;
          paramClickEvent = TypeaheadType.COMPANY;
          i = 2131233528;
          continue;
          paramClickEvent = TypeaheadType.REGION;
          i = 2131233530;
          continue;
          paramClickEvent = TypeaheadType.INDUSTRY;
          i = 2131233529;
        }
      } while (!(localObject1 instanceof SearchFacetViewModel));
      localObject2 = (SearchFacetViewModel)localObject1;
      if (isSelected) {
        localParameterMap.add(parameterKey, parameterValue);
      }
      for (;;)
      {
        setResetButtonVisibility();
        return;
        paramClickEvent = localParameterMap;
        localObject1 = parameterKey;
        localObject2 = parameterValue;
        if (map.containsKey(localObject1))
        {
          localObject3 = (List)map.get(localObject1);
          ((List)localObject3).remove(localObject2);
          if (((List)localObject3).isEmpty()) {
            map.remove(localObject1);
          }
        }
      }
    }
    boolean bool;
    if ((localObject1 instanceof RecordTemplate))
    {
      paramClickEvent = (RecordTemplate)localObject1;
      if (!(paramClickEvent instanceof MiniCompany)) {
        break label391;
      }
      paramClickEvent = (MiniCompany)paramClickEvent;
      localObject2 = newlyAddedItemList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (RecordTemplate)((Iterator)localObject2).next();
        if ((localObject3 instanceof MiniCompany))
        {
          localObject2 = (MiniCompany)localObject3;
          bool = _cachedId.equals(_cachedId);
        }
      }
    }
    for (;;)
    {
      if (!bool) {
        newlyAddedItemList.add((RecordTemplate)localObject1);
      }
      addFacet((RecordTemplate)localObject1, null, true);
      return;
      label391:
      if ((paramClickEvent instanceof TypeaheadHit))
      {
        paramClickEvent = (TypeaheadHit)paramClickEvent;
        localObject2 = newlyAddedItemList.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RecordTemplate)((Iterator)localObject2).next();
            if ((localObject3 instanceof TypeaheadHit))
            {
              localObject2 = (TypeaheadHit)localObject3;
              bool = TextUtils.equals(text.text, text.text);
              break;
            }
          }
        }
      }
      bool = false;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBundle("facet_params", localParameterMap.generateBundle());
    paramBundle = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = newlyAddedItemList.iterator();
    while (localIterator.hasNext())
    {
      RecordTemplate localRecordTemplate = (RecordTemplate)localIterator.next();
      if ((localRecordTemplate instanceof MiniCompany)) {
        paramBundle.add((MiniCompany)localRecordTemplate);
      } else if ((localRecordTemplate instanceof TypeaheadHit)) {
        localArrayList.add((TypeaheadHit)localRecordTemplate);
      }
    }
    if (!paramBundle.isEmpty()) {
      dataProvider.saveFacetDataInCache(paramBundle, "added_new_companies");
    }
    if (!localArrayList.isEmpty()) {
      dataProvider.saveFacetDataInCache(localArrayList, "added_new_typeahead");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    loading.setVisibility(0);
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    resetButton.setOnClickListener(new SearchFacetFragment.3(this, tracker, "facet_reset", new TrackingEventBuilder[0]));
    doneButton.setOnClickListener(new SearchFacetFragment.4(this, tracker, "facet_done", new TrackingEventBuilder[0]));
  }
  
  public final String pageKey()
  {
    return "search_facets";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.facet.SearchFacetFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */