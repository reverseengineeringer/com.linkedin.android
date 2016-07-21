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

public final class AbookImportInvitationImpressionEvent
  implements RecordTemplate<AbookImportInvitationImpressionEvent>
{
  public static final AbookImportInvitationImpressionEventBuilder BUILDER = AbookImportInvitationImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String abookFetchTransactionId;
  public final String abookImportTransactionId;
  public final int count;
  public final boolean hasAbookFetchTransactionId;
  public final boolean hasAbookImportTransactionId;
  public final boolean hasCount;
  public final boolean hasHeader;
  public final boolean hasImpressionType;
  public final boolean hasInvitationCounts;
  public final boolean hasInvitationTrackingInfo;
  public final boolean hasMobileHeader;
  public final boolean hasNumberOfContactsPortedFromPhoneNumber;
  public final boolean hasNumberOfExistingContacts;
  public final boolean hasNumberOfNewContacts;
  public final boolean hasRequestHeader;
  public final boolean hasSuggestedConnections;
  public final boolean hasSuggestedInvitations;
  public final EventHeader header;
  public final InvitationTarget impressionType;
  public final InvitationCountPerChannel invitationCounts;
  public final List<InvitationTrackingInfo> invitationTrackingInfo;
  public final MobileHeader mobileHeader;
  public final int numberOfContactsPortedFromPhoneNumber;
  public final int numberOfExistingContacts;
  public final int numberOfNewContacts;
  public final UserRequestHeader requestHeader;
  public final List<String> suggestedConnections;
  public final List<String> suggestedInvitations;
  
  AbookImportInvitationImpressionEvent(EventHeader paramEventHeader, String paramString1, MobileHeader paramMobileHeader, InvitationTarget paramInvitationTarget, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<String> paramList1, List<String> paramList2, List<InvitationTrackingInfo> paramList, UserRequestHeader paramUserRequestHeader, InvitationCountPerChannel paramInvitationCountPerChannel, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14)
  {
    header = paramEventHeader;
    abookImportTransactionId = paramString1;
    mobileHeader = paramMobileHeader;
    impressionType = paramInvitationTarget;
    count = paramInt1;
    numberOfExistingContacts = paramInt2;
    numberOfNewContacts = paramInt3;
    numberOfContactsPortedFromPhoneNumber = paramInt4;
    if (paramList1 == null)
    {
      paramEventHeader = null;
      suggestedConnections = paramEventHeader;
      if (paramList2 != null) {
        break label207;
      }
      paramEventHeader = null;
      label73:
      suggestedInvitations = paramEventHeader;
      if (paramList != null) {
        break label216;
      }
    }
    label207:
    label216:
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      invitationTrackingInfo = paramEventHeader;
      requestHeader = paramUserRequestHeader;
      invitationCounts = paramInvitationCountPerChannel;
      abookFetchTransactionId = paramString2;
      hasHeader = paramBoolean1;
      hasAbookImportTransactionId = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasImpressionType = paramBoolean4;
      hasCount = paramBoolean5;
      hasNumberOfExistingContacts = paramBoolean6;
      hasNumberOfNewContacts = paramBoolean7;
      hasNumberOfContactsPortedFromPhoneNumber = paramBoolean8;
      hasSuggestedConnections = paramBoolean9;
      hasSuggestedInvitations = paramBoolean10;
      hasInvitationTrackingInfo = paramBoolean11;
      hasRequestHeader = paramBoolean12;
      hasInvitationCounts = paramBoolean13;
      hasAbookFetchTransactionId = paramBoolean14;
      _cachedId = null;
      return;
      paramEventHeader = Collections.unmodifiableList(paramList1);
      break;
      paramEventHeader = Collections.unmodifiableList(paramList2);
      break label73;
    }
  }
  
  private AbookImportInvitationImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label406;
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
          break label415;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label121:
        if (localObject1 == null) {
          break label433;
        }
        bool2 = true;
      }
    }
    boolean bool3;
    int i;
    Object localObject5;
    for (Object localObject3 = localObject1;; localObject3 = localObject1)
    {
      if (hasImpressionType)
      {
        paramDataProcessor.startRecordField$505cff1c("impressionType");
        paramDataProcessor.processEnum(impressionType);
      }
      if (hasCount)
      {
        paramDataProcessor.startRecordField$505cff1c("count");
        paramDataProcessor.processInt(count);
      }
      if (hasNumberOfExistingContacts)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfExistingContacts");
        paramDataProcessor.processInt(numberOfExistingContacts);
      }
      if (hasNumberOfNewContacts)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfNewContacts");
        paramDataProcessor.processInt(numberOfNewContacts);
      }
      if (hasNumberOfContactsPortedFromPhoneNumber)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfContactsPortedFromPhoneNumber");
        paramDataProcessor.processInt(numberOfContactsPortedFromPhoneNumber);
      }
      localObject4 = null;
      localObject1 = null;
      bool3 = false;
      if (!hasSuggestedConnections) {
        break label461;
      }
      paramDataProcessor.startRecordField$505cff1c("suggestedConnections");
      suggestedConnections.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = suggestedConnections.iterator();
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
      label406:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label415:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label121;
      label433:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {
      bool3 = true;
    }
    label461:
    boolean bool4;
    for (Object localObject4 = localObject1;; localObject4 = localObject1)
    {
      localObject5 = null;
      localObject1 = null;
      bool4 = false;
      if (!hasSuggestedInvitations) {
        break label619;
      }
      paramDataProcessor.startRecordField$505cff1c("suggestedInvitations");
      suggestedInvitations.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject5 = suggestedInvitations.iterator();
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
      bool3 = false;
    }
    paramDataProcessor.endArray();
    label619:
    boolean bool5;
    Object localObject7;
    if (localObject1 != null)
    {
      bool4 = true;
      localObject5 = localObject1;
      localObject6 = null;
      localObject1 = null;
      bool5 = false;
      if (!hasInvitationTrackingInfo) {
        break label807;
      }
      paramDataProcessor.startRecordField$505cff1c("invitationTrackingInfo");
      invitationTrackingInfo.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject7 = invitationTrackingInfo.iterator();
      label690:
      if (!((Iterator)localObject7).hasNext()) {
        break label789;
      }
      localObject6 = (InvitationTrackingInfo)((Iterator)localObject7).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label773;
      }
    }
    label773:
    for (Object localObject6 = ((InvitationTrackingInfo)localObject6).accept(paramDataProcessor);; localObject6 = (InvitationTrackingInfo)paramDataProcessor.processDataTemplate((DataTemplate)localObject6))
    {
      if ((localObject1 != null) && (localObject6 != null)) {
        ((List)localObject1).add(localObject6);
      }
      i += 1;
      break label690;
      bool4 = false;
      localObject5 = localObject1;
      break;
    }
    label789:
    paramDataProcessor.endArray();
    label807:
    boolean bool6;
    if (localObject1 != null)
    {
      bool5 = true;
      localObject6 = localObject1;
      localObject7 = null;
      bool6 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label987;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label847:
        if (localObject1 == null) {
          break label1005;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      label859:
      localObject1 = null;
      bool7 = false;
      if (hasInvitationCounts)
      {
        paramDataProcessor.startRecordField$505cff1c("invitationCounts");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1015;
        }
        localObject1 = invitationCounts.accept(paramDataProcessor);
        label899:
        if (localObject1 == null) {
          break label1033;
        }
      }
    }
    label987:
    label1005:
    label1015:
    label1033:
    for (boolean bool7 = true;; bool7 = false)
    {
      if (hasAbookFetchTransactionId)
      {
        paramDataProcessor.startRecordField$505cff1c("abookFetchTransactionId");
        paramDataProcessor.processString(abookFetchTransactionId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1383;
      }
      try
      {
        if (hasHeader) {
          break label1039;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool5 = false;
      localObject6 = localObject1;
      break;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label847;
      bool6 = false;
      localObject7 = localObject1;
      break label859;
      localObject1 = (InvitationCountPerChannel)paramDataProcessor.processDataTemplate(invitationCounts);
      break label899;
    }
    label1039:
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
    if (!hasNumberOfContactsPortedFromPhoneNumber) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "numberOfContactsPortedFromPhoneNumber");
    }
    if (suggestedConnections != null)
    {
      paramDataProcessor = suggestedConnections.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "suggestedConnections");
        }
      }
    }
    if (suggestedInvitations != null)
    {
      paramDataProcessor = suggestedInvitations.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "suggestedInvitations");
        }
      }
    }
    if (invitationTrackingInfo != null)
    {
      paramDataProcessor = invitationTrackingInfo.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((InvitationTrackingInfo)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent", "invitationTrackingInfo");
        }
      }
    }
    return new AbookImportInvitationImpressionEvent((EventHeader)localObject2, abookImportTransactionId, (MobileHeader)localObject3, impressionType, count, numberOfExistingContacts, numberOfNewContacts, numberOfContactsPortedFromPhoneNumber, (List)localObject4, (List)localObject5, (List)localObject6, (UserRequestHeader)localObject7, (InvitationCountPerChannel)localObject1, abookFetchTransactionId, bool1, hasAbookImportTransactionId, bool2, hasImpressionType, hasCount, hasNumberOfExistingContacts, hasNumberOfNewContacts, hasNumberOfContactsPortedFromPhoneNumber, bool3, bool4, bool5, bool6, bool7, hasAbookFetchTransactionId);
    label1383:
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
      paramObject = (AbookImportInvitationImpressionEvent)paramObject;
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
      if (impressionType != null)
      {
        if (impressionType.equals(impressionType)) {}
      }
      else {
        while (impressionType != null) {
          return false;
        }
      }
      if (count != count) {
        return false;
      }
      if (numberOfExistingContacts != numberOfExistingContacts) {
        return false;
      }
      if (numberOfNewContacts != numberOfNewContacts) {
        return false;
      }
      if (numberOfContactsPortedFromPhoneNumber != numberOfContactsPortedFromPhoneNumber) {
        return false;
      }
      if (suggestedConnections != null)
      {
        if (suggestedConnections.equals(suggestedConnections)) {}
      }
      else {
        while (suggestedConnections != null) {
          return false;
        }
      }
      if (suggestedInvitations != null)
      {
        if (suggestedInvitations.equals(suggestedInvitations)) {}
      }
      else {
        while (suggestedInvitations != null) {
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
    int i5 = 0;
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
    int i6;
    int i7;
    int i8;
    int i9;
    int n;
    label118:
    int i1;
    label136:
    int i2;
    label154:
    int i3;
    if (header != null)
    {
      i = header.hashCode();
      if (abookImportTransactionId == null) {
        break label296;
      }
      j = abookImportTransactionId.hashCode();
      if (mobileHeader == null) {
        break label301;
      }
      k = mobileHeader.hashCode();
      if (impressionType == null) {
        break label306;
      }
      m = impressionType.hashCode();
      i6 = count;
      i7 = numberOfExistingContacts;
      i8 = numberOfNewContacts;
      i9 = numberOfContactsPortedFromPhoneNumber;
      if (suggestedConnections == null) {
        break label312;
      }
      n = suggestedConnections.hashCode();
      if (suggestedInvitations == null) {
        break label318;
      }
      i1 = suggestedInvitations.hashCode();
      if (invitationTrackingInfo == null) {
        break label324;
      }
      i2 = invitationTrackingInfo.hashCode();
      if (requestHeader == null) {
        break label330;
      }
      i3 = requestHeader.hashCode();
      label170:
      if (invitationCounts == null) {
        break label336;
      }
    }
    label296:
    label301:
    label306:
    label312:
    label318:
    label324:
    label330:
    label336:
    for (int i4 = invitationCounts.hashCode();; i4 = 0)
    {
      if (abookFetchTransactionId != null) {
        i5 = abookFetchTransactionId.hashCode();
      }
      i = (i4 + (i3 + (i2 + (i1 + (n + (((((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31) * 31) * 31) * 31) * 31) * 31 + i5;
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
      break label118;
      i1 = 0;
      break label136;
      i2 = 0;
      break label154;
      i3 = 0;
      break label170;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */