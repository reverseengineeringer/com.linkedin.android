package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchHeaderBuilder
  implements DataTemplateBuilder<SearchHeader>
{
  public static final SearchHeaderBuilder INSTANCE = new SearchHeaderBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("rawSearchId");
    JSON_KEY_STORE.put("query");
    JSON_KEY_STORE.put("origin");
    JSON_KEY_STORE.put("platform");
    JSON_KEY_STORE.put("vertical");
  }
  
  public static SearchHeader build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    SearchResultPageOrigin localSearchResultPageOrigin = null;
    SearchPlatformType localSearchPlatformType = null;
    SearchVertical localSearchVertical = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("rawSearchId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("query", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("origin", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchResultPageOrigin = (SearchResultPageOrigin)paramDataReader.readEnum(SearchResultPageOrigin.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("platform", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchPlatformType = (SearchPlatformType)paramDataReader.readEnum(SearchPlatformType.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("vertical", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchVertical = (SearchVertical)paramDataReader.readEnum(SearchVertical.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: rawSearchId when building com.linkedin.gen.avro2pegasus.events.search.SearchHeader");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: platform when building com.linkedin.gen.avro2pegasus.events.search.SearchHeader");
    }
    return new SearchHeader(str2, str1, localSearchResultPageOrigin, localSearchPlatformType, localSearchVertical, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchHeaderBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */