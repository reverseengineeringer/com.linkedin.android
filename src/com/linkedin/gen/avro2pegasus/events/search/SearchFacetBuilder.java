package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.util.ArrayList;
import java.util.List;

public final class SearchFacetBuilder
  implements DataTemplateBuilder<SearchFacet>
{
  public static final SearchFacetBuilder INSTANCE = new SearchFacetBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("facetType");
    JSON_KEY_STORE.put("facetVertical");
    JSON_KEY_STORE.put("facetValues");
    JSON_KEY_STORE.put("facetPosition");
  }
  
  public static SearchFacet build(DataReader paramDataReader)
    throws DataReaderException
  {
    SearchFacetType localSearchFacetType = null;
    SearchVertical localSearchVertical = null;
    ArrayList localArrayList = null;
    int i = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("facetType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchFacetType = (SearchFacetType)paramDataReader.readEnum(SearchFacetType.Builder.INSTANCE);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetVertical", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchVertical = (SearchVertical)paramDataReader.readEnum(SearchVertical.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetValues", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            SearchFacetValueBuilder localSearchFacetValueBuilder = SearchFacetValueBuilder.INSTANCE;
            localArrayList.add(SearchFacetValueBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetPosition", JSON_KEY_STORE))
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
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: facetType when building com.linkedin.gen.avro2pegasus.events.search.SearchFacet");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: facetVertical when building com.linkedin.gen.avro2pegasus.events.search.SearchFacet");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: facetValues when building com.linkedin.gen.avro2pegasus.events.search.SearchFacet");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: facetPosition when building com.linkedin.gen.avro2pegasus.events.search.SearchFacet");
    }
    return new SearchFacet(localSearchFacetType, localSearchVertical, localArrayList, i, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchFacetBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */