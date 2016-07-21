package com.linkedin.android.messaging.service;

import android.widget.Toast;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse;
import com.linkedin.messengerlib.MessengerLibApi.SendMessageResponse;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.event.PendingEvent;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.MessageSenderUtil;

final class ReplyIntentService$1
  implements MessengerLibApi.SendMessageResponse
{
  ReplyIntentService$1(ReplyIntentService paramReplyIntentService, PendingEvent paramPendingEvent) {}
  
  public final void onError(Exception paramException)
  {
    Log.e(ReplyIntentService.access$300(), "Error sending a reply");
    paramException = ReplyIntentService.access$200(this$0).getString(2131233482);
    Toast.makeText(this$0.getApplicationContext(), paramException, 0).show();
  }
  
  public final void onResponse(EventCreateResponse paramEventCreateResponse)
  {
    MessageSenderUtil.saveConversationToDb(val$pendingEvent, paramEventCreateResponse, ReplyIntentService.access$000(this$0).getMiniProfile(), null, access$100this$0).conversationDataManager);
    paramEventCreateResponse = ReplyIntentService.access$200(this$0).getString(2131233483);
    Toast.makeText(this$0.getApplicationContext(), paramEventCreateResponse, 0).show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.service.ReplyIntentService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */