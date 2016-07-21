package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class AbookImportInvitationImpressionDiscardEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<AbookImportInvitationImpressionDiscardEvent>
{
  public AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason abookImportInvitationDiscardReason = null;
  public String abookImportTransactionId = null;
  public boolean hasAbookImportInvitationDiscardReason = false;
  public boolean hasAbookImportTransactionId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private AbookImportInvitationImpressionDiscardEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AbookImportInvitationImpressionDiscardEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new AbookImportInvitationImpressionDiscardEvent(header, requestHeader, mobileHeader, abookImportTransactionId, abookImportInvitationDiscardReason, hasHeader, hasRequestHeader, hasMobileHeader, hasAbookImportTransactionId, hasAbookImportInvitationDiscardReason);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent", "requestHeader");
      }
      if (!hasAbookImportTransactionId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent", "abookImportTransactionId");
      }
    } while (hasAbookImportInvitationDiscardReason);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent", "abookImportInvitationDiscardReason");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */