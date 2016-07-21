package com.linkedin.android.messaging.messagelist;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.consumers.ActorDataManager;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.shared.FragmentComponent;

final class MessageListActivity$3
  implements View.OnClickListener
{
  MessageListActivity$3(MessageListActivity paramMessageListActivity) {}
  
  public final void onClick(View paramView)
  {
    Tracker localTracker = this$0.tracker;
    int i;
    if (MessageListActivity.access$100(this$0))
    {
      paramView = "group_topcard";
      new ControlInteractionEvent(localTracker, paramView, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
      paramView = MessageListActivity.access$000(this$0);
      if (messageListFragment != null)
      {
        paramView = messageListFragment;
        i = fragmentComponent.dataManager.actorDataManager.getParticipantCountForConversation(conversationId);
        if (i != 1) {
          break label105;
        }
        paramView.getMessengerLibApi().openConversationDetails(conversationId, conversationRemoteId, false);
      }
    }
    label105:
    while (i <= 1)
    {
      return;
      paramView = "topcard";
      break;
    }
    paramView.getMessengerLibApi().openConversationDetails(conversationId, conversationRemoteId, true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.MessageListActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */