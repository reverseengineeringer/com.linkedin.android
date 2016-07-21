package com.linkedin.android.entities.school;

import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;

public final class SchoolDataProvider$SchoolConsistencyListener
  extends DefaultConsistencyListener
{
  private Bus bus;
  private String modelKey;
  private SchoolDataProvider.SchoolState state;
  private String subscriberId;
  
  public SchoolDataProvider$SchoolConsistencyListener(RecordTemplate paramRecordTemplate, String paramString1, Bus paramBus, String paramString2, SchoolDataProvider.SchoolState paramSchoolState)
  {
    super(paramRecordTemplate);
    bus = paramBus;
    modelKey = paramString1;
    subscriberId = paramString2;
    state = paramSchoolState;
  }
  
  public final void safeModelUpdated(DataTemplate paramDataTemplate)
  {
    Bus.publish(new DataUpdatedEvent(subscriberId, modelKey));
    if (modelKey.equals(state.schoolRoute)) {
      state.schoolUpdated = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.SchoolDataProvider.SchoolConsistencyListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */