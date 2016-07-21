package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ResultScreenTextBuilder
  implements DataTemplateBuilder<ResultScreenText>
{
  public static final ResultScreenTextBuilder INSTANCE = new ResultScreenTextBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("body");
    JSON_KEY_STORE.put("doneAllCaps");
    JSON_KEY_STORE.put("doneNormal");
  }
  
  public static ResultScreenText build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
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
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("doneAllCaps", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("doneNormal", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.semaphore.models.android.ResultScreenText");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: body when building com.linkedin.semaphore.models.android.ResultScreenText");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: doneAllCaps when building com.linkedin.semaphore.models.android.ResultScreenText");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: doneNormal when building com.linkedin.semaphore.models.android.ResultScreenText");
    }
    return new ResultScreenText(str4, str3, str2, str1, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.ResultScreenTextBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */