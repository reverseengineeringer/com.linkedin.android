package com.linkedin.android.entities.job.controllers;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.transformers.JobTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;

final class JobFragment$1
  implements RecordTemplateListener<MiniJob>
{
  JobFragment$1(JobFragment paramJobFragment) {}
  
  public final void onResponse(DataStoreResponse<MiniJob> paramDataStoreResponse)
  {
    if ((error != null) || (model == null) || (JobFragment.access$000(this$0).isDataAvailable())) {
      return;
    }
    JobTransformer.preFillTopCard(this$0.fragmentComponent, JobFragment.access$100(this$0), (MiniJob)model);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.controllers.JobFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */