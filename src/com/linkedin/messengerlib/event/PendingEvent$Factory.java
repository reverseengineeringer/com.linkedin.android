package com.linkedin.messengerlib.event;

import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype;
import com.linkedin.messengerlib.inmail.InMailResponse;
import com.linkedin.messengerlib.sticker.LocalSticker;
import java.util.ArrayList;
import java.util.List;

public final class PendingEvent$Factory
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

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.event.PendingEvent.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */