package com.linkedin.gen.avro2pegasus.events.feed;

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

public final class CommentBuilder
  implements DataTemplateBuilder<Comment>
{
  public static final CommentBuilder INSTANCE = new CommentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("trackableCommentObject");
    JSON_KEY_STORE.put("trackableUpdateObject");
    JSON_KEY_STORE.put("threadUrn");
    JSON_KEY_STORE.put("commenterUrn");
    JSON_KEY_STORE.put("message");
    JSON_KEY_STORE.put("level");
    JSON_KEY_STORE.put("visibleTime");
    JSON_KEY_STORE.put("duration");
    JSON_KEY_STORE.put("associatedInputControlUrn");
    JSON_KEY_STORE.put("totalReplies");
    JSON_KEY_STORE.put("totalLikes");
    JSON_KEY_STORE.put("listPosition");
    JSON_KEY_STORE.put("size");
  }
  
  public static Comment build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    int i = 0;
    long l4 = 0L;
    long l3 = 0L;
    String str1 = null;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool13 = false;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("trackableCommentObject", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = TrackingObjectBuilder.INSTANCE;
        localObject4 = TrackingObjectBuilder.build(paramDataReader);
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackableUpdateObject", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = TrackingObjectBuilder.INSTANCE;
        localObject3 = TrackingObjectBuilder.build(paramDataReader);
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("threadUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("commenterUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("message", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("level", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("visibleTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l4 = paramDataReader.readLong();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("duration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l3 = paramDataReader.readLong();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("associatedInputControlUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalReplies", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalLikes", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
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
    if (!bool13) {
      throw new DataReaderException("Failed to find required field: trackableCommentObject when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool12) {
      throw new DataReaderException("Failed to find required field: trackableUpdateObject when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: threadUrn when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: commenterUrn when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: message when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: level when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: visibleTime when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: duration when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: totalReplies when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: totalLikes when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: listPosition when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: size when building com.linkedin.gen.avro2pegasus.events.feed.Comment");
    }
    return new Comment((TrackingObject)localObject4, (TrackingObject)localObject3, str4, str3, str2, i, l4, l3, str1, l2, l1, (ListPosition)localObject2, (EntityDimension)localObject1, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.CommentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */