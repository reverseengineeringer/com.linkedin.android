package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPositionBuilder;

public final class MentionResultHitBuilder
  implements DataTemplateBuilder<MentionResultHit>
{
  public static final MentionResultHitBuilder INSTANCE = new MentionResultHitBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("position");
    JSON_KEY_STORE.put("isCacheHit");
  }
  
  public static MentionResultHit build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject = null;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("position", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ListPositionBuilder.INSTANCE;
        localObject = ListPositionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isCacheHit", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      bool1 = false;
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: position when building com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit");
    }
    return new MentionResultHit(str, (ListPosition)localObject, bool1, bool4, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHitBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */