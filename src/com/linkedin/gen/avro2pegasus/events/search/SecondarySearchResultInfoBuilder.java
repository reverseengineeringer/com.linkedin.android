package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SecondarySearchResultInfoBuilder
  implements DataTemplateBuilder<SecondarySearchResultInfo>
{
  public static final SecondarySearchResultInfoBuilder INSTANCE = new SecondarySearchResultInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("vertical");
  }
  
  public static SecondarySearchResultInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    SearchVertical localSearchVertical = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("vertical", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchVertical = (SearchVertical)paramDataReader.readEnum(SearchVertical.Builder.INSTANCE);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: vertical when building com.linkedin.gen.avro2pegasus.events.search.SecondarySearchResultInfo");
    }
    return new SecondarySearchResultInfo(localSearchVertical, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SecondarySearchResultInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */