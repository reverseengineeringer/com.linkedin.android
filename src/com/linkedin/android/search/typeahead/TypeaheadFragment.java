package com.linkedin.android.search.typeahead;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewHolder;
import com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewModel;
import com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewModel.HeroDismissedEvent;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.networking.util.NetworkUtils;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory.HistoryInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.relationships.connections.ConnectionStore;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.search.SearchBarListener;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.SearchDataProvider.SearchState;
import com.linkedin.android.search.SearchPicker;
import com.linkedin.android.search.facet.FacetParameterMap;
import com.linkedin.android.search.facet.SearchFacetTransformer;
import com.linkedin.android.search.shared.SearchCacheHelper;
import com.linkedin.android.search.shared.SearchCacheHelper.1;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.search.shared.SearchViewHelper;
import com.linkedin.android.search.ui.SearchHistoryBar;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultPageOrigin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class TypeaheadFragment
  extends PageFragment
{
  private static final String STARTER_ROUTE = Routes.SEARCH_STARTER.buildUponRoot().buildUpon().toString();
  private static final String TAG = TypeaheadFragment.class.getSimpleName();
  private static int maxCachedConnectionsShown;
  @Inject
  ActivityComponent activityComponent;
  @InjectView(2131758671)
  ViewGroup container;
  private ViewGroup crossPromoView;
  @InjectView(2131758673)
  ViewStub crossPromoViewStub;
  private String customClickTrackingName;
  private String customPageKey;
  private String customTrackingName;
  private SearchDataProvider dataProvider;
  @Inject
  Bus eventBus;
  @Inject
  SearchFacetTransformer facetTransformer;
  private boolean fakeHitAtTop;
  private boolean hasFakeHit;
  @InjectView(2131758672)
  View hiddenView;
  private String hintText;
  @InjectView(2131758567)
  SearchHistoryBar historyBar;
  @InjectView(2131758529)
  TextView historyDismiss;
  private int inputMaxLength;
  private boolean isPickerMode;
  @Inject
  TypeaheadItemPresenter itemPresenter;
  @Inject
  KeyboardUtil keyboardUtil;
  private long lastToastShownTimestamp;
  @Inject
  LixManager lixManager;
  private String origin;
  public String query;
  @InjectView(2131758675)
  RecyclerView recyclerView;
  private boolean renderFinished;
  private String savedCacheKey;
  @InjectView(2131758512)
  Toolbar searchBar;
  @InjectView(2131755329)
  ImageView searchBarClear;
  private SearchBarListener searchBarListener;
  @Inject
  TypeAheadSearchBarPresenter searchBarPresenter;
  @InjectView(2131755328)
  EditText searchBarText;
  @Inject
  SearchUtils searchUtils;
  public boolean shouldShowKeyboard = true;
  private Toast toast;
  private TypeaheadType type;
  private String typeaheadId;
  private int typeaheadSource;
  private boolean useLocalCache;
  
  private static List<TypeaheadHit> dedupTypeaheadHits(List<TypeaheadHit> paramList, Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (TypeaheadHit)localIterator.next();
      if ((hitInfo.typeaheadProfileValue == null) || (!paramSet.contains(hitInfo.typeaheadProfileValue.id))) {
        localArrayList.add(paramList);
      }
    }
  }
  
  private void finishRender()
  {
    TypeaheadItemPresenter localTypeaheadItemPresenter = itemPresenter;
    adapter.showLoadingView(false);
    isLoadingRunnableScheduled = false;
    delayedExecution.stopDelayedExecution(loadingRunnable);
    renderFinished = true;
  }
  
  private static String getTextFromClickedItem(Object paramObject)
  {
    if (!(paramObject instanceof TypeaheadHit)) {
      return null;
    }
    return text.text;
  }
  
  public static TypeaheadFragment newInstance(SearchBundleBuilder paramSearchBundleBuilder)
  {
    TypeaheadFragment localTypeaheadFragment = new TypeaheadFragment();
    localTypeaheadFragment.setArguments(paramSearchBundleBuilder.build());
    return localTypeaheadFragment;
  }
  
  private void removePromoView()
  {
    if (crossPromoView != null)
    {
      container.removeView(crossPromoView);
      crossPromoView = null;
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
    KeyboardUtil.hideKeyboard(searchBarText);
    finishRender();
    if (toast != null) {
      toast.cancel();
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
    Object localObject = itemPresenter;
    typeaheadTransformer.startRevealViewModelRunnable(fragmentComponent);
    localObject = searchBarPresenter;
    EditText localEditText = searchBarText;
    SearchBarListener localSearchBarListener = searchBarListener;
    boolean bool = isPickerMode;
    TypeaheadItemPresenter localTypeaheadItemPresenter = itemPresenter;
    String str1 = hintText;
    String str2 = query;
    Bus localBus = eventBus;
    Tracker localTracker = activityComponent.tracker();
    String str3 = customTrackingName;
    searchBarListener = localSearchBarListener;
    eventBus = localBus;
    isPickerMode = bool;
    tracker = localTracker;
    customTrackingName = str3;
    if (!TextUtils.isEmpty(str1)) {
      localEditText.setHint(str1);
    }
    localEditText.setEnabled(true);
    localEditText.setSelection(localEditText.getText().length());
    if (textChangeListener != null) {
      localEditText.removeTextChangedListener(textChangeListener);
    }
    textChangeListener = new TypeAheadSearchBarPresenter.1((TypeAheadSearchBarPresenter)localObject, localTypeaheadItemPresenter);
    localEditText.addTextChangedListener(textChangeListener);
    localEditText.setOnEditorActionListener(new TypeAheadSearchBarPresenter.2((TypeAheadSearchBarPresenter)localObject, localEditText));
    localEditText.setOnKeyListener(new TypeAheadSearchBarPresenter.3((TypeAheadSearchBarPresenter)localObject, localEditText));
    if (bool) {
      localEditText.setImeOptions(268435462);
    }
    for (;;)
    {
      if (str2 != null)
      {
        localEditText.setText(str2);
        localEditText.setSelection(str2.length());
      }
      return;
      localEditText.setImeOptions(268435459);
    }
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.searchDataProvider();
  }
  
  public final boolean isAnchorPage()
  {
    return !isPickerMode;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      useLocalCache = bool;
      Object localObject1 = getArguments();
      isPickerMode = SearchBundleBuilder.isPickerMode((Bundle)localObject1);
      type = SearchBundleBuilder.getTypeaheadType((Bundle)localObject1);
      origin = SearchUtils.getOriginFromBundle((Bundle)localObject1);
      hintText = SearchBundleBuilder.getSearchBarHintText((Bundle)localObject1);
      query = SearchBundleBuilder.getQueryString((Bundle)localObject1);
      typeaheadSource = SearchBundleBuilder.getTypeaheadSourece((Bundle)localObject1);
      customPageKey = SearchBundleBuilder.getCustomTypeaheadPageKey((Bundle)localObject1);
      if (useLocalCache)
      {
        query = paramBundle.getString("query_text");
        savedCacheKey = paramBundle.getString("cache_key");
      }
      super.onCreate(paramBundle);
      fragmentComponent.inject(this);
      dataProvider = activityComponent.searchDataProvider();
      Object localObject2;
      Object localObject3;
      if ((!isPickerMode) && (TextUtils.isEmpty(query)) && ("enabled".equals(lixManager.getTreatment(Lix.LIX_SEARCH_CROSS_PROMO))))
      {
        paramBundle = dataProvider;
        localObject2 = Tracker.createPageInstanceHeader(getPageInstance());
        Object localObject4 = busSubscriberId;
        String str = getRumSessionId();
        localObject3 = pageKey();
        localObject4 = paramBundle.newModelListener((String)localObject4, str);
        localObject2 = Request.get().url(Routes.crossPromoPath(TrackingUtils.getTrackKey((String)localObject3))).customHeaders((Map)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).builder(Promo.BUILDER).listener((RecordTemplateListener)localObject4);
        activityComponent.dataManager().submit((Request.Builder)localObject2);
      }
      if ((hintText == null) && (dataProvider.isGuidedSearch)) {
        hintText = i18NManager.getString(2131233543);
      }
      if (query == null) {
        query = "";
      }
      inputMaxLength = SearchBundleBuilder.getInputMaxLength((Bundle)localObject1);
      hasFakeHit = SearchBundleBuilder.hasFakeHit((Bundle)localObject1);
      fakeHitAtTop = SearchBundleBuilder.getFakeHitAtTop((Bundle)localObject1);
      customClickTrackingName = SearchBundleBuilder.getCustomTypeaheadClickTrackingName((Bundle)localObject1);
      customTrackingName = SearchBundleBuilder.getCustomTrackingName((Bundle)localObject1);
      int i = SearchUtils.getCacheDisplaySizeFromLix(applicationComponent.lixManager().getTreatment(Lix.SEARCH_CACHE_DISPLAY_SIZE));
      maxCachedConnectionsShown = i;
      if (i > 0)
      {
        paramBundle = applicationComponent.connectionStore();
        localObject1 = applicationComponent.flagshipSharedPreferences();
        localObject2 = applicationComponent.dataManager();
        applicationComponent.tracker();
        localObject3 = Tracker.createPageInstanceHeader(getPageInstance());
        if ((!((FlagshipSharedPreferences)localObject1).getPreferences().getBoolean("connectionStoreInitialized", false)) && (paramBundle.isEmpty())) {
          new CollectionTemplateHelper((FlagshipDataManager)localObject2, null, Connection.BUILDER, CollectionMetadata.BUILDER).fetchInitialData((Map)localObject3, 2, RelationshipsRoutesHelper.makeConnectionsRoute$13d12155(), new SearchCacheHelper.1((FlagshipSharedPreferences)localObject1), null);
        }
      }
      searchBarListener = new TypeaheadFragment.1(this, Tracker.createPageInstanceHeader(getPageInstance()));
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((typeaheadSource == 1) || (typeaheadSource == 2)) {
      return paramLayoutInflater.inflate(2130969448, paramViewGroup, false);
    }
    return paramLayoutInflater.inflate(2130969447, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    super.onDataError(paramType, paramSet, paramDataManagerException);
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramSet = (String)paramSet.iterator().next();
          } while (paramSet.equals(Routes.crossPromoPath(TrackingUtils.getTrackKey(pageKey()))));
          if (!paramSet.equals(STARTER_ROUTE)) {
            break;
          }
        } while (!TextUtils.isEmpty(query));
        finishRender();
        itemPresenter.updateStarterData(Collections.EMPTY_LIST, false);
        return;
      } while (paramType == DataStore.Type.LOCAL);
      paramType = SearchUtils.getParamFromRoute("query", paramSet);
    } while (!query.equals(paramType));
    finishRender();
    if (NetworkUtils.hasActiveInternetConnection(applicationComponent.appContext()) == 0) {}
    for (int i = 2131233575;; i = 2131233577)
    {
      long l = System.currentTimeMillis();
      if (TimeUnit.MILLISECONDS.toSeconds(l - lastToastShownTimestamp) > 5L)
      {
        toast = Toast.makeText(getActivity(), i, 0);
        toast.setGravity(16, 0, 0);
        toast.show();
        lastToastShownTimestamp = l;
      }
      i = itemPresenter.typeaheadHitList.size();
      if (i <= 0) {
        break;
      }
      itemPresenter.trackTypeaheadImpression(query, typeaheadId, i);
      return;
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    boolean bool = true;
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramSet = (String)paramSet.iterator().next();
              if (!paramSet.equals(Routes.crossPromoPath(TrackingUtils.getTrackKey(pageKey())))) {
                break;
              }
            } while (paramMap == null);
            paramType = (DataStoreResponse)paramMap.get(Routes.crossPromoPath(TrackingUtils.getTrackKey(pageKey())));
          } while ((paramType == null) || (!(model instanceof Promo)));
          applicationComponent.crossPromoManager();
          paramType = (Promo)model;
          paramType = new CrossPromoHeroViewModel(pageKey(), paramType, new AtomicBoolean(false), new AtomicBoolean(false), eventBus, fragmentComponent);
          crossPromoView = ((ViewGroup)crossPromoViewStub.inflate());
          getLayoutInflater(null);
          fragmentComponent.mediaCenter();
          paramType.onBindViewHolder$1c57c46f(new CrossPromoHeroViewHolder(crossPromoView));
        } while (crossPromoView.getChildCount() == 0);
        paramType.trackImpression();
        return;
        if (!paramSet.equals(STARTER_ROUTE)) {
          break;
        }
      } while (!TextUtils.isEmpty(query));
      finishRender();
      dataProvider.state).cacheHitIds = Collections.emptySet();
      itemPresenter.updateStarterData(((SearchDataProvider.SearchState)dataProvider.state).starterList(), true);
      return;
      str = SearchUtils.getParamFromRoute("query", paramSet);
    } while ((!query.equals(str)) || (renderFinished));
    finishRender();
    List localList = dedupTypeaheadHits(((SearchDataProvider.SearchState)dataProvider.state).typeaheadList(paramSet), dataProvider.state).cacheHitIds);
    paramSet = (CollectionTemplate)((SearchDataProvider.SearchState)dataProvider.state).getModel(paramSet);
    if ((paramSet != null) && (metadata != null))
    {
      paramSet = metadata).id;
      paramMap = paramSet;
      if (paramSet == null) {
        paramMap = typeaheadId;
      }
      if (localList != null)
      {
        paramSet = itemPresenter;
        if (paramType != DataStore.Type.NETWORK) {
          break label418;
        }
      }
    }
    for (;;)
    {
      paramSet.updateTypeaheadData(str, localList, bool, false, paramMap);
      removePromoView();
      return;
      paramSet = null;
      break;
      label418:
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TypeaheadItemPresenter localTypeaheadItemPresenter = itemPresenter;
    if (trackingRunnable != null) {
      delayedExecution.stopDelayedExecution(trackingRunnable);
    }
    typeaheadTransformer.stopRevealViewModelRunnable();
  }
  
  public void onDestroyView()
  {
    if (itemPresenter != null)
    {
      TypeaheadItemPresenter localTypeaheadItemPresenter = itemPresenter;
      modelMap.clear();
      if (consistencyCoordinator != null) {
        consistencyCoordinator.removeListener(updateChangedListener);
      }
    }
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(CrossPromoHeroViewModel.HeroDismissedEvent paramHeroDismissedEvent)
  {
    removePromoView();
  }
  
  @Subscribe
  public void onEvent(ClickEvent paramClickEvent)
  {
    Object localObject2 = null;
    Object localObject1 = clickedItem;
    int i = type;
    paramClickEvent = getActivity();
    if (isPickerMode)
    {
      if ((customClickTrackingName != null) && (i != 13)) {
        new ControlInteractionEvent(tracker, customClickTrackingName, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
      }
      switch (typeaheadSource)
      {
      }
      label173:
      do
      {
        return;
        Bus.publish(new ClickEvent(6, localObject1));
        getActivity().onBackPressed();
        return;
        if ((localObject1 instanceof TypeaheadHit))
        {
          paramClickEvent = (TypeaheadHit)localObject1;
          if (!getActivity().getResources().getString(2131233549).equals(text.text)) {
            break label173;
          }
          Bus.publish(new ClickEvent(16, paramClickEvent));
        }
        for (;;)
        {
          getActivity().onBackPressed();
          return;
          if (hitInfo != null) {
            Bus.publish(new ClickEvent(14, paramClickEvent));
          }
        }
        paramClickEvent = getActivity();
      } while (!(paramClickEvent instanceof SearchPicker));
      ((SearchPicker)paramClickEvent).pickAndReturnItem(localObject1);
      return;
    }
    if (i != 9) {
      dataProvider.forceOpenJobSearch = false;
    }
    Object localObject3;
    switch (i)
    {
    default: 
      searchUtils.handleNonPickerModeEntityEvent(paramClickEvent, i, localObject1);
      return;
    case 4: 
      if ((localObject1 instanceof SearchHistory))
      {
        localObject1 = (SearchHistory)localObject1;
        localObject3 = SearchUtils.getQueryFromHistory((SearchHistory)localObject1);
        paramClickEvent = searchType;
        localObject2 = paramClickEvent;
        if (paramClickEvent == SearchType.PEOPLE)
        {
          localObject2 = paramClickEvent;
          if (!dataProvider.isGuidedSearch) {
            localObject2 = SearchType.ALL;
          }
        }
        if (historyInfo.entityAwareSearchQueryValue != null)
        {
          paramClickEvent = SearchUtils.getSearchQueryForSuggestion(historyInfo.entityAwareSearchQueryValue.query, historyInfo.entityAwareSearchQueryValue.suggestedEntities);
          localObject1 = SearchResultPageOrigin.SUGGESTION;
        }
      }
      break;
    }
    while (localObject3 != null)
    {
      searchBarListener.onQuerySubmit((String)localObject3, ((SearchResultPageOrigin)localObject1).toString(), paramClickEvent, (SearchType)localObject2);
      return;
      paramClickEvent = historyInfo.searchQueryValue;
      localObject1 = SearchResultPageOrigin.HISTORY;
      continue;
      if ((localObject1 instanceof TypeaheadHit))
      {
        localObject1 = hitInfo.typeaheadSuggestionValue;
        localObject2 = query;
        paramClickEvent = type;
        Object localObject4 = paramClickEvent;
        if (paramClickEvent == SearchType.PEOPLE)
        {
          localObject4 = paramClickEvent;
          if (!dataProvider.isGuidedSearch) {
            localObject4 = SearchType.ALL;
          }
        }
        String str = SearchUtils.getValueFromSearchQuery((SearchQuery)localObject2, "keywords");
        SearchResultPageOrigin localSearchResultPageOrigin = SearchResultPageOrigin.SUGGESTION;
        SearchQuery localSearchQuery = SearchUtils.getSearchQueryForSuggestion((SearchQuery)localObject2, suggestedEntities);
        localObject2 = localObject4;
        paramClickEvent = localSearchQuery;
        localObject1 = localSearchResultPageOrigin;
        localObject3 = str;
        if (str == null) {
          continue;
        }
        query = str;
        localObject2 = localObject4;
        paramClickEvent = localSearchQuery;
        localObject1 = localSearchResultPageOrigin;
        localObject3 = str;
        continue;
        paramClickEvent = getTextFromClickedItem(localObject1);
        if (paramClickEvent == null) {
          break;
        }
        searchBarListener.onQuerySubmit(paramClickEvent, SearchResultPageOrigin.AUTO_COMPLETE.toString(), null, null);
        query = paramClickEvent;
        return;
        if (renderFinished) {
          break;
        }
        itemPresenter.trackTypeaheadImpression(query, typeaheadId, itemPresenter.typeaheadHitList.size());
        return;
        paramClickEvent = getTextFromClickedItem(localObject1);
        if (paramClickEvent == null) {
          break;
        }
        searchBarListener.onQuerySubmit(paramClickEvent, SearchResultPageOrigin.GLOBAL_SEARCH_HEADER.toString(), null, null);
        return;
      }
      paramClickEvent = null;
      localObject1 = null;
      localObject3 = null;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("query_text", query);
    paramBundle.putString("cache_key", savedCacheKey);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (inputMaxLength > 0) {
      searchBarText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(inputMaxLength) });
    }
    paramView = itemPresenter;
    Object localObject = dataProvider;
    paramBundle = recyclerView;
    EditText localEditText = searchBarText;
    SearchHistoryBar localSearchHistoryBar = historyBar;
    TextView localTextView = historyDismiss;
    boolean bool1 = isPickerMode;
    boolean bool2 = hasFakeHit;
    boolean bool3 = fakeHitAtTop;
    isPickerMode = bool1;
    hasFakeHit = bool2;
    fakeHitAtTop = bool3;
    dataProvider = ((SearchDataProvider)localObject);
    historyBar = localSearchHistoryBar;
    localObject = paramBundle.getContext();
    paramBundle.setItemAnimator(null);
    layoutManager = new LinearLayoutManager((Context)localObject);
    paramBundle.setLayoutManager(layoutManager);
    paramBundle.setAdapter(adapter);
    paramBundle.addOnScrollListener(new TypeaheadItemPresenter.5(paramView, localEditText));
    int i = 2131233563;
    localSearchHistoryBar.setVisibility(8);
    if (!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.SEARCH_HISTORY_CLEAR_TEXT)))
    {
      i = 2131233561;
      localTextView.setText(2131233560);
    }
    localTextView.setOnClickListener(new TypeaheadItemPresenter.3(paramView, localSearchHistoryBar, i));
    localEditText.setOnTouchListener(new TypeaheadItemPresenter.4(paramView, localSearchHistoryBar));
    SearchViewHelper.restoreHistoryBarInRecyclerView(paramBundle, localSearchHistoryBar);
    modelMap = new HashMap();
    consistencyCoordinator = new ModelListConsistencyCoordinator(fragmentComponent.consistencyManager());
    typeaheadTransformer.followingListener = paramView;
    SearchUtils.setupToolBar((BaseActivity)getActivity(), searchBar);
    if (!isPickerMode) {
      dataProvider.state).facetParameterMap.clear();
    }
    searchBarText.setOnFocusChangeListener(new TypeaheadFragment.2(this));
    if (shouldShowKeyboard)
    {
      searchBarText.requestFocus();
      ((InputMethodManager)getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
      shouldShowKeyboard = false;
    }
  }
  
  public final String pageKey()
  {
    if (!isPickerMode) {
      return "search";
    }
    if (customPageKey == null)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Must have a customPageKey for picker mode typeahead"));
    }
    return customPageKey;
  }
  
  public final boolean shouldAggregateMultipleRenders()
  {
    return true;
  }
  
  public final void showCachedConnections(String paramString)
  {
    Object localObject1 = null;
    if (maxCachedConnectionsShown > 0)
    {
      localObject1 = applicationComponent.connectionStore();
      int i = maxCachedConnectionsShown;
      Object localObject2 = paramString.trim() + "%";
      Object localObject3 = "CASE WHEN firstName LIKE '" + (String)localObject2 + "' THEN 1 ELSE 2 END";
      String str = Integer.toString(i);
      localObject1 = ((ConnectionStore)localObject1).getConnections$57f3385f("firstName LIKE ? OR lastName LIKE ?", new String[] { localObject2, localObject2 }, (String)localObject3, str);
      localObject3 = new ArrayList(((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((List)localObject3).add(nextminiProfile);
      }
      localObject2 = SearchCacheHelper.extraProfileIds((List)localObject3);
      localObject1 = localObject2;
      if (!((Set)localObject2).isEmpty())
      {
        itemPresenter.updateTypeaheadData(paramString, SearchCacheHelper.convertToTypeaheadHits(i18NManager, (List)localObject3), false, true, typeaheadId);
        localObject1 = localObject2;
      }
    }
    dataProvider.state).cacheHitIds = ((Set)localObject1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.typeahead.TypeaheadFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */