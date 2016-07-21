package com.linkedin.android.entities.job.transformers;

import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails;

final class JobTransformerV2$1
  extends TrackingClosure<Boolean, Void>
{
  JobTransformerV2$1(Tracker paramTracker, String paramString, JobDetails paramJobDetails, JobDataProvider paramJobDataProvider, FragmentComponent paramFragmentComponent)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobTransformerV2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */