package com.linkedin.android.datamanager.multiplex;

import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Map;

public final class MultiplexedResponseContentBuilder
  implements DataTemplateBuilder<MultiplexedResponseContent>
{
  private static final JsonKeyStore JSON_KEY_STORE;
  private final EventListener eventListener;
  private final Map<String, String> requestUrlMap;
  private final Map<String, DataTemplateBuilder<? extends RecordTemplate>> responseBuilderMap;
  private final String trackingSessionId;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("responses");
  }
  
  public MultiplexedResponseContentBuilder(Map<String, DataTemplateBuilder<? extends RecordTemplate>> paramMap, String paramString, EventListener paramEventListener, Map<String, String> paramMap1)
  {
    responseBuilderMap = paramMap;
    trackingSessionId = paramString;
    eventListener = paramEventListener;
    requestUrlMap = paramMap1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.MultiplexedResponseContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */