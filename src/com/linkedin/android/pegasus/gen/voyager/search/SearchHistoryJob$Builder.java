package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchHistoryJob$Builder
  implements RecordTemplateBuilder<SearchHistoryJob>
{
  public Urn backendUrn = null;
  public boolean hasBackendUrn = false;
  public boolean hasJob = false;
  public MiniJob job = null;
  
  public final SearchHistoryJob build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchHistoryJob.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchHistoryJob(job, backendUrn, hasJob, hasBackendUrn);
      if (!hasJob) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob", "job");
      }
    } while (hasBackendUrn);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob", "backendUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */