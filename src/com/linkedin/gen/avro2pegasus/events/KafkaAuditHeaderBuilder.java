package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class KafkaAuditHeaderBuilder
  implements DataTemplateBuilder<KafkaAuditHeader>
{
  public static final KafkaAuditHeaderBuilder INSTANCE = new KafkaAuditHeaderBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("time");
    JSON_KEY_STORE.put("server");
    JSON_KEY_STORE.put("instance");
    JSON_KEY_STORE.put("appName");
    JSON_KEY_STORE.put("messageId");
  }
  
  public static KafkaAuditHeader build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("time", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("server", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("instance", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("messageId", JSON_KEY_STORE))
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
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: time when building com.linkedin.gen.avro2pegasus.events.KafkaAuditHeader");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: server when building com.linkedin.gen.avro2pegasus.events.KafkaAuditHeader");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: appName when building com.linkedin.gen.avro2pegasus.events.KafkaAuditHeader");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: messageId when building com.linkedin.gen.avro2pegasus.events.KafkaAuditHeader");
    }
    return new KafkaAuditHeader(l, str3, str2, str1, (String)localObject, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.KafkaAuditHeaderBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */