package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.Iterator;
import java.util.List;

public final class ConversationsImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<ConversationsImpressionEvent>
{
  public List<TrackingObject> conversations = null;
  public boolean hasConversations = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private ConversationsImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ConversationsImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (conversations != null)
    {
      paramFlavor = conversations.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((TrackingObject)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationsImpressionEvent", "conversations");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationsImpressionEvent", "header");
            }
            if (hasRequestHeader) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationsImpressionEvent", "requestHeader");
          }
        }
      }
    }
    return new ConversationsImpressionEvent(header, requestHeader, mobileHeader, conversations, hasHeader, hasRequestHeader, hasMobileHeader, hasConversations);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.ConversationsImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */