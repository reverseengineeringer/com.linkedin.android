package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ListPositionBuilder
  implements DataTemplateBuilder<ListPosition>
{
  public static final ListPositionBuilder INSTANCE = new ListPositionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("index");
  }
  
  public static ListPosition build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i = 0;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("index", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: index when building com.linkedin.gen.avro2pegasus.events.common.ListPosition");
    }
    return new ListPosition(i, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.ListPositionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */