package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class TrackingObjectBuilder
  implements DataTemplateBuilder<TrackingObject>
{
  public static final TrackingObjectBuilder INSTANCE = new TrackingObjectBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("objectUrn");
    JSON_KEY_STORE.put("trackingId");
  }
  
  public static TrackingObject build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = BytesCoercer.INSTANCE;
        localObject = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: objectUrn when building com.linkedin.gen.avro2pegasus.events.common.TrackingObject");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.gen.avro2pegasus.events.common.TrackingObject");
    }
    return new TrackingObject(str, (String)localObject, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.TrackingObjectBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */