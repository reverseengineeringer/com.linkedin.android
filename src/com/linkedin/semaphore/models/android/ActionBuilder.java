package com.linkedin.semaphore.models.android;

import android.support.v4.util.ArrayMap;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ActionBuilder
  implements DataTemplateBuilder<Action>
{
  public static final ActionBuilder INSTANCE = new ActionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("body");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("actionUrl");
    JSON_KEY_STORE.put("actionPostData");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("additionalActions");
    JSON_KEY_STORE.put("additionalOptions");
  }
  
  public static Action build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    ArrayMap localArrayMap = null;
    ActionType localActionType = null;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actionUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool5 = true;
      }
      else
      {
        Object localObject;
        if (paramDataReader.shouldReadField$11ca93e7("actionPostData", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayMap = new ArrayMap();
          if (paramDataReader.isStartOfMap()) {
            while (paramDataReader.hasMoreMapElements$255f299())
            {
              localObject = paramDataReader.readMapKey();
              String str5 = paramDataReader.readString();
              if (str5 != null) {
                localArrayMap.put(localObject, str5);
              }
            }
          }
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localActionType = (ActionType)paramDataReader.readEnum(ActionType.Builder.INSTANCE);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("additionalActions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299()) {
              localArrayList1.add(build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("additionalOptions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject = AdditionalOptionsBuilder.INSTANCE;
              localArrayList2.add(AdditionalOptionsBuilder.build(paramDataReader));
            }
          }
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.semaphore.models.android.Action");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.semaphore.models.android.Action");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: actionUrl when building com.linkedin.semaphore.models.android.Action");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.semaphore.models.android.Action");
    }
    return new Action(str4, str3, str2, str1, localArrayMap, localActionType, localArrayList1, localArrayList2, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static final class AdditionalOptionsBuilder
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
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.ActionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */