package com.linkedin.android.feed.page.feed.unfolloweducate;

import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import javax.inject.Inject;

public final class UnfollowEducateDataProvider
  extends DataProvider<State, DataProvider.DataProviderListener>
{
  @Inject
  public UnfollowEducateDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public static final class State
    extends DataProvider.State
  {
    String unfollowEducateRecommendationsRoute;
    
    public State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */