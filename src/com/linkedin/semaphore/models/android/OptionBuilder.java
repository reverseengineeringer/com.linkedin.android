package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class OptionBuilder
  implements DataTemplateBuilder<Option>
{
  public static final OptionBuilder INSTANCE = new OptionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("type");
    JSON_KEY_STORE.put("action");
    JSON_KEY_STORE.put("section");
    JSON_KEY_STORE.put("openLink");
  }
  
  public static Option build(DataReader paramDataReader)
    throws DataReaderException
  {
    OptionType localOptionType = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localOptionType = (OptionType)paramDataReader.readEnum(OptionType.Builder.INSTANCE);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("action", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ActionBuilder.INSTANCE;
        localObject3 = ActionBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("section", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SectionBuilder.INSTANCE;
        localObject2 = SectionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("openLink", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = OpenLinkBuilder.INSTANCE;
        localObject1 = OpenLinkBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.semaphore.models.android.Option");
    }
    return new Option(localOptionType, (Action)localObject3, (Section)localObject2, (OpenLink)localObject1, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.OptionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */