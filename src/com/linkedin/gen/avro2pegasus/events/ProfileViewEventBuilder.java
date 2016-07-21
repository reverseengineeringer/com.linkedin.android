package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ProfileViewEventBuilder
  implements DataTemplateBuilder<ProfileViewEvent>
{
  public static final ProfileViewEventBuilder INSTANCE = new ProfileViewEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("entityView");
    JSON_KEY_STORE.put("viewerPrivacySetting");
    JSON_KEY_STORE.put("vieweePrivacySetting");
    JSON_KEY_STORE.put("source");
    JSON_KEY_STORE.put("contractId");
    JSON_KEY_STORE.put("networkDistance");
    JSON_KEY_STORE.put("authType");
    JSON_KEY_STORE.put("authToken");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("vieweeMemberUrn");
    JSON_KEY_STORE.put("profileTrackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.ProfileViewEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */