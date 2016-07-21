package com.linkedin.gen.avro2pegasus.events.prop;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimensionBuilder;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.GridPositionBuilder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPositionBuilder;

public final class EntityBuilder
  implements DataTemplateBuilder<Entity>
{
  public static final EntityBuilder INSTANCE = new EntityBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("urn");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("visibleTime");
    JSON_KEY_STORE.put("duration");
    JSON_KEY_STORE.put("gridPosition");
    JSON_KEY_STORE.put("listPosition");
    JSON_KEY_STORE.put("size");
  }
  
  public static Entity build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject4 = null;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = BytesCoercer.INSTANCE;
        localObject4 = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("visibleTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("duration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("gridPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = GridPositionBuilder.INSTANCE;
        localObject3 = GridPositionBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("listPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ListPositionBuilder.INSTANCE;
        localObject2 = ListPositionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("size", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = EntityDimensionBuilder.INSTANCE;
        localObject1 = EntityDimensionBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: urn when building com.linkedin.gen.avro2pegasus.events.prop.Entity");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.gen.avro2pegasus.events.prop.Entity");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: visibleTime when building com.linkedin.gen.avro2pegasus.events.prop.Entity");
    }
    return new Entity(str, (String)localObject4, l2, l1, (GridPosition)localObject3, (ListPosition)localObject2, (EntityDimension)localObject1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.prop.EntityBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */