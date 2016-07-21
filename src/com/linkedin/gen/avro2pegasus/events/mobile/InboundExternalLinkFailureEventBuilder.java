package com.linkedin.gen.avro2pegasus.events.mobile;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class InboundExternalLinkFailureEventBuilder
  implements DataTemplateBuilder<InboundExternalLinkFailureEvent>
{
  public static final InboundExternalLinkFailureEventBuilder INSTANCE = new InboundExternalLinkFailureEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("intendedDestinationUrl");
    JSON_KEY_STORE.put("failureType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */