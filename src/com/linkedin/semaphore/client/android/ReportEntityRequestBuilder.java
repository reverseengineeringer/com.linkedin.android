package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ReportEntityRequestBuilder
  implements DataTemplateBuilder<ReportEntityRequest>
{
  public static final ReportEntityRequestBuilder INSTANCE = new ReportEntityRequestBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("contentSource");
    JSON_KEY_STORE.put("reportedEntity");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityRequestBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */