package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.widget.RemoteViews;

final class NotificationCompat$NotificationCompatImplHoneycomb
  extends NotificationCompat.NotificationCompatImplBase
{
  public final Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
  {
    Object localObject2 = mContext;
    Notification localNotification = mNotification;
    Object localObject1 = mContentTitle;
    CharSequence localCharSequence1 = mContentText;
    CharSequence localCharSequence2 = mContentInfo;
    RemoteViews localRemoteViews = mTickerView;
    int i = mNumber;
    PendingIntent localPendingIntent2 = mContentIntent;
    PendingIntent localPendingIntent1 = mFullScreenIntent;
    paramBuilder = mLargeIcon;
    localObject2 = new Notification.Builder((Context)localObject2).setWhen(when).setSmallIcon(icon, iconLevel).setContent(contentView).setTicker(tickerText, localRemoteViews).setSound(sound, audioStreamType).setVibrate(vibrate).setLights(ledARGB, ledOnMS, ledOffMS);
    if ((flags & 0x2) != 0)
    {
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
      if ((flags & 0x8) == 0) {
        break label284;
      }
      bool = true;
      label180:
      localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
      if ((flags & 0x10) == 0) {
        break label289;
      }
      bool = true;
      label201:
      localObject1 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(defaults).setContentTitle((CharSequence)localObject1).setContentText(localCharSequence1).setContentInfo(localCharSequence2).setContentIntent(localPendingIntent2).setDeleteIntent(deleteIntent);
      if ((flags & 0x80) == 0) {
        break label294;
      }
    }
    label284:
    label289:
    label294:
    for (boolean bool = true;; bool = false)
    {
      return ((Notification.Builder)localObject1).setFullScreenIntent(localPendingIntent1, bool).setLargeIcon(paramBuilder).setNumber(i).getNotification();
      bool = false;
      break;
      bool = false;
      break label180;
      bool = false;
      break label201;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplHoneycomb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */