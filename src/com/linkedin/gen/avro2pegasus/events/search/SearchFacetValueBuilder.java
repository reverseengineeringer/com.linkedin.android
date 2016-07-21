package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchFacetValueBuilder
  implements DataTemplateBuilder<SearchFacetValue>
{
  public static final SearchFacetValueBuilder INSTANCE = new SearchFacetValueBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("facetValue");
    JSON_KEY_STORE.put("facetValuePosition");
    JSON_KEY_STORE.put("isSelected");
  }
  
  public static SearchFacetValue build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    int i = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("facetValue", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("facetValuePosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isSelected", JSON_KEY_STORE))
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
      throw new DataReaderException("Failed to find required field: facetValue when building com.linkedin.gen.avro2pegasus.events.search.SearchFacetValue");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: facetValuePosition when building com.linkedin.gen.avro2pegasus.events.search.SearchFacetValue");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: isSelected when building com.linkedin.gen.avro2pegasus.events.search.SearchFacetValue");
    }
    return new SearchFacetValue(str, i, bool4, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchFacetValueBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */