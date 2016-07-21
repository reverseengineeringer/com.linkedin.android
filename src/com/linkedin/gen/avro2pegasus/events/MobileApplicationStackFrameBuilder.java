package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MobileApplicationStackFrameBuilder
  implements DataTemplateBuilder<MobileApplicationStackFrame>
{
  public static final MobileApplicationStackFrameBuilder INSTANCE = new MobileApplicationStackFrameBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("parent");
    JSON_KEY_STORE.put("function");
    JSON_KEY_STORE.put("lineNumber");
    JSON_KEY_STORE.put("fileName");
  }
  
  public static MobileApplicationStackFrame build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    int i = 0;
    String str1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("parent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("function", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("lineNumber", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fileName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: parent when building com.linkedin.gen.avro2pegasus.events.MobileApplicationStackFrame");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: function when building com.linkedin.gen.avro2pegasus.events.MobileApplicationStackFrame");
    }
    return new MobileApplicationStackFrame(str3, str2, i, str1, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationStackFrameBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */