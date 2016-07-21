package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchResultHitInfoBuilder
  implements DataTemplateBuilder<SearchResultHitInfo>
{
  public static final SearchResultHitInfoBuilder INSTANCE = new SearchResultHitInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("secondarySearchResultInfo");
    JSON_KEY_STORE.put("entityAwareSuggestionInfo");
  }
  
  public static SearchResultHitInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("secondarySearchResultInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SecondarySearchResultInfoBuilder.INSTANCE;
        localObject1 = SecondarySearchResultInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityAwareSuggestionInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = EntityAwareSuggestionInfoBuilder.INSTANCE;
        localObject2 = EntityAwareSuggestionInfoBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new SearchResultHitInfo((SecondarySearchResultInfo)localObject1, (EntityAwareSuggestionInfo)localObject2, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultHitInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */