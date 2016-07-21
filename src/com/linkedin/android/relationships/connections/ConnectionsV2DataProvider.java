package com.linkedin.android.relationships.connections;

import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import javax.inject.Inject;

public final class ConnectionsV2DataProvider
  extends DataProvider<ConnectionsV2DataProvider.State, DataProvider.DataProviderListener>
{
  private ConnectionsFetchingManager connectionsFetchingManager;
  FlagshipDataManager dataManager;
  
  @Inject
  public ConnectionsV2DataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
    connectionsFetchingManager = paramActivityComponent.connectionsFetchingManager();
    dataManager = paramActivityComponent.dataManager();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.connections.ConnectionsV2DataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */