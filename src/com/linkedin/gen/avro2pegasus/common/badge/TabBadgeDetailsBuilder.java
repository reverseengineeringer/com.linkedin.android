package com.linkedin.gen.avro2pegasus.common.badge;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class TabBadgeDetailsBuilder
  implements DataTemplateBuilder<TabBadgeDetails>
{
  public static final TabBadgeDetailsBuilder INSTANCE = new TabBadgeDetailsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("feedTabBadgeCount");
    JSON_KEY_STORE.put("myNetworkTabBadgeCount");
    JSON_KEY_STORE.put("messagingTabBadgeCount");
    JSON_KEY_STORE.put("notificationTabBadgeCount");
    JSON_KEY_STORE.put("meTabBadgeCount");
    JSON_KEY_STORE.put("jobsTabBadgeCount");
  }
  
  public static TabBadgeDetails build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i1 = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("feedTabBadgeCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i1 = paramDataReader.readInt();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("myNetworkTabBadgeCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        n = paramDataReader.readInt();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("messagingTabBadgeCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        m = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("notificationTabBadgeCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("meTabBadgeCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("jobsTabBadgeCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: feedTabBadgeCount when building com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: myNetworkTabBadgeCount when building com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: messagingTabBadgeCount when building com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: notificationTabBadgeCount when building com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: meTabBadgeCount when building com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails");
    }
    return new TabBadgeDetails(i1, n, m, k, j, i, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetailsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */