package com.linkedin.android.infra.events;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import java.util.Set;

public final class DataErrorEvent
{
  public final DataManagerException error;
  public final Set<String> routes;
  public final String rumSessionId;
  public final String subscriberId;
  public final DataStore.Type type;
  
  public DataErrorEvent(String paramString1, String paramString2, Set<String> paramSet, DataStore.Type paramType, DataManagerException paramDataManagerException)
  {
    subscriberId = paramString1;
    rumSessionId = paramString2;
    routes = paramSet;
    type = paramType;
    error = paramDataManagerException;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.DataErrorEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */