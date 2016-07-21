package com.linkedin.android.identity.guidededit;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFlowManager;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFragmentHelper;
import com.linkedin.android.identity.guidededit.infra.GuidedEditTaskFragment;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.android.pegasus.gen.voyager.entities.school.School;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ContextType;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VersionTag;
import com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditItem;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public final class GuidedEditDataProvider
  extends DataProvider<GuidedEditDataProvider.GuidedEditState, DataProvider.DataProviderListener>
{
  public static final Uri ROOT = Routes.GUIDED_EDIT_FLOWS.buildUponRoot();
  public String currentPOSTUri;
  public String employeesInfoUri;
  public String forcedGuidedEditCategoryRoute;
  public String schoolUri;
  public String versionTagUri;
  
  @Inject
  public GuidedEditDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  private static MultiplexRequest.Builder newUpdateRequestBuilder()
  {
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.sequential();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    return localBuilder.filter(DataManager.DataStoreFilter.NETWORK_ONLY);
  }
  
  public final void deleteNotification(String paramString)
  {
    FlagshipDataManager localFlagshipDataManager = activityComponent.dataManager();
    if (localFlagshipDataManager == null) {
      return;
    }
    paramString = Routes.ME_FEED_CARDS.buildUponRoot().buildUpon().appendPath(paramString).build().toString();
    localFlagshipDataManager.submit(Request.delete().url(paramString).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public final void fetchData(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, GuidedEditSource paramGuidedEditSource)
  {
    ContextType localContextType = GuidedEditFragmentHelper.convertToUeditContextType(paramGuidedEditSource);
    paramString3 = ROOT.buildUpon().appendQueryParameter("q", "findRelevantCategories").appendQueryParameter("vieweeMemberIdentity", paramString3).appendQueryParameter("contextType", localContextType.name()).build().toString();
    switch (GuidedEditDataProvider.1.$SwitchMap$com$linkedin$android$identity$guidededit$infra$shared$GuidedEditSource[paramGuidedEditSource.ordinal()])
    {
    default: 
      state).guidedEditCategoriesRoute = paramString3;
    }
    for (;;)
    {
      paramGuidedEditSource = MultiplexRequest.Builder.parallel().filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      performMultiplexedFetch(paramString1, paramString2, paramMap, paramGuidedEditSource.required(Request.get().url(paramString3).builder(CollectionTemplate.of(GuidedEditCategory.BUILDER))));
      return;
      state).guidedEditCategoriesFeedRoute = paramString3;
    }
  }
  
  public final void fetchUeditRewards$7cc26a56(int paramInt, GuidedEditProfileUpdate paramGuidedEditProfileUpdate, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    Object localObject = Routes.GUIDED_EDIT_U_EDIT.buildPagedRouteUponRoot(paramInt, 20).buildUpon().appendQueryParameter("q", "updatedPymkList").toString();
    paramGuidedEditProfileUpdate = (String)localObject + "&guidedEditProfileUpdate=" + Routes.toRestiUriQueryParam(paramGuidedEditProfileUpdate);
    if (paramInt == 0) {
      state).ueditRoute = paramGuidedEditProfileUpdate;
    }
    for (;;)
    {
      localObject = MultiplexRequest.Builder.parallel().filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      performMultiplexedFetch(paramString1, paramString2, paramMap, ((MultiplexRequest.Builder)localObject).required(Request.get().url(paramGuidedEditProfileUpdate).builder(CollectionTemplate.of(UbiquitousEditItem.BUILDER))));
      return;
      state).ueditMoreRoute = paramGuidedEditProfileUpdate;
    }
  }
  
  public final List<GuidedEditCategory> getGuidedEditCategories()
  {
    return state).guidedEditCategories().elements;
  }
  
  public final boolean isDataAvailable()
  {
    return (((GuidedEditDataProvider.GuidedEditState)state).guidedEditCategories() != null) && (CollectionUtils.isNonEmpty(state).guidedEditCategories().elements));
  }
  
  public final void postAddEntity(String paramString1, String paramString2, String paramString3, String paramString4, RecordTemplate paramRecordTemplate, String paramString5, Map<String, String> paramMap)
  {
    currentPOSTUri = ProfileRoutes.buildAddEntityRoute(paramString1, paramString4, paramString5).toString();
    versionTagUri = ProfileRoutes.buildVersionTagRoute(paramString4, "versionTag").toString();
    paramString5 = newUpdateRequestBuilder().filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.post().url(currentPOSTUri).model(paramRecordTemplate)).optional(Request.get().url(versionTagUri).builder(VersionTag.BUILDER));
    if ((paramRecordTemplate instanceof NormEducation))
    {
      paramRecordTemplate = schoolUrn;
      if (paramRecordTemplate != null)
      {
        paramRecordTemplate = paramRecordTemplate.getLastId();
        schoolUri = Routes.SCHOOL.buildRouteForId(paramRecordTemplate).toString();
        state).schoolRoute = schoolUri;
        paramString5.optional(Request.get().url(state).schoolRoute).builder(School.BUILDER));
      }
    }
    if ("control".equals(activityComponent.lixManager().getTreatment(Lix.PROFILE_VIEW_DISABLE_PROFILE_VIEW_API)))
    {
      state).profileViewRoute = ProfileRoutes.buildProfileViewRoute(paramString4).toString();
      paramString5.optional(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
    }
    for (;;)
    {
      performMultiplexedFetch(paramString2, paramString3, paramMap, paramString5);
      return;
      int i = -1;
      switch (paramString1.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          paramString1 = ProfileRoutes.buildPositionsRoute(paramString4).toString();
          paramString5.optional(Request.get().url(paramString1).builder(CollectionTemplate.of(Position.BUILDER)));
          break;
          if (paramString1.equals("normPositions"))
          {
            i = 0;
            continue;
            if (paramString1.equals("normEducations"))
            {
              i = 1;
              continue;
              if (paramString1.equals("normPublications")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      paramString1 = ProfileRoutes.buildEducationsRoute(paramString4).toString();
      paramString5.optional(Request.get().url(paramString1).builder(CollectionTemplate.of(Education.BUILDER)));
      continue;
      state).publicationsRoute = ProfileRoutes.buildPublicationsRoute(paramString4).toString();
      paramString5.optional(Request.get().url(state).publicationsRoute).builder(CollectionTemplate.of(Publication.BUILDER)));
    }
  }
  
  public final boolean postEducation(GuidedEditFlowManager paramGuidedEditFlowManager, NormEducation paramNormEducation, GuidedEditTaskFragment paramGuidedEditTaskFragment, String paramString)
    throws JSONException
  {
    if (getCurrentTaskrequired)
    {
      if (paramGuidedEditFlowManager.isLastRequiredTask())
      {
        postAddEntity("normEducations", busSubscriberId, paramGuidedEditTaskFragment.getRumSessionId(), fragmentComponent.memberUtil().getProfileId(), paramNormEducation, paramString, Tracker.createPageInstanceHeader(paramGuidedEditTaskFragment.getPageInstance()));
        return true;
      }
    }
    else
    {
      paramGuidedEditFlowManager = paramGuidedEditTaskFragment.getArguments().getString("postEntityID");
      paramNormEducation = new JsonModel(PegasusPatchGenerator.INSTANCE.diffEmpty(PegasusPatchGenerator.modelToJSON(paramNormEducation)));
      if (!TextUtils.isEmpty(paramGuidedEditFlowManager)) {
        postUpdateEntity("normEducations", busSubscriberId, paramGuidedEditTaskFragment.getRumSessionId(), fragmentComponent.memberUtil().getProfileId(), paramNormEducation, paramGuidedEditFlowManager, paramString, Tracker.createPageInstanceHeader(paramGuidedEditTaskFragment.getPageInstance()));
      }
      return true;
    }
    return false;
  }
  
  public final void postIndustry(String paramString1, String paramString2, String paramString3, Industry paramIndustry, String paramString4, Map<String, String> paramMap)
  {
    try
    {
      NormProfile localNormProfile = new NormProfile.Builder().setFirstName("").build(RecordTemplate.Flavor.RECORD);
      paramIndustry = new NormProfile.Builder(localNormProfile).setIndustryName(localizedName).setIndustryUrn(entityUrn).build(RecordTemplate.Flavor.RECORD);
      postProfileDiff(paramString1, paramString2, paramString3, PegasusPatchGenerator.INSTANCE.diff(localNormProfile, paramIndustry), paramString4, paramMap);
      return;
    }
    catch (BuilderException paramString1) {}catch (JSONException paramString1) {}
  }
  
  public final boolean postPosition(GuidedEditFlowManager paramGuidedEditFlowManager, NormPosition paramNormPosition, GuidedEditTaskFragment paramGuidedEditTaskFragment, String paramString)
    throws JSONException
  {
    String str = paramGuidedEditTaskFragment.getArguments().getString("postEntityID");
    if (!TextUtils.isEmpty(str))
    {
      paramGuidedEditFlowManager = new JsonModel(PegasusPatchGenerator.INSTANCE.diffEmpty(PegasusPatchGenerator.modelToJSON(paramNormPosition)));
      if (!TextUtils.isEmpty(str)) {
        postUpdateEntity("normPositions", busSubscriberId, paramGuidedEditTaskFragment.getRumSessionId(), fragmentComponent.memberUtil().getProfileId(), paramGuidedEditFlowManager, str, paramString, Tracker.createPageInstanceHeader(paramGuidedEditTaskFragment.getPageInstance()));
      }
      return true;
    }
    if ((getCurrentTaskrequired) && (paramGuidedEditFlowManager.isLastRequiredTask()))
    {
      postAddEntity("normPositions", busSubscriberId, paramGuidedEditTaskFragment.getRumSessionId(), fragmentComponent.memberUtil().getProfileId(), paramNormPosition, paramString, Tracker.createPageInstanceHeader(paramGuidedEditTaskFragment.getPageInstance()));
      return true;
    }
    return false;
  }
  
  public final void postProfileDiff(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4, Map<String, String> paramMap)
  {
    currentPOSTUri = ProfileRoutes.buildEditProfileRoute(paramString3, paramString4, null).toString();
    versionTagUri = ProfileRoutes.buildVersionTagRoute(paramString3, "versionTag").toString();
    paramJSONObject = newUpdateRequestBuilder().filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.post().url(currentPOSTUri).model(new JsonModel(paramJSONObject))).optional(Request.get().url(versionTagUri).builder(VersionTag.BUILDER));
    state).profileViewRoute = ProfileRoutes.buildProfileViewRoute(paramString3).toString();
    paramJSONObject.optional(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
    performMultiplexedFetch(paramString1, paramString2, paramMap, paramJSONObject);
  }
  
  public final void postUpdateEntity(String paramString1, String paramString2, String paramString3, String paramString4, JsonModel paramJsonModel, String paramString5, String paramString6, Map<String, String> paramMap)
  {
    currentPOSTUri = ProfileRoutes.buildGuidedEditEntityRoute(paramString1, paramString4, paramString5, paramString6).toString();
    versionTagUri = ProfileRoutes.buildVersionTagRoute(paramString4, "versionTag").toString();
    paramJsonModel = newUpdateRequestBuilder().filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.post().url(currentPOSTUri).model(paramJsonModel)).required(Request.get().url(versionTagUri).builder(VersionTag.BUILDER));
    int i = -1;
    switch (paramString1.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      performMultiplexedFetch(paramString2, paramString3, paramMap, paramJsonModel);
      return;
      if (!paramString1.equals("normPositions")) {
        break;
      }
      i = 0;
      break;
      if (!paramString1.equals("normEducations")) {
        break;
      }
      i = 1;
      break;
      paramString1 = ProfileRoutes.buildSinglePositionRoute(paramString4, paramString5).toString();
      paramJsonModel.optional(Request.get().cacheKey(Urn.createFromTuple("fs_position", new Object[] { paramString4, paramString5 }).toString()).url(paramString1).builder(Position.BUILDER));
      continue;
      paramString1 = ProfileRoutes.buildSingleEducationRoute(paramString4, paramString5).toString();
      paramJsonModel.optional(Request.get().cacheKey(Urn.createFromTuple("fs_education", new Object[] { paramString4, paramString5 }).toString()).url(paramString1).builder(Education.BUILDER));
    }
  }
  
  public final void sendForcedCategoryRequest(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    state).forcedGuidedEditCategoryRoute = forcedGuidedEditCategoryRoute;
    performFetch(GuidedEditCategory.BUILDER, forcedGuidedEditCategoryRoute, paramString1, paramString2, paramMap);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.GuidedEditDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */