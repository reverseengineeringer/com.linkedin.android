package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SubchannelsBuilder
  implements DataTemplateBuilder<Subchannels>
{
  public static final SubchannelsBuilder INSTANCE = new SubchannelsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("badge");
    JSON_KEY_STORE.put("sound");
    JSON_KEY_STORE.put("notificationCenter");
  }
  
  public static Subchannels build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    int i = 0;
    String str1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("badge", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sound", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("notificationCenter", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool5 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new Subchannels(str2, i, str1, bool5, bool4, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.SubchannelsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */