package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObjectBuilder;

public final class RecommendedEntityBuilder
  implements DataTemplateBuilder<RecommendedEntity>
{
  public static final RecommendedEntityBuilder INSTANCE = new RecommendedEntityBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entity");
    JSON_KEY_STORE.put("entityPosition");
    JSON_KEY_STORE.put("isFollowing");
  }
  
  public static RecommendedEntity build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    int i = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = TrackingObjectBuilder.INSTANCE;
        localObject = TrackingObjectBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isFollowing", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool4 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: entity when building com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: entityPosition when building com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity");
    }
    return new RecommendedEntity((TrackingObject)localObject, i, bool4, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntityBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */