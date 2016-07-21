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

public final class AbookImportInvitationImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<AbookImportInvitationImpressionEvent>
{
  public String abookFetchTransactionId = null;
  private String abookImportTransactionId = null;
  private int count = 0;
  public boolean hasAbookFetchTransactionId = false;
  private boolean hasAbookImportTransactionId = false;
  private boolean hasCount = false;
  private boolean hasHeader = false;
  private boolean hasImpressionType = false;
  private boolean hasInvitationCounts = false;
  private boolean hasInvitationTrackingInfo = false;
  private boolean hasMobileHeader = false;
  public boolean hasNumberOfContactsPortedFromPhoneNumber = false;
  public boolean hasNumberOfExistingContacts = false;
  public boolean hasNumberOfNewContacts = false;
  private boolean hasRequestHeader = false;
  private boolean hasSuggestedConnections = false;
  private boolean hasSuggestedInvitations = false;
  private EventHeader header = null;
  private InvitationTarget impressionType = null;
  private InvitationCountPerChannel invitationCounts = null;
  private List<InvitationTrackingInfo> invitationTrackingInfo = null;
  private MobileHeader mobileHeader = null;
  public int numberOfContactsPortedFromPhoneNumber = 0;
  public int numberOfExistingContacts = 0;
  public int numberOfNewContacts = 0;
  private UserRequestHeader requestHeader = null;
  private List<String> suggestedConnections = null;
  private List<String> suggestedInvitations = null;
  
  private AbookImportInvitationImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AbookImportInvitationImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (suggestedConnections != null)
    {
      paramFlavor = suggestedConnections.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "suggestedConnections");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "header");
            }
            if (!hasImpressionType) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "impressionType");
            }
            if (!hasCount) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "count");
            }
            if (!hasNumberOfExistingContacts) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "numberOfExistingContacts");
            }
            if (!hasNumberOfNewContacts) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "numberOfNewContacts");
            }
            if (hasNumberOfContactsPortedFromPhoneNumber) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "numberOfContactsPortedFromPhoneNumber");
          }
        }
      }
    }
    if (suggestedInvitations != null)
    {
      paramFlavor = suggestedInvitations.iterator();
      while (paramFlavor.hasNext()) {
        if ((String)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "suggestedInvitations");
        }
      }
    }
    if (invitationTrackingInfo != null)
    {
      paramFlavor = invitationTrackingInfo.iterator();
      while (paramFlavor.hasNext()) {
        if ((InvitationTrackingInfo)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "invitationTrackingInfo");
        }
      }
    }
    return new AbookImportInvitationImpressionEvent(header, abookImportTransactionId, mobileHeader, impressionType, count, numberOfExistingContacts, numberOfNewContacts, numberOfContactsPortedFromPhoneNumber, suggestedConnections, suggestedInvitations, invitationTrackingInfo, requestHeader, invitationCounts, abookFetchTransactionId, hasHeader, hasAbookImportTransactionId, hasMobileHeader, hasImpressionType, hasCount, hasNumberOfExistingContacts, hasNumberOfNewContacts, hasNumberOfContactsPortedFromPhoneNumber, hasSuggestedConnections, hasSuggestedInvitations, hasInvitationTrackingInfo, hasRequestHeader, hasInvitationCounts, hasAbookFetchTransactionId);
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
  
  public final Builder setCount(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasCount = false;
      count = 0;
      return this;
    }
    hasCount = true;
    count = paramInteger.intValue();
    return this;
  }
  
  public final Builder setImpressionType(InvitationTarget paramInvitationTarget)
  {
    if (paramInvitationTarget == null)
    {
      hasImpressionType = false;
      impressionType = null;
      return this;
    }
    hasImpressionType = true;
    impressionType = paramInvitationTarget;
    return this;
  }
  
  public final Builder setInvitationCounts(InvitationCountPerChannel paramInvitationCountPerChannel)
  {
    if (paramInvitationCountPerChannel == null)
    {
      hasInvitationCounts = false;
      invitationCounts = null;
      return this;
    }
    hasInvitationCounts = true;
    invitationCounts = paramInvitationCountPerChannel;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */