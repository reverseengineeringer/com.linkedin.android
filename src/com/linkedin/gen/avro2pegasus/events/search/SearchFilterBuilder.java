package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchFilterBuilder
  implements DataTemplateBuilder<SearchFilter>
{
  public static final SearchFilterBuilder INSTANCE = new SearchFilterBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("filterType");
    JSON_KEY_STORE.put("filterName");
    JSON_KEY_STORE.put("filterValue");
    JSON_KEY_STORE.put("filterPosition");
    JSON_KEY_STORE.put("isSelected");
  }
  
  public static SearchFilter build(DataReader paramDataReader)
    throws DataReaderException
  {
    SearchFilterType localSearchFilterType = null;
    String str2 = null;
    String str1 = null;
    int i = 0;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("filterType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchFilterType = (SearchFilterType)paramDataReader.readEnum(SearchFilterType.Builder.INSTANCE);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("filterName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("filterValue", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("filterPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isSelected", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool6 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: filterType when building com.linkedin.gen.avro2pegasus.events.search.SearchFilter");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: filterName when building com.linkedin.gen.avro2pegasus.events.search.SearchFilter");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: filterValue when building com.linkedin.gen.avro2pegasus.events.search.SearchFilter");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: filterPosition when building com.linkedin.gen.avro2pegasus.events.search.SearchFilter");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: isSelected when building com.linkedin.gen.avro2pegasus.events.search.SearchFilter");
    }
    return new SearchFilter(localSearchFilterType, str2, str1, i, bool6, bool5, bool4, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchFilterBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */