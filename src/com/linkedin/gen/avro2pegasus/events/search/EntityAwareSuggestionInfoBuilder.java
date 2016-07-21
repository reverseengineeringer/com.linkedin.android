package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.util.ArrayList;
import java.util.List;

public final class EntityAwareSuggestionInfoBuilder
  implements DataTemplateBuilder<EntityAwareSuggestionInfo>
{
  public static final EntityAwareSuggestionInfoBuilder INSTANCE = new EntityAwareSuggestionInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("suggestedEntities");
  }
  
  public static EntityAwareSuggestionInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("suggestedEntities", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            SuggestedEntityType localSuggestedEntityType = (SuggestedEntityType)paramDataReader.readEnum(SuggestedEntityType.Builder.INSTANCE);
            if (localSuggestedEntityType != null) {
              localArrayList.add(localSuggestedEntityType);
            }
          }
        }
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: suggestedEntities when building com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo");
    }
    return new EntityAwareSuggestionInfo(localArrayList, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */