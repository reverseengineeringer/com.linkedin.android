package com.linkedin.android.pegasus.gen.realtimefrontend;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ClientConnectionBuilder
  implements FissileDataModelBuilder<ClientConnection>, DataTemplateBuilder<ClientConnection>
{
  public static final ClientConnectionBuilder INSTANCE = new ClientConnectionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
  }
  
  public static ClientConnection build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.realtimefrontend.ClientConnection");
    }
    return new ClientConnection(str, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.realtimefrontend.ClientConnectionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */