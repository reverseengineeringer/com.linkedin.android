package com.linkedin.android.messaging.integration;

import android.content.Context;
import android.util.Log;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.realtime.DataEventHandler;
import com.linkedin.android.l2m.badge.Badger;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.messaging.Event;
import com.linkedin.android.pegasus.gen.voyager.messaging.ParticipantReceipts;
import com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeEvent;
import com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeSeenReceipt;
import com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeTypingIndicator;
import com.linkedin.android.realtime.impls.UnexpectedModelException;
import com.linkedin.android.realtime.interfaces.MessageDataInterface;
import com.linkedin.messengerlib.consumers.ConversationDataManager;
import com.linkedin.messengerlib.consumers.ConversationDataManager.1;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.consumers.EventsDataManager;
import com.linkedin.messengerlib.consumers.ReadReceiptsDataManager;
import com.linkedin.messengerlib.consumers.TypingIndicatorsDataManager;
import com.linkedin.messengerlib.database.DatabaseExecutor;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.UrnUtil;
import javax.inject.Inject;

public class MessagingDataEventHandler
  extends DataEventHandler
{
  private static final String TAG = MessagingDataEventHandler.class.getName();
  private final Badger badger;
  private final DataManager dataManager;
  private final LixManager lixManager;
  
  @Inject
  public MessagingDataEventHandler(Context paramContext, Badger paramBadger, LixManager paramLixManager)
  {
    dataManager = new DataManager(paramContext, new I18NManager(paramContext));
    badger = paramBadger;
    lixManager = paramLixManager;
  }
  
  public final void onMessage(MessageDataInterface paramMessageDataInterface)
  {
    int i = 0;
    if (!"enabled".equalsIgnoreCase(lixManager.getTreatment(Lix.INFRA_REALTIME_PROCESS_ALL_EVENTS))) {
      return;
    }
    String str;
    try
    {
      str = getTopicentityType;
      switch (str.hashCode())
      {
      case -670577853: 
        paramMessageDataInterface = (RealtimeEvent)paramMessageDataInterface.getModel();
        str = UrnUtil.getConversationRemoteIdFromEventUrn(event.entityUrn);
        ConversationDataManager localConversationDataManager = dataManager.conversationDataManager;
        i = conversationUnreadCount;
        DatabaseExecutor.getInstance().execute(new ConversationDataManager.1(localConversationDataManager, str, i));
        dataManager.eventsDataManager.saveAndNotifyEventAsync(event);
        paramMessageDataInterface = participantReceipts;
        if ((paramMessageDataInterface != null) && (seenReceipt != null)) {
          dataManager.readReceiptsDataManager.saveReadReceiptForConversationAsync(seenReceipt, fromParticipant, true);
        }
        badger.doFetchData(HomeTabInfo.TABS_V2, false);
        return;
      }
    }
    catch (UnexpectedModelException paramMessageDataInterface)
    {
      Log.e(TAG, "Topic and Model mismatch " + paramMessageDataInterface.getStackTrace());
      return;
    }
    if (str.equals("messagesTopic"))
    {
      break label314;
      if (str.equals("messageSeenReceiptsTopic"))
      {
        i = 1;
        break label314;
        if (str.equals("typingIndicatorsTopic"))
        {
          i = 2;
          break label314;
          paramMessageDataInterface = (RealtimeSeenReceipt)paramMessageDataInterface.getModel();
          dataManager.readReceiptsDataManager.saveReadReceiptForConversationAsync(seenReceipt, fromParticipant, true);
          return;
          paramMessageDataInterface = (RealtimeTypingIndicator)paramMessageDataInterface.getModel();
          dataManager.typingIndicatorsDataManager.notifyTypingIndicatorForConversation(conversation, fromParticipant);
          return;
        }
      }
    }
    i = -1;
    label314:
    switch (i)
    {
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.integration.MessagingDataEventHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */