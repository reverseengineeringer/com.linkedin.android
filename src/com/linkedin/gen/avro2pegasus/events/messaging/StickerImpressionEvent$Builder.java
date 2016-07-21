package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class StickerImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<StickerImpressionEvent>
{
  public TrackingObject conversation = null;
  public boolean hasConversation = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasSticker = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public StickerObject sticker = null;
  
  private StickerImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (StickerImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new StickerImpressionEvent(header, requestHeader, mobileHeader, conversation, sticker, hasHeader, hasRequestHeader, hasMobileHeader, hasConversation, hasSticker);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "requestHeader");
      }
      if (!hasConversation) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "conversation");
      }
    } while (hasSticker);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "sticker");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */