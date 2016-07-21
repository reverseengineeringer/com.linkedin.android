package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PageInstanceBuilder
  implements DataTemplateBuilder<PageInstance>
{
  public static final PageInstanceBuilder INSTANCE = new PageInstanceBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("pageUrn");
    JSON_KEY_STORE.put("trackingId");
  }
  
  public static PageInstance build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("pageUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: pageUrn when building com.linkedin.gen.avro2pegasus.events.common.PageInstance");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.gen.avro2pegasus.events.common.PageInstance");
    }
    return new PageInstance(str, (String)localObject, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.PageInstanceBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */