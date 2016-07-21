package com.linkedin.gen.avro2pegasus.events.invitations;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InvitationTrackingInfo$Builder
  implements RecordTemplateBuilder<InvitationTrackingInfo>
{
  private boolean hasInvitationTrackingId = false;
  private boolean hasRecipientUrn = false;
  private String invitationTrackingId = null;
  private String recipientUrn = null;
  
  public final InvitationTrackingInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (InvitationTrackingInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new InvitationTrackingInfo(invitationTrackingId, recipientUrn, hasInvitationTrackingId, hasRecipientUrn);
      if (!hasInvitationTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo", "invitationTrackingId");
      }
    } while (hasRecipientUrn);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo", "recipientUrn");
  }
  
  public final Builder setInvitationTrackingId(String paramString)
  {
    if (paramString == null)
    {
      hasInvitationTrackingId = false;
      invitationTrackingId = null;
      return this;
    }
    hasInvitationTrackingId = true;
    invitationTrackingId = paramString;
    return this;
  }
  
  public final Builder setRecipientUrn(String paramString)
  {
    if (paramString == null)
    {
      hasRecipientUrn = false;
      recipientUrn = null;
      return this;
    }
    hasRecipientUrn = true;
    recipientUrn = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */