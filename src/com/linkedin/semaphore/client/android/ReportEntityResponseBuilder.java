package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ReportEntityResponseBuilder
  implements DataTemplateBuilder<ReportEntityResponse>
{
  public static final ReportEntityResponseBuilder INSTANCE = new ReportEntityResponseBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("status");
    JSON_KEY_STORE.put("clientAction");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityResponseBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */