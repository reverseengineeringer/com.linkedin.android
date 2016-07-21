package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ContributorBuilder
  implements DataTemplateBuilder<Contributor>
{
  public static final ContributorBuilder INSTANCE = new ContributorBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("name");
    JSON_KEY_STORE.put("memberUrn");
  }
  
  public static Contributor build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("memberUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.gen.avro2pegasus.events.identity.Contributor");
    }
    return new Contributor(str1, str2, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.ContributorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */