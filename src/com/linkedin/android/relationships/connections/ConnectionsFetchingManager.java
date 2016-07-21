package com.linkedin.android.relationships.connections;

import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ConnectionsFetchingManager
{
  private static final String CONNECTIONS_FETCH_CACHE_KEY = MessageFormat.format("{0}:{1}", new Object[] { "collection", "relationships_connections" });
  private static final String TAG = ConnectionsFetchingManager.class.getSimpleName();
  private FlagshipDataManager dataManager;
  private int pageSize;
  private FlagshipSharedPreferences sharedPreferences;
  private List<RecordTemplateListener<CollectionTemplate<Connection, CollectionMetadata>>> updateConnectionsListeners;
  
  @Inject
  public ConnectionsFetchingManager(FlagshipDataManager paramFlagshipDataManager, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    dataManager = paramFlagshipDataManager;
    sharedPreferences = paramFlagshipSharedPreferences;
    updateConnectionsListeners = new ArrayList();
    pageSize = 1000;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.connections.ConnectionsFetchingManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */