package com.linkedin.android.search.starter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.TabScrolledEvent;
import com.linkedin.android.home.TabSelectedEvent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory.HistoryInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.SearchDataProvider.SearchState;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.search.shared.SearchViewHelper;
import com.linkedin.android.search.ui.SearchHistoryBar;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultPageOrigin;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class SearchStarterFragment
  extends ViewPagerFragment
{
  @Inject
  ActivityComponent activityComponent;
  private SearchDataProvider dataProvider;
  @Inject
  Bus eventBus;
  @InjectView(2131758567)
  SearchHistoryBar historyBar;
  @InjectView(2131758529)
  TextView historyDismiss;
  @Inject
  IntentRegistry intentRegistry;
  @Inject
  SearchStarterItemPresenter itemPresenter;
  @InjectView(2131758568)
  RecyclerView recyclerView;
  @Inject
  SearchUtils searchUtils;
  private boolean tabScrolledToSearch;
  private boolean tabScrolling;
  @InjectView(2131758512)
  Toolbar toolbar;
  
  public final void doEnter()
  {
    super.doEnter();
    refreshRUMSessionId();
    if (!tabScrolling)
    {
      itemPresenter.showLoadingView(true);
      dataProvider.fetchStarterData(Tracker.createPageInstanceHeader(getPageInstance()), busSubscriberId, getRumSessionId(), false, false);
      if (historyBar != null) {
        historyBar.restore();
      }
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
    tabScrolling = false;
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.searchDataProvider();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean isParentFragment()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    dataProvider = activityComponent.searchDataProvider();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969411, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    super.onDataError(paramType, paramSet, paramDataManagerException);
    itemPresenter.showLoadingView(false);
    itemPresenter.updateData(Collections.EMPTY_LIST);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramSet = ((SearchDataProvider.SearchState)dataProvider.state).starterList();
    paramType = paramSet;
    if (paramSet == null) {
      paramType = Collections.EMPTY_LIST;
    }
    if (paramType.isEmpty()) {
      historyBar.setVisibility(8);
    }
    for (;;)
    {
      itemPresenter.updateData(paramType);
      return;
      historyBar.setVisibility(0);
    }
  }
  
  @Subscribe
  public void onEvent(TabScrolledEvent paramTabScrolledEvent)
  {
    if (source != 1) {
      return;
    }
    if (!end)
    {
      tabScrolling = true;
      return;
    }
    tabScrolling = false;
    if ((tab == HomeTabInfo.SEARCH) && (tabScrolledToSearch))
    {
      itemPresenter.showLoadingView(true);
      dataProvider.fetchStarterData(Tracker.createPageInstanceHeader(getPageInstance()), busSubscriberId, getRumSessionId(), false, false);
    }
    tabScrolledToSearch = false;
  }
  
  @Subscribe
  public void onEvent(TabSelectedEvent paramTabSelectedEvent)
  {
    if ((tab == HomeTabInfo.SEARCH) && (!tapSelected)) {}
    for (boolean bool = true;; bool = false)
    {
      tabScrolledToSearch = bool;
      return;
    }
  }
  
  @Subscribe
  public void onEvent(ClickEvent paramClickEvent)
  {
    Object localObject = clickedItem;
    int i = type;
    paramClickEvent = getActivity();
    switch (i)
    {
    default: 
      searchUtils.handleNonPickerModeEntityEvent(paramClickEvent, i, localObject);
    }
    do
    {
      return;
    } while (!(localObject instanceof SearchHistory));
    paramClickEvent = (SearchHistory)localObject;
    FragmentActivity localFragmentActivity = getActivity();
    String str = SearchUtils.getQueryFromHistory(paramClickEvent);
    if (historyInfo.entityAwareSearchQueryValue != null)
    {
      paramClickEvent = historyInfo.entityAwareSearchQueryValue;
      localObject = SearchResultPageOrigin.SUGGESTION;
    }
    for (paramClickEvent = SearchUtils.getSearchQueryForSuggestion(query, suggestedEntities);; paramClickEvent = historyInfo.searchQueryValue)
    {
      paramClickEvent = SearchBundleBuilder.create().setQueryString(str).setOpenSearchFragment().setOrigin(((SearchResultPageOrigin)localObject).toString()).setSearchQuery(paramClickEvent).setSearchType(SearchType.ALL);
      localFragmentActivity.startActivity(intentRegistry.search.newIntent(localFragmentActivity, paramClickEvent));
      return;
      localObject = SearchResultPageOrigin.HISTORY;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = itemPresenter;
    paramBundle = recyclerView;
    paramBundle.setLayoutManager(new LinearLayoutManager(paramBundle.getContext()));
    paramBundle.setAdapter(adapter);
    int i = 2131233563;
    historyBar.setVisibility(8);
    if (!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.SEARCH_HISTORY_CLEAR_TEXT)))
    {
      historyDismiss.setText(2131233560);
      i = 2131233561;
    }
    historyDismiss.setOnClickListener(new SearchStarterFragment.1(this, i));
    SearchViewHelper.restoreHistoryBarInRecyclerView(recyclerView, historyBar);
  }
  
  public final String pageKey()
  {
    return "search_starter";
  }
  
  @OnClick({2131758512})
  public void startSearchActivity()
  {
    startActivity(intentRegistry.search.newIntent(getActivity(), SearchBundleBuilder.create()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.starter.SearchStarterFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */