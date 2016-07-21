package com.linkedin.gen.avro2pegasus.events.invitations;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class InvitationClickEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<InvitationClickEvent>
{
  private FlowType flow = null;
  private boolean hasFlow = false;
  private boolean hasHeader = false;
  private boolean hasInvitationTrackingInfo = false;
  private boolean hasInvitationType = false;
  private boolean hasInviteeEmails = false;
  private boolean hasInviteeUrns = false;
  private boolean hasMobileHeader = false;
  private boolean hasProduct = false;
  private boolean hasRequestHeader = false;
  private boolean hasSubproduct = false;
  private boolean hasTransactionId = false;
  private EventHeader header = null;
  private List<InvitationTrackingInfo> invitationTrackingInfo = null;
  private InvitationTargetType invitationType = null;
  private List<String> inviteeEmails = null;
  private List<String> inviteeUrns = null;
  private MobileHeader mobileHeader = null;
  private String product = null;
  private UserRequestHeader requestHeader = null;
  private String subproduct = null;
  private String transactionId = null;
  
  private InvitationClickEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (InvitationClickEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (inviteeUrns != null)
    {
      paramFlavor = inviteeUrns.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "inviteeUrns");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "requestHeader");
            }
            if (!hasInvitationType) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "invitationType");
            }
            if (!hasProduct) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "product");
            }
            if (hasSubproduct) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "subproduct");
          }
        }
      }
    }
    if (inviteeEmails != null)
    {
      paramFlavor = inviteeEmails.iterator();
      while (paramFlavor.hasNext()) {
        if ((String)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "inviteeEmails");
        }
      }
    }
    if (invitationTrackingInfo != null)
    {
      paramFlavor = invitationTrackingInfo.iterator();
      while (paramFlavor.hasNext()) {
        if ((InvitationTrackingInfo)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "invitationTrackingInfo");
        }
      }
    }
    return new InvitationClickEvent(header, requestHeader, mobileHeader, invitationType, inviteeUrns, inviteeEmails, product, subproduct, invitationTrackingInfo, transactionId, flow, hasHeader, hasRequestHeader, hasMobileHeader, hasInvitationType, hasInviteeUrns, hasInviteeEmails, hasProduct, hasSubproduct, hasInvitationTrackingInfo, hasTransactionId, hasFlow);
  }
  
  public final Builder setFlow(FlowType paramFlowType)
  {
    if (paramFlowType == null)
    {
      hasFlow = false;
      flow = null;
      return this;
    }
    hasFlow = true;
    flow = paramFlowType;
    return this;
  }
  
  public final Builder setInvitationTrackingInfo(List<InvitationTrackingInfo> paramList)
  {
    hasInvitationTrackingInfo = true;
    invitationTrackingInfo = paramList;
    return this;
  }
  
  public final Builder setInvitationType(InvitationTargetType paramInvitationTargetType)
  {
    if (paramInvitationTargetType == null)
    {
      hasInvitationType = false;
      invitationType = null;
      return this;
    }
    hasInvitationType = true;
    invitationType = paramInvitationTargetType;
    return this;
  }
  
  public final Builder setProduct(String paramString)
  {
    hasProduct = true;
    product = paramString;
    return this;
  }
  
  public final Builder setSubproduct(String paramString)
  {
    if (paramString == null)
    {
      hasSubproduct = false;
      subproduct = null;
      return this;
    }
    hasSubproduct = true;
    subproduct = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */