package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.util.ArrayList;
import java.util.List;

public final class SearchResultComponentBuilder
  implements DataTemplateBuilder<SearchResultComponent>
{
  public static final SearchResultComponentBuilder INSTANCE = new SearchResultComponentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("resultComponentType");
    JSON_KEY_STORE.put("position");
    JSON_KEY_STORE.put("layoutType");
    JSON_KEY_STORE.put("resultVerticalType");
    JSON_KEY_STORE.put("results");
  }
  
  public static SearchResultComponent build(DataReader paramDataReader)
    throws DataReaderException
  {
    SearchResultComponentType localSearchResultComponentType = null;
    int i = 0;
    SearchResultComponentLayoutType localSearchResultComponentLayoutType = null;
    SearchVertical localSearchVertical = null;
    ArrayList localArrayList = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("resultComponentType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchResultComponentType = (SearchResultComponentType)paramDataReader.readEnum(SearchResultComponentType.Builder.INSTANCE);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("position", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("layoutType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchResultComponentLayoutType = (SearchResultComponentLayoutType)paramDataReader.readEnum(SearchResultComponentLayoutType.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("resultVerticalType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchVertical = (SearchVertical)paramDataReader.readEnum(SearchVertical.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("results", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            SearchResultHitBuilder localSearchResultHitBuilder = SearchResultHitBuilder.INSTANCE;
            localArrayList.add(SearchResultHitBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: resultComponentType when building com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: position when building com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: layoutType when building com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: resultVerticalType when building com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: results when building com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent");
    }
    return new SearchResultComponent(localSearchResultComponentType, i, localSearchResultComponentLayoutType, localSearchVertical, localArrayList, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultComponentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */