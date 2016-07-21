package com.linkedin.android.l2m.notification;

import android.net.Uri;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.logger.Log;

public class NotificationIdUtils
{
  private static final String TAG = NotificationIdUtils.class.getSimpleName();
  
  public static int computeNotificationId(NotificationPayload paramNotificationPayload)
  {
    String str = notificationType;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return uniqueId.hashCode();
      if (!str.equals("NewMessage")) {
        break;
      }
      i = 0;
      break;
      str = getMessagingNotificationId(paramNotificationPayload);
    } while (str == null);
    return str.hashCode();
  }
  
  public static String getMessagingNotificationId(NotificationPayload paramNotificationPayload)
  {
    LinkingRoutes localLinkingRoutes = LinkingRoutes.getMatchingRoute(uri);
    if (LinkingRoutes.MESSAGING_CONVERSATION == localLinkingRoutes) {}
    try
    {
      paramNotificationPayload = (String)localLinkingRoutes.getMap(Uri.parse(uri)).get("threadId");
      if (paramNotificationPayload != null) {
        return paramNotificationPayload;
      }
    }
    catch (NullPointerException paramNotificationPayload)
    {
      Log.e(TAG, "Unable to parse for conversation remote ID", paramNotificationPayload);
      return null;
    }
    catch (IndexOutOfBoundsException paramNotificationPayload)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationIdUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */