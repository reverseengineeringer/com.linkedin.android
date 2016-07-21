package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.data.lite.UnionTemplate;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class AbookImportInvitationImpressionDiscardEvent
  implements RecordTemplate<AbookImportInvitationImpressionDiscardEvent>
{
  public static final AbookImportInvitationImpressionDiscardEventBuilder BUILDER = AbookImportInvitationImpressionDiscardEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final AbookImportInvitationDiscardReason abookImportInvitationDiscardReason;
  public final String abookImportTransactionId;
  public final boolean hasAbookImportInvitationDiscardReason;
  public final boolean hasAbookImportTransactionId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  AbookImportInvitationImpressionDiscardEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, AbookImportInvitationDiscardReason paramAbookImportInvitationDiscardReason, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    abookImportTransactionId = paramString;
    abookImportInvitationDiscardReason = paramAbookImportInvitationDiscardReason;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasAbookImportTransactionId = paramBoolean4;
    hasAbookImportInvitationDiscardReason = paramBoolean5;
    _cachedId = null;
  }
  
  private AbookImportInvitationImpressionDiscardEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label293;
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
          break label302;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label320;
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
          break label329;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label347;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      if (hasAbookImportTransactionId)
      {
        paramDataProcessor.startRecordField$505cff1c("abookImportTransactionId");
        paramDataProcessor.processString(abookImportTransactionId);
      }
      localObject1 = null;
      bool4 = false;
      if (hasAbookImportInvitationDiscardReason)
      {
        paramDataProcessor.startRecordField$505cff1c("abookImportInvitationDiscardReason");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label357;
        }
        localObject1 = abookImportInvitationDiscardReason.accept(paramDataProcessor);
        label223:
        if (localObject1 == null) {
          break label375;
        }
      }
    }
    label293:
    label302:
    label320:
    label329:
    label347:
    label357:
    label375:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label468;
      }
      try
      {
        if (hasHeader) {
          break label381;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (AbookImportInvitationDiscardReason)paramDataProcessor.processDataTemplate(abookImportInvitationDiscardReason);
      break label223;
    }
    label381:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent", "requestHeader");
    }
    if (!hasAbookImportTransactionId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent", "abookImportTransactionId");
    }
    if (!hasAbookImportInvitationDiscardReason) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent", "abookImportInvitationDiscardReason");
    }
    return new AbookImportInvitationImpressionDiscardEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, abookImportTransactionId, (AbookImportInvitationDiscardReason)localObject1, bool1, bool2, bool3, hasAbookImportTransactionId, bool4);
    label468:
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
      paramObject = (AbookImportInvitationImpressionDiscardEvent)paramObject;
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
      if (abookImportTransactionId != null)
      {
        if (abookImportTransactionId.equals(abookImportTransactionId)) {}
      }
      else {
        while (abookImportTransactionId != null) {
          return false;
        }
      }
      if (abookImportInvitationDiscardReason == null) {
        break;
      }
    } while (abookImportInvitationDiscardReason.equals(abookImportInvitationDiscardReason));
    for (;;)
    {
      return false;
      if (abookImportInvitationDiscardReason == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label132;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label137;
      }
      k = mobileHeader.hashCode();
      label60:
      if (abookImportTransactionId == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = abookImportTransactionId.hashCode();; m = 0)
    {
      if (abookImportInvitationDiscardReason != null) {
        n = abookImportInvitationDiscardReason.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class AbookImportInvitationDiscardReason
    implements UnionTemplate<AbookImportInvitationDiscardReason>
  {
    public static final AbookImportInvitationImpressionDiscardEventBuilder.AbookImportInvitationDiscardReasonBuilder BUILDER = AbookImportInvitationImpressionDiscardEventBuilder.AbookImportInvitationDiscardReasonBuilder.INSTANCE;
    private volatile int _cachedHashCode = -1;
    private final String _cachedId;
    public final AbookImportInvitationDiscardReason abookImportInvitationDiscardReasonValue;
    public final boolean hasAbookImportInvitationDiscardReasonValue;
    
    public AbookImportInvitationDiscardReason(AbookImportInvitationDiscardReason paramAbookImportInvitationDiscardReason, boolean paramBoolean)
    {
      abookImportInvitationDiscardReasonValue = paramAbookImportInvitationDiscardReason;
      hasAbookImportInvitationDiscardReasonValue = paramBoolean;
      _cachedId = null;
    }
    
    public final AbookImportInvitationDiscardReason accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      if (hasAbookImportInvitationDiscardReasonValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.avro2pegasus.events.abook.AbookImportInvitationDiscardReason");
        paramDataProcessor.processEnum(abookImportInvitationDiscardReasonValue);
      }
      paramDataProcessor.endUnion();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        return new AbookImportInvitationDiscardReason(abookImportInvitationDiscardReasonValue, hasAbookImportInvitationDiscardReasonValue);
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
        paramObject = (AbookImportInvitationDiscardReason)paramObject;
        if (abookImportInvitationDiscardReasonValue == null) {
          break;
        }
      } while (abookImportInvitationDiscardReasonValue.equals(abookImportInvitationDiscardReasonValue));
      for (;;)
      {
        return false;
        if (abookImportInvitationDiscardReasonValue == null) {
          break;
        }
      }
    }
    
    public final int hashCode()
    {
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (abookImportInvitationDiscardReasonValue != null) {}
      for (int i = abookImportInvitationDiscardReasonValue.hashCode();; i = 0)
      {
        i += 527;
        _cachedHashCode = i;
        return i;
      }
    }
    
    public final String id()
    {
      return _cachedId;
    }
    
    public static final class Builder
    {
      public AbookImportInvitationDiscardReason abookImportInvitationDiscardReasonValue = null;
      public boolean hasAbookImportInvitationDiscardReasonValue = false;
    }
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */