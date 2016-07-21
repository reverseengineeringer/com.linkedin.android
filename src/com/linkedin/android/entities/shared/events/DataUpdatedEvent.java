package com.linkedin.android.entities.shared.events;

public final class DataUpdatedEvent
{
  public final String modelKey;
  public final String subscriberId;
  
  public DataUpdatedEvent(String paramString1, String paramString2)
  {
    subscriberId = paramString1;
    modelKey = paramString2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.events.DataUpdatedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */