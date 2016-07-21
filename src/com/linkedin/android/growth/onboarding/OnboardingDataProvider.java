package com.linkedin.android.growth.onboarding;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataRequestWrapper.Builder;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexCompletionCallback;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.lego.LegoDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.common.City;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Country;
import com.linkedin.android.pegasus.gen.voyager.common.State;
import com.linkedin.android.pegasus.gen.voyager.growth.confirmation.EmailConfirmationTask;
import com.linkedin.android.pegasus.gen.voyager.growth.goal.GoalType;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import com.linkedin.android.pegasus.gen.voyager.growth.profile.UnderageResponse;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VersionTag;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONObject;

public final class OnboardingDataProvider
  extends LegoDataProvider<OnboardingState>
{
  @Inject
  public OnboardingDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final void batchSendPymkInvitations$55f8b3d8(JSONObject paramJSONObject, RecordTemplateListener<JsonModel> paramRecordTemplateListener, Map<String, String> paramMap)
  {
    performPost$27fd812e(new JsonModel(paramJSONObject), state).invitationsRoute, paramRecordTemplateListener, null, paramMap);
  }
  
  public final Request.Builder<Profile> createProfileRequest(String paramString)
  {
    state).profileRoute = ProfileRoutes.buildProfileRoute(paramString).toString();
    return Request.get().url(state).profileRoute).builder(Profile.BUILDER);
  }
  
  public final void fetchCities(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, DataManager.DataStoreFilter paramDataStoreFilter)
  {
    state).citiesRoute = Routes.buildCitiesRoute(paramString1, paramString2).toString();
    paramString1 = newModelListener(paramString3, paramString4);
    activityComponent.dataManager().submit(Request.get().url(state).citiesRoute).builder(CollectionTemplate.of(City.BUILDER)).listener(paramString1).customHeaders(paramMap).filter(paramDataStoreFilter));
  }
  
  public final void fetchCountries(RecordTemplateListener paramRecordTemplateListener, DataManager.DataStoreFilter paramDataStoreFilter)
  {
    paramDataStoreFilter = Request.get().url(state).countriesRoute).builder(CollectionTemplate.of(Country.BUILDER)).filter(paramDataStoreFilter);
    if (paramRecordTemplateListener != null) {}
    for (paramRecordTemplateListener = paramDataStoreFilter.listener(paramRecordTemplateListener);; paramRecordTemplateListener = paramDataStoreFilter.listener(newModelListener("", null)))
    {
      activityComponent.dataManager().submit(paramRecordTemplateListener);
      return;
    }
  }
  
  public final void fetchEmailConfirmationTask(String paramString, Map<String, String> paramMap)
  {
    paramString = newModelListener(paramString, null);
    activityComponent.dataManager().submit(Request.get().url(state).emailConfirmationTaskRoute).builder(EmailConfirmationTask.BUILDER).listener(paramString).customHeaders(paramMap).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public final void fetchProfile(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    String str = activityComponent.memberUtil().getProfileId();
    if (str != null)
    {
      state).profileRoute = ProfileRoutes.buildProfileRoute(str).toString();
      performFetch(Profile.BUILDER, state).profileRoute, paramString1, paramString2, paramMap);
      return;
    }
    Util.safeThrow$7a8b4789(new RuntimeException("Profile id is null"));
  }
  
  public final void fetchStates(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, DataManager.DataStoreFilter paramDataStoreFilter)
  {
    state).statesRoute = Routes.buildStatesRoute(paramString1).toString();
    paramString1 = newModelListener(paramString2, paramString3);
    activityComponent.dataManager().submit(Request.get().url(state).statesRoute).builder(CollectionTemplate.of(State.BUILDER)).listener(paramString1).customHeaders(paramMap).filter(paramDataStoreFilter));
  }
  
  public final void fetchVersionTag$5ea691a4(String paramString, Map<String, String> paramMap)
  {
    String str = activityComponent.memberUtil().getProfileId();
    if (str != null)
    {
      state).versionTagRoute = ProfileRoutes.buildVersionTagRoute(str, "versionTag").toString();
      performFetch(VersionTag.BUILDER, state).versionTagRoute, paramString, null, paramMap);
      return;
    }
    Util.safeThrow$7a8b4789(new RuntimeException("Profile id is null"));
  }
  
  public final List<City> getCities(String paramString1, String paramString2)
  {
    paramString1 = Routes.buildCitiesRoute(paramString1, paramString2).toString();
    paramString1 = (CollectionTemplate)((OnboardingState)state).getModel(paramString1);
    if ((paramString1 != null) && (elements != null) && (!elements.isEmpty())) {
      return elements;
    }
    return null;
  }
  
  public final EmailConfirmationTask getEmailConfirmationTask()
  {
    return ((OnboardingState)state).emailConfirmationTask();
  }
  
  public final CollectionTemplate<GoalType, CollectionMetadata> getGoalTypes()
  {
    OnboardingState localOnboardingState = (OnboardingState)state;
    return (CollectionTemplate)localOnboardingState.getModel(goalTypeRecommendationsRoute);
  }
  
  public final CollectionTemplate<PeopleYouMayKnow, CollectionMetadata> getPeopleYouMayKnow()
  {
    OnboardingState localOnboardingState = (OnboardingState)state;
    return (CollectionTemplate)localOnboardingState.getModel(peopleYouMayKnowRoute);
  }
  
  public final Profile getProfile()
  {
    return ((OnboardingState)state).profile();
  }
  
  public final List<State> getStates(String paramString)
  {
    paramString = Routes.buildStatesRoute(paramString).toString();
    paramString = (CollectionTemplate)((OnboardingState)state).getModel(paramString);
    if ((paramString != null) && (elements != null) && (!elements.isEmpty())) {
      return elements;
    }
    return null;
  }
  
  public final VersionTag getVersionTag()
  {
    return ((OnboardingState)state).versionTag();
  }
  
  public final boolean isProfileAvailable()
  {
    return ((OnboardingState)state).profile() != null;
  }
  
  public final boolean isVersionTagAvailable()
  {
    return ((OnboardingState)state).versionTag() != null;
  }
  
  public final <T extends RecordTemplate<T>> void loadDataModelFromCache(String paramString, DefaultModelListener<T> paramDefaultModelListener, DataTemplateBuilder<T> paramDataTemplateBuilder)
  {
    activityComponent.dataManager().submit(Request.get().url(paramString).cacheKey(paramString).builder(paramDataTemplateBuilder).listener(paramDefaultModelListener).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
  }
  
  public final void makeParallelCacheRequest(String paramString1, String paramString2, List<DataRequestWrapper.Builder> paramList)
  {
    if (!paramList.isEmpty())
    {
      MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      localBuilder = localBuilder.filter(DataManager.DataStoreFilter.LOCAL_ONLY);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localBuilder.required((DataRequestWrapper.Builder)paramList.next());
      }
      performMultiplexedFetch(paramString1, paramString2, null, localBuilder);
    }
  }
  
  public final void makeParallelCacheRequest(String paramString1, String paramString2, DataRequestWrapper.Builder... paramVarArgs)
  {
    makeParallelCacheRequest(paramString1, paramString2, Arrays.asList(paramVarArgs));
  }
  
  public final <PM extends RecordTemplate<PM>, RM extends RecordTemplate<RM>> void performPost$27fd812e(PM paramPM, String paramString, RecordTemplateListener<RM> paramRecordTemplateListener, DataTemplateBuilder<RM> paramDataTemplateBuilder, Map<String, String> paramMap)
  {
    paramPM = Request.post().url(paramString).model(paramPM).listener(paramRecordTemplateListener).builder(paramDataTemplateBuilder).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    paramPM.trackingSessionId(null).customHeaders(paramMap);
    activityComponent.dataManager().submit(paramPM);
  }
  
  public final void prefetchData(WidgetContent paramWidgetContent, boolean paramBoolean)
  {
    paramWidgetContent = widgetId;
    int i = -1;
    switch (paramWidgetContent.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramWidgetContent.equals("voyager_onboarding_profile_edit_location")) {
          i = 0;
        }
        break;
      }
    }
    if (paramBoolean)
    {
      fetchCountries(null, DataManager.DataStoreFilter.NETWORK_ONLY);
      return;
    }
    fetchCountries(new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse paramAnonymousDataStoreResponse)
      {
        int j = 0;
        if ((error == null) && (request != null) && (request.url != null) && (model != null)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ((OnboardingDataProvider.OnboardingState)state).setModel(request.url, model, "");
          return;
        }
        paramAnonymousDataStoreResponse = val$widgetId;
        switch (paramAnonymousDataStoreResponse.hashCode())
        {
        }
        for (i = -1;; i = j)
        {
          switch (i)
          {
          default: 
            return;
          }
          fetchCountries(null, DataManager.DataStoreFilter.NETWORK_ONLY);
          return;
          if (!paramAnonymousDataStoreResponse.equals("voyager_onboarding_profile_edit_location")) {
            break;
          }
        }
      }
    }, DataManager.DataStoreFilter.LOCAL_ONLY);
  }
  
  public final <T extends RecordTemplate<T>> void saveDataModelToCache(String paramString, T paramT)
  {
    activityComponent.dataManager().submit(Request.put().url(paramString).cacheKey(paramString).model(paramT).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
  }
  
  public final void sendMuxRequest(MultiplexCompletionCallback paramMultiplexCompletionCallback, PageInstance paramPageInstance, Request.Builder... paramVarArgs)
  {
    if (paramVarArgs.length > 0)
    {
      MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      localBuilder = localBuilder.filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      completionCallback = paramMultiplexCompletionCallback;
      customHeaders = Tracker.createPageInstanceHeader(paramPageInstance);
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localBuilder.required(paramVarArgs[i]);
        i += 1;
      }
      activityComponent.dataManager().submit(localBuilder.build());
    }
  }
  
  public static final class OnboardingState
    extends DataProvider.State
  {
    public String addEducationRoute;
    public String addPositionRoute;
    public final String basicLocationRoute = Routes.buildBasicLocationRoute().toString();
    public String citiesRoute;
    public final String countriesRoute = Routes.buildCountriesRoute().toString();
    public String editProfileRoute;
    public String educationsRoute;
    public final String emailConfirmationTaskRoute = Routes.EMAIL.buildUponRoot().buildUpon().build().toString();
    public final String goalTypeRecommendationsRoute = Routes.GOAL_TYPE_RECOMMENDATIONS.buildUponRoot().buildUpon().build().toString();
    public final String goalsRoute = Routes.GOALS.buildUponRoot().buildUpon().build().toString();
    final String invitationsRoute = Routes.NORM_INVITATIONS.buildUponRoot().buildUpon().appendQueryParameter("action", "batchCreate").build().toString();
    public String onboardingFlowRoute = Routes.ONBOARDING_FLOW.buildUponRoot().buildUpon().build().toString();
    public String peopleYouMayKnowRoute;
    public String positionsRoute;
    public String profileRoute;
    public String statesRoute;
    public final String updateUnderageRoute = Routes.UNDERAGE_CHECK.buildUponRoot().buildUpon().appendQueryParameter("action", "update").build().toString();
    public String versionTagRoute;
    
    public OnboardingState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
    
    public final EmailConfirmationTask emailConfirmationTask()
    {
      return (EmailConfirmationTask)getModel(emailConfirmationTaskRoute);
    }
    
    public final Profile profile()
    {
      return (Profile)getModel(profileRoute);
    }
    
    public final ActionResponse<UnderageResponse> underageResponse()
    {
      return (ActionResponse)getModel(updateUnderageRoute);
    }
    
    public final VersionTag versionTag()
    {
      return (VersionTag)getModel(versionTagRoute);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */