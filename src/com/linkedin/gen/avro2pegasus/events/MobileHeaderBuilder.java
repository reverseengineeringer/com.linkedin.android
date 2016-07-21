package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MobileHeaderBuilder
  implements DataTemplateBuilder<MobileHeader>
{
  public static final MobileHeaderBuilder INSTANCE = new MobileHeaderBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("osName");
    JSON_KEY_STORE.put("osVersion");
    JSON_KEY_STORE.put("deviceModel");
    JSON_KEY_STORE.put("appVersion");
    JSON_KEY_STORE.put("advertiserId");
    JSON_KEY_STORE.put("vendorId");
    JSON_KEY_STORE.put("isAdTrackingLimited");
  }
  
  public static MobileHeader build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("osName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("osVersion", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("deviceModel", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appVersion", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("advertiserId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("vendorId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isAdTrackingLimited", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool8 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new MobileHeader(str6, str5, str4, str3, str2, str1, bool8, bool7, bool6, bool5, bool4, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileHeaderBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */