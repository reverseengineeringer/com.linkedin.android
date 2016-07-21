package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class GroupBuilder
  implements FissileDataModelBuilder<Group>, DataTemplateBuilder<Group>
{
  public static final GroupBuilder INSTANCE = new GroupBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("basicGroupInfo");
    JSON_KEY_STORE.put("groupType");
    JSON_KEY_STORE.put("membershipInfo");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("heroImage");
    JSON_KEY_STORE.put("backgroundColor");
    JSON_KEY_STORE.put("rules");
    JSON_KEY_STORE.put("owner");
    JSON_KEY_STORE.put("sections");
    JSON_KEY_STORE.put("entityInfo");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.GroupBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */