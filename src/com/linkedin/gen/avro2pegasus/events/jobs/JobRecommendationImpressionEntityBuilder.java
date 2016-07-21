package com.linkedin.gen.avro2pegasus.events.jobs;

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
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObjectBuilder;

public final class JobRecommendationImpressionEntityBuilder
  implements DataTemplateBuilder<JobRecommendationImpressionEntity>
{
  public static final JobRecommendationImpressionEntityBuilder INSTANCE = new JobRecommendationImpressionEntityBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("recommendation");
    JSON_KEY_STORE.put("isSponsored");
    JSON_KEY_STORE.put("visibleTime");
    JSON_KEY_STORE.put("duration");
    JSON_KEY_STORE.put("gridPosition");
    JSON_KEY_STORE.put("listPosition");
    JSON_KEY_STORE.put("size");
  }
  
  public static JobRecommendationImpressionEntity build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    boolean bool8 = false;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("recommendation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = TrackingObjectBuilder.INSTANCE;
        localObject4 = TrackingObjectBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isSponsored", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool8 = paramDataReader.readBoolean();
        bool7 = true;
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
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: recommendation when building com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: isSponsored when building com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: visibleTime when building com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity");
    }
    return new JobRecommendationImpressionEntity((TrackingObject)localObject4, bool8, l2, l1, (GridPosition)localObject3, (ListPosition)localObject2, (EntityDimension)localObject1, bool6, bool7, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntityBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */