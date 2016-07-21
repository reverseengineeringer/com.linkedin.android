package com.linkedin.android.pegasus.gen.voyager.growth.invitation;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormInvitation$Builder
  implements RecordTemplateBuilder<NormInvitation>
{
  private boolean hasInvitee = false;
  private boolean hasMessage = false;
  private boolean hasTrackingId = false;
  private boolean hasUploadTransactionId = false;
  private NormInvitation.Invitee invitee = null;
  private String message = null;
  private String trackingId = null;
  private String uploadTransactionId = null;
  
  public final NormInvitation build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormInvitation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NormInvitation(trackingId, invitee, message, uploadTransactionId, hasTrackingId, hasInvitee, hasMessage, hasUploadTransactionId);
      if (!hasTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation", "trackingId");
      }
    } while (hasInvitee);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation", "invitee");
  }
  
  public final Builder setInvitee(NormInvitation.Invitee paramInvitee)
  {
    if (paramInvitee == null)
    {
      hasInvitee = false;
      invitee = null;
      return this;
    }
    hasInvitee = true;
    invitee = paramInvitee;
    return this;
  }
  
  public final Builder setMessage(String paramString)
  {
    if (paramString == null)
    {
      hasMessage = false;
      message = null;
      return this;
    }
    hasMessage = true;
    message = paramString;
    return this;
  }
  
  public final Builder setTrackingId(String paramString)
  {
    if (paramString == null)
    {
      hasTrackingId = false;
      trackingId = null;
      return this;
    }
    hasTrackingId = true;
    trackingId = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */