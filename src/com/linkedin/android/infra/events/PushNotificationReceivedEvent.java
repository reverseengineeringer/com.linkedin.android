package com.linkedin.android.infra.events;

public class PushNotificationReceivedEvent
{
  public final int badgeCount;
  
  public PushNotificationReceivedEvent(int paramInt)
  {
    badgeCount = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.PushNotificationReceivedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */