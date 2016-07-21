package com.linkedin.android.infra.events;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class DataReceivedEvent
{
  public final Map<String, DataStoreResponse> responseMap;
  public final Set<String> routes;
  public final String rumSessionId;
  public final String subscriberId;
  public final DataStore.Type type;
  
  public DataReceivedEvent(String paramString1, String paramString2, Set<String> paramSet, DataStore.Type paramType, Map<String, DataStoreResponse> paramMap)
  {
    subscriberId = paramString1;
    rumSessionId = paramString2;
    routes = Collections.unmodifiableSet(paramSet);
    type = paramType;
    if (paramMap != null) {}
    for (paramString1 = Collections.unmodifiableMap(paramMap);; paramString1 = null)
    {
      responseMap = paramString1;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.DataReceivedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */