package com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ConnectionsSummaryBuilder
  implements FissileDataModelBuilder<ConnectionsSummary>, DataTemplateBuilder<ConnectionsSummary>
{
  public static final ConnectionsSummaryBuilder INSTANCE = new ConnectionsSummaryBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("numConnections");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.ConnectionsSummaryBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */