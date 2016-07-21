package com.linkedin.gen.avro2pegasus.events.abook;

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
import com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class AbookImportInvitationCreateEvent
  implements RecordTemplate<AbookImportInvitationCreateEvent>
{
  public static final AbookImportInvitationCreateEventBuilder BUILDER = AbookImportInvitationCreateEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String abookFetchTransactionId;
  public final String abookImportTransactionId;
  public final boolean hasAbookFetchTransactionId;
  public final boolean hasAbookImportTransactionId;
  public final boolean hasHeader;
  public final boolean hasInvitationCounts;
  public final boolean hasInvitationReceiptEmails;
  public final boolean hasInvitationTrackingInfo;
  public final boolean hasInvitationType;
  public final boolean hasMobileHeader;
  public final boolean hasNumberOfInvitationsSent;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final InvitationCountPerChannel invitationCounts;
  public final List<String> invitationReceiptEmails;
  public final List<InvitationTrackingInfo> invitationTrackingInfo;
  public final InvitationSentTo invitationType;
  public final MobileHeader mobileHeader;
  public final int numberOfInvitationsSent;
  public final UserRequestHeader requestHeader;
  
  AbookImportInvitationCreateEvent(EventHeader paramEventHeader, String paramString1, MobileHeader paramMobileHeader, InvitationSentTo paramInvitationSentTo, int paramInt, List<String> paramList, List<InvitationTrackingInfo> paramList1, UserRequestHeader paramUserRequestHeader, InvitationCountPerChannel paramInvitationCountPerChannel, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    header = paramEventHeader;
    abookImportTransactionId = paramString1;
    mobileHeader = paramMobileHeader;
    invitationType = paramInvitationSentTo;
    numberOfInvitationsSent = paramInt;
    if (paramList == null)
    {
      paramEventHeader = null;
      invitationReceiptEmails = paramEventHeader;
      if (paramList1 != null) {
        break label153;
      }
    }
    label153:
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList1))
    {
      invitationTrackingInfo = paramEventHeader;
      requestHeader = paramUserRequestHeader;
      invitationCounts = paramInvitationCountPerChannel;
      abookFetchTransactionId = paramString2;
      hasHeader = paramBoolean1;
      hasAbookImportTransactionId = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasInvitationType = paramBoolean4;
      hasNumberOfInvitationsSent = paramBoolean5;
      hasInvitationReceiptEmails = paramBoolean6;
      hasInvitationTrackingInfo = paramBoolean7;
      hasRequestHeader = paramBoolean8;
      hasInvitationCounts = paramBoolean9;
      hasAbookFetchTransactionId = paramBoolean10;
      _cachedId = null;
      return;
      paramEventHeader = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  private AbookImportInvitationCreateEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    boolean bool2;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label331;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasAbookImportTransactionId)
      {
        paramDataProcessor.startRecordField$505cff1c("abookImportTransactionId");
        paramDataProcessor.processString(abookImportTransactionId);
      }
      localObject3 = null;
      bool2 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label340;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label121:
        if (localObject1 == null) {
          break label358;
        }
        bool2 = true;
      }
    }
    Object localObject4;
    boolean bool3;
    int i;
    for (Object localObject3 = localObject1;; localObject3 = localObject1)
    {
      if (hasInvitationType)
      {
        paramDataProcessor.startRecordField$505cff1c("invitationType");
        paramDataProcessor.processEnum(invitationType);
      }
      if (hasNumberOfInvitationsSent)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfInvitationsSent");
        paramDataProcessor.processInt(numberOfInvitationsSent);
      }
      localObject4 = null;
      localObject1 = null;
      bool3 = false;
      if (!hasInvitationReceiptEmails) {
        break label386;
      }
      paramDataProcessor.startRecordField$505cff1c("invitationReceiptEmails");
      invitationReceiptEmails.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = invitationReceiptEmails.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject5);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject5);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label331:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label340:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label121;
      label358:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    label386:
    boolean bool4;
    Object localObject6;
    if (localObject1 != null)
    {
      bool3 = true;
      localObject4 = localObject1;
      localObject5 = null;
      localObject1 = null;
      bool4 = false;
      if (!hasInvitationTrackingInfo) {
        break label574;
      }
      paramDataProcessor.startRecordField$505cff1c("invitationTrackingInfo");
      invitationTrackingInfo.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject6 = invitationTrackingInfo.iterator();
      label457:
      if (!((Iterator)localObject6).hasNext()) {
        break label556;
      }
      localObject5 = (InvitationTrackingInfo)((Iterator)localObject6).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label540;
      }
    }
    label540:
    for (Object localObject5 = ((InvitationTrackingInfo)localObject5).accept(paramDataProcessor);; localObject5 = (InvitationTrackingInfo)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject1 != null) && (localObject5 != null)) {
        ((List)localObject1).add(localObject5);
      }
      i += 1;
      break label457;
      bool3 = false;
      localObject4 = localObject1;
      break;
    }
    label556:
    paramDataProcessor.endArray();
    label574:
    boolean bool5;
    if (localObject1 != null)
    {
      bool4 = true;
      localObject5 = localObject1;
      localObject6 = null;
      bool5 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label753;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label614:
        if (localObject1 == null) {
          break label771;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      label626:
      localObject1 = null;
      bool6 = false;
      if (hasInvitationCounts)
      {
        paramDataProcessor.startRecordField$505cff1c("invitationCounts");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label781;
        }
        localObject1 = invitationCounts.accept(paramDataProcessor);
        label666:
        if (localObject1 == null) {
          break label799;
        }
      }
    }
    label753:
    label771:
    label781:
    label799:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (hasAbookFetchTransactionId)
      {
        paramDataProcessor.startRecordField$505cff1c("abookFetchTransactionId");
        paramDataProcessor.processString(abookFetchTransactionId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1025;
      }
      try
      {
        if (hasHeader) {
          break label805;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool4 = false;
      localObject5 = localObject1;
      break;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label614;
      bool5 = false;
      localObject6 = localObject1;
      break label626;
      localObject1 = (InvitationCountPerChannel)paramDataProcessor.processDataTemplate(invitationCounts);
      break label666;
    }
    label805:
    if (!hasInvitationType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "invitationType");
    }
    if (!hasNumberOfInvitationsSent) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "numberOfInvitationsSent");
    }
    if (!hasInvitationReceiptEmails) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "invitationReceiptEmails");
    }
    if (invitationReceiptEmails != null)
    {
      paramDataProcessor = invitationReceiptEmails.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "invitationReceiptEmails");
        }
      }
    }
    if (invitationTrackingInfo != null)
    {
      paramDataProcessor = invitationTrackingInfo.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((InvitationTrackingInfo)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent", "invitationTrackingInfo");
        }
      }
    }
    return new AbookImportInvitationCreateEvent((EventHeader)localObject2, abookImportTransactionId, (MobileHeader)localObject3, invitationType, numberOfInvitationsSent, (List)localObject4, (List)localObject5, (UserRequestHeader)localObject6, (InvitationCountPerChannel)localObject1, abookFetchTransactionId, bool1, hasAbookImportTransactionId, bool2, hasInvitationType, hasNumberOfInvitationsSent, bool3, bool4, bool5, bool6, hasAbookFetchTransactionId);
    label1025:
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
      paramObject = (AbookImportInvitationCreateEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (abookImportTransactionId != null)
      {
        if (abookImportTransactionId.equals(abookImportTransactionId)) {}
      }
      else {
        while (abookImportTransactionId != null) {
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
      if (numberOfInvitationsSent != numberOfInvitationsSent) {
        return false;
      }
      if (invitationReceiptEmails != null)
      {
        if (invitationReceiptEmails.equals(invitationReceiptEmails)) {}
      }
      else {
        while (invitationReceiptEmails != null) {
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
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (invitationCounts != null)
      {
        if (invitationCounts.equals(invitationCounts)) {}
      }
      else {
        while (invitationCounts != null) {
          return false;
        }
      }
      if (abookFetchTransactionId == null) {
        break;
      }
    } while (abookFetchTransactionId.equals(abookFetchTransactionId));
    for (;;)
    {
      return false;
      if (abookFetchTransactionId == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
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
    int i5;
    int n;
    label100:
    int i1;
    label118:
    int i2;
    if (header != null)
    {
      i = header.hashCode();
      if (abookImportTransactionId == null) {
        break label236;
      }
      j = abookImportTransactionId.hashCode();
      if (mobileHeader == null) {
        break label241;
      }
      k = mobileHeader.hashCode();
      if (invitationType == null) {
        break label246;
      }
      m = invitationType.hashCode();
      i5 = numberOfInvitationsSent;
      if (invitationReceiptEmails == null) {
        break label252;
      }
      n = invitationReceiptEmails.hashCode();
      if (invitationTrackingInfo == null) {
        break label258;
      }
      i1 = invitationTrackingInfo.hashCode();
      if (requestHeader == null) {
        break label264;
      }
      i2 = requestHeader.hashCode();
      label134:
      if (invitationCounts == null) {
        break label270;
      }
    }
    label236:
    label241:
    label246:
    label252:
    label258:
    label264:
    label270:
    for (int i3 = invitationCounts.hashCode();; i3 = 0)
    {
      if (abookFetchTransactionId != null) {
        i4 = abookFetchTransactionId.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i5) * 31) * 31) * 31) * 31) * 31 + i4;
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
      break label100;
      i1 = 0;
      break label118;
      i2 = 0;
      break label134;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */