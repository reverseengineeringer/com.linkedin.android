package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.GridPositionBuilder;

public final class SearchResultHitBuilder
  implements DataTemplateBuilder<SearchResultHit>
{
  public static final SearchResultHitBuilder INSTANCE = new SearchResultHitBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("resultType");
    JSON_KEY_STORE.put("absolutePosition");
    JSON_KEY_STORE.put("positionInVertical");
    JSON_KEY_STORE.put("isCacheHit");
    JSON_KEY_STORE.put("isAnonymized");
    JSON_KEY_STORE.put("hitInfo");
    JSON_KEY_STORE.put("gridPosition");
  }
  
  public static SearchResultHit build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    SearchResultType localSearchResultType = null;
    int j = 0;
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("resultType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchResultType = (SearchResultType)paramDataReader.readEnum(SearchResultType.Builder.INSTANCE);
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("absolutePosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("positionInVertical", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isCacheHit", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool2 = paramDataReader.readBoolean();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isAnonymized", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("hitInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SearchResultHitInfoBuilder.INSTANCE;
        localObject2 = SearchResultHitInfoBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("gridPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = GridPositionBuilder.INSTANCE;
        localObject1 = GridPositionBuilder.build(paramDataReader);
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      bool2 = false;
    }
    if (!bool5) {
      bool1 = false;
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: resultType when building com.linkedin.gen.avro2pegasus.events.search.SearchResultHit");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: absolutePosition when building com.linkedin.gen.avro2pegasus.events.search.SearchResultHit");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: positionInVertical when building com.linkedin.gen.avro2pegasus.events.search.SearchResultHit");
    }
    return new SearchResultHit(str, localSearchResultType, j, i, bool2, bool1, (SearchResultHitInfo)localObject2, (GridPosition)localObject1, bool10, bool9, bool8, bool6, bool7, bool5, bool4, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultHitBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */