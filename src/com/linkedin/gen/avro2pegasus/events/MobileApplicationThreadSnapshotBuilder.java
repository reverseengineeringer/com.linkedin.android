package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.util.ArrayList;
import java.util.List;

public final class MobileApplicationThreadSnapshotBuilder
  implements DataTemplateBuilder<MobileApplicationThreadSnapshot>
{
  public static final MobileApplicationThreadSnapshotBuilder INSTANCE = new MobileApplicationThreadSnapshotBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("stackTrace");
    JSON_KEY_STORE.put("threadName");
    JSON_KEY_STORE.put("isCauseOfError");
  }
  
  public static MobileApplicationThreadSnapshot build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    String str = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("stackTrace", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MobileApplicationStackFrameBuilder localMobileApplicationStackFrameBuilder = MobileApplicationStackFrameBuilder.INSTANCE;
            localArrayList.add(MobileApplicationStackFrameBuilder.build(paramDataReader));
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("threadName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isCauseOfError", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool4 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: stackTrace when building com.linkedin.gen.avro2pegasus.events.MobileApplicationThreadSnapshot");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: isCauseOfError when building com.linkedin.gen.avro2pegasus.events.MobileApplicationThreadSnapshot");
    }
    return new MobileApplicationThreadSnapshot(localArrayList, str, bool4, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationThreadSnapshotBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */