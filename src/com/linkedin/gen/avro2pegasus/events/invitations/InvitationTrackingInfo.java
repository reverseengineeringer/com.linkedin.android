package com.linkedin.gen.avro2pegasus.events.invitations;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InvitationTrackingInfo
  implements RecordTemplate<InvitationTrackingInfo>
{
  public static final InvitationTrackingInfoBuilder BUILDER = InvitationTrackingInfoBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasInvitationTrackingId;
  public final boolean hasRecipientUrn;
  public final String invitationTrackingId;
  public final String recipientUrn;
  
  InvitationTrackingInfo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    invitationTrackingId = paramString1;
    recipientUrn = paramString2;
    hasInvitationTrackingId = paramBoolean1;
    hasRecipientUrn = paramBoolean2;
    _cachedId = null;
  }
  
  public final InvitationTrackingInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasInvitationTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("invitationTrackingId");
      BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(invitationTrackingId));
    }
    if (hasRecipientUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("recipientUrn");
      paramDataProcessor.processString(recipientUrn);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasInvitationTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo", "invitationTrackingId");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasRecipientUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo", "recipientUrn");
      }
      return new InvitationTrackingInfo(invitationTrackingId, recipientUrn, hasInvitationTrackingId, hasRecipientUrn);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (InvitationTrackingInfo)paramObject;
      if (invitationTrackingId != null)
      {
        if (invitationTrackingId.equals(invitationTrackingId)) {}
      }
      else {
        while (invitationTrackingId != null) {
          return false;
        }
      }
      if (recipientUrn == null) {
        break;
      }
    } while (recipientUrn.equals(recipientUrn));
    for (;;)
    {
      return false;
      if (recipientUrn == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (invitationTrackingId != null) {}
    for (int i = invitationTrackingId.hashCode();; i = 0)
    {
      if (recipientUrn != null) {
        j = recipientUrn.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */