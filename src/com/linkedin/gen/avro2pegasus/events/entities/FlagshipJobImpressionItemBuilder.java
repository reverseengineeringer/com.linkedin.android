package com.linkedin.gen.avro2pegasus.events.entities;

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
import java.util.ArrayList;
import java.util.List;

public final class FlagshipJobImpressionItemBuilder
  implements DataTemplateBuilder<FlagshipJobImpressionItem>
{
  public static final FlagshipJobImpressionItemBuilder INSTANCE = new FlagshipJobImpressionItemBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("itemTrackingId");
    JSON_KEY_STORE.put("visibleTime");
    JSON_KEY_STORE.put("duration");
    JSON_KEY_STORE.put("gridPosition");
    JSON_KEY_STORE.put("listPosition");
    JSON_KEY_STORE.put("size");
    JSON_KEY_STORE.put("urns");
  }
  
  public static FlagshipJobImpressionItem build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    ArrayList localArrayList = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("itemTrackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = BytesCoercer.INSTANCE;
        localObject4 = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("visibleTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("duration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("gridPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = GridPositionBuilder.INSTANCE;
        localObject3 = GridPositionBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("listPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ListPositionBuilder.INSTANCE;
        localObject2 = ListPositionBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("size", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = EntityDimensionBuilder.INSTANCE;
        localObject1 = EntityDimensionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urns", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            String str = paramDataReader.readString();
            if (str != null) {
              localArrayList.add(str);
            }
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: itemTrackingId when building com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: visibleTime when building com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: urns when building com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem");
    }
    return new FlagshipJobImpressionItem((String)localObject4, l2, l1, (GridPosition)localObject3, (ListPosition)localObject2, (EntityDimension)localObject1, localArrayList, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItemBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */