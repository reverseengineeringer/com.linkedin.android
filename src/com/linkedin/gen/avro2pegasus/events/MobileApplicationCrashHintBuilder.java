package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MobileApplicationCrashHintBuilder
  implements DataTemplateBuilder<MobileApplicationCrashHint>
{
  public static final MobileApplicationCrashHintBuilder INSTANCE = new MobileApplicationCrashHintBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("hint");
    JSON_KEY_STORE.put("timestamp");
  }
  
  public static MobileApplicationCrashHint build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    long l = 0L;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("hint", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: hint when building com.linkedin.gen.avro2pegasus.events.MobileApplicationCrashHint");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: timestamp when building com.linkedin.gen.avro2pegasus.events.MobileApplicationCrashHint");
    }
    return new MobileApplicationCrashHint(str, l, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationCrashHintBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */