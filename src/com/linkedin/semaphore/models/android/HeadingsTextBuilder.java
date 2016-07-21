package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class HeadingsTextBuilder
  implements DataTemplateBuilder<HeadingsText>
{
  public static final HeadingsTextBuilder INSTANCE = new HeadingsTextBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("whyReportingThis");
    JSON_KEY_STORE.put("helpUnderstandThis");
    JSON_KEY_STORE.put("whatDoYouWantToDo");
  }
  
  public static HeadingsText build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("whyReportingThis", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("helpUnderstandThis", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("whatDoYouWantToDo", JSON_KEY_STORE))
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: whyReportingThis when building com.linkedin.semaphore.models.android.HeadingsText");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: helpUnderstandThis when building com.linkedin.semaphore.models.android.HeadingsText");
    }
    return new HeadingsText(str3, str2, str1, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.HeadingsTextBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */