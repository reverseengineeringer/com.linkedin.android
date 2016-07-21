package com.linkedin.messengerlib.consumers;

import android.content.Context;
import com.linkedin.messengerlib.utils.I18NManager;

public final class DataManager
{
  public final ActorDataManager actorDataManager;
  public final AttachmentDataManager attachmentDataManager;
  public final ConversationDataManager conversationDataManager;
  public final EventsDataManager eventsDataManager;
  final I18NManager i18NManager;
  public final ReadReceiptsDataManager readReceiptsDataManager;
  public final StickersDataManager stickersDataManager;
  public final TypingIndicatorsDataManager typingIndicatorsDataManager;
  
  public DataManager(Context paramContext, I18NManager paramI18NManager)
  {
    i18NManager = paramI18NManager;
    actorDataManager = new ActorDataManager(paramContext, this);
    attachmentDataManager = new AttachmentDataManager(paramContext, this);
    conversationDataManager = new ConversationDataManager(paramContext, this);
    eventsDataManager = new EventsDataManager(paramContext, this);
    stickersDataManager = new StickersDataManager(paramContext, this);
    readReceiptsDataManager = new ReadReceiptsDataManager(paramContext, this);
    typingIndicatorsDataManager = new TypingIndicatorsDataManager(paramContext, this);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.consumers.DataManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */