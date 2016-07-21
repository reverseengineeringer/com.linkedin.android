package com.linkedin.android.l2m.notification;

import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import java.util.concurrent.BlockingQueue;

final class NotificationListenerService$2
  implements Runnable
{
  NotificationListenerService$2(MediaCenter paramMediaCenter, NotificationPayload paramNotificationPayload, String paramString, BlockingQueue paramBlockingQueue) {}
  
  public final void run()
  {
    val$mediaCenter.loadUrl(val$payload.actorPictureUrl, val$rumSessionId).into(new NotificationListenerService.2.1(this));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationListenerService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */