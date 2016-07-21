package com.linkedin.gen.avro2pegasus.events.mobile;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MobileApplicationLixTreatmentBuilder
  implements DataTemplateBuilder<MobileApplicationLixTreatment>
{
  public static final MobileApplicationLixTreatmentBuilder INSTANCE = new MobileApplicationLixTreatmentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("testKey");
    JSON_KEY_STORE.put("treatment");
  }
  
  public static MobileApplicationLixTreatment build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("testKey", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("treatment", JSON_KEY_STORE))
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: testKey when building com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationLixTreatment");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: treatment when building com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationLixTreatment");
    }
    return new MobileApplicationLixTreatment(str2, str1, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationLixTreatmentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */