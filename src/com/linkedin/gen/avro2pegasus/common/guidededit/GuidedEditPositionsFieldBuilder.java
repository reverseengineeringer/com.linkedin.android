package com.linkedin.gen.avro2pegasus.common.guidededit;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.util.ArrayList;
import java.util.List;

public final class GuidedEditPositionsFieldBuilder
  implements DataTemplateBuilder<GuidedEditPositionsField>
{
  public static final GuidedEditPositionsFieldBuilder INSTANCE = new GuidedEditPositionsFieldBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("positions");
  }
  
  public static GuidedEditPositionsField build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("positions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            String str = paramDataReader.readString();
            if (str != null) {
              localArrayList.add(str);
            }
          }
        }
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: positions when building com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField");
    }
    return new GuidedEditPositionsField(localArrayList, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsFieldBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */