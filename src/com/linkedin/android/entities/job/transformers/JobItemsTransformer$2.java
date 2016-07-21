package com.linkedin.android.entities.job.transformers;

import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import java.util.Map;

final class JobItemsTransformer$2
  extends TrackingClosure<Boolean, Void>
{
  JobItemsTransformer$2(Tracker paramTracker, String paramString, JobDataProvider paramJobDataProvider, MiniCompany paramMiniCompany, BasicCompanyInfo paramBasicCompanyInfo, Map paramMap)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobItemsTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */