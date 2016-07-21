package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MenuBuilder
  implements DataTemplateBuilder<Menu>
{
  public static final MenuBuilder INSTANCE = new MenuBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numberOfSteps");
    JSON_KEY_STORE.put("options");
    JSON_KEY_STORE.put("resultScreen");
    JSON_KEY_STORE.put("headings");
    JSON_KEY_STORE.put("blockConfirmationScreen");
    JSON_KEY_STORE.put("dialogTrackingCodes");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.MenuBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */