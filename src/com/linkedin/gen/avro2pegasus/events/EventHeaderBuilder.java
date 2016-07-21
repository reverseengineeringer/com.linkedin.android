package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;
import com.linkedin.gen.avro2pegasus.events.common.PageInstanceBuilder;

public final class EventHeaderBuilder
  implements DataTemplateBuilder<EventHeader>
{
  public static final EventHeaderBuilder INSTANCE = new EventHeaderBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("memberId");
    JSON_KEY_STORE.put("viewerUrn");
    JSON_KEY_STORE.put("applicationViewerUrn");
    JSON_KEY_STORE.put("csUserUrn");
    JSON_KEY_STORE.put("time");
    JSON_KEY_STORE.put("server");
    JSON_KEY_STORE.put("service");
    JSON_KEY_STORE.put("environment");
    JSON_KEY_STORE.put("guid");
    JSON_KEY_STORE.put("treeId");
    JSON_KEY_STORE.put("requestId");
    JSON_KEY_STORE.put("impersonatorId");
    JSON_KEY_STORE.put("version");
    JSON_KEY_STORE.put("instance");
    JSON_KEY_STORE.put("appName");
    JSON_KEY_STORE.put("testId");
    JSON_KEY_STORE.put("testSegmentId");
    JSON_KEY_STORE.put("auditHeader");
    JSON_KEY_STORE.put("pageInstance");
  }
  
  public static EventHeader build(DataReader paramDataReader)
    throws DataReaderException
  {
    int j = 0;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    long l = 0L;
    String str9 = null;
    String str8 = null;
    String str1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    int i = 0;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool19 = false;
    boolean bool18 = false;
    boolean bool17 = false;
    boolean bool16 = false;
    boolean bool15 = false;
    boolean bool14 = false;
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
      if (paramDataReader.shouldReadField$11ca93e7("memberId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool19 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("viewerUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str12 = paramDataReader.readString();
        bool18 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("applicationViewerUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str11 = paramDataReader.readString();
        bool17 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("csUserUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str10 = paramDataReader.readString();
        bool16 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("time", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool15 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("server", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str9 = paramDataReader.readString();
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("service", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str8 = paramDataReader.readString();
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("environment", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("guid", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = BytesCoercer.INSTANCE;
        localObject4 = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("treeId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = BytesCoercer.INSTANCE;
        localObject3 = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("requestId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("impersonatorId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str7 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("version", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("instance", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("testId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("testSegmentId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("auditHeader", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = KafkaAuditHeaderBuilder.INSTANCE;
        localObject2 = KafkaAuditHeaderBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pageInstance", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = PageInstanceBuilder.INSTANCE;
        localObject1 = PageInstanceBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool12) {
      str1 = "";
    }
    if (!bool19) {
      throw new DataReaderException("Failed to find required field: memberId when building com.linkedin.gen.avro2pegasus.events.EventHeader");
    }
    if (!bool15) {
      throw new DataReaderException("Failed to find required field: time when building com.linkedin.gen.avro2pegasus.events.EventHeader");
    }
    if (!bool14) {
      throw new DataReaderException("Failed to find required field: server when building com.linkedin.gen.avro2pegasus.events.EventHeader");
    }
    if (!bool13) {
      throw new DataReaderException("Failed to find required field: service when building com.linkedin.gen.avro2pegasus.events.EventHeader");
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: guid when building com.linkedin.gen.avro2pegasus.events.EventHeader");
    }
    return new EventHeader(j, str12, str11, str10, l, str9, str8, str1, (String)localObject4, (String)localObject3, i, str7, str6, str5, str4, str3, str2, (KafkaAuditHeader)localObject2, (PageInstance)localObject1, bool19, bool18, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.EventHeaderBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */