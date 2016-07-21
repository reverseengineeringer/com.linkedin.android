package com.linkedin.android.growth.heathrow;

import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;

public final class HeathrowFlowDataProvider$State
  extends DataProvider.State
{
  String acceptInviteRoute;
  String heathrowRoute;
  String miniProfileRoute;
  String suggestedRouteTrackingId;
  
  public HeathrowFlowDataProvider$State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowFlowDataProvider.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */