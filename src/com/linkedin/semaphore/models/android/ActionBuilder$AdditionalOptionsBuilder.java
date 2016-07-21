package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ActionBuilder$AdditionalOptionsBuilder
  implements DataTemplateBuilder<Action.AdditionalOptions>
{
  public static final AdditionalOptionsBuilder INSTANCE = new AdditionalOptionsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.semaphore.models.Action");
    JSON_KEY_STORE.put("com.linkedin.semaphore.models.OpenLink");
  }
  
  public static Action.AdditionalOptions build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.semaphore.models.Action", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ActionBuilder.INSTANCE;
        localObject2 = ActionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.semaphore.models.OpenLink", JSON_KEY_STORE))
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
    int i = 0;
    if (bool2) {
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building .AdditionalOptions");
    }
    return new Action.AdditionalOptions((Action)localObject2, (OpenLink)localObject1, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.ActionBuilder.AdditionalOptionsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */