package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PerformanceTimingItemsBuilder
  implements DataTemplateBuilder<PerformanceTimingItems>
{
  public static final PerformanceTimingItemsBuilder INSTANCE = new PerformanceTimingItemsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("functionName");
    JSON_KEY_STORE.put("functionStartTime");
    JSON_KEY_STORE.put("functionDuration");
  }
  
  public static PerformanceTimingItems build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    long l2 = 0L;
    long l1 = 0L;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("functionName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("functionStartTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("functionDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: functionName when building com.linkedin.gen.avro2pegasus.events.PerformanceTimingItems");
    }
    return new PerformanceTimingItems(str, l2, l1, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.PerformanceTimingItemsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */