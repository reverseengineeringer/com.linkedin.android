package com.linkedin.android.entities.job;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.linkedin.android.axle.PromoListener;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.shared.RestliUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.job.GroupedJobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobSupportedItems;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobSavingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class JobDataProvider
  extends DataProvider<JobState, DataProvider.DataProviderListener>
{
  private static final String TAG = JobDataProvider.class.getSimpleName();
  
  @Inject
  public JobDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public static JSONObject constructApplyJobRequestBody$783d4759(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("featured", false).put("phoneNumber", new JSONObject().put("number", paramString2)).put("hidden", false).put("contactEmail", paramString1);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      Log.e(TAG, "Error constructing apply job POST request body.");
    }
    return null;
  }
  
  private static String crossPromoPath(String paramString)
  {
    return new Uri.Builder().path("/cross-promo-fe/api/promo").appendPath(paramString).build().toString();
  }
  
  public final void fetchCrossPromo(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new PromoListener(this, paramString2, paramString3);
    paramString1 = Request.get().url(crossPromoPath(paramString1)).builder(Promo.BUILDER).listener(paramString2).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    activityComponent.dataManager().submit(paramString1);
  }
  
  public final void fetchJob(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    paramString3 = Routes.JOB.buildRouteForId(paramString3);
    Uri localUri = paramString3.buildUpon().appendQueryParameter("supportedItems", JobSupportedItems.CHOPIN.toString()).build();
    state).immediateConnectionsRoute = Uri.withAppendedPath(paramString3, "immediateConnections").toString();
    state).jobRoute = localUri.toString();
    performFetch(Job.BUILDER, localUri.toString(), paramString1, paramString2, paramMap);
  }
  
  public final void fetchJobWithDeco(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    paramString3 = RestliUtils.appendRecipeParameter(Routes.JOB_POSTINGS.buildRouteForId(paramString3), "!_build_nt_doc='RecipefordisplayingaJobsdetailpage.'(entityUrn,title,formattedEmploymentStatus,formattedExperienceLevel,formattedLocation,jobState,listedAt,closedAt,companyDetails,description,skillsDescription,savingInfo,applyingInfo,applyMethod,views,formattedIndustries*,formattedJobFunctions*)");
    state).jobDetailsRoute = paramString3.toString();
    performFetch(JobDetails.BUILDER, paramString3.toString(), paramString1, paramString2, paramMap);
  }
  
  public final boolean isDataAvailable()
  {
    return ((JobState)state).job() != null;
  }
  
  public final void saveJob(Map<String, String> paramMap)
  {
    Object localObject = ((JobState)state).job();
    if ((localObject == null) || (entityUrn == null)) {
      return;
    }
    localObject = Routes.JOB.buildRouteForId(entityUrn.getId()).buildUpon().appendQueryParameter("action", "save").build().toString();
    activityComponent.dataManager().submit(Request.post().url((String)localObject).model(new JsonModel(new JSONObject())).customHeaders(paramMap).listener(new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<JobSavingInfo> paramAnonymousDataStoreResponse)
      {
        JobDataProvider.access$400$36533449(JobDataProvider.this, paramAnonymousDataStoreResponse, 2131230983);
      }
    }).filter(DataManager.DataStoreFilter.ALL));
  }
  
  public final void setupImmediateConnectionsHelper(MiniProfilesCollection paramMiniProfilesCollection)
  {
    Object localObject = null;
    List localList;
    if (paramMiniProfilesCollection == null)
    {
      localList = null;
      if (paramMiniProfilesCollection != null) {
        break label63;
      }
    }
    for (paramMiniProfilesCollection = (MiniProfilesCollection)localObject;; paramMiniProfilesCollection = pagingInfo)
    {
      try
      {
        paramMiniProfilesCollection = EntityUtils.createDefaultCollection(localList, paramMiniProfilesCollection);
        state).immediateConnectionsHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramMiniProfilesCollection, EntitiesMiniProfile.BUILDER, CollectionMetadata.BUILDER);
        return;
      }
      catch (BuilderException paramMiniProfilesCollection)
      {
        label63:
        activityComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(paramMiniProfilesCollection));
      }
      localList = items;
      break;
    }
  }
  
  public final void unsaveJob(Map<String, String> paramMap)
  {
    String str = Routes.JOB.buildRouteForId(state).job().entityUrn.getId()).buildUpon().appendQueryParameter("action", "unsave").build().toString();
    activityComponent.dataManager().submit(Request.post().url(str).model(new JsonModel(new JSONObject())).customHeaders(paramMap).listener(new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<JobSavingInfo> paramAnonymousDataStoreResponse)
      {
        JobDataProvider.access$400$36533449(JobDataProvider.this, paramAnonymousDataStoreResponse, 2131230993);
      }
    }).filter(DataManager.DataStoreFilter.ALL));
  }
  
  public static final class JobConsistencyListener
    extends DefaultConsistencyListener
  {
    private Bus bus;
    private String modelKey;
    private JobDataProvider.JobState state;
    private String subscriberId;
    
    public JobConsistencyListener(DataTemplate paramDataTemplate, String paramString1, Bus paramBus, String paramString2, JobDataProvider.JobState paramJobState)
    {
      super();
      bus = paramBus;
      modelKey = paramString1;
      subscriberId = paramString2;
      state = paramJobState;
    }
    
    public final void safeModelUpdated(DataTemplate paramDataTemplate)
    {
      Bus.publish(new DataUpdatedEvent(subscriberId, modelKey));
      if (modelKey.equals(state.jobRoute)) {
        state.jobUpdated = true;
      }
    }
  }
  
  public static final class JobState
    extends DataProvider.State
  {
    public String applyJobRoute;
    public List<CompanyRanking> companyRankings;
    public String companyRecruitsRoute;
    public Description description;
    public boolean fromSubEntityPage;
    public CollectionTemplateHelper<EntitiesMiniProfile, CollectionMetadata> immediateConnectionsHelper;
    public String immediateConnectionsRoute;
    public String jobDetailsRoute;
    public boolean jobNeedsRefetch = false;
    public CollectionTemplate<MiniProfile, CollectionMetadata> jobPosterInCommon;
    public String jobRoute;
    public GroupedJobItem jobSummary;
    public TrackingObject jobTrackingObject;
    public boolean jobUpdated;
    public String lastSplashPromoPagekey;
    public List<SchoolRanking> schoolRankings;
    public String schoolRecruitsRoute;
    public boolean submittedJobApplication;
    public boolean toastDisplayed;
    
    public JobState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
    
    protected final DefaultConsistencyListener createConsistencyListener(RecordTemplate paramRecordTemplate, String paramString1, String paramString2)
    {
      return new JobDataProvider.JobConsistencyListener(paramRecordTemplate, paramString1, bus, paramString2, this);
    }
    
    public final Promo getCrossPromo(String paramString)
    {
      return (Promo)getModel(JobDataProvider.crossPromoPath(paramString));
    }
    
    public final TrackingObject initJobTrackingObjectFromNetwork()
    {
      Object localObject = job();
      if (localObject != null)
      {
        localObject = miniJob;
        if ((objectUrn != null) && (trackingId != null)) {
          break label88;
        }
        Log.e(JobDataProvider.TAG, "Unable to create TrackingObject for MiniJob, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
        jobTrackingObject = null;
      }
      for (;;)
      {
        return jobTrackingObject;
        try
        {
          label88:
          jobTrackingObject = new TrackingObject.Builder().setObjectUrn(objectUrn.toString()).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
        }
        catch (BuilderException localBuilderException)
        {
          Log.e(JobDataProvider.TAG, localBuilderException);
        }
      }
    }
    
    public final boolean isSplashDisplayed(String paramString)
    {
      return paramString.equals(lastSplashPromoPagekey);
    }
    
    public final Job job()
    {
      return (Job)getModel(jobRoute);
    }
    
    public final JobDetails jobDetails()
    {
      return (JobDetails)getModel(jobDetailsRoute);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */