package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Conversation$Builder
  implements RecordTemplateBuilder<Conversation>
{
  private Urn entityUrn = null;
  public List<Event> events = null;
  private boolean hasEntityUrn = false;
  public boolean hasEvents = false;
  public boolean hasMuted = false;
  private boolean hasName = false;
  private boolean hasNotificationStatus = false;
  public boolean hasParticipants = false;
  private boolean hasPendingInvitation = false;
  public boolean hasRead = false;
  private boolean hasReceipts = false;
  private boolean hasTotalEventCount = false;
  private boolean hasUnreadCount = false;
  public boolean muted = false;
  private String name = null;
  private NotificationStatus notificationStatus = null;
  public List<MessagingProfile> participants = null;
  private Invitation pendingInvitation = null;
  public boolean read = false;
  private List<ParticipantReceipts> receipts = null;
  private int totalEventCount = 0;
  private int unreadCount = 0;
  
  private Conversation build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Conversation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (participants != null)
    {
      paramFlavor = participants.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((MessagingProfile)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "participants");
            if (!hasEvents) {
              events = Collections.emptyList();
            }
            if (!hasUnreadCount) {
              unreadCount = 0;
            }
            if (!hasReceipts) {
              receipts = Collections.emptyList();
            }
            if (!hasNotificationStatus) {
              notificationStatus = NotificationStatus.ACTIVE;
            }
            if (!hasEntityUrn) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "entityUrn");
            }
            if (!hasParticipants) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "participants");
            }
            if (hasRead) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "read");
          }
        }
      }
    }
    if (events != null)
    {
      paramFlavor = events.iterator();
      while (paramFlavor.hasNext()) {
        if ((Event)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "events");
        }
      }
    }
    if (receipts != null)
    {
      paramFlavor = receipts.iterator();
      while (paramFlavor.hasNext()) {
        if ((ParticipantReceipts)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "receipts");
        }
      }
    }
    return new Conversation(entityUrn, participants, events, read, muted, unreadCount, totalEventCount, name, pendingInvitation, receipts, notificationStatus, hasEntityUrn, hasParticipants, hasEvents, hasRead, hasMuted, hasUnreadCount, hasTotalEventCount, hasName, hasPendingInvitation, hasReceipts, hasNotificationStatus);
  }
  
  public final Conversation build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.Conversation.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */