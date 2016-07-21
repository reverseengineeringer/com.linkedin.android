package com.linkedin.gen.avro2pegasus.events.me;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimensionBuilder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPositionBuilder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObjectBuilder;

public final class NotificationImpressionBuilder
  implements DataTemplateBuilder<NotificationImpression>
{
  public static final NotificationImpressionBuilder INSTANCE = new NotificationImpressionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("notification");
    JSON_KEY_STORE.put("listPosition");
    JSON_KEY_STORE.put("visibleTime");
    JSON_KEY_STORE.put("duration");
    JSON_KEY_STORE.put("size");
    JSON_KEY_STORE.put("insight");
  }
  
  public static NotificationImpression build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("notification", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = TrackingObjectBuilder.INSTANCE;
        localObject4 = TrackingObjectBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("listPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ListPositionBuilder.INSTANCE;
        localObject3 = ListPositionBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("visibleTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("duration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("size", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = EntityDimensionBuilder.INSTANCE;
        localObject2 = EntityDimensionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = TrackingObjectBuilder.INSTANCE;
        localObject1 = TrackingObjectBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: notification when building com.linkedin.gen.avro2pegasus.events.me.NotificationImpression");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: visibleTime when building com.linkedin.gen.avro2pegasus.events.me.NotificationImpression");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: duration when building com.linkedin.gen.avro2pegasus.events.me.NotificationImpression");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: size when building com.linkedin.gen.avro2pegasus.events.me.NotificationImpression");
    }
    return new NotificationImpression((TrackingObject)localObject4, (ListPosition)localObject3, l2, l1, (EntityDimension)localObject2, (TrackingObject)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.NotificationImpressionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */