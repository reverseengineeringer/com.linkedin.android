package com.linkedin.android.l2m.notification;

import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId.Builder;
import com.linkedin.gen.avro2pegasus.events.messages.MessageReceivedEvent.Builder;
import java.util.Collections;
import java.util.UUID;

final class NotificationListenerService$1
  implements Runnable
{
  NotificationListenerService$1(NotificationListenerService paramNotificationListenerService, NotificationPayload paramNotificationPayload) {}
  
  public final void run()
  {
    try
    {
      Object localObject = NotificationListenerService.access$000(val$payload);
      PageInstance localPageInstance = new PageInstance(NotificationListenerService.access$100(this$0), (String)localObject, UUID.randomUUID());
      new PageViewEvent(NotificationListenerService.access$100(this$0), (String)localObject, true, localPageInstance).send();
      localObject = NotificationListenerService.access$100(this$0);
      MessageReceivedEvent.Builder localBuilder = new MessageReceivedEvent.Builder();
      MessageId localMessageId = new MessageId.Builder().setFlockMessageUrn(val$payload.uniqueId).setDeliveryId(NotificationListenerService.access$200(this$0).getNotificationToken()).setExternalIds(Collections.emptyList()).build(RecordTemplate.Flavor.RECORD);
      hasMessageId = true;
      messageId = localMessageId;
      ((Tracker)localObject).send(localBuilder, localPageInstance);
      return;
    }
    catch (BuilderException localBuilderException)
    {
      Log.e(NotificationListenerService.access$300(), "Failed to send MessageReceivedEvent tracking for payload: " + val$payload.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationListenerService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */