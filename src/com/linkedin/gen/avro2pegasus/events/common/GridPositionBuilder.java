package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class GridPositionBuilder
  implements DataTemplateBuilder<GridPosition>
{
  public static final GridPositionBuilder INSTANCE = new GridPositionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("row");
    JSON_KEY_STORE.put("column");
  }
  
  public static GridPosition build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i = 0;
    int j = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("row", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("column", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: row when building com.linkedin.gen.avro2pegasus.events.common.GridPosition");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: column when building com.linkedin.gen.avro2pegasus.events.common.GridPosition");
    }
    return new GridPosition(i, j, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.GridPositionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */