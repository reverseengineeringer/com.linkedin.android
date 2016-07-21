package com.linkedin.android.entities.company;

import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.DataTemplate;

public final class CompanyDataProvider$CompanyConsistencyListener
  extends DefaultConsistencyListener
{
  private Bus bus;
  private String modelKey;
  private CompanyDataProvider.CompanyState state;
  private String subscriberId;
  
  public CompanyDataProvider$CompanyConsistencyListener(DataTemplate paramDataTemplate, String paramString1, Bus paramBus, String paramString2, CompanyDataProvider.CompanyState paramCompanyState)
  {
    super(paramDataTemplate);
    bus = paramBus;
    modelKey = paramString1;
    subscriberId = paramString2;
    state = paramCompanyState;
  }
  
  public final void safeModelUpdated(DataTemplate paramDataTemplate)
  {
    Bus.publish(new DataUpdatedEvent(subscriberId, modelKey));
    if (modelKey.equals(state.companyRoute)) {
      state.companyUpdated = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyDataProvider.CompanyConsistencyListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */