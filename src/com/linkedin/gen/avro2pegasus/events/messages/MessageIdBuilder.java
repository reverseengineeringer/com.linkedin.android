package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.util.ArrayList;
import java.util.List;

public final class MessageIdBuilder
  implements DataTemplateBuilder<MessageId>
{
  public static final MessageIdBuilder INSTANCE = new MessageIdBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("flockMessageUrn");
    JSON_KEY_STORE.put("deliveryId");
    JSON_KEY_STORE.put("externalIds");
  }
  
  public static MessageId build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("flockMessageUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("deliveryId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("externalIds", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            String str3 = paramDataReader.readString();
            if (str3 != null) {
              localArrayList.add(str3);
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: flockMessageUrn when building com.linkedin.gen.avro2pegasus.events.messages.MessageId");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: externalIds when building com.linkedin.gen.avro2pegasus.events.messages.MessageId");
    }
    return new MessageId(str2, str1, localArrayList, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageIdBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */