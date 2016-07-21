package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class DialogTrackingCodesBuilder
  implements DataTemplateBuilder<DialogTrackingCodes>
{
  public static final DialogTrackingCodesBuilder INSTANCE = new DialogTrackingCodesBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("dialogCancel");
    JSON_KEY_STORE.put("dialogOpen");
    JSON_KEY_STORE.put("dialogClose");
    JSON_KEY_STORE.put("dialogBackButton");
    JSON_KEY_STORE.put("blockProfileDialogOpen");
    JSON_KEY_STORE.put("blockProfileDialogCancel");
  }
  
  public static DialogTrackingCodes build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("dialogCancel", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("dialogOpen", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("dialogClose", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("dialogBackButton", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("blockProfileDialogOpen", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("blockProfileDialogCancel", JSON_KEY_STORE))
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
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: dialogCancel when building com.linkedin.semaphore.models.android.DialogTrackingCodes");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: dialogOpen when building com.linkedin.semaphore.models.android.DialogTrackingCodes");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: dialogClose when building com.linkedin.semaphore.models.android.DialogTrackingCodes");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: dialogBackButton when building com.linkedin.semaphore.models.android.DialogTrackingCodes");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: blockProfileDialogOpen when building com.linkedin.semaphore.models.android.DialogTrackingCodes");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: blockProfileDialogCancel when building com.linkedin.semaphore.models.android.DialogTrackingCodes");
    }
    return new DialogTrackingCodes(str6, str5, str4, str3, str2, str1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.DialogTrackingCodesBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */