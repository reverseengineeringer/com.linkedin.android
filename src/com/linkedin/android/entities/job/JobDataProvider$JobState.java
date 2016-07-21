package com.linkedin.android.entities.job;

import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.job.GroupedJobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import java.util.List;

public final class JobDataProvider$JobState
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
  
  public JobDataProvider$JobState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
  
  protected final DefaultConsistencyListener createConsistencyListener(RecordTemplate paramRecordTemplate, String paramString1, String paramString2)
  {
    return new JobDataProvider.JobConsistencyListener(paramRecordTemplate, paramString1, bus, paramString2, this);
  }
  
  public final Promo getCrossPromo(String paramString)
  {
    return (Promo)getModel(JobDataProvider.access$700(paramString));
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
      Log.e(JobDataProvider.access$600(), "Unable to create TrackingObject for MiniJob, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
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
        Log.e(JobDataProvider.access$600(), localBuilderException);
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

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobDataProvider.JobState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */