package com.linkedin.android.infra.events;

public final class HiddenPushReceivedEvent
  extends PushNotificationReceivedEvent
{
  public final String notificationType;
  
  public HiddenPushReceivedEvent(String paramString, int paramInt)
  {
    super(paramInt);
    notificationType = paramString;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.HiddenPushReceivedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */