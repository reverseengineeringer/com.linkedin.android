package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class BlockConfirmationScreenTextBuilder
  implements DataTemplateBuilder<BlockConfirmationScreenText>
{
  public static final BlockConfirmationScreenTextBuilder INSTANCE = new BlockConfirmationScreenTextBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("heading");
    JSON_KEY_STORE.put("firstLine");
    JSON_KEY_STORE.put("secondLine");
    JSON_KEY_STORE.put("blockNormal");
    JSON_KEY_STORE.put("blockAllCaps");
    JSON_KEY_STORE.put("gobackNormal");
    JSON_KEY_STORE.put("gobackAllCaps");
  }
  
  public static BlockConfirmationScreenText build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("heading", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str7 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("firstLine", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("secondLine", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("blockNormal", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("blockAllCaps", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("gobackNormal", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("gobackAllCaps", JSON_KEY_STORE))
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
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: heading when building com.linkedin.semaphore.models.android.BlockConfirmationScreenText");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: firstLine when building com.linkedin.semaphore.models.android.BlockConfirmationScreenText");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: secondLine when building com.linkedin.semaphore.models.android.BlockConfirmationScreenText");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: blockNormal when building com.linkedin.semaphore.models.android.BlockConfirmationScreenText");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: blockAllCaps when building com.linkedin.semaphore.models.android.BlockConfirmationScreenText");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: gobackNormal when building com.linkedin.semaphore.models.android.BlockConfirmationScreenText");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: gobackAllCaps when building com.linkedin.semaphore.models.android.BlockConfirmationScreenText");
    }
    return new BlockConfirmationScreenText(str7, str6, str5, str4, str3, str2, str1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.BlockConfirmationScreenTextBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */