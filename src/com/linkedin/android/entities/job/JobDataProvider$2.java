package com.linkedin.android.entities.job;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobSavingInfo;

final class JobDataProvider$2
  implements RecordTemplateListener<JobSavingInfo>
{
  JobDataProvider$2(JobDataProvider paramJobDataProvider) {}
  
  public final void onResponse(DataStoreResponse<JobSavingInfo> paramDataStoreResponse)
  {
    JobDataProvider.access$400$36533449(this$0, paramDataStoreResponse, 2131230983);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobDataProvider.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */