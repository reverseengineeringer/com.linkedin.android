package com.linkedin.android.entities.job;

import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.DataTemplate;

public final class JobDataProvider$JobConsistencyListener
  extends DefaultConsistencyListener
{
  private Bus bus;
  private String modelKey;
  private JobDataProvider.JobState state;
  private String subscriberId;
  
  public JobDataProvider$JobConsistencyListener(DataTemplate paramDataTemplate, String paramString1, Bus paramBus, String paramString2, JobDataProvider.JobState paramJobState)
  {
    super(paramDataTemplate);
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

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobDataProvider.JobConsistencyListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */