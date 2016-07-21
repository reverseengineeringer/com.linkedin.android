package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class CalendarSourceRequestBuilder
  implements FissileDataModelBuilder<CalendarSourceRequest>, DataTemplateBuilder<CalendarSourceRequest>
{
  public static final CalendarSourceRequestBuilder INSTANCE = new CalendarSourceRequestBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("calendarSource");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSourceRequestBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */