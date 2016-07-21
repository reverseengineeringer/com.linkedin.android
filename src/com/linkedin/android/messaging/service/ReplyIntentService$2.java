package com.linkedin.android.messaging.service;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.gen.avro2pegasus.events.MessageType;
import com.linkedin.gen.avro2pegasus.events.messages.MessageActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import com.linkedin.gen.avro2pegasus.events.messages.actionType;

final class ReplyIntentService$2
  implements Runnable
{
  ReplyIntentService$2(ReplyIntentService paramReplyIntentService, MessageId paramMessageId, PageInstance paramPageInstance) {}
  
  public final void run()
  {
    ReplyIntentService.access$400(this$0).send(new MessageActionEvent.Builder().setActionType(actionType.TAP).setMessageType(MessageType.PUSHNOTIFICATION).setMessageId(val$messageId), val$pageInstance);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.service.ReplyIntentService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */