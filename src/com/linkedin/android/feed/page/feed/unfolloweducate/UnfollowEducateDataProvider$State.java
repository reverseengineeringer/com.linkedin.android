package com.linkedin.android.feed.page.feed.unfolloweducate;

import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;

public final class UnfollowEducateDataProvider$State
  extends DataProvider.State
{
  String unfollowEducateRecommendationsRoute;
  
  public UnfollowEducateDataProvider$State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateDataProvider.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */