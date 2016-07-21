package com.linkedin.android.pegasus.gen.voyager.growth.confirmation;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class EmailConfirmationTaskBuilder
  implements FissileDataModelBuilder<EmailConfirmationTask>, DataTemplateBuilder<EmailConfirmationTask>
{
  public static final EmailConfirmationTaskBuilder INSTANCE = new EmailConfirmationTaskBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("email");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.confirmation.EmailConfirmationTaskBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */