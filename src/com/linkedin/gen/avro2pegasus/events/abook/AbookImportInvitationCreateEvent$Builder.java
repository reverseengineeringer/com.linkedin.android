package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo;
import java.util.Iterator;
import java.util.List;

public final class AbookImportInvitationCreateEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<AbookImportInvitationCreateEvent>
{
  public String abookFetchTransactionId = null;
  private String abookImportTransactionId = null;
  public boolean hasAbookFetchTransactionId = false;
  private boolean hasAbookImportTransactionId = false;
  private boolean hasHeader = false;
  public boolean hasInvitationCounts = false;
  public boolean hasInvitationReceiptEmails = false;
  private boolean hasInvitationTrackingInfo = false;
  public boolean hasInvitationType = false;
  private boolean hasMobileHeader = false;
  public boolean hasNumberOfInvitationsSent = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public InvitationCountPerChannel invitationCounts = null;
  public List<String> invitationReceiptEmails = null;
  private List<InvitationTrackingInfo> invitationTrackingInfo = null;
  public InvitationSentTo invitationType = null;
  private MobileHeader mobileHeader = null;
  public int numberOfInvitationsSent = 0;
  private UserRequestHeader requestHeader = null;
  
  private AbookImportInvitationCreateEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AbookImportInvitationCreateEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (invitationReceiptEmails != null)
    {
      paramFlavor = invitationReceiptEmails.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "invitationReceiptEmails");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "header");
            }
            if (!hasInvitationType) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "invitationType");
            }
            if (!hasNumberOfInvitationsSent) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "numberOfInvitationsSent");
            }
            if (hasInvitationReceiptEmails) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "invitationReceiptEmails");
          }
        }
      }
    }
    if (invitationTrackingInfo != null)
    {
      paramFlavor = invitationTrackingInfo.iterator();
      while (paramFlavor.hasNext()) {
        if ((InvitationTrackingInfo)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "invitationTrackingInfo");
        }
      }
    }
    return new AbookImportInvitationCreateEvent(header, abookImportTransactionId, mobileHeader, invitationType, numberOfInvitationsSent, invitationReceiptEmails, invitationTrackingInfo, requestHeader, invitationCounts, abookFetchTransactionId, hasHeader, hasAbookImportTransactionId, hasMobileHeader, hasInvitationType, hasNumberOfInvitationsSent, hasInvitationReceiptEmails, hasInvitationTrackingInfo, hasRequestHeader, hasInvitationCounts, hasAbookFetchTransactionId);
  }
  
  public final Builder setAbookImportTransactionId(String paramString)
  {
    if (paramString == null)
    {
      hasAbookImportTransactionId = false;
      abookImportTransactionId = null;
      return this;
    }
    hasAbookImportTransactionId = true;
    abookImportTransactionId = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */