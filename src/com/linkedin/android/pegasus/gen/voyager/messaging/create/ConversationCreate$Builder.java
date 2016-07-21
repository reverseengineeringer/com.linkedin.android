package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class ConversationCreate$Builder
  implements RecordTemplateBuilder<ConversationCreate>
{
  public EventCreate eventCreate = null;
  public boolean hasEventCreate = false;
  public boolean hasName = false;
  public boolean hasRecipients = false;
  public boolean hasSubject = false;
  public boolean hasSubtype = false;
  public String name = null;
  public List<String> recipients = null;
  public String subject = null;
  public EventSubtype subtype = null;
  
  private ConversationCreate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ConversationCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (recipients != null)
    {
      paramFlavor = recipients.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "recipients");
            if (!hasSubtype) {
              subtype = EventSubtype.MEMBER_TO_MEMBER;
            }
            if (!hasRecipients) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "recipients");
            }
            if (hasEventCreate) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate", "eventCreate");
          }
        }
      }
    }
    return new ConversationCreate(recipients, subject, eventCreate, subtype, name, hasRecipients, hasSubject, hasEventCreate, hasSubtype, hasName);
  }
  
  public final ConversationCreate build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */