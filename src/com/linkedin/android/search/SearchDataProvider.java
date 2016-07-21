package com.linkedin.android.search;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.search.ClusterType;
import com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchCluster;
import com.linkedin.android.pegasus.gen.voyager.search.SearchFacet;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory.HistoryInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryCompany;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryGroup;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit;
import com.linkedin.android.pegasus.gen.voyager.search.SearchMetadata;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQueryParam;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.search.facet.FacetParameterMap;
import com.linkedin.android.search.shared.SearchHistoryCreator;
import com.linkedin.android.search.shared.SearchRoutes;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.json.JSONObject;

public final class SearchDataProvider
  extends DataProvider<SearchDataProvider.SearchState, DataProvider.DataProviderListener>
{
  public boolean forceOpenJobSearch;
  private long historyRefreshInterval;
  public boolean isGuidedSearch;
  private SearchUtils searchUtils;
  
  @Inject
  public SearchDataProvider(ActivityComponent paramActivityComponent, SearchUtils paramSearchUtils)
  {
    super(paramActivityComponent);
    searchUtils = paramSearchUtils;
    isGuidedSearch = paramActivityComponent.lixManager().getTreatment(Lix.SEARCH_VERTICAL_NAV).equals("enabled");
  }
  
  public static int getPrimaryElementCount(CollectionTemplate<SearchCluster, SearchMetadata> paramCollectionTemplate)
  {
    paramCollectionTemplate = elements.iterator();
    while (paramCollectionTemplate.hasNext())
    {
      SearchCluster localSearchCluster = (SearchCluster)paramCollectionTemplate.next();
      if (type.equals(ClusterType.PRIMARY)) {
        return elements.size();
      }
    }
    return 0;
  }
  
  public static int getPrimaryElementTotal(CollectionTemplate<SearchCluster, SearchMetadata> paramCollectionTemplate)
  {
    paramCollectionTemplate = elements.iterator();
    while (paramCollectionTemplate.hasNext())
    {
      SearchCluster localSearchCluster = (SearchCluster)paramCollectionTemplate.next();
      if ((type.equals(ClusterType.PRIMARY)) && (hasTotal)) {
        return (int)total;
      }
    }
    return -1;
  }
  
  private void saveDataInCache(RecordTemplate paramRecordTemplate, String paramString)
  {
    activityComponent.dataManager().submit(Request.put().cacheKey(paramString).model(paramRecordTemplate).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
  }
  
  private void updateLocalHistory()
  {
    Object localObject = new CollectionTemplate(new ArrayList(state).histories), null, null, null, null, true, false, false);
    activityComponent.dataManager().submit(Request.put().cacheKey(state).starterRoute).model((RecordTemplate)localObject).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
    localObject = activityComponent.flagshipSharedPreferences();
    long l = System.currentTimeMillis();
    ((FlagshipSharedPreferences)localObject).getPreferences().edit().putLong("lastSearchHistoryUpdate", l).apply();
  }
  
  public final void clearCache(String paramString)
  {
    activityComponent.dataManager().submit(Request.delete().cacheKey(paramString).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
  }
  
  public final void clearHistory(RecordTemplateListener paramRecordTemplateListener)
  {
    String str = Routes.SEARCH_STARTER.buildUponRoot().buildUpon().appendQueryParameter("action", "dismiss").build().toString();
    activityComponent.dataManager().submit(Request.post().url(str).model(new JsonModel(new JSONObject())).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(new SearchDataProvider.4(this, paramRecordTemplateListener)));
  }
  
  public final boolean fetchClusterData(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, String paramString4, SearchType paramSearchType, String paramString5, FacetParameterMap paramFacetParameterMap, Map<String, String> paramMap2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if (paramSearchType != SearchType.ALL) {
        break label471;
      }
      paramString5 = null;
    }
    label171:
    label188:
    label275:
    label278:
    label285:
    label471:
    for (;;)
    {
      String str = SearchRoutes.buildGuidedSearchRoute(paramString1, getNewSearchId(), paramString4, paramString5, paramFacetParameterMap, paramMap2, false).toString();
      Object localObject = newModelListener(paramString2, paramString3);
      paramString2 = new SearchDataProvider.7(this, paramSearchType, (RecordTemplateListener)localObject);
      localObject = new SearchDataProvider.8(this, (RecordTemplateListener)localObject, str, paramString2, paramMap1, paramString3);
      paramSearchType = (String)state).guidedSearchCacheRouteMap.get(paramSearchType);
      if (paramSearchType != null) {}
      for (paramString1 = SearchRoutes.buildGuidedSearchRoute(paramString1, SearchUtils.getParamFromRoute("searchId", paramSearchType), paramString4, paramString5, paramFacetParameterMap, paramMap2, false).toString();; paramString1 = null)
      {
        if ((paramBoolean2) && (paramSearchType != null) && (paramString1 != null))
        {
          activityComponent.searchUtils();
          SearchUtils.allowUseCache();
          i = 1;
          paramString4 = Request.get();
          if (i == 0) {
            break label275;
          }
          paramString2 = (String)localObject;
          paramString4 = paramString4.listener(paramString2);
          if (i == 0) {
            break label278;
          }
          paramString2 = DataManager.DataStoreFilter.LOCAL_ONLY;
          paramString4 = paramString4.filter(paramString2);
          if (i == 0) {
            break label285;
          }
        }
        for (paramString2 = paramSearchType;; paramString2 = null)
        {
          paramString4 = paramString4.cacheKey(paramString2);
          paramString2 = str;
          if (i != 0) {
            paramString2 = paramString1;
          }
          paramString1 = paramString4.url(paramString2).customHeaders(paramMap1).trackingSessionId(paramString3).builder(new CollectionTemplate.CollectionTemplateJsonParser(SearchCluster.BUILDER, SearchMetadata.BUILDER));
          activityComponent.dataManager().submit(paramString1);
          return true;
          i = 0;
          break;
          break label171;
          paramString2 = DataManager.DataStoreFilter.NETWORK_ONLY;
          break label188;
        }
        if (TextUtils.isEmpty(paramString1)) {
          return false;
        }
        if (state).guidedSearchIndexStart >= state).guidedSearchPageTotal) {
          return false;
        }
        paramSearchType = state).primaryClusterUrlParameter;
        paramString5 = getNewSearchId();
        int i = state).guidedSearchIndexStart;
        paramString1 = SearchRoutes.buildGuidedSearchRoute(paramString1, paramString5, paramString4, paramSearchType, paramFacetParameterMap, paramMap2, true).buildUpon().appendQueryParameter("start", String.valueOf(i)).appendQueryParameter("count", "20").build().toString();
        paramString2 = newModelListener(paramString2, paramString3);
        paramString1 = Request.get().url(paramString1).listener(paramString2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).customHeaders(paramMap1).builder(new CollectionTemplate.CollectionTemplateJsonParser(SearchHit.BUILDER, SearchMetadata.BUILDER));
        paramString1.trackingSessionId(paramString3);
        activityComponent.dataManager().submit(paramString1);
        return true;
      }
    }
  }
  
  public final void fetchFacetData(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    state).facetRoute = SearchRoutes.buildSearchFacetRoute(paramString3, getFacetParametereMap()).toString();
    if (paramBoolean) {}
    for (paramString3 = DataManager.DataStoreFilter.LOCAL_ONLY; ((SearchDataProvider.SearchState)state).facetList() != null; paramString3 = DataManager.DataStoreFilter.NETWORK_ONLY)
    {
      paramMap = new ArrayMap();
      paramMap.put(state).facetRoute, null);
      paramMap = new DataReceivedEvent(paramString1, paramString2, paramMap.keySet(), DataStore.Type.MEMORY, paramMap);
      activityComponent.eventBus();
      Bus.publish(paramMap);
      return;
    }
    paramString1 = newModelListener(paramString1, paramString2);
    paramMap = Request.get().url(state).facetRoute).customHeaders(paramMap).cacheKey(state).facetRoute).filter(paramString3).builder(new CollectionTemplate.CollectionTemplateJsonParser(SearchFacet.BUILDER, CollectionMetadata.BUILDER)).listener(paramString1);
    paramMap.trackingSessionId(paramString2);
    activityComponent.dataManager().submit(paramMap);
  }
  
  public final boolean fetchSearchData(String paramString1, SearchType paramSearchType, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, FacetParameterMap paramFacetParameterMap, Map<String, String> paramMap2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString1)) || ((paramBoolean1) && (state).searchIndexStart >= state).searchPageTotal))) {
      return false;
    }
    if (!paramBoolean1)
    {
      state).searchIndexStart = 0;
      state).searchPageTotal = Integer.MAX_VALUE;
    }
    int i = state).searchIndexStart;
    String str = getNewSearchId();
    paramString1 = SearchRoutes.buildBaseSearchQueryWithoutTrackingParams(paramString1, null, paramSearchType, paramFacetParameterMap, paramMap2).buildUpon().appendQueryParameter("id", str);
    if (paramString2 != null) {
      paramString1.appendQueryParameter("origin", paramString2);
    }
    return makeSearchRequest(paramString1.build().buildUpon().appendQueryParameter("start", String.valueOf(i)).appendQueryParameter("count", "20").build(), paramString3, paramString4, paramMap1, paramBoolean2, paramBoolean1);
  }
  
  public final void fetchStarterData(Map<String, String> paramMap, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    state).typeaheadStarterRequestTimes.put(state).starterRoute, Long.valueOf(System.currentTimeMillis()));
    long l1 = System.currentTimeMillis();
    long l2 = activityComponent.flagshipSharedPreferences().getPreferences().getLong("lastSearchHistoryUpdate", 0L);
    l1 = TimeUnit.MILLISECONDS.toSeconds(l1 - l2);
    historyRefreshInterval = SearchUtils.getHistoryRefreshIntervalFromLix(activityComponent.lixManager().getTreatment(Lix.SEARCH_RECENT_SEARCHES_REFRESH_INTERVAL));
    if (l1 > historyRefreshInterval) {}
    for (int i = 1; (i != 0) && (!paramBoolean2); i = 0)
    {
      fetchStarterDataFromRemote(paramMap, paramString1, paramString2, true);
      return;
    }
    RecordTemplateListener localRecordTemplateListener = newModelListener(paramString1, paramString2);
    if ((paramBoolean1) && (state).histories != null))
    {
      paramMap = Request.get().url(state).starterRoute).customHeaders(paramMap).filter(DataManager.DataStoreFilter.LOCAL_ONLY).builder(new CollectionTemplate.CollectionTemplateJsonParser(SearchHistory.BUILDER, CollectionMetadata.BUILDER));
      paramMap.trackingSessionId(paramString2);
      localRecordTemplateListener.onResponse(DataStoreResponse.localResponse(paramMap.build(), new CollectionTemplate(state).histories, null, null, null, null, true, false, false)));
      return;
    }
    fetchStarterDataFromCache(paramString2, new SearchDataProvider.1(this, localRecordTemplateListener, paramMap, paramString1, paramString2));
  }
  
  public final void fetchStarterDataFromCache(String paramString, RecordTemplateListener<CollectionTemplate<SearchHistory, CollectionMetadata>> paramRecordTemplateListener)
  {
    paramRecordTemplateListener = Request.get().url(state).starterRoute).filter(DataManager.DataStoreFilter.LOCAL_ONLY).builder(new CollectionTemplate.CollectionTemplateJsonParser(SearchHistory.BUILDER, CollectionMetadata.BUILDER)).listener(paramRecordTemplateListener);
    if (paramString != null) {
      paramRecordTemplateListener.trackingSessionId(paramString);
    }
    activityComponent.dataManager().submit(paramRecordTemplateListener);
  }
  
  public final void fetchStarterDataFromRemote(Map<String, String> paramMap, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramMap = Request.get().url(state).starterRoute).customHeaders(paramMap).filter(DataManager.DataStoreFilter.NETWORK_ONLY).builder(new CollectionTemplate.CollectionTemplateJsonParser(SearchHistory.BUILDER, CollectionMetadata.BUILDER)).listener(new SearchDataProvider.2(this, paramString1, paramString2, paramBoolean));
    paramMap.trackingSessionId(paramString2);
    activityComponent.dataManager().submit(paramMap);
  }
  
  public final FacetParameterMap getFacetParametereMap()
  {
    return new FacetParameterMap(state).facetParameterMap);
  }
  
  public final String getNewSearchId()
  {
    return SearchUtils.generateSearchId(String.valueOf(activityComponent.memberUtil().getMemberId()));
  }
  
  public final void insertDedupedHistory(SearchHistory paramSearchHistory)
  {
    SearchHistory localSearchHistory;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (state).histories != null)
    {
      Iterator localIterator = state).histories.iterator();
      if (!localIterator.hasNext()) {
        break label620;
      }
      localSearchHistory = (SearchHistory)localIterator.next();
      localObject1 = historyInfo;
      localObject2 = historyInfo;
      if ((searchHistoryProfileValue == null) || (searchHistoryProfileValue == null)) {
        break label136;
      }
      bool = searchHistoryProfileValue.profile.entityUrn.equals(searchHistoryProfileValue.profile.entityUrn);
      label104:
      if (!bool) {
        break label618;
      }
      localIterator.remove();
    }
    for (;;)
    {
      state).histories.add(0, paramSearchHistory);
      updateLocalHistory();
      return;
      label136:
      if ((searchHistoryCompanyValue != null) && (searchHistoryCompanyValue != null))
      {
        bool = searchHistoryCompanyValue.company.entityUrn.equals(searchHistoryCompanyValue.company.entityUrn);
        break label104;
      }
      if ((searchHistorySchoolValue != null) && (searchHistorySchoolValue != null))
      {
        bool = searchHistorySchoolValue.school.entityUrn.equals(searchHistorySchoolValue.school.entityUrn);
        break label104;
      }
      if ((searchHistoryJobValue != null) && (searchHistoryJobValue != null))
      {
        bool = searchHistoryJobValue.job.entityUrn.equals(searchHistoryJobValue.job.entityUrn);
        break label104;
      }
      if ((searchHistoryGroupValue != null) && (searchHistoryGroupValue != null))
      {
        bool = searchHistoryGroupValue.group.entityUrn.equals(searchHistoryGroupValue.group.entityUrn);
        break label104;
      }
      if ((historyInfo.searchQueryValue != null) && (historyInfo.searchQueryValue != null))
      {
        bool = SearchUtils.getQueryFromHistory(localSearchHistory).equals(SearchUtils.getQueryFromHistory(paramSearchHistory));
        break label104;
      }
      if ((historyInfo.entityAwareSearchQueryValue != null) && (historyInfo.entityAwareSearchQueryValue != null))
      {
        if ((!displayText.equals(displayText)) || (!searchType.equals(searchType))) {
          break label591;
        }
        if (!hasSubtext) {
          break label584;
        }
        if (!subtext.equals(subtext)) {
          break label591;
        }
      }
      label513:
      label584:
      while (!hasSubtext)
      {
        if (!historyInfo.entityAwareSearchQueryValue.suggestedEntities.equals(historyInfo.entityAwareSearchQueryValue.suggestedEntities)) {
          break label591;
        }
        if (!historyInfo.entityAwareSearchQueryValue.query.hasParameters) {
          break label596;
        }
        if (historyInfo.entityAwareSearchQueryValue.query.parameters.size() != historyInfo.entityAwareSearchQueryValue.query.parameters.size()) {
          break label591;
        }
        localObject1 = historyInfo.entityAwareSearchQueryValue.query.parameters.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (SearchQueryParam)((Iterator)localObject1).next();
        } while (historyInfo.entityAwareSearchQueryValue.query.parameters.contains(localObject2));
        bool = false;
        break;
      }
      for (;;)
      {
        label591:
        bool = false;
        break;
        label596:
        if (!historyInfo.entityAwareSearchQueryValue.query.hasParameters) {
          break label513;
        }
      }
      bool = true;
      break label104;
      label618:
      break;
      label620:
      if (state).histories.size() == 10) {
        state).histories.remove(state).histories.size() - 1);
      }
    }
  }
  
  public final void insertHistory(SearchHistory paramSearchHistory)
  {
    if ((paramSearchHistory == null) || (!"enabled".equals(activityComponent.lixManager().getTreatment(Lix.SEARCH_RECENT_SEARCH_LOCAL_CACHE)))) {}
    while ((historyInfo != null) && (historyInfo.searchQueryValue != null) && (!SearchHistoryCreator.isTypeSupportedInQueryHistory(searchType))) {
      return;
    }
    if (state).histories != null)
    {
      insertDedupedHistory(paramSearchHistory);
      return;
    }
    fetchStarterDataFromCache(null, new SearchDataProvider.3(this, paramSearchHistory));
  }
  
  public final boolean makeSearchRequest(Uri paramUri, String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramUri.toString();
    if (paramBoolean1) {}
    for (paramUri = DataManager.DataStoreFilter.LOCAL_ONLY;; paramUri = DataManager.DataStoreFilter.NETWORK_ONLY)
    {
      paramString1 = newModelListener(paramString1, paramString2);
      paramUri = Request.get().cacheKey("search_result_cache_key").url(str).customHeaders(paramMap).filter(paramUri).builder(new CollectionTemplate.CollectionTemplateJsonParser(SearchHit.BUILDER, SearchMetadata.BUILDER)).listener(new SearchDataProvider.9(this, paramString1, paramBoolean2));
      paramUri.trackingSessionId(paramString2);
      activityComponent.dataManager().submit(paramUri);
      return true;
    }
  }
  
  public final void saveFacetDataInCache(List paramList, String paramString)
  {
    saveDataInCache(new CollectionTemplate(paramList, null, null, null, null, true, false, false), paramString);
  }
  
  public final void sendInvite(MiniProfile paramMiniProfile, Map<String, String> paramMap, RecordTemplateListener paramRecordTemplateListener)
  {
    Object localObject = entityUrn.getId();
    try
    {
      localObject = new InviteeProfile.Builder().setProfileId((String)localObject).build(RecordTemplate.Flavor.RECORD);
      localObject = new NormInvitation.Invitee.Builder().setInviteeProfileValue((InviteeProfile)localObject).build();
      paramMiniProfile = new NormInvitation.Builder().setInvitee((NormInvitation.Invitee)localObject).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
      paramMiniProfile = Request.post().url(RelationshipsRoutesHelper.makeSendGrowthInvitationRoute()).model(paramMiniProfile).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(paramRecordTemplateListener).customHeaders(paramMap);
      activityComponent.dataManager().submit(paramMiniProfile);
      return;
    }
    catch (BuilderException paramMiniProfile)
    {
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to send invite", paramMiniProfile));
    }
  }
  
  public final void setFacetParameterMap(FacetParameterMap paramFacetParameterMap)
  {
    state).facetParameterMap = new FacetParameterMap(paramFacetParameterMap);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.SearchDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */