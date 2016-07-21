package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class StickerObjectBuilder
  implements DataTemplateBuilder<StickerObject>
{
  public static final StickerObjectBuilder INSTANCE = new StickerObjectBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("stickerPackName");
    JSON_KEY_STORE.put("stickerNumber");
  }
  
  public static StickerObject build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    long l = 0L;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("stickerPackName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("stickerNumber", JSON_KEY_STORE))
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
      throw new DataReaderException("Failed to find required field: stickerPackName when building com.linkedin.gen.avro2pegasus.events.messaging.StickerObject");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: stickerNumber when building com.linkedin.gen.avro2pegasus.events.messaging.StickerObject");
    }
    return new StickerObject(str, l, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.StickerObjectBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */