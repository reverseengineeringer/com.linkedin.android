package com.linkedin.android.search.shared;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.company.CompanyBundleBuilder;
import com.linkedin.android.entities.company.CompanyIntent;
import com.linkedin.android.entities.group.GroupBundleBuilder;
import com.linkedin.android.entities.group.GroupIntent;
import com.linkedin.android.entities.job.JobBundleBuilder;
import com.linkedin.android.entities.job.JobIntent;
import com.linkedin.android.entities.school.SchoolBundleBuilder;
import com.linkedin.android.entities.school.SchoolIntent;
import com.linkedin.android.identity.me.shared.util.MeUtil;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewIntent;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixDefinition;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText.Builder;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory.HistoryInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery.Builder;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQueryParam;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQueryParam.Builder;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.pegasus.gen.voyager.typeahead.SuggestedEntity;
import com.linkedin.android.pegasus.gen.voyager.typeahead.SuggestedEntityType;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.Builder;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo.Builder;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadTitle;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadTitle.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultPageOrigin;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONObject;

public class SearchUtils
{
  private static final String TAG = SearchUtils.class.getSimpleName();
  private IntentRegistry intentRegistry;
  
  @Inject
  public SearchUtils(IntentRegistry paramIntentRegistry)
  {
    intentRegistry = paramIntentRegistry;
  }
  
  public static boolean allowUseCache()
  {
    return true;
  }
  
  public static SearchQuery createSearchQueryByMap(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(createSearchQueryParam((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    try
    {
      paramMap = new SearchQuery.Builder().setParameters(localArrayList).build();
      return paramMap;
    }
    catch (BuilderException paramMap)
    {
      Log.e(TAG, "Error while creating SearchQuery");
    }
    return null;
  }
  
  private static SearchQueryParam createSearchQueryParam(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        SearchQueryParam.Builder localBuilder = new SearchQueryParam.Builder();
        if (paramString1 == null)
        {
          hasName = false;
          name = null;
          if (paramString2 == null)
          {
            hasValue = false;
            value = null;
            return localBuilder.build(RecordTemplate.Flavor.RECORD);
          }
        }
        else
        {
          hasName = true;
          name = paramString1;
          continue;
        }
        hasValue = true;
      }
      catch (BuilderException localBuilderException)
      {
        Log.e(TAG, "Error while creating SearchQueryParam with name : " + paramString1 + " and value : " + paramString2);
        return null;
      }
      value = paramString2;
    }
  }
  
  public static String generateSearchId(String paramString)
  {
    return paramString + System.currentTimeMillis();
  }
  
  public static int getCacheDisplaySizeFromLix(String paramString)
  {
    if ((paramString == null) || (!paramString.startsWith("CACHE_SIZE_"))) {
      return 0;
    }
    paramString = paramString.substring(11);
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      Log.e(TAG, "Error in parsing value for lix " + Lix.SEARCH_CACHE_DISPLAY_SIZE + ". Falling back to default value 0.");
    }
    return 0;
  }
  
  public static String getDegree(MemberDistance paramMemberDistance, I18NManager paramI18NManager)
  {
    if (paramMemberDistance == null) {
      paramMemberDistance = null;
    }
    do
    {
      return paramMemberDistance;
      paramI18NManager = MeUtil.getDistanceString(value, paramI18NManager);
      paramMemberDistance = paramI18NManager;
    } while (paramI18NManager == null);
    return " • " + paramI18NManager;
  }
  
  public static TypeaheadHit getFakedHit(String paramString)
  {
    try
    {
      paramString = new TypeaheadHit.Builder().setText(new AnnotatedText.Builder().setText(paramString).setAnnotations(new ArrayList()).build());
      TypeaheadHit.HitInfo.Builder localBuilder = new TypeaheadHit.HitInfo.Builder();
      Object localObject = new TypeaheadTitle.Builder();
      hasId = true;
      id = "";
      Urn localUrn = new Urn("urn:li:fakehit:12345");
      hasBackendUrn = true;
      backendUrn = localUrn;
      localObject = ((TypeaheadTitle.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      hasTypeaheadTitleValue = true;
      typeaheadTitleValue = ((TypeaheadTitle)localObject);
      paramString = paramString.setHitInfo(localBuilder.build()).build(RecordTemplate.Flavor.RECORD);
      return paramString;
    }
    catch (BuilderException paramString)
    {
      return null;
    }
    catch (URISyntaxException paramString)
    {
      for (;;) {}
    }
  }
  
  public static int getHistoryRefreshIntervalFromLix(String paramString)
  {
    if ((paramString == null) || (!paramString.startsWith("SECONDS_"))) {
      return 180;
    }
    paramString = paramString.substring(8);
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      Log.e(TAG, "Error in parsing value for lix " + Lix.SEARCH_RECENT_SEARCHES_REFRESH_INTERVAL + ". Falling back to default value 180.");
    }
    return 180;
  }
  
  public static int getImageByType(SearchType paramSearchType)
  {
    switch (SearchUtils.3.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$search$SearchType[paramSearchType.ordinal()])
    {
    default: 
      return 0;
    case 1: 
      return 2130838229;
    case 2: 
      return 2130837961;
    case 3: 
      return 2130838314;
    case 4: 
      return 2130837920;
    case 5: 
      return 2130838046;
    }
    return 2130838194;
  }
  
  public static int getOpenSearchEntryType$67eca9c3(LixManager paramLixManager, Lix paramLix)
  {
    if ((paramLix != Lix.ENTITIES_ADD_SEARCH_MENU) && (paramLix != Lix.LIX_PROFILE_VIEW_SHOW_TOOLBAR_SEARCH_ICON)) {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("wrong lix"));
    }
    paramLixManager = paramLixManager.getTreatment(paramLix);
    if ("openSearchBar".equals(paramLixManager)) {
      return 2;
    }
    if ("enabled".equals(paramLixManager)) {
      return 1;
    }
    return 0;
  }
  
  public static String getOriginFromBundle(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("origin"))) {
      return SearchResultPageOrigin.GLOBAL_SEARCH_HEADER.toString();
    }
    return paramBundle.getString("origin");
  }
  
  public static String getOriginFromString(String paramString)
  {
    String str = paramString;
    if (SearchResultPageOrigin.of(paramString) == SearchResultPageOrigin.$UNKNOWN) {
      str = SearchResultPageOrigin.GLOBAL_SEARCH_HEADER.toString();
    }
    return str;
  }
  
  public static String getParamFromRoute(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString2.split("&");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.startsWith(paramString1))
      {
        paramString1 = str.split("=");
        try
        {
          if (paramString1.length > 1) {
            return URLDecoder.decode(paramString1[1], "UTF-8");
          }
          return "";
        }
        catch (UnsupportedEncodingException paramString2)
        {
          Log.d(TAG, "Error in decoding query string : " + paramString1[1]);
          return "";
        }
      }
      i += 1;
    }
    Log.d(TAG, "query param missing in route : " + paramString2);
    return "";
  }
  
  public static Map<String, String> getParamsMap(SearchQuery paramSearchQuery)
  {
    Object localObject = null;
    if (hasParameters)
    {
      ArrayMap localArrayMap = new ArrayMap();
      paramSearchQuery = parameters.iterator();
      for (;;)
      {
        localObject = localArrayMap;
        if (!paramSearchQuery.hasNext()) {
          break;
        }
        localObject = (SearchQueryParam)paramSearchQuery.next();
        localArrayMap.put(name, value);
      }
    }
    return (Map<String, String>)localObject;
  }
  
  public static String getQueryFromHistory(SearchHistory paramSearchHistory)
  {
    if (historyInfo.entityAwareSearchQueryValue != null) {}
    for (String str = subtext; str != null; str = getValueFromSearchQuery(historyInfo.searchQueryValue, "keywords")) {
      return str;
    }
    return displayText;
  }
  
  public static SearchQuery getSearchQueryForSuggestion(SearchQuery paramSearchQuery, List<SuggestedEntity> paramList)
  {
    ArrayList localArrayList = new ArrayList(parameters.size() + paramList.size());
    paramSearchQuery = parameters.iterator();
    while (paramSearchQuery.hasNext())
    {
      SearchQueryParam localSearchQueryParam = (SearchQueryParam)paramSearchQuery.next();
      localArrayList.add(createSearchQueryParam(name, value));
    }
    paramSearchQuery = paramList.iterator();
    while (paramSearchQuery.hasNext()) {
      localArrayList.add(createSearchQueryParam("suggestedEntities", nexttype.toString()));
    }
    try
    {
      paramSearchQuery = new SearchQuery.Builder().setParameters(localArrayList).build();
      return paramSearchQuery;
    }
    catch (BuilderException paramSearchQuery)
    {
      Log.e(TAG, "Error while creating SearchQuery");
    }
    return null;
  }
  
  public static String getValueFromSearchQuery(SearchQuery paramSearchQuery, String paramString)
  {
    if ((paramSearchQuery == null) || (!hasParameters)) {}
    SearchQueryParam localSearchQueryParam;
    do
    {
      while (!paramSearchQuery.hasNext())
      {
        return null;
        paramSearchQuery = parameters.iterator();
      }
      localSearchQueryParam = (SearchQueryParam)paramSearchQuery.next();
    } while (!name.equals(paramString));
    return value;
  }
  
  public static boolean isTypeaheadEntity(TypeaheadHit.HitInfo paramHitInfo)
  {
    return (typeaheadProfileValue != null) || (typeaheadCompanyValue != null) || (typeaheadSchoolValue != null) || (typeaheadGroupValue != null) || (typeaheadShowcaseValue != null);
  }
  
  private void openCompanyOrShowCasePage(Context paramContext, Object paramObject, boolean paramBoolean)
  {
    CompanyBundleBuilder localCompanyBundleBuilder = null;
    if ((paramObject instanceof MiniCompany)) {
      localCompanyBundleBuilder = CompanyBundleBuilder.create((MiniCompany)paramObject, paramBoolean);
    }
    for (;;)
    {
      if (localCompanyBundleBuilder != null) {
        paramContext.startActivity(intentRegistry.company.newIntent(paramContext, localCompanyBundleBuilder));
      }
      return;
      if ((paramObject instanceof String)) {
        localCompanyBundleBuilder = CompanyBundleBuilder.create((String)paramObject, null, paramBoolean);
      }
    }
  }
  
  public static final View.OnClickListener searchBarTextListener(Activity paramActivity, String paramString, SearchType paramSearchType, LixManager paramLixManager)
  {
    return new SearchUtils.1(paramActivity, paramSearchType, paramLixManager, paramString);
  }
  
  public static void sendJoinGroupRequest(FragmentComponent paramFragmentComponent, String paramString, Map<String, String> paramMap, GroupMembershipInfo paramGroupMembershipInfo, RecordTemplateListener paramRecordTemplateListener)
  {
    paramString = Routes.GROUP.buildRouteForId(paramString).buildUpon().appendQueryParameter("action", "sendJoinRequest").build().toString();
    paramFragmentComponent.dataManager().submit(Request.post().url(paramString).model(new JsonModel(new JSONObject())).builder(new ActionResponseBuilder(GroupMembershipInfo.BUILDER)).customHeaders(paramMap).listener(new SearchUtils.2(paramGroupMembershipInfo, paramFragmentComponent, paramRecordTemplateListener)).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public static void setupToolBar(BaseActivity paramBaseActivity, Toolbar paramToolbar)
  {
    paramBaseActivity.setSupportActionBar(paramToolbar);
    paramToolbar = paramBaseActivity.getSupportActionBar();
    paramToolbar.setHomeAsUpIndicator(DrawableHelper.setTint(ContextCompat.getDrawable(paramBaseActivity, 2130838633), ContextCompat.getColor(paramBaseActivity, 2131623977)));
    paramToolbar.setHomeActionContentDescription(2131232791);
    paramToolbar.setDisplayHomeAsUpEnabled(true);
    paramToolbar.setDisplayShowTitleEnabled(false);
  }
  
  public static boolean shouldShowFollowView(FragmentComponent paramFragmentComponent, FollowingInfo paramFollowingInfo, LixDefinition paramLixDefinition)
  {
    if (!"enabled".equals(paramFragmentComponent.lixManager().getTreatment(paramLixDefinition))) {}
    while (paramFollowingInfo == null) {
      return false;
    }
    return true;
  }
  
  public static boolean shouldShowInviteMessageInSearchResultsAndTypeAhead(FragmentComponent paramFragmentComponent)
  {
    return "enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.MYNETWORK_SEARCH_INVITE_CONNECT_VISIBLE));
  }
  
  public static boolean shouldShowInviteMessageInSearchResultsOnly(FragmentComponent paramFragmentComponent)
  {
    return "searchResultsOnly".equals(paramFragmentComponent.lixManager().getTreatment(Lix.MYNETWORK_SEARCH_INVITE_CONNECT_VISIBLE));
  }
  
  public static boolean shouldShowInviteView(FragmentComponent paramFragmentComponent, MemberDistance paramMemberDistance)
  {
    if (!"enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.LIX_SEARCH_INVITE_ACTION))) {}
    do
    {
      return false;
      if (paramMemberDistance == null) {
        return true;
      }
    } while ((value == GraphDistance.DISTANCE_1) || (value == GraphDistance.SELF));
    return true;
  }
  
  public static boolean shouldShowSendMessageView(FragmentComponent paramFragmentComponent, MemberDistance paramMemberDistance)
  {
    if (!"enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.LIX_SEARCH_MESSAGE_ACTION))) {}
    while ((paramMemberDistance == null) || (value != GraphDistance.DISTANCE_1) || (value == GraphDistance.SELF)) {
      return false;
    }
    return true;
  }
  
  public final void handleNonPickerModeEntityEvent(Context paramContext, int paramInt, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof MiniProfile)) {
        localObject1 = ProfileBundleBuilder.create((MiniProfile)paramObject);
      }
      while (localObject1 != null)
      {
        paramContext.startActivity(intentRegistry.profileView.newIntent(paramContext, (BundleBuilder)localObject1));
        return;
        if ((paramObject instanceof String)) {
          localObject1 = ProfileBundleBuilder.createFromProfileId((String)paramObject);
        }
      }
      continue;
      openCompanyOrShowCasePage(paramContext, paramObject, false);
      return;
      openCompanyOrShowCasePage(paramContext, paramObject, true);
      return;
      if ((paramObject instanceof MiniSchool)) {
        localObject1 = SchoolBundleBuilder.create(entityUrn.getId());
      }
      while (localObject1 != null)
      {
        paramContext.startActivity(intentRegistry.school.newIntent(paramContext, (BundleBuilder)localObject1));
        return;
        localObject1 = localObject2;
        if ((paramObject instanceof String)) {
          localObject1 = SchoolBundleBuilder.create((String)paramObject);
        }
      }
      continue;
      if ((paramObject instanceof MiniJob)) {
        localObject1 = JobBundleBuilder.create((MiniJob)paramObject);
      }
      while (localObject1 != null)
      {
        paramContext.startActivity(intentRegistry.job.newIntent(paramContext, (BundleBuilder)localObject1));
        return;
        localObject1 = localObject3;
        if ((paramObject instanceof String)) {
          localObject1 = JobBundleBuilder.create((String)paramObject);
        }
      }
      continue;
      if ((paramObject instanceof MiniGroup)) {
        localObject1 = GroupBundleBuilder.create(entityUrn.getId());
      }
      while (localObject1 != null)
      {
        paramContext.startActivity(intentRegistry.group.newIntent(paramContext, (BundleBuilder)localObject1));
        return;
        localObject1 = localObject4;
        if ((paramObject instanceof String)) {
          localObject1 = GroupBundleBuilder.create((String)paramObject);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.shared.SearchUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */