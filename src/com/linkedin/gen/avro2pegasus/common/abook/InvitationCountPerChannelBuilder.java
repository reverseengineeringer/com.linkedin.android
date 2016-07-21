package com.linkedin.gen.avro2pegasus.common.abook;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class InvitationCountPerChannelBuilder
  implements DataTemplateBuilder<InvitationCountPerChannel>
{
  public static final InvitationCountPerChannelBuilder INSTANCE = new InvitationCountPerChannelBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("emailCount");
    JSON_KEY_STORE.put("smsCount");
  }
  
  public static InvitationCountPerChannel build(DataReader paramDataReader)
    throws DataReaderException
  {
    int j = 0;
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("emailCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("smsCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: emailCount when building com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: smsCount when building com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel");
    }
    return new InvitationCountPerChannel(j, i, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannelBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */