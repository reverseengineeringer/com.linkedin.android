package com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MeetingDetailBuilder
  implements FissileDataModelBuilder<MeetingDetail>, DataTemplateBuilder<MeetingDetail>
{
  public static final MeetingDetailBuilder INSTANCE = new MeetingDetailBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("attendees");
    JSON_KEY_STORE.put("primaryActions");
    JSON_KEY_STORE.put("followupActions");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetailBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */