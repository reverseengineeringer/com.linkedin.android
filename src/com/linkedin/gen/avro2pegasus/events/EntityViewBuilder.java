package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class EntityViewBuilder
  implements DataTemplateBuilder<EntityView>
{
  public static final EntityViewBuilder INSTANCE = new EntityViewBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("viewType");
    JSON_KEY_STORE.put("viewerId");
    JSON_KEY_STORE.put("targetId");
  }
  
  public static EntityView build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    int j = 0;
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("viewType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("viewerId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("targetId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: viewType when building com.linkedin.gen.avro2pegasus.events.EntityView");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: targetId when building com.linkedin.gen.avro2pegasus.events.EntityView");
    }
    return new EntityView(str, j, i, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.EntityViewBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */