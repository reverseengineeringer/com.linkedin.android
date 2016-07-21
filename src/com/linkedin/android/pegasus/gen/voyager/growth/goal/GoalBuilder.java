package com.linkedin.android.pegasus.gen.voyager.growth.goal;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class GoalBuilder
  implements FissileDataModelBuilder<Goal>, DataTemplateBuilder<Goal>
{
  public static final GoalBuilder INSTANCE = new GoalBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("goalType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.goal.GoalBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */