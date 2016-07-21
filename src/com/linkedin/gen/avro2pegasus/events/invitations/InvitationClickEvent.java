package com.linkedin.gen.avro2pegasus.events.invitations;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class InvitationClickEvent
  implements RecordTemplate<InvitationClickEvent>
{
  public static final InvitationClickEventBuilder BUILDER = InvitationClickEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final FlowType flow;
  public final boolean hasFlow;
  public final boolean hasHeader;
  public final boolean hasInvitationTrackingInfo;
  public final boolean hasInvitationType;
  public final boolean hasInviteeEmails;
  public final boolean hasInviteeUrns;
  public final boolean hasMobileHeader;
  public final boolean hasProduct;
  public final boolean hasRequestHeader;
  public final boolean hasSubproduct;
  public final boolean hasTransactionId;
  public final EventHeader header;
  public final List<InvitationTrackingInfo> invitationTrackingInfo;
  public final InvitationTargetType invitationType;
  public final List<String> inviteeEmails;
  public final List<String> inviteeUrns;
  public final MobileHeader mobileHeader;
  public final String product;
  public final UserRequestHeader requestHeader;
  public final String subproduct;
  public final String transactionId;
  
  InvitationClickEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, InvitationTargetType paramInvitationTargetType, List<String> paramList1, List<String> paramList2, String paramString1, String paramString2, List<InvitationTrackingInfo> paramList, String paramString3, FlowType paramFlowType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    invitationType = paramInvitationTargetType;
    if (paramList1 == null)
    {
      paramEventHeader = null;
      inviteeUrns = paramEventHeader;
      if (paramList2 != null) {
        break label171;
      }
      paramEventHeader = null;
      label49:
      inviteeEmails = paramEventHeader;
      product = paramString1;
      subproduct = paramString2;
      if (paramList != null) {
        break label180;
      }
    }
    label171:
    label180:
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      invitationTrackingInfo = paramEventHeader;
      transactionId = paramString3;
      flow = paramFlowType;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasInvitationType = paramBoolean4;
      hasInviteeUrns = paramBoolean5;
      hasInviteeEmails = paramBoolean6;
      hasProduct = paramBoolean7;
      hasSubproduct = paramBoolean8;
      hasInvitationTrackingInfo = paramBoolean9;
      hasTransactionId = paramBoolean10;
      hasFlow = paramBoolean11;
      _cachedId = null;
      return;
      paramEventHeader = Collections.unmodifiableList(paramList1);
      break;
      paramEventHeader = Collections.unmodifiableList(paramList2);
      break label49;
    }
  }
  
  private InvitationClickEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    boolean bool3;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label333;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label342;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label360;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label370;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label148:
        if (localObject1 == null) {
          break label388;
        }
        bool3 = true;
      }
    }
    boolean bool4;
    int i;
    Object localObject6;
    for (Object localObject4 = localObject1;; localObject4 = localObject1)
    {
      if (hasInvitationType)
      {
        paramDataProcessor.startRecordField$505cff1c("invitationType");
        paramDataProcessor.processEnum(invitationType);
      }
      localObject5 = null;
      localObject1 = null;
      bool4 = false;
      if (!hasInviteeUrns) {
        break label416;
      }
      paramDataProcessor.startRecordField$505cff1c("inviteeUrns");
      inviteeUrns.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject5 = inviteeUrns.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject6);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject6);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label333:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label342:
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      label360:
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      label370:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      label388:
      bool3 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {
      bool4 = true;
    }
    label416:
    boolean bool5;
    for (Object localObject5 = localObject1;; localObject5 = localObject1)
    {
      localObject6 = null;
      localObject1 = null;
      bool5 = false;
      if (!hasInviteeEmails) {
        break label574;
      }
      paramDataProcessor.startRecordField$505cff1c("inviteeEmails");
      inviteeEmails.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject6 = inviteeEmails.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (String)((Iterator)localObject6).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject7);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject7);
        }
        i += 1;
      }
      bool4 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool5 = true;
      localObject6 = localObject1;
      label574:
      if (hasProduct)
      {
        paramDataProcessor.startRecordField$505cff1c("product");
        paramDataProcessor.processString(product);
      }
      if (hasSubproduct)
      {
        paramDataProcessor.startRecordField$505cff1c("subproduct");
        paramDataProcessor.processString(subproduct);
      }
      localObject1 = null;
      localObject7 = null;
      bool6 = false;
      if (!hasInvitationTrackingInfo) {
        break label812;
      }
      paramDataProcessor.startRecordField$505cff1c("invitationTrackingInfo");
      invitationTrackingInfo.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject7;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = invitationTrackingInfo.iterator();
      label699:
      if (!localIterator.hasNext()) {
        break label798;
      }
      localObject7 = (InvitationTrackingInfo)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label782;
      }
    }
    label782:
    for (Object localObject7 = ((InvitationTrackingInfo)localObject7).accept(paramDataProcessor);; localObject7 = (InvitationTrackingInfo)paramDataProcessor.processDataTemplate((DataTemplate)localObject7))
    {
      if ((localObject1 != null) && (localObject7 != null)) {
        ((List)localObject1).add(localObject7);
      }
      i += 1;
      break label699;
      bool5 = false;
      localObject6 = localObject1;
      break;
    }
    label798:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool6 = true;; bool6 = false)
    {
      label812:
      if (hasTransactionId)
      {
        paramDataProcessor.startRecordField$505cff1c("transactionId");
        paramDataProcessor.processString(transactionId);
      }
      if (hasFlow)
      {
        paramDataProcessor.startRecordField$505cff1c("flow");
        paramDataProcessor.processEnum(flow);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1209;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
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
    if (!hasSubproduct) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "subproduct");
    }
    if (inviteeUrns != null)
    {
      paramDataProcessor = inviteeUrns.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "inviteeUrns");
        }
      }
    }
    if (inviteeEmails != null)
    {
      paramDataProcessor = inviteeEmails.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "inviteeEmails");
        }
      }
    }
    if (invitationTrackingInfo != null)
    {
      paramDataProcessor = invitationTrackingInfo.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((InvitationTrackingInfo)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent", "invitationTrackingInfo");
        }
      }
    }
    return new InvitationClickEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, invitationType, (List)localObject5, (List)localObject6, product, subproduct, (List)localObject1, transactionId, flow, bool1, bool2, bool3, hasInvitationType, bool4, bool5, hasProduct, hasSubproduct, bool6, hasTransactionId, hasFlow);
    label1209:
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
      paramObject = (InvitationClickEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (invitationType != null)
      {
        if (invitationType.equals(invitationType)) {}
      }
      else {
        while (invitationType != null) {
          return false;
        }
      }
      if (inviteeUrns != null)
      {
        if (inviteeUrns.equals(inviteeUrns)) {}
      }
      else {
        while (inviteeUrns != null) {
          return false;
        }
      }
      if (inviteeEmails != null)
      {
        if (inviteeEmails.equals(inviteeEmails)) {}
      }
      else {
        while (inviteeEmails != null) {
          return false;
        }
      }
      if (product != null)
      {
        if (product.equals(product)) {}
      }
      else {
        while (product != null) {
          return false;
        }
      }
      if (subproduct != null)
      {
        if (subproduct.equals(subproduct)) {}
      }
      else {
        while (subproduct != null) {
          return false;
        }
      }
      if (invitationTrackingInfo != null)
      {
        if (invitationTrackingInfo.equals(invitationTrackingInfo)) {}
      }
      else {
        while (invitationTrackingInfo != null) {
          return false;
        }
      }
      if (transactionId != null)
      {
        if (transactionId.equals(transactionId)) {}
      }
      else {
        while (transactionId != null) {
          return false;
        }
      }
      if (flow == null) {
        break;
      }
    } while (flow.equals(flow));
    for (;;)
    {
      return false;
      if (flow == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i6 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label94:
    int i1;
    label112:
    int i2;
    label128:
    int i3;
    label144:
    int i4;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label270;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label275;
      }
      k = mobileHeader.hashCode();
      if (invitationType == null) {
        break label280;
      }
      m = invitationType.hashCode();
      if (inviteeUrns == null) {
        break label286;
      }
      n = inviteeUrns.hashCode();
      if (inviteeEmails == null) {
        break label292;
      }
      i1 = inviteeEmails.hashCode();
      if (product == null) {
        break label298;
      }
      i2 = product.hashCode();
      if (subproduct == null) {
        break label304;
      }
      i3 = subproduct.hashCode();
      if (invitationTrackingInfo == null) {
        break label310;
      }
      i4 = invitationTrackingInfo.hashCode();
      label162:
      if (transactionId == null) {
        break label316;
      }
    }
    label270:
    label275:
    label280:
    label286:
    label292:
    label298:
    label304:
    label310:
    label316:
    for (int i5 = transactionId.hashCode();; i5 = 0)
    {
      if (flow != null) {
        i6 = flow.hashCode();
      }
      i = (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label94;
      i1 = 0;
      break label112;
      i2 = 0;
      break label128;
      i3 = 0;
      break label144;
      i4 = 0;
      break label162;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */