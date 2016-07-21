package com.linkedin.android.search.unifiedsearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.company.CompanyBundleBuilder;
import com.linkedin.android.entities.company.CompanyIntent;
import com.linkedin.android.entities.group.GroupBundleBuilder;
import com.linkedin.android.entities.group.GroupIntent;
import com.linkedin.android.entities.job.JobBundleBuilder;
import com.linkedin.android.entities.job.JobIntent;
import com.linkedin.android.entities.school.SchoolBundleBuilder;
import com.linkedin.android.entities.school.SchoolIntent;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.growth.seo.appindexing.GoogleAppIndexingManager;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.gms.GeoLocator;
import com.linkedin.android.infra.gms.GeoLocatorListener;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import com.linkedin.android.infra.ui.slidingtab.TabLayout.Tab;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.DisplayedViewDetector;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor;
import com.linkedin.android.pegasus.gen.voyager.feed.InfluencerActor;
import com.linkedin.android.pegasus.gen.voyager.feed.MemberActor;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.search.ClusterType;
import com.linkedin.android.pegasus.gen.voyager.search.Guide;
import com.linkedin.android.pegasus.gen.voyager.search.Guide.GuideInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchCluster;
import com.linkedin.android.pegasus.gen.voyager.search.SearchCompany;
import com.linkedin.android.pegasus.gen.voyager.search.SearchGroup;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchJob;
import com.linkedin.android.pegasus.gen.voyager.search.SearchMetadata;
import com.linkedin.android.pegasus.gen.voyager.search.SearchProfile;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchSchool;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.pegasus.gen.voyager.search.SecondaryResult;
import com.linkedin.android.pegasus.gen.voyager.search.VerticalGuide;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCity;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCountry;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadPostalCode;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadRegion;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadState;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.search.SearchActivity;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.SearchDataProvider.SearchState;
import com.linkedin.android.search.SecondaryClusterActionListener;
import com.linkedin.android.search.facet.FacetParameterMap;
import com.linkedin.android.search.guidedsearch.GuidedSearchTransformer;
import com.linkedin.android.search.guidedsearch.SearchFragmentTabAdapter;
import com.linkedin.android.search.guidedsearch.TabType;
import com.linkedin.android.search.searchengine.SearchEngineItemDecoration;
import com.linkedin.android.search.searchengine.SearchEngineSecondaryResultsViewModel;
import com.linkedin.android.search.searchengine.SearchEngineTransformer;
import com.linkedin.android.search.searchengine.SearchHeadlessProfilePageFragment;
import com.linkedin.android.search.secondaryresults.SecondaryResultsTransformer;
import com.linkedin.android.search.shared.SearchHistoryCreator;
import com.linkedin.android.search.shared.SearchRoutes;
import com.linkedin.android.search.shared.SearchTracking;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.search.shared.TrackingInfo;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import com.linkedin.gen.avro2pegasus.events.search.SearchActionType;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultComponentLayoutType;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultComponentType;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultHit;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultPageOrigin;
import com.linkedin.gen.avro2pegasus.events.search.SearchVertical;
import com.linkedin.xmsg.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class SearchFragment
  extends PageFragment
{
  private static int absolutePosition;
  private static int clusterPosition;
  private static int positionInPrimary;
  private static int positionInRow;
  @Inject
  ActivityComponent activityComponent;
  private Action appIndexPageViewAction;
  @Inject
  SearchFragmentBarPresenter barPresenter;
  @InjectView(2131758520)
  ImageView clearCurrentLocation;
  SearchDataProvider dataProvider;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @Inject
  Bus eventBus;
  @InjectView(2131758514)
  ImageButton facetButton;
  @InjectView(2131758513)
  View facetContainer;
  @Inject
  GeoLocator geoLocator;
  private GeoLocatorListener geoLocatorListener = new SearchFragment.6(this);
  private GoogleApiClient googleApiClient;
  @Inject
  I18NManager i18NManager;
  @Inject
  SearchFragmentItemPresenter itemPresenter;
  @InjectView(2131758518)
  LiImageView jobLocationIcon;
  @InjectView(2131758519)
  TextView jobLocationTextView;
  @Inject
  LixManager lixManager;
  @InjectView(2131758517)
  View locationBar;
  @InjectView(2131758521)
  ProgressBar locationSpinner;
  private String pageKey = "search_srp";
  @InjectView(2131758522)
  RecyclerView recyclerView;
  private SearchMetadata savedMetadata;
  private int scrollPosition;
  @InjectView(2131758512)
  Toolbar searchBar;
  @InjectView(2131755328)
  TextView searchBarText;
  @Inject
  SearchUtils searchUtils;
  @Inject
  SnackbarUtil snackBar;
  SearchFragmentState states;
  private SearchFragmentTabAdapter tabAdapter;
  private TabLayout tabLayout;
  private Map<String, TrackingInfo> trackingMap = new ArrayMap();
  @InjectView(2131758515)
  View verticalSelectorDivider;
  @InjectView(2131758516)
  ViewStub verticalSelectorStub;
  private ViewPortManager viewPortManager;
  
  private void addSearchHitToTrackingMap(SearchHit paramSearchHit, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, SearchResultComponentType paramSearchResultComponentType, SearchResultComponentLayoutType paramSearchResultComponentLayoutType)
  {
    if (paramSearchHit == null) {}
    TrackingInfo localTrackingInfo;
    String str;
    SearchType localSearchType;
    do
    {
      return;
      localTrackingInfo = new TrackingInfo();
      new String();
      str = null;
      localSearchType = getSearchTypeFromSearchHit(paramSearchHit);
      if (hitInfo.hasSearchJobValue)
      {
        str = hitInfo.searchJobValue.backendUrn.toString();
        localObject = SearchVertical.JOB;
      }
      for (;;)
      {
        setTrackInfo(paramSearchHit, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, localTrackingInfo, (SearchVertical)localObject, localSearchType, paramSearchResultComponentType, paramSearchResultComponentLayoutType);
        trackingMap.put(str, localTrackingInfo);
        return;
        if (hitInfo.hasSearchCompanyValue)
        {
          str = hitInfo.searchCompanyValue.backendUrn.toString();
          localObject = SearchVertical.COMPANY;
        }
        else if (hitInfo.hasSearchProfileValue)
        {
          str = hitInfo.searchProfileValue.backendUrn.toString();
          localObject = SearchVertical.PEOPLE;
        }
        else if (hitInfo.hasSearchSchoolValue)
        {
          str = hitInfo.searchSchoolValue.backendUrn.toString();
          localObject = SearchVertical.SCHOOL;
        }
        else
        {
          if (!hitInfo.hasSearchGroupValue) {
            break;
          }
          str = hitInfo.searchGroupValue.backendUrn.toString();
          localObject = SearchVertical.GROUP;
        }
      }
    } while (!hitInfo.hasUpdateValue);
    Object localObject = str;
    if (hitInfo.updateValue.hasValue)
    {
      localObject = str;
      if (hitInfo.updateValue.value.hasReshareValue)
      {
        str = hitInfo.updateValue.value.reshareValue.originalUpdate.urn.toString();
        localObject = SearchVertical.POSTS;
        setTrackInfo(paramSearchHit, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, localTrackingInfo, (SearchVertical)localObject, localSearchType, paramSearchResultComponentType, paramSearchResultComponentLayoutType);
        trackingMap.put(str, localTrackingInfo);
      }
    }
    if ((hitInfo.hasUpdateValue) && (hitInfo.updateValue.hasValue) && (hitInfo.updateValue.value.hasShareUpdateValue) && (hitInfo.updateValue.value.shareUpdateValue.hasActor) && (hitInfo.updateValue.value.shareUpdateValue.actor.hasInfluencerActorValue) && (!hitInfo.updateValue.value.shareUpdateValue.actor.influencerActorValue.followingInfo.following)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        str = hitInfo.updateValue.value.shareUpdateValue.actor.influencerActorValue.followingInfo.entityUrn.toString();
        localObject = SearchVertical.POSTS;
        setTrackInfo(paramSearchHit, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, localTrackingInfo, (SearchVertical)localObject, localSearchType, paramSearchResultComponentType, paramSearchResultComponentLayoutType);
        trackingMap.put(str, localTrackingInfo);
      }
      if (getMemberUrn(paramSearchHit) != null)
      {
        str = getMemberUrn(paramSearchHit);
        setTrackInfo(paramSearchHit, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, localTrackingInfo, (SearchVertical)localObject, localSearchType, paramSearchResultComponentType, paramSearchResultComponentLayoutType);
        trackingMap.put(str, localTrackingInfo);
      }
      str = hitInfo.updateValue.urn.toString();
      localObject = SearchVertical.POSTS;
      break;
    }
  }
  
  private void applySavedLocation()
  {
    Object localObject1 = (SearchDataProvider.SearchState)dataProvider.state;
    Object localObject2;
    SearchDataProvider.SearchState localSearchState;
    if ((countryCode != null) && (postalCode != null) && (locationName != null))
    {
      localObject2 = new TreeMap();
      ((Map)localObject2).put("countryCode", countryCode);
      ((Map)localObject2).put("postalCode", postalCode);
      ((Map)localObject2).put("locationName", locationName);
      localSearchState = (SearchDataProvider.SearchState)dataProvider.state;
      localObject1 = new TreeMap();
      if (locationName == null) {
        break label227;
      }
      ((Map)localObject1).put("locationName", locationName);
      if (facetCity == null) {
        break label232;
      }
      ((Map)localObject1).put("facetCity", facetCity);
    }
    for (;;)
    {
      if (localObject2 == null) {
        break label285;
      }
      showLocationText((String)((Map)localObject2).remove("locationName"));
      localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        states.getNonFacetParams().put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
      localObject2 = null;
      break;
      label227:
      localObject1 = null;
      continue;
      label232:
      if (facetRegion != null) {
        ((Map)localObject1).put("facetRegion", facetRegion);
      } else if (facetState != null) {
        ((Map)localObject1).put("facetState", facetState);
      } else {
        localObject1 = null;
      }
    }
    label285:
    if (localObject1 != null)
    {
      showLocationText((String)((Map)localObject1).remove("locationName"));
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        states.getFacetParams().add((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
    }
  }
  
  private void clearLocationParams()
  {
    states.getFacetParams().remove("facetState");
    states.getFacetParams().remove("facetRegion");
    states.getFacetParams().remove("facetCity");
    states.getNonFacetParams().remove("countryCode");
    states.getNonFacetParams().remove("postalCode");
    SearchDataProvider.SearchState localSearchState = (SearchDataProvider.SearchState)dataProvider.state;
    facetCity = null;
    facetRegion = null;
    facetState = null;
    countryCode = null;
    postalCode = null;
  }
  
  private static SearchResultHit createSearchResultHit(SearchHit paramSearchHit, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SearchType localSearchType = getSearchTypeFromSearchHit(paramSearchHit);
    return SearchTracking.createResultHitForSearchClusters(hitInfo, paramInt1, paramInt2, localSearchType, paramInt3, paramInt4);
  }
  
  private void fireNewPageEvent()
  {
    String str = states.searchType.name().toLowerCase(Locale.US);
    pageKey = ("search_srp_" + str);
    RUMTiming.setPageKey(getRumSessionId(), pageKey);
    new PageViewEvent(tracker, pageKey, true).send();
  }
  
  static String getLocationString(Address paramAddress)
  {
    if (StringUtils.isNotBlank(paramAddress.getLocality())) {
      return paramAddress.getLocality();
    }
    if (StringUtils.isNotBlank(paramAddress.getAdminArea())) {
      return paramAddress.getAdminArea();
    }
    if (StringUtils.isNotBlank(paramAddress.getCountryName())) {
      return paramAddress.getCountryName();
    }
    if (StringUtils.isNotBlank(paramAddress.getPostalCode())) {
      return paramAddress.getPostalCode();
    }
    return "";
  }
  
  private static String getMemberUrn(SearchHit paramSearchHit)
  {
    String str2 = new String();
    String str1;
    if ((hitInfo.updateValue.value != null) && (hitInfo.updateValue.value.shareUpdateValue != null) && (hitInfo.updateValue.value.shareUpdateValue.actor != null) && (hitInfo.updateValue.value.shareUpdateValue.actor.memberActorValue != null) && (hitInfo.updateValue.value.shareUpdateValue.actor.memberActorValue.miniProfile != null) && (hitInfo.updateValue.value.shareUpdateValue.actor.memberActorValue.miniProfile.entityUrn != null)) {
      str1 = hitInfo.updateValue.value.shareUpdateValue.actor.memberActorValue.miniProfile.entityUrn.toString();
    }
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
              do
              {
                return str1;
                if ((hitInfo.updateValue.value != null) && (hitInfo.updateValue.value.shareUpdateValue != null) && (hitInfo.updateValue.value.shareUpdateValue.actor != null) && (hitInfo.updateValue.value.shareUpdateValue.actor.influencerActorValue != null) && (hitInfo.updateValue.value.shareUpdateValue.actor.influencerActorValue.miniProfile != null) && (hitInfo.updateValue.value.shareUpdateValue.actor.influencerActorValue.miniProfile.entityUrn != null)) {
                  return hitInfo.updateValue.value.shareUpdateValue.actor.influencerActorValue.miniProfile.entityUrn.toString();
                }
                str1 = str2;
              } while (hitInfo.updateValue.value == null);
              str1 = str2;
            } while (hitInfo.updateValue.value.shareUpdateValue == null);
            str1 = str2;
          } while (hitInfo.updateValue.value.shareUpdateValue.actor == null);
          str1 = str2;
        } while (hitInfo.updateValue.value.shareUpdateValue.actor.companyActorValue == null);
        str1 = str2;
      } while (hitInfo.updateValue.value.shareUpdateValue.actor.companyActorValue.miniCompany == null);
      str1 = str2;
    } while (hitInfo.updateValue.value.shareUpdateValue.actor.companyActorValue.miniCompany.entityUrn == null);
    return hitInfo.updateValue.value.shareUpdateValue.actor.companyActorValue.miniCompany.entityUrn.toString();
  }
  
  private static SearchType getSearchTypeFromGuides(SearchMetadata paramSearchMetadata)
  {
    if (paramSearchMetadata == null) {
      break label22;
    }
    label22:
    do
    {
      do
      {
        do
        {
          return null;
          paramSearchMetadata = guides;
        } while (paramSearchMetadata == null);
        paramSearchMetadata = paramSearchMetadata.iterator();
      } while (!paramSearchMetadata.hasNext());
      Guide localGuide = (Guide)paramSearchMetadata.next();
      if ((!hasSelected) || (!selected) || (!hasGuideInfo)) {
        break;
      }
      paramSearchMetadata = guideInfo;
    } while (!hasVerticalGuideValue);
    return verticalGuideValue.vertical;
  }
  
  private static SearchType getSearchTypeFromSearchHit(SearchHit paramSearchHit)
  {
    if (hitInfo.hasSearchJobValue) {
      return SearchType.JOBS;
    }
    if (hitInfo.hasSearchCompanyValue) {
      return SearchType.COMPANIES;
    }
    if (hitInfo.hasSearchProfileValue) {
      return SearchType.PEOPLE;
    }
    if (hitInfo.hasSearchSchoolValue) {
      return SearchType.SCHOOLS;
    }
    if (hitInfo.hasSearchGroupValue) {
      return SearchType.GROUPS;
    }
    if (hitInfo.hasUpdateValue) {
      return SearchType.CONTENT;
    }
    return null;
  }
  
  private void getTrackingInfo(CollectionTemplate<SearchCluster, SearchMetadata> paramCollectionTemplate)
  {
    if ((paramCollectionTemplate == null) || (!hasElements) || (!hasMetadata)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    trackingMap.clear();
    Iterator localIterator = elements.iterator();
    while (localIterator.hasNext())
    {
      SearchCluster localSearchCluster = (SearchCluster)localIterator.next();
      clusterPosition += 1;
      if (type.equals(ClusterType.SMALL))
      {
        positionInRow += 1;
        getTrackingSearchHitInfo(SearchResultComponentType.SMALL, SearchResultComponentLayoutType.HORIZONTAL, localSearchCluster, localArrayList);
      }
      else if (type.equals(ClusterType.LARGE))
      {
        getTrackingSearchHitInfo(SearchResultComponentType.LARGE, SearchResultComponentLayoutType.VERTICAL, localSearchCluster, localArrayList);
      }
      else if (type.equals(ClusterType.PRIMARY))
      {
        getTrackingSearchHitInfo(SearchResultComponentType.PRIMARY, SearchResultComponentLayoutType.VERTICAL, localSearchCluster, localArrayList);
      }
    }
    SearchTracking.trackSRPImpressionEventV2(fragmentComponent.tracker(), states.query, paramCollectionTemplate, states.origin, states.lastSearchId, localArrayList);
  }
  
  private void getTrackingSearchHitInfo(SearchResultComponentType paramSearchResultComponentType, SearchResultComponentLayoutType paramSearchResultComponentLayoutType, SearchCluster paramSearchCluster, List<SearchResultComponent> paramList)
  {
    List localList = elements;
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int i = -1;
    int j = 0;
    if (j < localList.size())
    {
      if (paramSearchResultComponentType == SearchResultComponentType.SMALL) {
        i += 1;
      }
      for (;;)
      {
        if ((paramSearchResultComponentType == SearchResultComponentType.LARGE) || (paramSearchResultComponentType == SearchResultComponentType.PRIMARY)) {
          positionInRow += 1;
        }
        absolutePosition += 1;
        k += 1;
        SearchHit localSearchHit = (SearchHit)localList.get(j);
        addSearchHitToTrackingMap(localSearchHit, clusterPosition, positionInRow, i, absolutePosition, k, paramSearchResultComponentType, paramSearchResultComponentLayoutType);
        localArrayList.add(createSearchResultHit(localSearchHit, absolutePosition, k, positionInRow, i));
        j += 1;
        break;
        i = 0;
      }
    }
    paramList.add(SearchTracking.toCreateSearchResultComponent(localArrayList, hitType, clusterPosition, paramSearchResultComponentType, paramSearchResultComponentLayoutType));
  }
  
  private static void resetTrackingPositions()
  {
    positionInRow = -1;
    absolutePosition = 0;
    clusterPosition = 0;
    positionInPrimary = 0;
  }
  
  private static void setTrackInfo(SearchHit paramSearchHit, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, TrackingInfo paramTrackingInfo, SearchVertical paramSearchVertical, SearchType paramSearchType, SearchResultComponentType paramSearchResultComponentType, SearchResultComponentLayoutType paramSearchResultComponentLayoutType)
  {
    clusterPosition = paramInt1;
    positionInRow = paramInt2;
    positionInCol = paramInt3;
    absolutePosition = paramInt4;
    positionInVertical = paramInt5;
    searchHit = paramSearchHit;
    searchVertical = paramSearchVertical;
    searchResultComponentType = paramSearchResultComponentType;
    searchResultComponentLayoutType = paramSearchResultComponentLayoutType;
    searchType = paramSearchType;
  }
  
  private void setupVerticalNav()
  {
    if (!dataProvider.isGuidedSearch) {}
    while ((tabLayout != null) || (savedMetadata == null)) {
      return;
    }
    Object localObject = savedMetadata;
    ArrayList localArrayList = new ArrayList();
    localObject = guides.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Guide localGuide = (Guide)((Iterator)localObject).next();
      localArrayList.add(new TabType(displayText, guideInfo.verticalGuideValue.vertical, urlParameter));
    }
    verticalSelectorDivider.setVisibility(0);
    tabLayout = ((TabLayout)verticalSelectorStub.inflate());
    tabLayout.setTabMode(0);
    tabAdapter = new SearchFragmentTabAdapter(fragmentComponent, getFragmentManager(), localArrayList);
    int j = tabAdapter.getTabPosition(states.searchType);
    int i = j;
    if (j == -1) {
      i = 0;
    }
    tabLayout.setupWithAdapter$661f2163(tabAdapter, i, new SearchFragment.2(this, tabAdapter));
  }
  
  private void showLocationSpinner(boolean paramBoolean)
  {
    Object localObject = locationSpinner;
    int i;
    TextView localTextView;
    if (paramBoolean)
    {
      i = 0;
      ((ProgressBar)localObject).setVisibility(i);
      localTextView = jobLocationTextView;
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (localObject = "";; localObject = getResources().getString(2131233530))
    {
      localTextView.setHint((CharSequence)localObject);
      if (paramBoolean) {
        jobLocationTextView.setText("");
      }
      return;
      i = 8;
      break;
    }
  }
  
  private void updateSearchId(SearchMetadata paramSearchMetadata)
  {
    if (paramSearchMetadata == null) {
      return;
    }
    states.lastSearchId = id;
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (viewPortManager != null) {
      viewPortManager.trackAll(tracker);
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    if (viewPortManager != null) {
      viewPortManager.untrackAll();
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
    itemPresenter.setLoading(false, false);
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
    SearchFragmentItemPresenter localSearchFragmentItemPresenter = itemPresenter;
    peopleTransformer.startRevealViewModelRunnable(fragmentComponent);
    secondaryTransformer.startRevealViewModelRunnable(fragmentComponent);
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
  
  final boolean isRequestStale(String paramString)
  {
    paramString = SearchUtils.getParamFromRoute("timestamp", paramString);
    if (paramString.isEmpty()) {}
    while (Long.parseLong(paramString) >= states.verticalEnterTimeStamp) {
      return false;
    }
    return true;
  }
  
  public final String loadMorePageKey()
  {
    return pageKey + "_load_more";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (EntityUtils.isLixEnabled(fragmentComponent.lixManager(), Lix.SEARCH_JSERP_USER_ACTIVITY_REPORTING)) {
      googleApiClient = new GoogleApiClient.Builder(getActivity()).addApi(AppIndex.API).build();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!isAdded()) {}
    while (paramInt1 != 0) {
      return;
    }
    showLocationSpinner(true);
    geoLocator.start(geoLocatorListener);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = itemPresenter.adapter.getValues().iterator();
    while (paramConfiguration.hasNext())
    {
      Object localObject = (ViewModel)paramConfiguration.next();
      if ((localObject instanceof SearchEngineSecondaryResultsViewModel))
      {
        localObject = (SearchEngineSecondaryResultsViewModel)localObject;
        if (viewHolder != null)
        {
          getLayoutInflater(null);
          fragmentComponent.mediaCenter();
          ((SearchEngineSecondaryResultsViewModel)localObject).onBindViewHolder$5f83e6a3(viewHolder);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject2 = getArguments();
    states = new SearchFragmentState();
    states.query = SearchBundleBuilder.getQueryString((Bundle)localObject2);
    states.jserpUrl = SearchBundleBuilder.getJserpUrl((Bundle)localObject2);
    states.searchType = SearchBundleBuilder.getSearchType((Bundle)localObject2);
    states.origin = SearchUtils.getOriginFromBundle((Bundle)localObject2);
    Object localObject1 = SearchBundleBuilder.getSuggestedEntity((Bundle)localObject2);
    Object localObject4;
    String str;
    if (paramBundle != null)
    {
      states.getFacetParams().applyFacetParams(paramBundle.getBundle("facet_params"));
      scrollPosition = paramBundle.getInt("scroll_position");
      states.isFirstLaunch = paramBundle.getBoolean("first_launch");
      localObject3 = paramBundle.getBundle("non_facet_params");
      if (localObject3 != null)
      {
        localObject4 = ((Bundle)localObject3).keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          str = (String)((Iterator)localObject4).next();
          if (((Bundle)localObject3).getString(str) != null) {
            states.getNonFacetParams().put(str, ((Bundle)localObject3).getString(str));
          }
        }
      }
    }
    else
    {
      states.isFirstLaunch = true;
    }
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    boolean bool = SearchBundleBuilder.getIsHashTag((Bundle)localObject2);
    Object localObject3 = SearchBundleBuilder.getQueryString((Bundle)localObject2);
    if (bool) {
      SearchTracking.fireSearchInputFocusEvent(tracker, "hash_tag_tap", (String)localObject3);
    }
    resetTrackingPositions();
    dataProvider = activityComponent.searchDataProvider();
    dataProvider.state).guidedSearchCacheRouteMap.clear();
    states.trackingHeader = Tracker.createPageInstanceHeader(getPageInstance());
    viewPortManager = new ViewPortManager(tracker, new DisplayedViewDetector());
    viewPortManager.configure(0.0F, 0.0F, 0L);
    if (states.searchType == null)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("must set SearchType for SearchFragment!"));
      states.searchType = SearchType.ALL;
    }
    if (states.searchType == SearchType.TOP) {
      states.searchType = SearchType.ALL;
    }
    if (states.searchType != SearchType.ALL) {
      states.urlParameter = ("v->" + states.searchType.toString());
    }
    if ((states.query != null) && (!SearchResultPageOrigin.SUGGESTION.toString().equals(states.origin)) && (!SearchResultPageOrigin.SECONDARY_SEARCH.toString().equals(states.origin)) && (SearchHistoryCreator.isTypeSupportedInQueryHistory(states.searchType))) {
      dataProvider.insertHistory(SearchHistoryCreator.buildQueryHistory$2c837778(states.query, states.searchType));
    }
    bool = SearchBundleBuilder.shouldOpenJserp((Bundle)localObject2);
    states.fetchAsJserp = bool;
    if (bool) {
      pageKey = "search_srp_jobs";
    }
    localObject2 = SearchBundleBuilder.getSearchQuery(getArguments());
    if ((localObject2 != null) && (hasParameters) && (paramBundle == null))
    {
      localObject3 = new ArrayList(parameters);
      localObject2 = states;
      localObject3 = states.getFacetParams().applyFacetParams((List)localObject3);
      nonFacetMap.put(searchType, localObject3);
    }
    if (!states.getFacetParams().isEmpty()) {
      dataProvider.setFacetParameterMap(states.getFacetParams());
    }
    if (localObject1 != null) {
      states.getNonFacetParams().put("suggestedEntities", localObject1);
    }
    dataProvider.forceOpenJobSearch = false;
    localObject1 = dataProvider;
    localObject2 = SearchRoutes.buildSearchFacetRoute(states.query, ((SearchDataProvider)localObject1).getFacetParametereMap()).toString();
    int i;
    if (((SearchDataProvider.SearchState)state).getModel((String)localObject2) != null)
    {
      i = 1;
      if ((i == 0) && (states.isFirstLaunch))
      {
        localObject1 = dataProvider;
        localObject2 = Tracker.createPageInstanceHeader(getPageInstance());
        localObject3 = busSubscriberId;
        localObject4 = getRumSessionId();
        str = states.query;
        if (paramBundle == null) {
          break label805;
        }
      }
    }
    label805:
    for (bool = true;; bool = false)
    {
      ((SearchDataProvider)localObject1).fetchFacetData((Map)localObject2, (String)localObject3, (String)localObject4, str, bool);
      return;
      i = 0;
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969401, paramViewGroup, false);
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
          return;
        } while (((String)paramSet.iterator().next()).contains(SEARCH_FACETroute));
        itemPresenter.setLoading(false, false);
        paramType = itemPresenter;
      } while (!adapter.isEmpty());
      paramDataManagerException = new SearchFragmentItemPresenter.7(paramType, fragmentComponent.tracker(), "try_again");
      paramSet = getView();
    } while (paramSet == null);
    paramSet = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(paramSet);
    errorPageViewModel.setupDefaultErrorConfiguration(fragmentComponent.context(), paramDataManagerException);
    recyclerView.setVisibility(8);
    paramDataManagerException = errorPageViewModel;
    LayoutInflater localLayoutInflater = fragmentComponent.activity().getLayoutInflater();
    fragmentComponent.activity().applicationComponent.mediaCenter();
    paramDataManagerException.onBindViewHolder$49e9e35b(localLayoutInflater, paramSet);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return;
    }
    paramMap = paramSet.iterator();
    label21:
    Object localObject1;
    label127:
    Object localObject2;
    Object localObject3;
    label497:
    label504:
    boolean bool;
    while (paramMap.hasNext())
    {
      localObject1 = (String)paramMap.next();
      int i;
      if ((((String)localObject1).contains(SEARCHroute)) && (((String)localObject1).contains("q=guided")) && (!isRequestStale((String)localObject1)))
      {
        paramSet = (CollectionTemplate)((SearchDataProvider.SearchState)dataProvider.state).getModel((String)localObject1);
        if (paramSet != null)
        {
          updateSearchId((SearchMetadata)metadata);
          if ((paramSet == null) || (!hasElements) || (!hasMetadata))
          {
            localObject2 = (SearchDataProvider.SearchState)dataProvider.state;
            guidedSearchIndexStart += 20;
            if (!hasPaging) {
              break label497;
            }
          }
          for (i = paging.total;; i = Integer.MAX_VALUE)
          {
            dataProvider.state).guidedSearchPageTotal = i;
            if ((!SearchType.CONTENT.equals(states.searchType)) && (metadata).type != SearchType.CONTENT)) {
              break label504;
            }
            localObject2 = itemPresenter;
            paramSet = GuidedSearchTransformer.getUpdateList(elements);
            localObject1 = new SearchFragmentItemPresenter.5((SearchFragmentItemPresenter)localObject2, (String)localObject1);
            fragmentComponent.updateChangeCoordinator().listenForUpdates(paramSet, updateChangedListener);
            FeedViewTransformer.toViewModels(fragmentComponent, feedViewPool, paramSet, ((SearchFragmentItemPresenter)localObject2).getFeedDataModelMetadata(), (ModelsTransformedCallback)localObject1);
            break;
            localObject2 = elements;
            localObject3 = new ArrayList(((List)localObject2).size());
            ArrayList localArrayList = new ArrayList();
            i = 0;
            while (i < ((List)localObject2).size())
            {
              positionInRow += 1;
              absolutePosition += 1;
              positionInPrimary += 1;
              SearchHit localSearchHit = (SearchHit)((List)localObject2).get(i);
              addSearchHitToTrackingMap(localSearchHit, clusterPosition, positionInRow, 0, absolutePosition, positionInPrimary, SearchResultComponentType.PRIMARY, SearchResultComponentLayoutType.VERTICAL);
              ((List)localObject3).add(createSearchResultHit(localSearchHit, absolutePosition, positionInPrimary, positionInRow, 0));
              i += 1;
            }
            localArrayList.add(SearchTracking.toCreateSearchResultComponent((List)localObject3, metadata).type, clusterPosition, SearchResultComponentType.PRIMARY, SearchResultComponentLayoutType.VERTICAL));
            SearchTracking.trackSRPImpressionEventForLoadMoreV2(fragmentComponent.tracker(), states.query, paramSet, states.origin, states.lastSearchId, localArrayList);
            break label127;
          }
          itemPresenter.setLoading(false, false);
          itemPresenter.updateResult(paramSet, true);
        }
      }
      else if (((String)localObject1).contains(SEARCHroute))
      {
        itemPresenter.setLoading(false, false);
        paramSet = (CollectionTemplate)((SearchDataProvider.SearchState)dataProvider.state).getModel((String)localObject1);
        if (paramSet != null)
        {
          updateSearchId((SearchMetadata)metadata);
          localObject1 = SearchUtils.getParamFromRoute("start", (String)localObject1);
          if ((hasMetadata) && (metadata).hasType))
          {
            localObject2 = metadata).type;
            if ((!dataProvider.isGuidedSearch) || (localObject2 == states.searchType)) {
              states.searchType = ((SearchType)localObject2);
            }
          }
          else
          {
            if (!"0".equals(localObject1))
            {
              bool = true;
              label669:
              if ((!bool) && (!states.fetchAsJserp)) {
                fireNewPageEvent();
              }
              itemPresenter.updateResult(paramSet, bool);
              if ((!bool) && (states.fetchAsJserp) && (metadata != null))
              {
                localObject1 = searchBarText;
                localObject2 = jobLocationTextView;
                localObject3 = (SearchMetadata)metadata;
                ViewUtils.setTextAndUpdateVisibility((TextView)localObject1, keywords);
                if (!TextUtils.isEmpty(location)) {
                  ((TextView)localObject2).setText(location);
                }
                states.query = metadata).keywords;
                dataProvider.insertHistory(SearchHistoryCreator.buildQueryHistory$2c837778(states.query, SearchType.JOBS));
                if ((!TextUtils.isEmpty(states.query)) && (paramType == DataStore.Type.NETWORK))
                {
                  localObject1 = states.query;
                  localObject2 = metadata).location;
                  if (googleApiClient != null)
                  {
                    localObject3 = i18NManager;
                    if (TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label1022;
                    }
                    bool = true;
                    label874:
                    localObject1 = ((I18NManager)localObject3).getString(2131233552, new Object[] { localObject1, Boolean.valueOf(bool), localObject2 });
                    appIndexPageViewAction = GoogleAppIndexingManager.getAction(Uri.parse(states.jserpUrl), (String)localObject1, null);
                    GoogleAppIndexingManager.startAppIndexing(googleApiClient, appIndexPageViewAction);
                  }
                }
              }
              localObject1 = locationBar;
              paramSet = (SearchMetadata)metadata;
              if ((paramSet == null) || (!hasType) || (type != SearchType.JOBS)) {
                break label1028;
              }
              i = 1;
              label975:
              if (i == 0) {
                break label1034;
              }
            }
            label1022:
            label1028:
            label1034:
            for (i = 0;; i = 8)
            {
              ((View)localObject1).setVisibility(i);
              if (scrollPosition <= 0) {
                break;
              }
              recyclerView.scrollToPosition(scrollPosition);
              scrollPosition = 0;
              break;
              bool = false;
              break label669;
              bool = false;
              break label874;
              i = 0;
              break label975;
            }
          }
        }
      }
      else if ((((String)localObject1).contains(GUIDED_SEARCH_CLUSTERroute)) && (!isRequestStale((String)localObject1)))
      {
        itemPresenter.setLoading(false, false);
        paramSet = (CollectionTemplate)((SearchDataProvider.SearchState)dataProvider.state).getModel((String)localObject1);
        if (paramSet != null)
        {
          updateSearchId((SearchMetadata)metadata);
          localObject2 = getSearchTypeFromGuides((SearchMetadata)metadata);
          if (localObject2 != null) {
            states.searchType = ((SearchType)localObject2);
          }
          if ((states.searchType == SearchType.PEOPLE) && (((elements != null) && (!elements.isEmpty())) || (!states.getFacetParams().isEmpty())))
          {
            facetContainer.setVisibility(0);
            if (states.getFacetParams().isEmpty()) {
              break label1367;
            }
            bool = true;
            label1202:
            barPresenter.updateFacetButton(facetButton, bool);
          }
          if (states.searchType == SearchType.JOBS) {
            locationBar.setVisibility(0);
          }
          getTrackingInfo(paramSet);
          SearchDataProvider.getPrimaryElementCount(paramSet);
          dataProvider.state).guidedSearchIndexStart = 10;
          i = SearchDataProvider.getPrimaryElementTotal(paramSet);
          if ((i != -1) && (states.searchType != SearchType.CONTENT)) {
            dataProvider.state).guidedSearchPageTotal = i;
          }
          if ((metadata != null) && (metadata).hasGuides))
          {
            savedMetadata = ((SearchMetadata)metadata);
            setupVerticalNav();
          }
          localObject2 = itemPresenter;
          if ((paramSet != null) && (hasElements) && (hasMetadata)) {
            break label1373;
          }
        }
      }
    }
    for (;;)
    {
      fireNewPageEvent();
      break label21;
      break;
      label1367:
      bool = false;
      break label1202;
      label1373:
      paramSet = elements;
      if (paramSet != null)
      {
        bool = SearchType.TOP.equals(states.searchType);
        localObject3 = GuidedSearchTransformer.getPrimaryClusterUrlParameter(paramSet);
        dataProvider.state).primaryClusterUrlParameter = ((String)localObject3);
        if (states.searchType != SearchType.CONTENT)
        {
          if ((!SearchType.PEOPLE.equals(states.searchType)) && (!bool)) {
            ((SearchFragmentItemPresenter)localObject2).setSecondaryResultBackground();
          }
          localObject3 = GuidedSearchTransformer.toClusterViewModelList(fragmentComponent, paramSet, fragmentComponent.eventBus(), states.query, itemCount, positionMap, states.origin, states.lastSearchId, bool);
          adapter.appendValues((List)localObject3);
        }
        localObject3 = GuidedSearchTransformer.getFeedPrimaryCluster(paramSet);
        if (localObject3 != null) {
          break label1574;
        }
        if (adapter.isEmpty())
        {
          paramSet = Collections.singletonList(SearchEngineTransformer.transformToEmptyResultViewModel(fragmentComponent));
          adapter.appendValues(paramSet);
        }
      }
    }
    label1574:
    paramSet = new ArrayList();
    if (!hasElements) {}
    for (;;)
    {
      localObject1 = new SearchFragmentItemPresenter.4((SearchFragmentItemPresenter)localObject2, (String)localObject1, bool, (SearchCluster)localObject3);
      fragmentComponent.updateChangeCoordinator().listenForUpdates(paramSet, updateChangedListener);
      FeedViewTransformer.toViewModels(fragmentComponent, feedViewPool, paramSet, ((SearchFragmentItemPresenter)localObject2).getFeedDataModelMetadata(), (ModelsTransformedCallback)localObject1);
      break;
      paramSet = GuidedSearchTransformer.getUpdateList(elements);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SearchFragmentItemPresenter localSearchFragmentItemPresenter = itemPresenter;
    peopleTransformer.stopRevealViewModelRunnable();
    secondaryTransformer.stopRevealViewModelRunnable();
  }
  
  public void onDestroyView()
  {
    if (itemPresenter != null)
    {
      SearchFragmentItemPresenter localSearchFragmentItemPresenter = itemPresenter;
      modelMap.clear();
      if (consistencyCoordinator != null) {
        consistencyCoordinator.removeListener(secondaryResultChangedListener);
      }
    }
    tabLayout = null;
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(ClickEvent paramClickEvent)
  {
    Object localObject = clickedItem;
    int i = type;
    paramClickEvent = getActivity();
    if ((i == 7) && ((localObject instanceof SecondaryResult)))
    {
      localObject = type;
      if ((paramClickEvent instanceof SecondaryClusterActionListener))
      {
        localObject = SearchBundleBuilder.create().setQueryString(states.query).setSearchType((SearchType)localObject).setOrigin(SearchResultPageOrigin.SECONDARY_SEARCH.toString());
        ((SecondaryClusterActionListener)paramClickEvent).onSecondaryClusterTap((SearchBundleBuilder)localObject);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (i != 15) {
              break;
            }
          } while (!(paramClickEvent instanceof SearchActivity));
          paramClickEvent = (SearchActivity)paramClickEvent;
        } while (!paramClickEvent.isSafeToExecuteTransaction());
        localObject = SearchHeadlessProfilePageFragment.newInstance();
        paramClickEvent.getSupportFragmentManager().beginTransaction().add(2131758464, (Fragment)localObject, null).addToBackStack(null).commit();
        return;
        if ((i == 12) && ((localObject instanceof MiniJob)))
        {
          localObject = JobBundleBuilder.create((MiniJob)localObject);
          paramClickEvent.startActivity(activityComponent.intentRegistry().job.newIntent(paramClickEvent, (BundleBuilder)localObject));
          return;
        }
        if ((i == 3) && ((localObject instanceof MiniCompany)))
        {
          localObject = CompanyBundleBuilder.create((MiniCompany)localObject, false);
          paramClickEvent.startActivity(activityComponent.intentRegistry().company.newIntent(paramClickEvent, (BundleBuilder)localObject));
          return;
        }
        if ((i == 2) && ((localObject instanceof MiniSchool)))
        {
          localObject = SchoolBundleBuilder.create(entityUrn.getId());
          paramClickEvent.startActivity(activityComponent.intentRegistry().school.newIntent(paramClickEvent, (BundleBuilder)localObject));
          return;
        }
        if ((i == 10) && ((localObject instanceof MiniGroup)))
        {
          localObject = GroupBundleBuilder.create(entityUrn.getId());
          paramClickEvent.startActivity(activityComponent.intentRegistry().group.newIntent(paramClickEvent, (BundleBuilder)localObject));
          return;
        }
        if ((i != 14) || (!(localObject instanceof TypeaheadHit))) {
          break;
        }
        paramClickEvent = (TypeaheadHit)localObject;
      } while ((hitInfo == null) || (hitInfo.typeaheadTitleValue != null));
      localObject = (TypeaheadHit)localObject;
    } while (text == null);
    refreshRUMSessionId();
    showLocationText(text.text);
    states.fetchAsJserp = false;
    itemPresenter.setLoading(true, true);
    paramClickEvent = hitInfo;
    String str2 = text.text;
    clearLocationParams();
    String str1;
    if (typeaheadStateValue != null)
    {
      paramClickEvent = typeaheadStateValue.stateUrn.toString();
      states.getFacetParams().add("facetState", paramClickEvent);
      str1 = null;
      localObject = null;
    }
    for (;;)
    {
      SearchDataProvider.SearchState localSearchState = (SearchDataProvider.SearchState)dataProvider.state;
      facetCity = str1;
      facetRegion = ((String)localObject);
      facetState = paramClickEvent;
      locationName = str2;
      countryCode = null;
      postalCode = null;
      if (!dataProvider.isGuidedSearch)
      {
        dataProvider.fetchSearchData(states.query, SearchType.JOBS, states.origin, busSubscriberId, getRumSessionId(), states.trackingHeader, states.getFacetParams(), states.getNonFacetParams(), false, false);
        return;
        if (typeaheadCityValue != null)
        {
          str1 = typeaheadCityValue.cityUrn.toString();
          states.getFacetParams().add("facetCity", str1);
          localObject = null;
          paramClickEvent = null;
          continue;
        }
        if (typeaheadRegionValue != null)
        {
          localObject = typeaheadRegionValue.regionUrn.toString();
          states.getFacetParams().add("facetRegion", (String)localObject);
          str1 = null;
          paramClickEvent = null;
          continue;
        }
        if (typeaheadPostalCodeValue != null)
        {
          str1 = typeaheadPostalCodeValue.cityUrn.toString();
          states.getFacetParams().add("facetCity", str1);
          localObject = null;
          paramClickEvent = null;
          continue;
        }
        if (typeaheadCountryValue != null)
        {
          localObject = typeaheadCountryValue.countryUrn.toString();
          states.getFacetParams().add("facetRegion", (String)localObject);
          str1 = null;
          paramClickEvent = null;
        }
      }
      else
      {
        dataProvider.fetchClusterData(states.query, busSubscriberId, getRumSessionId(), states.trackingHeader, states.origin, states.searchType, states.urlParameter, states.getFacetParams(), states.getNonFacetParams(), false, false);
        return;
        if (i == 16)
        {
          requestPermission("android.permission.ACCESS_FINE_LOCATION", 2131231563, 2131231562);
          return;
        }
        if ((i == 18) && ((localObject instanceof SearchType)))
        {
          paramClickEvent = (SearchType)localObject;
          if ((tabAdapter == null) || (tabLayout == null)) {
            break;
          }
          i = tabAdapter.getTabPosition(paramClickEvent);
          if (i == -1) {
            break;
          }
          paramClickEvent = tabLayout.getTabAt(i);
          if (paramClickEvent == null) {
            break;
          }
          mTag = SearchResultPageOrigin.CLUSTER_EXPANSION;
          paramClickEvent.select();
          return;
        }
        if ((i != 19) || (localObject == null) || (!(localObject instanceof String))) {
          break;
        }
        localObject = (String)localObject;
        paramClickEvent = null;
        if (((String)localObject).startsWith("urn:li:fs_followingInfo:")) {
          paramClickEvent = SearchActionType.FOLLOW;
        }
        localObject = (TrackingInfo)trackingMap.get(localObject);
        SearchTracking.trackSRPActionEventV2(fragmentComponent.tracker(), states.query, states.origin, states.lastSearchId, (TrackingInfo)localObject, paramClickEvent);
        return;
      }
      str1 = null;
      localObject = null;
      paramClickEvent = null;
    }
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    super.onRequestPermissionsResult(paramSet1, paramSet2);
    if (paramSet2.isEmpty())
    {
      showLocationSpinner(true);
      geoLocator.start(geoLocatorListener);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (recyclerView != null) {
      paramBundle.putInt("scroll_position", ((LinearLayoutManager)recyclerView.getLayoutManager()).findLastVisibleItemPosition());
    }
    paramBundle.putBundle("facet_params", states.getFacetParams().generateBundle());
    if (jobLocationTextView != null) {
      paramBundle.putString("locationName", jobLocationTextView.getText().toString());
    }
    paramBundle.putBoolean("first_launch", states.isFirstLaunch);
    Bundle localBundle = new Bundle();
    Iterator localIterator = states.getNonFacetParams().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    paramBundle.putBundle("non_facet_params", localBundle);
  }
  
  public void onStop()
  {
    if ((googleApiClient == null) || (appIndexPageViewAction == null)) {}
    for (;;)
    {
      super.onStop();
      return;
      GoogleAppIndexingManager.stopAppIndexing(googleApiClient, appIndexPageViewAction);
      appIndexPageViewAction = null;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    int i = 0;
    int j;
    label92:
    boolean bool2;
    label123:
    boolean bool1;
    if (!states.isFirstLaunch)
    {
      paramView = dataProvider.getFacetParametereMap();
      if (!paramView.equals(states.getFacetParams()))
      {
        i = 1;
        j = i;
        if (i != 0)
        {
          refreshRUMSessionId();
          localObject1 = states;
          facetMap.put(searchType, paramView);
          states.origin = SearchResultPageOrigin.FACETED_SEARCH.toString();
          j = i;
        }
        errorPageViewModel = new ErrorPageViewModel(errorViewStub);
        if (states.getFacetParams().isEmpty()) {
          break label759;
        }
        bool2 = true;
        bool1 = bool2;
        if (dataProvider.isGuidedSearch)
        {
          if ((!bool2) || (states.searchType != SearchType.PEOPLE)) {
            break label765;
          }
          bool1 = true;
        }
        label158:
        if ((paramBundle == null) || (j != 0)) {
          break label771;
        }
        bool2 = true;
        label170:
        if ((!states.isFirstLaunch) && (j == 0) && (!bool2)) {
          break label777;
        }
        i = 1;
        label192:
        paramView = itemPresenter;
        Object localObject1 = recyclerView;
        Object localObject5 = searchBarText;
        Object localObject2 = facetContainer;
        Object localObject3 = states;
        Object localObject4 = viewPortManager;
        Object localObject6 = errorPageViewModel;
        facetContainer = ((View)localObject2);
        facetOn = bool1;
        recyclerView = ((RecyclerView)localObject1);
        errorPageViewModel = ((ErrorPageViewModel)localObject6);
        searchBarText = ((TextView)localObject5);
        states = ((SearchFragmentState)localObject3);
        if (i != 0)
        {
          paramView.setLoading(true, true);
          paramView.doFetch(bool2, false);
        }
        localObject5 = ((RecyclerView)localObject1).getContext();
        localObject6 = new LinearLayoutManager((Context)localObject5);
        ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject6);
        ((RecyclerView)localObject1).setAdapter(adapter);
        container = ((View)localObject1);
        adapter.setViewPortManager((ViewPortManager)localObject4);
        ((RecyclerView)localObject1).addOnScrollListener(new RecyclerViewPortListener((ViewPortManager)localObject4));
        if (!dataProvider.isGuidedSearch) {
          ((RecyclerView)localObject1).addItemDecoration(new SearchEngineItemDecoration((Context)localObject5));
        }
        ((RecyclerView)localObject1).addOnScrollListener(new SearchFragmentItemPresenter.3(paramView, (LinearLayoutManager)localObject6));
        ((RecyclerView)localObject1).setItemAnimator(null);
        if ((searchType == SearchType.PEOPLE) && (i == 0))
        {
          ((View)localObject2).setVisibility(0);
          ((View)localObject2).setClickable(true);
        }
        modelMap = new HashMap();
        consistencyCoordinator = new ModelListConsistencyCoordinator(fragmentComponent.consistencyManager());
        secondaryTransformer.followingListener = paramView;
        paramView = new SearchFragment.1(this);
        localObject1 = barPresenter;
        localObject2 = searchBarText;
        localObject3 = searchBar;
        localObject4 = states.query;
        localObject5 = facetContainer;
        localObject6 = facetButton;
        SearchUtils.setupToolBar(activityComponent.activity(), (Toolbar)localObject3);
        KeyboardUtil.hideKeyboard((View)localObject2);
        ((TextView)localObject2).setText((CharSequence)localObject4);
        ((TextView)localObject2).setOnClickListener(SearchUtils.searchBarTextListener(activityComponent.activity(), (String)localObject4, SearchType.PEOPLE, activityComponent.lixManager()));
        ((SearchFragmentBarPresenter)localObject1).updateFacetButton((ImageButton)localObject6, bool1);
        ((View)localObject5).setOnClickListener(new SearchFragmentBarPresenter.1((SearchFragmentBarPresenter)localObject1, activityComponent.tracker(), "search_srp_facet", new TrackingEventBuilder[0], paramView, (String)localObject4));
        if (paramBundle == null) {
          break label782;
        }
      }
    }
    label759:
    label765:
    label771:
    label777:
    label782:
    for (paramView = paramBundle.getString("locationName");; paramView = null)
    {
      if (!TextUtils.isEmpty(paramView)) {
        showLocationText(paramView);
      }
      jobLocationTextView.setOnClickListener(new SearchFragment.3(this, tracker, "job_srp_location", new TrackingEventBuilder[0]));
      jobLocationIcon.setOnClickListener(new SearchFragment.4(this));
      clearCurrentLocation.setOnClickListener(new SearchFragment.5(this));
      states.isFirstLaunch = false;
      return;
      i = 0;
      break;
      j = i;
      if (states.searchType != SearchType.JOBS) {
        break label92;
      }
      j = i;
      if (!lixManager.getTreatment(Lix.LIX_SEARCH_STICKY_LOCATION).equals("enabled")) {
        break label92;
      }
      applySavedLocation();
      j = i;
      break label92;
      bool2 = false;
      break label123;
      bool1 = false;
      break label158;
      bool2 = false;
      break label170;
      i = 0;
      break label192;
    }
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    setupVerticalNav();
  }
  
  public final String pageKey()
  {
    return pageKey;
  }
  
  public final void showLocationText(String paramString)
  {
    showLocationSpinner(false);
    jobLocationTextView.setText(paramString);
    jobLocationTextView.setTextColor(getResources().getColor(2131623960));
    clearCurrentLocation.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.unifiedsearch.SearchFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */