package com.linkedin.gen.avro2pegasus.events.pymk;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.GridPositionBuilder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPositionBuilder;

public final class PymkRecommendationBuilder
  implements DataTemplateBuilder<PymkRecommendation>
{
  public static final PymkRecommendationBuilder INSTANCE = new PymkRecommendationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("recommendationUrn");
    JSON_KEY_STORE.put("gridPosition");
    JSON_KEY_STORE.put("listPosition");
    JSON_KEY_STORE.put("trackingId");
  }
  
  public static PymkRecommendation build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("recommendationUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
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
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = BytesCoercer.INSTANCE;
        localObject1 = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: recommendationUrn when building com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation");
    }
    return new PymkRecommendation(str, (GridPosition)localObject3, (ListPosition)localObject2, (String)localObject1, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */