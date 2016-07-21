package com.linkedin.android.l2m.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import javax.inject.Inject;

public final class NotificationDisplayUtils
{
  private final NotificationManager notificationManager;
  
  @Inject
  public NotificationDisplayUtils(Context paramContext)
  {
    notificationManager = ((NotificationManager)paramContext.getSystemService("notification"));
  }
  
  public final void cancel(int paramInt)
  {
    notificationManager.cancel(paramInt);
  }
  
  public final void display(int paramInt, Notification paramNotification)
  {
    notificationManager.notify(paramInt, paramNotification);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationDisplayUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */