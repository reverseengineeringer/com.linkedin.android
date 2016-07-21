package com.linkedin.messengerlib.event;

import android.util.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate.Builder;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate.Value.Builder;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate.Builder;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate.CustomContent.Builder;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate.Builder;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailAction;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreate.Builder;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.messengerlib.inmail.InMailResponse;
import com.linkedin.messengerlib.sticker.LocalSticker;
import com.linkedin.messengerlib.utils.PendingRemoteId;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PendingEvent
{
  private static final String TAG = PendingEvent.class.getCanonicalName();
  public long conversationId = -1L;
  public String conversationRemoteId = null;
  public EventCreateType eventCreateType;
  public long eventId = -1L;
  public EventSubtype eventSubtype = null;
  private InMailResponse inMailResponse = null;
  public List<File> messageAttachments = null;
  public String messageBody = null;
  public String messageSubject;
  public String newConversationName = null;
  public String pendingRemoteId = PendingRemoteId.newId();
  public LocalSticker sticker;
  
  private StickerCreate newStickerCreate()
    throws BuilderException
  {
    StickerCreate.Builder localBuilder = new StickerCreate.Builder();
    try
    {
      localBuilder.setStickerUrn(Urn.createFromString(sticker.remoteId));
      return localBuilder.build(RecordTemplate.Flavor.RECORD);
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        Log.e(TAG, "Unable to create sticker urn");
      }
    }
  }
  
  public final boolean isSaved()
  {
    return eventId != -1L;
  }
  
  public final EventCreate newEventCreate()
    throws BuilderException, IOException
  {
    EventCreate.Builder localBuilder = new EventCreate.Builder();
    EventCreate.Value.Builder localBuilder1 = new EventCreate.Value.Builder();
    switch (PendingEvent.1.$SwitchMap$com$linkedin$messengerlib$event$EventCreateType[eventCreateType.ordinal()])
    {
    }
    for (;;)
    {
      localBuilder.setValue(localBuilder1.build());
      return localBuilder.build(RecordTemplate.Flavor.RECORD);
      MessageCreate.Builder localBuilder2 = new MessageCreate.Builder().setBody(messageBody);
      localBuilder2.setAttachments(messageAttachments);
      Object localObject1;
      Object localObject2;
      if ((eventSubtype == EventSubtype.INMAIL_REPLY) && (inMailResponse != null))
      {
        localObject1 = inMailResponse.action;
        localObject2 = new InmailContentCreate.Builder();
        if (localObject1 != null) {
          break label202;
        }
        hasAction = false;
      }
      for (action = null;; action = ((InmailAction)localObject1))
      {
        localObject1 = ((InmailContentCreate.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
        localObject2 = new MessageCreate.CustomContent.Builder();
        hasInmailContentCreateValue = true;
        inmailContentCreateValue = ((InmailContentCreate)localObject1);
        localBuilder2.setCustomContent(((MessageCreate.CustomContent.Builder)localObject2).build());
        localBuilder1.setMessageCreateValue(localBuilder2.build(RecordTemplate.Flavor.RECORD));
        break;
        label202:
        hasAction = true;
      }
      localBuilder1.setStickerCreateValue(newStickerCreate());
    }
  }
  
  public final void setMessageAttachment(File paramFile)
  {
    if (paramFile == null)
    {
      messageAttachments = null;
      return;
    }
    messageAttachments = new ArrayList();
    messageAttachments.add(paramFile);
  }
  
  public static final class Factory
  {
    public static PendingEvent newMessageEvent(String paramString1, File paramFile, long paramLong, String paramString2, EventSubtype paramEventSubtype, InMailResponse paramInMailResponse)
    {
      ArrayList localArrayList = null;
      if (paramFile != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramFile);
      }
      paramString1 = newMessageEvent(null, paramString1, localArrayList);
      PendingEvent.access$502(paramString1, paramLong);
      PendingEvent.access$602(paramString1, paramString2);
      PendingEvent.access$702(paramString1, paramEventSubtype);
      PendingEvent.access$802(paramString1, paramInMailResponse);
      return paramString1;
    }
    
    public static PendingEvent newMessageEvent(String paramString1, String paramString2, List<File> paramList)
    {
      PendingEvent localPendingEvent = new PendingEvent((byte)0);
      PendingEvent.access$102(localPendingEvent, paramString1);
      PendingEvent.access$202(localPendingEvent, EventCreateType.MESSAGE);
      PendingEvent.access$302(localPendingEvent, paramString2);
      PendingEvent.access$402(localPendingEvent, paramList);
      return localPendingEvent;
    }
    
    public static PendingEvent newStickerEvent(LocalSticker paramLocalSticker, long paramLong, String paramString, EventSubtype paramEventSubtype)
    {
      paramLocalSticker = newStickerEvent(null, paramLocalSticker);
      PendingEvent.access$502(paramLocalSticker, paramLong);
      PendingEvent.access$602(paramLocalSticker, paramString);
      PendingEvent.access$702(paramLocalSticker, paramEventSubtype);
      return paramLocalSticker;
    }
    
    public static PendingEvent newStickerEvent(String paramString, LocalSticker paramLocalSticker)
    {
      PendingEvent localPendingEvent = new PendingEvent((byte)0);
      PendingEvent.access$102(localPendingEvent, paramString);
      PendingEvent.access$202(localPendingEvent, EventCreateType.STICKER);
      PendingEvent.access$1002(localPendingEvent, paramLocalSticker);
      return localPendingEvent;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.event.PendingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */