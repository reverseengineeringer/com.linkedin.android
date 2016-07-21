package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class EntityDimensionBuilder
  implements DataTemplateBuilder<EntityDimension>
{
  public static final EntityDimensionBuilder INSTANCE = new EntityDimensionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("height");
    JSON_KEY_STORE.put("width");
  }
  
  public static EntityDimension build(DataReader paramDataReader)
    throws DataReaderException
  {
    int j = 0;
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("height", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("width", JSON_KEY_STORE))
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: height when building com.linkedin.gen.avro2pegasus.events.common.EntityDimension");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: width when building com.linkedin.gen.avro2pegasus.events.common.EntityDimension");
    }
    return new EntityDimension(j, i, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.EntityDimensionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */