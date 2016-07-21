package com.linkedin.android.entities.job.transformers;

import android.support.v4.util.Pair;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import java.util.Map;

final class JobTransformer$6
  extends TrackingClosure<Pair<String, String>, Void>
{
  JobTransformer$6(Tracker paramTracker, String paramString1, JobDataProvider paramJobDataProvider, String paramString2, Map paramMap, FragmentComponent paramFragmentComponent)
  {
    super(paramTracker, paramString1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobTransformer.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */