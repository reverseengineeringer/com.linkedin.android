package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

final class NotificationCompat$NotificationCompatImplGingerbread
  extends NotificationCompat.NotificationCompatImplBase
{
  public final Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
  {
    Notification localNotification = mNotification;
    Context localContext = mContext;
    CharSequence localCharSequence1 = mContentTitle;
    CharSequence localCharSequence2 = mContentText;
    PendingIntent localPendingIntent1 = mContentIntent;
    PendingIntent localPendingIntent2 = mFullScreenIntent;
    localNotification.setLatestEventInfo(localContext, localCharSequence1, localCharSequence2, localPendingIntent1);
    fullScreenIntent = localPendingIntent2;
    if (mPriority > 0) {
      flags |= 0x80;
    }
    return localNotification;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplGingerbread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */